import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-02-18 下午3:47
 */
public class HashMapTest {
    public static void main(String[] args) {
        test1();

    }

    private static void test1() {
        Map<String, Integer> taskMananger = new ConcurrentHashMap<>();
        taskMananger.put("test",1);
        taskMananger.put("test2",2);
        taskMananger.put("test3",3);
        int flag=0;
        for(int i:taskMananger.values()){
            System.out.println("i:"+i);
            if(i>flag)flag=i;
        }
        System.out.println("flag:"+flag);


    }
}
