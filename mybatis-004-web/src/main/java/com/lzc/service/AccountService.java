package com.lzc.service;

import com.lzc.exceptions.MoneyNotEnoughException;
import com.lzc.exceptions.TransferException;

/**
 * 账户业务类
 * @title: AccountService
 * @Author luozouchen
 * @Date: 2022/11/16 20:28
 */
public interface AccountService {

    /**
     * 账户转账业务
     * @param fromActno 转出账号
     * @param toActno 转入账号
     * @param money 转账金额
     */
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}
