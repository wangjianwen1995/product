package com.sxdl.sd.util;

import com.sxdl.sd.dao.dao1.SdInfoColumnDao;
import com.sxdl.sd.dao.dao1.SdInfoDao;
import com.sxdl.sd.entity.SdInfo;
import com.sxdl.sd.entity.SdInfoColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class SdApplicationRunnerImpl extends com.sxdl.base.util.ApplicationRunnerImpl {
    //全局变量
    public volatile static Map<String, Object> contextMap = new ConcurrentHashMap<>();

   /* @Autowired
    CronTaskRegistrar cronTaskRegistrar;*/

    @Autowired
    SdInfoDao sdInfoDao;

    @Autowired
    SdInfoColumnDao sdInfoColumnDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        super.init();
        System.out.println("山西雕龙欢迎您！欢迎使用SD（Single Disease）单病种数据的质量管理和上报平台~");
        List<SdInfo> sdInfos = sdInfoDao.selectAll();
        List<SdInfoColumn> sdInfoColumns = sdInfoColumnDao.selectAll();

        Map<Integer, List<SdInfoColumn>> map = sdInfoColumns.stream().collect( Collectors.groupingBy( e -> e.getSd_info_id()));
        sdInfos.forEach(e->{
            e.setColumns(map.get(e.getId()));
        });
        contextMap.put("sdInfos", sdInfos);

    }

 /*   private void excuteSchedule() {
        SchedulingRunnable task = new SchedulingRunnable ( "dataTask","doTask",new JSONArray() );
        cronTaskRegistrar.addCronTask ( task, "0 0 4 * * ?");

    }
*/
}
