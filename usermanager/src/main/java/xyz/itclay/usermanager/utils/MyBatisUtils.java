package xyz.itclay.usermanager.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 生产SQLSession的工具类
 *
 * @author ZhangSenmiao
 * @date 2021/2/7 13:49
 **/
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
//        加载核心配置文件
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取SQLSession工厂对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 释放资源
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
