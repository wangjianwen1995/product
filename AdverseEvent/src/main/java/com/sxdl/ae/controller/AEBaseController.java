package com.sxdl.ae.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.ae.config.AEApplicationRunnerImpl;
import com.sxdl.ae.dao.dao1.AEPatientDao;
import com.sxdl.ae.dao.dao1.AESysKsDao;
import com.sxdl.ae.entity.AEAreaZip;
import com.sxdl.ae.entity.AEPatient;
import com.sxdl.ae.entity.AESysKs;
import com.sxdl.ae.util.PageUtil;
import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.impl.SysDictValServiceImpl;
import com.sxdl.base.util.PageList;
import com.sxdl.ae.util.ResultUtil;
import com.sxdl.ae.util.DataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "基础接口")
@RestController
@RequestMapping("/baseInterface")
public class AEBaseController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Autowired
    private AESysKsDao ksDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysDictValServiceImpl dcDitValService;

    @Autowired
    private AEPatientDao patientDao;

    @ApiOperation(value = "查询患者数据")
    @GetMapping("/getPatientData")
    public ResultUtil getPatientData(PageInfo pageInfo,
                                     @RequestParam(value = "val",defaultValue = "" ) String val ) {
        PageInfo pageData = null;
        try {
            Example example = new Example(AEPatient.class);
            Example.Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(val)){
                criteria.andLike("hz_xm","%"+val+"%")
                        .orLike("hz_bah","%"+val+"%")
                        .orLike("hz_zyh","%"+val+"%");
            }

            example.setOrderByClause("hz_jzrq desc");
            List<AEPatient> list = patientDao.selectByExample(example);
            pageData = PageUtil.getPageInfo(list,pageInfo);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(pageData);
    }



    @ApiOperation(value = "查询ICD10编码")
    @GetMapping("/getICD")
    public ResultUtil getICD(   @RequestParam(value = "val",defaultValue = "" ) String val ) {
        List<LinkedHashMap<String, Object>> list = null;
        try {
             list  = patientDao.selectListLinkedMap("select  top 100 * from ae_icd where name like '%" + val + "%' or code like '%" + val + "%'");
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }




    @ApiOperation(value = "查询科室数据")
    @GetMapping("/getKsData")
    public ResultUtil getKsData(  @RequestParam(value = "val",defaultValue = "" ) String val ) {
        List<AESysKs> list = null;
        try {
            Example example = new Example(AESysKs.class);
            Example.Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(val)){
                criteria.andLike("code","%"+val+"%").orLike("name","%"+val+"%");
            }
            example.setOrderByClause("code asc");
            list = ksDao.selectByExample(example);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
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
        Map<String, List<SysDictVal>> collect = new HashMap<>();
        try {
            Map<String, List<SysDictVal>> dictValMap = (Map<String, List<SysDictVal>>)AEApplicationRunnerImpl.contextMap.get("dictValMap");
            for (String name : dictNames.split(",")) {
                collect.put(name,dictValMap.get(name));
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(collect);
    }







    @ApiOperation(value = "查询所有省份信息")
    @GetMapping("/findAllProvince")
    public ResultUtil findAllProvince(){
        List<AEAreaZip>  collect = new ArrayList<>();
        try {
            List<AEAreaZip> areaZipList = (List<AEAreaZip>)AEApplicationRunnerImpl.contextMap.get("areaZip");
            collect = areaZipList.stream().filter(e -> "2".equals(e.getGrade().toString())).collect(Collectors.toList());
        }catch (Exception e){
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(collect);
    }


    @ApiOperation(value = "查询省份下面所有->市级信息")
    @GetMapping("/findCityByProId")
    public ResultUtil findCityByProId(@RequestParam(value = "parent_code",required = true) String parent_code ){
        List<AEAreaZip> list = new ArrayList<>();
        try {
            List<AEAreaZip> areaZipList = (List<AEAreaZip>) AEApplicationRunnerImpl.contextMap.get("areaZip");
            list = areaZipList.stream().filter(e -> "3".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        }catch (Exception e){
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(list);
    }



    @ApiOperation(value = "查询市级下面所有->县级信息")
    @GetMapping("/findCountyByCityId")
    public ResultUtil findCountyByCityId(@RequestParam(value = "parent_code",required = true) String parent_code){
        List<AEAreaZip> list = new ArrayList<>();
        try {
            List<AEAreaZip> areaZipList = (List<AEAreaZip>) AEApplicationRunnerImpl.contextMap.get("areaZip");
            list = areaZipList.stream().filter(e -> "4".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        }catch (Exception e){
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(list);
    }



    @ApiOperation(value = "查询县级下面所有->乡镇信息")
    @GetMapping("/findTownByCouId")
    public ResultUtil findTownByCouId(@RequestParam(value = "parent_code",required = true) String parent_code){
        List<AEAreaZip> list = new ArrayList<>();
        try {
            List<AEAreaZip> areaZipList = (List<AEAreaZip>)AEApplicationRunnerImpl.contextMap.get("areaZip");
            list = areaZipList.stream().filter(e -> "5".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        }catch (Exception e){
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(list);
    }


    /**
     * 这里的数据到时候要修改成 查询缓存中的数据
     * @return
     */
    @ApiOperation(value = "根据姓名或者代码 查询 用户数据")
    @GetMapping("/findNurseBynameOrCode")
    public ResultUtil findNurseBynameOrCode(  @RequestParam(value = "kscode" ,required = false,defaultValue = "") String kscode,
                                            @RequestParam(value = "val",required = false,defaultValue = "") String val){
        List<SysUser> list = null;
        try {

            if(StringUtils.isEmpty(kscode))
                list = sysUserDao.selectKsAndVal(kscode,"%"+val+"%");
            else
                list = sysUserDao.selectVal("%"+val+"%");
        }catch (Exception e){
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(list);
    }



















}
