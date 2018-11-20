package com.lll.thread.h2.thread;

public class SingleTonBySelf {
	public static void main(String []args){
		Singleton0 s=Singleton0.getInstance();
	}

}

class Singleton0{
	private void SingleTon(){}
	private static  Singleton0 s=new Singleton0();
	public static Singleton0 getInstance (){
		return s;	
	}
}

class Singleton1{
	private void SingleTon(){}
	private static Singleton1 s;
	public static Singleton1 getInstance(){
		if (s==null){
			s=new Singleton1();
		}
		return s;
	}
}
class Singleton3{
	private void Singleton3(){}
	private static final  Singleton3 s=new Singleton3();
}
	
