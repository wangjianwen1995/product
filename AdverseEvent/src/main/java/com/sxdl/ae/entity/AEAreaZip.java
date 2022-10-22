package com.sxdl.ae.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@ApiModel(value = "ae_areazip", description = "地址与邮编")
@Entity
@Data
@Table(name="ae_areazip")
public class AEAreaZip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String name;

    private Integer grade;
    private String code;
    private String parent_code;
    private String fullname;
    private String sheng;
    private String shi;
    private String xian;
    private String sheng_code;
    private String shi_code;
    private String xian_code;
    private String zip;
    private String tel;
    private Integer isoff;


}
