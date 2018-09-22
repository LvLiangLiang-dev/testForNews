package entiey;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/6/1
 */
public class Birthday {
    private String birthday;

    public Birthday(String birthday) {
        super();
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public Birthday(){}
    public String toString(){
        return this.birthday;
    }
}
