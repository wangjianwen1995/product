package JUCTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

       // key 第一组  会抛出异常 一般不会使用
        //添加元素
        boolean add1 = blockingQueue.add("1");
        //检查元素
        String element = blockingQueue.element();
        //取元素
        String remove1 = blockingQueue.remove();

        // key 第二组(重点)  offer存放 poll取元素返回成功与失败
        //添加元素
        boolean offer = blockingQueue.offer("1");
        //取元素
        String poll = blockingQueue.poll();

        //key  第三组 put 存放到满时,会阻塞等待 take取完所有数据再取时候也会等待阻塞

        blockingQueue.put("1");
        String take = blockingQueue.take();

        //key  第四组  offer 存放到满时,会阻塞等待 poll 取完所有数据再取时候也会等待阻塞 ,可以设置超时时间
        boolean offer1 = blockingQueue.offer("1", 3,TimeUnit.SECONDS );

        String poll1 = blockingQueue.poll(3, TimeUnit.SECONDS);
    }
}
