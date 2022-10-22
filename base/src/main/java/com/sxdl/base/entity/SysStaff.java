package com.sxdl.base.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

//医院医护人员信息
@Entity
@Data
@Table(name = "sys_staff")
public class SysStaff implements Serializable {
    private static final long serialVersionUID = 1L;
    //拼音码
    String pym;
    //医师执业证书编码
    String yszyzsbm;
    //医保医师代码
    String ybysdm;
    @Id
    private Integer id;
    //名称
    private String name;
    //代码
    private String code;
    //职称
    private String title;
    //职位
    private String position;
    //院区id
    private Integer yq_id;
    //院区名称
    private String yq_name;
    //科室id
    private Integer ks_id;
    //科室名称
    private String ks_name;
    //人员类型，1医生，2护士，3行政人员
    private Integer staff_type;
    //更新时间
    private String update_time;


}
