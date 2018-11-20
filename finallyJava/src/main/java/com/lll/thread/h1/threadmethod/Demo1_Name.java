package com.lll.thread.h1.threadmethod;

public class Demo1_Name {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//demo1();
		Thread t1 = new Thread() {
			public void run() {
				//this.setName("����");
				System.out.println(this.getName() + "....aaaaaaaaaaaaa");
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				//this.setName("����");
				System.out.println(this.getName() + "....bb");
			}
		};
		
		t1.setName("����");
		t2.setName("����");
		t1.start();
		t2.start();
	}

	public static void demo1() {
		new Thread("ܽ�ؽ��") {							//ͨ�����췽����name��ֵ
			public void run() {
				System.out.println(this.getName() + "....aaaaaaaaa");
			}
		}.start();
		
		new Thread("���") {
			public void run() {
				System.out.println(this.getName() + "....bb");
			}
		}.start();
	}

}
