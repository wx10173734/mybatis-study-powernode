package com.lzc.dao;

import com.lzc.pojo.Account;

/**
 * 账户的dao对象，负责t_act表中的数据的crud
 *
 * @title: AccountDao
 * @Author luozouchen
 * @Date: 2022/11/16 20:33
 */
public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act
     * @return
     */
    int updateByActno(Account act);
}
