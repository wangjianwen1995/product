package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcScheduleConfig;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DcScheduleConfigDao extends BaseUUIDDao<DcScheduleConfig> {

    @Select(" " +
            "select '' as id ,  " +
            "'' as Product_id,  " +
            "id as Job_id,  " +
            "name as Job_name, " +
            "null as parent_id,  " +
            "null    as Product_name, " +
            "null as procedure_id,  " +
            "''      as procedure_name, " +
            "name as name,  " +
            "'' as Prent_procedure_id,  " +
            "0 as Ordernum, " +
            "'' as scope,  " +
            "rule_id as rule_id, " +
            "param as param, " +
            "param_unit as param_unit, " +
            "rule_suffix as rule_suffix, " +
            "0 as type_id, " +
            "0 as is_single " +
            "from dc_job  " +
        "union all  " +
            "select '' as id ,  " +
            "'' as Product_id,  " +
            "a.id as Job_id,  " +
            "b.name as Job_name, " +
            "Job_id as parent_id, " +
            "null    as Product_name, " +
            "a.id as procedure_id,  " +
            "a.name  as procedure_name, " +
            "a.name as name,  " +
            "''as Prent_procedure_id,  " +
            "0 as Ordernum, " +
            "scope as scope,  " +
            "b.rule_id as rule_id, " +
            "isparam as param, " +
            "b.param_unit as param_unit, " +
            "b.rule_suffix as rule_suffix, " +
            "2 as type_id, " +
            "support_single as is_single " +
            "from dc_procedure a left join dc_job b on a.job_id=b.id ${flag}" +
        "union all   " +
            "select '' as id ,  " +
            "'' as Product_id,  " +
            "a.id as Job_id,  " +
            "b.name as Job_name, " +
            "Job_id as parent_id,  " +
            "null    as Product_name, " +
            "a.id as procedure_id,  " +
            "a.name  as procedure_name, " +
            "a.name as name,  " +
            "'' as Prent_procedure_id,  " +
            "0 as Ordernum , " +
            "scope as scope,  " +
            "b.rule_id as rule_id, " +
            "b.param as param, " +
            "b.param_unit as param_unit, " +
            "b.rule_suffix as rule_suffix, " +
            "1 as type_id, " +
            "0 as is_single " +
            "from dc_request_api a left join dc_job b on a.job_id=b.id ")
    List<DcScheduleConfig> findData(String flag);

    @Select("select * from dc_schedule_config where rule_id='${info}' and isnull(type_id,0)!=0 and isnull(is_single,1)=1  and Product_id in (select id from dc_product where status=1) order by Product_id")
    List<DcScheduleConfig> selectCanAutoRun(String info);
    @Select("select * from dc_schedule_config where Product_id in (${id})")
    List<DcScheduleConfig> selectByProduct(String id);

    @Select("select distinct Product_id,Product_name from dc_schedule_config ")
    List<DcScheduleConfig> findPzProduct();

    @Select("select * from dc_schedule_config where job_id='${jobId}' or parent_id='${jobId}'")
    List<DcScheduleConfig> findAlreadyPz(String jobId);

    @Select("select * from dc_schedule_config where ${column} in (${ids}) and isnull(is_single,1)=${is_single} order by Ordernum,${column}")
    List<DcScheduleConfig> selectBySingleId(String ids,String column,Integer is_single);


    @Select("select * from dc_schedule_config where Product_id = '${id}' and isnull(single_id,1)='${singleId}' order by Ordernum ")
    List<DcScheduleConfig> selectSort(String id,String singleId);

}