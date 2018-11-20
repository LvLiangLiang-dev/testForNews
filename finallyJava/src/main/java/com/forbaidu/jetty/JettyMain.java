package com.forbaidu.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/3
 * Time: 18:24
 */
public class JettyMain {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8888);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
//        context.addServlet(new ServletHolder(new GetFileDownload()), "/getfiledownload");//文件下载服务(get)
//        context.addServlet(new ServletHolder(new PostFileDownload()), "/postfiledownload");//文件下载服务()post
        context.addServlet(new ServletHolder(new Helloworld()), "/helloworld");//helloworld
//        context.addServlet(new ServletHolder(new ParseParameter()), "/parseparameter");//解析URL参数
//        context.addServlet(new ServletHolder(new SendRedirect()), "/sendredirect");//重定向
//        context.addServlet(new ServletHolder(new UploadHandleServlet()), "/uploadhandleservlet");//文件上传服务
//        context.addServlet(new ServletHolder(new UploadHandleMessageServlet()), "/uploadhandlemessageservlet");//文件上传服务
        server.start();
        server.join();
    }
}

