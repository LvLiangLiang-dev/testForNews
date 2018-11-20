package com.lll.testtry;//by lvliangliang
//on 2017-3-26
//for two ways of showing thread
//for indicating cpu_times



/*
public class TestTh{
	public static void main(String args[]){
		demo1 rundemo=new demo1();
		Thread t=new Thread(rundemo);
		t.start();
		for(int j=0;j<10;j++){
			System.out.println("main:"+j);
		}
		
	}
}
class demo1 implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("run:"+i);
		}
	}
}
*/

public class TestTh{
	public static void main(String args[]){
		demo2 t=new demo2("T1");
		t.start();
		demo2 t2=new demo2("T2");
		t2.start();
		for(int j=0;j<10;j++){
			System.out.println("main:"+j);
		}
		
	}
}

class demo2 extends Thread{
	private String tname;
	demo2(String name){
		tname=name;
		System.out.println("creating"+name);
	}
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(tname+"--"+"run:"+i);
		}
	}
}
