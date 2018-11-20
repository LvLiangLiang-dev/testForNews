package com.forbaidu.jetty;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/6
 * Time: 14:15
 */
public class Helloworld extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String msg = "Hello World!";

    public Helloworld() {
    }

    public Helloworld(String msg) {
        this.msg = msg;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>" + msg + "</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}
