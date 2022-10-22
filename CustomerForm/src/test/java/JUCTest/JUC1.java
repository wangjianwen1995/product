package JUCTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 1 synchronized Lock 锁的售票小案例
 */
public class JUC1 {


    @Test
    public void t1(){
//        saleTest sale = new saleTest();
        saleTest2 sale = new saleTest2();
        System.out.println("开始售票");
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sale.setSale();
            }
        },"小张").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sale.setSale();
            }
        },"小郭");
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sale.setSale();
            }
        },"小刚").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sale.setSale();
            }
        },"小李").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sale.setSale();
            }
        },"小王").start();
    }


    class saleTest{
        private  Integer   number= 30;

        public  void setSale(){
            synchronized(number){
                if(number>0){
                    System.out.println("现在有"+number+"张票,售票员:"+Thread.currentThread().getName()+"卖出一张,还剩余:"+--number+"张票");
                }
            }
        }
    }

    class saleTest2{
        private  Integer   number= 30;

        private final ReentrantLock reentrantLock = new ReentrantLock();

        public  void setSale(){
            reentrantLock.lock();
            try {
                if(number>0){
                    System.out.println("现在有"+number+"张票,售票员:"+Thread.currentThread().getName()+"卖出一张,还剩余:"+--number+"张票");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {

                reentrantLock.unlock();
            }
        }
    }


}
