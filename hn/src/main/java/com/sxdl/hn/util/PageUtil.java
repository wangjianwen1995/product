package com.sxdl.hn.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.sxdl.hn.function.Funcation1;
import com.sxdl.hn.function.Funcation2;
import com.sxdl.hn.function.Funcation3;
import com.sxdl.hn.function.Funcation4;
import com.sxdl.hn.function.Funcation5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {

    public static void setPageInfo(int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
    }

    public static void setPageInfo(PageInfo pageInfo){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        //PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("字段").setOrderBy()

    }


    public  static  PageInfo getPageInfo(List  data,int pageNum,int pageSize){
        PageInfo list = new PageInfo( data,pageSize);
        list.setPageNum(pageNum);
        list.setPageSize(pageSize);
        return list;
    }
    public  static  PageInfo getPageInfo(List  data,PageInfo pageInfo){
        PageInfo list = new PageInfo( data ,pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        list.setPageSize(pageInfo.getPageSize());
        return list;
    }
    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation1 data, Object  v1  ){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo list = new PageInfo( data.execute( v1 ),pageInfo.getPageSize());
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }

    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation2  data, Object  v1 ,   Object v2 ){
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo list = new PageInfo( data.execute( v1,v2));
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }

    public  static  PageInfo getPageInfoData(PageInfo pageInfo, Funcation3 data, Object  v1 , Object v2,Object v3 ){
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

    /**
     * 将list数据,按照分页要求切割
     * @param pageNum  当前页数
     * @param pageSize 每页得大小
     * @param list     分页的对象
     */
    public static Map<String, Object> NOSqlOfPage(int pageNum, int pageSize, List list) {
        if (list == null || list.size () == 0) {
            return new HashMap<>();
        }
        int[] sne= cn.hutool.core.util.PageUtil.transToStartEnd(pageNum-1,pageSize);
        int s=sne[0];
        int e=sne[1];
        int totalCount = list.size ();
        Map<String, Object> map = new HashMap<> ();
        map.put ( "total", list.size () );
        map.put ( "pageNum", pageNum );
        if(s>totalCount){
            map.put ( "list", new ArrayList<>() );
            return map;
        }
        if(e>totalCount){
            e=totalCount;
        }
        map.put ( "list", list.subList ( s, e ) );
        return map;
    }

    /**
     * 将list数据,按照分页要求切割
     * @param page 分页信息
     * @param list 列表数据
     * @return 分页后的列表
     */
    public static Map<String, Object> NOSqlOfPage(PageInfo page, List list) {
        return NOSqlOfPage(page.getPageNum(),page.getPageSize(),list);
    }

}
