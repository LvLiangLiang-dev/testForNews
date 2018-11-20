package com.lll.basics.inherit;

/**
 * Created by lvliangliang on 2017/11/19.
 */
public class Test {
    public static void main(String []args){
        new Circle();

        Shape1 shape1 = new Circle1();
        System.out.println(shape1.name1);
        shape1.printType();
        shape1.printName();
    }

    /**
     * 这是字符串和整形的转换
     * 可以使用valueOf，目的是谁，就是谁在前面。
     * 也可以使用parseFloat;parseDouble;等等。
     */
    public static void transfer() {
        String temp="12";
        int a=Integer.valueOf(temp);
        int b=Integer.parseInt(temp);
        System.out.println(a);

        int temp1=12;
        String a1=String.valueOf(temp1);
        System.out.println(a1);
    }
}


class Draw {
    public Draw(String type) {
        System.out.println(type+" draw constructor");
    }
}
/**
 * 构造函数是在成员变量之后初始化的。
 */
class Shape {
    private Draw draw = new Draw("shape");
    public Shape(){
        System.out.println("shape constructor");
    }
}
class Circle extends Shape {
    private Draw draw = new Draw("circle");
    public Circle() {
        System.out.println("circle constructor");
    }
//    public Circle(int length){
//        this.length=length;
//    }
}



class Shape1 {
    public String name1 = "shape1";

    public Shape1(){
        System.out.println("shape1 constructor");
    }

    public void printType() {
        System.out.println("this is shape1");
    }

    public static void printName() {
        System.out.println("shape1");
    }
}

class Circle1 extends Shape1 {
    public String name1 = "circle1";

    public Circle1() {
        System.out.println("circle1 constructor");
    }

    public void printType() {
        System.out.println("this is circle1");
    }

    public static void printName() {
        System.out.println("circle");
    }
}
