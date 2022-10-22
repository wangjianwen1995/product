package com.sxdl.drplus.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.service.DrPlusCenterTableService;
import com.sxdl.drplus.service.DrPlusPlatformDetailedService;
import com.sxdl.drplus.util.BeanUtils;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "平台详情")
@RestController
@RequestMapping("/platformDetailed")
public class DrPlusPlatformDetailedController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    private static final  String TABLE="drplus_center_table_data";
    private static final  String TABLE_IOC="drplus_center_table_data_ioc";

    @Autowired
    private DrPlusPlatformDetailedService drPlusPlatformDetailedService;


    @Autowired
    private DrPlusCenterTableService centerTableService;







    /**
     *
     * 后台设置维护调用此接口
     * @return
     */
    @ApiOperation(value = "获取平台类别和平台名称信息>>后台平台信息维护前,数据平台(JSON)列表的获取")
    @GetMapping("/getPlatformInfo")
    public ResultUtil getPlatformInfo() {
        JSONObject jsonDate ;
        try {
            JSONObject json  = new JSONObject();
            DrPlusPlatformDetailed detailed = new DrPlusPlatformDetailed();
            jsonDate = FileUtil.getJsonDate("platform.json");
            List<DrPlusPlatformDetailed> detailedList = drPlusPlatformDetailedService.select(detailed);
            JSONObject jsonArray = JSONObject.fromObject(jsonDate.get("listmaps"));
            JSONArray jsonArray1 = JSONArray.fromObject(jsonArray.get("1"));
            for (int i = 0; i < jsonArray1.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonArray1.get(i));
                for (DrPlusPlatformDetailed e : detailedList) {
                    if(( jsonObject.getString("key")).equals(e.getId().toString()) && e.getIs_qy()==1){
                        jsonObject.put("is_qy","1");
                        jsonArray1.set(i,jsonObject);
                    }
                }
            }
            json.put("1",jsonArray1);

            JSONArray jsonArray2 = JSONArray.fromObject(jsonArray.get("2"));
            for (int i = 0; i < jsonArray2.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonArray2.get(i));
                for (DrPlusPlatformDetailed e : detailedList) {
                    if(( jsonObject.getString("key")).equals(e.getId().toString()) && e.getIs_qy()==1){
                        jsonObject.put("is_qy","1");
                        jsonArray2.set(i,jsonObject);
                    }
                }
            }
            json.put("2",jsonArray2);


            JSONArray jsonArray3 = JSONArray.fromObject(jsonArray.get("3"));
            for (int i = 0; i < jsonArray3.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonArray3.get(i));
                int finalI = i;
                detailedList.forEach(e->{
                    if(( jsonObject.getString("key")).equals(e.getId().toString()) && e.getIs_qy()==1){
                        jsonObject.put("is_qy","1");
                        jsonArray3.set(finalI,jsonObject);
                    }
                });
            }
            json.put("3",jsonArray3);
            jsonDate.put("listmaps",json);
            //ApplicationHome h = new ApplicationHome(this.getClass());
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(jsonDate);
    }

    /**
     * 首页页面 已经启用的平台(后续正式开始抽取上报数据)
     * @return
     */
    @ApiOperation(value = "获取list数据2 针对绩效的一样平台")
    @GetMapping("/getPlatformList2")
    public ResultUtil getPlatformList2() {
        Map<String,List<DrPlusPlatformDetailed>> collect  = new LinkedHashMap<>();
        try {
            DrPlusPlatformDetailed detailed = new DrPlusPlatformDetailed();
            detailed.setIs_qy(1);
            List<DrPlusPlatformDetailed> listData = drPlusPlatformDetailedService.select(detailed);
            List<DrPlusPlatformDetailed> listData2 = BeanUtils.deepCopyList(listData);

            listData.forEach(e->{
                if(e.getId()==6){

                    DrPlusPlatformDetailed detailed1= null;
                    try {
                        detailed1 = BeanUtils.deepCopyBean(e);
                    } catch (IOException | ClassNotFoundException ioException) {
                        ioException.printStackTrace();
                    }
                    detailed1.setDrplus_platform_bigclass_name("省平台");
                    detailed1.setDrplus_platform_bigclass_id(2);
                    detailed1.setName("DRG综合管理应用平台(中医)");
                    detailed1.setId(11);
                    listData2.add(detailed1);
                }else if(e.getId()==7){
                    DrPlusPlatformDetailed detailed1= null;
                    try {
                        detailed1 = BeanUtils.deepCopyBean(e);
                    } catch (IOException | ClassNotFoundException ioException) {
                        ioException.printStackTrace();
                    }
                    detailed1.setDrplus_platform_bigclass_name("省平台");
                    detailed1.setDrplus_platform_bigclass_id(2);
                    detailed1.setName("DRG综合管理应用平台(西医)");
                    detailed1.setId(12);
                    listData2.add(detailed1);
                }
            });
            Map<String, List<DrPlusPlatformDetailed>> map   = listData2.stream()
                    .collect(Collectors.groupingBy(DrPlusPlatformDetailed::getDrplus_platform_bigclass_name));
            if(map.containsKey("国家平台"))
                collect.put("国家平台",map.get("国家平台"));
            if(map.containsKey("省平台"))
                collect.put("省平台",map.get("省平台"));
            if(map.containsKey("市平台"))
                collect.put("市平台",map.get("市平台"));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( collect);
    }


    /**
     * 首页页面 已经启用的平台(后续正式开始抽取上报数据)
     * @return
     */
    @ApiOperation(value = "获取list数据")
    @GetMapping("/getPlatformList")
    public ResultUtil getPlatformList() {
        Map<String,List<DrPlusPlatformDetailed>> collect = new LinkedHashMap<>();
        try {
            DrPlusPlatformDetailed detailed = new DrPlusPlatformDetailed();
            detailed.setIs_qy(1);
            List<DrPlusPlatformDetailed> listData = drPlusPlatformDetailedService.select(detailed);
            Map<String, List<DrPlusPlatformDetailed>> map = listData.stream()
                    .collect(Collectors.groupingBy(DrPlusPlatformDetailed::getDrplus_platform_bigclass_name));
            if(map.containsKey("国家平台"))
                collect.put("国家平台",map.get("国家平台"));
            if(map.containsKey("省平台"))
                collect.put("省平台",map.get("省平台"));
            if(map.containsKey("市平台"))
                collect.put("市平台",map.get("市平台"));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( collect);
    }

    /**
     * 首页页面 已经启用的平台(后续正式开始抽取上报数据)
     * @return
     */
    @ApiOperation(value = "获取list数据名称和代码")
    @GetMapping("/getPlatformListName")
    public ResultUtil getPlatformListName() {
        List<DrPlusPlatformDetailed> listData = null;
        try {
            DrPlusPlatformDetailed detailed = new DrPlusPlatformDetailed();
            detailed.setIs_qy(1);
            listData = drPlusPlatformDetailedService.select(detailed);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( listData);
    }


    /**
     * 点击一个平台,进行数据回显时调用此接口, 若数据库中没有数据代表没有维护过,对他进行默认值设置
     * @param id
     * @return
     */
    @ApiOperation(value = "获取平台类别和平台名称信息")
    @GetMapping("/getPlatformDetailedById")
    public ResultUtil getPlatformDetailedById(@RequestParam(value = "id",required = true) Integer id,
                                              @RequestParam(value = "name",required = true) String name,
                                              @RequestParam(value = "pid",required = true) Integer pid
    ) {
        DrPlusPlatformDetailed detailed = null;
        try {
            detailed = drPlusPlatformDetailedService.getPlatformDetailedById(id);
            if(StringUtils.isEmpty(detailed)){
                detailed = new DrPlusPlatformDetailed();
                detailed.setId(id);
                detailed.setName(name);
                detailed.setDrplus_platform_bigclass_id(pid);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( detailed);
    }


    /**
     * 平台列表通过json数据回显,json中的平台platform.id 对映DrPlusPlatformDetailed.id 主键,
     *  第一次维护平台是新增(需要开启主键自增插入数据模式),后续都是修改操作  故而没有删除功能
     * @param detailed
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "维护平台信息")
    @PostMapping("/saveDetailed")
    public ResultUtil saveDetailed(@RequestBody @Valid DrPlusPlatformDetailed detailed, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            if(StringUtils.isEmpty(detailed.getIs_qy()))
                detailed.setIs_qy(0);
            //数据表中存在该数据修改,不存在新增,新增需要打开主键插入 , 并且将数据保存到 center表中
            drPlusPlatformDetailedService.saveDetailedData(detailed);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     * 平台启停 这块功能只给实施人员使用  ,停用的平台不需要前端回显
     * @param id
     * @param type 0 停用 1启用
     * @return
     */
    @ApiOperation(value = "维护平台启停状态")
    @GetMapping("/updateType")
    public ResultUtil updateType(@RequestParam(value = "id",required = true) Integer id,
                                 @RequestParam(value = "type",required = true) Integer type) {

        try {
            if (drPlusPlatformDetailedService.getCountById(id)<1)
                return  ResultUtil.error("温馨提示:平台未维护,请先完成平台维护");
            int i = drPlusPlatformDetailedService.updateType(id,type);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }












}
