package com.sxdl.hp.controller;


import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpConditionGroup;
import com.sxdl.hp.service.HpConditionGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "条件组维护")
@RestController
@RequestMapping("/group")
public class HpConditionGroupController {

    @Autowired
    private HpConditionGroupService groupService;

//    @Autowired
//    private HpConditionTemplateService templateService;


    @ApiOperation(value = "查询所有条件组")
    @GetMapping("/findAllConditiongroup")
    public ResultUtil findAllConditiongroup(PageInfo pageInfo,
                                            @RequestParam(value = "user_id", required = true) Integer user_id,
                                            @RequestParam(value = "name", required = false) String name) throws Exception {
        Map<String, Object> listPage = null;
        List<HpConditionGroup> groupList = groupService.findIsEnable(user_id, name);
        listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), groupList);
        return ResultUtil.success(listPage);
    }


    @ApiOperation(value = "删除一个条件组:前端弹出是否删除")
    @DeleteMapping("/delConditiongroup")
    public ResultUtil delConditiongroup(@RequestParam(value = "id", required = true) String id) throws Exception {

//        HpConditionTemplate template = new HpConditionTemplate();
//        template.setGroup_id(id);
//        List<HpConditionTemplate> list = templateService.select(template);
//        if (list.size() > 0) {
//            return ResultUtil.error("有用户正在使用此条件组,不允许删除");
//        }
        groupService.deleteByIdAndChil(id);

        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "条件组保存修改")
    @PostMapping("/saveConditiongroup")
    public ResultUtil saveConditiongroup(@RequestBody HpConditionGroup hpConditionGroup) throws Exception {
        if (StrUtil.isEmpty(hpConditionGroup.getId())) {
             groupService.insert(hpConditionGroup);
        } else {
             groupService.update(hpConditionGroup);
        }
        return ResultUtil.success("操作成功");
    }


}
