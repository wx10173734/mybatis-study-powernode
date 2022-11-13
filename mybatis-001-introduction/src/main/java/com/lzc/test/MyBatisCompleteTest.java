package com.lzc.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


/**
 * 采用正规的方式，写一个完整的mybatis程序
 *
 * @author Luozouchen
 * @classname MyBatisCompleteTest
 * @create 2022/11/13 14:40
 */
public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
            //执行sql语句，处理相关的事务
            int insertCar = sqlSession.insert("insertCar");
            System.out.println(insertCar);
            //执行到这里，没有发生任何异常，提交事务，终止事务
            sqlSession.commit();
        } catch (IOException e) {
            //最好回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            //关闭会话
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
