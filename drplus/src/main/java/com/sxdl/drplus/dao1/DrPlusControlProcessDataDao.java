package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.dto.ProcessDataDBO;
import com.sxdl.drplus.entity.DrPlusControlProcessData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusControlProcessDataDao extends BaseUUIDDao<DrPlusControlProcessData> {


    @Select(" select ${pid} drplus_platform_detailed_id,  ${eid} drplus_extract_detailed," +
            "        a.PRIMAEYKEY patient_key, a.NAME patient_name, a.ZYH patient_zyh, a.CYSJ patient_cysj  " +
            " from  drplus_center_table_data${pid}${tab} a " +
            " where exists(select 1 from  drplus_control_result b where b.drplus_extract_detailed_id = ${eid} and b.primary_keyval = a.PRIMAEYKEY ) " +
            " and (a.NAME like '%${val}%' or a.ZYH like '%${val}%' or a.PRIMAEYKEY like '%${val}%')")
    List<ProcessDataDBO> drillDownControl(Integer pid, Integer eid,    String val,String tab);





}
