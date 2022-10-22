package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpVsch0FEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpVsch0FService extends BaseUUIDServiceImpl<HpVsch0FEntity> {

//    @Autowired
//    private HpDictMapService dictMapService;
    private String sql = "select CHYEAR AS CHYEAR, --病案年度\n" +
            "CH0F01 AS CH0F01, --病案号\n" +
            "CH0F02 AS CH0F02, --根本死因\n" +
            "Ch0F05 AS Ch0F05, --尸检诊断\n" +
            "Ch0F06 AS Ch0F06, --尸检诊断符合标识\n" +
            "Ch0F07 AS Ch0F07, --死亡时间(时分)\n" +
            "Ch0F08 AS Ch0F08, --根本死因ICD10\n" +
            "Ch0F09 AS Ch0F09 --尸体解剖号\n" +
            "from dcLinkvsch_CH0F " +
            "where CHYear='@@@' and CH0F01='!!!'";

    /**
     * 初始化查询f表数据
     */
    public HpVsch0FEntity findFForInit(String year, String bah, String hiscode, String dcLink)  {
        List<HpVsch0FEntity> list = selectListWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dcLink), HpVsch0FEntity.class);
        if(CollUtil.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
//        List<Map<String, Object>> maps = selectSqlWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dcLink));
//        if (null == maps || maps.size() == 0) {
//            return null;
//        }
//        Map<String, Object> map = dictMapService.operationMappingDictData(maps.get(0), hiscode);
//        return JSON.parseObject(JSON.toJSONString(map), HpVsch0FEntity.class);
    }
}
