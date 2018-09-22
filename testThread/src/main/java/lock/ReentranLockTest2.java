package lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lvliangliang on 2018/06/05.
 *  ReentrantLock持有一个所计数器，当已持有所的线程再次获得该锁时计数器值加1，
 *  每调用一次lock.unlock()时所计数器值减一，直到所计数器值为0，此时线程释放锁。
 */
public class ReentranLockTest2 {
    private ReentrantLock mylock=new ReentrantLock();
    public void testReentrantLock(){
        mylock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" get lock" );
            long beginTime=System.currentTimeMillis();
            while(System.currentTimeMillis()-beginTime<100){}
            mylock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get lock again");
                long beginTime2 = System.currentTimeMillis();
                while(System.currentTimeMillis() - beginTime2 < 100){}
            }finally {
                mylock.unlock();
                System.out.println(Thread.currentThread().getName() + " release lock");
            }
        }finally {
            mylock.unlock();
            System.out.println(Thread.currentThread().getName() + " release lock again");
        }
    }


    public static void main(String[] args) {
        final ReentranLockTest2 reentranLockTest2=new ReentranLockTest2();
        Thread thread=new Thread(new Runnable() {
            public void run() {
                reentranLockTest2.testReentrantLock();
            }
        },"A:");
        thread.start();

    }

}


