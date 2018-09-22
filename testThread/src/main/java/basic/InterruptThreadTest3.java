package basic;

/**
 * Created by lvliangliang on 2018/06/05.
 *
 *  当线程调用Thread.sleep()、Thread.join()、object.wait()再或者调用阻塞的i/o操作方法时，都会使得当前线程进入阻塞状态。
 *  那么此时如果在线程处于阻塞状态是调用interrupt() 方法设置线程中断标志位时会出现什么情况呢！
 *  此时处于阻塞状态的线程会抛出一个异常，并且会清除线程中断标志位(设置为false)。
 */

/**
 需要注意的地方就是 Thread.sleep()、Thread.join()、object.wait()这些方法，会检测线程中断标志位，
 如果发现中断标志位为true则抛出异常并且将中断标志位设置为false。
 所以while循环之后每次调用阻塞方法后 都要在捕获异常之后，调用Thread.currentThread().interrupt()重置状态标志位。
 */
public class InterruptThreadTest3 extends Thread {
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() +" is running");
            try{
                System.out.println(Thread.currentThread().getName() + "Thread sleep begin");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "Thread sleep end  ");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    public static void main(String[] args) {
        InterruptThreadTest3 interruptThreadTest2=new InterruptThreadTest3();
        interruptThreadTest2.start();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptThreadTest2.interrupt();
    }
}
