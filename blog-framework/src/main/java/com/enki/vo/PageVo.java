package com.enki.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Enki
 * @ClassName PageVo
 * @Description: TODO
 * @Date 2023/9/20 15:43
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    private List rows;
    private Long total;
}
