package com.lzc.mapper;

import com.lzc.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @title: StudentMapper
 * @Author luozouchen
 * @Date: 2022/11/17 18:21
 */
public interface StudentMapper {
    /**
     * 当接口中的方法参数只有一一个（单个参数）并且参数的数据类型都是简单类型
     * 根据id查询，name查询，birth查询，sex查询
     */
    List<Student> selectById(Long id);

    List<Student> selectByName(String name);

    List<Student> selectByBirth(Date birth);

    List<Student> selectBySex(Character sex);

    int insertStudentByMap(Map<String, Object> map);


//    mybatis框架会自动创建一个Map 集合。并且Map集合是以这种方式存储参数的:
//            map.put("argO",name);
//            map.put("arg1，sex);
//            map.put("pafam1”name);
//            map.put("param2",sex);

    List<Student> selectByNameAndSex(String name, Character sex);

    /**
     * Param注解。
     * <p>
     * mybatis框架底层的实现原理:
     * <p>
     * mgp. put( "name",name) ;
     * map.put( "sex" ,sex) ;
     **/

    List<Student> selectByNameAndSex2(@Param("name") String name, @Param("sex") Character sex);


}
