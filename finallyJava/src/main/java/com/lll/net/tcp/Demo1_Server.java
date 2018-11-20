package com.lll.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Demo1_Server {

	/**
	 * 2.服务端
	 * 创建ServerSocket(需要指定端口号)
	 * 调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
	 * 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
	 * 输入流可以读取客户端输出流写出的数据
	 * 输出流可以写出数据到客户端的输入流
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		
		Socket socket = server.accept();						//接收客户端的请求
		InputStream is = socket.getInputStream();			//获取客户端输入流
		OutputStream os = socket.getOutputStream();			//获取客户端输出流

		Scanner scanner=new Scanner(System.in);

		while (true){
			String string=scanner.nextLine();
			if(string.equals("quit"))break;
			else {
				os.write(string.getBytes());
			}
		}
//		os.write("服务端发数据，写入数据".getBytes());
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr,0,len));
		socket.close();
	}

}
