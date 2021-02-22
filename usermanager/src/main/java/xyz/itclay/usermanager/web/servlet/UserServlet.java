package xyz.itclay.usermanager.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import xyz.itclay.usermanager.domain.ResultInfo;
import xyz.itclay.usermanager.domain.User;
import xyz.itclay.usermanager.service.UserService;
import xyz.itclay.usermanager.utils.RandomCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author ZhangSenmiao
 * @date 2021/2/7 14:10
 **/
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserService();

    /**
     * 注册方法
     *
     * @author ZhangSenmiao
     * @date 2021/2/7 14:11
     **/
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        比较用户填写的验证码和发送手机的验证码做对比
        String randomNumber = (String) req.getSession().getAttribute("randomNumber");
        String smsCode = req.getParameter("smsCode");
        if (smsCode == null || !smsCode.equals(randomNumber)) {
            req.setAttribute("msg", "验证码错误!");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        try {
//    接收请求参数
            Map<String, String[]> map = req.getParameterMap();
//    封装User实体，调用Service完成注册
            User user = new User();
            BeanUtils.populate(user, map);
            ResultInfo resultInfo = userService.register(user);
//            判断结果
            if (resultInfo.getSuccess()) {
//                重定向到注册成功页面
                resp.sendRedirect(req.getContextPath() + "/register_ok.jsp");
            } else {
//                将注册信息放到域中，转发到注册页面
                req.setAttribute("resultInfo", resultInfo);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证用户名
     *
     * @author ZhangSenmiao
     * @date 2021/2/7 16:23
     **/
    public void findByUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求参数
        String username = req.getParameter("username");
        if (username != null & !Objects.equals(username, "")) {
//        调用service，校验用户名是否存在，返回resultInfo
            ResultInfo resultInfo = userService.findByUsername(username);
            //将resultInfo转为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(resultInfo);
            //响应给客户端
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
        }
    }

    /**
     * 验证手机号
     *
     * @author ZhangSenmiao
     * @date 2021/2/7 16:23
     **/
    public void findByTelephone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求参数
        String telephone = req.getParameter("telephone");
//        调用service，校验手机号是否存在，返回resultInfo
        ResultInfo resultInfo = userService.findByTelePhone(telephone);
        //将resultInfo转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        //响应给客户端
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);

    }

    /**
     * 发送短信验证码
     *
     * @author ZhangSenmiao
     * @date 2021/2/8 22:19
     **/
    public void sendSms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        接收请求参数
        String telephone = req.getParameter("telephone");
//        获取验证码
        String randomNumber = RandomCodeUtils.randomNumber(6);
//        调用service发送短信，得到resultInfo信息
        ResultInfo resultInfo = userService.sendSms(telephone, randomNumber);
//        将随机生成的验证码放到session域中
        if (resultInfo.getSuccess()) {
            req.getSession().setAttribute("randomNumber", randomNumber);
        }
        //将resultInfo转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        //响应给客户端
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    /**
     * 用户名密码登录
     *
     * @author ZhangSenmiao
     * @date 2021/2/10 10:58
     **/
    public void pwdLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Map<String, String[]> map = req.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, map);
            ResultInfo resultInfo = userService.pwdLogin(user.getUsername(), user.getPassword());

            if (resultInfo.getSuccess()) {
                Cookie cookieName = new Cookie("username", user.getUsername());
                Cookie cookiePwd = new Cookie("pwd", user.getPassword());
                //获取页面记住状态复选框的值
                String ck = req.getParameter("ck");
                if (ck != null) {
                    //设置存活时间
                    cookieName.setMaxAge(7 * 24 * 60 * 60);
                    cookiePwd.setMaxAge(7 * 24 * 60 * 60);
                } else {//不记住
                    //设置存活时间
                    cookieName.setMaxAge(0);
                    cookiePwd.setMaxAge(0);
                }
                //设置cookie存储路径:设置在根路径，将来页面获取就不需要考虑存储的路径
                cookieName.setPath("/");
                cookiePwd.setPath("/");
                resp.addCookie(cookieName);
                resp.addCookie(cookiePwd);
//                重定向到注册成功页面
                resp.sendRedirect("/news/getNews");
//                req.getRequestDispatcher("news/getNews").forward(req,resp);
                req.getSession().setAttribute("user", resultInfo.getData());
            } else {
//                将注册信息放到域中，转发到注册页面
                req.setAttribute("resultInfo", resultInfo);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户退出登录
     *
     * @author ZhangSenmiao
     * @date 2021/2/10 20:16
     **/
    public void quit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        清除session缓存
        req.getSession().removeAttribute("user");
//        将页面重定向到登录登录页面
        resp.sendRedirect("/login.jsp");
    }

    /**
     * 查询所有用户信息
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 9:40
     **/
    public void getUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用service查询用户信息
        int pageNumber = 1;
        //控制分页效果
        String pageNumber1 = req.getParameter("pageNumber");
        if (pageNumber1 != null) {
            pageNumber = Integer.parseInt(pageNumber1);
        }
        if (pageNumber <= 1) {
            pageNumber = 1;
        }
        int pageSize = 10;
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String status = req.getParameter("status");
        User user=new User();
        user.setName(name);
        user.setUsername(username);
        List<User> users = userService.getUsers(pageNumber, pageSize,user);
        PageInfo<User> userPageInfo = new PageInfo<User>(users);
        req.setAttribute("userPageInfo", userPageInfo);
        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }

    /**
     * 添加用户
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 19:04
     **/
    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Enumeration<String> parameterNames = req.getParameterNames();
        ArrayList<String> values = new ArrayList<String>();
        while (parameterNames.hasMoreElements()) {
//            得到名字
            String name = parameterNames.nextElement();
            String parameter = req.getParameter(name);
            values.add(parameter);
        }
        user.setUsername(values.get(0));
        user.setRole(values.get(1));
        user.setPassword(values.get(3));
        user.setName(values.get(4));
        user.setSex(values.get(5));
        user.setAge(Integer.valueOf(values.get(6)));
        user.setTelephone(values.get(7));
        user.setEmail(values.get(8));
        user.setAddress(values.get(9));
        ResultInfo resultInfo = userService.addUser(user);
        if (resultInfo.getSuccess()) {
            req.setAttribute("resultInfo", resultInfo);
            req.getRequestDispatcher("/addUser.jsp").forward(req, resp);
        }
    }

    /**
     * 修改用户信息
     *
     * @author ZhangSenmiao
     * @date 2021/2/22 9:13
     **/
    public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        ArrayList<String> list = new ArrayList<>();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String parameter = req.getParameter(name);
            list.add(parameter);
        }
        user.setId(Integer.valueOf(list.get(0)));
        user.setUsername(list.get(1));
        user.setRole(list.get(2));
        user.setPassword(list.get(4));
        user.setName(list.get(5));
        user.setSex(list.get(6));
        user.setAge(Integer.valueOf(list.get(7)));
        user.setTelephone(list.get(8));
        user.setEmail(list.get(9));
        user.setAddress(list.get(10));
        ResultInfo resultInfo = userService.updateUser(user);
        if (resultInfo.getSuccess()) {
            req.setAttribute("resultInfo", resultInfo);
            req.getRequestDispatcher("/addUser.jsp").forward(req, resp);
        }
    }

    /**
     * 删除用户信息
     *
     * @author ZhangSenmiao
     * @date 2021/2/22 9:40
     **/
    public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ResultInfo resultInfo = userService.deleteUserById(Integer.valueOf(id));
        if (resultInfo.getSuccess()) {
            req.setAttribute("resultInfo", resultInfo);
//            resp.sendRedirect("/user/getUsers");
            req.getRequestDispatcher("getUsers").forward(req,resp);
        }
    }


}
