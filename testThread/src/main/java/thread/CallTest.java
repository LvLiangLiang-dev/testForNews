package thread;

import java.util.concurrent.Callable;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/6/4
 */
public class CallTest implements Callable<String> {
    public String call() throws Exception {
        System.out.println("this is call");
        return "CALL";
    }
}
