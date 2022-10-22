package com.sxdl.hp.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpExportTemplate;
import com.sxdl.hp.service.HpExportExeclService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "导出模板设置")
@RestController
@RequestMapping("/execlTemplate")
public class HpExprotTemplateController {

    @Autowired
    private HpExportExeclService hpExportExeclService;

    @ApiOperation(value = "查询非空的模板")
//    @GetMapping("/getTemplateByUserID")
    @GetMapping("/getTemplateByColNotNull")
    public ResultUtil getTemplateByColNotNull() throws Exception {
        return ResultUtil.success(hpExportExeclService.getTemplateByColNotNull());
    }

    @ApiOperation(value = "查询所有模板")
    @GetMapping("/getTemplates")
    public ResultUtil getTemplates() throws Exception {
        return ResultUtil.success(hpExportExeclService.getAllTemplate());
    }

    @ApiOperation(value = "修改保存导出模板")
    @PostMapping("/saveTemplate")
    public ResultUtil saveTemplate(@RequestBody @Valid HpExportTemplate template, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        hpExportExeclService.saveTemplate(template);
        return ResultUtil.success("操作成功!!!");
    }

    @ApiOperation(value = "删除模板,判断了是否默认模版的情况")
    @PostMapping("/delTemplate")
    public ResultUtil delTemplate(@RequestBody HpExportTemplate template) throws Exception {
        return hpExportExeclService.delTemplate(template);
    }

    @ApiOperation(value = "修改默认模板")
    @PostMapping("/updateDefault")
    public ResultUtil updateDefault(Integer id) throws Exception {
        hpExportExeclService.updateDefault(id);
        return ResultUtil.success("操作成功!!!");
    }
}
