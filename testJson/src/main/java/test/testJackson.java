package test;

import com.fasterxml.jackson.databind.JavaType;
import org.json.JSONObject;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entiey.AccountBean;
import entiey.Birthday;
import entiey.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/6/1
 */
public class testJackson {
    private JsonGenerator jsonGenerator=null;
    private ObjectMapper objectMapper=null;
    private AccountBean accountBean=null;

    @Test
    public void t1() throws IOException {
        accountBean=new AccountBean();
        accountBean.setId(1);
        accountBean.setName("mark");
        accountBean.setEmail("mark@baidu.com");
        accountBean.setBirthday(new Birthday("2000-10-1"));
        objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(accountBean);
        System.out.println(json);


        AccountBean accountBean = objectMapper.readValue(json, AccountBean.class);
        System.out.println("string to bean:"+accountBean.toString());

    }
    @Test
    public void t2() throws JsonProcessingException {
        User user=new User();
        user.setAddress("beij");
        user.setAge(10);
        user.setName("jack");
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(user));
    }

    @Test
    public void t3() throws IOException {
        User user=new User();
        user.setAddress("beij");
        user.setAge(10);
        user.setName("jack");
        Map<String,User> map=new HashMap<>();
        map.put("temp",user);
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(map);
        System.out.println(string);
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(HashMap.class, String.class, User.class);
        HashMap<String,User> mapresult = objectMapper.readValue(string, javaType);
        System.out.println(mapresult.values());

    }

}
