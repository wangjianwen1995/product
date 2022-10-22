package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.HpAreaZip;
import com.sxdl.hp.entity.HpTable;
import com.sxdl.hp.service.HpTableService;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "区划病案附页管理")
@RestController
@RequestMapping("/table")
public class HpTableController {

    @Autowired
    private HpTableService hpTableService;

    @ApiOperation(value = "查询区划病案附页信息列表")
    @GetMapping("/findAll")
    public ResultUtil findAll(PageInfo page, @RequestParam(value = "sheng_code", required = true) String sheng_code,
                              @RequestParam(value = "ispage", required = false) Integer ispage) throws Exception {
        PageInfo<HpTable> pageInfo = null;
        HpTable hpTable = new HpTable();
        hpTable.setSheng_code(sheng_code);
        hpTable.setIspage(ispage);
        hpTable.setIs_diaolong(0);


        List<HpAreaZip> areaZipList = (List<HpAreaZip>) HpApplicationRunnerImpl.contextMap.get("areaZip");
        List<HpAreaZip> collect = areaZipList.stream().filter(e -> "2".equals(e.getGrade().toString())).collect(Collectors.toList());
        pageInfo = hpTableService.queryPageList(page, hpTable);
        pageInfo.getList().forEach(e -> {
            collect.forEach(l -> {
                if (l.getCode().equals(e.getSheng_code())) {
                    e.setSheng_name(l.getName());
                }
            });
        });
        return ResultUtil.success(pageInfo);
    }

    @ApiOperation(value = "修改保存区划病案附页信息/修改启停状态")
    @PostMapping("/upEableType")
    public ResultUtil upEableType(@RequestParam(value = "sheng_code", required = true) String sheng_code,
                                  @RequestParam(value = "id", required = true) String id,
                                  @RequestParam(value = "type", required = true) Integer type) throws Exception {
        /**
         * sheng_code  =
         * ispage =1
         * is_diaolong =0
         * is_enable = 1
         */
        if (0 == type) { //要停用附页表的时候
            Integer num = hpTableService.judgeEable(sheng_code);
            if (num <= 1)
                return ResultUtil.error("警告:至少需要保留一条省附页信息");
        }
        hpTableService.upEableType(id, type);
        return ResultUtil.success("操作成功");
    }


    @ApiOperation(value = "修改保存区划病案附页信息/修改启停状态")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HpTable hpTable) throws Exception {
        if (StringUtil.isEmpty(hpTable.getId())) {
            Integer insert = hpTableService.insert(hpTable);
        } else {

            Integer update = hpTableService.update(hpTable);
        }
        return ResultUtil.success("操作成功");
    }


    @ApiOperation(value = "删除区划病案附页信息")
    @DeleteMapping("/deleteById")
    public ResultUtil deleteById(@RequestParam(value = "id", required = true) String id) throws Exception {
        hpTableService.deleteById(id);
        return ResultUtil.success("操作成功");
    }


    @ApiOperation(value = "查询表名称,在全字段设置中配置表名称下拉框使用")
    @GetMapping("/findTablename")
    public ResultUtil findtablename() throws Exception {
        List<Map<String, String>> list = hpTableService.findtablename();
        return ResultUtil.success(list);
    }


}
