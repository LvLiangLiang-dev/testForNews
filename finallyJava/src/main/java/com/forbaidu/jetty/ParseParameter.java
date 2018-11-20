package com.forbaidu.jetty;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/6
 * Time: 14:59
 * <p>
 * 解析url参数
 */

public class ParseParameter extends HttpServlet {

    private String enc = "utf-8";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding(enc);
        /**
         * 获取所有请求参数，封装到Map中
         */
        Map<String, String[]> map = (Map<String, String[]>) request.getParameterMap();
        for (String name : map.keySet()) {
            String[] values = map.get(name);
            System.out.println(name + "=" + Arrays.toString(values));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding(enc);
        /**
         * 获取所有请求参数，封装到Map中
         */
        Map<String, String[]> map = (Map<String, String[]>) request.getParameterMap();
        for (String name : map.keySet()) {
            String[] values = map.get(name);
            System.out.println(name + "=" + Arrays.toString(values));
        }
    }
}
