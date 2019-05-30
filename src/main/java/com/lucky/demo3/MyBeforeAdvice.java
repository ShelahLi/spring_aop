package com.lucky.demo3;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
/*
     实现前置增强的接口：MethodbeforeAdvice
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置增强======================");
    }
}
