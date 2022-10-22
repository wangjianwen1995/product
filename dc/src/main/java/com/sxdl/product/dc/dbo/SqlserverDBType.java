package com.sxdl.product.dc.dbo;

/**
 * sqlserver 数据类型枚举类,用来封装字段类型,字段限定,字段默认值
 */
public enum SqlserverDBType {
    VARCHAR("varchar", "max", " null"), INT("int", "", " null"), NUMERIC("numeric", "18,2", " null"), DATETIME("datetime", "", " null");
    private String type, limit, defult;

    SqlserverDBType(String type, String limit, String defult) {
        this.type = type;
        this.limit = limit;
        this.defult = defult;
    }
    public String getType(){
        return this.type;
    }
    public String getLimit(){
        return this.limit;
    }
    public String getDefult(){
        return this.defult;
    }
}
