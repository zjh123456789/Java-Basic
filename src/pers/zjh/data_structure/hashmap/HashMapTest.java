package pers.zjh.data_structure.hashmap;

/**
 * hashMap 测试死循环
 *
 * @author jinghui.zhu@luckincoffee.com
 * @date 2020/3/31 15:18:31
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
