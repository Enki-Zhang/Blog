package com.enki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enki.domain.ResponseResult;
import com.enki.domain.User;

/**
 * @author Enki
 * @ClassName BlogLoginService
 * @Description: TODO
 * @Date 2023/9/20 17:13
 * @Version 1.0
 */
public interface BlogLoginService  {
    ResponseResult login(User user);

    ResponseResult logout();
}