package SyncDataDemo;

import com.sxdl.cf.dto.SimpleDBO;
import com.sxdl.cf.util.SplitUtils;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Collectors;

// @SpringBootTest  由于没有启动类 只能在这里写普通测试方法,没法注入容器数据
public class TestDemoSpringBoot {
    public volatile static List<ConcurrentHashMap<String,Object>> sourceData = new CopyOnWriteArrayList<>();
    public volatile static List<ConcurrentHashMap<String,Object>> goalData = new CopyOnWriteArrayList<>();


    public volatile static List<ConcurrentHashMap<String,Object>> addList = new CopyOnWriteArrayList<>();
    public volatile static List<ConcurrentHashMap<String,Object>> delList = new CopyOnWriteArrayList<>();
    public volatile static List<ConcurrentHashMap<String,Object>> upList = new CopyOnWriteArrayList<>();


    @Test
    public void test1() throws InterruptedException {



        //模拟数据库查询
        for (int i = 0; i < 100100; i++) {
            ConcurrentHashMap<String,Object> sourceMap = new ConcurrentHashMap<>();
            sourceMap.put("_key",i);
            sourceMap.put("name",i);
            sourceMap.put("age",i);
            sourceMap.put("_version","源");
            sourceData.add(sourceMap);

            if(i<50000){
                ConcurrentHashMap<String,Object> goalDataMap = new ConcurrentHashMap<>();
                goalDataMap.put("_key",i);
                goalDataMap.put("name",i);
                goalDataMap.put("age",i);
                goalDataMap.put("_version","目");
                goalData.add(goalDataMap);
            }else{
                ConcurrentHashMap<String,Object> goalDataMap = new ConcurrentHashMap<>();
                goalDataMap.put("_key",i+1);
                goalDataMap.put("name",i+1);
                goalDataMap.put("age",i);
                goalDataMap.put("_version","目");
                goalData.add(goalDataMap);
            }

        }
        sourceData.addAll(goalData);

        CountDownLatch countDownLatch = new CountDownLatch(50);
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        ConcurrentMap<String, List<ConcurrentHashMap<String, Object>>> joinData = sourceData.stream().collect(Collectors.groupingByConcurrent(e->e.get("_key").toString()));


        List<Map<String, List<ConcurrentHashMap<String, Object>>>> ListMaps = SplitUtils.splitMap(joinData, 50);
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            executorService.submit(() -> {
                ListMaps.get(finalI).forEach((k, v)->{
                    if(v.size()==1){//新增或者删除了数据
                        if (v.get(0).get("_version").toString().equals("源"))
                            addList.add(v.get(0));
                        else
                            delList.add(v.get(0));
                    }else if(v.size()==2){ //修改 或者未操作

                        ConcurrentHashMap<String, Object> sourceObj = v.get(0);
                        ConcurrentHashMap<String, Object> goalObj = v.get(1);
                        //存放修改数据对象
                        ConcurrentHashMap<String, Object> container = new ConcurrentHashMap<>();
                        sourceObj.forEach((mKey,mVal)->{
                            //测试不做null处理
                            if (!mVal.toString().equals(goalObj.get(mKey).toString()))
                                container.put(mKey,mVal);
                        });

                        if (!StringUtils.isEmpty(container))
                            upList.add(container);
                    }
                });

            });
        }  System.out.println("等待所有线程完成......");   countDownLatch.await();

        // 将 数据1000份一组
        SplitUtils.splitList(addList, 1000).forEach(e->{
            System.out.println("这里就当做拼接SQL了"+e.size());
        });

        //其余的update delete 类似
        SplitUtils.splitList(delList, 1000).forEach(e->{
            System.out.println("这里就当做拼接SQL了"+e.size());
        });


        //其余的update delete 类似
        SplitUtils.splitList(upList, 1000).forEach(e->{
            System.out.println("这里就当做拼接SQL了"+e.size());
        });

    }


    public static ExecutorService executorService = Executors.newFixedThreadPool(100);
    @Test
    public void test2(){

        //模拟数据库查询
        for (int i = 1; i < 100000; i++) {

            if(i<=40000){ //模拟新增数据
                ConcurrentHashMap<String,Object> sourceMap = new ConcurrentHashMap<>();
                sourceMap.put("_key",i);
                sourceMap.put("name",i);
                sourceMap.put("age",i);
                sourceMap.put("_version","源");
                ConcurrentHashMap<String,Object> sourceMap1 = new ConcurrentHashMap<>();
                sourceMap1.put("_key",i+"新增");
                sourceMap1.put("name",i);
                sourceMap1.put("age",i);
                sourceMap1.put("_version","源");
                sourceData.add(sourceMap);
                sourceData.add(sourceMap1);
            }else if(i<=80000){//模拟删除数据

            }else if (i<=90000){//模拟修改数据
                ConcurrentHashMap<String,Object> sourceMap = new ConcurrentHashMap<>();
                sourceMap.put("_key",i);
                sourceMap.put("name",i+"修改");
                sourceMap.put("age",i+"修改");
                sourceMap.put("_version","源");
                sourceData.add(sourceMap);
            }else{ //模拟数据不变
                ConcurrentHashMap<String,Object> sourceMap = new ConcurrentHashMap<>();
                sourceMap.put("_key",i);
                sourceMap.put("name",i);
                sourceMap.put("age",i);
                sourceMap.put("_version","源");
                sourceData.add(sourceMap);
            }

            ConcurrentHashMap<String,Object> goalDataMap = new ConcurrentHashMap<>();
            goalDataMap.put("_key",i);
            goalDataMap.put("name",i);
            goalDataMap.put("age",i);
            goalDataMap.put("_version","目");
            goalData.add(goalDataMap);

        }

        long startTime = System.currentTimeMillis();
        sourceData.addAll(goalData);
        List<FutureTask<TTDBO>> futureList = new ArrayList<>();
        ConcurrentMap<String, List<ConcurrentHashMap<String, Object>>> joinData = sourceData.stream().collect(Collectors.groupingByConcurrent(e->e.get("_key").toString()));

        joinData.forEach((k,v)->{
            FutureTask<TTDBO> futureTask = new FutureTask<>(() -> {
                TTDBO  dbo = new TTDBO ();
                if(v.size()==1){//新增或者删除了数据
                    if (v.get(0).get("_version").toString().equals("源")){
                        dbo.setConcurrentHashMap(v.get(0));
                        dbo.setType(1);
                    } else{
                        dbo.setConcurrentHashMap(v.get(0));
                        dbo.setType(3);
                    }
                }else if(v.size()==2){ //修改 或者未操作
                    ConcurrentHashMap<String, Object> sourceObj = v.get(0);
                    ConcurrentHashMap<String, Object> goalObj = v.get(1);
                    //存放修改数据对象
                    ConcurrentHashMap<String, Object> container = new ConcurrentHashMap<>();

                    for (Map.Entry<String, Object> entry : sourceObj.entrySet()) {
                        String val = entry.getValue().toString();
                        if (entry.getKey().equals("_version")) continue;
                        if(!val.equals(goalObj.get(entry.getKey()).toString())){
                            container.put(entry.getKey(),entry.getValue());
                        }
                    }

                    if(container.size()>0){
                        dbo.setConcurrentHashMap(container);
                        dbo.setType(2);
                    }else{
                        return null;
                    }
                }

                return dbo;
            });
            Future<?> submit = executorService.submit(futureTask);
            futureList.add(futureTask);
        });


        List<TTDBO> dboData = futureList.stream().map(stringFutureTask -> {

            try {
                return stringFutureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        //测试环境下需要手动关闭线程池资源
        executorService.shutdown();

        Map<Integer, List<TTDBO>> collect = dboData.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(TTDBO::getType));
        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println("新增:"+collect.get(1).size());
        System.out.println("修改:"+collect.get(2).size());
        System.out.println("删除:"+collect.get(3).size());
    }

    @Data
    @Accessors(chain = true) //set链式编程
    class TTDBO {
        //一条数据
        ConcurrentHashMap<String,Object> concurrentHashMap;
        //1 添加 2修改 3删除  null 没有操作
        Integer type;


    }

    @Test
    public void t2t() throws ExecutionException, InterruptedException {
       List<SimpleDBO> l = new ArrayList<>();
       l.add(new SimpleDBO());
       l.add(new SimpleDBO());
       l.add(new SimpleDBO());
       l.add(new SimpleDBO());
       l.add(new SimpleDBO());
        Map<String, List<SimpleDBO>> collect = l.stream().filter(f -> f != null || f.getTname() != null).collect(Collectors.groupingBy(e -> e.getTname()));

        if (collect==null){
            System.out.println(1111);
        }

    }



}
