package com.lzc.mapper;

import com.lzc.pojo.Clazz;

/**
 * @title: ClazzMapper
 * @Author luozouchen
 * @Date: 2022/11/21 10:41
 */
public interface ClazzMapper {
    /**
     * 分布查询第二部，根据id获取班级信息
     *
     * @param cid
     * @return
     */
    Clazz selectByIdStep2(Integer cid);

    Clazz selectByCollection(Integer cid);

    Clazz selectByStep1(Integer cid);

}
