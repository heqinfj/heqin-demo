package com.heqin.proxy.nestedproxy.cglib;

import com.heqin.proxy.cglib.CglibDynamicProxyHelper4ClassTest;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;

/**
 * @Desc Nested Proxy using cglib in spring
 * 在spring中使用cglib嵌套代理
 * <a>https://stackoverflow.com/questions/60690702/nested-proxy-using-cglib-in-spring</a>
 * @Author heqin
 * @Date 2021/9/16 19:44
 */
public class NestedProxyUsingCglibExample extends CglibDynamicProxyHelper4ClassTest {

    /**
     * 错误
     */
    @Test
    public void nestedProxyError() {
        //Create First Proxy
        Enhancer firstEnhancer = new Enhancer();
        firstEnhancer.setSuperclass(OriginalClass.class);
        firstEnhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("method interceptor at first proxy");
            return methodProxy.invokeSuper(o, objects);
        });
        OriginalClass firstProxy = (OriginalClass) firstEnhancer.create();

        //Create Second Proxy
        Enhancer secondEnhancer = new Enhancer();
        secondEnhancer.setSuperclass(firstProxy.getClass());
        secondEnhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("method interceptor at second proxy");
            return methodProxy.invokeSuper(o, objects);
        });

        //Getting Exception on this line
        //Duplicate method name "newInstance" with signature "([Lnet.sf.cglib.proxy.Callback;)Ljava.lang.Object;"
        OriginalClass secondProxy = (OriginalClass) secondEnhancer.create();

        //Call
        secondProxy.print();
    }

    /**
     * 正确方案
     * I've found working soultion, it works when used methodProxy.invoke() instead of methodProxy.invokeSuper() in the second enhancer,
     * also the firstProxy need to be passed to the invocation instead of the o object and the superClass is set to the original one,
     * that doesn't have the newInstance method:
     */
    @Test
    public void nestedProxyRight() {
        //Create First Proxy
        Enhancer firstEnhancer = new Enhancer();
        firstEnhancer.setSuperclass(OriginalClass.class);
        firstEnhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            //为了测试明确方法名
            if("print".equals(method.getName())){
                System.out.println("method interceptor at first proxy");
                Object o1 = methodProxy.invokeSuper(o, objects);
                return o1;
            }else{
                //System.out.println("null...");
                return null;
            }
        });
        OriginalClass firstProxy = (OriginalClass) firstEnhancer.create();

        //Create Second Proxy
        Enhancer secondEnhancer = new Enhancer();
        secondEnhancer.setSuperclass(firstProxy.getClass().getSuperclass());//修改点
        secondEnhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            //为了测试明确方法名
            if("print".equals(method.getName())){
                System.out.println("method interceptor at second proxy");
                Object o1 = methodProxy.invoke(firstProxy, objects);//修改点
                return o1;
            }else{
                //System.out.println("null...");
                return null;
            }
        });

        OriginalClass secondProxy = (OriginalClass) secondEnhancer.create();

        //Call
        secondProxy.print();
    }

    /**
     * 测试出现 java.lang.StackOverflowError
     */
    @Test
    public void testStackOverflowError(){
        //Create First Proxy
        Enhancer firstEnhancer = new Enhancer();
        firstEnhancer.setSuperclass(OriginalClass.class);
        firstEnhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            //为了测试明确方法名
            if("print".equals(method.getName())){
                System.out.println("method interceptor at first proxy");
                Object o1 = methodProxy.invokeSuper(o, objects);

                //invokeSuper -> invoke的情况
                //Getting Exception on this line -> java.lang.StackOverflowError  死循环
                //Object o1 = methodProxy.invoke(o, objects);
                return o1;
            }else{
                //System.out.println("null...");
                return null;
            }
        });
        OriginalClass firstProxy = (OriginalClass) firstEnhancer.create();

        //Call
        firstProxy.print();
    }
}
