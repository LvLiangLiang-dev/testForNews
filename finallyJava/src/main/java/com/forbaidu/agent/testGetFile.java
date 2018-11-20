package com.forbaidu.agent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/13
 */
public class testGetFile {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/mysql.properties"));
        System.out.println(fileInputStream);
    }
}
