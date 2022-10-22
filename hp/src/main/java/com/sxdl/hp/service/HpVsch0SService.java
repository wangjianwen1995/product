package com.sxdl.hp.service;

import com.alibaba.fastjson.JSON;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpVsch0SEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpVsch0SService extends BaseUUIDServiceImpl<HpVsch0SEntity> {

    private String sql = "select CHYEAR AS CHYEAR, --病案年度\n" +
            "CH0S01 AS CH0S01, --病案号\n" +
            "CH0S02 AS CH0S02, --序号\n" +
            "CH0S03 AS CH0S03, --ICU类型\n" +
            "CH0S04 AS CH0S04, --入住时间\n" +
            "CH0S05 AS CH0S05, --转出时间\n" +
            "CH0S06 AS CH0S06, --再次入住ICU计划 无有\n" +
            "CH0S07 AS CH0S07, --再次入住原因\n" +
            "CH0S08 AS CH0S08 --患者进监护室患者APACHE Ⅱ评分\n" +
            "from dcLinkvsch_CH0S " +
            "where CHYear='@@@' and CH0S01='!!!'";
    @Autowired
    private HpDictMapService dictMapService;

    /**
     * 初始化查询s表数据
     */
    public List<HpVsch0SEntity> findSForInit(String year, String bah, String hiscode, String dclink)  {
       return  selectListWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dclink),HpVsch0SEntity.class);
//        List<Map<String, Object>> maps = selectSqlWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dclink));
//        if (null == maps || maps.size() == 0) {
//            return null;
//        }
//        List<HpVsch0SEntity> entitys = new ArrayList<>();
//        for (Map<String, Object> e : maps) {
//            e = dictMapService.operationMappingDictData(e, hiscode);
//            entitys.add(JSON.parseObject(JSON.toJSONString(e), HpVsch0SEntity.class));
//        }
//        return entitys;
    }
}
