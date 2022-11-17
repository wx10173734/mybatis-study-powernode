package com.lzc.mapper;

import com.lzc.pojo.Log;

import java.util.List;

/**
 * @title: LogMapper
 * @Author luozouchen
 * @Date: 2022/11/17 14:25
 */
public interface LogMapper {
    List<Log> selectAllByTable(String date);
}
