package com.forbaidu.jackson;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JackDemo {
    public static void main(String[] args) throws IOException {
        user user=new user();
        user.setName("xiaoming");
        user.setAge(10);
        user.setBirthday(1001);
        user.setEmail("lll.@163.com");


        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        //User类转JSON
        String json=mapper.writeValueAsString(user);
        System.out.println(json);
        //Java集合转JSON
        List<user> list=new ArrayList<>();
        list.add(user);
        String json1=mapper.writeValueAsString(list);
        System.out.println(json1);
        //* ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
        String json2 = "{\"name\":\"小民\",\"age\":20,\"birthday\":8440,\"email\":\"xiaomin@sina.com\"}";
        ObjectMapper mapper1 = new ObjectMapper();
        com.forbaidu.jackson.user user1 = mapper1.readValue(json2, user.getClass());
        System.out.println(user1);

        //json注解，方便对json就行序列化和反序列化。
        User2 user2 = new User2();
        user2.setAge(10);
        user2.setUsername("xiaowang");
//        user2.setBirthday(2000-10-01);
        ObjectMapper mapper2 = new ObjectMapper();
        String json3 = mapper2.writeValueAsString(user2);
        System.out.println(json3);

    }
}
