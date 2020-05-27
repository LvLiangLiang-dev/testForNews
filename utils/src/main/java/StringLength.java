/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-02-15 上午10:32
 */
public class StringLength {
    public static void main(String[] args) {
        test3();
    }

    private static void test1() {
        String temp="COMMAND   PID         USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME\n" +
                "java    23147 lvliangliang  218u  IPv6 0x160afa1e9906eb8d      0t0  TCP 172.24.174.62:8585 (LISTEN)";
        System.out.println(temp.length());
        String temp2="COMMAND   PID         USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME\n" +
                "java";
        System.out.println(temp2.length());
        String  result="";
        for(int i=85;i<93;i++){
            if(" ".equals(temp.substring(i,i+1))){
                System.out.println("i:"+i);
                result=temp.substring(85,i);
                break;
            }
        }
        System.out.println("result:"+result);
        int pid=Integer.valueOf(result);
        System.out.println(pid);
    }

    private static void test3() {
        String temp="x1";
        System.out.println(temp.substring(1,temp.length()));

    }

}
