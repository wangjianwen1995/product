//package com.sxdl.hp.config;
//
//import cn.hutool.core.collection.CollUtil;
//import com.sxdl.base.config.SchedulConfig;
//import com.sxdl.base.entity.SchedulEntity;
//import com.sxdl.base.util.DateUtil;
//import com.sxdl.hp.util.HpApplicationRunnerImpl;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//public class HpSchedulConfig extends SchedulConfig {
//
//    List<String> keys;
//    Map<String, Date> usedQueue;
//    public void runChild(SchedulEntity se) {
//        if (null == se || null == se.getIsSys()) {
//            return;
//        }
//        if(se.getIsSys()==0){
//            switch(se.getInfo()){
//                case "清理独占病例":
//                    usedQueue=(Map)HpApplicationRunnerImpl.contextMap.get("usedQueue");
//                    keys=new ArrayList<>();
//                    if(CollUtil.isEmpty(usedQueue)) return;
//                    usedQueue.forEach((k,v)->{
//                        if(DateUtil.betweenMs(v,new Date())>=1800000){
//                            keys.add(k);
//                        }
//                    });
//                    if(keys.size()>0){
//                        keys.forEach(e->{
//                            usedQueue.remove(e);
//                        });
//                    }
//                    break;
//            }
//        }
//    }
//    //每30分钟清理独占的病例
//    @Scheduled(cron = "0 0/30 * * * ?")
//    public void checkIsUsed() {
//        runChild(new SchedulEntity(0,"清理独占病例"));
//    }
//}
