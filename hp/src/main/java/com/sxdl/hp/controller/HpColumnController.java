package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.entity.HpTable;
import com.sxdl.hp.service.HpColumnService;
import com.sxdl.hp.service.HpHospiatlInfoService;
import com.sxdl.hp.service.HpTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "字段表管理")
@RestController
@RequestMapping("/columns")
public class HpColumnController {

    LinkedHashMap<String, String> linkedHashMap, linkedHashMapC, linkedHashMapE;
    List<LinkedHashMap<String, String>> list, listE, listC;
    HpTable hpTable;
    List<HpTable> tables;
    @Autowired
    private HpColumnService hpColumnService;
    @Autowired
    private HpTableService hpTableService;
    @Autowired
    private HpHospiatlInfoService hpHospiatlInfoService;

    @ApiOperation(value = "查询所有hp_column表中所有数据")
    @GetMapping("/findColumnsByHeader")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo, @RequestParam(value = "name", required = false) String name, String tablename) throws Exception {
        Map<String, Object> listPage = null;
        List<HpColumn> hpColumns = hpColumnService.findColumnsByHeader(name, tablename);
        listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hpColumns);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "添加/修改全属性")
    @PostMapping("/updateAllProperties")
    public ResultUtil updateColumnAllProperties(@RequestBody HpColumn hpColumn) throws Exception {
        if (StringUtil.isNotEmpty(hpColumn.getWeb_name()) && StringUtil.isNotEmpty(hpColumn.getName())) {
            String caseSql = getCaseSql(hpColumn.getWeb_name(), hpColumn.getName(), hpColumn.getTable_name());
            hpColumn.setExport_case(caseSql);
        }
        hpColumnService.updateAllProperties(hpColumn);
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delColumnById")
    public ResultUtil delColumnById(@RequestParam(value = "id", required = true) String id) throws Exception {
        hpColumnService.delColumnById(id);
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "查询所有雕龙附页的字段")
    @GetMapping("/findDLPageByTableId")
    public ResultUtil findDLPageByTableId() throws Exception {
        HpTable retable = new HpTable();
        //查询出,雕龙附页的所有字段数据
        List<HpColumn> hpColumns = hpColumnService.findDLPageByTableId();
        HpTable hpTable = new HpTable();
        hpTable.setIs_diaolong(1);
        List<HpTable> tables = hpTableService.select(hpTable);
        if (tables.size() < 1) {
            return ResultUtil.error("table表中没有雕龙附页");
        } else if (tables.size() > 1) {
            return ResultUtil.error("table表中只能有一个雕龙附页");
        }
        retable = tables.get(0);
        retable.setHpColumns(hpColumns);
        return ResultUtil.success(retable);
    }

    @ApiOperation(value = "查询E表的字段")
    @GetMapping("/findEConfig")
    public ResultUtil findEConfig() throws Exception {
        HpTable retable = new HpTable();

        //查询出,雕龙附页的所有字段数据
        List<HpColumn> hpColumns = hpColumnService.findColumnByTableName("vsch0E");
        HpTable hpTable = new HpTable();
        hpTable.setName("vsch0E");
        List<HpTable> tables = hpTableService.select(hpTable);
        if (tables.size() < 1) {
            return ResultUtil.error("table表中没有维护手术信息表");
        } else if (tables.size() > 1) {
            return ResultUtil.error("table表中只能有一个维护手术信息表");
        }
        retable = tables.get(0);
        retable.setHpColumns(hpColumns);
        return ResultUtil.success(retable);
    }

    @ApiOperation(value = "查询C表的字段")
    @GetMapping("/findCConfig")
    public ResultUtil findCConfig() throws Exception {

        HpTable retable = new HpTable();

        //查询出,雕龙附页的所有字段数据
        List<HpColumn> hpColumns = hpColumnService.findColumnByTableName("vsch0C");
        HpTable hpTable = new HpTable();
        hpTable.setName("vsch0C");
        List<HpTable> tables = hpTableService.select(hpTable);
        if (tables.size() < 1) {
            return ResultUtil.error("table表中没有维护诊断信息表");
        } else if (tables.size() > 1) {
            return ResultUtil.error("table表中只能有一个维护诊断信息表");
        }
        retable = tables.get(0);
        retable.setHpColumns(hpColumns);
        return ResultUtil.success(retable);
    }

    @ApiOperation(value = "查询所有雕龙附页的字段前端专用")
    @GetMapping("/findDLPageShowByTableId")
    public ResultUtil findDLPageShowByTableId() throws Exception {
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMapE = new LinkedHashMap<>();
        linkedHashMapC = new LinkedHashMap<>();
        Map maps = new HashMap();

        //查询出,雕龙附页的所有字段数据

        hpTable = new HpTable();
        hpTable.setIs_diaolong(1);
        tables = hpTableService.select(hpTable);
        if (tables.size() < 1) {
            return ResultUtil.error("hp_table表中没有雕龙附页");
        } else if (tables.size() > 1) {
            return ResultUtil.error("hp_table表中只能有一个雕龙附页");
        }

        list = hpColumnService.findDLPageShow();
        for (LinkedHashMap<String, String> map : list) {
            linkedHashMap.put(map.get("name"), map.get("is_show"));
        }

        listE = hpColumnService.findBytableName("vsch0E");
        for (LinkedHashMap<String, String> map : listE) {
            linkedHashMapE.put(map.get("name"), map.get("is_show"));
        }
        listC = hpColumnService.findBytableName("vsch0C");
        for (LinkedHashMap<String, String> map : listC) {
            linkedHashMapC.put(map.get("name"), map.get("is_show"));
        }
        maps.put("P", linkedHashMap);
        maps.put("E", linkedHashMapE);
        maps.put("C", linkedHashMapC);
        return ResultUtil.success(maps);
    }


    @ApiOperation(value = "修改保存,附页需要展示录入的字段")
    @PutMapping("/saveShow")
    public ResultUtil saveShow(@RequestBody HpTable hpTable) throws Exception {
        if (StringUtils.isEmpty(hpTable.getId())) {
            return ResultUtil.error("没有传入表Id");
        }
        hpColumnService.updateIsShow(hpTable);

        return ResultUtil.success("操作成功");
    }


    @ApiOperation(value = "开始录入,雕龙附页是否显示哪些数据")
    @GetMapping("/findDLPageShow")
    public ResultUtil findDLPageShow() throws Exception {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        //查询出,雕龙附页的所有字段数据
        List<HpColumn> hpColumns = hpColumnService.findDLPageByTableId();
        if (hpColumns.size() > 0) {
            hpColumns.forEach(e -> {
                map.put(e.getName(), StringUtils.isEmpty(e.getOperable_show()) ? 0 : e.getOperable_show());
            });
        }
        return ResultUtil.success(map);
    }


    @ApiOperation(value = "开始录入,各个省附页是否开启,并且与医院行政区划一致")
    @GetMapping("/findShengPageShow")
    public ResultUtil findShengPageShow() throws Exception {
        HpTable retable = new HpTable();
        List<HpTable> select = new ArrayList<>();
        //查询出,雕龙附页的所有字段数据
        List<HpHospiatlInfo> hpHospiatlInfos = hpHospiatlInfoService.findAll();
        if (hpHospiatlInfos.size() != 1) {
            ResultUtil.error("医院信息必须只有一条");
        }
        HpTable hpTable = new HpTable();
        hpTable.setSheng_code(hpHospiatlInfos.get(0).getSheng_code());
        hpTable.setIspage(1);
        hpTable.setIs_enable(1);
        hpTable.setIs_diaolong(0);
        hpTable.setIs_equally(1);
        select = hpTableService.select(hpTable);
        if (select.size() > 0) {
            retable = select.get(0);
        }
        hpTable.setIs_equally(null);
        hpTable.setHomepage_type(hpHospiatlInfos.get(0).getHomepage_type());
        select = hpTableService.select(hpTable);
        if (select.size() > 0) {
            retable = select.get(0);
        }
        return ResultUtil.success(retable);
    }


    /**      字段查询类型设置--->高级查询前置*/
    @ApiOperation(value = "查询需要设置的字段段")
    @GetMapping("/findColumnSettings")
    public ResultUtil findColumnSettings(PageInfo pageInfo,
                                         @RequestParam(value = "name", defaultValue = "") String name) throws Exception {
        Map<String, Object> listPage = null;
        List<HpColumn> list = new ArrayList<>();
        String shengPageTable = hpHospiatlInfoService.getFollowerPageTable();
        if (StringUtil.isEmpty(shengPageTable)) { //该医院没有省附页表
            list = hpColumnService.findColumnSettings(name);
        } else {
            list = hpColumnService.findColumnSettings(name, shengPageTable);
        }
        listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "修改保存附页需要展示录入的字段")
    @PostMapping("/saveColumnSettings")
    public ResultUtil saveColumnSettings(@RequestBody HpColumn hpColumn) throws Exception {
        hpColumnService.update(hpColumn);
        return ResultUtil.success("操作成功");
    }

    public String getCaseSql(String webNme, String columnName, String tableName) throws Exception {
        StringBuilder caseSql = new StringBuilder();
        //  (case when homepage.xb=0 then '未知的性别'  when homepage.xb=1 then '男' when  homepage.xb=2 then '女'  when  homepage.xb=9 then '未说明的性别'  end )
        List<SysDictVal> dcDitVals = (List<SysDictVal>) ApplicationRunnerImpl.contextMap.get("dvAllList");
        dcDitVals = dcDitVals.stream().filter(e -> null != e && e.getDict_name().equals(webNme)).collect(Collectors.toList());
        if (null != dcDitVals && dcDitVals.size() > 0) {
            caseSql.append("(case ");
            dcDitVals.forEach(e -> {
                caseSql.append(" when ").append(tableName + "." + columnName).append("=").append(e.getVal()).append(" then '").append(e.getName()).append("'");
            });
            //caseSql.append("end ) as ").append(columnName);
            caseSql.append("end )  ");
        }
        return caseSql.toString();
    }


}
