package xyz.itclay.usermanager.service;

import org.apache.ibatis.session.SqlSession;
import xyz.itclay.usermanager.dao.NewsDao;
import xyz.itclay.usermanager.dao.UserDao;
import xyz.itclay.usermanager.domain.CheckNews;
import xyz.itclay.usermanager.domain.News;
import xyz.itclay.usermanager.domain.ResultInfo;
import xyz.itclay.usermanager.domain.User;
import xyz.itclay.usermanager.utils.MyBatisUtils;
import xyz.itclay.usermanager.utils.SystemTime;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻service
 *
 * @author ZhangSenmiao
 * @date 2021/2/18 18:32
 **/
public class NewsService {
    public List<News> getNewsList(CheckNews checkNews) {
        List<News> newsList = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtils.openSession();
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        Integer pageNumber = checkNews.getPageNumber();
        Integer pageSize = checkNews.getPageSize();
        int startSize = (pageNumber  - 1) * pageSize;
        checkNews.setStartSize(startSize);
        newsList = newsDao.getNewList(checkNews);
        MyBatisUtils.close(sqlSession);
        return newsList;
    }

    /**
     * 添加新闻
     *
     * @author ZhangSenmiao
     * @date 2021/2/19 12:44
     **/
    public ResultInfo addNews(String newsTitle, String newsType, String newsContent) {
        News news = new News();
        String nowSystemTime = SystemTime.nowSystemTime();
        SqlSession sqlSession = MyBatisUtils.openSession();
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        news.setNewsTitle(newsTitle);
        news.setNewsContent(newsContent);
        news.setNewsStatus("未审核");
        news.setNewsType(newsType);
        news.setCreateTime(nowSystemTime);
        newsDao.addNews(news);
        MyBatisUtils.close(sqlSession);
        return new ResultInfo(true, "保存成功!");
    }

    public ResultInfo deleteNewsById(Integer newsId) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        newsDao.deleteNewsById(newsId);
        MyBatisUtils.close(sqlSession);
        return new ResultInfo(true,"删除成功!");
    }

    public News getNews(Integer newsId) {
        News news = new News();
        SqlSession sqlSession = MyBatisUtils.openSession();
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        news = newsDao.getNews(newsId);
        return news;
    }

    public ResultInfo updateNews(Integer newsId, String newsTitle, String newsContent, String newsType) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        newsDao.updateNews(newsId, newsTitle, newsContent, newsType);
        MyBatisUtils.close(sqlSession);
        return new ResultInfo(true, "修改成功!");
    }

    public int getCount() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        int row = newsDao.getCount();
        MyBatisUtils.close(sqlSession);
        return row;
    }
}
