package com.lll.testtry;

public class Fxtest<T>{
	private T ob;
	public Fxtest(T ob){
		this.ob=ob;
	}
	public T getob(){
		return ob;
	}
	public void show(){
		System.out.println("T��������"+ob.getClass().getName());
	}
	public static void main(String []args){
		Fxtest<Integer> intt1=new Fxtest<Integer>(100);
		Fxtest<String> stringt2=new Fxtest<String>("ggg");
		
		intt1.show();
		stringt2.show();
		
	}

}
