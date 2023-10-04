package com.enki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enki.domain.ResponseResult;
import com.enki.domain.User;

/**
 * @author Enki
 * @ClassName UserService
 * @Description: TODO
 * @Date 2023/10/3 15:28
 * @Version 1.0
 */
public interface UserService extends IService<User> {
    //个人信息查询
    ResponseResult userInfo();

    //用户注册功能
    ResponseResult register(User user);

    //更新个人信息
    ResponseResult updateUserInfo(User user);
}
