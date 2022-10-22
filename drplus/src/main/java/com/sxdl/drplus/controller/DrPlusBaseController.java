package com.sxdl.drplus.controller;


import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.impl.SysDictValServiceImpl;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.config.DrPlusApplicationRunnerImpl;
import com.sxdl.drplus.entity.DrPlusAreaZip;
import com.sxdl.drplus.entity.DrplusJbicd;
import com.sxdl.drplus.entity.DrplusSsicd;
import com.sxdl.drplus.service.*;
import com.sxdl.drplus.util.DataUtil;
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
import java.util.stream.Collectors;

@Api(tags = "基础接口")
@RestController
@RequestMapping("/baseInterface")
public class DrPlusBaseController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private DrPlusPlatformDetailedService detailedService;

    @Autowired
    private DrPlusCenterTableService tableService;


    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysDictValServiceImpl dcDitValService;

    /**
     *
     * 平台明细 里面设置的数据源表,获取表中的字段
     * @return
     */
    @ApiOperation(value = "获取平台设置的表的字段")
    @GetMapping("/getPlatformsetTableCol")
    public ResultUtil getPlatformsetTableCol(@RequestParam(value = "id",required = true) Integer id) {
        List<String> list = new ArrayList<>();
        try {
            String source_table = detailedService.selectByKey(id).getSource_table();
            if(!StringUtils.isEmpty(source_table)){
                list =  tableService.getTableColumns(source_table);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }

    /**
     *
     * 实时查询数据库表中的 数据字典
     * @param dictName   sys_dict_val.dictName
     * @return
     */
    //key 暂时不用次接口 使用下面的查询多个数据的接口
    @ApiOperation(value = "实时查询数据字典")
    @GetMapping("/getDictionariesByName")
    public ResultUtil getDictionariesByName(PageInfo pageInfo,@RequestParam(value = "dictName",required = true) String dictName,
                                            @RequestParam(value = "val",defaultValue = "" ) String val ) {
        Map<String, Object> listPage;
        try {
            SysDictVal sysDictVal = new SysDictVal();
            sysDictVal.setDict_name(dictName);
            List<SysDictVal> list = dcDitValService.getDictionariesByName(dictName,val);
            listPage = PageList.getListPage(pageInfo, list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }

    /**
     *
     * 实时查询数据库表中的 数据字典
     * @param dictNames   'sys_dict_val.dictName','sys_dict_val.dictName'
     * @return
     */
    @ApiOperation(value = "实时查询数据字典:多个dictName")
    @GetMapping("/getDictionariesByNameMuch")
    public ResultUtil getDictionariesByNameMuch(@RequestParam(value = "dictNames",required = true) String dictNames  ) {
        Map<String, List<SysDictVal>> collect;
        try {
            List<SysDictVal> list = dcDitValService.getDictionariesByNameMuch(dictNames);
            collect = list.stream().collect(Collectors.groupingBy(e -> e.getDict_name()));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(collect);
    }

    /**
     *
     * 实时查询数据库表中的 数据字典
     * @param sourceName
     * @return
     */
    @ApiOperation(value = "根据来源名称查询数据")
    @GetMapping("/getDictionariesBySourceNameMuch")
        public ResultUtil getDictionariesBySourceNameMuch(@RequestParam(value = "sourceName",required = true) String sourceName  ) {
        Map<String, List<SysDictVal>> collect;
        try {
            List<SysDictVal> list = dcDitValService.getDictionariesBySourceNameMuch(sourceName);
            collect = list.stream().collect(Collectors.groupingBy(e -> e.getDict_name()));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(collect);
    }



    /**
     *
     * 平台详情里面设置的数据源表,获取表中的字段,这里只要前10
     * @return
     */
    @ApiOperation(value = "获取平台设置的表的字段根据 值查询")
    @GetMapping("/getPlatformsetTableColByval")
    public ResultUtil getPlatformsetTableColByval(@RequestParam(value = "id",required = true) Integer id,
                                             @RequestParam(value = "val" ,defaultValue = "") String val) {
        List<String> list = new ArrayList<>();
        try {
            String source_table = detailedService.selectByKey(id).getSource_table();
            if(!StringUtils.isEmpty(source_table)){
                list =  tableService.getTableColumnsByVal(source_table,val);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }


    @ApiOperation(value = "查询所有省份信息")
    @GetMapping("/findAllProvince")
    public ResultUtil findAllProvince(){
        List<DrPlusAreaZip>  collect = new ArrayList<>();
        try {
            List<DrPlusAreaZip> areaZipList = (List<DrPlusAreaZip>)DrPlusApplicationRunnerImpl.contextMap.get("areaZip");
            collect = areaZipList.stream().filter(e -> "2".equals(e.getGrade().toString())).collect(Collectors.toList());
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(collect);
    }


    @ApiOperation(value = "查询省份下面所有->市级信息")
    @GetMapping("/findCityByProId")
    public ResultUtil findCityByProId(@RequestParam(value = "parent_code",required = true) String parent_code ){
        List<DrPlusAreaZip> list = new ArrayList<>();
        try {
            List<DrPlusAreaZip> areaZipList = (List<DrPlusAreaZip>) DrPlusApplicationRunnerImpl.contextMap.get("areaZip");
            list = areaZipList.stream().filter(e -> "3".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(list);
    }



    @ApiOperation(value = "查询市级下面所有->县级信息")
    @GetMapping("/findCountyByCityId")
    public ResultUtil findCountyByCityId(@RequestParam(value = "parent_code",required = true) String parent_code){
        List<DrPlusAreaZip> list = new ArrayList<>();
        try {
            List<DrPlusAreaZip> areaZipList = (List<DrPlusAreaZip>)DrPlusApplicationRunnerImpl.contextMap.get("areaZip");
            list = areaZipList.stream().filter(e -> "4".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(list);
    }



    @ApiOperation(value = "查询县级下面所有->乡镇信息")
    @GetMapping("/findTownByCouId")
    public ResultUtil findTownByCouId(@RequestParam(value = "parent_code",required = true) String parent_code){
        List<DrPlusAreaZip> list = new ArrayList<>();
        try {
            List<DrPlusAreaZip> areaZipList = (List<DrPlusAreaZip>)DrPlusApplicationRunnerImpl.contextMap.get("areaZip");
            list = areaZipList.stream().filter(e -> "5".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(list);
    }


    /**
     * 这里的数据到时候要修改成 查询缓存中的数据
     * @return
     */
    @ApiOperation(value = "根据姓名或者代码 查询 用户数据")
    @GetMapping("/findNurseBynameOrCode")
    public ResultUtil findNurseBynameOrCode(PageInfo pageInfo, @RequestParam(value = "kscode" ,required = false,defaultValue = "") String kscode,
                                            @RequestParam(value = "val",required = false,defaultValue = "") String val){
        Map<String, Object> listPage =null;
        try {
            List<SysUser> list = null;
            if("".equals(kscode)){
                list = sysUserDao.selectByVal("%"+val+"%");
            }else{
                list = sysUserDao.selectKsAndVal(kscode,"%"+val+"%");
            }
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(listPage);
    }


    @Autowired
    private DrplusSsicdService ssicdService;


    @Autowired
    private DrplusJbicdService jbicdService;

    /**
     *
     * @param pageInfo
     * @param pid    drplus_platform_detailed_id
     * @param type 1 疾病 2 手术
     * @return
     */
    @ApiOperation(value = "查询 疾病/手术 明细")
    @GetMapping("/getDetailedByPid")
    public ResultUtil getDetailedByPlateFormPid(PageInfo pageInfo,
                                       @RequestParam(value = "pid",required = true) Integer pid ,
                                       @RequestParam(value = "type",required = true) Integer type ,
                                       @RequestParam(value = "val",defaultValue = "") String val) {
        Map<String, Object> listPage=null;
        try {
            if (type==1){
                List<DrplusJbicd> list = jbicdService.getDetailedByPlateFormPid(pid,val);
                listPage = PageList.getListPage(pageInfo, list);
            }else if (type==2){
                List<DrplusSsicd> list = ssicdService.getDetailedByPlateFormPid(pid,val);
                listPage = PageList.getListPage(pageInfo, list);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }





}
