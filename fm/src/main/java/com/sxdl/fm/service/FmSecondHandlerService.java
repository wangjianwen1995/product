package com.sxdl.fm.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.fm.entity.FmSecondHandler;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FmSecondHandlerService extends BaseService<FmSecondHandler> {
    /**
     * 查询HBI中医生维度数据表\
     * @return List<Map<String, Object>> 数据
     */
    List<Map<String, Object>> selectWys();

    /**
     * 查询HBI中科室维度数据表
     * @return List<Map<String, Object>> 数据
     */
    List<Map<String, Object>> selectWks();

    List<Map<String, Object>> selectWksByName(String name);

    List<Map<String, Object>> selectWksByDm(String dm);

    List<Map<String, Object>> selectWysByName(String name);

    List<Map<String, Object>> selectWysByDm(String dm);

    List<Map<String, Object>> selectGzlSum(String sdate, String edate);

    Map<Object, Object> selectByYear(String sDate1, String edate1, String sDate2, String eDate2, String sDate3, String eDate3, String nameParam, int year);

    List<Map<String, Object>> selectByHBTB(String sDate, String eDate, LocalDate hbsDate, LocalDate hbeDate, LocalDate tbsDate, LocalDate tbeDate, String nameParam);

    Map<String, Object> selectByKs(String sDate, String eDate, String nameParam, String ks);

    List<Map<String, Object>> findBySd(String sDate, String eDate);

    List<Map<String, Object>> findByKsAndSd(String sDate, String eDate, String flag);

    List<Map<String, Object>> findSd();

    //List<Map<String, Object>> selectByHBTB(String sDate, String eDate, String hbsDate, String hbeDate, String tbsDate, String tbeDate, String nameParam);
    /**
     * 插入医生维度数据
     *
     * @param dm 代码,使用"科室名称@医生名称"格式数据
     * @param mc 姓名
     * @return
     */
//    Integer insertWys(String dm, String mc);

    /**
     * 插入科室维度数据
     *
     * @param dm 代码,使用"科室名称"
     * @param mc 科室
     * @return
     */
//    Integer insertWks(String dm, String mc);

    /**
     * 删除医生维度,代码为 dm 的一条数据
     *
     * @param dm 代码,使用"科室名称@医生名称"
     */
//    Integer deleteWys(String dm);

    /**
     * 删除科室维度,代码为 dm 的一条数据
     *
     * @param dm 代码,使用"科室名称@医生名称"
     * @return
     */
//    Integer deleteWks(String dm);

    /**
     * 更新数据
     * @param type 1科主任,2主任医师,3主治医师,4住院医师;5缓存表到数据表
     */
    void updateWFromDrgs(Integer type);

    /**
     * 查询昨天的在院总人数和出院总人数
     */
    List<Map<String, Object>> selectIndexCYZY();
}
