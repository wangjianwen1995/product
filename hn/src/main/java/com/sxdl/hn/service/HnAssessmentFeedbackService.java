package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HnAssessmentFeedbackDao;
import com.sxdl.hn.dao.dao1.HnAssessmentQuestionsDao;
import com.sxdl.hn.entity.HnAssessmentFeedback;
import com.sxdl.hn.entity.HnAssessmentQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//考核反馈（反馈信息补录数据）
@Service
@Transactional
public class HnAssessmentFeedbackService extends BaseServiceImpl<HnAssessmentFeedback> {

    @Autowired
    private HnAssessmentFeedbackDao feedbackDao;

    @Autowired
    private HnAssessmentQuestionsDao questionsDao;

    public Integer startFeedbackHlb(List<HnAssessmentQuestions> questionsList, String stime, String etime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String newdate = df.format(new Date());
        Map<String, List<HnAssessmentQuestions>> map = questionsList.stream().collect(Collectors.groupingBy(e -> e.getKscode()));
        map.forEach((k,v)->{
            //1保存 反馈主表数据
            HnAssessmentFeedback feedback = new HnAssessmentFeedback();
            feedback.setAssessment_time(stime+"~"+etime);
            feedback.setAssessment_kscode(k);
            feedback.setAssessor(v.get(0).getAssessor());
            feedback.setFeedback_time(newdate);
            feedback.setIs_hlb(1);
            feedback.setHead_nurse(v.get(0).getHead_nurse());
            int insert = feedbackDao.insert(feedback);
            //修改问题明细数据的 反馈id
            v.forEach(e->{
                e.setAssessment_feedback_id(feedback.getId());
                int i = questionsDao.updateByPrimaryKey(e);
            });
        });

        return 1;

    }

    public Integer startFeedbackKs(List<HnAssessmentQuestions> questionsList, String stime, String etime, String kscode) {

       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       String newdate = df.format(new Date());
       HnAssessmentFeedback feedback = new HnAssessmentFeedback();
       feedback.setAssessment_time(stime+"~"+etime);
       feedback.setAssessment_kscode(kscode);
       feedback.setAssessor(questionsList.get(0).getAssessor());
       feedback.setFeedback_time(newdate);
       feedback.setIs_hlb(-1);
       feedback.setHead_nurse(questionsList.get(0).getHead_nurse());
       //1保存 反馈主表数据
       Integer insert = feedbackDao.insert(feedback);
       //修改问题明细数据的 反馈id
       questionsList.forEach(e->{
           e.setAssessment_feedback_id(feedback.getId());
           int i = questionsDao.updateByPrimaryKey(e);
       });

        return  insert;

    }

    public Integer upateMeasures(HnAssessmentFeedback feedback) {
        int i = feedbackDao.updateByPrimaryKey(feedback);
        feedback.getQuestions().forEach(e->{
            int i1 = questionsDao.updateByPrimaryKey(e);
        });
        return  i;
    }

    public Integer upateMeasuresHs(List<HnAssessmentQuestions> questions ) {
        questions.forEach(e->{
            int i1 = questionsDao.updateByPrimaryKey(e);
        });
       return 1;
    }

    public Integer delFeedback(Integer Id) {
        int delete = feedbackDao.deleteByPrimaryKey(Id);
        List<HnAssessmentQuestions> questions = questionsDao.findbybackId(Id);
        for (HnAssessmentQuestions question : questions) {
            question.setAssessment_feedback_id(null);
            int i = questionsDao.updateByPrimaryKey(question);
        }
        return delete;
    }

    public List<HnAssessmentFeedback> findByCanAllKs(String fbstime, String fbetime, int ishlb) {
        List<HnAssessmentFeedback> list = feedbackDao.findByCanAllKs(fbstime,fbetime,ishlb);
        return list;
    }


    public List<HnAssessmentFeedback> findByCanseeKs(String fbstime, String fbetime, String allkscodes, int ishlb) {
        List<HnAssessmentFeedback> list = feedbackDao.findByCanseeKs(fbstime,fbetime,allkscodes,ishlb);
        return list;
    }

    public List<HnAssessmentFeedback> findByKs(String fbstime, String fbetime, String kscode, int ishlb) {
        List<HnAssessmentFeedback> list = feedbackDao.findByKs(fbstime,fbetime,kscode,ishlb);
        return list;
    }
}
