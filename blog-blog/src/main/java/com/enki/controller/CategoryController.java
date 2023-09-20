package com.enki.controller;

import com.enki.domain.ResponseResult;
import com.enki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Enki
 * @ClassName CategoryController
 * @Description: TODO
 * @Date 2023/9/20 15:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    //CategoryService是我们在framework工程里面写的接口
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    //ResponseResult是我们在framework工程里面写的实体类
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

}