package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpDataCancel;
import com.sxdl.hp.service.HpDataCancelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Api(tags = "启用弃用")
@RestController
@RequestMapping("/cancel")
public class HpDataCancelController {


    @Autowired
    HpDataCancelService hpDataCancelService;


    @ApiOperation(value = "根据条件查询表内容")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(PageInfo pageInfo, String type, String cysj, String time) throws Exception {
        HpDataCancel hpDataCancel = new HpDataCancel();
        if (null != type && "".equals(type)) {
            hpDataCancel.setType(type);
        }
        if (!"".equals(cysj)) {
            hpDataCancel.setHp_cysj(cysj);
        }
        if (!"".equals(time)) {
            hpDataCancel.setTime(time);
        }
        PageInfo queryPageList = hpDataCancelService.queryPageList(pageInfo, hpDataCancel);
        return ResultUtil.success(queryPageList);
    }

    @ApiOperation(value = "保存")
    @GetMapping("/save")
    public ResultUtil save(HpDataCancel hpDataCancel, HttpServletRequest request) throws Exception {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if (null != user) {
            hpDataCancel.setUser_id(user.getId());
            hpDataCancel.setUser_name(user.getName());
        }
        hpDataCancel.setTime(DateUtil.formatFromDate2(new Date()));
        hpDataCancelService.insertSelective(hpDataCancel);
        return ResultUtil.success("保存成功");
    }

}
