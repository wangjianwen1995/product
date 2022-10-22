package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.*;
import com.sxdl.hn.dto.StartAssessmentEndDBO;
import com.sxdl.hn.entity.*;
import com.sxdl.hn.util.MyListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//质量考核保存表(只保存公共抬头数据)
@Service
@Transactional
public class HnQualityAssessmentService extends BaseServiceImpl<HnQualityAssessment> {

    @Autowired
    HnQualityAssessmentDao assessmentDao;

    @Autowired
    HnAssessmentQuestionsDao questionsDao;

    @Autowired
    HnChecktypeADao checktypeADao;

    @Autowired
    HnChecktypeBDao checktypeBDao;

    @Autowired
    HnChecktypeCDao checktypeCDao;
    @Autowired
    HnChecktypeDDao checktypeDDao;

    @Autowired
    HnChecktypeEDao checktypeEDao;
    @Autowired
    HnHandleDao hnHandleDao;



    public List<HnQualityAssessment> findByTemplateId(Integer templateId){
        return  assessmentDao.findByTemplateId(templateId);
    }

    public Integer saveAllAssessment(HnQualityAssessment hnQualityAssessment) {
        List<HnAssessmentQuestions> questions = hnQualityAssessment.getQuestions();
        int insert = assessmentDao.insert(hnQualityAssessment);
        questions.forEach(e->{
            e.setAssessment_id(hnQualityAssessment.getId());
            int insert1 = questionsDao.insert(e);
        });
        String checktype = hnQualityAssessment.getChecktype();
        if("a".equals(checktype)){ //保存患者
            List<HnChecktypeA> checktypeA = hnQualityAssessment.getChecktypeA();
            checktypeA.forEach(e->{
                e.setAssessment_id(hnQualityAssessment.getId());
                int insert1 = checktypeADao.insert(e);
            });
        }else{//保存护士
            List<HnChecktypeD> checktypeD = hnQualityAssessment.getChecktypeD();
            checktypeD.forEach(e->{
                e.setAssessment_id(hnQualityAssessment.getId());
                int insert1 = checktypeDDao.insert(e);
            });
            if("b".equals(checktype)){
                HnChecktypeB checktypeB = hnQualityAssessment.getChecktypeB();
                checktypeB.setAssessment_id(hnQualityAssessment.getId());
                int insert1 = checktypeBDao.insert(checktypeB);
            }else if("c".equals(checktype)){
                HnChecktypeC checktypeC = hnQualityAssessment.getChecktypeC();
                checktypeC.setAssessment_id(hnQualityAssessment.getId());
                int insert1 = checktypeCDao.insert(checktypeC);
            }else if("e".equals(checktype)){
                HnChecktypeE checktypeE = hnQualityAssessment.getChecktypeE();
                checktypeE.setAssessment_id(hnQualityAssessment.getId());
                int insert1 = checktypeEDao.insert(checktypeE);
            }
        }
        return insert;

    }

    public Integer updateAllAssessment(HnQualityAssessment hnQualityAssessment) {
        int insert = assessmentDao.updateByPrimaryKey(hnQualityAssessment);
        List<HnAssessmentQuestions> questions = hnQualityAssessment.getQuestions();
        Integer i = hnHandleDao.delQuestionsByAId(hnQualityAssessment.getId());
        questions.forEach(e->{
            e.setAssessment_id(hnQualityAssessment.getId());
            int insert1 = questionsDao.insert(e);
        });
        String checktype = hnQualityAssessment.getChecktype();
        if("a".equals(checktype)){
            Integer del = hnHandleDao.delByAId(hnQualityAssessment.getId());
            List<HnChecktypeA> checktypeA = hnQualityAssessment.getChecktypeA();
            checktypeA.forEach(e->{
                e.setAssessment_id(hnQualityAssessment.getId());
                int insert1 = checktypeADao.insert(e);
            });
        }else  {
            Integer del = hnHandleDao.delByDId(hnQualityAssessment.getId());
            List<HnChecktypeD> checktypeD = hnQualityAssessment.getChecktypeD();
            checktypeD.forEach(e->{
                e.setAssessment_id(hnQualityAssessment.getId());
                int insert1 = checktypeDDao.insert(e);
            });

            if("b".equals(checktype)){
                HnChecktypeB checktypeB = hnQualityAssessment.getChecktypeB();
                //checktypeB.setAssessment_id(hnQualityAssessment.getId());
                int update = checktypeBDao.updateByPrimaryKey(checktypeB);
            }else if("c".equals(checktype)){
                HnChecktypeC checktypeC = hnQualityAssessment.getChecktypeC();
                //checktypeC.setAssessment_id(hnQualityAssessment.getId());
                int update = checktypeCDao.updateByPrimaryKey(checktypeC);
            }else if("e".equals(checktype)){
                HnChecktypeE checktypeE = hnQualityAssessment.getChecktypeE();
                //checktypeC.setAssessment_id(hnQualityAssessment.getId());
                int update = checktypeEDao.updateByPrimaryKey(checktypeE);
            }
        }
        return insert;
    }

    public Integer delAssessmentByid(Integer id,String checktype) {
        int deleteByPrimaryKey = assessmentDao.deleteByPrimaryKey(id);
        Integer del = questionsDao.deleteByPid(id);
        if("a".equals(checktype)){
            Integer deleteByPid = checktypeADao.deleteByPid(id);
        }else if("b".equals(checktype)){
            Integer deleteByPid = checktypeBDao.deleteByPid(id);
            Integer integer = checktypeDDao.deleteByPid(id);
        }else if("c".equals(checktype)){
            Integer deleteByPid = checktypeCDao.deleteByPid(id);
            Integer integer = checktypeDDao.deleteByPid(id);
        }else if("e".equals(checktype)){
            Integer deleteByPid = checktypeEDao.deleteByPid(id);
            Integer integer = checktypeDDao.deleteByPid(id);
        }else if("d".equals(checktype)){
            Integer integer = checktypeDDao.deleteByPid(id);
        }
        return deleteByPrimaryKey;

    }

    public StartAssessmentEndDBO updateAssessment(StartAssessmentEndDBO startAssessmentEndDBO,Integer id) throws
            Exception{

        StartAssessmentEndDBO startAssessment = MyListUtil.deepCopyObj(startAssessmentEndDBO);




        HnQualityAssessment quality = selectByKey(id);
        startAssessment.setIs_hlb(quality.getIs_hlb());
        startAssessment.setSuborder_id(quality.getSuborder_id());
        startAssessment.setTemplate_id(quality.getTemplate_id());
        startAssessment.setChecktype(quality.getChecktype());
        startAssessment.setKs_code(quality.getKs_code());
        startAssessment.setTime(quality.getTime());
        startAssessment.setAssessor(quality.getAssessor());
        startAssessment.setTotal_score(quality.getTotal_score());
        startAssessment.setScore_value(quality.getScore_value());
        startAssessment.setDeduction_value(quality.getDeduction_value());
        startAssessment.setPass_rate(quality.getPass_rate());
        startAssessment.setHead_nurse(quality.getHead_nurse());
        if ("a".equals(quality.getChecktype())){
            List<HnChecktypeA> typeA = checktypeADao.findByPid(quality.getId());
            startAssessment.setChecktypeA(typeA);

        }else{
            List<HnChecktypeD> typeD = checktypeDDao.findByPid(quality.getId());
            startAssessment.setChecktypeD(typeD);
            if("b".equals(quality.getChecktype())){
                HnChecktypeB typeB = checktypeBDao.findByPid(quality.getId());
                startAssessment.setChecktypeB(typeB);
            }else if("c".equals(quality.getChecktype())){
                HnChecktypeC typeC = checktypeCDao.findByPid(quality.getId());
                startAssessment.setChecktypeC(typeC);
            }
        }
        return startAssessment;
    }

    public List<HnChecktypeA> findbyPidA(Integer id) {
        return checktypeADao.findByPid(id);
    }

    public List<HnChecktypeD> findbyPidD(Integer id) {
        return checktypeDDao.findByPid(id);
    }

    public HnChecktypeB findbyPidB(Integer id) {
        return checktypeBDao.findByPid(id);
    }

    public HnChecktypeC findbyPidC(Integer id) {
        return checktypeCDao.findByPid(id);
    }
    public HnChecktypeE findbyPidE(Integer id) {
        return checktypeEDao.findByPid(id);
    }

    public List<HnQualityAssessment> findByCanAllKs(String stime, String etime, Integer is_hlb, Integer suborder_id) {
        return assessmentDao.findByCanAllKs(stime,etime,is_hlb,suborder_id);
    }

    public List<HnQualityAssessment> findByCanseeKs(String stime, String etime, String allkscodes, Integer is_hlb, Integer suborder_id) {
        return assessmentDao.findByCanseeKs(stime,etime,allkscodes,is_hlb,suborder_id);
    }

    public List<HnQualityAssessment> findByKs(String stime, String etime, String kscode, Integer is_hlb, Integer suborder_id) {
        return assessmentDao.findByKs(stime,etime,kscode,is_hlb,suborder_id);
    }
}
