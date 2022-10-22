package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnQualityAssessment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//质量考核保存表(只保存问题数据，和公共抬头数据)
public interface HnQualityAssessmentDao extends BaseDao<HnQualityAssessment> {

    @Select("select * from quality_assessment where template_id=${templateId}")
    List<HnQualityAssessment> findByTemplateId(Integer templateId);

    @Select("select * from quality_assessment where time between '${stime}' and '${etime}' and is_hlb= ${is_hlb} and suborder_id = ${suborder_id} order by id desc ")
    List<HnQualityAssessment> findByCanAllKs(String stime, String etime, Integer is_hlb, Integer suborder_id);

    @Select("select * from quality_assessment where time between '${stime}' and '${etime}' and ks_code in (${allkscodes}) and is_hlb= ${is_hlb} and suborder_id = ${suborder_id} order by id desc ")
    List<HnQualityAssessment> findByCanseeKs(String stime, String etime, String allkscodes, Integer is_hlb, Integer suborder_id);

    @Select("select * from quality_assessment where time between '${stime}' and '${etime}' and ks_code ='${kscode}' and is_hlb= ${is_hlb} and suborder_id = ${suborder_id} order by id desc ")
    List<HnQualityAssessment> findByKs(String stime, String etime, String kscode, Integer is_hlb, Integer suborder_id);
}
