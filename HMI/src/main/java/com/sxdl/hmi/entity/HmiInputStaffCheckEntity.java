package com.sxdl.hmi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@ApiModel(value = "hmi_input_staff_rsk", description = "人员录入--审核结果表")
@Entity
@Data
@Table(name="hmi_input_staff_check")
public class HmiInputStaffCheckEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "固定急诊医师人数_审核结果")
    private Integer jzgdys;

    @ApiModelProperty(value = "固定急诊医师人数_人事科填报")
    private Integer jzgdys_rs;

    @ApiModelProperty(value = "固定急诊医师人数_医务科填报")
    private Integer jzgdys_yw;

    @ApiModelProperty(value = "固定急诊医师人数_急诊科填报")
    private Integer jzgdys_jz;

    @ApiModelProperty(value = "急诊在岗医师人数")
    private Integer jzzgys;

    @ApiModelProperty(value = "急诊在岗医师人数")
    private Integer jzzgys_rs;

    @ApiModelProperty(value = "急诊在岗医师人数")
    private Integer jzzgys_yw;

    @ApiModelProperty(value = "急诊在岗医师人数")
    private Integer jzzgys_jz;

    @ApiModelProperty(value = "急诊固定护士人数")
    private Integer jzgdhs;

    @ApiModelProperty(value = "急诊固定护士人数")
    private Integer jzgdhs_rs;

    @ApiModelProperty(value = "急诊固定护士人数")
    private Integer jzgdhs_hl;

    @ApiModelProperty(value = "急诊固定护士人数")
    private Integer jzgdhs_jz;

    @ApiModelProperty(value = "急诊在岗护士人数")
    private Integer jzzghs;

    @ApiModelProperty(value = "急诊在岗护士人数")
    private Integer jzzghs_rs;

    @ApiModelProperty(value = "急诊在岗护士人数")
    private Integer jzzghs_hl;

    @ApiModelProperty(value = "急诊在岗护士人数")
    private Integer jzzghs_jz;

    @ApiModelProperty(value = "重症ICU医生人数")
    private Integer icuys;

    @ApiModelProperty(value = "重症ICU医生人数")
    private Integer icuys_rs;

    @ApiModelProperty(value = "重症ICU医生人数")
    private Integer icuys_yw;

    @ApiModelProperty(value = "重症ICU医生人数")
    private Integer icuys_zz;

    @ApiModelProperty(value = "重症CCU医生人数")
    private Integer ccuys;

    @ApiModelProperty(value = "重症CCU医生人数")
    private Integer ccuys_rs;

    @ApiModelProperty(value = "重症CCU医生人数")
    private Integer ccuys_yw;

    @ApiModelProperty(value = "重症CCU医生人数")
    private Integer ccuys_zz;

    @ApiModelProperty(value = "重症RICU医生人数")
    private Integer ricuys;

    @ApiModelProperty(value = "重症RICU医生人数")
    private Integer ricuys_rs;

    @ApiModelProperty(value = "重症RICU医生人数")
    private Integer ricuys_yw;

    @ApiModelProperty(value = "重症RICU医生人数")
    private Integer ricuys_zz;

    @ApiModelProperty(value = "重症NICU医生人数")
    private Integer nicuys;

    @ApiModelProperty(value = "重症NICU医生人数")
    private Integer nicuys_rs;

    @ApiModelProperty(value = "重症NICU医生人数")
    private Integer nicuys_yw;

    @ApiModelProperty(value = "重症NICU医生人数")
    private Integer nicuys_zz;

    @ApiModelProperty(value = "重症ICU护士人数")
    private Integer icuhs;

    @ApiModelProperty(value = "重症ICU护士人数")
    private Integer icuhs_rs;

    @ApiModelProperty(value = "重症ICU护士人数")
    private Integer icuhs_hl;

    @ApiModelProperty(value = "重症ICU护士人数")
    private Integer icuhs_zz;

    @ApiModelProperty(value = "重症CCU护士人数")
    private Integer ccuhs;

    @ApiModelProperty(value = "重症CCU护士人数")
    private Integer ccuhs_rs;

    @ApiModelProperty(value = "重症CCU护士人数")
    private Integer ccuhs_hl;

    @ApiModelProperty(value = "重症CCU护士人数")
    private Integer ccuhs_zz;

    @ApiModelProperty(value = "重症RICU护士人数")
    private Integer ricuhs;

    @ApiModelProperty(value = "重症RICU护士人数")
    private Integer ricuhs_rs;

    @ApiModelProperty(value = "重症RICU护士人数")
    private Integer ricuhs_hl;

    @ApiModelProperty(value = "重症RICU护士人数")
    private Integer ricuhs_zz;

    @ApiModelProperty(value = "重症NICU护士人数")
    private Integer nicuhs;

    @ApiModelProperty(value = "重症NICU护士人数")
    private Integer nicuhs_rs;

    @ApiModelProperty(value = "重症NICU护士人数")
    private Integer nicuhs_hl;

    @ApiModelProperty(value = "重症NICU护士人数")
    private Integer nicuhs_zz;

    @ApiModelProperty(value = "麻醉医师人数")
    private Integer mzys;

    @ApiModelProperty(value = "麻醉医师人数")
    private Integer mzys_rs;

    @ApiModelProperty(value = "麻醉医师人数")
    private Integer mzys_yw;

    @ApiModelProperty(value = "麻醉医师人数")
    private Integer mzys_mz;

    @ApiModelProperty(value = "中医医师人数")
    private Integer zyys;

    @ApiModelProperty(value = "中医医师人数")
    private Integer zyys_rs;

    @ApiModelProperty(value = "中医医师人数")
    private Integer zyys_yw;

    @ApiModelProperty(value = "中医医师人数")
    private Integer zyys_zy;

    @ApiModelProperty(value = "中医护士人数")
    private Integer zyhs;

    @ApiModelProperty(value = "中医护士人数")
    private Integer zyhs_rs;

    @ApiModelProperty(value = "中医护士人数")
    private Integer zyhs_hl;

    @ApiModelProperty(value = "中医护士人数")
    private Integer zyhs_zy;

    @ApiModelProperty(value = "康复科医师人数")
    private Integer kfys;

    @ApiModelProperty(value = "康复科医师人数")
    private Integer kfys_rs;

    @ApiModelProperty(value = "康复科医师人数")
    private Integer kfys_yw;

    @ApiModelProperty(value = "康复科医师人数")
    private Integer kfys_kf;

    @ApiModelProperty(value = "康复科康复师人数")
    private Integer kfs;

    @ApiModelProperty(value = "康复科康复师人数")
    private Integer kfs_rs;

    @ApiModelProperty(value = "康复科康复师人数")
    private Integer kfs_yw;

    @ApiModelProperty(value = "康复科康复师人数")
    private Integer kfs_kf;

    @ApiModelProperty(value = "康复科护士人数")
    private Integer kfhs;

    @ApiModelProperty(value = "康复科护士人数")
    private Integer kfhs_rs;

    @ApiModelProperty(value = "康复科护士人数")
    private Integer kfhs_hl;

    @ApiModelProperty(value = "康复科护士人数")
    private Integer kfhs_kf;

    @ApiModelProperty(value = "感染科在岗医师人数")
    private Integer grzgys;

    @ApiModelProperty(value = "感染科在岗医师人数")
    private Integer grzgys_rs;

    @ApiModelProperty(value = "感染科在岗医师人数")
    private Integer grzgys_yw;

    @ApiModelProperty(value = "感染科在岗医师人数")
    private Integer grzgys_gr;

    @ApiModelProperty(value = "感染科固定医师人数")
    private Integer grgdys;

    @ApiModelProperty(value = "感染科固定医师人数")
    private Integer grgdys_rs;

    @ApiModelProperty(value = "感染科固定医师人数")
    private Integer grgdys_yw;

    @ApiModelProperty(value = "感染科固定医师人数")
    private Integer grgdys_gr;

    @ApiModelProperty(value = "感染科在岗护士人数")
    private Integer grzghs;

    @ApiModelProperty(value = "感染科在岗护士人数")
    private Integer grzghs_rs;

    @ApiModelProperty(value = "感染科在岗护士人数")
    private Integer grzghs_hl;

    @ApiModelProperty(value = "感染科在岗护士人数")
    private Integer grzghs_gr;

    @ApiModelProperty(value = "感染科固定护士人数")
    private Integer grgdhs;

    @ApiModelProperty(value = "感染科固定护士人数")
    private Integer grgdhs_rs;

    @ApiModelProperty(value = "感染科固定护士人数")
    private Integer grgdhs_hl;

    @ApiModelProperty(value = "感染科固定护士人数")
    private Integer grgdhs_gr;

    @ApiModelProperty(value = "状态：1未审/2已审")
    private Integer status;

    @ApiModelProperty(value = "录入日期")
    private Date checkdate;

    @ApiModelProperty(value = "录入人员工号")
    private String checkuser;

    @ApiModelProperty(value = "录入人员名称")
    private String checkusername;





}
