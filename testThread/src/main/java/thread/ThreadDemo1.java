package thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/6/3
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        Ticket3 ticket = new Ticket3();
        new Thread(ticket, "1").start();
        new Thread(ticket, "2").start();
        new Thread(ticket, "3").start();
    }

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new CallTest());
        try {
            System.out.println(future.get());
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getId());
        } catch (Exception e) {

        } finally {
            executorService.shutdown();
        }
    }


}
