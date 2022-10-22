package com.sxdl.drplus.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CVSDBO {

    @NotNull(message = "平台ID不能为空")
    private Integer pid;


    //文件名称
    private String fileName;

    private String platName;

    private String stime;
    private String etime;

    //病例号 格式: '8888','999'
    private String blh;

    //类型 1 csv 2 execl 3 dbf 4 csv zip 5 execl zip  6 dbf zip
    private String type;

    //抽取id
    private String eid;

}
