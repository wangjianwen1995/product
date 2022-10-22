package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpDictMap;
import com.sxdl.hp.service.HpColumnService;
import com.sxdl.hp.service.HpDictMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = "病案与his字段对映")
@RestController
@RequestMapping("/dictMap")
public class HpDictMapController {

    @Autowired
    private HpDictMapService mapService;

    @Autowired
    private HpColumnService columnService;

    @Autowired
    private SysDictValService dictValService;

    @ApiOperation(value = "自动对照接口表中的历史数据")
    @GetMapping("/autpMap")
    public ResultUtil autoMap(String name, String hisCode) throws Exception {
        return mapService.autoMap(name, hisCode);
    }

    @ApiOperation(value = "导出当前his厂商下的所有字典对照数据,type:1 sql,2 json")
    @GetMapping("/exprot")
    public void exportData(String hisCode, String type, HttpServletResponse response) throws Exception {
        mapService.exportData(hisCode, type, response);
    }

    @ApiOperation(value = "导入特定格式的json数据,更新服务器的字典对照库")
    @PostMapping("/import")
    public ResultUtil importData(MultipartFile file) throws Exception {
        return mapService.importData(file);
    }

    @ApiOperation(value = "查询左侧字段数据")
    @GetMapping("/findMappingColumn")
    public ResultUtil findMappingColumn(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) throws Exception {
        Map<String, Object> listPage = null;
        // HpTable followerPageTable = hospitalInfoService.getFollowerPageTable();
        List<HpColumn> columns = columnService.findMappingColumn(name);
            /*if(StringUtils.isEmpty(followerPageTable.getName())){  //没有省附页
                columns = columnService.findMappingColumn(name);
            }else{
                columns = columnService.findMappingColumn2(followerPageTable.getName(),name);
            }*/
        listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), columns);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "查询模板字段数据")
    @GetMapping("/findReportTempColumn")
    public ResultUtil findReportTempColumn(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) throws Exception {
        Map<String, Object> listPage = null;
        List<HpColumn> columns = columnService.findReportTempColumn(name);
        listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), columns);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "修改映射启停状态")
    @PostMapping("/updateMappingEnable")
    public ResultUtil updateMappingEnable(@RequestParam(value = "id", required = true) String id,
                                          @RequestParam(value = "is_hisenable", required = true) Integer is_hisenable) throws Exception {
        columnService.updateMappingEnable(id, is_hisenable);
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "点击左侧字段名称加载字典对映数据")
    @GetMapping("/loadMappingData")
    public ResultUtil loadMappingData(@RequestParam(value = "his_code", required = false, defaultValue = "") String his_code,
                                      @RequestParam(value = "his_name", required = false, defaultValue = "") String his_name,
                                      @RequestParam(value = "column_id", required = true) String column_id,
                                      @RequestParam(value = "column_name", required = true) String column_name,
                                      @RequestParam(value = "talbe_id", required = true) String talbe_id,
                                      @RequestParam(value = "talbe_name", required = true) String talbe_name,
                                      @RequestParam(value = "dictTable_id", required = true) Integer dictTable_id,
                                      HttpServletRequest request) throws Exception {
        List<HpDictMap> hpDictMaps = null;
            /*
            //TODO  这里获取hiscode数据的时候没问题就注释调这块代码
            if(StringUtils.isEmpty(his_code)){
                his_code = (String)request.getSession().getAttribute("his_code");
                his_name =(String)request.getSession().getAttribute("his_name");
            }

            //1 获取医院基本信息,主要确定该医院是哪个his厂家 (注意这里,要求前端把his的代码储存起来)
            HpHospiatlInfo hpHospiatlInfo = hospitalInfoService.findAll().get(0);*/
        //2 先根据his代码和 字段的id定位到 hp_dict_map  his查询框默认是当前医院的his
        //注意这块的排序使用hp_val_id字段asc是字典数据的id
        hpDictMaps = mapService.findDataByHisCodeAndColId(his_code, column_id);
        //3 如果hp_dict_map没有该his的对映数据,后台自己组装hp中的字典数据
        if (hpDictMaps.size() < 1) {
            SysDictVal sysDictVal = new SysDictVal();
            sysDictVal.setDict_id(dictTable_id);
            List<SysDictVal> vals = dictValService.select(sysDictVal);
            hpDictMaps = new ArrayList<>();
            for (SysDictVal e : vals) {
                HpDictMap hpDictMap = new HpDictMap();
                hpDictMap.setDict_talbe_id(dictTable_id);
                hpDictMap.setHis_code(his_code);
                hpDictMap.setHp_column_id(column_id);
                hpDictMap.setHp_table_id(talbe_id);
                hpDictMap.setHp_column_name(column_name);
                hpDictMap.setHp_table_name(talbe_name);
                hpDictMap.setHp_key(e.getVal());
                hpDictMap.setHp_val(e.getName());
                hpDictMap.setHp_val_id(e.getId());
                hpDictMap.setHis_name(his_name);
                hpDictMaps.add(hpDictMap);
            }
        }
        return ResultUtil.success(hpDictMaps);
    }

    /**
     * 这里注意 不需要 hpColumn.gethpDictMaps 这个list里面的id主键,全部是删除然后直接保存,排序使用的是字典的id
     *
     * @param hpColumn 如题
     */
    @ApiOperation(value = "维护病案与HIS字典数据对照")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HpColumn hpColumn) throws Exception {
        mapService.save(hpColumn);
        return ResultUtil.success("操作成功");
    }
}
