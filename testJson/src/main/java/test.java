import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-01-25 下午3:23
 */
public class test {

    public static void main(String[] args) {

    }
    @Test
    public void test1(){
        java.util.Date date = new java.util.Date();
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        System.out.println(dateSql);

        Date date1 = new Date();
        Timestamp currentTime1 = new Timestamp(date.getTime());
        System.out.println("currentTime1:"+currentTime1);

    }
}
