package com.lzc.mapper;

import com.lzc.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @title: CarMapper
 * @Author luozouchen
 * @Date: 2022/11/18 21:51
 */
public interface CarMapper {
    Car selectById(Long id);

    List<Car> selectAll();

    Car selectByBrandLike(String brand);

    Map<String, Object> selectByIdRetMap(Long id);

    List<Map<String, Object>> selectAllRetListMap();


    @MapKey("id")
        //将查询结果的id值作为整个大map集合的Key
    Map<Long, Map<String, Object>> selectAllRetMap();

    List<Car> selectAllByResultMap();

    List<Car> selectBymapUnderscoreToCamelCase();

    Long selectTotal();
}
