package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.config.DrPlusApplicationRunnerImpl;
import com.sxdl.drplus.dao1.DrPlusPlatformDetailedDao;
import com.sxdl.drplus.dao1.DrplusSsicdDao;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.entity.DrplusSsicd;
import com.sxdl.drplus.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DrplusSsicdService extends BaseUUIDServiceImpl<DrplusSsicd> {

    @Autowired
    private DrplusSsicdDao ssicdDao;

    @Autowired
    private DrPlusPlatformDetailedDao platformDao;


    public List<DrplusSsicd> getDetailedByPid(Integer pid, String val) {
        return ssicdDao.getDetailedByPid(pid, val);
    }

    public Integer saveImportDataICD(String sqltext) {
        return ssicdDao.saveImportDataICD(sqltext);
    }

    public Integer getCountByVersionId(Integer versionId) {
        return ssicdDao.getCountBytype(versionId);
    }

    public Integer delByVersionId(Integer pid) {
        return ssicdDao.delByVersionId(pid);
    }

    public Integer insertBysql(String sqltext) {
        return ssicdDao.saveImportDataICD(sqltext);
    }

    public void delinsertICD(Integer pid, Integer type) {
        Integer integer = ssicdDao.delByVersionId(pid);
        // (注意主键问题)拼接sql insert into table (col1,col2,col3) values (1,2,versionId),(1,2,versionId)  执行
        List<Map<String, Object>> list = (List<Map<String, Object>>) DrPlusApplicationRunnerImpl.contextMap.get("execl");
        StringBuilder sb = DataUtil.getInsertSqlText(list, type, pid);
        Integer i = ssicdDao.saveImportDataICD(sb.toString());

        return;
    }

    public void delinsertICDSql(Integer pid, String sqltext) {
        Integer integer = ssicdDao.delByVersionId(pid);
        Integer integer2 = ssicdDao.saveImportDataICD(sqltext);
        return;
    }


    public List<DrplusSsicd> getDetailedByPlateFormPid(Integer pid, String val) {
        DrPlusPlatformDetailed detailed = platformDao.selectByPrimaryKey(pid);
        Integer ask_ss_version_id = detailed.getAsk_ss_version_id();
        return ssicdDao.getDetailedByPid(ask_ss_version_id, val);
    }
}