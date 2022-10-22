package com.sxdl.sd.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@ApiModel(value = "源表信息")
@Entity
@Data
@Table(name = "sd_source")
public class SdInfoSource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "caseId")
    @JsonProperty("caseId")
    private String caseId;
    @Column(name = "age")
    @JsonProperty("age")
    private String age;
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard;
    @Column(name="director_code")
    @JsonProperty("director_code")
    private String director_code;//审核主任代码
    @Column(name = "CM_0_1_1_1")
    @JsonProperty("CM_0_1_1_1")
    private String CM_0_1_1_1;
    @Column(name = "CM_0_1_1_2")
    @JsonProperty("CM_0_1_1_2")
    private String CM_0_1_1_2;
    @Column(name = "CM_0_1_1_3")
    @JsonProperty("CM_0_1_1_3")
    private String CM_0_1_1_3;
    @Column(name = "CM_0_1_1_4")
    @JsonProperty("CM_0_1_1_4")
    private String CM_0_1_1_4;
    @Column(name = "CM_0_1_1_5")
    @JsonProperty("CM_0_1_1_5")
    private String CM_0_1_1_5;
    @Column(name = "CM_0_1_3_1")
    @JsonProperty("CM_0_1_3_1")
    private String CM_0_1_3_1;
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM_0_1_3_2")
    private String CM_0_1_3_2;
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM_0_1_4_1")
    private String CM_0_1_4_1;
    @Column(name = "CM_0_1_4_1_1")
    @JsonProperty("CM_0_1_4_1_1")
    private String CM_0_1_4_1_1;
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM_0_1_4_2")
    private String CM_0_1_4_2;
    @Column(name = "CM_0_1_4_2_1")
    @JsonProperty("CM_0_1_4_2_1")
    private String CM_0_1_4_2_1;
    @Column(name = "CM_0_1_4_3")
    @JsonProperty("CM_0_1_4_3")
    private String CM_0_1_4_3;
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM_0_1_5")
    private String CM_0_1_5;
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM_0_2_1_1")
    private String CM_0_2_1_1;
    @Column(name = "CM_0_2_1_2")
    @JsonProperty("CM_0_2_1_2")
    private String CM_0_2_1_2;
    @Column(name = "CM_0_2_1_3")
    @JsonProperty("CM_0_2_1_3")
    private String CM_0_2_1_3;

    @Column(name = "CM_0_2_1_3_1")
    @JsonProperty("CM_0_2_1_3_1")
    private String CM_0_2_1_3_1;
    @Column(name = "CM_0_2_1_4")
    @JsonProperty("CM_0_2_1_4")
    private String CM_0_2_1_4;
    @Column(name = "CM_0_2_1_5")
    @JsonProperty("CM_0_2_1_5")
    private String CM_0_2_1_5;
    @Column(name = "CM_0_2_1_6")
    @JsonProperty("CM_0_2_1_6")
    private String CM_0_2_1_6;
    @Column(name = "CM_0_2_2_1")
    @JsonProperty("CM_0_2_2_1")
    private String CM_0_2_2_1;
    @Column(name = "CM_0_2_2_2")
    @JsonProperty("CM_0_2_2_2")
    private String CM_0_2_2_2;
    @Column(name = "CM_0_2_3_1")
    @JsonProperty("CM_0_2_3_1")
    private String CM_0_2_3_1;
    @Column(name = "CM_0_2_3_2")
    @JsonProperty("CM_0_2_3_2")
    private String CM_0_2_3_2;
    @Column(name = "CM_0_2_4_1")
    @JsonProperty("CM_0_2_4_1")
    private String CM_0_2_4_1;
    @Column(name = "CM_0_2_4_2")
    @JsonProperty("CM_0_2_4_2")
    private String CM_0_2_4_2;
    @Column(name = "CM_0_2_5_1")
    @JsonProperty("CM_0_2_5_1")
    private String CM_0_2_5_1;
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM_0_2_5_2")

    private String CM_0_2_5_2;
    @Column(name = "CM_0_2_6_1")
    @JsonProperty("CM_0_2_6_1")
    private String CM_0_2_6_1;

    @Column(name = "CM_0_2_6_2")
    @JsonProperty("CM_0_2_6_2")
    private String CM_0_2_6_2;
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM_0_3_1")
    private String CM_0_3_1;
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM_0_3_2")
    private String CM_0_3_2;
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM_0_3_3")
    private String CM_0_3_3;
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM_1_1_1")
    private String CM_1_1_1;
    @Column(name = "CM_1_2_1")
    @JsonProperty("CM_1_2_1")
    private String CM_1_2_1;
    @Column(name = "CM_1_2_2")
    @JsonProperty("CM_1_2_2")
    private String CM_1_2_2;
    @Column(name = "CM_1_2_2_1")
    @JsonProperty("CM_1_2_2_1")
    private String CM_1_2_2_1;
    @Column(name = "CM_1_3_1")
    @JsonProperty("CM_1_3_1")
    private String CM_1_3_1;
    @Column(name = "CM_1_3_1_1")
    @JsonProperty("CM_1_3_1_1")
    private String CM_1_3_1_1;
    @Column(name = "CM_1_4_1")
    @JsonProperty("CM_1_4_1")
    private String CM_1_4_1;
    @Column(name = "CM_1_4_1_1")
    @JsonProperty("CM_1_4_1_1")
    private String CM_1_4_1_1;
    @Column(name = "CM_1_5_1")
    @JsonProperty("CM_1_5_1")
    private String CM_1_5_1;
    @Column(name = "CM_1_5_3")
    @JsonProperty("CM_1_5_3")
    private String CM_1_5_3;
    @Column(name = "CM_1_5_4")
    @JsonProperty("CM_1_5_4")
    private String CM_1_5_4;
    @Column(name = "CM_1_6_1")
    @JsonProperty("CM_1_6_1")
    private String CM_1_6_1;
    @Column(name = "CM_1_6_1_2")
    @JsonProperty("CM_1_6_1_2")

    private String CM_1_6_1_2;
    @Column(name = "CM_1_6_1_dump")
    @JsonProperty("CM_1_6_1_dump")
    private String CM_1_6_1_dump;
    @Column(name = "CM_1_6_2")
    @JsonProperty("CM_1_6_2")
    private String CM_1_6_2;
    @Column(name = "CM_1_6_3")
    @JsonProperty("CM_1_6_3")
    private String CM_1_6_3;
    @Column(name = "CM_2_1")
    @JsonProperty("CM_2_1")
    private String CM_2_1;
    @Column(name = "CM_2_2")
    @JsonProperty("CM_2_2")
    private String CM_2_2;
    @Column(name = "CM_2_2_1")
    @JsonProperty("CM_2_2_1")
    private String CM_2_2_1;
    @Column(name = "CM_2_3")
    @JsonProperty("CM_2_3")
    private String CM_2_3;
    @Column(name = "CM_2_3_1")
    @JsonProperty("CM_2_3_1")
    private String CM_2_3_1;
    @Column(name = "CM_2_3_10")
    @JsonProperty("CM_2_3_10")
    private String CM_2_3_10;
    @Column(name = "CM_2_3_11")
    @JsonProperty("CM_2_3_11")
    private String CM_2_3_11;
    @Column(name = "CM_2_3_12")
    @JsonProperty("CM_2_3_12")
    private String CM_2_3_12;
    @Column(name = "CM_2_3_13")
    @JsonProperty("CM_2_3_13")
    private String CM_2_3_13;
    @Column(name = "CM_2_3_14")
    @JsonProperty("CM_2_3_14")
    private String CM_2_3_14;
    @Column(name = "CM_2_3_15")
    @JsonProperty("CM_2_3_15")
    private String CM_2_3_15;
    @Column(name = "CM_2_3_16")
    @JsonProperty("CM_2_3_16")
    private String CM_2_3_16;
    @Column(name = "CM_2_3_16_1")
    @JsonProperty("CM_2_3_16_1")
    private String CM_2_3_16_1;
    @Column(name = "CM_2_3_17")
    @JsonProperty("CM_2_3_17")
    private String CM_2_3_17;
    @Column(name = "CM_2_3_18")
    @JsonProperty("CM_2_3_18")
    private String CM_2_3_18;
    @Column(name = "CM_2_3_19")
    @JsonProperty("CM_2_3_19")
    private String CM_2_3_19;
    @Column(name = "CM_2_3_1_1")
    @JsonProperty("CM_2_3_1_1")
    private String CM_2_3_1_1;
    @Column(name = "CM_2_3_2")
    @JsonProperty("CM_2_3_2")
    private String CM_2_3_2;
    @Column(name = "CM_2_3_20")
    @JsonProperty("CM_2_3_20")
    private String CM_2_3_20;
    @Column(name = "CM_2_3_21")
    @JsonProperty("CM_2_3_21")
    private String CM_2_3_21;
    @Column(name = "CM_2_3_21_1")
    @JsonProperty("CM_2_3_21_1")
    private String CM_2_3_21_1;
    @Column(name = "CM_2_3_3")
    @JsonProperty("CM_2_3_3")
    private String CM_2_3_3;
    @Column(name = "CM_2_3_4")
    @JsonProperty("CM_2_3_4")
    private String CM_2_3_4;
    @Column(name = "CM_2_3_5")
    @JsonProperty("CM_2_3_5")
    private String CM_2_3_5;
    @Column(name = "CM_2_3_6")
    @JsonProperty("CM_2_3_6")
    private String CM_2_3_6;
    @Column(name = "CM_2_3_7")
    @JsonProperty("CM_2_3_7")
    private String CM_2_3_7;
    @Column(name = "CM_2_3_8")
    @JsonProperty("CM_2_3_8")
    private String CM_2_3_8;
    @Column(name = "CM_2_3_9")
    @JsonProperty("CM_2_3_9")
    private String CM_2_3_9;
    @Column(name = "CM_2_4")
    @JsonProperty("CM_2_4")
    private String CM_2_4;
    @Column(name = "CM_2_5")
    @JsonProperty("CM_2_5")
    private String CM_2_5;
    @Column(name = "CM_2_5_1")
    @JsonProperty("CM_2_5_1")
    private String CM_2_5_1;
    @Column(name = "CM_2_5_2")
    @JsonProperty("CM_2_5_2")
    private String CM_2_5_2;
    @Column(name = "CM_2_5_3")
    @JsonProperty("CM_2_5_3")
    private String CM_2_5_3;
    @Column(name = "CM_2_6")
    @JsonProperty("CM_2_6")
    private String CM_2_6;
    @Column(name = "CM_2_70")
    @JsonProperty("CM_2_70")
    private String CM_2_70;
    @Column(name = "CM_2_71")
    @JsonProperty("CM_2_71")
    private String CM_2_71;
    @Column(name = "CM_2_72")
    @JsonProperty("CM_2_72")
    private String CM_2_72;
    @Column(name = "CM_2_73")
    @JsonProperty("CM_2_73")
    private String CM_2_73;
    @Column(name = "CM_3_1")
    @JsonProperty("CM_3_1")
    private String CM_3_1;
    @Column(name = "CM_3_2")
    @JsonProperty("CM_3_2")
    private String CM_3_2;
    @Column(name = "CM_3_2_1")
    @JsonProperty("CM_3_2_1")
    private String CM_3_2_1;
    @Column(name = "CM_3_3")
    @JsonProperty("CM_3_3")
    private String CM_3_3;
    @Column(name = "CM_3_4")
    @JsonProperty("CM_3_4")
    private String CM_3_4;
    @Column(name = "CM_4_1")
    @JsonProperty("CM_4_1")
    private String CM_4_1;
    @Column(name = "CM_4_2")
    @JsonProperty("CM_4_2")
    private String CM_4_2;
    @Column(name = "CM_4_3")
    @JsonProperty("CM_4_3")
    private String CM_4_3;
    @Column(name = "CM_4_4_1")
    @JsonProperty("CM_4_4_1")
    private String CM_4_4_1;
    @Column(name = "CM_4_5")
    @JsonProperty("CM_4_5")
    private String CM_4_5;
    @Column(name = "CM_4_6")
    @JsonProperty("CM_4_6")
    private String CM_4_6;
    @Column(name = "CM_5_1")
    @JsonProperty("CM_5_1")
    private String CM_5_1;
    @Column(name = "CM_5_2_1")
    @JsonProperty("CM_5_2_1")
    private String CM_5_2_1;
    @Column(name = "CM_5_2_10")
    @JsonProperty("CM_5_2_10")
    private String CM_5_2_10;
    @Column(name = "CM_5_2_11")
    @JsonProperty("CM_5_2_11")
    private String CM_5_2_11;
    @Column(name = "CM_5_2_2")
    @JsonProperty("CM_5_2_2")
    private String CM_5_2_2;
    @Column(name = "CM_5_2_3")
    @JsonProperty("CM_5_2_3")
    private String CM_5_2_3;
    @Column(name = "CM_5_2_5")
    @JsonProperty("CM_5_2_5")
    private String CM_5_2_5;
    @Column(name = "CM_5_2_6")
    @JsonProperty("CM_5_2_6")
    private String CM_5_2_6;
    @Column(name = "CM_5_2_7")
    @JsonProperty("CM_5_2_7")
    private String CM_5_2_7;
    @Column(name = "CM_5_2_8")
    @JsonProperty("CM_5_2_8")
    private String CM_5_2_8;
    @Column(name = "CM_5_2_9")
    @JsonProperty("CM_5_2_9")
    private String CM_5_2_9;
    @Column(name = "CM_6_1")
    @JsonProperty("CM_6_1")
    private String CM_6_1;
    @Column(name = "CM_6_10")
    @JsonProperty("CM_6_10")
    private String CM_6_10;
    @Column(name = "CM_6_11")
    @JsonProperty("CM_6_11")
    private String CM_6_11;
    @Column(name = "CM_6_12")
    @JsonProperty("CM_6_12")
    private String CM_6_12;
    @Column(name = "CM_6_13")
    @JsonProperty("CM_6_13")
    private String CM_6_13;
    @Column(name = "CM_6_14")
    @JsonProperty("CM_6_14")
    private String CM_6_14;
    @Column(name = "CM_6_15")
    @JsonProperty("CM_6_15")
    private String CM_6_15;
    @Column(name = "CM_6_16")
    @JsonProperty("CM_6_16")
    private String CM_6_16;
    @Column(name = "CM_6_17")
    @JsonProperty("CM_6_17")
    private String CM_6_17;
    @Column(name = "CM_6_18")
    @JsonProperty("CM_6_18")
    private String CM_6_18;
    @Column(name = "CM_6_19")
    @JsonProperty("CM_6_19")
    private String CM_6_19;
    @Column(name = "CM_6_1_3")
    @JsonProperty("CM_6_1_3")
    private String CM_6_1_3;
    @Column(name = "CM_6_2")
    @JsonProperty("CM_6_2")
    private String CM_6_2;
    @Column(name = "CM_6_20")
    @JsonProperty("CM_6_20")
    private String CM_6_20;
    @Column(name = "CM_6_21")
    @JsonProperty("CM_6_21")

    private String CM_6_21;
    @Column(name = "CM_6_22")
    @JsonProperty("CM_6_22")
    private String CM_6_22;
    @Column(name = "CM_6_23")
    @JsonProperty("CM_6_23")
    private String CM_6_23;
    @Column(name = "CM_6_24")
    @JsonProperty("CM_6_24")
    private String CM_6_24;
    @Column(name = "CM_6_25")
    @JsonProperty("CM_6_25")
    private String CM_6_25;
    @Column(name = "CM_6_26")
    @JsonProperty("CM_6_26")
    private String CM_6_26;
    @Column(name = "CM_6_27")
    @JsonProperty("CM_6_27")
    private String CM_6_27;
    @Column(name = "CM_6_28")
    @JsonProperty("CM_6_28")
    private String CM_6_28;
    @Column(name = "CM_6_29")
    @JsonProperty("CM_6_29")
    private String CM_6_29;
    @Column(name = "CM_6_3")
    @JsonProperty("CM_6_3")
    private String CM_6_3;
    @Column(name = "CM_6_30")
    @JsonProperty("CM_6_30")
    private String CM_6_30;
    @Column(name = "CM_6_4")
    @JsonProperty("CM_6_4")
    private String CM_6_4;
    @Column(name = "CM_6_5")
    @JsonProperty("CM_6_5")
    private String CM_6_5;
    @Column(name = "CM_6_6")
    @JsonProperty("CM_6_6")
    private String CM_6_6;
    @Column(name = "CM_6_7")
    @JsonProperty("CM_6_7")
    private String CM_6_7;
    @Column(name = "CM_6_8")
    @JsonProperty("CM_6_8")
    private String CM_6_8;
    @Column(name = "CM_6_9")
    @JsonProperty("CM_6_9")
    private String CM_6_9;
    @Column(name = "CM_7_1_1")
    @JsonProperty("CM_7_1_1")
    private String CM_7_1_1;
    @Column(name = "CM_7_1_2")
    @JsonProperty("CM_7_1_2")
    private String CM_7_1_2;
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM_7_2_1")
    private String CM_7_2_1;
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM_7_2_2")
    private String CM_7_2_2;
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM_7_2_3")
    private String CM_7_2_3;
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM_7_2_4")
    private String CM_7_2_4;
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM_7_2_5")
    private String CM_7_2_5;
    @Column(name = "C06x01C")
    @JsonProperty("C06x01C")
    private String C06x01C;
    @Column(name = "C35x01C")
    @JsonProperty("C35x01C")
    private String C35x01C;
    @Column(name = "C06x02C")
    @JsonProperty("C06x02C")
    private String C06x02C;
    @Column(name = "C35x02C")
    @JsonProperty("C35x02C")
    private String C35x02C;
    @Column(name = "C06x03C")
    @JsonProperty("C06x03C")
    private String C06x03C;
    @Column(name = "C35x03C")
    @JsonProperty("C35x03C")
    private String C35x03C;
    @Column(name = "C06x04C")
    @JsonProperty("C06x04C")
    private String C06x04C;
    @Column(name = "C35x04C")
    @JsonProperty("C35x04C")
    private String C35x04C;
    @Column(name = "C06x05C")
    @JsonProperty("C06x05C")
    private String C06x05C;
    @Column(name = "C35x05C")
    @JsonProperty("C35x05C")
    private String C35x05C;
    @Column(name = "C06x06C")
    @JsonProperty("C06x06C")
    private String C06x06C;
    @Column(name = "C35x06C")
    @JsonProperty("C35x06C")
    private String C35x06C;
    @Column(name = "C06x07C")
    @JsonProperty("C06x07C")
    private String C06x07C;
    @Column(name = "C35x07C")
    @JsonProperty("C35x07C")
    private String C35x07C;
    @Column(name = "C06x08C")
    @JsonProperty("C06x08C")
    private String C06x08C;
    @Column(name = "C35x08C")
    @JsonProperty("C35x08C")
    private String C35x08C;
    @Column(name = "C06x09C")
    @JsonProperty("C06x09C")
    private String C06x09C;
    @Column(name = "C35x09C")
    @JsonProperty("C35x09C")
    private String C35x09C;
    @Column(name = "C06x010C")
    @JsonProperty("C06x010C")
    private String C06x010C;
    @Column(name = "C35x010C")
    @JsonProperty("C35x010C")
    private String C35x010C;
    @Column(name = "C06x11C")
    @JsonProperty("C06x11C")
    private String C06x11C;
    @Column(name = "C35x11C")
    @JsonProperty("C35x11C")
    private String C35x11C;
    @Column(name = "C06x12C")
    @JsonProperty("C06x12C")
    private String C06x12C;
    @Column(name = "C35x12C")
    @JsonProperty("C35x12C")
    private String C35x12C;
    @Column(name = "C06x13C")
    @JsonProperty("C06x13C")
    private String C06x13C;
    @Column(name = "C35x13C")
    @JsonProperty("C35x13C")
    private String C35x13C;
    @Column(name = "C06x14C")
    @JsonProperty("C06x14C")
    private String C06x14C;
    @Column(name = "C35x14C")
    @JsonProperty("C35x14C")
    private String C35x14C;
    @Column(name = "C06x15C")
    @JsonProperty("C06x15C")
    private String C06x15C;
    @Column(name = "C35x15C")
    @JsonProperty("C35x15C")
    private String C35x15C;
    @Column(name = "C06x16C")
    @JsonProperty("C06x16C")
    private String C06x16C;
    @Column(name = "C35x16C")
    @JsonProperty("C35x16C")
    private String C35x16C;
    @Column(name = "C06x17C")
    @JsonProperty("C06x17C")
    private String C06x17C;
    @Column(name = "C35x17C")
    @JsonProperty("C35x17C")
    private String C35x17C;
    @Column(name = "C06x18C")
    @JsonProperty("C06x18C")
    private String C06x18C;
    @Column(name = "C35x18C")
    @JsonProperty("C35x18C")
    private String C35x18C;
    @Column(name = "C06x19C")
    @JsonProperty("C06x19C")
    private String C06x19C;
    @Column(name = "C35x19C")
    @JsonProperty("C35x19C")
    private String C35x19C;
    @Column(name = "C06x20C")
    @JsonProperty("C06x20C")
    private String C06x20C;
    @Column(name = "C35x20C")
    @JsonProperty("C35x20C")
    private String C35x20C;
    @Column(name = "C06x21C")
    @JsonProperty("C06x21C")
    private String C06x21C;
    @Column(name = "C35x21C")
    @JsonProperty("C35x21C")
    private String C35x21C;
    @Column(name = "C06x22C")
    @JsonProperty("C06x22C")
    private String C06x22C;
    @Column(name = "C35x22C")
    @JsonProperty("C35x22C")
    private String C35x22C;
    @Column(name = "C06x23C")
    @JsonProperty("C06x23C")
    private String C06x23C;
    @Column(name = "C35x23C")
    @JsonProperty("C35x23C")
    private String C35x23C;
    @Column(name = "C06x24C")
    @JsonProperty("C06x24C")
    private String C06x24C;
    @Column(name = "C35x24C")
    @JsonProperty("C35x24C")
    private String C35x24C;
    @Column(name = "C06x25C")
    @JsonProperty("C06x25C")
    private String C06x25C;
    @Column(name = "C35x25C")
    @JsonProperty("C35x25C")
    private String C35x25C;
    @Column(name = "C06x26C")
    @JsonProperty("C06x26C")
    private String C06x26C;
    @Column(name = "C35x26C")
    @JsonProperty("C35x26C")
    private String C35x26C;
    @Column(name = "C06x27C")
    @JsonProperty("C06x27C")
    private String C06x27C;
    @Column(name = "C35x27C")
    @JsonProperty("C35x27C")
    private String C35x27C;
    @Column(name = "C06x28C")
    @JsonProperty("C06x28C")
    private String C06x28C;
    @Column(name = "C35x28C")
    @JsonProperty("C35x28C")
    private String C35x28C;
    @Column(name = "C06x29C")
    @JsonProperty("C06x29C")
    private String C06x29C;
    @Column(name = "C35x29C")
    @JsonProperty("C35x29C")
    private String C35x29C;
    @Column(name = "C06x30C")
    @JsonProperty("C06x30C")
    private String C06x30C;
    @Column(name = "C35x30C")
    @JsonProperty("C35x30C")
    private String C35x30C;
    @Column(name = "C06x31C")
    @JsonProperty("C06x31C")
    private String C06x31C;
    @Column(name = "C35x31C")
    @JsonProperty("C35x31C")
    private String C35x31C;
    @Column(name = "C06x32C")
    @JsonProperty("C06x32C")
    private String C06x32C;
    @Column(name = "C35x32C")
    @JsonProperty("C35x32C")
    private String C35x32C;
    @Column(name = "C06x33C")
    @JsonProperty("C06x33C")
    private String C06x33C;
    @Column(name = "C35x33C")
    @JsonProperty("C35x33C")
    private String C35x33C;
    @Column(name = "C06x34C")
    @JsonProperty("C06x34C")
    private String C06x34C;
    @Column(name = "C35x34C")
    @JsonProperty("C35x34C")
    private String C35x34C;
    @Column(name = "C06x35C")
    @JsonProperty("C06x35C")
    private String C06x35C;
    @Column(name = "C35x35C")
    @JsonProperty("C35x35C")
    private String C35x35C;
    @Column(name = "C06x36C")
    @JsonProperty("C06x36C")
    private String C06x36C;
    @Column(name = "C35x36C")
    @JsonProperty("C35x36C")
    private String C35x36C;
    @Column(name = "C06x37C")
    @JsonProperty("C06x37C")
    private String C06x37C;
    @Column(name = "C35x37C")
    @JsonProperty("C35x37C")
    private String C35x37C;
    @Column(name = "C06x38C")
    @JsonProperty("C06x38C")
    private String C06x38C;
    @Column(name = "C35x38C")
    @JsonProperty("C35x38C")
    private String C35x38C;
    @Column(name = "C06x39C")
    @JsonProperty("C06x39C")
    private String C06x39C;
    @Column(name = "C35x39C")
    @JsonProperty("C35x39C")
    private String C35x39C;
    @Column(name = "C06x40C")
    @JsonProperty("C06x40C")
    private String C06x40C;
    @Column(name = "C35x40C")
    @JsonProperty("C35x40C")
    private String C35x40C;
    @Column(name = "main_sscode")
    @JsonProperty("main_sscode")
    private String main_sscode;
    @Column(name = "main_ssname")
    @JsonProperty("main_ssname")
    private String main_ssname;
    @Column(name = "other_sscode")
    @JsonProperty("other_sscode")
    private String other_sscode;
    @Column(name = "other_ssname")
    @JsonProperty("other_ssname")
    private String other_ssname;
    @Column(name = "main_jbcode")
    @JsonProperty("main_jbcode")
    private String main_jbcode;
    @Column(name = "main_jbname")
    @JsonProperty("main_jbname")
    private String main_jbname;
    @Column(name = "other_jbcode")
    @JsonProperty("other_jbcode")
    private String other_jbcode;
    @Column(name = "other_jbname")
    @JsonProperty("other_jbname")
    private String other_jbname;
    @Column(name = "sid")
    @JsonProperty("sid")
    private Integer sid;
    @Column(name = "second_code")
    @JsonProperty("second_code")
    private String second_code;
    @Column(name = "name")
    @JsonProperty("name")
    private String name;
    @Column(name = "CM_1_2_2_2")
    @JsonProperty("CM_1_2_2_2")
    private String CM_1_2_2_2;

    @Column(name = "CM_1_6_3_2")
    @JsonProperty("CM_1_6_3_2")
    private String CM_1_6_3_2;

    @Column(name = "CM_1_5_2")
    @JsonProperty("CM_1_5_2")
    private String  CM_1_5_2 ;

    @Column(name = "CM_1_3_1_2")
    @JsonProperty("CM_1_3_1_2")
    private String  CM_1_3_1_2 ;

    @Column(name = "CM_1_2_1_2")
    @JsonProperty("CM_1_2_1_2")
    private String  CM_1_2_1_2 ;
   }