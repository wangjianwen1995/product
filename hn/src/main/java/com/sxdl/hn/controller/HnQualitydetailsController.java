package com.sxdl.hn.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.TreeUtils;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.entity.HnQualityTemplate;
import com.sxdl.hn.entity.HnQualitydetails;
import com.sxdl.hn.service.HnQualityTemplateService;
import com.sxdl.hn.service.HnQualitydetailsService;
import com.sxdl.hn.util.HNApplicationRunnerImpl;
import com.sxdl.hn.util.MyListUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "护理质量考核细目")
@RestController
@RequestMapping("/details")
public class HnQualitydetailsController {


    @Autowired
    private HnQualitydetailsService hnQualitydetailsService;

    @Autowired
    private HnHandleDao hnHandleDao;

    @Autowired
    private HnQualityTemplateService templateService;
    //private List<HnQualitydetails>  maplist = HNApplicationRunnerImpl.detailsMap.get("details");


    @ApiOperation(value = "设置查询亚目下对应细目")
    @PostMapping("/findAllDetails")
    public ResultUtil findAllDetails(@RequestParam(value = "suborder_id",required = true) Integer suborder_id) {
        List<HnQualitydetails> tree = new ArrayList<>();
        try {

            List<HnQualitydetails> list = MyListUtil.deepCopy(HNApplicationRunnerImpl.detailsMap.get(suborder_id));
            //根据亚目id过滤需要的细目 、并且按照code升序排序
            List<HnQualitydetails>  details = list.stream().sorted(Comparator.comparing(HnQualitydetails::getCode)).
                                              collect(Collectors.toList());
            //函数式编程处理tree数据
            tree = TreeUtils.tree(details, HnQualitydetails::getId,
                                                        HnQualitydetails::getPid,
                                                        HnQualitydetails::getChildren,
                                                        HnQualitydetails::setChildren, null);
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(tree);
    }


    @ApiOperation(value = "模板查询亚目下对应细目")
    @PostMapping("/templateFindAllDetails")
    public ResultUtil templateFindAllDetails(@RequestParam(value = "suborder_id",required = true) Integer suborder_id) {
        List<HnQualitydetails> tree = new ArrayList<>();

        try {
            //缓存中获取细目
            List<HnQualitydetails> list = MyListUtil.deepCopy(HNApplicationRunnerImpl.detailsMap.get(suborder_id));
            //根据亚目id过滤需要的细目 、并且按照code升序排序
            List<HnQualitydetails>  details = list.stream().
                    filter(e->e.getState()==1).sorted(Comparator.comparing(HnQualitydetails::getCode)).collect(Collectors.toList());
            //函数式编程处理tree数据
            tree = TreeUtils.tree(details, HnQualitydetails::getId,
                    HnQualitydetails::getPid,
                    HnQualitydetails::getChildren,
                    HnQualitydetails::setChildren, null);
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(tree);
    }



    @ApiOperation(value = "新增修改 考核细目")
    @PostMapping("/saveDetails")
    public ResultUtil saveDetails(@RequestBody HnQualitydetails hnQualitydetails ) {
        try {
            /**
             * 每次新增数据，数据直接保存到数据库中，同时更新缓存中的数据（不走数据库）
             */

            if(StringUtils.isEmpty(hnQualitydetails.getId())){ //新增功能
                //数据直接追加
                Integer insert = hnQualitydetailsService.insertCache(hnQualitydetails);
            }else{//修改功能
                //查看模板缓存中是否存在 将要删除的细目标准

                List<HnQualityTemplate> templates = hnHandleDao.findsuborderTemplate(hnQualitydetails.getSuborder_id());
                boolean falg= true;
                for (HnQualityTemplate template : templates) {
                    if(Arrays.asList(template.getDetails_ids().split(",")).contains(hnQualitydetails.getId().toString())){
                        falg =false;
                        break;
                    }
                }
                // 判断模板是否存在数据 有不允许修改
                if(falg){
                    //修改处理缓存
                    Integer update = hnQualitydetailsService.updateCache(hnQualitydetails);
                }else{
                    return  ResultUtil.error("操作失败， 有模板正在使用该标准");
                }
            }
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("保存成功");
    }



    @ApiOperation(value = "删除考核细目")
    @GetMapping("/delDetails")
    public ResultUtil delDetails(@RequestParam(value = "id",required = true) Integer id,
                                 @RequestParam(value = "suborder_id",required = true) Integer suborder_id){
        try {
            /**
             * 删除时
             *      1 前端判断是否有子项目 有不允许删除
             *      2 判断模板是否存在数据 有不允许删除
             *
             */
            List<HnQualityTemplate> templates = hnHandleDao.findsuborderTemplate(suborder_id);
            boolean falg= true;
            for (HnQualityTemplate template : templates) {
                if(Arrays.asList(template.getDetails_ids().split(",")).contains(id.toString())){
                    falg =false;
                    break;
                }

            }
            if(falg){
                hnQualitydetailsService.delCache(id,suborder_id);
            }else{
                return  ResultUtil.error("操作失败， 有模板正在使用该标准");
            }
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("删除成功");
    }












}
