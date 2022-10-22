package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "单病种病人信息")
@Entity
@Data
@Table(name = "sd_patient_info")
public class SdPatientInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String name;//病人姓名
    @Column(name="patient_code")
    private String patient_code;//病人代码
    @Column(name="dr_code")
    private String dr_code;//主治医师代码
    @Column(name="director_code")
    private String director_code;//审核主任代码
    @Column(name="medical_code")
    private String medical_code;//医务科人员代码
    @Column(name="sd_info_id")
    private Integer sd_info_id;//单病种id
    @Column(name="sd_group_id")
    private Integer sd_group_id;//单病种分组id
    @Column(name="ks_code")
    private String ks_code;//出院科室代码
    @Column(name="cy_time")
    private String cy_time;//出院时间
    @Column(name="create_time")
    private String create_time;//创建时间
    @Column(name="submit_time")
    private String submit_time;//提交时间
    @Column(name="reject_time")
    private String reject_time;//审核驳回时间
    @Column(name="check_time")
    private String check_time;//审核通过时间
    @Column(name="check_ztime")
    private String check_ztime;//终审核通过时间
    @Column(name="reject_reason")
    private String reject_reason;//审核驳回意见
    @Column(name="status")
    private Integer status;//状态，1未提交未审核；2已提交未审核；3已提交已驳回；4已提交已通过；5已提交终驳回；6已提交终通过

    @Column(name="source")
    private String source;//来源：主要适用于补录
    @Column(name="upload_time")
    private String upload_time;//上传时间
    @Transient
    private  String ks_name;

    @Transient
    private  String zr_name;
}
