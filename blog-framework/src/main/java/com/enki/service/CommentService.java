package com.enki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enki.domain.Comment;
import com.enki.domain.ResponseResult;

/**
 * @author Enki
 * @ClassName CommentService
 * @Description: 评论访问接口
 * @Date 2023/10/3 15:24
 * @Version 1.0
 */
public interface CommentService extends IService<Comment> {
    /**
     * 评论数量查询
     *
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);


    //在文章的评论区发送评论
    ResponseResult addComment(Comment comment);
}
