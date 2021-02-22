package xyz.itclay.usermanager.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *  属性：id
 *      姓名
 *      用户名
 *      密码
 *      性别
 *      年龄
 *      地址
 *      邮件
 *      电话
 *
 * @author ZhangSenmiao
 * @date 2021/2/7 14:13
 **/
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private String address;
    private String email;
    private String telephone;
    private String role;
}
