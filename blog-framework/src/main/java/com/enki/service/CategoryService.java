package com.enki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enki.domain.Category;
import com.enki.domain.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * @author Enki
 * @ClassName CategoryService
 * @Description: TODO
 * @Date 2023/9/20 15:23
 * @Version 1.0
 */
public interface CategoryService extends IService<Category> {
    ResponseResult getCategoryList();
}
