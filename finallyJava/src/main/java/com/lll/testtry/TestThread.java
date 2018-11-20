package com.lll.testtry;//by Internet


class RunnableDemo implements Runnable {
   private Thread t;
   private String threadName;
   
   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // ���߳�˯��һ��
            Thread.sleep(50);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
//   public void start () {
//      System.out.println("Starting " +  threadName );
//      if (t == null) {
//         t = new Thread (this, threadName);
//         t.start ();
//      }
//   }
}
 
public class TestThread {
 
   public static void main(String args[]) {
//      RunnableDemo R1 = new RunnableDemo( "Thread-1");
//      R1.start();
//      
//      RunnableDemo R2 = new RunnableDemo( "Thread-2");
//      R2.start();
	   
	   RunnableDemo t1=new RunnableDemo("�߳�1");
	   RunnableDemo t2=new RunnableDemo("�߳�2");
	   new Thread(t1).start();
	   new Thread(t2).start();
      int temp=10;
      for(int i=0;i<temp;i++){
    	  System.out.println("i="+i);
      }
      //this indicated the thread would go until time is allowed;
      //����start�������״̬��ֱ����ʱ��Ƭ�Ż��������״̬��
   }   
}


//runnable��thread������
//����һ����ֻ����һ�����࣬�ӿ���û������
//run��������д
//ֻ������start���������ܽ������״̬
//runnable�����������û��start������ֻ��thread�в��У���thread��һ�����췽�����ܹ�����ȥrunnable������ʵ��
//Ҳ����˵��ͨ��thread��ķ���������runnableʵ�ֵ� ���߳�
//��ʵ��������Ҫ��runnable�ӿڼ̳�Ϊ��
///�����̳еľ��ޣ�һ������Լ̳ж���ӿ�
///�ʺ���Դ�Ĺ���