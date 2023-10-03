package com.enki.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.enki.config.exception.SystemException;
import com.enki.config.handler.exception.GlobalExceptionHandler;
import com.enki.domain.ResponseResult;
import com.enki.domain.User;
import com.enki.enums.AppHttpCodeEnum;
import com.enki.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        if (StrUtil.isBlank(user.getUserName())) {
//            必须填写用户名称
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    /**
     * 登陆退出
     * @return
     */
    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}
