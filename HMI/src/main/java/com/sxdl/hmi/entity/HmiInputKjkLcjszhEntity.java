package com.sxdl.hmi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@ApiModel(value = "hmi_input_kjk_lcjszh", description = "科教科信息录入--临床技术转化")
@Entity
@Data
@Table(name="hmi_input_kjk_lcjszh")
public class HmiInputKjkLcjszhEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "科室code")
    private String kscode;

    @ApiModelProperty(value = "科室名称")
    private String ksname;

    @ApiModelProperty(value = "名称(研究者)")
    private String name;

    @ApiModelProperty(value = "职称代码")
    private String zc;

    @ApiModelProperty(value = "职称名称")
    private String zcmc;

    @ApiModelProperty(value = "项目名称")
    private String projectname;

    @ApiModelProperty(value = "署名(项目研究中的排名)")
    private Integer signature;

    @ApiModelProperty(value = "转化时间")
    private String convertime;

    @ApiModelProperty(value = "转化类型")
    private String convertype;

    @ApiModelProperty(value = "合作单位")
    private String hzdw;

    @ApiModelProperty(value = "备注")
    private String remark;


    @ApiModelProperty(value = "录入日期")
    private Date inputdate;

    @ApiModelProperty(value = "录入人员工号")
    private String inputuser;

    @ApiModelProperty(value = "录入人员名称")
    private String inputusername;



}
