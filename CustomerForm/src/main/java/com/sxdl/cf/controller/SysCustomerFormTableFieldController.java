package com.sxdl.cf.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.service.SysCustomerFormFactTableService;
import com.sxdl.cf.service.SysCustomerFormFieldTableService;
import com.sxdl.cf.service.SysCustomerFormHeaderColumnService;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.PageUtil;
import com.sxdl.cf.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "1事实表管理 2字段表管理" )
@RestController
@RequestMapping("/dev/faceFieldTable")
@RequiredArgsConstructor
public class SysCustomerFormTableFieldController {
    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final SysCustomerFormFactTableService tableService;

    private final SysCustomerFormFieldTableService fieldService;

    private final SysCustomerFormHeaderColumnService columnService;


    /**
     * 刚进来 查询全部,选择 分类查询分类下的 事实表
     * @param pageInfo
     * @param classify_id
     * @return
     */
    @ApiOperation(value = "查询事实表列表")
    @GetMapping("/getTableList")
    public ResultUtil getTableList(PageInfo pageInfo,
                                   @RequestParam (value = "classify_id",defaultValue = "") String classify_id,
                                   @RequestParam (value = "val",defaultValue = "") String val){
        List<SysCustomerFormFactTableEntity> data = null;
        try {
            if(StringUtils.isEmpty(classify_id)){
                data = tableService.getDataofVal(val);
            }else {
                data = tableService.getDataOfClassify(classify_id,val);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(data);
    }

    @ApiOperation(value = "修改保存事实表")
    @PostMapping("/saveFactTable")
    public ResultUtil saveFactTable(@RequestBody @Valid SysCustomerFormFactTableEntity tableEntity, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            if(StringUtils.isEmpty(tableEntity.getId())){
                tableService.addFactTable(tableEntity);
            }else {
                //表名称,表类型,不能修改
                tableService.updateSelective(tableEntity);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     * 这里 事实表模型 和数据库表都会删除
     * key 删除 子父 表 应该先删除 关联关系,然后才可以删除子表 或者父表
     * @param id
     * @param name
     * @param is_childtable
     * @return
     */
    @ApiOperation(value = "删除事实表")
    @GetMapping("/delFactTable")
    public ResultUtil delFactTable( @RequestParam (value = "id",required = true) String id,
                                    @RequestParam (value = "name",required = true) String name,
                                    @RequestParam (value = "is_childtable",required = true) Integer is_childtable){
        ResultUtil resultUtil = null;
        try {
            resultUtil = tableService.delFactTable(id,name,is_childtable);

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  resultUtil;
    }



    @ApiOperation(value = "查询字段列表")
    @GetMapping("/getFieldList")
    public ResultUtil getFieldList(PageInfo pageInfo,
                                   @RequestParam (value = "pid",required =true) String pid,
                                   @RequestParam (value = "val",defaultValue = "") String val){
        PageInfo list =null;
        try {
            PageUtil.setPageInfo(pageInfo);
            List<SysCustomerFormFieldTableEntity> data =  fieldService.getFieldList(pid,val);
            list =  PageUtil.getPageInfo( data, pageInfo);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }


    /**
     *  这里数据导入查询出所有表字段
     * @param resourcesName  本身事实表名称
     * @param resourcesId    本身事实表ID
     * @param targetName     导入的表名称
     * @return
     */
    @ApiOperation(value = "导入数据表结构")
    @GetMapping("/importFields")
    public ResultUtil importFields(
                                   @RequestParam(value = "resourcesName",required = true)String  resourcesName,
                                   @RequestParam(value = "resourcesId",required = true)String  resourcesId,
                                   @RequestParam(value = "targetName",required = true)String  targetName ) {
        List<SysCustomerFormFieldTableEntity> list =null;
        try {
             list = fieldService.gettargetFields(resourcesName, resourcesId, targetName);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }

  /**
     *  这里数据导入查询出所有表字段
   *   字段后台Dao层进行排序
     * @return
     */
    @ApiOperation(value = "导入数据表结构保存")
    @PostMapping("/importFieldsSave")
    public ResultUtil importFieldsSave( @RequestBody List<SysCustomerFormFieldTableEntity> list) {
        ResultUtil resultUtil = null;
        try {
            resultUtil = fieldService.addFieldTables(list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(resultUtil);
    }


    /**
     * 第一步 字段进行排序
     * @param fieldEntity
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改保存字段")
    @PostMapping("/saveField")
    public ResultUtil saveField(@RequestBody @Valid SysCustomerFormFieldTableEntity fieldEntity, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        ResultUtil resultUtil = null;
        try {

            if(StringUtils.isEmpty(fieldEntity.getId())){
                //对序号进行排序
                Integer num = fieldService.getMaxNum(fieldEntity.getFacttable_id());
                fieldEntity.setOrder_number(num);
                resultUtil = fieldService.addFieldTable(fieldEntity);
            }else {
                resultUtil = fieldService.setFieldTable(fieldEntity);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  resultUtil;
    }

    @ApiOperation(value = "删除字段")
    @DeleteMapping("/delField")
    public ResultUtil delField(@RequestBody SysCustomerFormFieldTableEntity fieldEntity ) {
        ResultUtil resultUtil = fieldService.delFieldTable(fieldEntity);
        return resultUtil;
    }







}
