package com.lzc.exceptions;

/**
 * @title: MoneyNotEnoughException
 * @Author luozouchen
 * @Date: 2022/11/16 20:43
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
