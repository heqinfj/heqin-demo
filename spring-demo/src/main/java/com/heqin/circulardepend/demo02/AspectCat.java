package com.heqin.circulardepend.demo02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectCat {

    @Around("execution(public void com.heqin.circulardepend.demo02.Cat.makeSound(..))")
    public void aroundCatMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("come into aroundCatMethod...");
        Object[] args = pjp.getArgs();
        pjp.proceed(args);
    }
}
