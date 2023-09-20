package com.enki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enki.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author Enki
 * @ClassName UserMapper
 * @Description: TODO
 * @Date 2023/9/20 17:13
 * @Version 1.0
 */
@Service
public interface UserMapper extends BaseMapper<User> {
}