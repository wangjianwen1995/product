package JUCPool;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolDemo1 {



    /**
     * key ThreadPoolExecutor 的参数含义
     *   1   int corePoolSize,      常驻线程数量 (核心线程数量)
     *   2   int maximumPoolSize,   最大支持线程数据
     *   3   long keepAliveTime,    线程存活时间 ( 这里存活时间指的是 非核心的线程==>最大支持线程数据 - 常驻线程数量)
     *   4   TimeUnit unit,         线程存活时间单位
     *   5   BlockingQueue<Runnable> workQueue  阻塞队列,核心线程用完了,再来请求就会放到阻塞队列中去
     *   6   ThreadFactory threadFactory        线程工厂,用于创建线程的
     *   7   ejectedExecutionHandler handler    拒绝策略
     *
     * key 逻辑
     *    在调用execute()方法时候,线程才会创建 通过 threadFactory,假设你核心线程是 2
     *    来个7个业务请求,前两个会在核心线程中,剩下的不会直接创建线程,而是会放在 BlockingQueue 阻塞队列中排队
     *    当队列中也满了,才会开始创建新的线程,这里通过最大线程数(maximumPoolSize)来控制创建多少线程,
     *    当最大线程数也满了的时候,就开始使用handler 拒绝策略
     *    业务处理完成,多创建的线程闲置下来了,通过判断keepAliveTime 存活时间来销毁多与的线程
     *
     *  key 拒绝策略
     *    1.new ThreadPoolExecutor.AbortPolicy(默认)：
     *         默认策略，在需要拒绝任务时抛出RejectedExecutionException；拒绝执行异常
     *    2.new ThreadPoolExecutor.CallerRunsPolicy：
     *        直接在 execute 方法的调用线程中运行被拒绝的任务，如果线程池已经关闭，任务将被丢弃；
     *    3.new ThreadPoolExecutor.DiscardPolicy：
     *       默默的丢弃无法处理的任务,不予任何处理也不抛出异常,如果允许任务丢失,这是最好的策略
     *    4.new ThreadPoolExecutor.DiscardOldestPolicy：
     *       抛弃队列中等待最久的任务,然后把当前任务加入队列中,尝试再次提交当前任务
     *       ex: 我等了9小时没没吃饭,她一来就吃饭,艹
     *
     *
     */
    @Test
    public void t2(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(), //一般都是默认
                new ThreadPoolExecutor.AbortPolicy()
        );

        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String> future = threadPoolExecutor.submit(()-> {

                BlockingQueue queue = threadPoolExecutor.getQueue();
                System.out.println(Thread.currentThread().getName() + "," +

                        "当前的线程数量:" + threadPoolExecutor.getPoolSize() + "," +
                        "核心线程数:" + threadPoolExecutor.getCorePoolSize() + "," +
                        "最大线程数:" + threadPoolExecutor.getMaximumPoolSize() + "," +
                        "活动线程数:" + threadPoolExecutor.getActiveCount() + "," +
                        "任务总数:" + threadPoolExecutor.getTaskCount() + "," +
                        "任务完成数:" + threadPoolExecutor.getCompletedTaskCount() + "," +
                        "线程空闲时间:" + threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS) + "秒," +
                        "当前排队线程数:" + queue.size() + "," +
                        "队列剩余大小:" + queue.remainingCapacity() + "," +
                        "线程池是否关闭:" + threadPoolExecutor.isShutdown() + ","
                );
                System.out.println(Thread.currentThread().getName());
                return "测试";
            });
            futureList.add(future);

          /*  //执行完成没判断
            while(!future.isDone()){
                System.out.println("wait...");
            }*/
        }


        Future<String> future = threadPoolExecutor.submit(()-> {
            TimeUnit.SECONDS.sleep(3);
            BlockingQueue queue = threadPoolExecutor.getQueue();
            System.out.println(Thread.currentThread().getName() + "," +

                    "当前的线程数量:" + threadPoolExecutor.getPoolSize() + "," +
                    "核心线程数:" + threadPoolExecutor.getCorePoolSize() + "," +
                    "最大线程数:" + threadPoolExecutor.getMaximumPoolSize() + "," +
                    "活动线程数:" + threadPoolExecutor.getActiveCount() + "," +
                    "任务总数:" + threadPoolExecutor.getTaskCount() + "," +
                    "任务完成数:" + threadPoolExecutor.getCompletedTaskCount() + "," +
                    "线程空闲时间:" + threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS) + "秒," +
                    "当前排队线程数:" + queue.size() + "," +
                    "队列剩余大小:" + queue.remainingCapacity() + "," +
                    "线程池是否关闭:" + threadPoolExecutor.isShutdown() + ","
            );
            System.out.println(Thread.currentThread().getName());
            return "我要3秒看看你get方法是否会等待";
        });
        futureList.add(future);

        futureList.forEach(e->{
            try {
                /**
                 * key 其实 这类调用的是FutureTask.get()方法  会等待结果执行完成才获取返回值
                 *     源代码
                 *       public V get() throws InterruptedException, ExecutionException {
                 *         int s = state;
                 *         if (s <= COMPLETING)
                 *             s = awaitDone(false, 0L);  //等待任务执行完
                 *         return report(s); //将执行的任务结果返回
                 *     }
                 *
                 *
                 *
                 */

                System.out.println(e.get());
            } catch (InterruptedException | ExecutionException interruptedException) {
                interruptedException.printStackTrace();
            }
        });


        //由于是测试项目需要手动关闭线程池 否自程序不会终止
        threadPoolExecutor.shutdown();


    }



    /**
     * key 演示线程池三种常用分类
     */
    @Test
    public void t1(){
        //一池 5 线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //一池 1 线程
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //一池可扩容线程
        ExecutorService executorService2 = Executors.newCachedThreadPool();



        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName() +" 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //测试环境手动关闭资源
            executorService.shutdown();
        }

    }




}
