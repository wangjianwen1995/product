package com.sxdl.hpqc.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxdl.hpqc.function.*;

import java.util.List;

public class PageUtil {


    public static void setPageInfo(PageInfo pageInfo){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
    }


    public  static  PageInfo getPageInfo(List  data,PageInfo pageInfo){
        PageInfo list = new PageInfo( data);
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }
    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation1 data, Object  v1  ){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo list = new PageInfo( data.execute( v1 ));
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }

    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation2 data, Object  v1 , Object v2 ){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo list = new PageInfo( data.execute( v1,v2));
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }

    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation3 data, Object  v1 , Object v2, Object v3 ){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo list = new PageInfo( data.execute( v1,v2,v3));
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }


    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation4 data, Object  v1 , Object v2, Object v3 , Object v4){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo list = new PageInfo( data.execute( v1,v2,v3,v4));
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }


    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation5 data, Object  v1 , Object v2, Object v3 , Object v4, Object v5){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo list = new PageInfo( data.execute( v1,v2,v3,v4,v5));
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }

}
