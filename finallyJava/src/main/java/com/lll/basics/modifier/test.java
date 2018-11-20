package com.lll.basics.modifier;

import org.junit.Test;

/**
 * 这节讲的主要是修饰符
 *     访问修饰符
 *      适用范围<访问权限范围越小，安全性越高>
 * 　　　　  访问权限   类   包  子类  其他包
 *   　　　　  public     ∨   ∨    ∨     ∨          （对任何人都是可用的）
 *    　　　　 protect    ∨   ∨   ∨     ×　　　 （继承的类可以访问以及和private一样的权限）
 *    　　　　 default    ∨   ∨   ×     ×　　　 （包访问权限，即在整个包内均可被访问）
 *    　　　　 private    ∨   ×   ×     ×　　　 （除类型创建者和类型的内部方法之外的任何人都不能访问的元素）
 *      protect、private不能修饰类、接口
 *
 *
 *    访问继承和控制
 *      父类中声明为 public 的方法在子类中也必须为 public。
 *      父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
 *      父类中声明为 private 的方法，不能够被继承。
 *
 *    非访问修饰符
 *      为了实现一些其他的功能，Java 也提供了许多非访问修饰符。
 *          static 修饰符，用来修饰类方法和类变量。
 *          final 修饰符，用来修饰类、方法和变量，final 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
 *          abstract 修饰符，用来创建抽象类和抽象方法。
 *          synchronized 和 volatile 修饰符，主要用于线程的编程。
 *      static：
 *          静态变量：
 *              static 关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。
 *              静态变量也被称为类变量。局部变量不能被声明为 static 变量。
 *                  Java语言支持的变量类型有：
 *                      类变量：独立于方法之外的变量，用 static 修饰。
 *                      实例变量：独立于方法之外的变量，不过没有 static 修饰。
 *                      局部变量：类的方法中的变量。
 *          静态方法：
 *              static 关键字用来声明独立于对象的静态方法。静态方法不能使用类的非静态变量。
 *              静态方法从参数列表得到数据，然后计算这些数据。
 *              子类可以继承父类的静态方法，但是不能覆盖，因为静态方法在编译时确定了，不能多态，也就是不能运行时绑定。
 *      final:
 *          一个保留的关键字，一旦将引用声明为final，你将不能改变这个引用，编译器会改变代码。
 *          变量：
 *              final 变量能被显式地初始化并且只能初始化一次。
 *              final 修饰符通常和 static 修饰符一起使用来创建类常量。
 *              final变量是只读的。
 *          方法：
 *              方法前面加上这个关键字，代表这个方法不可以被子类的方法重写。
 *              如果你认为一个方法的功能已经足够完整了，子类中不需要改变的话，你可以声明此方法为final。
 *              final方法比非final方法要快，因为在编译的时候已经静态绑定了，不需要在运行时再动态绑定。
 *
 *              允许编译器将所有对此方法的调用转化为inline调用机制，它会使你在调用final方法时，直接将方法主体插入到调用处，
 *              而不是进行例行的方法调用，例如保存断点，压栈等，这样可能会使你的程序效率有所提高，
 *              然而当你的方法主体非常庞大时，或你在多处调用此方法，那么你的调用主体代码便会迅速膨胀，可能反而会影响效率，
 *              所以你要慎用final进行方法定义。
 *
 *          类：
 *              final类通常功能是完整的，它们不能被继承。
 *              Java中有许多类是final的，譬如String, Interger以及其他包装类。
 *          好处：
 *              final关键字提高了性能，jvm和java应用都会缓存final变量。
 *              final变量可以安全的在多线程的环境下共享，而不需要额外的同步开销。
 *              使用final关键字，jvm会对方法，变量，类就行优化
 *
 *              不可变类：
 *                  创建不可变类要使用final关键字，不可变类指的是他的对象一旦被创建时就不能更改了，
 *                  string是不可变类的代表。
 *                  不可变类有很多好处，比如他们的对象是只读的，可以在多线程的环境下共享，不用额外的
 *                  同步开销。
 *      abstract：
 *          抽象类：
 *              不能用来实例化对象，声明抽象类的目的就是为了将来对该类就行扩充。
 *              一个类不能同时被abstract和final修饰，如果一个类有抽象方法，那么该类一定要声明为抽象类，否则会出现编译错误。
 *              抽象类可以包含抽象方法和非抽象方法。
 *          抽象方法：
 *              一种没有任何实现的方法，该方法的具体实现由子类提供。
 *              抽象方法不能被声明为final和static。
 *              任何继承抽象类的子类必须实现父类所有的抽象方法，除非他也是抽象类。
 *
 *          如果一个类有抽象方法，那么他一定是抽象类；如果一个类是抽象类，他可以没有抽象方法。
 *      synchronized：
 *          synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。
 *      transient：
 *          序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。
 *          该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。
 *      volatile：
 *          volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。
 *          而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。
 *          这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
 *          一个 volatile 对象引用可能是 null。
 *
 *
 *
 *
 *
 *
 *
 */
public class test {
    public static void main(String[] args) {
        temp temp=new temp();
        temp.staticTest();
        temp.staticTest();
        temp5 temp5=new temp5();
        temp5.test4();

        String a="jjj";
        final int a1=10;
//        a1=11;    只能被初始化一次
        System.out.println(a1);

    }
    @Test
    void test2(){
        temp.staticTest2();
        temp.staticTest2();
    }
}
class temp{
    public static int num = 0;
    public void staticTest() {
        num++;
        System.out.println("num: "+num);
    }
    static void staticTest2(){
        int num2=0;
        num2++;
        System.out.println("num2: "+num2);
    }

    public final void finalTest() {
        System.out.println("this is final method");
    }
}
class temp2 extends temp{
    @Override
    public void staticTest() {
        super.staticTest();
    }
//    public final void finalTest(){ }
//    final 方法不能被重写
}
final class temp3{
}
abstract class temp4{
    public void test4(){
        System.out.println("this is temp4 class");
    }
}
class temp5 extends temp4{
    @Override
    public void test4() {
        super.test4();
    }
}
