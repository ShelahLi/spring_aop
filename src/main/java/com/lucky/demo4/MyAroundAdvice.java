package com.lucky.demo4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕前增强===================");

        Object obj = invocation.proceed();//执行目标的方法
        //环绕通知是很强的通知方法，可以使目标方法不执行

        System.out.println("环绕后增强===================");
        return obj;
    }
}
