package xyz.itclay.usermanager.service;

import org.apache.ibatis.session.SqlSession;
import xyz.itclay.usermanager.dao.UserDao;
import xyz.itclay.usermanager.domain.ResultInfo;
import xyz.itclay.usermanager.domain.User;
import xyz.itclay.usermanager.utils.MyBatisUtils;

/**
 * @author ZhangSenmiao
 * @date 2021/2/7 14:33
 **/
public class UserService {
    /**
     * 注册
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
//        保存user对象，完成注册
        userDao.save(user);
        MyBatisUtils.close(sqlSession);
        return new ResultInfo(true);
    }
}
