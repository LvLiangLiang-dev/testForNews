package com.lll.thread.h1.threadmethod;

public class Demo2_CurrentThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println(getName() + "....aaaaaa");
			}
		}.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				//Thread.currentThread()��ȡ��ǰ����ִ�е��߳�
				System.out.println(Thread.currentThread().getName() + "...bb");
			}
		}).start();
		
		Thread.currentThread().setName("�������߳�");
		System.out.println(Thread.currentThread().getName());
	}

}
