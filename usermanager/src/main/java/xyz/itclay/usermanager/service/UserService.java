package xyz.itclay.usermanager.service;

import com.github.pagehelper.PageHelper;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.apache.ibatis.session.SqlSession;
import xyz.itclay.usermanager.dao.UserDao;
import xyz.itclay.usermanager.domain.ResultInfo;
import xyz.itclay.usermanager.domain.User;
import xyz.itclay.usermanager.utils.Md5Utils;
import xyz.itclay.usermanager.utils.MyBatisUtils;
import xyz.itclay.usermanager.utils.SendSmsUtils;

import java.util.List;

/**
 * @author ZhangSenmiao
 * @date 2021/2/7 14:33
 **/
public class UserService {
    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 封装了注册结果的信息
     */
    public ResultInfo register(User user) {
//        创建接口代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        调用dao查询，验证用户名
        User username = userDao.findByUsername(user.getUsername());
//        如果username不是null，表示该用户已经是存在的了
        if (username != null) {
//            释放资源
            MyBatisUtils.close(sqlSession);
            return new ResultInfo(false, "用户名已存在！");
        }
        User telephone = userDao.findByTelephone(user.getTelephone());
        if (telephone != null) {
            MyBatisUtils.close(sqlSession);
            return new ResultInfo(false, "手机号已存在！");
        }
        String password = Md5Utils.encodeByMd5(user.getPassword());
        user.setPassword(password);
//        保存user对象，完成注册
        userDao.save(user);
        MyBatisUtils.close(sqlSession);
        return new ResultInfo(true);
    }

    /**
     * 验证用户名是否存在
     *
     * @param username 用户名
     * @return resultInfo
     */
    public ResultInfo findByUsername(String username) {
        //        创建接口代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用dao，查询username是否存在
        User byUsername = userDao.findByUsername(username);
        MyBatisUtils.close(sqlSession);
        if (byUsername != null) {
            return new ResultInfo(false, "此用户已存在!");
        } else {
            return new ResultInfo(true, "用户名可以使用!");
        }
    }

    /**
     * 验证手机号是否存在
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 20:09
     **/
    public ResultInfo findByTelePhone(String telephone) {
        //        创建接口代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用dao，查询username是否存在
        User byUsername = userDao.findByTelephone(telephone);
        MyBatisUtils.close(sqlSession);
        if (byUsername != null) {
            return new ResultInfo(false, "此手机号已注册!");
        } else {
            return new ResultInfo(true, "手机号未注册!");
        }
    }

    /**
     * 发送短信验证码
     *
     * @param telephone    手机号
     * @param randomNumber 验证码
     * @return resultInfo
     */
    public ResultInfo sendSms(String telephone, String randomNumber) {
        try {
            SendSmsUtils.sendTheVerificationCode(telephone, randomNumber);
            return new ResultInfo(true, "短信发送成功!");
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            return new ResultInfo(false, "短信发送失败!");
        }
    }

    /**
     * 密码登录
     *
     * @param username 用户名和密码
     * @return resultInfo
     */
    public ResultInfo pwdLogin(String username, String password) {
        //        创建接口代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User byUsername = userDao.findByUsername(username);
        MyBatisUtils.close(sqlSession);
        if (byUsername == null) {
            return new ResultInfo(false, "用户名不正确!");
        }
        if (!password.equals(byUsername.getPassword())) {
            return new ResultInfo(false, "密码错误!");
        }
        return new ResultInfo(true, "登录成功!", byUsername);

    }

    /**
     * 查询所有用户信息
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 9:44
     **/
    public List<User> getUsers(int pageNumber, int pageSize ,User user) {
        //        创建接口代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        PageHelper.startPage(pageNumber, pageSize);
        List<User> users = userDao.getUsers(user);
        MyBatisUtils.close(sqlSession);
        return users;
    }

    /**
     * 管理员添加用户
     *
     * @author ZhangSenmiao
     * @date 2021/2/21 20:10
     **/
    public ResultInfo addUser(User user) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.addUser(user);
        MyBatisUtils.close(sqlSession);
        return new ResultInfo(true, "添加成功!");
    }

    /**
     * 修改用户信息
     *
     * @author ZhangSenmiao
     * @date 2021/2/22 9:23
     **/
    public ResultInfo updateUser(User user) {
        UserDao userDao = MyBatisUtils.getMapper(UserDao.class);
        userDao.updateUser(user);
        return new ResultInfo(true, "修改用户信息成功!");
    }

    /**
     * 删除用户信息
     *
     * @author ZhangSenmiao
     * @date 2021/2/22 9:47
     **/
    public ResultInfo deleteUserById(Integer id) {
        UserDao userDao = MyBatisUtils.getMapper(UserDao.class);
        int row=userDao.deleteUserById(id);
        return new ResultInfo(true,"成功删除 "+row+"条记录!");
    }
}
