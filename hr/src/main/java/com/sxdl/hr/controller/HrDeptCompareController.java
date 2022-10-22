package com.sxdl.hr.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hr.dao.dao1.Handle1Dao;
import com.sxdl.hr.dao.dao1.HrPlatDeptCompare;
import com.sxdl.hr.entity.Handle1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shqrpknife
 * @create 2022-08-05-14:03
 * 科室对照
 */
@Api(tags = "科室对照")
@RestController
@RequestMapping("/deptCompare")
public class HrDeptCompareController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    Handle1Dao handle1Dao;

    @Autowired
    HrPlatDeptCompare hrPlatDeptCompare;
    /**
     *
     * 获取平台标准科室（分组）信息
     * @return
     */
    @ApiOperation(value = "获取平台标准代码和名称")
    @GetMapping("/getPlatDeptTable")
    public ResultUtil getPlatDeptTable() {
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            list = handle1Dao.selectSqlWithSQL("select * FROM bzks");
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(list);
    }
    /**
     *
     * 获取医院科室信息
     * @return
     */
    @ApiOperation(value = "获取医院科室信息")
    @GetMapping("/getHospitalDeptTable")
    public ResultUtil getHospitalDeptTable() {
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            String sysname = handle1Dao.selectSqlWithSQLStr("SELECT name_zh FROM dbo.hr_sys_dict_table WHERE name='systemname'");
            if("net".equals(sysname)){
                list = handle1Dao.selectSqlWithSQL("select distinct KsCode ryks,ksname,pym FROM tuseks");
            }else if("java".equals(sysname)){
                list = handle1Dao.selectSqlWithSQL("select distinct code ryks,name ksname,pym FROM sys_ks ");
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(list);
    }

    /**
     *
     * 获取平台和医院的科室所有的对照信息
     * @return
     */
    @ApiOperation(value = "获取平台和医院的科室所有的对照信息")
    @GetMapping("/getDeptCompare")
    public ResultUtil getDeptCompare(String ksname) {
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            String sysname = handle1Dao.selectSqlWithSQLStr("SELECT name_zh FROM dbo.hr_sys_dict_table WHERE name='systemname'");
            if("net".equals(sysname)){
                if(ksname==null || "".equals(ksname)|| "null".equals(ksname)){
                    list = handle1Dao.selectSqlWithSQL("select a.yyksname yyksname,c.KsCode yykscode, b.ksname bzksname,b.kscode bzkscode FROM dzks a,bzks b,TUseKs c WHERE a.dzid=b.kscode AND a.yykscode=c.kscode");
                }else{
                    list = handle1Dao.selectSqlWithSQL("select a.yyksname yyksname,c.KsCode yykscode, b.ksname bzksname,b.kscode bzkscode FROM dzks a,bzks b,TUseKs c WHERE a.dzid=b.kscode AND a.yykscode=c.kscode AND (a.yyksname like'%"+ksname+"%' OR b.ksname like'%"+ksname+"%')");
                }
            }else if("java".equals(sysname)){
                if(ksname==null || "".equals(ksname)|| "null".equals(ksname)){
                    list = handle1Dao.selectSqlWithSQL("select a.yyksname yyksname,c.code yykscode, b.ksname bzksname,b.kscode bzkscode FROM dzks a,bzks b,sys_ks c WHERE a.dzid=b.kscode AND a.yyksname=c.name");
                }else{
                    list = handle1Dao.selectSqlWithSQL("select a.yyksname yyksname,c.code yykscode, b.ksname bzksname,b.kscode bzkscode FROM dzks a,bzks b,sys_ks c WHERE a.dzid=b.kscode AND a.yyksname=c.name AND (a.yyksname like'%"+ksname+"%' OR b.ksname like'%"+ksname+"%')");
                }
            }


        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(list);
    }

    /**
     *
     * 新增平台和医院的科室对照信息
     * @return
     */
    @ApiOperation(value = "新增平台和医院的科室对照信息")
    @GetMapping("/saveDeptCompare")
    public ResultUtil saveDeptCompare(String yyksname,String bzkscode) {
        try {
             List<Map<String,Object>>  lists = handle1Dao.selectSqlWithSQL("select * FROM dzks WHERE yyksname ='"+yyksname+"'");
             if(lists.size()>0){
                 return ResultUtil.success("医院科室已对照");
             }else{
                 hrPlatDeptCompare.Insert(yyksname,bzkscode);
             }
            return ResultUtil.success("保存成功");
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**
     *
     * 删除平台和医院的科室对照信息
     * @return
     */
    @ApiOperation(value = "删除平台和医院的科室对照信息")
    @GetMapping("/delDeptCompare")
    public ResultUtil delDeptCompare(@RequestParam(value = "yyksname",required = true) String yyksname) {
        Integer total;
        try {
            total = hrPlatDeptCompare.Del(yyksname);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
}
