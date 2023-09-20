package com.enki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enki.domain.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Enki
 * @ClassName ArticleMapper
 * @Description: TODO
 * @Date 2023/9/20 13:52
 * @Version 1.0
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
