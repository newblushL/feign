package com.example.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: Fei自定义拦截器实现认证
 * @author: ll
 * @create: 2019-08-06 21:52
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    public FeignBasicAuthRequestInterceptor() {

    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String accessToken = request == null ? StringUtils.EMPTY : request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("=================Feign Interceptor AccessToken: " + accessToken);
        requestTemplate.header(HttpHeaders.AUTHORIZATION, accessToken);
    }
}