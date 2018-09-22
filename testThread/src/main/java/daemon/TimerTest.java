package daemon;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：timer和timetask
 *  timer指定多久之后会执行任务，但是只会执行一次
 * @DATE: 2018/6/8
 */
public class TimerTest {
    Timer timer;
    public TimerTest(int time){
        timer=new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("times up");
            }
        },time*1000);
    }

    public static void main(String[] args) {
        System.out.println("time begin");
        new TimerTest(2);
    }
}
