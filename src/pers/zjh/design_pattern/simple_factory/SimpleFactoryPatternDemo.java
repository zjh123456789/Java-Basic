package pers.zjh.design_pattern.simple_factory;

/**
 * 简单工厂模式：又称静态工厂方法模式，可根据参数的不同返回不同类的实例
 *
 * 优点：客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可，对于一些复杂的类名，通过简单工厂模式可以在一定程度减少使用者的记忆量。
 *      通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性。
 * 缺点：由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都要受到影响。
 *      使用简单工厂模式势必会增加系统中类的个数（引入了新的工厂类），增加了系统的复杂度和理解难度。
 *      系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护，且违背开闭原则。
 * 适用场景：工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
 *          客户端只知道传入工厂类的参数，对于如何创建对象并不关心。
 *
 * -- 创建型模式 --
 *
 * @author jinghui.zhu@luckincoffee.com
 * @date 2019/5/14 17:27
 */
public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {
        // 获取 “狗” 对象，并调用它的 sound 方法
        Animal animal1 = AnimalFactory.createAnimal("Dog");
        animal1.sound();

        // 获取 “猫” 对象，并调用它的 sound 方法
        Animal animal2 = AnimalFactory.createAnimal("Cat");
        animal2.sound();

        // 获取 “青蛙” 对象，并调用它的 sound 方法
        Animal animal3 = AnimalFactory.createAnimal("Frog");
        animal3.sound();
    }

}
