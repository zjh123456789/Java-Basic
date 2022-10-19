package pers.zjh.thread.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author jinghui.zhu
 * @description Semaphore - 信号量
 * @createTime 2022/10/18 5:09 PM
 */
public class SemaphoreTest01 {

    private static final Semaphore semaphore = new Semaphore(2);

    public static class T extends Thread {
        public T(String name) {
            super(name);
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                semaphore.acquire();
                System.out.printf("当前时间：%s, 当前线程：%s 获得许可, 当前可用许可证：%s%n", System.currentTimeMillis(), thread.getName(), semaphore.availablePermits());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.printf("----当前时间：%s, 当前线程：%s 释放许可, 当前可用许可证：%s%n", System.currentTimeMillis(), thread.getName(), semaphore.availablePermits());
                semaphore.release();
                System.out.printf("****当前时间：%s, 当前线程：%s 释放许可, 当前可用许可证：%s%n", System.currentTimeMillis(), thread.getName(), semaphore.availablePermits());
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new T("t-" + i).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}