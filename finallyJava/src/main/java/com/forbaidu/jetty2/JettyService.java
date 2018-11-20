package com.forbaidu.jetty2;

import org.eclipse.jetty.server.Server;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/2
 */
public class JettyService {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8989);
        server.setHandler(new TestController());
        server.start();
        server.join();
    }
}
