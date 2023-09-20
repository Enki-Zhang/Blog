package com.enki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enki.domain.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Enki
 * @ClassName CategoryMapper
 * @Description: TODO
 * @Date 2023/9/20 15:22
 * @Version 1.0
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
