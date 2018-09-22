package Impl;

import javax.inject.Inject;

import entity.Application;
import entity.LogService;
import entity.UserService;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */
public class MyApp implements Application {
    private UserService userService;
    private LogService logService;
    @Inject
    public MyApp(UserService userService, LogService logService){
        this.userService=userService;
        this.logService=logService;
    }
    public void work() {
        userService.process();
        logService.log("running normal");
    }
}
