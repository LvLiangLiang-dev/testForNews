package com.lll.designPattern.ResponsibilityChain;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/7/27
 */
public abstract class Handel {
    public Handel handel;
    public void setNextHandel(Handel handel){
        this.handel=handel;
    }
    public abstract void request(int request);
}
