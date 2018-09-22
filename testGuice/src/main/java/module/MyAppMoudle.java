package module;

import javax.inject.Named;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.name.Names;

import Impl.LogServiceImpl;
import Impl.MyApp;
import Impl.Student;
import Impl.Teacher;
import Impl.TempImpl;
import Impl.UserServiceImpl;
import entity.Application;
import entity.LogService;
import entity.Person;
import entity.Temp;
import entity.UserService;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 *  这个绑定还可以进行链式绑定，就是写俩个bind，链式的。
 *
 * @DATE: 2018/5/18
 */
public class MyAppMoudle extends AbstractModule {
    protected void configure() {
        bind(LogService.class).to(LogServiceImpl.class);
        bind(UserService.class).to(UserServiceImpl.class);
        bind(Application.class).to(MyApp.class);
        bind(Temp.class).to(TempImpl.class);

        bind(Person.class).annotatedWith(Names.named("teacher")).to(Teacher.class);
        bind(Person.class).annotatedWith(Names.named("student")).to(Student.class);
    }
}
