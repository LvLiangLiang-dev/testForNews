package com.lll.basics.inherit;

/**
 * 用来测试静态的只会调用一次
 * 不管你新建几个对象，只会调用一次static代码块，
 *
 *
 * Created by lvliangliang on 2017/11/21.
 */
public class InitializationOrder {
    public static void main(String[] args) {
        Test1 temp=new Test1();
        Test1 temp1=new Test1();

    }
}
class Test1{
    static{
        System.out.println("test1 static block");
    }
    int i=0;

    public  Test1(){
        i++;
        System.out.println("test1 structure");
    }
    static void say(){
        System.out.println("say from static method");
    }

}
