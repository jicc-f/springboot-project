package com.fying.stu_school.service.impl;

import com.fying.stu_school.mapper.StuMapper;
import com.fying.stu_school.pojo.Student;
import com.fying.stu_school.service.StuService;
import com.fying.stu_school.service.ex.*;
import com.fying.stu_school.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public void register(Student student) {

        //判断为空
        if (StringUtils.isEmpty(student.getName()) || StringUtils.isEmpty(student.getPassword())) {
            throw new EmptyException("用户名或者密码为空");
        }
        //开始查找
        String name = student.getName();
        Student byName = stuMapper.findByName(name);
        if (byName != null) {
            throw new DuplicateNameException("用户已注册");
        }

        //开始加密
        String password = student.getPassword();
        String salt = String.valueOf(UUID.randomUUID()).replace("-", "").toUpperCase();
        String md5pwd = EncryptUtil.getMd5three(salt, password);


        //插入用户名，密码，盐值，修改人及日期
        student.setPassword(md5pwd);
        student.setSalt(salt);
        student.setModifier(name);
        student.setmodificationTime(new Date());
        Integer i = stuMapper.insertStudent(student);

        if (i != 1) {
            throw new InsertException("注册失败");
        }
    }

    @Override
    public int login(String name, String password) {
        //判断为空
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            throw new EmptyException("用户名或者密码为空");
        }
        //查找结果
        Student byName = stuMapper.findByName(name);
        //判断用户是否存在
        if (byName == null) {
            throw new UserNotFindException("用户名不存在");
        }
        //比较密码,用户传过来的密码加密比较
        String salt = byName.getSalt();
        System.out.println(salt);
        System.out.println((EncryptUtil.getMd5three(salt, password)));
        if (!byName.getPassword().equals(EncryptUtil.getMd5three(salt, password))) {
            throw new PasswordNotMatchException("密码不正确，请重新输入");
        }
        //返回用户ID
        return byName.getId();
    }


}
