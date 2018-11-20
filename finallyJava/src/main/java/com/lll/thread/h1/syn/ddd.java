package com.lll.thread.h1.syn;

public class ddd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	ttemp t1=new ttemp();
		Thread tt1=new Thread(t1);
		tt1.start();*/
		
		new Thread(new ttemp()).start();
		new Thread(new ttemp()).start();
		new Thread(new ttemp()).start();
		new Thread(new ttemp()).start();
		
		

	}

}
class ttemp implements Runnable{
	private static int ticket=100;
	
	public void run(){
		while(ticket>0){
			synchronized(ttemp.class){
				System.out.println(Thread.currentThread().getName()+"  this is "+ticket);
				ticket--;
			}
		}
	}
}
