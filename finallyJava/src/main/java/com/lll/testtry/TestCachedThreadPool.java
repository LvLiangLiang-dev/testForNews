package com.lll.testtry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 */
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time��2017��5��5�� ����4:28:05
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class TestCachedThreadPool {
	public static void main(String args[]){
		ExecutorService pool=Executors.newCachedThreadPool();
		Thread t1=new MyThread();
		Thread t2=new MyThread();
		//MyThread t6=new MyThread();
		Thread t3=new MyThread();
		Thread t4=new MyThread();
		Thread t5=new MyThread();
		
		pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //pool.execute(t6);
        
        pool.shutdown();

		
	}

}
class MyThread extends Thread{
	public void run(){
		System.out.println(Thread.currentThread().getName()+" is running!");
	}
}