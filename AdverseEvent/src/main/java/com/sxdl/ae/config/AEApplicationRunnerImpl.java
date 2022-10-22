package com.sxdl.ae.config;

import com.google.common.base.Objects;
import com.sun.org.apache.regexp.internal.RE;
import com.sxdl.ae.dao.dao1.AEAreaZipDao;
import com.sxdl.ae.entity.AEAreaZip;
import com.sxdl.base.dao.dao1.SysDictTableDao;
import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class AEApplicationRunnerImpl extends ApplicationRunnerImpl {
//    //全局变量
//    public volatile static Map<String, Object> contextMap = new ConcurrentHashMap<>();


    @Autowired
    private AEAreaZipDao areaZipDao;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        init();
        List<AEAreaZip> hpAreaZips = areaZipDao.selectAll();
        contextMap.put("areaZip", hpAreaZips);
        List<SysDictVal> dictValList = (List<SysDictVal>)contextMap.get("dictValList");
        Map<String, List<SysDictVal>> dictValMap = dictValList.stream()
                .filter(f -> !StringUtils.isEmpty(f.getIs_on()) && f.getIs_on().equals(1))
                .map(m -> {
                    List<SysDictVal> children = getChildren(m, dictValList);
                    m.setChildren(children);
                    if(!StringUtils.isEmpty(children) && children.size()>0){
                        m.setRemark(children.get(0).getDict_name());
                    }
                    return m;
                })
                .collect(Collectors.groupingBy(SysDictVal::getDict_name));

        contextMap.put("dictValMap",dictValMap);

    }

    private List<SysDictVal> getChildren(SysDictVal dictVal, List<SysDictVal> dictValList) {
        return   dictValList.stream()
                .filter(f-> Objects.equal(dictVal.getSource_id(),f.getDict_id()))
                .map(m->m.setChildren(getChildren(m,dictValList)))
                .collect(Collectors.toList());
    }


}
