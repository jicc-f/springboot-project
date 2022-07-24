package com.fying.stu_school.service;

import com.fying.stu_school.pojo.Student;

public interface StuService {

   void register(Student student);

   int login(String name, String password);
}
