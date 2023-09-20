package com.enki.handler.security;

import com.alibaba.fastjson.JSON;
import com.enki.domain.ResponseResult;
import com.enki.enums.AppHttpCodeEnum;
import com.enki.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Enki
 * @ClassName AccessDeniedHandlerImpl
 * @Description: 自定义授权失败的处理器
 * @Date 2023/9/20 19:55
 * @Version 1.0
 */

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //输出异常信息
        accessDeniedException.printStackTrace();

        //ResponseResult、AppHttpCodeEnum是我们在huanf-framework工程写的类。重点在下面那行的枚举，就是我们返回给前端的信息
        ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);

        //使用spring提供的JSON工具类，把上一行的result转换成JSON，然后响应给前端。WebUtils是我们写的类
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}