package com.lll.basics.inherit;
/**
 * 非静态一般称为实例方法，必须实例化才能调用。
 * 静态方法可以直接通过类，也可以通过类调用。
 *
 * 同一个包内可以直接调用 别的类静态方法
 * 访问控制符。
 *
 * 都是接口，或者都是类，可以使用 extends继承
 * 否则，类实现接口用 implements
 *
 * Created by lvliangliang on 2017/11/21.
 */
public class InterfaceTest extends AbstractFisrst implements InterfaceFisrst{
    public static void main(String[] args) {
        InterfaceTest temp=new InterfaceTest();
        temp.drink();
        temp.eat();
        temp.play();
        shop();
    }

    @Override
    public void eat() {
        System.out.println("eat from interface");
    }
    @Override
    public void drink() {
        System.out.println("drink from interface");
    }
    public static void shop(){
        System.out.println("shop from static");
    }
    @Override
    public void play() {
        System.out.println("play from abstractfirst");
    }
}
