package com.sxdl.base.util;

import cn.hutool.core.util.PageUtil;
import com.github.pagehelper.PageInfo;

/**
 * 拼接,组装,包装验证sql语句的工具类
 */
public class SQLPackageUtil {

    /**
     * 判断sql语句是否select 开头,如果是则截取其余,如果不是则原样返回
     *
     * @param sql 可执行的sql语句
     * @return
     */
    public static String ifStartSelect(String sql) {
        if (StringUtil.isEmpty(sql)) {
            return null;
        }
        String copy = sql.toLowerCase();
        if (copy.trim().startsWith("select")) {
            int start = copy.toLowerCase().indexOf("select") + 6;
            return sql.substring(start);
        }
        return sql;
    }

    /**
     * 拼接分页查询sql语句,默认为每页8条数据
     *
     * @param colums       查询中字段部分的sql片段
     * @param fromAndWhere 查询中from 后面的sql片段
     * @param order        需要排序的字段
     * @param p            分页信息
     * @param isDesc       是否降序排序,否则是升序排序
     * @return
     */
    public static String getPageSQL(String colums, String fromAndWhere, String order, PageInfo p, boolean isDesc) {
        int[] sne = PageUtil.transToStartEnd(p.getPageNum() - 1, p.getPageSize());
        int s = sne[0];
        int e = sne[1];
        colums = ifStartSelect(colums);
        String DESC = "ASC";
        if (isDesc) {
            DESC = "DESC";
        }
        if (StringUtil.isNotEmpty(colums) && StringUtil.isNotEmpty(fromAndWhere)) {
            StringBuilder sbpre = new StringBuilder("SELECT TOP ");
            sbpre.append(p.getPageSize()).append(" aaaa.* FROM (SELECT ");
            return sbpre.append(colums).append(",row_number ( ) OVER (ORDER BY " + order + " " + DESC + ") AS rn ").append(fromAndWhere).append(") AS aaaa WHERE rn >").append(s).append(" AND rn <= ").append(e).append(" ").toString();
        } else {
            return "";
        }
    }

    /**
     * 拼接查总数查询sql语句
     *
     * @param fromAndWhere 可执行的sql片段,从form开始到sql结束
     * @return
     */
    public static String getCountSQL(String fromAndWhere) {
        fromAndWhere = ifStartSelect(fromAndWhere);
        if (StringUtil.isNotEmpty(fromAndWhere)) {
            StringBuilder sbpre = new StringBuilder("SELECT count(1) as cnt ");
            return sbpre.append(fromAndWhere).toString();
        }
        return "";
    }



    /**
     * 生成是否有数据库对象语句
     *
     * @param name 对象名称,表,存储,视图
     * @param type 类型,表,存储,视图
     * @return
     */
    public static String generateIfExists(String name, String type) {
        String xtype = "";
        switch (type) {
            case " table ":
                xtype = "U";
                break;
            case " PROCEDURE ":
                xtype = "P";
                break;
            case " view ":
                xtype = "V";
                break;
        }
        return "select 1 from sysobjects where name='" + name + "' and xType='" + xtype + "'";
    }

    /**
     * 生成是否有数据库对象,如果有则删除语句
     *
     * @param name 对象名称,表,存储,视图
     * @param type 类型,表,存储,视图
     * @return
     */
    public static String generateIfExistsThenDropSql(String name, String type) {
        return "if exists (" + generateIfExists(name, type) + ") Begin DROP " + type + " " + name + " End";
    }

    /**
     * 拼接分页查询sql语句,默认为每页8条数据
     *
     * @param colums       查询中字段部分的sql片段
     * @param fromAndWhere 查询中from 后面的sql片段
     * @param order        需要排序的字段
     * @param p            分页信息
     * @param isDesc       是否降序排序,否则是升序排序
     * @return
     */
    public static String getNotPageSQL(String colums, String fromAndWhere, String order,  boolean isDesc) {
       /* int[] sne = PageUtil.transToStartEnd(p.getPageNum() - 1, p.getPageSize());
        int s = sne[0];
        int e = sne[1];*/
        colums = ifStartSelect(colums);
        String DESC = "ASC";
        if (isDesc) {
            DESC = "DESC";
        }
        if (StringUtil.isNotEmpty(colums) && StringUtil.isNotEmpty(fromAndWhere)) {
            StringBuilder sbpre = new StringBuilder();
            sbpre.append(" SELECT ");
            return sbpre.append(colums).append(",row_number ( ) OVER (ORDER BY " + order + " " + DESC + ") AS rn ").append(fromAndWhere).toString();
        } else {
            return "";
        }
    }


    /**
     * 拼接查总数查询sql语句
     *
     * @param fromAndWhere 可执行的sql片段,从form开始到sql结束
     * @return
     */
    public static String getCountSQL1(String colums,String fromAndWhere) {
        fromAndWhere = ifStartSelect(fromAndWhere);
        if (StringUtil.isNotEmpty(fromAndWhere)) {
            StringBuilder sbpre = new StringBuilder("SELECT count(1) as cnt FROM (SELECT ");

            return sbpre.append(colums).append(" ").append(fromAndWhere).append(") AS aaaa").toString();
        }
        return "";
    }
}
