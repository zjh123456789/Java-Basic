package pers.zjh.object;

import java.util.ArrayList;
import java.util.List;

/**
 * string 测试方法
 *
 * @author jinghui.zhu@luckincoffee.com
 * @date 2020/7/27 17:09:47
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "1,2,3";
        String[] split = s.split(",");

        List<Long> list = new ArrayList<>();
        for (String a :
                split) {
            list.add(Long.valueOf(a));
        }
        System.out.println(list);


        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setId(1);
        person.setName("A A A");
        personList.add(person);

        Person person1 = new Person();
        person1.setId(2);
        person1.setName("B B B");
        personList.add(person1);

        System.out.println("去除空格前" + personList);

        for (Person person2 : personList) {
            person2.getName().replace(" ", "");
        }

        System.out.println("去除空格后:" + personList);
    }
}
