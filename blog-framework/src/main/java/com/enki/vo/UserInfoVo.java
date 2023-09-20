package com.enki.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Enki
 * @ClassName UserInfoVo
 * @Description: TODO
 * @Date 2023/9/20 17:18
 * @Version 1.0
 */
@Data
@Accessors(chain = true)//生成具有链式调用风格的 setter 方法，以便于链式编程
public class UserInfoVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;

}
