package pers.zjh.design_pattern.factory;

/**
 * ${todo}
 *
 * @author jinghui.zhu@luckincoffee.com
 * @date 2019/5/29 14:32
 */
public class Frog implements Animal {

    @Override
    public void sound() {
        System.out.println("青蛙的叫声: '呱呱呱'");
    }
}
