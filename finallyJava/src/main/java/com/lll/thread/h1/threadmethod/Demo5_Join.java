package com.lll.thread.h1.threadmethod;

public class Demo5_Join {

	/**
	 * @param args
	 * join(), ��ǰ�߳���ͣ, �ȴ�ָ�����߳�ִ�н�����, ��ǰ�߳��ټ���
	 */
	public static void main(String[] args) {
		 final Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println(getName() + "...aaaaaaaaaaaaa");
				}
			}
		};
		
		//�����ڲ�����ʹ�������ڷ����ľֲ�����ʱ��Ҫʹ��final���Ρ�
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					if(i == 2) {
						try {
							//t1.join();
							t1.join(1);					//���ָ����ʱ��,����ָ��ʱ���,�����߳̽���ִ��
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					}
					System.out.println(getName() + "...bb");
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
