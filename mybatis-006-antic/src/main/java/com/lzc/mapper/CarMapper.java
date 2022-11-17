package com.lzc.mapper; // 包名也有叫做：com.powernode.mybatis.dao
//mapper包就是dao包。


import com.lzc.pojo.Car;

import java.util.List;

// 一般使用mybatis的话，一般不叫做XXXDao了。一般都是XXXMapper。
public interface CarMapper { //CarDao。
    /**
     * 插入car信息，并且使用生成的主键值
     *
     *
     * @param car
     * @return
     */
    int insertCarUseGenerateKeys(Car car);

    List<Car> selectAllByAscOrDesc(String ascOrDesc);

    List<Car> selectByBrandLike(String brand);

    List<Car> selectByCarType(String carType);

    int deleteBatch(String ids);

}
