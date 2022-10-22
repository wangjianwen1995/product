package com.sxdl.hmi.util;

import com.sxdl.base.dao.dao1.SysDictTableDao;
import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HmiApplicationRunnerImpl extends ApplicationRunnerImpl {
    @Autowired
    public SysDictValDao sysDictValDao;
    @Autowired
    public SysDictTableDao sysDictTableDao;
    @Override
    public void run(ApplicationArguments args) {
        init();
        List<SysDictTable> dcDitTableList2 = dcDitTableList.stream().filter(e -> null != e && !StringUtil.isEmpty(e.getSource_id().toString()) && 2 == e.getSource_id()).collect(Collectors.toList());
        contextMap.put("dcDitTableList2", dcDitTableList2);
        System.out.println("山西雕龙欢迎您！欢迎使用HMI(三级医院等级评审)系统");
    }


}
