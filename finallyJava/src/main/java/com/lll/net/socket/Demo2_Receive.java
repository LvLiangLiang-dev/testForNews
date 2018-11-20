package com.lll.net.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo2_Receive {

	/**
	 ** 2.����Receive
	 * ����DatagramSocket, ָ���˿ں�
	 * ����DatagramPacket, ָ������, ����
	 * ʹ��DatagramSocket����DatagramPacket
	 * �ر�DatagramSocket
	 * ��DatagramPacket�л�ȡ����
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(6666);		//����Socket�൱�ڴ�����ͷ
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);//����Packet�൱�ڴ�����װ��
		
		while(true) {
			socket.receive(packet);									//�ӻ�,��������
			
			byte[] arr = packet.getData();							//��ȡ����
			int len = packet.getLength();							//��ȡ��Ч���ֽڸ���
			String ip = packet.getAddress().getHostAddress();		//��ȡip��ַ
			int port = packet.getPort();							//��ȡ�˿ں�
			System.out.println(ip + ":" + port + ":" + new String(arr,0,len));
		}
	}

}
