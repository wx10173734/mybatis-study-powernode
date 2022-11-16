package com.lzc.dao;

import com.lzc.pojo.Account;
import com.lzc.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @title: AccountDaoImpl
 * @Author luozouchen
 * @Date: 2022/11/16 20:36
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("account.selectByActno", actno);
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("account.updateByActno", act);
        return count;
    }
}
