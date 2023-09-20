package com.enki.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.enki.domain.LoginUser;
import com.enki.domain.ResponseResult;
import com.enki.enums.AppHttpCodeEnum;
import com.enki.utils.JwtUtil;
import com.enki.utils.RedisCache;
import com.enki.utils.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Enki
 * @ClassName JwtAuthenticationTokenFilter
 * @Description: 自定义JWT认证过滤器
 * @Date 2023/9/20 19:20
 * @Version 1.0
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    //RedisCache是我们在huanf-framework工程写的工具类，用于操作redis
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");//获取token
        if (StrUtil.isBlank(token)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);//放行
            return;
        }
//        获取token
        Claims claims = null;
//        解析token
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
//            当出现错误 token过期或发送错误
            e.printStackTrace();
//            返回前端错误信息并重新登陆
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }
        String id = claims.getSubject();
//        获取Redis中的数据
        LoginUser loginUser = redisCache.getCacheObject("bloglogin:" + id);
//        判断是否取到
        if (ObjectUtil.isNull(loginUser)) {
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }
//把从redis获取到的value，存入到SecurityContextHolder(Security官方提供的类)
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
