import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-03-12 下午5:11
 */
public class MapTest {
    public static void main(String[] args) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("test1",new HashMapTest());
//            hashMap.put("test2",new SqlHelp());
            System.out.println(hashMap.keySet().toArray()[0]);
        StringLength stringLength = new StringLength();
        System.out.println(stringLength.getClass());
        if(stringLength.getClass() == (new StringLength().getClass())){
            System.out.println("same");
        }else {
            System.out.println("not");
        }

    }
}
