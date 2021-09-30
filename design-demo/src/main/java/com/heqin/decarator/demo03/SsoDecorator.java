package com.heqin.decarator.demo03;

/**
 * 抽象类装饰器
 *
 * @Author heqin
 * @Date 2021/9/29 18:55
 */
public abstract class SsoDecorator implements HandlerInterceptor{

    //需要被装饰的目标
    private HandlerInterceptor target;

    public SsoDecorator(HandlerInterceptor target){
        this.target = target;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return target.preHandle(request,response,handler);
    }
}
