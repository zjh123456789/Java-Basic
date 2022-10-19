package pers.zjh.thread.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jinghui.zhu
 * @description CountDownLatch - 线程池
 * @createTime 2022/10/11 12:37 PM
 */
public class JoinCountDownLatch02 {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
                System.out.println("threadA over");
                System.out.println(Thread.currentThread().getName());
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
                System.out.println("threadB over");
                System.out.println(Thread.currentThread().getName());
            }
        });
        System.out.println("wait all child thread over");
        countDownLatch.await();
        System.out.println("all child thread over");
        executorService.shutdown();
    }
}