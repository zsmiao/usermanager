package xyz.itclay.usermanager.service;

import org.apache.ibatis.session.SqlSession;
import xyz.itclay.usermanager.dao.NewsDao;
import xyz.itclay.usermanager.dao.UserDao;
import xyz.itclay.usermanager.domain.News;
import xyz.itclay.usermanager.domain.User;
import xyz.itclay.usermanager.utils.MyBatisUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻service
 *
 * @author ZhangSenmiao
 * @date 2021/2/18 18:32
 **/
public class NewsService {
    public List<News> getNewsList(Integer pageNumber, Integer pageSize) {
        List<News> newsList = new ArrayList<>();
        News news = new News();
        SqlSession sqlSession = MyBatisUtils.openSession();
        NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
        //调用dao，查询username是否存在
        newsList = newsDao.getNewList(pageNumber, pageSize);
        MyBatisUtils.close(sqlSession);
        return newsList;
    }
}
