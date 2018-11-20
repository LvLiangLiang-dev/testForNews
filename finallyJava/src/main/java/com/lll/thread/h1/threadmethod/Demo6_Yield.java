package com.lll.thread.h1.threadmethod;

public class Demo6_Yield {

	/**
	 * yield�ó�cpu�����߳�
	 */
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
	}

}

class MyThread extends Thread {
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			if(i % 10 == 0) {
				Thread.yield();						//�ó�CPU
			}
			System.out.println(getName() + "..." + i);
		}
	}
}