package com.lzc.mapper;

import com.lzc.pojo.Student;

import java.util.List;

/**
 * @title: StudentMapper
 * @Author luozouchen
 * @Date: 2022/11/21 10:41
 */
public interface StudentMapper {
    /**
     * 根据id获取学生的信息。 同时获取学生关联的班级信息
     *
     * @param id 学生的id
     * @return 学生对象， 但是学生对象中含有班级对象
     */
    Student selectById(Integer id);

    Student selectByAssociation(Integer id);


    /**
     * 分布查询第一步，现根据学生的id查询学生的信息
     *
     * @param id
     * @return
     */
    Student selectByStep1(Integer id);

    List<Student> selectByStep2(Integer cid);
}
