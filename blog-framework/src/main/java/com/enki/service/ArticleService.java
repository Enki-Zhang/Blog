package com.enki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enki.domain.Article;
import com.enki.domain.ResponseResult;

/**
 * @author Enki
 * @ClassName ArticleService
 * @Description: TODO
 * @Date 2023/9/20 13:52
 * @Version 1.0
 */
public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    //分类查询文章列表
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);
    //根据id查询文章详情
    ResponseResult getArticleDetail(Long id);


    //根据文章id从mysql查询文章
    ResponseResult updateViewCount(Long id);
}
