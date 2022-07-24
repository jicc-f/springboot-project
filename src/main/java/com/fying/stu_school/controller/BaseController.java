package com.fying.stu_school.controller;

import com.fying.stu_school.pojo.JsonResult;
import com.fying.stu_school.service.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    public static  final int SUCCESS = 200;
    //错误拦截器
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> jr = new JsonResult<>();
        jr.setCode(SUCCESS);
        if (e instanceof EmptyException) {
            jr.setCode(2000);
            jr.setMessage(e.getMessage());
        } else if (e instanceof InsertException) {
            jr.setCode(2001);
            jr.setMessage(e.getMessage());
        } else if (e instanceof UserNotFindException) {
            jr.setCode(3000);
            jr.setMessage(e.getMessage());

        } else if (e instanceof DuplicateNameException) {
            jr.setCode(3001);
            jr.setMessage(e.getMessage());
        } else if (e instanceof PasswordNotMatchException) {
            jr.setCode(3002);
            jr.setMessage(e.getMessage());
        }
        return jr;
    }


}
