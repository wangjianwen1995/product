package com.sxdl.hpqc.util;

import cn.hutool.json.JSONObject;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.hpqc.util.verify.HpVerify;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class HpqcApplicationRunnerImpl extends ApplicationRunnerImpl {
    Map<Integer, Object> dictmap;
    Map<String, String> dictVal;
    List<Map<String, String>> dicts;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        super.init();
        Map<Integer, List<SysDictVal>> baMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1 && "病案首页字典".equals(e.getSupplement_name())).collect(Collectors.groupingBy(e -> e.getDict_id()));
        Map<Integer, List<SysDictVal>> baBmMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1 && "病案编码字典".equals(e.getSupplement_name())).collect(Collectors.groupingBy(e -> e.getDict_id()));
        //查询首页的所有字典库信息
        dictmap = new HashMap<>();
        baMap.forEach((k, v) -> {
            v.sort(Comparator.comparing(SysDictVal::getVal));
            dicts = new ArrayList<>();
            v.forEach(e -> {
                dictVal = new HashMap<>();
                dictVal.put("name", e.getName());
                dictVal.put("val", e.getVal());
                dictVal.put("remark", e.getRemark());
                dicts.add(dictVal);
            });
            dictmap.put(k, dicts);
        });
        contextMap.put("baMapSimple", dictmap);
        contextMap.put("baBmMap", baBmMap);

        JSONObject j = HpVerify.builder().isVerify((JSONObject) contextMap.get("verifyInfo"));
        System.out.println("山西雕龙欢迎您！欢迎使用hpqc（Homepage Of Medical Record）病案首页数据质控系统~");
        if (null == j) {
            contextMap.put("verify", false);
            contextMap.put("level", "");
            contextMap.put("hasLinking", "");
            // System.out.println(VerifyUtil.msg);
        } else {
            contextMap.put("verify", true);
            contextMap.put("level", j.getStr("level"));//用户级别
            contextMap.put("hasLinking", j.getStr("hasLinking"));//是否有环节质控
        }

    }
}
