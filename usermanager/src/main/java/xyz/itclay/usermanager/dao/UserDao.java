package xyz.itclay.usermanager.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import xyz.itclay.usermanager.domain.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

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
     * 根据用户名查询用户
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

    /**
     * 用户名密码登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否登录成功
     */
    User pwdLogin(String username, String password);

    /**
     * 查询所有用户
     * @param user 用户信息
     * @return 用户集合
     */
    List<User> getUsers(User user);

    /**
     * 添加用户
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 20:12
     **/
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tb_user(name,username,password,sex,age,address,email,telephone,role) " +
            "values (#{name},#{username},#{password},#{sex},#{age},#{address},#{email},#{telephone},#{role})")
    void addUser(User user);

    /**
     * 修改用户信息
     *
     * @author ZhangSenmiao
     * @date 2021/2/22 9:26
     **/
    @Update("update tb_user\n" +
            "        set name=#{name},\n" +
            "            username=#{username},\n" +
            "            password=#{password},\n" +
            "            sex=#{sex},\n" +
            "            age=#{age},\n" +
            "            address=#{address},\n" +
            "            email=#{email},\n" +
            "            telephone=#{role}\n" +
            "        where id = #{id}")
    void updateUser(User user);

    /**
     * 根据用户Id删除用户数据
     *
     * @author ZhangSenmiao
     * @date 2021/2/22 9:51
     **/
    @Delete("delete\n" +
            "        from tb_user\n" +
            "        where id = #{id}")
    int deleteUserById(Integer id);
}
