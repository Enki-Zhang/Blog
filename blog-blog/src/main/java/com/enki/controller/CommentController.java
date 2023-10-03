package com.enki.controller;

import com.enki.domain.ResponseResult;
import com.enki.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Enki
 * @ClassName CommentController
 * @Description: TODO
 * @Date 2023/10/3 15:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("commentList")
    //ResponseResult是我们在huanf-framework工程写的类
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.commentList(articleId,pageNum,pageSize);
    }
}
