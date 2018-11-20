package com.lll.net.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo2_Send {

	/**
	 * * 1.����Send
	 * ����DatagramSocket, ����˿ں�
	 * ����DatagramPacket, ָ������, ����, ��ַ, �˿�
	 * ʹ��DatagramSocket����DatagramPacket
	 * �ر�DatagramSocket
	 * @throws SocketException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);						//��������¼�����
		DatagramSocket socket = new DatagramSocket();				//����Socket�൱�ڴ�����ͷ
		
		while(true) {
			String line = sc.nextLine();							//��ȡ����¼����ַ���
			if("quit".equals(line)) {
				break;
			}

			DatagramPacket packet = 								//����Packet�൱�ڼ�װ��
					new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
			socket.send(packet);									//����,�����ݷ���ȥ
		}
		socket.close();												//�ر���ͷ
	}

}
