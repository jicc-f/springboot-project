package com.fying.stu_school.service;

import com.fying.stu_school.mapper.StuMapper;
import com.fying.stu_school.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StuServiceImplTest {

    @Autowired
    private StuService stuService;

    @Test
    void  register(){
        Student student = new Student();
        student.setName("测试1");
        student.setPassword("123456");
        stuService.register(student);
    }
}
