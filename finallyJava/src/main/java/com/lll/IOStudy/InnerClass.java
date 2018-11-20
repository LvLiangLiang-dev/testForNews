package com.lll.IOStudy;

/**
 * 内部类的一些测试。
 * Created by lvliangliang on 2017/11/21.
 */
public class InnerClass {
    private String name="outer";
    public static void main(String[] args) {
        InnerClass innerClass=new InnerClass();

        Inner inner=innerClass.new Inner();
        SInner sInner=new SInner();

        inner.pp("test");
        inner.show();
        sInner.show();

        innerClass.show();

    }

    /**
     * 这是成员内部类，也称之为普通内部类。
     *
     * 内部类方法可以访问外部类的成员变量，而不受访问控制符的控制，private也可以访问。
     * 相反的，外部类不能直接访问内部类的成员和方法，必须先创建内部类对象才行。
     * 如果内部类有和外部类一样的方法和变量，默认是访问内部类的，如果要访问外部类的，可以使用this关键字。
     *
     * 定义了成员内部类之后，必须使用外部类对象来创建内部类对象，不能直接new一个内部类对象
     * 即：内部类 对象名=外部类。new 内部类对象名（）；
     */
    public class Inner{
         String name="inner";
         public void show(){
             System.out.println(InnerClass.this.name);
             System.out.println(name);
         }
        public void pp(String str){
            System.out.println(str);
        }
    }

    /**
     * 这是静态内部类
     *
     * 调用外部类的变量，要先new一个外部类对象。
     * 可以试想一下，因为静态是先加载的，而外部类不是静态的，所以不许要实例化外部类才能调用外部类的变量。
     *
     * 在外部类调用静态内部类时，要先实例化，不过不用通过外部类实例化，因为他是静态的，所以可以自己实例化。
     */
    public static class SInner{
        String name="sinner";
        public void show(){
            System.out.println("sinner.name="+name);
            System.out.println("outer.name="+new InnerClass().name);
        }
    }

    /**
     * 这是方法内部类
     * 只能在该方法内使用，只在该方法内部可见~~
     *     thread中多次使用这种方法内部类。
     * 不能使用访问控制符，static来修饰！！
     */
    public void show(){
        String name1="name_here";
        class MInner{
            String name="MInner";
            public void print(){
                System.out.println("MInner name="+name);
                System.out.println("Outre name="+  name1 );
            }
        }
        MInner mInner=new MInner();
        mInner.print();
    }
}
