package com.enki.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Enki
 * @ClassName HotArticleVO
 * @Description: 查询对象的结果封装
 * @Date 2023/9/20 14:47
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//返回给前端特定的字段
public class HotArticleVO {

    private Long id;
    //标题
    private String title;
    //访问量
    private Long viewCount;

}