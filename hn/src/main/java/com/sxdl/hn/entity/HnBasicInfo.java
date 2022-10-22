package com.sxdl.hn.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@ApiModel(value = "basic_info", description = "基本信息")
@Entity
@Data
@Table(name="basic_info")
public class HnBasicInfo {
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "登录工号")
    private String logincode;

    @ApiModelProperty(value = "现职称")
    private String nowtitle;


    @ApiModelProperty(value = "最高学历")
    private String maxeducation;

    @ApiModelProperty(value = "科室代码")
    private String ks_code;

    @ApiModelProperty(value = "身份证号")
    private String idcard;

    @ApiModelProperty(value = "执业证号")
    private String license;

    @ApiModelProperty(value = "执业证url")
    private String license_path;

    @ApiModelProperty(value = "执业证文件名称")
    private String license_name;

    @ApiModelProperty(value = "职业证号生效起始时间")
    private String license_enable_time;

    @ApiModelProperty(value = "职业证号过期时间")
    private String license_disenable_time;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "照片")
    private String photo;

    @ApiModelProperty(value = "曾用名")
    private String old_name;

    @ApiModelProperty(value = "籍贯")
    private String native_place;

    @ApiModelProperty(value = "任职时间")
    private String inauguration_time;

    @ApiModelProperty(value = "生日")
    private String birthday;

    @ApiModelProperty(value = "职务")
    private String post;

    @ApiModelProperty(value = "参加工作时间")
    private String work_time;

    @ApiModelProperty(value = "从事专业")
    private String professional;

    @ApiModelProperty(value = "健康状况")
    private String healthy;

    @ApiModelProperty(value = "家庭地址")
    private String home_address;

    @ApiModelProperty(value = "何时加入共产党何职位")
    private String communist;

    @ApiModelProperty(value = "何时加入民主党何职位")
    private String democratic;

    @ApiModelProperty(value = "社会兼职")
    private String social_appointments;

    @ApiModelProperty(value = "社会兼职url")
    private String social_appointments_path;

    @ApiModelProperty(value = "社会兼职 文件名称")
    private String social_appointments_name;
    @ApiModelProperty(value = "是否离职")
    private Integer leave_whether;

    @ApiModelProperty(value = "审核状态")
    private String examine_type;

    @ApiModelProperty(value = "业务自传")
    private String autobiography;

    @ApiModelProperty(value = "爱人名字")
    private String wife_name;

    @ApiModelProperty(value = "爱人年龄")
    private Integer wife_age;

    @ApiModelProperty(value = "爱人民族")
    private String wife_nation;

    @ApiModelProperty(value = "爱人文化程度")
    private String wife_culture;

    @ApiModelProperty(value = "爱人政治面貌")
    private String wife_politics;

    @ApiModelProperty(value = "爱人专长")
    private String wife_expertise;

    @ApiModelProperty(value = "爱人担任职务")
    private String wife_post;


    @Transient
    @ApiModelProperty(value = " 学术团体")
    private List<HnAcademicInfo> academicInfos;

    @Transient
    @ApiModelProperty(value = "著作与论文登记 ")
    private List<HnWorksandpapersInfo> worksandpapersInfos;


    @Transient
    @ApiModelProperty(value = " 工作经历")
    private List<HnWorkexperienceInfo> workexperienceInfos;

    @Transient
    @ApiModelProperty(value = " 培养人才情况登记")
    private List<HnTrainingtalentsInfo> trainingtalentsInfos;

    @Transient
    @ApiModelProperty(value = "培训学习记录 ")
    private List<HnTraininglearningInfo> traininglearningInfos;

    @Transient
    @ApiModelProperty(value = " 社会兼职")
    private List<HnSocialpostInfo> socialpostInfos;


    @Transient
    @ApiModelProperty(value = " 担任过得主要技术工作")
    private List<HnMaintechnologyInfo> maintechnologyInfos;


    @Transient
    @ApiModelProperty(value = "主要经历 ")
    private List<HnMainexperienceInfo> mainexperienceInfos;


    @Transient
    @ApiModelProperty(value = "外语能力 ")
    private List<HnLanguageInfo> languageInfos;


    @Transient
    @ApiModelProperty(value = "出国短期学习、考察及参加国际学术活动等情况 ")
    private List<HnInternationalInfo> internationalInfos;

    @Transient
    @ApiModelProperty(value = " 学历信息")
    private List<HnEducationInfo> educationInfos;

    @Transient
    @ApiModelProperty(value = "创造发明、科研成果和技术业务工作授奖登记 ")
    private List<HnAwardInfo> awardInfos;

    @Transient
    @ApiModelProperty(value = " 考核登记")
    private List<HnAssessmentInfo> assessmentInfos;




}
