package Impl;

import javax.inject.Named;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;

import entity.Person;
import module.MyAppMoudle;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */
public class PersonCaller {
    @Inject
    @Named("teacher")
    private Person teacher;
    @Inject
    @Named("student")
    private Person student;

    public void doTeacher() {
        teacher.say();
    }
    public void doStudent() {
        student.say();
    }
}