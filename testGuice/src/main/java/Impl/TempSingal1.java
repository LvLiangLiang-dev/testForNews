package Impl;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */

public class TempSingal1 {
    public String name;
    @Inject
    public  TempSingal1(@Assisted String name){
        this.name = name;
    }

//    @Inject
//    public void setName(@Named("NAME") String name){
//        this.name = name;
//    }
    public void work() {
        System.out.println("TempSingal1 begin" + name);
    }
}
