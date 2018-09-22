package method;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/6/13
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin1=new TestJoin("MARK");
        TestJoin testJoin2=new TestJoin("JANE");
        testJoin1.start();
//        testJoin1.join();
        testJoin2.start();
    }
}
