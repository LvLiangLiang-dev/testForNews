package com.lll.thread.h1.syn;

public class DemoBySelf {
	public static void main(String []args){
		final temp t=new temp();
		
		while(true){
			new Thread(){
				public void run(){
					t.p1();
					
				}
			}.start();
			
			
			new Thread(){
				public void run(){
					t.p2();
					
				}
			}.start();
		}
	}
}

class temp{
	Demo a=new Demo();
	public void p1(){
		synchronized(a){
			System.out.print ("1");
			System.out.print ("2");
			System.out.print ("3");
			System.out.print ("\r\n");
		}
	}
	
	public void p2(){
		synchronized(a){
			System.out.print ("a");
			System.out.print  ("b");
			System.out.print ("c");
			System.out.print ("\r\n");
		}
	}
}
