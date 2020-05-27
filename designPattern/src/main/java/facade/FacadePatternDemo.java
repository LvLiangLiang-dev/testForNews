package facade;

/**
 * ${很容易理解，外观模式
 *  隐藏系统复杂性，给客户端提供一个可以访问系统的接口
 *  属于结构型设计模式
 *  提供了委托调用
 *  优点：减少系统相互依赖，提高灵活性，提高安全性
 *  缺点：不符合开闭原则，如果要改东西很麻烦，继承重写都不合适
 *
 *  在层次化结构中，可以通过外观模式来定义系统每一层的入口}
 *
 * @author lvliangliang
 * @create 2019-02-27 下午2:58
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
