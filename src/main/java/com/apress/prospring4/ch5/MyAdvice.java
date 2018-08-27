package com.apress.prospring4.ch5;


import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Executing: " + method);
    }

    public void  simpleBeforeAdvice(JoinPoint joinpoint) {
        System.out.println("Executing: " +
                joinpoint.getSignature().getDeclaringTypeName() + " " +
                joinpoint.getSignature().getName());
    }
}
