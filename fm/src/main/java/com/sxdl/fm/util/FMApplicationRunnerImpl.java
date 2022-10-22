package com.sxdl.fm.util;

import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictTableService;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.fm.service.FmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FMApplicationRunnerImpl extends ApplicationRunnerImpl {
    @Autowired
    FmUserService fmUserService;
    @Autowired
    SysDictTableService sysDictTableService;
    @Autowired
    SysDictValService   sysDictValService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        init();
        //初始化缓存全局数据，字典数据
        Map<Integer, List<SysDictVal>> dvOnMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1).collect(Collectors.groupingBy(e -> e.getDict_id()));
        contextMap.put("dvOnMap", dvOnMap);
        System.out.println("山西雕龙欢迎您！欢迎使用FM（Fine Management）院内精细化管理平台~");
        LinkedHashMap<String, Object> dataMap = new LinkedHashMap() {
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 1000;
            }
        };
        contextMap.put("data", dataMap);
    }
}
