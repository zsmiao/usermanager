package xyz.itclay.usermanager.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 新闻实体类
 *
 * @author ZhangSenmiao
 * @date 2021/2/18 18:27
 **/
@Data
public class News implements Serializable {
    private Integer newsId;
    private String newsTitle;
    private String newsContent;
    private String newsStatus;
    private String newsType;
    private String createTime;

}
