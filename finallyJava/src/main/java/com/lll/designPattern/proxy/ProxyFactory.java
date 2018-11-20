package com.lll.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lvliangliang on 2018/05/24.
 */
public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object object) {
        this.target = object;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        Object returnValue=method.invoke(target,args);
                        System.out.println("结束事务2");
                        return returnValue;
                    }
                }
        );

    }
}
