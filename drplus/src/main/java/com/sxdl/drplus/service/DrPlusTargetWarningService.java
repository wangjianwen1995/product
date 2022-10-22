package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusTargetWarningDao;
import com.sxdl.drplus.entity.DrPlusTargetWarning;
import com.sxdl.drplus.util.SplicingSqlScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@Transactional
public class DrPlusTargetWarningService extends BaseServiceImpl<DrPlusTargetWarning> {


    @Autowired
    private DrPlusTargetWarningDao targetWarningDao;

    public List<DrPlusTargetWarning> getTargetList(Object pid, Object val) {
        return targetWarningDao.getTargetList(convert(pid,Integer.class),convert(val,String.class));
    }


    public void enableTarget(Integer id, Integer onOff) {
        targetWarningDao.enableTarget(id,onOff);
    }

    public List<DrPlusTargetWarning> getTargetByPid(Integer pid) {
        DrPlusTargetWarning target = new DrPlusTargetWarning();
        target.setIsqy(1);
        target.setDrplus_platform_detailed_id(pid);
        return targetWarningDao.select(target);
    }


    //key 原理:这里只有一个聚合函数 不需要group by 分组
    public List<LinkedHashMap<String, Object>> getTargetResult(Integer pid, Integer eid) {
        List<DrPlusTargetWarning> list = getTargetByPid(pid);
        String sqlText = SplicingSqlScript.splicingTargetResultSql(list, pid, eid);
        List<LinkedHashMap<String, Object>> dataBySql = targetWarningDao.getDataBySql(sqlText);
        return dataBySql;
    }

    public Integer getTestTarget(Integer pid,String sql, Integer isuse,String usetable) {
        StringBuilder sb = new StringBuilder("select "+sql);
        if (pid==6 || pid==7|| pid==10|| pid==15) {
            sb.append(" from drplus_center_table_data"+pid+"a ");
            if(!StringUtils.isEmpty(isuse)&& 1==isuse){
                if(StringUtils.isEmpty(usetable)){
                    sb.append(" a left join drplus_center_table_data"+pid+"b b on b.PRIMAEYKEY= a.PRIMAEYKEY ");
                }else{
                    // 10 平台 选择了子表
                    for (String tab : usetable.split(",")) {
                        sb.append(" a left join drplus_center_table_data"+pid+tab+" "+tab+" on "+tab+".PRIMAEYKEY= a.PRIMAEYKEY ");
                    }
                }
            }
        }else{
            sb.append(" from drplus_center_table_data"+pid);
        }
        sb.append(" where 1=1");
        return targetWarningDao.TestTarget(sb.toString());
    }
}
