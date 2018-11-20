package com.lll.testtry;

import java.net.*;
import java.io.*;
 
public class SocketServer extends Thread
{
   private ServerSocket serverSocket;
   
   public SocketServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(1000000);
   }
   //����socketserver��
   //���캯����ʵ����serversocket�࣬������ȥ�˿ںţ������� ͨ��ָ����ʱֵ����/���� SO_TIMEOUT���Ժ���Ϊ��λ��
   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +serverSocket.getLocalPort() + "...");
            //getLocalPort,���ش��׽��������������Ķ˿ڡ�
            Socket server = serverSocket.accept();
            //���������� ServerSocket ��� accept() �������÷�����һֱ�ȴ���ֱ���ͻ������ӵ��������ϸ����Ķ˿ڡ�
            //��һֱ�ȴ��������������У�֪��clientʵ����һ��socket����ͨ���˿ںͷ������������ӡ�
            System.out.println("Just connected to "+ server.getRemoteSocketAddress());
            //public SocketAddress getRemoteSocketAddress() ���ش��׽������ӵĶ˵�ĵ�ַ�����δ�����򷵻� null��
            
            DataInputStream in =new DataInputStream(server.getInputStream());
            //getInputStream   Returns:an input stream for reading bytes from this socket.
            System.out.println(in.readUTF());
            //readUTF  Returns:a Unicode string.
            
            
            DataOutputStream out =new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to "+ server.getLocalSocketAddress() + "\nGoodbye!");
            
            
            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      //int port = Integer.parseInt(args[0]);
	  int port=6066;
      try
      {
         Thread t = new SocketServer(port);
         t.start();
         //���˵��̣߳����̳�thread�࣬��дrun����������start�������������״̬��
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}