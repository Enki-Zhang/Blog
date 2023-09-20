package com.enki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enki.domain.Link;
import com.enki.domain.ResponseResult;

/**
 * @author Enki
 * @ClassName LinkService
 * @Description: TODO
 * @Date 2023/9/20 16:52
 * @Version 1.0
 */
public interface LinkService extends IService<Link> {
    ResponseResult getAllLink();
}
