package com.lll.testtry; /**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time��2017��5��4�� ����4:25:55
* class illustration:
*/
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.net.HttpURLConnection;

public class TestConcurrent {
	int i=0;
	public static void main(String args[]){
		
		ThreadPoolExecutor executor=new ThreadPoolExecutor(200,210,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));
		for(int i=0;i<50;i++){
			MTask mtask=new MTask(i);
			executor.execute(mtask);
			System.out.println("�̳߳��߳���Ŀ��"+executor.getPoolSize());
			//System.out.println("�ȴ��߳���Ŀ�� "+executor.getQueue().size());
			//System.out.println("��ִ������������Ŀ��"+executor.getCompletedTaskCount());
			//System.out.println("the i is "+i+"flag is"+mtask.flag);
			//System.out.println("failure is "+mtask.FailureNum);
		
		}
	    
		
	}

}
class MTask implements Runnable{
	public boolean flag=false;
	public  static int FailureNum=0;
	private int tasknum;
	public MTask(int num){
		this.tasknum=num;
	}
	public void run(){
		System.out.println("the thread "+tasknum+"  is running");
		try{
			URL url=new URL("http://localhost:6066/");
			URLConnection connection=url.openConnection();
			HttpURLConnection httpco=(HttpURLConnection)connection;
			int code=httpco.getResponseCode();
            flag = code == 200;
			
		}catch(Exception e){
			System.out.println("error:"+e.getMessage());
			FailureNum++;
		}
		System.out.println(tasknum+" thread is over");
		System.out.println("failure is "+FailureNum);
	}
}
