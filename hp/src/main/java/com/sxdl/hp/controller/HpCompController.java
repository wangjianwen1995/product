package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpComp;
import com.sxdl.hp.service.HpCompService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "并发症")
@RestController
@RequestMapping("/bfz")
public class HpCompController {


    @Autowired
    HpCompService hpCompService;


    @ApiOperation(value = "下拉框")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition() throws Exception {
//            HpComp hpComp = new HpComp();
//            hpComp.setStatus("1");
//            List<HpComp> pathwayList = hpCompService.select(hpComp);
//            List<Map> list=new ArrayList<>();
//            Map<String, List<HpComp>> listMap = pathwayList.stream().collect(Collectors.groupingBy(e -> e.getKs_name()));
//            listMap.forEach((k,v)->{
//                Map map=new HashMap();
//                map.put("ks",k);
//                map.put("xl",v);
//                list.add(map);
//            });
        return ResultUtil.success(hpCompService.selectSelectsIfON());
    }

    @ApiOperation(value = "根据条件查询表内容")
    @GetMapping("/findByLikeSome")
    public ResultUtil findByLikeSome(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name,
                                     @RequestParam(value = "status", defaultValue = "2") String status) throws Exception {
        HpComp hpComp = new HpComp();
        hpComp.setName(name);
        hpComp.setStatus(status);

        List<HpComp> list = hpCompService.selectByLikeName(hpComp);
        if (!status.equals("2")) {
            list = list.stream().filter(e -> null != e && e.getStatus().equals(status)).collect(Collectors.toList());
        }
        if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
            return ResultUtil.success(list);
        }
        Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "新增或者修改保存")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HpComp hpComp) throws Exception {

           /* SysUser user = (SysUser) request.getSession().getAttribute("user");
            if (null != user) {
                HpComp.setUser_id(user.getId());
                HpComp.setUser_name(user.getName());
            }*/
        hpComp.setUpdate_time(DateUtil.formatFromDate2(new Date()));
        if (null == hpComp.getId() || "".equals(hpComp.getId())) {
            hpCompService.insertSelective(hpComp);
        } else {
            hpCompService.updateSelective(hpComp);
        }
        return ResultUtil.success("保存成功");
    }

}
