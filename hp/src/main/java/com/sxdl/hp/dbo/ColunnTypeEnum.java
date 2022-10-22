package com.sxdl.hp.dbo;

public enum ColunnTypeEnum {
    type1(1,"基础信息"),
    type2(2,"诊疗信息"),
    type3(3,"手术信息"),
    type4(4,"费用信息"),
    type5(5,"其他");


    public Integer code;
    public String name;

    ColunnTypeEnum(int code,String name){
        this.code=code;
        this.name=name;
    }

    public static String getTypeName(Integer code){
        if(1==code){
            return   type1.name;
        }else if(2==code){
            return   type2.name;
        }else if(3==code){
            return   type3.name;
        }else if (4==code){
            return type5.name;
        }else{
            return type5.name;
        }
    }

}
