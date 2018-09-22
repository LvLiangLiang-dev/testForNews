package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/31
 */
public class TimerTest {
    public static void main(String[] args) {

    }

    /**
     * 当将一个任务添加到线程池中的时候，线程池会为每个任务创建一个线程，该线程会在之后的某个时刻自动执行。
     * 可以看到示例1中，两个线程都会执行，但是只会使用一个线程来运行。
     */
    @Test
    public void t1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("xc启动并运行： " + Thread.currentThread().getName());
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("xc2启动并运行： " + Thread.currentThread().getName());
            }
        });
    }

    /**
     * 从运行结果可以看出，每四个一组输出，即一共创建了四个线程，每次每个线程都会执行输出，但不按顺序，每一次输出都四个算是一组。
     * <p>
     * shutdown():当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态,以后不能再往线程池中添加任何任务，否则将会抛出RejectedExecutionException异常。
     * 但是，此时线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出。
     */
    @Test
    public void t2() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int a = i;
            executorService.execute(new Runnable() {
                public void run() {
                    while (true) {
                        System.out.println(
                                "测试： " + a + "->" + Thread.currentThread().getName() + "," + Thread.currentThread()
                                        .isDaemon());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    @Test
    public void t3() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> result = new ArrayList<Future<String>>();
        for (int i = 0; i < 3; i++) {
            Future<String> f = executorService.submit(new MyCall(i));
            result.add(f);
        }
        for (Future<String> f : result) {
            System.err.println("返回值：" +f.get());//输出返回的值
        }

        System.err.println("完成....");

    }

    class MyCall implements Callable<String> {
        private int seq;

        public MyCall(int seq) {
            this.seq = seq;
        }

        public String call() throws Exception {
            System.out.println("执行 " + seq + "," + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("wake up " + seq);
            return "完成 " + seq;
        }
    }

}
