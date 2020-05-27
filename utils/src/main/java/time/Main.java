package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-04-10 上午10:35
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String format1 = df.format(new Date());// new Date()为获取当前系统时间
        Thread.sleep(4000);
        String format2 = df.format(new Date());// new Date()为获取当前系统时间
        System.out.println("1:"+format1);
        System.out.println("2:"+format2);

        Date parse2 = df.parse(format2);
        Date parse1 = df.parse(format1);
        long idf = parse2.getTime()-parse1.getTime();
        System.out.println("idf:"+idf);

        System.out.println("sttus;"+getStatus(1));



    }
    public static String getStatus(int  status) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String format = df.format(new Date());// new Date()为获取当前系统时间
        return String.valueOf(status)+","+format;
    }
}
