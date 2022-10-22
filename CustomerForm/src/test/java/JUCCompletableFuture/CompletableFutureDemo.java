package JUCCompletableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//异步 回调
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //异步调用,没有返回值
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"没有返回值");
        });

        voidCompletableFuture.get();


        //异步调用有返回值
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回值");
            int p = 1/0;
            return 1111;
        });

        Integer integer = integerCompletableFuture.whenComplete((t,u)->{
            System.out.println("t------>"+t+">>方法返回值");
            System.out.println("u------>"+u+">>异常信息");
        }).get();
        System.out.println(integer);

    }

}
