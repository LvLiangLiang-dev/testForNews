package com.lll.designPattern;

/**
 * 简单工厂模式
 *      又称为静态工厂模式
 *      目的很简单：定义一个用来创建对象的接口。
 *
 * 工厂方法模式
 * <p>
 * 抽象工厂模式
 */
public class factory {
    public static void main(String[] args) {
        //作为简单工厂模式的客户
        //通过调用工厂类，避免了直接和产品类接触但是能得到产品。
        //因为开闭原则（对扩展开发，对修改关闭）发现工厂类不够封闭。
        BMWFactory bmwFactory = new BMWFactory();
        BMW bmw123 = bmwFactory.getBMW(123);
        BMW bmw456 = bmwFactory.getBMW(456);

        //工厂方法模式
        //去掉了简单工厂模式中的工厂方法的静态属性，使得子类可以被子类继承。
        //这样在简单工厂模式里集中在工厂方法上的压力可以由工厂方法模式里不同的工厂子类来分担。
        BMW123Factory1 bmw123Factory1 = new BMW123Factory1();
        BMW bmw = bmw123Factory1.getBMW();
        BMW bmw1 = bmw123Factory1.getBMW();
    }
}

abstract class BMW {
    public BMW() {
    }
}

class BMW123 extends BMW {
    public BMW123() {
        System.out.println("make BMW123");
    }
}

class BMW456 extends BMW {
    public BMW456() {
        System.out.println("make BMW456");
    }
}

class BMWFactory {
    public BMW getBMW(int type) {
        switch (type) {
            case 123:
                return new BMW123();
            case 456:
                return new BMW456();
            default:
                break;
        }

        return null;
    }
}

interface BMWFactory1{
    BMW getBMW();
}
class BMW123Factory1 implements BMWFactory1{

    @Override
    public BMW getBMW() {
        return  new BMW123();
    }
}
class BMW456Factory1 implements BMWFactory1{
    @Override
    public BMW getBMW() {
        return new BMW456();
    }
}