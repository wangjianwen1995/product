package com.sxdl.hp.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.dao.dao1.HpExprotTemplateDao;
import com.sxdl.hp.entity.HpExprotExecl;
import com.sxdl.hp.service.HpExportExeclService;
import com.sxdl.hp.service.HpTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "导出exec")
@RestController
@RequestMapping("/export")
public class HpExprotExeclController {

    @Autowired
    HpExprotTemplateDao hpExprotTemplateDao;
    @Autowired
    private HpExportExeclService hpExportExeclService;
    @Autowired
    private HpTableService hpTableService;

    /**
     * 导出时逻辑
     * 1 在没有配置导出模板的情况下,只能点击左半测按钮 ,导出的数据是固定的几个数据
     * 2 在配置了模板情况下,如果没有设置默认多出默认,这块依旧是同1一样导出样式
     * 3 在设置了默认模板情况下,导出你设置的默认模板样式
     * 4 只能设置一个默认模板,如果没有设置认为是系统的固定方案,选择一个模板后,在取消默认模板,才能回到系统默认
     * 5 点击右半侧按钮,选择哪个模板就导出那个模板
     * 6 模板设置,默认会加上系统默认的固定几个字段,属于累加,不会只导出你现在选择的个别几个字段数据2
     *
     * @return
     */
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportExecl")
    public void exportExecl(String sql, Integer user_id, Integer template_id, HttpServletResponse response) throws Exception {
        hpExportExeclService.down(sql, template_id, response);
    }


    @ApiOperation(value = "根据模板查询列数据")
    @GetMapping("/getColByTempalateID")
    public ResultUtil getColByTempalateID(@RequestParam(value = "exprot_id", required = true) Integer exprot_id) throws Exception {
        return ResultUtil.success(hpExportExeclService.getColByTempalateID(exprot_id));
    }

    @ApiOperation(value = "查询可以导出execl的字段")
    @GetMapping("/getCanExeclColumn")
    public ResultUtil getCanExeclColumn() throws Exception {
        return ResultUtil.success(hpExportExeclService.findCanExeclColumn());
    }

    @ApiOperation(value = "修改保存模板中的列数据")
    @PostMapping("/saveColExecl")
    public ResultUtil saveColExecl(@RequestBody HpExprotExecl hpExprotExecl) throws Exception {
        hpExportExeclService.saveColExecl(hpExprotExecl);
        return ResultUtil.success("操作成功!!!");
    }

    @ApiOperation(value = "删除导出列字段")
    @PostMapping("/delColExecl")
    public ResultUtil delColExecl(@RequestBody HpExprotExecl exprotExecl) throws Exception {
        hpExportExeclService.delColExecl(exprotExecl);
        return ResultUtil.success("操作成功!!!");
    }
}
