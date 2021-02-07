package xyz.itclay.usermanager.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author ZhangSenmiao
 * @date 2021/2/7 14:04
 **/
public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取uri
        String uri = req.getRequestURI();
//        获取执行的方法名
        String substring = uri.substring(uri.lastIndexOf("/") + 1);
        try {
//        获取Method对象
            Method method = this.getClass().getDeclaredMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
//        暴力反射
            method.setAccessible(true);
//        执行req和resp的method方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
