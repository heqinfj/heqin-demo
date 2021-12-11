package com.heqin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author heqin
 * @Date 2021/11/3 10:59
 */
@Component
@Order(1)
public class CustomFirstFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CustomFirstFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("########## Initiating Custom filter ##########");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        logger.info("Logging Request  {} : {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());

        //call next filter in the filter chain
        chain.doFilter(httpServletRequest, httpServletResponse);

        logger.info("Logging Response :{}", response.getContentType());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
