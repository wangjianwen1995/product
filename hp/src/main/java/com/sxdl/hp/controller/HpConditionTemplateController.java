package com.sxdl.hp.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpConditionGroup;
import com.sxdl.hp.service.HpConditionTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "条件组查询模板")
@RestController
@RequestMapping("/conditiontemplate")
public class HpConditionTemplateController {

    @Autowired
    private HpConditionTemplateService templateService;

    /**
     * 条件数据维护
     */
    @ApiOperation(value = "维护人员与条件组关系")
    @PostMapping("/saveConditionTemplate")
    public ResultUtil saveConditionTemplate(@RequestBody HpConditionGroup hpConditionGroup) throws Exception {
        templateService.saveConditionTemplate(hpConditionGroup.getUser_id(), hpConditionGroup);
        return ResultUtil.success("操作成功");
    }
}
