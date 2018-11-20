package com.forbaidu.jetty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/6
 * Time: 15:23
 * 重定向例子
 */
public class SendRedirect extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我要跳转到helloworld");
        response.sendRedirect("/helloworld");//使用这个方法（sendRedirect）【helloworld】接口得不到这个接口的request对象所有信息
    }
}
