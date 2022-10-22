package com.sxdl.fm.util.app;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 工作量报表对应数据枚举类
 */
public enum FMone {
    mjzrs(1, "mjzrs", " SELECT  mzzyh AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl1 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND zyh='x' AND rymc='@!!!@' "),
    szrs(2, "szrs", " SELECT   mzzyh AS 门诊号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl1 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND  mzh='x' AND  rymc='@!!!@' "),
    sscs(3, "sscs", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND ysname='@!!!@'"),
    zdssls(4, "zdssls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄  FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND ysname='@!!!@' "),
    yzssls(5, "yzssls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND ssyz='@!!!@' "),
    zqssls(6, "zqssls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND sslb='择期' AND  ysname='@!!!@'' "),
    jzssls(7, "jzssls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄  FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND type='1' AND ysname='@!!!@' "),
    xy1h(8, "xy1h", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND DATEDIFF(hour,sskssj,ssjssj)<1 AND ysname='@!!!@' "),
    z1d3h(9, "z1d3h", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND DATEDIFF(hour,sskssj,ssjssj)>=1 AND DATEDIFF(hour,sskssj,ssjssj)<3 AND ysname='@!!!@' "),
    dy3h(10, "dy3h", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND DATEDIFF(hour,sskssj,ssjssj)>3 AND ysname='@!!!@' "),
    zlczls(11, "zlczls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND zlxcz='1' AND ysname='@!!!@' "),
    sjssls(12, "sjssls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND ssjbzl='4' AND ysname='@!!!@' "),
    wcssls(13, "wcssls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND iswc='1' AND ysname='@!!!@' "),
    jrssls(14, "jrssls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND isjrss='1' AND ysname='@!!!@' "),
    ylqkshls(15, "ylqkshls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND qkdj='Ⅰ' AND  ysname='@!!!@' "),
    ylqkgrls(16, "ylqkgrls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND qkdj='Ⅰ' AND  qkgr='1' AND  ysname='@!!!@' "),
    ssbfzls(17, "ssbfzls", " SELECT DISTINCT ( CASE WHEN zlxcz <> '1' THEN ysname + CONVERT ( VARCHAR ( 10 ), gzlsj, 120 ) + brid ELSE NULL END ) AS 去重, brid AS 门诊住院号,hzxm AS 姓名,hzxb AS 性别,hznl AS 年龄 FROM T_lf_gzl2 WITH (NOLOCK) " +
            " WHERE gzlsj BETWEEN '@!@' AND '@!!@ 23:59:59' AND qkdj='Ⅰ' AND  ysname='@!!!@' ");
    static String sum = "sum", count = "count", namestr = "";
    public int code;
    public String sql;
    public String name;

    FMone(int _code, String _name, String _sql) {
        this.code = _code;
        this.sql = _sql;
        this.name = _name;
    }

    public static String getSql(int index) {
        if (index < 1 || index > FMone.values().length) return null;
        return Arrays.stream(FMone.values()).filter(e -> e.code == index).map(FMone::getStr).collect(Collectors.toList()).get(0);
    }

    public static String getName(int index) {
        if (index < 1 || index > FMone.values().length) return null;
        return Arrays.stream(FMone.values()).filter(e -> e.code == index).map(FMone::getNameStr).collect(Collectors.toList()).get(0);
    }

    /**
     * 根据工作量id和类型返回拼接的聚合字段
     *
     * @param index
     * @param type  1,sum;2,count;3,max;4,min;5,avg
     *
     * @return
     */
    public static String getNameParam(int index, int type) {
        namestr = getName(index);
        if (type == 1) {
            return " sum(" + namestr + ") as " + namestr + ",";
        } else if (type == 2) {
            return " count(" + namestr + ") as " + namestr + ",";
        } else if (type == 3) {
            return " max(" + namestr + ") as maxval,";
        } else if (type == 4) {
            return " min(" + namestr + ") as minval,";
        } else if (type == 5) {
            return " convert(decimal(10,2),avg(" + namestr + ")) as avgval,";
        }else return "";
    }
    /**
     * 根据工作量id和类型返回拼接的聚合字段,没有最后的分隔符,
     *
     * @param index
     * @param type  1,sum;2,count;3,max;4,min;5,avg
     *
     * @return
     */
    public static String getNameParamWithNotSep(int index, int type) {
        namestr = getName(index);
        if (type == 1) {
            return " sum(" + namestr + ") as " + namestr ;
        } else if (type == 2) {
            return " count(" + namestr + ") as " + namestr ;
        } else if (type == 3) {
            return " max(" + namestr + ") as maxval";
        } else if (type == 4) {
            return " min(" + namestr + ") as minval";
        } else if (type == 5) {
            return " convert(decimal(10,2),avg(" + namestr + ")) as avgval";
        }else return "";
    }

    public String getStr() {
        return this.sql;
    }

    public String getNameStr() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);

    }
}
