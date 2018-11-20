package com.lll.thread.h1.thread;

public class Demo1_Thread {

	/**
	 * @param args
	 * ???jvm???????
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			new Demo();
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println("????????????д???");
		}
		
		
		new Thread(new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread().getName()+"   jjjjj");
			}
		}).start();
		
		System.out.println(Thread.currentThread().getName());
		
	}

}

class Demo {

	@Override
	public void finalize() {
		System.out.println("???????????");
	}
	
}