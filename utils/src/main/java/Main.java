import temp.EnclaveInfo;
import temp.Temp;
import temp.param;
import temp.temp2;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-03-29 下午1:25
 */
public class Main {
    public static void main(String[] args) {

        test2();
    }

    private static void test3() {
        temp2 temp =new temp2();
        temp.setAppid("fuck");
        temp.setAppname("1450a0e8-b29c-4bd4-9dd9-e506f40ca337");
        System.out.println(GsonUtil.toJson(temp));

    }

    private static void test2() {
        Temp temp = new Temp();
        param param = new param();
        param.setMetaserver("http://10.94.168.242:8082/metadata/getLastVer");
        param.setInput("[{\"datasetQName\":\"/ns3/urls/bbb6\", \"storage\": {\"type\":\"hdfs\",\"arguments\": {\"ak\": \"xxx\",\"sk\": \"xxx\",\"bucket\": \"\",\"endpoint\": \"172.19.62.9\", \"path\":\"/tmp/datatest/cdata/test2\" }}}]");
        param.setSql("select substring(word, 1, 4) from ns3_urls_bbb6");
        param.setPartyNum(2);
        param.setOutput("[{\"userId\":\"sssss\" , \"storage\": {\"type\":\"hdfs\",\"arguments\": {\"ak\": \"xxx\",\"sk\": \"xxx\",\"bucket\": \"\",\"endpoint\": \"172.19.62.9\", \"path\":\"/tmp/datatest/result101\" }} }]");

        temp.setParam(param);
        temp.setCallback("callback");

        System.out.println(GsonUtil.toJson(temp));
    }

    private static void test1() {
        EnclaveInfo enclaveInfo = new EnclaveInfo();
        enclaveInfo.setIp("172.19.62.9");
        enclaveInfo.setPort(8808);
        enclaveInfo.setEid(11);
        enclaveInfo.setId(1);
        enclaveInfo.setStatus(1);

        System.out.println(GsonUtil.toJson(enclaveInfo));
    }
}
