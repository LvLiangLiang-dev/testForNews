package com.lll.net.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo1_Receive {

	/**
	 * 2.接收Receive
	 * 创建DatagramSocket, 指定端口号
	 * 创建DatagramPacket, 指定数组, 长度
	 * 使用DatagramSocket接收DatagramPacket
	 * 关闭DatagramSocket
	 * 从DatagramPacket中获取数据
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(9900);
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		socket.receive(packet);
		
		byte[] arr = packet.getData(); //发送接收的都是字节数据,获取数据
		int len = packet.getLength();

		System.out.println(new String(arr,0,len));
		System.out.println(packet.getAddress().toString());
		System.out.println(packet.getPort());
		System.out.println(packet.getLength());
		socket.close();
	}

}
