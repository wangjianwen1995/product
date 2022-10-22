package JUCForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * key  分支合并框架
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0,100);
        //创建拆分合并池对象
        ForkJoinPool joinPool = new  ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = joinPool.submit(myTask);
        Integer integer = forkJoinTask.get();

        System.out.println(integer);
        //关闭资源
        joinPool.shutdown();
    }


}

class MyTask extends RecursiveTask<Integer>{


    //拆分差值不能超过10
    private static final Integer VALUE = 10;

    //拆分开始值
    private Integer begin;
    //拆分结果值
    private Integer end;

    //计算结果值
    private int result;

    public MyTask(Integer begin,Integer end){
        this.begin = begin;
        this.end = end;
    }

    //核心逻辑,拆分合并过程
    @Override
    protected Integer compute() {
        if(end-begin<=VALUE){
            for(int i = begin ; i<=end;i++){
                result  = result+i;
            }
        }else{ //将数据进行拆分
            //获取中间值
            Integer middle =  (begin+end)/ 2;
            //拆分左边
            MyTask myTask1= new MyTask(begin,middle);
            //拆分右边
            MyTask myTask2= new MyTask(middle+1,end);
            //调用方法开始拆分
            myTask1.fork();
            myTask2.fork();

            //合并结果
            result = myTask1.join()+myTask2.join();

        }
        return result;
    }
}
