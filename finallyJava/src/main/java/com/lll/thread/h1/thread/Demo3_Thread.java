package com.lll.thread.h1.thread;

import java.security.AccessControlContext;

public class Demo3_Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();	//4,����Runnable���������
		//Runnable target = mr;	mr = 0x0011
		
		
		/*public Thread(Runnable target) {
	        init(null, target, "Thread-" + nextThreadNum(), 0);
	    }
		
		
		private void init(ThreadGroup g, Runnable target, String name,long stackSize) {
			init(g, target, name, stackSize, null);
		}
		
		private void init(ThreadGroup g, Runnable target, String name,
                long stackSize, AccessControlContext acc) {
			if (name == null) {
					throw new NullPointerException("name cannot be null");
			}
			this.target = target;


		@Override
		public void run() {
		    if (target != null) {
		        target.run();
		    }
		}
		*/
		//����Ĵ��ݹ���
		
		Thread t = new Thread(mr);			//5,���䵱���������ݸ�Thread�Ĺ��캯��
		t.start();							//6,�����߳�
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("bb");
		}
	}

}

class MyRunnable implements Runnable {		//1,����һ����ʵ��Runnable

	@Override
	public void run() {						//2,��дrun����
		for(int i = 0; i < 1000; i++) {		//3,��Ҫִ�еĴ���д��run������
			System.out.println("aaaaaaaaaaaa");
		}
	}
	
}