package com.sxdl.hn.entity;

import lombok.Data;


//his患者基本信息
@Data
public class Hnpatientinfo {

    //住院号+住院次数
    private String blh;

    //住院号
    private String zyh;

    //住院次数
    private Integer zycs;

    //患者姓名
    private String name;

    //性别
    private String sex;

    //年龄
    private String age;

    //入院时间
    private String ry_time;

    //出院时间
    private String cy_time;

    //入院科室代码
    private String ry_code;

    //入院科室名称
    private String ry_codename;

    //出院科室代码
    private String cy_code;

    //出院科室名称
    private String cy_codename;

    //床位号
    private String cwh;

    //入院诊断
    private String ryzd;

    //病室
    private String bingshi;

}
