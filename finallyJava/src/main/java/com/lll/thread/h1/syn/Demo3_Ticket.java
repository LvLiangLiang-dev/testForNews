package com.lll.thread.h1.syn;

public class Demo3_Ticket {

	/**
	 * ����:��·��Ʊ,һ��100��,ͨ���ĸ���������.
	 */
	public static void main(String[] args) {
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
	}

}

class Ticket extends Thread {
	private static int ticket = 100;
	//private static Object obj = new Object();		//����������������ͳ�Ա��������������,�����Ǿ�̬��
	public void run() {
		while(true) {
			synchronized(Ticket.class) {
				if(ticket <= 0) {
					break;
				}
				try {
					Thread.sleep(10);				//�߳�1˯,�߳�2˯,�߳�3˯,�߳�4˯
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println(getName() + "...���ǵ�" + ticket-- + "��Ʊ");
			}
		}
	}
}
