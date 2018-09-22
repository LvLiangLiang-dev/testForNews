package daemon;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 *
 *
 * (1) thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。
 * (2) 在Daemon线程中产生的新线程也是Daemon的。
 * (3) 守护线程应该永远不去访问固有资源，如文件、数据库，因为它会在任何时候甚至在一个操作的中间发生中断。
 *
 *
 * @DATE: 2018/6/8
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("now is "+ new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,10);
        Date date = calendar.getTime();
        MyTask myTask = new MyTask();

        Timer timer = new Timer();
        timer.schedule(myTask,date);
    }
}
