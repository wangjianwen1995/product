package com.sxdl.hn.service;


import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.*;
import com.sxdl.hn.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class PersonnelFilesService extends BaseServiceImpl<HnBasicInfo> {

    @Autowired
    private PersonnelFilesDao personnelFilesDao; //基础模块

    @Autowired
    private HnAcademicInfoDao academicInfoDao; //学术团体

    @Autowired
    private HnAssessmentInfoDao assessmentInfoDao; //考核登记

    @Autowired
    private HnAwardInfoDao awardInfoDao; // 创造发明、科研成果和技术业务工作授奖登记

    @Autowired
    private HnEducationInfoDao educationInfoDao;  //学历信息


    @Autowired
    private HnInternationalInfoDao internationalInfoDao; //出国短期学习、考察及参加国际学术活动等情况


    @Autowired
    private HnLanguageInfoDao languageInfoDao; // 外语能力

    @Autowired
    private HnMainexperienceInfoDao mainexperienceInfoDao; //主要经历

    @Autowired
    private HnMaintechnologyInfoDao maintechnologyInfoDao; //担任过得主要技术工作

    @Autowired
    private HnSocialpostInfoDao socialpostInfoDao; //社会兼职

    @Autowired
    private  HnTraininglearningInfoDao traininglearningInfoDao ; //培训学习记录

    @Autowired
    private HnTrainingtalentsInfoDao trainingtalentsInfoDao; //培养人才情况登记

    @Autowired
    private HnWorkexperienceInfoDao workexperienceInfoDao; //工作经历

    @Autowired
    private HnWorksandpapersInfoDao worksandpapersInfoDao;//著作与论文登记


    public Integer save(HnBasicInfo basicInfo) {

        int pid = personnelFilesDao.insert(basicInfo);
        if(!StringUtils.isEmpty(basicInfo.getAcademicInfos())){
            basicInfo.getAcademicInfos().forEach(e->{
                e.setPid(pid);
                academicInfoDao.insert(e);
            });

        }

        if(!StringUtils.isEmpty(basicInfo.getWorkexperienceInfos())){
            basicInfo.getWorksandpapersInfos().forEach(e->{
                e.setPid(pid);
                worksandpapersInfoDao.insert(e);
            });
        }

        if(!StringUtils.isEmpty(basicInfo.getWorkexperienceInfos())){
            basicInfo.getWorkexperienceInfos().forEach(e->{
                e.setPid(pid);
                workexperienceInfoDao.insert(e);
            });
        }

        if(!StringUtils.isEmpty(basicInfo.getTraininglearningInfos())){
            basicInfo.getTraininglearningInfos().forEach(e->{
                e.setPid(pid);
                traininglearningInfoDao.insert(e);
            });
        }




        if(!StringUtils.isEmpty(basicInfo.getSocialpostInfos())){
            basicInfo.getSocialpostInfos().forEach(e->{
                e.setPid(pid);
                socialpostInfoDao.insert(e);
            });
        }

        if(!StringUtils.isEmpty(basicInfo.getMaintechnologyInfos())){
            basicInfo.getMaintechnologyInfos().forEach(e->{
                e.setPid(pid);
                maintechnologyInfoDao.insert(e);
            });
        }

        if(!StringUtils.isEmpty(basicInfo.getMainexperienceInfos())){
            basicInfo.getMainexperienceInfos().forEach(e->{
                e.setPid(pid);
                mainexperienceInfoDao.insert(e);
            });
        }

        if(!StringUtils.isEmpty(basicInfo.getLanguageInfos())){
            basicInfo.getLanguageInfos().forEach(e->{
                e.setPid(pid);
                languageInfoDao.insert(e);
            });
        }
        if(!StringUtils.isEmpty(basicInfo.getInternationalInfos())){
            basicInfo.getInternationalInfos().forEach(e->{
                e.setPid(pid);
                internationalInfoDao.insert(e);
            });
        }
        if(!StringUtils.isEmpty(basicInfo.getEducationInfos())){
            basicInfo.getEducationInfos().forEach(e->{
                e.setPid(pid);
                educationInfoDao.insert(e);
            });
        }

        if(!StringUtils.isEmpty(basicInfo.getEducationInfos())){
            basicInfo.getTrainingtalentsInfos().forEach(e->{
                e.setPid(pid);
                trainingtalentsInfoDao.insert(e);
            });
        }

        if(!StringUtils.isEmpty(basicInfo.getAwardInfos())){
            basicInfo.getAwardInfos().forEach(e->{
                e.setPid(pid);
                awardInfoDao.insert(e);
            });
        }
        if(!StringUtils.isEmpty(basicInfo.getAssessmentInfos())){
            basicInfo.getAssessmentInfos().forEach(e->{
                e.setPid(pid);
                assessmentInfoDao.insert(e);
            });
        }
        return pid;
    }

    /**
     * 此处逻辑编写错误
     * 更新数据返回的pid
     * @param basicInfo 如题
     */
    public Integer update(HnBasicInfo basicInfo) {

        int pid = personnelFilesDao.updateByPrimaryKey(basicInfo);

        Integer integer = academicInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getAcademicInfos())){
            basicInfo.getAcademicInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                academicInfoDao.insert(e);
            });

        }
        Integer integer1 = worksandpapersInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getWorkexperienceInfos())){
            basicInfo.getWorksandpapersInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                worksandpapersInfoDao.insert(e);
            });
        }
        Integer integer2 = workexperienceInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getWorkexperienceInfos())){
            basicInfo.getWorkexperienceInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                workexperienceInfoDao.insert(e);
            });
        }

        Integer integer3 = traininglearningInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getTraininglearningInfos())){
            basicInfo.getTraininglearningInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                traininglearningInfoDao.insert(e);
            });
        }
        Integer integer4 = socialpostInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getSocialpostInfos())){
            basicInfo.getSocialpostInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                socialpostInfoDao.insert(e);
            });
        }

        Integer integer5 = maintechnologyInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getMaintechnologyInfos())){
            basicInfo.getMaintechnologyInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                maintechnologyInfoDao.insert(e);
            });
        }

        Integer integer6 = mainexperienceInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getMainexperienceInfos())){
            basicInfo.getMainexperienceInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                mainexperienceInfoDao.insert(e);
            });
        }


        Integer integer7 = languageInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getLanguageInfos())){
            basicInfo.getLanguageInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                languageInfoDao.insert(e);
            });
        }

        Integer integer8 = internationalInfoDao.delDataByPid(basicInfo.getId());

        if(!StringUtils.isEmpty(basicInfo.getInternationalInfos())){
            basicInfo.getInternationalInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                internationalInfoDao.insert(e);
            });
        }
        Integer integer9 = educationInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getEducationInfos())){
            basicInfo.getEducationInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                educationInfoDao.insert(e);
            });
        }

        Integer integer10 = trainingtalentsInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getEducationInfos())){
            basicInfo.getTrainingtalentsInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                trainingtalentsInfoDao.insert(e);
            });
        }


        Integer integer11 = awardInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getAwardInfos())){
            basicInfo.getAwardInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                awardInfoDao.insert(e);
            });
        }

        Integer integer12 = assessmentInfoDao.delDataByPid(basicInfo.getId());
        if(!StringUtils.isEmpty(basicInfo.getAssessmentInfos())){
            basicInfo.getAssessmentInfos().forEach(e->{
                e.setPid(basicInfo.getId());
                assessmentInfoDao.insert(e);
            });
        }

        return pid;

    }

    //离职
    public Integer updatestate(Integer id, Integer state) {
        return personnelFilesDao.updatestate(id,state);
    }

    public void setchildren(HnBasicInfo hnBasicInfo) {
        Integer pid = hnBasicInfo.getId();
        List<HnAcademicInfo> dataByPid = academicInfoDao.getDataByPid(pid);
        hnBasicInfo.setAcademicInfos(dataByPid);

        List<HnWorksandpapersInfo> dataByPid1 = worksandpapersInfoDao.getDataByPid(pid);
        hnBasicInfo.setWorksandpapersInfos(dataByPid1);

        List<HnWorkexperienceInfo> dataByPid2 = workexperienceInfoDao.getDataByPid(pid);
        hnBasicInfo.setWorkexperienceInfos(dataByPid2);

        List<HnTraininglearningInfo> dataByPid3 = traininglearningInfoDao.getDataByPid(pid);
        hnBasicInfo.setTraininglearningInfos(dataByPid3);

        List<HnSocialpostInfo> dataByPid4 = socialpostInfoDao.getDataByPid(pid);
        hnBasicInfo.setSocialpostInfos(dataByPid4);

        List<HnMaintechnologyInfo> dataByPid5 = maintechnologyInfoDao.getDataByPid(pid);
        hnBasicInfo.setMaintechnologyInfos(dataByPid5);

        List<HnMainexperienceInfo> dataByPid6 = mainexperienceInfoDao.getDataByPid(pid);
        hnBasicInfo.setMainexperienceInfos(dataByPid6);

        List<HnLanguageInfo> dataByPid7 = languageInfoDao.getDataByPid(pid);
        hnBasicInfo.setLanguageInfos(dataByPid7);

        List<HnInternationalInfo> dataByPid8 = internationalInfoDao.getDataByPid(pid);
        hnBasicInfo.setInternationalInfos(dataByPid8);

        List<HnEducationInfo> dataByPid9 = educationInfoDao.getDataByPid(pid);
        hnBasicInfo.setEducationInfos(dataByPid9);

        List<HnTrainingtalentsInfo> dataByPid10 = trainingtalentsInfoDao.getDataByPid(pid);
        hnBasicInfo.setTrainingtalentsInfos(dataByPid10);

        List<HnAwardInfo> dataByPid11 = awardInfoDao.getDataByPid(pid);
        hnBasicInfo.setAwardInfos(dataByPid11);

        List<HnAssessmentInfo> dataByPid12 = assessmentInfoDao.getDataByPid(pid);
        hnBasicInfo.setAssessmentInfos(dataByPid12);


    }



    public  List<HnBasicInfo> findbySql(String sql){
        return personnelFilesDao.findbySql(sql);
    }

    //离职
    public Integer delete(Integer id) {
        return personnelFilesDao.deleteById(id);
    }
}
