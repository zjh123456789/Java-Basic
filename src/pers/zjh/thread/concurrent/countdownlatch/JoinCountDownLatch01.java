package pers.zjh.thread.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author jinghui.zhu
 * @description CountDownLatch - new Thread() -允许一个或者多个线程去等待其他线程完成操作。
 * @createTime 2022/10/11 11:35 AM
 */
public class JoinCountDownLatch01 {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程A执行");
            countDownLatch.countDown();
            System.out.println("didi A");
        });

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程B执行");
            countDownLatch.countDown();
            System.out.println("didi B");
        });

        threadA.start();
        threadB.start();
        System.out.println("main thread start");
        // 等待子线程执行完毕 返回
        countDownLatch.await();
        System.out.println("all thread ending");
    }
}