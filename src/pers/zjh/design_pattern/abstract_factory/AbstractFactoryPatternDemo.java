package pers.zjh.design_pattern.abstract_factory;

/**
 * 抽象工厂模式：围绕一个超级工厂创建其他工厂，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 *
 * 主要解决：主要解决接口选择的问题。
 * 何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。
 * 如何解决：在一个产品族里面，定义多个产品。
 * 关键代码：在一个工厂里聚合多个同类产品。
 *
 * 优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
 * 缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。
 * 使用场景： 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。
 *
 * -- 创建型模式 --
 *
 * @author jinghui.zhu@luckincoffee.com
 * @date 2020/3/31 14:32:33
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {

        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.getShape("circle");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape("rectangle");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取形状为 Square 的对象
        Shape shape3 = shapeFactory.getShape("square");

        //调用 Square 的 draw 方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //获取颜色为 Red 的对象
        Color color1 = colorFactory.getColor("red");

        //调用 Red 的 fill 方法
        color1.fill();

        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("green");

        //调用 Green 的 fill 方法
        color2.fill();

        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("blue");

        //调用 Blue 的 fill 方法
        color3.fill();
    }
}
