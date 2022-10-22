package JUCTest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * JUC 辅助类
 *    1 减少计数  CountDownLatch
 *    2 循环栅栏  CyclicBarrier
 *    3 信号灯    Semaphore
 */
public class JUCAssistTest {



}
//7 个同学都离开 班长才可以锁门
class CountDownLatchDemo{

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 离开了教室 ");
                //计数-1
                latch.countDown();
            },String.valueOf(i)+"同学").start();
        }

        //等待计数为0 才会执行下面操作
        latch.await();
        System.out.println("班长开始锁门");

    }
}
//集齐7颗龙珠 才能成功召唤神龙
class CyclicBarrierDemo{

    private final static  Integer NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            System.out.println("成功集齐7龙珠,开始召唤中........");
        });


        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                System.out.println("收集到"+Thread.currentThread().getName()+"星龙珠");

                try {
                    //等待中,开启一个线程认为就是收集到一个触发值是NUMBER
                    int await = cyclicBarrier.await();
                } catch (Exception e) {
                }
            },String.valueOf(i)).start();
        }
    }

}

// 6辆汽车 3个停车位
class SemaphoreDemo{

    public static void main(String[] args) {
        //设置 3 个车位
        Semaphore semaphore = new  Semaphore(3);
        //模拟六辆车
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    //抢占资源 获取许可
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName()+" 抢到了车位");
                    //设置停车时间,随机时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));

                    System.out.println(Thread.currentThread().getName()+" 离开了车位----");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放资源
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

    }
}

