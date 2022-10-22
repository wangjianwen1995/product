package JUCTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * key 线程间的定制化通信: 线程按照自定义的顺序执行
 *
 */

public class JUC2 {

    @Test
    public void t1(){
        ShareResource resource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {

                resource.pringAA();
            }
        } ).start();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {

                resource.printBB();
            }
        } ).start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {

                resource.printCC();
            }
        } ).start();

    }

    class ShareResource{
        private Integer falg = 1; // 1 AA线程打印1次  2 BB线程打印2次  3CC线程打印3次

        private final ReentrantLock lock = new ReentrantLock();

        private final Condition condition1  = lock.newCondition();
        private final Condition condition2  = lock.newCondition();
        private final Condition condition3   = lock.newCondition();


        //打印1次
        public void pringAA(){
            lock.lock();
            try {
                //通过标志位判断是否需要执行该线程,同时防止虚假唤醒
                while (falg!=1){
                    condition1.await();
                }
                //执行逻辑代码
                System.out.println("pringAA");
                //修改标志位,
                falg  = 2;
                //唤醒对映逻辑线程
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printBB() {
            lock.lock();
            try {
                while (falg!=2){
                    condition2.await();
                }

                System.out.println("pringBB");
                System.out.println("pringBB");
                falg  = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printCC() {
            lock.lock();
            try {
                while (falg!=3){
                    condition3.await();
                }
                System.out.println("pringCC");
                System.out.println("pringCC");
                System.out.println("pringCC");
                System.out.println("");

                falg  = 1;
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }

}
