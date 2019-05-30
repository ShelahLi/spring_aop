package com.lucky.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyJdkProxy implements InvocationHandler{
    private UserDao userDao;

    public MyJdkProxy(UserDao userDao){
        this.userDao = userDao;
    }

    public Object createProxy(){
        Object proxy = Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                        userDao.getClass().getInterfaces(),this);
        return proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("save".equals(method.getName())){
            //判断方法是否是save，如果是save则进行增强
            System.out.println("权限校验...");
            return method.invoke(userDao,args);
        }
        //如果不是save方法，就直接执行该方法，不进行增强
        return method.invoke(userDao,args);
    }
}
