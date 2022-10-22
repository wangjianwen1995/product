package com.sxdl.sd.util.init;

import lombok.Data;

import java.util.Map;

@Data
public class SdInfoInit {
    private Integer id;
    private String name;
    private String tableName;
    private String entityName;
    private String abbr;//首字母英文缩写词
    private String detail;
    private Integer isOn;
    private Map<String, Object> ets;

    public SdInfoInit(Integer id, String name, String abbr, Integer isOn, String detail) {
        this.id = id;
        this.name = name;
        this.abbr = abbr;
        this.detail = detail;
        this.isOn = isOn;
        setTableName();
        setEntityName();
    }

    public void setTableName() {
        this.tableName = "sd_info_" + this.getAbbr();
    }

    public void setEntityName() {
        this.entityName = "SdInfo" + this.getAbbr();
    }
}
