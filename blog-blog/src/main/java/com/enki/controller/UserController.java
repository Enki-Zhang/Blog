package com.enki.controller;

import com.enki.domain.ResponseResult;
import com.enki.domain.User;
import com.enki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Enki
 * @ClassName UserController
 * @Description: 用户信息接口
 * @Date 2023/10/4 10:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    //UserService是我们在huanf-framework工程写的接口
    private UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        //查询个人信息
        return userService.userInfo();
    }

    @PutMapping("userInfo")
    public ResponseResult  updateUserInfo(@RequestBody User user){
        //更新个人信息
        return userService.updateUserInfo(user);
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        //注册功能
        return userService.register(user);
    }
}