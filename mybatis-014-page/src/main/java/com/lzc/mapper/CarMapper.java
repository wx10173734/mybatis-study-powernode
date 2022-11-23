package com.lzc.mapper;

import com.lzc.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @title: CarMapper
 * @Author luozouchen
 * @Date: 2022/11/23 21:01
 */
public interface CarMapper {
    List<Car> selectByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    List<Car> selectAll();
}
