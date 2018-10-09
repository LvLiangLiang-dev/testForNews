package messPass;

import javafx.scene.chart.PieChart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2018-10-09 上午11:09
 */
public class Agent1 {
    public void work() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("temp1");
                try {
//                    new TableNameHive().settablename("agent1："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    new TableNameHive().settablename("agent1："+"test");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,5, TimeUnit.SECONDS);

    }
}
