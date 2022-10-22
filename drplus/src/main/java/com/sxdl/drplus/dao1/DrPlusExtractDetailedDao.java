package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.dto.QQRDBO;
import com.sxdl.drplus.entity.DrPlusExtractDetailed;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusExtractDetailedDao extends BaseDao<DrPlusExtractDetailed> {


    /**  quality_question_num       质控出有问题的数据
         actual_extract_num         实际抽取
         quality_exception_num      质控异常的数据:报错的
     *   review_pass_num            审核通过数据
     *   review_failed_num          审核不通过数据
         report_pass_num            上报成功数据
         report_failed_num          上报失败数据
     */
    @Select(" select a.*," +
            "       (select  count(distinct primary_keyval) from drplus_control_result b where a.id = b.drplus_extract_detailed_id) quality_question_num ," +
            "       (select count(1) from drplus_errorlog c where   a.id = c.drplus_extract_detailed_id ) quality_exception_num ," +
            "       (select count(1) from drplus_center_table_data${pid}${tab} h where a.id = h.drplus_extract_detailed_id ) actual_extract_num ," +
            "       (select count(1) from drplus_data_type d " +
            "          inner join drplus_center_table_data${pid}${tab} t on d.drplus_platform_detailed_id =${pid} and d.primarykey_val=t.PRIMAEYKEY " +
            "          where a.id = t.drplus_extract_detailed_id and isnull(d.review_type,0)=1) review_pass_num ," +
            "       (select count(1) from drplus_data_type e " +
            "          inner join drplus_center_table_data${pid}${tab} t on e.drplus_platform_detailed_id =${pid} and e.primarykey_val=t.PRIMAEYKEY " +
            "        where a.id = t.drplus_extract_detailed_id and isnull(e.review_type,0)=-1) review_failed_num ," +
            "       (select count(1) from drplus_data_type f " +
            "          inner join drplus_center_table_data${pid}${tab} t on f.drplus_platform_detailed_id =${pid} and f.primarykey_val=t.PRIMAEYKEY " +
            "        where a.id = t.drplus_extract_detailed_id and (isnull(f.report_type,0)=1 or isnull(f.report_type,0)=-2)) report_pass_num ," +
            "       (select count(1) from drplus_data_type g " +
            "          inner join drplus_center_table_data${pid}${tab} t on g.drplus_platform_detailed_id =${pid} and g.primarykey_val=t.PRIMAEYKEY " +
            "       where a.id = t.drplus_extract_detailed_id and isnull(g.report_type,0)=-1) report_failed_num " +
            "  from drplus_extract_detailed a" +
            " where a.drplus_platform_detailed_id = ${pid}  and a.is_auto =${is_auto}  " +
            " order by create_time desc ")
    List<DrPlusExtractDetailed> getQualityResultData(Integer pid,  Integer is_auto,String tab);


    @Insert("${sql}")
    Integer insetSql(String sql);

    @Select("${sql}")
    Integer selectNUM(String sql);


    @Delete("${sql}")
    Integer deleteToSql(String sql);


    @Select(" select [type],result_message,COUNT(*) count_value  from drplus_control_result where drplus_platform_detailed_id=${pid} and drplus_extract_detailed_id=${eid} " +
            " group by result_message,type  order by COUNT(*)")
    List<QQRDBO> getQualityQuestionResult(Integer pid, Integer eid);
}
