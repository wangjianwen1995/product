package com.sxdl.drplus.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.entity.DrPlusCenterTable;
import com.sxdl.drplus.service.DrPlusCenterTableService;
import com.sxdl.drplus.service.DrPlusPlatformDetailedService;
import com.sxdl.drplus.util.DataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "字段表(核心)管理")
@RestController
@RequestMapping("/centerTable")
public class DrPlusCenterTableController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private static final  String COL_MESSAGE="表中已经存在该字段名称";

    @Autowired
    private DrPlusCenterTableService centerTableService;

    @Autowired
    private DrPlusPlatformDetailedService detailedService;
    /**
     * 查询 字段列表
     * @param val1
     * @param val2
     * @param val3
     * @param val4   -1 未对应数据   '' 全部
     * @return
     */
    @ApiOperation(value = "查询字段数据列表")
    @GetMapping("/getColumnList")
    public ResultUtil getColumnList(PageInfo pageInfo,
                                    @RequestParam(value = "pid",required = true) Integer pid,
                                    @RequestParam(value = "val1",defaultValue = "") String val1,
                                    @RequestParam(value = "val2",defaultValue = "") String val2,
                                    @RequestParam(value = "val3",defaultValue = "") String val3,
                                    @RequestParam(value = "val4",defaultValue = "") String val4){
        Map<String, Object> listPage ;
        try {
            List<DrPlusCenterTable>  list = null;
            if(6==pid||7==pid){
                list = centerTableService.getLikeDateListAdd(pid,val1,val2,val3,val4);
            }else {
                list = centerTableService.getLikeDateList(pid,val1,val2,val3,val4);
            }
            listPage = PageList.getListPage(pageInfo, list);

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }


    /**
     *
     *  这块的操作 应该是 先点击保存,让他输入授权码,授权码通过验证(验证功能已经完成 授权码有效期五分钟)
     *
     *  新增时,先判断有没有同名的,drplus_center_table 表中添加一条数据,drplus_center_table_data和drplus_center_table_data_ioc
     *   表中添加一列字段 同时,drplus_center_table_data和drplus_center_table_data_ioc 表中的字段说明也添加进去
     *
     *  修改时, 先判断有没有同名的大于1, 判断 DrPlusCenterTable.column_type 字段类型修改没有,判断 是不是只修改的字段名称 /字段解释.,
     * @param centerTable
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "中间表,新增或者 修改一个字段")
    @PostMapping("/saveColumn")
    public ResultUtil saveColumn(@RequestBody @Valid DrPlusCenterTable centerTable, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            if(StringUtils.isEmpty(centerTable.getId())){
                if(centerTableService.getColumnsNumByname(centerTable.getDrplus_platform_detailed_id(),centerTable.getName())>0)
                    return  ResultUtil.error(COL_MESSAGE);
                centerTableService.insertCol(centerTable);
            }else{
                if(centerTableService.getColumnsNumByname(centerTable.getDrplus_platform_detailed_id(),centerTable.getName())>1)
                    return  ResultUtil.error(COL_MESSAGE);
                centerTableService.updateCol(centerTable);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     * 先验证,不对数据表中数据有无进行判断, 弹出危险操作提醒, 删除直接删除drplus_center_table 中的数据
     * 和 drplus_center_table_data 和drplus_center_table_data_ioc中的列
     */
    @ApiOperation(value = "中间表,删除一个字段")
    @PostMapping("/delColumn")
    public ResultUtil delColumn(@RequestBody @Valid DrPlusCenterTable centerTable, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            centerTableService.delColumn(centerTable);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }




    /**
     * 获取来源表,没有对映的字段数据
     * @param val
     * @param type 0 未对映 1已对映  2 全部
     * @param tablenameB   附表表名称
     * @return
     */
    @ApiOperation(value = " 查询未对映字段数据")
    @GetMapping("/getUnmappedColumnList")
    public ResultUtil getUnmappedColumnList(PageInfo pageInfo, @RequestParam(value = "val",defaultValue = "") String val ,
                                            @RequestParam(value = "tablename",required = true) String tablename,
                                            @RequestParam(value = "tablenameB",defaultValue = "") String tablenameB,
                                            @RequestParam(value = "pid",required = true) Integer pid,
                                            @RequestParam(value = "type",required = true) Integer type){
        Map<String, Object> listPage;
        try {
            //String source_table = detailedService.selectByKey(id).getSource_table();
            List<LinkedHashMap<String, String>>   list = null;
            if(StringUtils.isEmpty(tablenameB)){
                list = centerTableService.getUnmappedColumnList(tablename,pid,val,type );
            }else{ //key 若出附表说明一定是拆分表
                list = centerTableService.getUnmappedColumnListAdd( tablename,  tablenameB,  pid,   val ,  type );
            }
            listPage = PageList.getListPage(pageInfo, list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }





    /**
     *  字段完全一样的字段对映好
     * 点击自动映射 前端遮盖等待,成功后前端直接调用查询List接口 getColumnList
     * @param tablename
     * @param pid
     * @return
     */
    @ApiOperation(value = " 源字段自动对映")
    @GetMapping("/getAutomappedColumn")
    public ResultUtil getAutomappedColumn( @RequestParam(value = "tablename",required = true) String tablename,
                                           @RequestParam(value = "pid",required = true) Integer pid,
                                           @RequestParam(value = "tablenameB",defaultValue ="") String tablenameB ){
        try {
            if(StringUtils.isEmpty(tablenameB)){
                centerTableService.getAutomappedColumn(tablename,pid);
            }else{//key 若有附表说明一定是拆分表
                centerTableService.getAutomappedColumnAdd(tablename,tablenameB,pid);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    /**
     *
     *
     * 记住: 这里不做对映的 代表不上报
     * 手动对映源字段 ,左右双击对映(左边选中需要对映的字段,,右边双击要对映的字段)
     * @param columnName
     * @param id
     * @return
     */
    @ApiOperation(value = "源字段手动对映")
    @GetMapping("/getManualmappedColumn")
    public ResultUtil getManualmappedColumn( @RequestParam(value = "columnName",required = true) String columnName,
                                           @RequestParam(value = "id",required = true) Integer id){
        try {
            if(centerTableService.getExistsMapping(id)==1)
                return ResultUtil.error("字段已对映,请先删除对映关系");
            centerTableService.getManualmappedColumn(columnName,id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    @ApiOperation(value = "清楚全部对映关系")
    @GetMapping("/clearMapping")
    public ResultUtil clearMapping(  @RequestParam(value = "pid",required = true) Integer pid ){
        try {
           centerTableService.clearMapping( pid);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    @ApiOperation(value = "清楚一个对映关系")
    @GetMapping("/clearOneMapping")
    public ResultUtil clearOneMapping(  @RequestParam(value = "pid",required = true) Integer pid,
                                        @RequestParam(value = "id",required = true) Integer id
                                        ){
        try {
            if(centerTableService.clearExistsMapping(pid,id)==0)
                return ResultUtil.error("该字段没有对映关系");
            centerTableService.clearOneMapping( pid,id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    /*===================================上报字段对映====================================================*/

    /**
     *
     * @param pageInfo
     * @param pid
     * @param val1    左侧字段名
     * @param val2    字段中文名
     * @param val3    录入上报字段
     * @param val4     -1 未对应数据   '' 全部
     * @return
     */
    @ApiOperation(value = " 查询上报对映数据")
    @GetMapping("/getReportColumnList")
    public ResultUtil getReportColumnList(PageInfo pageInfo,
                                    @RequestParam(value = "pid",required = true) Integer pid,
                                    @RequestParam(value = "val1",defaultValue = "") String val1,
                                    @RequestParam(value = "val2",defaultValue = "") String val2,
                                    @RequestParam(value = "val3",defaultValue = "") String val3,
                                    @RequestParam(value = "val4",defaultValue = "") String val4){
        Map<String, Object> listPage ;
        try {
            List<DrPlusCenterTable>  list = centerTableService.getLikeDateList2(pid,val1,val2,val3,val4);
            listPage = PageList.getListPage(pageInfo, list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }



    /**
     * 记住: 这里不做对映的 代表不上报
     *
     * @param columnName
     * @param id
     * @return
     */
    @ApiOperation(value = "上报字段手动对映")
    @GetMapping("/getReportManualmappedColumn")
    public ResultUtil getReportManualmappedColumn( @RequestParam(value = "columnName",required = true) String columnName,
                                             @RequestParam(value = "id",required = true) Integer id){
        try {
            centerTableService.getReportManualmappedColumn(columnName,id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    /**
     * 记住: 上报字段自动对映 数据源字段这里不做对映的 代表不上报 上报字段不对应的也不上报
     *
     * @return
     */
    @ApiOperation(value = "上报字段自动对映")
    @GetMapping("/getAutoReportManualmappedColumn")
    public ResultUtil getAutoReportManualmappedColumn(  @RequestParam(value = "pid",required = true) Integer pid){
        try {
            centerTableService.getAutoReportManualmappedColumn(pid);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    /**
     * 记住: 上报字段自动对映 数据源字段这里不做对映的 代表不上报 上报字段不对应的也不上报
     *
     * @return
     */
    @ApiOperation(value = " 清空上报对映")
    @GetMapping("/cleanReportManualmappedColumn")
    public ResultUtil cleanReportManualmappedColumn(  @RequestParam(value = "pid",required = true) Integer pid){
        try {
            centerTableService.cleanReportManualmappedColumn(pid);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }





}
