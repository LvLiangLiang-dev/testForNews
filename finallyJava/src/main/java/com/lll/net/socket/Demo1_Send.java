package com.lll.net.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Demo1_Send {

	/**
	 *  1.发送Send
	 * 创建DatagramSocket, 随机端口号
	 * 创建DatagramPacket, 指定数据, 长度, 地址, 端口
	 * 使用DatagramSocket发送DatagramPacket
	 * 关闭DatagramSocket
	 * @throws SocketException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws Exception {
		String str = "what are you doing?"; //相当于码头
		DatagramSocket socket = new DatagramSocket(9911);
		DatagramPacket packet =				//相当于集装箱
				new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 9900);
		socket.send(packet);
		socket.close();
	}

}
