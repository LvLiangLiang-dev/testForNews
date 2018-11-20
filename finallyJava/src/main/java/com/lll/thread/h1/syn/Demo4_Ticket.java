package com.lll.thread.h1.syn;

public class Demo4_Ticket {

	/**
	 * @param args
	 * ��վ��Ʊ��������ʵ��Runnable�ӿ�
	 */
	public static void main(String[] args) {
		MyTicket mt = new MyTicket();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		
		/*Thread t1 = new Thread(mt);				//�������һ���߳��ǷǷ���
		t1.start();
		t1.start();
		t1.start();
		t1.start();*/
	}

}

class MyTicket implements Runnable {
	private int tickets = 100;
	@Override
	public void run() {
		while(true) {
			synchronized(this) {
				if(tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(10);				//�߳�1˯,�߳�2˯,�߳�3˯,�߳�4˯
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...���ǵ�" + tickets-- + "��Ʊ");
			}
		}
	}
}