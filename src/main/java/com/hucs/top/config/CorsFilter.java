package com.hucs.top.config;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 配置跨域
 * @author: huchuansai
 * @time: 2021/6/7 7:29 下午
 */
@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 跨域访问CORS
        httpResponse.addHeader("Access-Control-Allow-Origin", "*"); // 代表允许所有的域名来进行访问
        httpResponse.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE,HEAD"); // 允许的请求类型
        httpResponse.setHeader("Access-Control-Allow-Headers", "*"); // 允许的http-header
        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        if (HttpMethod.OPTIONS.name().equals(httpServletRequest.getMethod())) {
            // 如果是options请求的话直接通过
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        // 前往下一个过滤器
        chain.doFilter(request, response);
    }
}
