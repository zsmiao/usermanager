package xyz.itclay.usermanager.dao;

import xyz.itclay.usermanager.domain.User;

/**
 * @author ZhangSenmiao
 * @date 2021/2/7 14:24
 **/
public interface UserDao {
    /**
     * 添加用户
     *
     * @param user user对象
     */
    void save(User user);

    /**
     * 根绝用户名查询用户
     *
     * @param username 用户名
     * @return 是否存在
     */
    User findByUsername(String username);

    /**
     * 根据手机号查询用户
     *
     * @param telephone 手机号
     * @return 手机号是否存在
     */
    User findByTelephone(String telephone);
}
