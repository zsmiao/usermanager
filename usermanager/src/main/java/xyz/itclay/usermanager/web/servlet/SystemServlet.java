package xyz.itclay.usermanager.web.servlet;

import xyz.itclay.usermanager.entity.*;
import xyz.itclay.usermanager.service.SystemHardwareServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ZhangSenmiao
 * @date   2021/2/26 18:00
 **/
@WebServlet("/system/*")
public class SystemServlet extends BaseServlet{

    public void systemInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        SystemHardwareServer server=new SystemHardwareServer();
        server.copyTo();
        Cpu cpu = server.getCpu();
        Sys sys = server.getSys();
        Jvm jvm = server.getJvm();
        Mem mem = server.getMem();
        String name = jvm.getName();
        String runTime = jvm.getRunTime();
        String startTime = jvm.getStartTime();
        List<SysFile> sysFiles = server.getSysFiles();

        req.setAttribute("cpu",cpu);
        req.setAttribute("sys",sys);
        req.setAttribute("jvm",jvm);
        req.setAttribute("mem",mem);
        req.setAttribute("sysFiles",sysFiles);
        req.setAttribute("name",name);
        req.setAttribute("runTime",runTime);
        req.setAttribute("startTime",startTime);

        req.getRequestDispatcher("/system.jsp").forward(req,resp);
    }
}
