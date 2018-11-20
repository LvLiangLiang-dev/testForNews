package com.lll.testtry;

import java.io.IOException;
import java.util.Arrays;
import java.io.File;
//import java.io.FileInputStream;
import java.io.*;

/**
 * 
 */
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time��2017��5��2�� ����11:03:54
* class illustration:
*/
/**
 * @author NewUser
 *
 */
//public class streamio_test {
//	public static void main(String args[]){
//		System.out.println("please input");
//		int b = 0;
//		try{
//			while((b=System.in.read())!=-1){
//				System.out.print((char)b);
//			}
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//		
//	}
//
//}

public class streamio_test{
	public static void main(String args[]) throws IOException{
		File src=new File("d:\\test_io");
		File f1=new File(src,"file1.txt");
		if(!src.exists()){
			src.mkdir();
		}
		if(!f1.exists()){
			f1.createNewFile();
		}
		
		
		System.out.println(f1.getAbsolutePath());
		//String [] flow=f1.list();
		//System.out.println(flow);
		
		
		FileInputStream fff=new FileInputStream(f1);
		
		//1һ���ֽ�һ���ֽڵĶ�ȡ     
		//temp=new FileInputStream(new File(location,"filename)).read();
		//system.out.println(temp);
		int by=0;
		while((by=fff.read())!=-1){
			System.out.println(by);
			//System.out.println("tmp");
		}
		
		System.out.println("this is the second method");
		
		//2
		byte [] bf=new byte[4096];
		//int len =fff.read(bf);
		//System.out.println(len+"..."+Arrays.toString(bf));
		
		int llen=0;
		while((llen=fff.read(bf))!=-1){
			System.out.println(new String(bf,0,llen));
		}
		
		
		
		
		
		
		
		
		
		
		fff.close();
	}
}
