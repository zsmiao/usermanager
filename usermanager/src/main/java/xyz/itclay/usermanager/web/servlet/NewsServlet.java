package xyz.itclay.usermanager.web.servlet;

import xyz.itclay.usermanager.domain.News;
import xyz.itclay.usermanager.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ZhangSenmiao
 * @date 2021/2/18 18:30
 **/
@WebServlet("/news/*")
public class NewsServlet extends BaseServlet {
    private final NewsService newsService = new NewsService();

    /**
     * 添加新闻
     *
     * @author ZhangSenmiao
     * @date 2021/2/18 18:34
     **/
    public void addNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    public void getNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<News> newsList = newsService.getNewsList(1, 2);
        req.setAttribute("newsList", newsList);

        req.getRequestDispatcher("/newList.jsp").forward(req, resp);
    }
}
