package com.fying.stu_school.mapper;

import com.fying.stu_school.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuMapper {

    //注册
    Student findByName(String name);

    Integer insertStudent(Student student);

    //登录
    Student findById(Integer id);


}
