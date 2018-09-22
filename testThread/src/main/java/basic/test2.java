package basic;

/**
 * Created by lvliangliang on 2018/06/05.
 */
public class test2 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getContextClassLoader());
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
