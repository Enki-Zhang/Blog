package com.enki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.enki.domain.User;
import com.enki.mapper.UserMapper;
import com.enki.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Enki
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Date 2023/10/3 15:28
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
