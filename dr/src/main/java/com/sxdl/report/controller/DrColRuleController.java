package com.sxdl.report.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.entity.DrColRule;
import com.sxdl.report.entity.DrColumn;
import com.sxdl.report.service.DrColRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "字段规则维护")
@RestController
@RequestMapping("/colRule")
public class DrColRuleController {

    @Autowired
    private DrColRuleService drColRuleService;

    @ApiOperation(value = "根据字段id获取规则", notes = "根据字段id获取规则")
    @GetMapping("/findByColumnId")
    @ResponseBody
    public ResultUtil findByTableId(PageInfo pageInfo, @RequestParam(value = "id",required = true) Integer id) {

        DrColRule colrule = new DrColRule();
        colrule.setColumn_id(id);

        try {
            PageInfo<List<DrColumn>> list = drColRuleService.queryPageList(pageInfo,colrule);
            return ResultUtil.success (list);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存表信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody DrColRule colRule) {
        if (colRule == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Integer id=colRule.getId();
            if("".equals(id) || null==id){
                drColRuleService.insert(colRule);
            }else{
                drColRuleService.update(colRule);
            }
            return  ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }


    @ApiOperation(value="删除字段规则",notes="删除字段规则")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
        try{
            drColRuleService.deleteById(id);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }

    }
}
