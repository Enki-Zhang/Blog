package com.enki.controller;

import com.enki.domain.ResponseResult;
import com.enki.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Enki
 * @ClassName LinkController
 * @Description: TODO
 * @Date 2023/9/20 16:58
 * @Version 1.0
 */
@RestController
@RequestMapping("link")
public class LinkController {
    @Autowired
    //LinkService是我们在huanf-framework工程写的接口
    private LinkService linkService;


    @GetMapping("/getAllLink")
    //ResponseResult是我们在huanf-framework工程写的实体类
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}
