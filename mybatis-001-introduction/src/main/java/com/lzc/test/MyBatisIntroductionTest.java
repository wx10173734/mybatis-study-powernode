package com.lzc.test;

import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Luozouchen
 * @classname MyBatisIntroductionTest
 * @create 2022/11/13 0:55
 */
public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        //获取sqlsessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlsessionfactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insertCar = sqlSession.insert("insertCar");
        System.out.println(insertCar);

        //手动提交
        sqlSession.commit();
    }
}
