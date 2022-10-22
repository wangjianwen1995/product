package com.sxdl.product.dc.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.entity.DcKnowledgeType;
import com.sxdl.product.dc.service.DcKnowledgeTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "文件分类")
@RestController
@RequestMapping("/knowtype")
public class DcKnowledgeTypeController {

    @Autowired
    private DcKnowledgeTypeService dcKnowledgeTypeService;

    @ApiOperation(value = "根据name查询", notes = "根据名称模糊查询")
    @GetMapping("/findByName")
    public ResultUtil findByName(@RequestParam(value = "name", defaultValue = "") String name) {
        try {
            List<DcKnowledgeType> tree = new ArrayList<>();
            DcKnowledgeType type = new DcKnowledgeType();
            if(!StringUtil.isEmpty(name)){
                type.setName(name);
            }


            List<DcKnowledgeType> select = dcKnowledgeTypeService.select(type);
            List<DcKnowledgeType> collect = select.stream().filter(e -> StringUtil.isEmpty(e.getParentid()) ).collect(Collectors.toList());
            for (DcKnowledgeType c:collect) { //遍历根节点，获取子节点
                c.setChildren(findChildren(c,select));
                tree.add(c);
            }
            return ResultUtil.success(tree);

        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }



    //删除分类信息
    @ApiOperation(value = "删除", notes = "删除分类信息")
    @DeleteMapping("/delete")
    public ResultUtil<DcKnowledgeType> delete(String id) {

        try {
            DcKnowledgeType newtype = new DcKnowledgeType();
            newtype.setParentid(id);
            List<DcKnowledgeType> select = dcKnowledgeTypeService.select(newtype);
            if(select.size()>0) return ResultUtil.error("该项下有子节点，不允许删除！");

            dcKnowledgeTypeService.deleteById(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增/修改", notes = "添加/修改分类信息")
    @PostMapping("/insert")
    public ResultUtil<DcKnowledgeType> insertHospital(@RequestBody DcKnowledgeType know) {
        try {
            if("".equals(know.getId()) || know.getId()==null){

                dcKnowledgeTypeService.insert(know);
            }else{
                dcKnowledgeTypeService.update(know);
            }

            return ResultUtil.success("保存成功！");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }



    public List<DcKnowledgeType> findChildren(DcKnowledgeType c,List<DcKnowledgeType> list){

        List<DcKnowledgeType>  nodes= new ArrayList<>();
        for(int i = 0;i < list.size();i++){
            //这里可以使用Iterator
            if(list.get(i).getParentid().equals(c.getId())) {
                list.get(i).setChildren(findChildren(list.get(i),list));
                nodes.add(list.get(i));
            };
        }


        return nodes;
    }





}
