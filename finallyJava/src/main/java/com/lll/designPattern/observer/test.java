package com.lll.designPattern.observer;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

/**
 * Created by lvliangliang on 2018/05/24.
 *      这个模式是松偶合的。改变主题或观察者中的一方，另一方不会受到影像。
        JDK中也有自带的观察者模式。但是被观察者是一个类而不是接口，限制了它的复用能力。
        在JavaBean和Swing中也可以看到观察者模式的影子。

     观察者模式的定义：
     　　在对象之间定义了一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象会收到通知并自动更新。

     其实就是
            发布订阅模式，
            发布者发布信息，
            订阅者获取信息，
            订阅了就能收到信息，
            没订阅就收不到信息。
 */
public class test {
    public static void main(String[] args) {
        WechatServer wechatServer=new WechatServer();

        Observer Mark=new User("Mark");
        Observer Jack=new User("Jack");
        Observer Anne=new User("Anne");
        wechatServer.registerObserver(Mark);
        wechatServer.registerObserver(Jack);
        wechatServer.registerObserver(Anne);
        wechatServer.setInfor("i love you ");

        wechatServer.removeObserver(Mark);
        wechatServer.setInfor("i love you twice");


    }
}
