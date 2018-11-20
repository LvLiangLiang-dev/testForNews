package com.lll.testtry;

import java.net.*;
import java.io.*;
 
public class SocketClient
{
   public static void main(String [] args)
   {
      //String serverName = args[0];
      //int port = Integer.parseInt(args[1]);
      String serverName="localhost";
	  int port=6066;
      try
      {
         System.out.println("Connecting to " + serverName+ " on port " + port);
         Socket client = new Socket(serverName, port);
         //�ͻ��˽���socketʵ��
         System.out.println("Just connected to "+ client.getRemoteSocketAddress());
         
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =new DataOutputStream(outToServer);
         out.writeUTF("Hello from "+ client.getLocalSocketAddress());
         
         //new DataOutputStream(new Socket(serverName, port).getOutputStream()).writeUTF("Hello from "+ client.getLocalSocketAddress());
         //�������Ƕ�׵��ã��Ƚϸ���
         
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
         
        // boolean isConnection=Socket.isConnected();
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}