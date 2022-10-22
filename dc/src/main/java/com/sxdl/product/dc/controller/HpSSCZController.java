package com.sxdl.product.dc.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.entity.HpSSCZ;
import com.sxdl.product.dc.service.HpSSCZService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "手术操作信息")
@RestController
@RequestMapping("/sscz")
public class HpSSCZController {
    @Autowired
    HpSSCZService hpSSCZService;

    @ApiOperation(value = "查询手术等级信息")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(PageInfo pageInfo, String name, String ssdj) throws Exception {
        HpSSCZ hpSSCZ = new HpSSCZ();
        String sql = " select *  from hp_2sscz where 1=1";
        if (null != name && !name.trim().equals("")) {
            sql += " and  ssmc like '%" + name + "%'  ";
        }
        if (StringUtil.isNotEmpty(ssdj.trim())) {
            sql += " and  ssjb='" + ssdj + "'";
        }
        sql += "order by ssjb desc";
        List<Map<String, Object>> maps = hpSSCZService.selectSqlWithSQL(sql);
        if (null == maps || maps.size() <= 0) {
            return ResultUtil.success(null);
        }
        if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
            return ResultUtil.success(maps);
        }

        Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), maps);
        return ResultUtil.success(listPage);
    }


    @ApiOperation(value = "修改手术等级信息")
    @PostMapping("/update")
    public ResultUtil update(@RequestBody HpSSCZ hpSSCZ) throws Exception {
        hpSSCZService.updateSelective(hpSSCZ);
        return ResultUtil.success("修改成功");
    }
}
