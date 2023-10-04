package com.enki.controller;

import com.enki.constants.SystemCanstants;
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
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {
        return commentService.commentList(SystemCanstants.ARTICLE_COMMENT, articleId, pageNum, pageSize);
    }

    @GetMapping("/linkCommentList")
    //在友链的评论区发送评论。ResponseResult是我们在huanf-framework工程写的类
    public ResponseResult linkCommentList(Integer pageNum, Integer pageSize) {
        //commentService是我们刚刚实现文章的评论区发送评论功能时(当时用的是addComment方法，现在用commentList方法)，写的类
        //SystemCanstants是我们写的用来解决字面值的常量类，Article_LINK代表1
        return commentService.commentList(SystemCanstants.LINK_COMMENT, null, pageNum, pageSize);
    }


}
