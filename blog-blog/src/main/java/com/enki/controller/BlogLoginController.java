package com.enki.controller;

import com.enki.domain.ResponseResult;
import com.enki.domain.User;
import com.enki.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Enki
 * @ClassName BlogLoginController
 * @Description: TODO
 * @Date 2023/9/20 17:20
 * @Version 1.0
 */
@RestController
public class BlogLoginController {

    @Autowired
    //BlogLoginService是我们在service目录写的接口
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    //ResponseResult是我们在framework工程里面写的实体类
    public ResponseResult login(@RequestBody User user) {
        return blogLoginService.login(user);
    }
}
