package com.sxdl.hp.controller;


import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpConditionGroup;
import com.sxdl.hp.entity.HpQueryTemplate;
import com.sxdl.hp.service.*;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "高级查询模板")
@RestController
@RequestMapping("/seniorQuery")
public class HpQueryTemplateController {

    @Autowired
    HpColumnService hpColumnService;
    @Autowired
    private QueryTemplateService queryTemplateService;
    @Autowired
    private HpHospiatlInfoService hospiatlInfoService;
    @Autowired
    private HpConditionGroupService conditionGroupService;
    @Autowired
    private HpHomepageService hpHomepageService;

    @ApiOperation(value = "高级查询")
    @GetMapping("/queryDateBySql")
    public ResultUtil queryDateBySql(PageInfo page, @RequestParam(value = "sql", defaultValue = "") String sql,
                                     @RequestParam(value = "user_id", required = true) Integer user_id) throws Exception {
        return ResultUtil.success(hpHomepageService.seniorQueryData(page, sql, user_id));
    }

    @ApiOperation(value = "加载所有下拉框数据")
    @GetMapping("/queryDate")
    public ResultUtil queryDate() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<SysDictVal> dcDitVals = (List<SysDictVal>) HpApplicationRunnerImpl.contextMap.get("dvAllList");
        Map<String, List<SysDictVal>> collect = dcDitVals.stream().filter(e -> null != e && "病案首页字典".equals(e.getSupplement_name())).collect(Collectors.groupingBy(e -> e.getDict_name()));
        map.putAll(collect);
        return ResultUtil.success(map);
    }

    @ApiOperation(value = "正式:查询条件组的数据 和 页面的所有查询框")
    @GetMapping("/isenableData")
    public ResultUtil isenableData(@RequestParam(value = "user_id", required = true) Integer user_id) throws Exception {

        Map<String, Object> map = new HashMap<>();
        //获取条件组数据
        List<HpConditionGroup> conditionGroups = conditionGroupService.IsEnableData(user_id);
        //获取column查询数据
        List<HpColumn> canQueryCol = queryTemplateService.findCanQueryCol(user_id);
        if (null == canQueryCol || canQueryCol.size() <= 0) {
            canQueryCol = queryTemplateService.findIsDefaultCol();
        }
        Map<Integer, List<HpColumn>> collect = canQueryCol.stream().filter(e -> null != e && null != e.getModel_type() && !"".equals(e.getModel_type())).collect(Collectors.groupingBy(e -> e.getModel_type()));
        if (conditionGroups.size() > 0) {
            map.put("b", conditionGroups);
        }
        map.put("a", collect);
        return ResultUtil.success(map);
    }

    @ApiOperation(value = "查询所有项目")
    @GetMapping("/findQueryCol")
    public ResultUtil findQueryCol() throws Exception {
        List<HpColumn> list = new ArrayList<>();
        //获取所有可以查询的字段数据
        String followerPageTable = hospiatlInfoService.getFollowerPageTable();
        if (StringUtil.isEmpty(followerPageTable)) {
            list = queryTemplateService.findQueryCol();
        } else {
            list = queryTemplateService.findQueryCol(followerPageTable);
        }
        return ResultUtil.success(list);
    }

    @ApiOperation(value = "设置页面 左右两个拖拽数据")
    @GetMapping("/findLeftAndRightData")
    public ResultUtil findLeftAndRightData(
            @RequestParam(value = "user_id", required = true) Integer user_id,
            @RequestParam(value = "name", required = false, defaultValue = "") String name) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<HpColumn> fList = hpColumnService.findLeftData(user_id);
        String followerPageTable = hospiatlInfoService.getFollowerPageTable();
        //获取所有可以查询的字段数据 (右侧数据为 待错拽数据,左侧为正式使用的查询数据)
        List<HpColumn> rList = hpColumnService.findRightData(followerPageTable, user_id);
        if (CollUtil.isEmpty(fList)) {
            fList = queryTemplateService.findIsDefaultCol();
        }
        map.put("left", fList);
        map.put("right", rList);
        return ResultUtil.success(map);
    }

    @ApiOperation(value = "修改保存拖拽结果,只需要保存被选中的(被拖拽的)数据,注意用户id的给我")
    @PostMapping("/saveDragAndDrop")
    public ResultUtil saveDragAndDrop(@RequestParam(value = "user_id", required = true) Integer user_id
            , @RequestBody List<HpColumn> hpColumns) throws Exception {
        if (CollUtil.isEmpty(hpColumns)) {
            return ResultUtil.error("没有要保存的数据,请重新拖拽");
        }
        ArrayList<HpColumn> collect = hpColumns.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<HpColumn>
                (Comparator.comparing(HpColumn::getId))), ArrayList::new));
        if (collect.size() < 1) return ResultUtil.error("没有要保存的数据,请重新拖拽");
        queryTemplateService.saveDragAndDrop(user_id, collect);
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "查询用户有多少查询权限")
    @GetMapping("/findUserCanQuery")
    public ResultUtil findUserCanQuery(@RequestParam(value = "user_id", required = true) Integer user_id) throws Exception {
        HpQueryTemplate template = new HpQueryTemplate();
        template.setUser_id(user_id);
        List<HpQueryTemplate> templates = queryTemplateService.select(template);
        return ResultUtil.success(templates);
    }
}
