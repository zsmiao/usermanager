package xyz.itclay.usermanager.dao;

import org.apache.ibatis.annotations.Param;
import xyz.itclay.usermanager.domain.CheckNews;
import xyz.itclay.usermanager.domain.News;
import xyz.itclay.usermanager.domain.ResultInfo;

import java.util.List;

/**
 * @author ZhangSenmiao
 * @date 2021/2/18 18:37
 **/
public interface NewsDao {

    /**
     * @return 新闻集合
     */

    List<News> getNewList(CheckNews checkNews);

    void addNews(News news);

    void deleteNewsById(Integer newsId);

    News getNews(Integer newsId);

    void updateNews(@Param("id") Integer newsId, @Param("title") String newsTitle,@Param("content") String newsContent,@Param("type") String newsType);

    int getCount();
}
