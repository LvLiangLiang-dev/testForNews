package com.lll.designPattern;

public class model {
    public static void main(String[] args) {
        SingleDemo1 temp=SingleDemo1.getInstance();
        SingleDemo1 temp2=SingleDemo1.getInstance();
        SingleDemo2 temp3=SingleDemo2.getInstance();
        SingleDemo2 temp4=SingleDemo2.getInstance();
    }
}
//饿汉模式
//最简单的一种实现方式，饿汉模式在类加载的时候进行创建，实例在整个周期都存在，
//好处是只在类加载的时候创建一次实例，不会存在多个线程创建多个实例的情况，避免了多线程的同步的问题，
//缺点也很明显，就是在整个单例没有被用的时候也会被创建
class SingleDemo1{
    private static int i=0;
    private static SingleDemo1 instance =new SingleDemo1();
    private SingleDemo1(){
        i++;
        System.out.println("饿汉式被创建"+i);
    };
    //private : 私有成员, 在类的内部才可以访问。
    public static SingleDemo1 getInstance(){
        return instance;
    }

}
//懒汉模式
//需要的时候在创建实例
class SingleDemo2{
    private static SingleDemo2 singleDemo2=null;
    private SingleDemo2(){
        System.out.println("懒汉式被创建");
    }
    public static  SingleDemo2 getInstance(){
        if(null==singleDemo2)singleDemo2=new SingleDemo2();
        return singleDemo2;
    }
}
//虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。
// 因为在任何时候只能有一个线程调用 getInstance()方法。
// 但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。这就引出了双重检验锁。
class SingleDemo2_1{
    private static SingleDemo2_1 singleDemo2_1=null;
    private SingleDemo2_1(){};

    public static synchronized SingleDemo2_1 getSingleDemo2_1() {
        if(null==singleDemo2_1)singleDemo2_1=new SingleDemo2_1();
        return singleDemo2_1;
    }
}
//双重检验锁
class SD2_2{
    private volatile static SD2_2 sd2_2;
    private SD2_2(){}
    public static SD2_2 getSd2_2(){
        if(null==sd2_2){
            synchronized(SD2_2.class){
                if(null==sd2_2)
                    sd2_2=new SD2_2();

            }
        }
        return sd2_2;
    }
}
//静态内部类
class SD2_3{
    private SD2_3(){};
    private static class ssss{
        private static final ssss instance =new ssss();
    }
    public static final ssss getSD2_3(){
        return ssss.instance;
    }
}




















//工厂模式
//简单工厂


