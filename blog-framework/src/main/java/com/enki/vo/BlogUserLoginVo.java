package com.enki.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Enki
 * @ClassName BlogUserLoginVo
 * @Description: TODO
 * @Date 2023/9/20 17:18
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserLoginVo {

    private String token;
    private UserInfoVo userInfo;
}