package xyz.itclay.usermanager.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import xyz.itclay.usermanager.domain.ResultInfo;
import xyz.itclay.usermanager.domain.User;
import xyz.itclay.usermanager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
}
