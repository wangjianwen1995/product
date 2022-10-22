package JUCTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        //锁降级
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        //开始锁降级
        // 1 获取写锁
        writeLock.lock();
        System.out.println("开始写入数据的逻辑");
        //2 获取读锁
        readLock.lock();
        System.out.println("开始读取数据的逻辑");
        //3 释放写锁 这一步就是将谢所降级成为读锁
        writeLock.unlock();
        System.out.println("这一步就是将谢所降级成为读锁");
        //4 释放读锁
        readLock.unlock();
    }

    //读写锁测试
    public static void test(){
        MyCatch myCatch = new MyCatch();

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(()->{
                myCatch.put(finalI+"",finalI+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(()->{
                myCatch.get(finalI+"");
            },String.valueOf(i)).start();
        }
    }
}


//资源类
class MyCatch{

    private volatile Map<String,String> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key ,String val){
        //添加写锁
        readWriteLock.writeLock().lock();
        try {
        System.out.println(Thread.currentThread().getName()+" 正在写入数据"+key);

        //模拟写入数据需要花费的时间

            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key,val);
            System.out.println(Thread.currentThread().getName()+" 数据写入完成"+key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }


    }

    public String get(String key){
        //添加读锁
        readWriteLock.readLock().lock();
        String s =null;
        try {
            System.out.println(Thread.currentThread().getName()+" 正在读取数据"+key);
            TimeUnit.MICROSECONDS.sleep(300);
            s = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取数据完成"+key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放读锁
            readWriteLock.readLock().unlock();
        }
        return s;

    }

}