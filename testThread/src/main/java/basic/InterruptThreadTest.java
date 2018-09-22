package basic;

/**
 * Created by lvliangliang on 2018/06/05.
 *     中断非阻塞线程
 *     1：采用线程共享变量
 *      这种方式比较简单，就是共享变量必须使用volatile，这样才能保证修改后其他线程立即可见。
 */
public class InterruptThreadTest extends  Thread {
    volatile boolean isStop=false;
    public void run(){
        while(!isStop){
            long beginTime=System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"is running");
            while(System.currentTimeMillis()-beginTime<1000){ }
        }
        if(isStop){
            System.out.println(Thread.currentThread().getName() +"is interrupted");
        }
    }

    public static void main(String[] args) {
        InterruptThreadTest itt=new InterruptThreadTest();
        itt.start();
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itt.isStop=true;
    }

}
