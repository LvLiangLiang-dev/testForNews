package com.lll.thread.h2.thread;

public class Demo1_Singleton {

	/**
	 * @param args
	 * * �������ģʽ����֤�����ڴ���ֻ��һ������
	 */
	public static void main(String[] args) {
		//Singleton s1 = new Singleton();
		
		Singleton s1 = Singleton.s;				//��Ա������˽��,����ͨ������.����
		//Singleton.s = null;
		Singleton s2 = Singleton.s;
		
		System.out.println(s1 == s2);
		
	/*	Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1 == s2);*/
	}

}

/*
 * ����ʽ
 
class Singleton {
	//1,˽�й��췽��,�����಻�ܷ��ʸù��췽����
	private Singleton(){}
	//2,�����������
	private static Singleton s = new Singleton();
	//3,�����ṩ�����ķ��ʷ���
	public static Singleton getInstance() {				//��ȡʵ��
		return s;
	}
}*/
/*
 * ����ʽ,�������ӳټ���ģʽ
 */
/*class Singleton {
	//1,˽�й��췽��,�����಻�ܷ��ʸù��췽����
	private Singleton(){}
	//2,����һ������
	private static Singleton s ;
	//3,�����ṩ�����ķ��ʷ���
	public static Singleton getInstance() {				//��ȡʵ��
		if(s == null) {
			//�߳�1�ȴ�,�߳�2�ȴ�
			s = new Singleton();
		}
		
		return s;
	}
}*/
/*
 * ����ʽ������ʽ������
 * 1,����ʽ�ǿռ任ʱ��,����ʽ��ʱ�任�ռ�
 * 2,�ڶ��̷߳���ʱ,����ʽ���ᴴ���������,������ʽ�п��ܻᴴ���������
 */

class Singleton {
	//1,˽�й��췽��,�����಻�ܷ��ʸù��췽����
	private Singleton(){}
	//2,����һ������
	public static final Singleton s = new Singleton();
	
}
