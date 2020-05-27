import javax.inject.Named;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import Impl.PersonCaller;
import Impl.TempSingal1;
import Impl.TestFactory;
import entity.Application;
import entity.Temp;
import module.MyAppMoudle;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */
public class MyAppTest {
    private static Injector inject;
    /**
     * guice配置完之后，需要调用createjector方法传入配置类来创建一个注入器，然后用getinstance来获取目标累
     */
    @BeforeClass
    public static void init(){
        inject= Guice.createInjector(new MyAppMoudle());
    }

    /**
     * 这个注入了
     *  在构造函数中，注入构造函数的参数的实现类，这样下面调用的方法其实是注入的是实现类的方法
     *
     */
    @Test
    public void testMyApp(){
        Application application=inject.getInstance(Application.class);
        application.work();
    }

    /**
     * 这个没有注入，只是在module中绑定了一下，然后就直接调用inject的得到实例方法得到实现类
     */
    @Test
    public void testTemp(){
        Temp temp=inject.getInstance(Temp.class);
        temp.work();
    }

    @Test
    public void testMoreImpl(){
        PersonCaller personCaller=inject.getInstance(PersonCaller.class);
        personCaller.doStudent();
        personCaller.doTeacher();
    }

//    @Inject @Named("NAME")
//    private TempSingal1 tempSingal1;



    @Test
    public void testMoreImpl11(){
//        TempSingal1 instance = inject.getInstance(TempSingal1.class);
//        tempSingal1.work();
        TestFactory instance = inject.getInstance(TestFactory.class);
        TempSingal1 tempSingal1 = instance.create(" xx");
        tempSingal1.work();
    }

//    @Test
//    public void testMoreImpl11(){
//        //        TempSingal1 instance = inject.getInstance(TempSingal1.class);
//        //        tempSingal1.work();
//        TempSingal1 instance = inject.getInstance(TempSingal1.class);
//        instance.work();
//    }
}
