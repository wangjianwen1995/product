package com.sxdl.product.dc.controller;


import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.GetDataFromApp;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcDictMap;
import com.sxdl.product.dc.service.DcColumnService;
import com.sxdl.product.dc.service.DcDictMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = "dc与his字段对映")
@RestController
@RequestMapping("/dcDictMap")
public class DcDictMapController {

    @Autowired
    private DcDictMapService dcDictMapService;

    @Autowired
    private DcColumnService dcColumnService;

    @Autowired
    private SysDictValService dictValService;




    @ApiOperation(value = "查询左侧字段数据")
    @GetMapping("/findMappingColumn")
    public ResultUtil findMappingColumn(PageInfo pageInfo,@RequestParam(value = "name",defaultValue = "")String name){
        Map<String, Object> listPage =null;
        try{
            pageInfo = dcColumnService.findMappingColumn(pageInfo,name);
        }catch (Exception e){
            return  ResultUtil.error("查询失败"+e.getCause());
        }
        return  ResultUtil.success(pageInfo);
    }



    @ApiOperation(value = "修改字典字段是否启用状态")
    @GetMapping("/updateDictIsOn")
    public ResultUtil updateDictIsOn(@RequestParam(value = "id",required = true) String id,
                                          @RequestParam(value = "is_on",required = true) Integer is_on){
        try{
            Integer integer = dcColumnService.updateDictIsOn(id,is_on);
        }catch (Exception e){
            return  ResultUtil.error("操作失败"+e.getCause());
        }
        return  ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "点击左侧字段名称加载字典对映数据")
    @GetMapping("/loadMappingData")
    public ResultUtil loadMappingData(@RequestParam(value = "his_code",required = false,defaultValue = "") String his_code,
                                      @RequestParam(value = "his_name",required = false,defaultValue = "") String his_name,
                                      @RequestParam(value = "column_id",required = true) String column_id,
                                      @RequestParam(value = "column_name",required = true) String column_name,
                                      @RequestParam(value = "talbe_id",required = true) String talbe_id,
                                      @RequestParam(value = "talbe_name",required = true) String talbe_name,
                                      @RequestParam(value = "dictTable_id",required = true) Integer dictTable_id,
                                      HttpServletRequest request) {
        List<DcDictMap> dcDictMaps  = null;
        try {
            /*
            //TODO  这里获取hiscode数据的时候没问题就注释调这块代码
            if(StringUtils.isEmpty(his_code)){
                his_code = (String)request.getSession().getAttribute("his_code");
                his_name =(String)request.getSession().getAttribute("his_name");
            }

            //1 获取医院基本信息,主要确定该医院是哪个his厂家 (注意这里,要求前端把his的代码储存起来)
            HpHospiatlInfo hpHospiatlInfo = hospitalInfoService.findAll().get(0);*/
            //2 先根据his代码和 字段的id定位到 dc_dict_map  his查询框默认是当前医院的his
            //注意这块的排序使用hp_val_id字段asc是字典数据的id
            dcDictMaps =  dcDictMapService.findDataByHisCodeAndColId(his_code,column_id);
            //3 如果hp_dict_map没有该his的对映数据,后台自己组装hp中的字典数据
            if(dcDictMaps.size()<1){
                SysDictVal sysDictVal = new SysDictVal();
                sysDictVal.setDict_id(dictTable_id);
                List<SysDictVal> vals = dictValService.select(sysDictVal);
                dcDictMaps = new ArrayList<>();
                if(CollUtil.isNotEmpty(vals)){
                    for (SysDictVal e : vals) {
                        DcDictMap dcDictMap = new DcDictMap();
                        dcDictMap.setDict_talbe_id(dictTable_id);
                        dcDictMap.setHis_code(his_code);
                        dcDictMap.setDc_column_id(column_id);
                        dcDictMap.setDc_table_id(talbe_id);
                        dcDictMap.setDc_column_name(column_name);
                        dcDictMap.setDc_table_name(talbe_name);
                        dcDictMap.setDc_key(e.getVal());
                        dcDictMap.setDc_val(e.getName());
                        dcDictMap.setDc_val_id(e.getId());
                        dcDictMap.setHis_name(his_name);
                        dcDictMaps.add(dcDictMap);
                    }
                }

            }
        } catch (Exception e) {
            return  ResultUtil.error("操作失败"+e.getCause());
        }
        return  ResultUtil.success(dcDictMaps);
    }


    /**
     * 这里注意 不需要 这个list里面的id主键,全部是删除然后直接保存,排序使用的是字典的id
     * @param dcColumn 如题
     */
    @ApiOperation(value = "维护dc与HIS字典数据对照")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody DcColumn dcColumn){
        try {
            Integer update = dcDictMapService.save(dcColumn);
        } catch (Exception e) {
            return  ResultUtil.error("操作失败"+e.getCause());
        }
        return  ResultUtil.success("操作成功");
    }



    @ApiOperation(value = "根据条件查询字典表值信息")
    @GetMapping("/findByFactor")
    public ResultUtil findByfactor(  @RequestParam(value = "dict_id", defaultValue = "") Integer dict_id) {
        List<SysDictVal> dcDitVals = new ArrayList<>();
        try {
            dcDitVals = GetDataFromApp.findDcDitVals ( dict_id );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
        return ResultUtil.success ( dcDitVals );
    }

}
