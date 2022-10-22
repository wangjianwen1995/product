package com.sxdl.cf.config;

import com.sxdl.cf.dao.dao1.SysDictTableDao2;
import com.sxdl.cf.dao.dao1.SysDictValDao2;
import com.sxdl.cf.entity.SysDictTable;
import com.sxdl.cf.entity.SysDictVal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Component
public class CFRunner implements ApplicationRunner {
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public volatile static  Map<Integer, Map<String, String>> CFIOC = new ConcurrentHashMap<>();
    public volatile static   List<SysDictTable> CFDT = new CopyOnWriteArrayList<>();
    public volatile static   List<SysDictVal> CFDV = new CopyOnWriteArrayList<>();
    @Autowired
    public SysDictValDao2 sysDictValDao;
    @Autowired
    public SysDictTableDao2 sysDictTableDao;





    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadData();
        logger.info("CF初始化字典数据完成");


    }



    public void ref(){
        CFIOC.clear();
        CFDT.clear();
        CFDV.clear();
        loadData();
        logger.info("CF定时刷新字典数据完成");
    }


    public void loadData(){
        List<SysDictVal> sysDictVals = sysDictValDao.selectAll();
        List<SysDictTable> sysDictTables = sysDictTableDao.selectAll();
        CFDV.addAll(sysDictVals.stream().filter(e -> !StringUtils.isEmpty(e.getDict_id()))
                .collect(Collectors.toList()));

        sysDictVals.stream().filter(e -> !StringUtils.isEmpty(e.getDict_id()))
                .collect(Collectors.groupingBy(SysDictVal::getDict_id)).forEach((k,v)->{
            Map<String, String> stringMap = v.stream().filter(f -> !StringUtils.isEmpty(f.getVal()) && !StringUtils.isEmpty(f.getName()))
                    .collect(Collectors.toMap(SysDictVal::getVal, SysDictVal::getName));
            CFIOC.put(k,stringMap);
        });

        CFDT.addAll(sysDictTables.stream().filter(e -> !StringUtils.isEmpty(e.getName()) && !StringUtils.isEmpty(e.getName_zh()))
                .collect(Collectors.toList()));


    }




}
