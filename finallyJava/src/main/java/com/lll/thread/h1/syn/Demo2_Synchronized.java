package com.lll.thread.h1.syn;

public class Demo2_Synchronized {

	/**
	 * @param args
	 * ͬ�������
	 */
	public static void main(String[] args) {
		final Printer2 p = new Printer2();
		
		new Thread() {
			public void run() {
				while(true) {
					p.print1();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					p.print2();
				}
			}
		}.start();
	}

}

class Printer2 {
	Demo d = new Demo();
	//�Ǿ�̬��ͬ��������������������?
	//��:�Ǿ�̬��ͬ����������������this
	//��̬��ͬ����������������ʲô?
	//�Ǹ�����ֽ������
	public static synchronized void print1() {							//ͬ������ֻ��Ҫ�ڷ����ϼ�synchronized�ؼ��ּ���
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("Ա");
		System.out.print("\r\n");
	}
	
	public static void print2() {
		//synchronized(new Demo()) {							//������������������,��Ϊ����������ͬһ������
		synchronized(Printer2.class) {		
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");
		}
	}
}

