package xyz.itclay.usermanager.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import xyz.itclay.usermanager.domain.ResultInfo;
import xyz.itclay.usermanager.domain.User;
import xyz.itclay.usermanager.service.UserService;
import xyz.itclay.usermanager.utils.RandomCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

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
        System.out.println(username);
        if (username != null) {
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
            System.out.println(user.getUsername() + user.getPassword());
            ResultInfo resultInfo = userService.pwdLogin(user.getUsername(), user.getPassword());

            if (resultInfo.getSuccess()) {
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
}
