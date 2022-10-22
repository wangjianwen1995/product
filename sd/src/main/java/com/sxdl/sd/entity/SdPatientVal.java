package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "单病种病人的值信息")
@Entity
@Data
@Table(name = "sd_patient_val")
public class SdPatientVal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    @Column(name = "sd_patient_id")
    private Integer sd_patient_id;//单病种病人id

    @Column(name = "sd_info_id")
    private Integer sd_info_id;//单病种信息id

    @Column(name = "sd_info_column_id")
    private Integer sd_info_column_id;//单病种字段id

    @Column(name = "val")
    private String val;//单病种字段值

    @Column(name = "sd_info_column_name")
    private String sd_info_column_name;//单病种字段名称

}
