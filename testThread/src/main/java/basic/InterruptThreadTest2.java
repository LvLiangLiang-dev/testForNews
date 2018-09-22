package basic;

/**
 * Created by lvliangliang on 2018/06/05.
 *  采用中断机制
 *  我们可以通过调用Thread.currentThread().isInterrupted()或者Thread.interrupted()来检测线程的中断标志是否被置位。
 *  这两个方法的区别是Thread.currentThread().isInterrupted()是线程对象的方法，
 *  调用它后不清除线程中断标志位；而Thread.interrupted()是一个静态方法，调用它会清除线程中断标志位。
 */
public class InterruptThreadTest2 extends Thread {
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            long beginTime=System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() +" is running");
//            while (System.currentTimeMillis() - beginTime < 1000) {
//                System.out.println(Thread.currentThread().isInterrupted());
//            }
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    public static void main(String[] args) {
        InterruptThreadTest2 interruptThreadTest2=new InterruptThreadTest2();
        interruptThreadTest2.start();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().isInterrupted());
        interruptThreadTest2.interrupt();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().isInterrupted());

    }
}
