package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.config.DrPlusApplicationRunnerImpl;
import com.sxdl.drplus.dao1.DrPlusPlatformDetailedDao;
import com.sxdl.drplus.dao1.DrplusJbicdDao;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.entity.DrplusJbicd;
import com.sxdl.drplus.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DrplusJbicdService extends BaseUUIDServiceImpl<DrplusJbicd> {

    @Autowired
    private DrplusJbicdDao jbicdDao;

    @Autowired
    private DrPlusPlatformDetailedDao platformDao;


    public List<DrplusJbicd> getDetailedByPid(Integer pid,String val) {
        return jbicdDao.getDetailedByPid(pid,val);
    }

    public Integer saveImportDataICD(String sqltext) {
        return jbicdDao.saveImportDataICD(sqltext);
    }

    public Integer getCountByVersionId(Integer pid) {
        return jbicdDao.getCountBytype(pid);
    }

    public Integer delByVersionId(Integer pid) {
        return jbicdDao.delByVersionId(pid);
    }
    public Integer insertBysql(String sqltext) {
        return jbicdDao.saveImportDataICD(sqltext);
    }

    public void delinsertICD(Integer pid,Integer type ) {
        Integer integer =jbicdDao.delByVersionId(pid);
        // (注意主键问题)拼接sql insert into table (col1,col2,col3) values (1,2,versionId),(1,2,versionId)  执行
        List<Map<String,Object>> list = (List<Map<String, Object>>) DrPlusApplicationRunnerImpl.contextMap.get("execl");
        StringBuilder sb =  DataUtil.getInsertSqlText(list,type,pid);
        Integer  i = jbicdDao.saveImportDataICD(sb.toString());
        return;
    }

    public void delinsertICDSql(Integer pid, String sqltext) {
        Integer integer = jbicdDao.delByVersionId(pid);
        Integer integer2 = jbicdDao.saveImportDataICD(sqltext);
    }


    public List<DrplusJbicd> getDetailedByPlateFormPid(Integer pid, String val) {
        DrPlusPlatformDetailed detailed = platformDao.selectByPrimaryKey(pid);
        Integer ask_jb_version_id = detailed.getAsk_jb_version_id();
        return jbicdDao.getDetailedByPid(ask_jb_version_id,val);
    }
}
