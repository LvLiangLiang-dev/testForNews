package com.lll.thread;

/**
 * Created by lvliangliang on 2018/03/19.
 */
public class test {
    public static void main(String[] args) {
        ofRunnable();
    }

    private static void ofRunnable() {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
        for(int i=0;i<5;i++)
            System.out.println("main is running");
    }

    private static void ofThread() {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("main running");
    }
}
