package com.lll.designPattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lvliangliang on 2018/05/24.
 */
public class ProxyFactoryCglib implements MethodInterceptor {
    private Object target;
    public ProxyFactoryCglib(Object target){
        this.target=target;
    }

    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务3");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("提交事务3");
        return returnValue;

    }
}
