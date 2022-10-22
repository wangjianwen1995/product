package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnAssessmentQuestions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//护理质量考核存储问题记录表
public interface HnAssessmentQuestionsDao extends BaseDao<HnAssessmentQuestions> {

    @Select("select * from assessment_questions where is_hlb = 1 and isnull(assessment_feedback_id,'')='' and assessment_time between '${stime}' and '${etime}'  ")
    List<HnAssessmentQuestions> findHlbassessmentQuestions(String stime, String etime);

    @Select("select * from assessment_questions where is_hlb = -1 and isnull(assessment_feedback_id,'')='' and  assessment_time between '${stime}' and '${etime}' and kscode='${kscode}'")
    List<HnAssessmentQuestions> findKsassessmentQuestions(String stime, String etime, String kscode);

    @Select("select * from assessment_questions where assessment_feedback_id = ${id} ")
    List<HnAssessmentQuestions> findbybackId(Integer id);


    @Delete("delete from assessment_questions where assessment_id = ${id}")
    Integer deleteByPid(Integer id);

    @Select("select * from assessment_questions where assessment_id = ${id} ")
    List<HnAssessmentQuestions> findbypid(Integer id);
}
