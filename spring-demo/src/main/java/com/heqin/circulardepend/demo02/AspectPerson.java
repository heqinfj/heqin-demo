package com.heqin.circulardepend.demo02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectPerson {

    @Around("execution(public void com.heqin.circulardepend.demo02.Person.makeSound(..))")
    public void aroundPersonMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("come into aroundPersonMethod...");
        Object[] args = pjp.getArgs();
        pjp.proceed(args);
    }
}
