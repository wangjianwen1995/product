package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpVsch0HEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpVsch0HService extends BaseUUIDServiceImpl<HpVsch0HEntity> {

//    @Autowired
//    HpDictMapService dictMapService;
    private String sql = "select ChYear AS ChYear, --年度\n" +
            "Ch0H01 AS Ch0H01, --病案号\n" +
            "Ch0H02 AS Ch0H02, --输血量：红细胞\n" +
            "Ch0H03 AS Ch0H03, --输血量：血小板\n" +
            "Ch0H04 AS Ch0H04, --输血量：血浆\n" +
            "Ch0H05 AS Ch0H05, --输血量：全血\n" +
            "Ch0H06 AS Ch0H06, --输血量：其它\n" +
            "Ch0H07 AS Ch0H07, --输血量：自体回收\n" +
            "Ch0H08 AS Ch0H08, --输血次数\n" +
            "Ch0H09 AS Ch0H09, --输血反应次数\n" +
            "Ch0H10 AS Ch0H10, --输液次数\n" +
            "CH0HN1 AS CH0HN1 --输液反应次数\n" +
            "from dcLinkvsch_CH0H " +
            "where CHYear='@@@' and CH0H01='!!!'";

    /**
     * 初始化查询H表数据
     */
    public HpVsch0HEntity findHForInit(String year, String bah, String hiscode, String dclink)  {
        List<HpVsch0HEntity> list = selectListWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dclink), HpVsch0HEntity.class);
        if(CollUtil.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
        //        List<Map<String, Object>> maps = selectSqlWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dclink));
//
//        if (null == maps || maps.size() == 0) {
//            return null;
//        }
//        Map<String, Object> map = dictMapService.operationMappingDictData(maps.get(0), hiscode);
//        return JSON.parseObject(JSON.toJSONString(map), HpVsch0HEntity.class);
    }


}
