package com.sxdl.hpqc.dbo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class HpQmRuleData {



    private String  ID;
    private String  fields;
    private String  sqls;
    private String  message;
    private Integer can_forced;
    private String  classify;
    private Integer classify_id;
    private Integer ordernum;
    private Integer is_west;              //是否中西医 1：中医 2：西医
    private String  fields_anchor;
    private Double  kfz;
    private String  packages;
    private Double  packages_score;


}
