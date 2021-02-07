package xyz.itclay.usermanager.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author ZhangSenmiao
 * @date 2021/2/7 14:13
 **/
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String username;
    private String password;
    private char sex;
    private int age;
    private String address;
    private String email;
    private String telephone;
}
