package test;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entiey.AccountBean;
import entiey.Birthday;
import entiey.User;

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
    public void t1() throws JsonProcessingException {
        accountBean=new AccountBean();
        accountBean.setId(1);
        accountBean.setName("mark");
        accountBean.setEmail("mark@baidu.com");
        accountBean.setBirthday(new Birthday("2000-10-1"));
        objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(accountBean);
        System.out.println(json);
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

}
