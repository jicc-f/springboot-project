package com.fying.stu_school;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class StuSchoolApplicationTests {
  @Autowired
  private  DataSource dataSource;
    @Test
    void contextLoads() {
    }
    @Test
    void  Conntection(){
      System.out.println(dataSource.toString());
    }

}
