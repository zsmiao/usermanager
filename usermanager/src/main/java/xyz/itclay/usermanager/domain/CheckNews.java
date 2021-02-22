package xyz.itclay.usermanager.domain;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author ZhangSenmiao
 * @date   2021/2/20 19:50
 **/
@Data
public class CheckNews implements Serializable {
    private Integer newsId;
    private String newsTitle;
    private String newsContent;
    private String newsStatus;
    private String newsType;
    private String startTime;
    private String endTime;

    private Integer pageNumber;
    private Integer pageSize;
    private Integer startSize;

    public CheckNews() {
    }

    public CheckNews(Integer newsId, String newsTitle, String newsContent, String newsStatus, String newsType, String startTime, String endTime) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsStatus = newsStatus;
        this.newsType = newsType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public CheckNews(Integer newsId, String newsTitle, String newsContent, String newsStatus, String newsType, String startTime, String endTime, Integer pageSize, Integer startSize) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsStatus = newsStatus;
        this.newsType = newsType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pageSize = pageSize;
        this.startSize = startSize;
    }

    public CheckNews(Integer newsId, String newsTitle, String newsContent, String newsStatus, String newsType, String startTime, String endTime, Integer pageNumber, Integer pageSize, Integer startSize) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsStatus = newsStatus;
        this.newsType = newsType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.startSize = startSize;
    }
}
