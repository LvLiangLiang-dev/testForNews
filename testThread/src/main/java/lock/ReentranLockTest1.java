package lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by lvliangliang on 2018/06/05.
 *
 *  把解锁操作括在finally字句之内是至关重要的，如果受保护的代码抛出异常，锁可以得到释放，这样可以避免死锁的发生
 *  输出结果是显式锁很好的保护了 writeNumMethod 的操作，假设线程A在执行结束前被剥夺了运行权，
 *  这是线程B调用readNumMethod方法去读取num的值，但是由于线程B不能获得锁，线程B必须等待线程A释放锁才能执行readNumMethod方法。
 *  这样就保证了writeNumMethod方法的原子性，也就保证了共享变量num不会出现讹误的现象。
 */
public class ReentranLockTest1 {
    private int num=10;
    private ReentrantLock mylock=new ReentrantLock();
    public void writeNumMethod(){
//        mylock.lock();
        try {
            int index = 10;
            while (index > 0) {
                System.out.println(Thread.currentThread().getName() + ": " + num);
                num = num - 10;
                long beginTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - beginTime < 1000) {
                }
                num = num + 10;
                System.out.println(Thread.currentThread().getName() + ": " + num);
                index--;
            }
        }finally{
//                mylock.unlock();
            }
    }
    public void readNumMethod(){
//        mylock.lock();
        try{
            int index=10;
            while (index>0){
                System.out.println(Thread.currentThread().getName()+": "+num);
                index--;
            }
        }finally {
//            mylock.unlock();
        }
    }

    public static void main(String[] args) {
        final  ReentranLockTest1 reentranLockTest1=new ReentranLockTest1();
        Thread t1=new Thread(new Runnable() {
            public void run() {
                reentranLockTest1.writeNumMethod();
            }
        },"A");
        Thread t2=new Thread(new Runnable() {
            public void run() {
                reentranLockTest1.readNumMethod();
            }
        },"B");
        t1.start();
        t2.start();
    }

}


