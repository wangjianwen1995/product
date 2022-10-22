package com.sxdl.hp.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpCondition;
import com.sxdl.hp.entity.HpConditionGroup;
import com.sxdl.hp.service.HpConditionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "条件维护")
@RestController
@RequestMapping("/condition")
public class HpConditionController {

    @Autowired
    private HpConditionService conditionService;


    @ApiOperation(value = "查询一个条件组下的条件")
    @GetMapping("/findConditionByGroup")
    public ResultUtil findConditionByGroup(@RequestParam(value = "pid", required = true) String pid) throws Exception {
        List<HpCondition> list = conditionService.findConditionByGroup(pid);
        return ResultUtil.success(list);
    }

    @ApiOperation(value = "条件保存修改")
    @PostMapping("/saveCondition")
    public ResultUtil saveCondition(@RequestBody HpConditionGroup conditionGroup) throws Exception {
        if (conditionGroup.getHpConditions().size() < 1) return ResultUtil.error("没有要保存的数据");
        Map<String, String> stringMap = conditionService.saveCondition(conditionGroup);
        if ("-1".equals(stringMap.get("type"))) {
            return ResultUtil.error("动态sql有语法错误: " + stringMap.get("sql"));
        }
        return ResultUtil.success("操作成功");
    }


}
