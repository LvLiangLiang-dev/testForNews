package messPass;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2018-10-09 上午11:17
 */
public class Agent2 {
    public void work() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.print("temp2 ");
                try {
                    System.out.println(new TableNameHive().gettablename());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,5, TimeUnit.SECONDS);

    }
}
