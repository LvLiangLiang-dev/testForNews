package com.forbaidu.thread;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/17
 */
/**
 *@functon 线程通信之面包类
 *@author 温煦（昵称：沉沦之巅）
 *@time 2017.12.5
 */


public class Breads {

    //面包的id
    private int bid;
    //面包的个数
    private int num;

    //生产面包的方法（由于是demo，方便大家理解，就把synchronized关键字加到方法上面了哦）
    public synchronized void produc(){

        //当面包的数量不为0时，该方法处于等待状态
        if(0 != num){
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //当面包数量为0时，那么就开始生产面包了哦
        num  =  num +1;//数量加1
        bid = bid + 1 ;//id当然也得加1
        String threadname = Thread.currentThread().getName();
        System.out.println(threadname+"生产了一个编号为"+bid+"的面包！");
        notify();//当执行完后，去唤醒其他处于等待的线程
    }
    //消费面包的方法
    public synchronized void consume(){
        //当面包的数量为0时，该方法处于等待状态
        if(num == 0 ){
            try {
                wait();//等待
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //消费完面包了，所以面包数量降为0了
        num  =  num -1;//数量减1
        String name1 = Thread.currentThread().getName();
        System.out.println(name1+"买了一个面包编号为"+bid);
        notify();//当执行完后，去唤醒其他处于等待的线程
    }


    //set和get方法
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //有参构造
    public Breads(int bid, int num) {
        super();
        this.bid = bid;
        this.num = num;
    }

    //无参构造
    public Breads() {
        super();
        // TODO Auto-generated constructor stub
    }
}