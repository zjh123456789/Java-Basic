package pers.zjh.object;

/**
 * @author jinghui.zhu
 * @description 反射测试类
 * @createTime 2022/7/12 2:11 PM
 */
public class Reflect {

    public static void main(String[] args) {

        Person person = new Person();
        person.setId(1);
        person.setAge(19);
        person.setName("无极剑圣");

        // 第一种 对象 getClass() 方法获取 Class 对象
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);

        // 第二种 类名 .class 获取 Class 对象
        System.out.println(Person.class);

        Class<?> aClass1 = null;
        try {
            // 第三种 通过包名全路径获取 Class 对象
            aClass1 = Class.forName("pers.zjh.object.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass1);
    }
}