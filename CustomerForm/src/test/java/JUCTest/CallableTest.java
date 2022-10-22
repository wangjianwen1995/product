package JUCTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = ()-> {
            System.out.println(Thread.currentThread().getName()+" come in callable  ");
            return 200;

        };

        FutureTask futureTask  = new FutureTask(callable);

        new Thread(futureTask,"luck").start();

        //判断线程是否执行完成
        while(!futureTask.isDone()){
            System.out.println("wait...");
        }

        String string = futureTask.get().toString();
        System.out.println(string);
        System.out.println(Thread.currentThread().getName()+" come in over  ");


    }
}
