package com.sxdl.base.util;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 获取全局缓存数据工具类
 */
public class GetDataFromApp {

    /**
     * 从缓存理根据值获取字典表其他信息
     * @param dictId 如题
     * @param typeId 如题
     */
    public static SysDictVal getDcDitVal(Integer dictId, String typeId) {
        List<SysDictVal> dcDitVals = findDcDitVals ( dictId );
        List<SysDictVal> dcDitValList = dcDitVals.stream ().filter ( e -> null != e && e.getVal ().equals ( typeId ) && e.getIs_on () == 1 ).collect ( Collectors.toList () );
        return (dcDitValList!=null&&dcDitValList.size ()>0)?dcDitValList.get ( 0 ):null;
    }

    /**
     * 获取所有表名
     */
    public static List<SysDictTable> findDcDitTables() {
        List<SysDictTable> list = (List<SysDictTable>) ApplicationRunnerImpl.contextMap.get ( "dcDitTableList" );
        return list;
    }

    /**
     * 获取所有标值
     * @param dict_id 如题
     */
    public static List<SysDictVal> findDcDitVals(Integer dict_id) {
        Map<Integer, List<SysDictVal>> dvAllMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get ( "dvAllMap" );
        List<SysDictVal> dcDitVals = dvAllMap.get ( dict_id );
        if(CollUtil.isNotEmpty(dcDitVals)){
            dcDitVals=dcDitVals.stream()
                    .filter ( e -> null != e && e.getIs_on () == 1 )
                    .sorted(Comparator.comparing( o->Integer.parseInt(o.getVal())))
                    .collect ( Collectors.toList () );
        }
        return dcDitVals!=null&&dcDitVals.size ()>0?dcDitVals:null;
    }



}
