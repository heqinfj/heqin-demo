package com.heqin.decarator.demo03;

/**
 * 模拟单点登录功能
 *
 * @Author heqin
 * @Date 2021/9/29 18:53
 */
public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }
}
