package com.lll.testtry;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time��2017��5��8�� ����10:59:19
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class TestThreadPool {
	public static void main(String args[]){
		ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
		for(int i=0;i<15;i++){
			Task mytask=new Task(i);
			executor.execute(mytask);
			System.out.println("�̳߳��߳���Ŀ��"+executor.getPoolSize());
			System.out.println("�ȴ��߳���Ŀ�� "+executor.getQueue().size());
			System.out.println("��ִ������������Ŀ��"+executor.getCompletedTaskCount());
			
		}
		executor.shutdown();
	}

}

class Task implements Runnable{
	private int tasknum;
	public  Task(int num){
		this.tasknum=num;
	}
	public void run(){
		System.out.println("the thread "+tasknum+"  is running");
		try{
			Thread.currentThread().sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(tasknum+" thread is over");
	}
}