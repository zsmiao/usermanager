package xyz.itclay.usermanager.dao;

import xyz.itclay.usermanager.domain.News;

import java.util.List;

/**
 * @author ZhangSenmiao
 * @date 2021/2/18 18:37
 **/
public interface NewsDao {

    /**
     * @param pageNumber 页数
     * @param pageSize   每页数量
     * @return 新闻集合
     */

    List<News> getNewList(Integer pageNumber, Integer pageSize);

}
