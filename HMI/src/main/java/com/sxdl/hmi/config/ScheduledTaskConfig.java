package com.sxdl.hmi.config;//package com.sxdl.hp.config;
//
//import com.sxdl.base.config.SchedulConfig;
//import com.sxdl.base.entity.SchedulEntity;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Async;
//
///**
// * 执行定时任务的线程池配置类
// */
//@Configuration
//public class eScheduledTaskConfig extends SchedulConfig {
//
//    private SchedulEntity schedulEntity;
//    @Async("taskExecutor")
//    @Override
//    public void run(SchedulEntity se) {
//        if(se.getIsSys()==0){
//            System.out.println(se.getInfo()+" 10");
//        }
//    }
//
//    /**
//     *
//     * 每天早上09点 自动上报 时间是前天到昨天
//     */
//    // @Scheduled(cron = "*/30 * * * * ?")
////    @Scheduled(cron = "*/10 * * * * ?")
//    public void hp(){
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(new Date());
////        calendar.add(Calendar.DAY_OF_MONTH, -10);
////        String stime = sdf.format(calendar.getTime());//前天时间
////        calendar.setTime(new Date());
////        calendar.add(Calendar.DAY_OF_MONTH, -1);
////        String etime = sdf.format(calendar.getTime());//昨天时间
////        System.out.println(stime +"----"+etime);
//        schedulEntity=new SchedulEntity();
//        schedulEntity.setCorn("0 0/1 * * * ?");
//        schedulEntity.setIsSys(0);
//        schedulEntity.setInfo("项目中的");
//        run(schedulEntity);
//    }
//
////    @Bean
////    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
////        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
////        threadPoolTaskScheduler.setPoolSize(20);
////        threadPoolTaskScheduler.setThreadNamePrefix("taskExecutor-");
////        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
////        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
////        threadPoolTaskScheduler.setRemoveOnCancelPolicy(true);
////        return threadPoolTaskScheduler;
////    }
//}
