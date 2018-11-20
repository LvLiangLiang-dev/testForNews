package com.forbaidu.jetty2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/2
 */
public class TestController extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println(target);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        PrintWriter out = response.getWriter();
        if(target.equals("/favicon.ico"))
        {
            System.out.println(1);
            out.println("404");
        }
        else
        {
            System.out.println(2);
            out.println("hello jetty");
            if(request.getParameter("name")!=null)
            {
                out.println(request.getParameter("name"));
            }
        }

    }
}
