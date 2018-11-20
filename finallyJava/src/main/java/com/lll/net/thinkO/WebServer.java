package com.lll.net.thinkO;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time��2017��4��27�� ����9:34:05
* class illustration
*/
import java.io.*;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.net.ServerSocket;
import java.net.InetAddress;


public class WebServer {
	public int countthread=0;
	public static void main(String []args){
		WebServer server=new WebServer();
		server.istart();
	}
	public void istart(){
		ServerSocket serversocket=null;
		int port=6066;
		int backlog=1;
		int i=0;
		ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
		
		try{
			serversocket=new ServerSocket(port,backlog,InetAddress.getByName("127.0.0.1"));
			
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		while(true){
			Socket socket=null;
			//InputStream input=null;
			//OutputStream output=null;
			
			
			
			try{
				socket=serversocket.accept();
				Task task=new Task(i,socket);
				i=i+1;
				System.out.println("i="+i);
				executor.execute(task);
				
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}

}

class Task implements Runnable{
	private int tasknum;
	private Socket socket=null;
	
	public  Task(int num,Socket temp){
		this.tasknum=num;
		this.socket=temp;
	}
	
	public void run(){
		InputStream input=null;
		OutputStream output=null;
		//int count=0;
		try{
			input=socket.getInputStream();
			output=socket.getOutputStream();
			Request request=new Request(input);
			request.parse();
			
			Response response=new Response(output);
			response.setRequest(request);
			response.sendStaticResource();
			
			socket.close();
			System.out.println("count=");
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
