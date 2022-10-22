package com.sxdl.drplus.dto;

import lombok.Data;

@Data
public class ReportDBO {

    private String key;
    private Integer pid;
    private Integer eid;
    private String stime;
    private String etime;
    private Integer iswrite;

}
