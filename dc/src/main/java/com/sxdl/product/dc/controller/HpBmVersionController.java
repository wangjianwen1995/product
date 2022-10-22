package com.sxdl.product.dc.controller;


import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.HospiatlInfo;
import com.sxdl.product.dc.entity.HpBmVersion;
import com.sxdl.product.dc.service.HpBmVersionService;
import com.sxdl.product.dc.service.HpBzdmkService;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "编码版本")
@RestController
@RequestMapping("/bmversion")
public class HpBmVersionController {


    @Autowired
    HpBmVersionService hpBmVersionService;
    PageInfo queryPageList;
    @Autowired
    HpBzdmkService bzdmkService;

    @Autowired
    HandleDao handleDao;

    @ApiOperation(value = "根据状态查询编码版本")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(PageInfo pageInfo, String type, String status) throws Exception {
        HpBmVersion hpBmVersion = new HpBmVersion();
        HospiatlInfo hpHospiatlInfo = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        hpBmVersion.setHid(hpHospiatlInfo.getId());
        if (!"".equals(type)) {
            hpBmVersion.setType(type);
        }
        if (!"".equals(status)) {
            hpBmVersion.setIson(status);
        }
        queryPageList = hpBmVersionService.queryPageList(pageInfo, hpBmVersion);
        return ResultUtil.success(queryPageList);
    }

    @ApiOperation(value = "切换编码版本")
    @GetMapping("/save")
    public ResultUtil save(HpBmVersion hpBmVersion, HttpServletRequest request) throws Exception {
        //从缓存中取用户信息，下一步查询该用户所在医院信息
        HospiatlInfo hpHospiatlInfo = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        hpBmVersion.setHid(hpHospiatlInfo.getId());
        String id = hpBmVersion.getId();
        if (null == id || id.equals("")) {
            hpBmVersionService.updateVersion(hpBmVersion);
        }
        hpBmVersionService.update(hpBmVersion);
        Map<String, String> bmversions=hpHospiatlInfo.getBmVersion();
        if(CollUtil.isEmpty(bmversions)){
            bmversions=new HashMap<>();
            hpHospiatlInfo.setBmVersion(bmversions);
        }
        bmversions.put(hpBmVersion.getType(), hpBmVersion.getVersion());
        DcApplicationRunnerImpl.contextMap.put("hpHospiatlInfo", hpHospiatlInfo);
        //将标准代码库插入到永久临时表中
        bzdmkService.initBiaozuns();
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "删除编码版本")
    @GetMapping("/delete")
    public ResultUtil delete(HpBmVersion hpBmVersion) throws Exception {
        hpBmVersionService.delete(hpBmVersion);
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "查找版本字典")
    @GetMapping("/findZd")
    public ResultUtil findZd() throws Exception {
        //查询首页的所有字段库信息
        Map<Integer, List<SysDictVal>> baBmMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        return ResultUtil.success(baBmMap);
    }

    @ApiOperation(value = "查找字典88编码版本")
    @GetMapping("/find88")
    public ResultUtil find88() throws Exception {
        String sql="select c.*,d.remark from \n" +
                "(select a.id,a.type,b.name,a.version_name,a.stime,a.etime  from hp_bm_version a\n" +
                "left join dc_sys_dict_val b on a.type=b.val and dict_id=88 where  a.ison=1  )c\n" +
                "left join dc_sys_dict_val d on c.version_name=d.name and dict_id=89 order by type";
        List<Map<String, Object>> maps = handleDao.selectSqlWithSQL(sql);
        return ResultUtil.success(maps);
    }


}
