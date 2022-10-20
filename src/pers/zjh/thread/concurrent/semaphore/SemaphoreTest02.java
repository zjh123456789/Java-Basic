package pers.zjh.thread.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author jinghui.zhu
 * @description 餐厅排队打饭
 * @createTime 2022/10/20 10:18 AM
 */
public class SemaphoreTest02 {

    // 初始化信号量
    private static Semaphore semaphore = new Semaphore(3);
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            // 5个学生共用一个信号量
            new Student(semaphore, "学生 " + i).start();
        }
    }

    static class Student extends Thread {
        private Semaphore sp = null;
        private String name = null;
        public Student(Semaphore sp, String name) {
            this.sp = sp;
            this.name = name;
        }
        @Override
        public void run() {
            try {
                System.out.println(name + " 进入了餐厅");
                sp.acquire();
                System.out.println(name + " 拿到了打饭的许可证");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sp.release();
                System.out.println(name + " 打好了饭,释放许可证");
            }
        }
    }
}