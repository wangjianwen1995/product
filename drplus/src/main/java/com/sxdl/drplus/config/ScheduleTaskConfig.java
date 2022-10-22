package com.sxdl.drplus.config;

import com.sxdl.drplus.util.SplitUtils;
import com.sxdl.drplus.entity.SysScheduleTaskEntity;
import com.sxdl.drplus.service.SysScheduleTaskService;
import com.sxdl.drplus.util.BeanUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.StringUtils;

import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableScheduling
@EnableAsync
@RequiredArgsConstructor
public class ScheduleTaskConfig implements SchedulingConfigurer {
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    //存储需要执行的调度任务
    public final ConcurrentHashMap<SysScheduleTaskEntity, ScheduledFuture<?>> scheduledFutures = new ConcurrentHashMap<>();

    // 保证变量写操作的可见性 而且防止指令重排
    private volatile ScheduledTaskRegistrar registrar;

    private final SysScheduleTaskService taskService;


    public volatile static Map<String,List<LinkedHashMap<String,Object>>> sourceData = new ConcurrentHashMap<>();
    public volatile static Map<String,List<LinkedHashMap<String,Object>>> goalData = new ConcurrentHashMap<>();

    public static ExecutorService executorService = Executors.newFixedThreadPool(100);
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(30);
        scheduledTaskRegistrar.setScheduler(pool);
        registrar = scheduledTaskRegistrar;
    }

    /**
     *
     * 启动 或者 任务变动的时候 需要调用
     * @param cornTask
     */



    public void refresh( List<SysScheduleTaskEntity> cornTask){
        cancelTack(cornTask);
        cornTask.parallelStream().forEach(e->{
            String cronStr = e.getCron();
            if(!StringUtils.isEmpty(cronStr)){
                if(!scheduledFutures.containsKey(e)  ){
                    //判断是否修改了调度任务
                    Stream<SysScheduleTaskEntity> stream = scheduledFutures.keySet().stream();
                    if(stream.anyMatch(b -> b.getId().equals(e.getId()) && !b.getCron().equals(e.getCron()))){
                        //先停止 调度任务  这里 使用get() 因为上面做了判断故不需要 orElse();
                        SysScheduleTaskEntity key = stream.filter(f->f.getId().equals(e.getId())).findAny().get();
                        //先停止 操作系统中的调度任务
                        scheduledFutures.get(key).cancel(false);
                        //集合中移除
                        scheduledFutures.remove(key);

                    }
                    //key 你自己的任务 核心代码 ,我这里只做输出打印
                    Runnable runnable = null;
                    try {
                        runnable = ()-> {
                            CoreSync(e);
                           System.out.println(">>>>>>>>>完成<<<<<<<<<");
                           System.out.println("");
                        };
                        CronTask task = new CronTask(runnable,cronStr);
                        ScheduledFuture<?> future = registrar.getScheduler().schedule(task.getRunnable(), task.getTrigger());
                        //保存数据到容器中,而容器中的数据实际对映的 操作系统实际在运行的调度任务
                        scheduledFutures.put(e,future);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        logger.error("调度任务核心代码错误:"+exception.getMessage());

                    }


                }
            }

        });



    }

    public void CoreSync(SysScheduleTaskEntity e) {
        long startTime = System.currentTimeMillis();
        //key 这里的sql 到时候需要在  SysScheduleTaskEntity 中获取 如果需要提速,可以将 _version 提前到组装数据那块
        List<LinkedHashMap<String, Object>> sourceVersion = taskService.getDataBySql(" select * from dl_dr..aaa ")
                .stream().map(m -> {
                    m.put("_version", "源");
                    return m;
                }).collect(Collectors.toList());
        //用来下次对比对数据
        List<LinkedHashMap<String, Object>> copyList = null ;
        try {
             copyList = BeanUtils.deepCopyList(sourceVersion);
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }
        sourceData.put(e.getPid(),sourceVersion);

        if(!goalData.containsKey(e.getPid())){ //不包含表示重启系统或者系统初始化
            //key 这里的sql 到时候需要在  SysScheduleTaskEntity 中获取
            List<LinkedHashMap<String, Object>> goalVersion = taskService.getDataBySql(" select * from dl_dr..bbb ").stream().map(m -> {
                m.put("_version", "目");
                return m;
            }).collect(Collectors.toList());
            goalData.put(e.getPid(),goalVersion);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("1程序查询数据库耗时：" + (endTime - startTime) + "ms");


        sourceVersion.addAll(goalData.get(e.getPid()));

        List<FutureTask<TTDBO>> futureList = new ArrayList<>();

        ConcurrentMap<String, List<LinkedHashMap<String, Object>>> joinData = sourceVersion.stream().collect(Collectors.groupingByConcurrent(g -> g.get("PRIMAEYKEY").toString()));

        long startTime2 = System.currentTimeMillis();
        joinData.forEach((k,v)->{

            FutureTask<TTDBO> futureTask = new FutureTask<>(() -> {
                TTDBO dbo = new TTDBO();
                if(v.size()==1){//新增或者删除了数据
                    if (v.get(0).get("_version").toString().equals("源")){
                        dbo.setConcurrentHashMap(v.get(0));
                        dbo.setType(1);
                    } else{
                        dbo.setConcurrentHashMap(v.get(0));
                        dbo.setType(3);
                    }
                }else if(v.size()==2){ //修改 或者未操作
                    LinkedHashMap<String, Object> sourceObj = v.get(0);
                    LinkedHashMap<String, Object> goalObj = v.get(1);
                    //存放修改数据对象
                    LinkedHashMap<String, Object> container = new LinkedHashMap<>();
                    for (Map.Entry<String, Object> entry : sourceObj.entrySet()) {
                        if(!StringUtils.isEmpty(entry.getValue())){
                            String val = entry.getValue().toString();
                            if (entry.getKey().equals("_version")) continue;
                            if(!val.equals(goalObj.get(entry.getKey()).toString())){
                                container.put(entry.getKey(),entry.getValue());
                            }
                        }else{
                            if (!StringUtils.isEmpty(goalObj.get(entry.getKey()))){
                                container.put(entry.getKey(),entry.getValue());
                            }
                        }

                    }
                    if(container.size()>0){
                        //key 这里手动保存主键值
                        container.put("PRIMAEYKEY",sourceObj.get("PRIMAEYKEY"));
                        dbo.setConcurrentHashMap(container);
                        dbo.setType(2);
                    }else{

                        return null;
                    }
                }
                return dbo;
            });
            //executorService.submit(futureTask);
            executorService.execute(futureTask);
            //key 提高并发响应速度 为让任务统一执行,在这里不直接get结果集,在list装载完所有线程后,统一get 结果
            futureList.add(futureTask);
        });
        List<TTDBO> dboData = futureList.stream().map(stringFutureTask -> {
            try {
                return stringFutureTask.get();
            } catch (Exception ex) {
                System.out.println("草,真是这里啊");
                ex.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        //   key 测试环境下需要手动关闭线程池资源
        //executorService.shutdown();

        long endTime2 = System.currentTimeMillis();
        System.out.println("2程序对比数据耗时：" + (endTime2 - startTime2) + "ms");
        Map<Integer, List<TTDBO>> collect = dboData.stream().filter(f->f!=null && f.getType()!=null).collect(Collectors.groupingBy(TTDBO::getType));
        if (collect.size()==0){
            System.out.println("无任何数据修改");
            return;
        }
        if(collect.containsKey(1))
            System.out.println("新增:"+collect.get(1).size());
        if(collect.containsKey(2))
            System.out.println("修改:"+collect.get(2).size());
        if(collect.containsKey(3))
            System.out.println("删除:"+collect.get(3).size());

        //开始拼接sql 更新数据表
        List<TTDBO> AddDbos = collect.get(1);
        List<TTDBO> UpDbos = collect.get(2);
        List<TTDBO> DelDbos = collect.get(3);

        long startTime3 = System.currentTimeMillis();

        if(!StringUtils.isEmpty(AddDbos)) {
            SplitUtils.splitList(AddDbos, 50).forEach(add -> {
                StringBuffer sb = new StringBuffer();
                add.forEach(a -> {
                    StringBuffer sb1 = new StringBuffer(" Insert into dl_dr..bbb( ");
                    StringBuffer sb2 = new StringBuffer(" values( ");
                    a.getConcurrentHashMap().forEach((k, v) -> {
                        if (!k.equals("_version")) {
                            if (!StringUtils.isEmpty(v)) {
                                sb1.append(k).append(",");
                                sb2.append("'").append(v.toString()).append("',");
                            } else {
                                sb1.append(k).append(",");
                                sb2.append("null ,");
                            }
                        }

                    });
                    sb1.deleteCharAt(sb1.length() - 1).append(")");
                    sb2.deleteCharAt(sb2.length() - 1).append(") ");
                    sb1.append(sb2);
                    sb.append(sb1).append(LineBreak);
                });
                int i = taskService.updateSqlWithSQL(sb.toString());
            });
        }
        if(!StringUtils.isEmpty(UpDbos)){
            SplitUtils.splitList(UpDbos,80).forEach(up->{
                StringBuffer sb = new StringBuffer();
                up.forEach(a->{
                    StringBuffer sb1 = new StringBuffer(" Update dl_dr..bbb set ");
                    a.getConcurrentHashMap().forEach((k,v)->{
                        if(!k.equals("PRIMAEYKEY")){
                            if(!StringUtils.isEmpty(v)){
                                sb1.append(k).append(" = '").append(v.toString()).append("' ,");
                            }else{
                                sb1.append(k).append(" = NULL ,");
                            }
                        }

                    });
                    sb1.deleteCharAt(sb1.length()-1);
                    //key 这里我的是PRIMAEYKEY
                    sb1.append(" Where PRIMAEYKEY='").append(a.getConcurrentHashMap().get("PRIMAEYKEY")).append("' ");
                    sb.append(sb1).append(LineBreak);
                });
                int i = taskService.updateSqlWithSQL(sb.toString());
            });
        }

        if(!StringUtils.isEmpty(DelDbos)){
            SplitUtils.splitList(DelDbos,100).forEach(del->{
                StringBuffer sb = new StringBuffer();
                del.forEach(a->{
                    StringBuffer sb1 = new StringBuffer(" Delete dl_dr..bbb");
                    //key 这里我的是PRIMAEYKEY
                    sb1.append(" Where PRIMAEYKEY='").append(a.getConcurrentHashMap().get("PRIMAEYKEY")).append("' ");
                    sb.append(sb1).append(LineBreak);
                });
                int i = taskService.updateSqlWithSQL(sb.toString());
            });
        }
        //更换新的数据


        List<LinkedHashMap<String, Object>> goalDataCopy = copyList.stream().map(m -> {
            m.put("_version", "目");
            return m;
        }).collect(Collectors.toList());
        goalData.put(e.getPid(),goalDataCopy);

        long endTime3 = System.currentTimeMillis();
        System.out.println("3程序同步数据耗时：" + (endTime3 - startTime3) + "ms");
    }

    /***
     *  判断数据库中 是否 有 在运行的调度任务 ,如果没有代表该任务已经被删除 ,
     *  后续应该停止该任务
     * @param cornTask
     */
    public void cancelTack(List<SysScheduleTaskEntity> cornTask) {
        Set<SysScheduleTaskEntity> sids = scheduledFutures.keySet();
        sids.forEach(e->{
            if(!exists(cornTask,e))
                scheduledFutures.get(e).cancel(false);
            /**
             * 尝试取消此任务的执行。如果任务已完成、已被取消或由于某些其他原因无法取消，则此尝试将失败。
             * 如果成功，并且在调用 {@code cancel} 时此任务尚未启动，则此任务不应运行。
             * 如果任务已经开始，则 {@code mayInterruptIfRunning} 参数确定是否应中断执行此任务的线程以尝试停止任务。
             * <p>此方法返回后，对 {@link isDone} 的后续调用将始终返回 {@code true}。
             * 如果此方法返回 {@code true}，则对 {@link isCancelled} 的后续调用将始终返回 {@code true}。
             * @param mayInterruptIfRunning {@code true} 如果执行这个任务的线程应该被中断；
             *                                          否则，如果无法取消任务，则允许进行中的任务完成@return
             *                                          {@code false}，通常是因为它已经正常完成；
             *                                          {@code true}
             *                                          否则
             */




        });
    }

    /**
     *  判断数据库中 是否 有 在运行的调度任务 ,如果没有代表该任务已经被删除 ,
     *    后续应该停止该任务
     * @param cornTaskOfDatabase  数据库中的调度数据
     * @param iocTask              操作系统中开启的任务
     * @return
     */
    public Boolean exists (List<SysScheduleTaskEntity>  cornTaskOfDatabase,SysScheduleTaskEntity iocTask){
        return cornTaskOfDatabase.stream().anyMatch(b -> b.getId().equals(iocTask.getId()));
    }


    /**
     *   异常时候,销毁该调度任务 ,释放线程资源
     */
    @PreDestroy
    public void destory(){
        registrar.destroy();
    }


    @Data
    @Accessors(chain = true) //set链式编程
    class TTDBO {
        //一条数据
        LinkedHashMap<String,Object> concurrentHashMap;
        //1 添加 2修改 3删除  null 没有操作
        Integer type;


    }

}
