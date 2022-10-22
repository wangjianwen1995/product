package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.entity.DcTarget;
import com.sxdl.product.dc.service.DcTargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "指标知识库")
@RestController
@RequestMapping("/target")
public class DcTargetController {

    @Autowired
    private DcTargetService dcTargetService;

    /**
     * 查询所有指标信息
     * @param pageInfo
     * @param name 指标名称
     * @return
     */
    @ApiOperation(value = "根据name查询", notes = "根据指标名称模糊查询")
    @GetMapping("/findByName")
    public ResultUtil<PageInfo<DcTarget>> findByName(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
//            DcTarget target = new DcTarget();
//            if(StringUtil.isEmpty(name)) target.setTargetname(name);
//            PageInfo<DcTarget> list = dcTargetService.queryPageListOrderBy(pageInfo, target,"ordernum","asc");
            pageInfo = dcTargetService.likeFind(pageInfo, name);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    /**
     * 查询分类信息
     * @param name
     * @return
     */
    @ApiOperation(value = "根据name查询分类信息", notes = "根据名称模糊查询分类信息")
    @GetMapping("/findType")
    public ResultUtil<List<DcTarget>> findType( @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            List<DcTarget> tree = new ArrayList<>();

            DcTarget target = new DcTarget();
            if(!"".equals(name)) target.setTargetname(name);
            target.setIstype("1");
            List<DcTarget> list = dcTargetService.select(target);
            List<DcTarget> collect = list.stream().filter(e -> StringUtil.isEmpty(e.getParentid()) ).collect(Collectors.toList());
            for (DcTarget c:collect) { //遍历根节点，获取子节点
                c.setChildren(findChildren(c,list));
                tree.add(c);
            }


            return ResultUtil.success(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //删除指标信息
    @ApiOperation(value = "删除", notes = "删除指标信息")
    @DeleteMapping("/delete")
    public ResultUtil<DcTarget> delete( String id) {

        try {
            dcTargetService.deleteById(id);
            return ResultUtil.success("删除指标信息");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增", notes = "添加指标信息")
    @PostMapping("/insert")
    public ResultUtil<DcTarget> insertHospital(@RequestBody DcTarget target) {
        try {
            if("".equals(target.getId()) || target.getId()==null){
                dcTargetService.insert(target);
            }else{
                dcTargetService.update(target);
            }

            return ResultUtil.success("保存成功！");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    public List<DcTarget> findChildren(DcTarget c,List<DcTarget> list){

        List<DcTarget>  nodes= new ArrayList<>();
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
