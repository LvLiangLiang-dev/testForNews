/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package second.jaxrs;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckHandler extends AbstractHandler {
    private String body;

    public CheckHandler() {
        this("do check");
    }
    public CheckHandler(String body) {
        this.body = body;
    }
    public CheckHandler(String body, String body2) {
        this.body = body;
    }
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException, ServletException {
        System.out.println("begin");
        System.out.println(s);
        if (s.equals("/async-hello")) {
            System.out.println("pass");
        }else{
            System.out.println("canot go~");
            httpServletResponse.sendError(401,"it's wrong token");
        }
        System.out.println("end");
    }
}
