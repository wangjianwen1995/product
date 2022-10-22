package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HnAssessmentQuestionsDao;
import com.sxdl.hn.entity.HnAssessmentQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//护理质量考核储存问题表
@Service
@Transactional
public class HnAssessmentQuestionsService extends BaseServiceImpl<HnAssessmentQuestions> {

    @Autowired
    private HnAssessmentQuestionsDao questionsDao;

    public List<HnAssessmentQuestions> findHlbassessmentQuestions(String stime, String etime) {
        List<HnAssessmentQuestions> list =  questionsDao.findHlbassessmentQuestions(stime,etime);
        return  list;

    }

    public List<HnAssessmentQuestions> findKsassessmentQuestions(String stime, String etime, String kscode) {
        List<HnAssessmentQuestions> list =  questionsDao.findKsassessmentQuestions(stime,etime,kscode);
        return  list;
    }

    public List<HnAssessmentQuestions> findbybackId(Integer id) {
        return  questionsDao.findbybackId(id);
    }

    public List<HnAssessmentQuestions> findquestionsByPid(Integer id) {
        return  questionsDao.findbypid(id);
    }
}
