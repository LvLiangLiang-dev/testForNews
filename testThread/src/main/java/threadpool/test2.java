package threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.junit.Rule;
import org.junit.Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：创建四种线程池
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * @DATE: 2018/6/1
 */
public class test2 {
    int a=0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("begin...");
            }
        }).start();
        System.out.println(Thread.activeCount());
    }

    @Test
    public void tp1(){
        ExecutorService executorService=Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            final int index=i;
            try{
                Thread.sleep(index*100);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.print(index+"->");
                    System.out.println(Thread.currentThread().getName());
                }
            });
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.print(index+"->");
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }
    @Test
    public void tp2() throws InterruptedException {
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            Thread.sleep(i*100);
            final int finalI = i;
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(finalI +" ->");
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("id:"+Thread.currentThread().getId());
                }
            });
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(finalI +" ->");
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("id:"+Thread.currentThread().getId());
                }
            });
        }
    }
    @Test
    public void t3(){
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        for(int i=0;i<10;i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });

            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });

            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }
    @Test
    public void t4(){
        ExecutorService executorService=Executors.newScheduledThreadPool(10, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return null;
            }
        });

    }


}
