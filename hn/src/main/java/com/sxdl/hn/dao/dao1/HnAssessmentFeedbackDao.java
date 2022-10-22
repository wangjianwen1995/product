package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnAssessmentFeedback;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//考核反馈（反馈信息补录数据）
public interface HnAssessmentFeedbackDao extends BaseDao<HnAssessmentFeedback> {

    @Select("select * from assessment_feedback where feedback_time between '${fbstime}' and '${fbetime}' and is_hlb=${ishlb}  order by id desc" )
    List<HnAssessmentFeedback> findByCanAllKs(String fbstime, String fbetime, int ishlb);


    @Select(" select  * from assessment_feedback where feedback_time  between '${fbstime}' and '${fbetime}' and is_hlb=${ishlb}  and assessment_kscode in (${allkscodes})   order by id desc")
    List<HnAssessmentFeedback> findByCanseeKs(String fbstime, String fbetime, String allkscodes, int ishlb);

    @Select(" select * from assessment_feedback where feedback_time  between '${fbstime}' and '${fbetime}' and  is_hlb=${ishlb}  and assessment_kscode = '${kscode}'   order by id desc")
    List<HnAssessmentFeedback> findByKs(String fbstime, String fbetime, String kscode, int ishlb);
}
