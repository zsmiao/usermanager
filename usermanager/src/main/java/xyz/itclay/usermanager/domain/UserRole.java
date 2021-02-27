package xyz.itclay.usermanager.domain;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author makejava
 * @since 2021-02-23 18:57:18
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 552670089952022612L;
    /**
     * 主键id
     */
    private Integer id;

    private String role;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 新闻id
     */
    private Integer nid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

}
