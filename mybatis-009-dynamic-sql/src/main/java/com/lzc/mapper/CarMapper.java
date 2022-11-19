package com.lzc.mapper;

import com.lzc.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @title: CarMapper
 * @Author luozouchen
 * @Date: 2022/11/19 10:32
 */
public interface CarMapper {
    int updateById(Car car);

    int updateBySet(Car car);

    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    List<Car> selectWithChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("produceTime") String produceTime);

    int deleteByIds(@Param("ids") Long[] ids);

    int insertBatchByForeach(@Param("cars") List<Car> cars);

}
