package com.fying.stu_school.controller;

import com.fying.stu_school.pojo.JsonResult;
import com.fying.stu_school.pojo.Student;
import com.fying.stu_school.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class StuController extends  BaseController{
   @Autowired
   private StuService stuService;
   @PostMapping("/register")
   public JsonResult<Void> register(Student student){
         stuService.register(student);
         JsonResult<Void> jr = new JsonResult<>();
          jr.setCode(BaseController.SUCCESS);
          return jr;
   }
   @PostMapping("/login")
   public JsonResult<Void> login(HttpSession session,String name, String password){
       JsonResult<Void> jr = new JsonResult<>();
       jr.setCode(BaseController.SUCCESS);
       int stuId = stuService.login(name, password);

       //存储id
       session.setAttribute("stuId","stuId");
       return jr;
   }
}
