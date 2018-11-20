package com.forbaidu.thread;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/17
 */
/**
 *@functon 线程通信之消费类（继承Thread类）
 *@author 温煦（昵称：沉沦之巅）
 *@time 2017.12.5
 */
public class consume extends Thread{

    //获得面包的类
    private Breads bre ;

    //set和get方法
    public Breads getBre() {
        return bre;
    }
    public void setBre(Breads bre) {
        this.bre = bre;
    }

    //继承重写run方法
    @Override
    public void run() {
        con();
    }

    //消费面包
    private void con() {
        // 与生产者保持一致，本系统默认循环生产20个面包（生产几个，消费几个）
        for(int i = 0;i<20;i++){
            try {
                //沉睡0.3秒（演示效果需要，可以不加）
                Thread.currentThread().sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //调用面包类里的生产面包的方法
            bre.consume();
        }
    }

    //有参构造
    public consume(Breads bre) {
        super();
        this.bre = bre;
    }

    //无参构造
    public consume() {
        super();
    }
}