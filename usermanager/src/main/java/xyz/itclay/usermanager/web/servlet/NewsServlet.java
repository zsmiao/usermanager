package xyz.itclay.usermanager.web.servlet;

import xyz.itclay.usermanager.domain.News;
import xyz.itclay.usermanager.domain.ResultInfo;
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
        String newsTitle = req.getParameter("newstitle");
        String newsType = req.getParameter("newstype");
        String newsContent = req.getParameter("newscontent");
        ResultInfo resultInfo = newsService.addNews(newsTitle, newsType, newsContent);
        if (resultInfo.getSuccess()) {
            req.setAttribute("message", resultInfo.getMessage());
            req.getRequestDispatcher("/addNew.jsp").forward(req, resp);
        }
    }


    public void deleteNewsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(req.getParameter("id"));
        ResultInfo resultInfo = newsService.deleteNewsById(newsId);
        if (resultInfo.getSuccess()) {
            req.setAttribute("message", resultInfo.getMessage());
            req.getRequestDispatcher("getNews").forward(req, resp);
        }
    }


    public void batchDeletion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] deleteIds = req.getParameterValues("deleteId");
        for (String deleteId : deleteIds) {
            Integer integer = Integer.valueOf(deleteId);
            newsService.deleteNewsById(integer);
        }
        req.getRequestDispatcher("getNews").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(req.getParameter("id"));
        News news = newsService.getNews(newsId);
        req.setAttribute("news",news);
        req.getRequestDispatcher("/newsUpdate.jsp").forward(req,resp);
    }


    public void updateNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(req.getParameter("id"));
        String newsTitle = req.getParameter("newstitle");
        String newsType = req.getParameter("newstype");
        String newsContent = req.getParameter("newscontent");
        ResultInfo resultInfo = newsService.updateNews(newsId,newsTitle,newsContent,newsType);
        if (resultInfo.getSuccess()) {
            req.setAttribute("message", resultInfo.getMessage());
            req.getRequestDispatcher("/newsUpdate.jsp").forward(req, resp);
        }
    }

    public void getNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo resultInfo=new ResultInfo();
        String title = req.getParameter("title");
        Integer pageNumber = 1;
        //控制分页效果
        String pageNumber1 = req.getParameter("pageNumber");
        if (pageNumber1 != null) {
            pageNumber = Integer.valueOf(pageNumber1);
        }
        if (pageNumber <= 1) {
            pageNumber = 1;
        }
        //新闻总条数
        int count = newsService.getCount();
        Integer pageSize = 5;

        int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        if (pageNumber > pageCount) {
            pageNumber = pageCount;
        }
        List<News> newsList = newsService.getNewsList(pageNumber, pageSize,title);
        if (!(title == null)){
            resultInfo.setSuccess(true);
            resultInfo.setMessage("共查询到了"+newsList.size()+"条记录!");
        }
        req.setAttribute("resultInfo",resultInfo);
        req.setAttribute("newsList", newsList);
        req.setAttribute("count",count);
        req.setAttribute("pageSize",pageSize);
        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("pageCount", pageCount);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

}
