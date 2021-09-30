package com.heqin.decarator.demo03;

/**
 * 模拟spring的HandlerInterceptor
 *
 * @Author heqin
 * @Date 2021/9/29 18:44
 */
public interface HandlerInterceptor {
    boolean preHandle(String request, String response, Object handler);
}
