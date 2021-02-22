package xyz.itclay.usermanager.web.servlet;

import xyz.itclay.usermanager.domain.CheckNews;
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

    /**
     * 删除单条新闻
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 19:07
     **/
    public void deleteNewsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(req.getParameter("id"));
        ResultInfo resultInfo = newsService.deleteNewsById(newsId);
        if (resultInfo.getSuccess()) {
            req.setAttribute("message", resultInfo.getMessage());
            req.getRequestDispatcher("getNews").forward(req, resp);
        }
    }

    /**
     * 批量删除新闻
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 19:06
     **/

    public void batchDeletion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] deleteIds = req.getParameterValues("deleteId");
        for (String deleteId : deleteIds) {
            Integer integer = Integer.valueOf(deleteId);
            newsService.deleteNewsById(integer);
        }
        req.getRequestDispatcher("getNews").forward(req, resp);
    }

    /**
     * 获取新闻数据的回显
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 19:06
     **/
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(req.getParameter("id"));
        News news = newsService.getNews(newsId);
        req.setAttribute("news", news);
        req.getRequestDispatcher("/newsUpdate.jsp").forward(req, resp);
    }

    /**
     * 更新新闻
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 19:05
     **/
    public void updateNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(req.getParameter("id"));
        String newsTitle = req.getParameter("newstitle");
        String newsType = req.getParameter("newstype");
        String newsContent = req.getParameter("newscontent");
        ResultInfo resultInfo = newsService.updateNews(newsId, newsTitle, newsContent, newsType);
        if (resultInfo.getSuccess()) {
            req.setAttribute("message", resultInfo.getMessage());
            req.getRequestDispatcher("/newsUpdate.jsp").forward(req, resp);
        }
    }

    /**
     * 查询所有新闻
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 19:05
     **/
    public void getNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo resultInfo = new ResultInfo();
        CheckNews checkNews = new CheckNews();
        Integer id = null;
        String title = req.getParameter("title");
        String id1 = req.getParameter("id");
        if (id1 != null && !(id1.equals(""))) {
            id = Integer.valueOf(id1);
        }
        String status = req.getParameter("status");
        status = "null".equals(status) ? null : status;
        String startTime = req.getParameter("startTime");
        String type = req.getParameter("type");
        String endTime = req.getParameter("endTime");


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

        checkNews.setNewsId(id);
        checkNews.setNewsTitle(title);
        checkNews.setNewsStatus(status);
        checkNews.setNewsType(type);
        checkNews.setStartTime(startTime);
        checkNews.setEndTime(endTime);
        checkNews.setPageNumber(pageNumber);
        checkNews.setPageSize(pageSize);
        List<News> newsList = newsService.getNewsList(checkNews);
        resultInfo.setMessage("共查询到了" + newsList.size() + "条记录!");
        req.setAttribute("resultInfo", resultInfo);
        req.setAttribute("newsList", newsList);
        req.setAttribute("count", count);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("pageCount", pageCount);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

}
