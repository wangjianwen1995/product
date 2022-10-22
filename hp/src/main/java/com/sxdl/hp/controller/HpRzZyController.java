package com.sxdl.hp.controller;


import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.HpZyrzEntity;
import com.sxdl.hp.entity.HpZyrzMxEntity;
import com.sxdl.hp.service.HpZyrzMxService;
import com.sxdl.hp.service.HpRzZyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "住院日志")
@RestController
@RequestMapping("/zyrz")
public class HpRzZyController {
    @Autowired
    HpRzZyService hpRzZyService;
    @Autowired
    HpZyrzMxService hpZyrzMxService;

    /**
     * 查询病案日志列表
     */
    @ApiOperation(value = "条件查询")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(String sdate, String edate) throws Exception {
        ResultUtil result = hpRzZyService.checkPreOption(sdate, false);
        if (null != result) {
            return result;
        }
        List<HpZyrzEntity> zyrzEntityList = hpRzZyService.selectByTjrq(sdate, edate);
        result = hpRzZyService.checkIsAuto();
        int isauto = 0;
        if (null == zyrzEntityList || zyrzEntityList.size() <= 0) {
            if (StringUtil.isNotEmpty(sdate)) {
                if (null == result) {
                    isauto = 1;
                    HpZyrzEntity hpZyrzEntity = new HpZyrzEntity();
                    hpZyrzEntity.setTjrq(sdate);
                    zyrzEntityList = hpRzZyService.insertSomeByMaxTjrq(sdate);
                    zyrzEntityList = zyrzEntityList.stream().sorted(Comparator.comparing(HpZyrzEntity::getTjkb).reversed()).
                            collect(Collectors.toList());
                } else {
                    return result;
                }
            }
        }
        Map map = new HashMap();
        map.put("list", zyrzEntityList);
        map.put("isauto", isauto);
        return ResultUtil.success(map, "查询成功");
    }

    /**
     * 查询病案与日志对比差额明细列表
     *
     * @param flag  标志,dbrs ;cyrs
     * @param stjrq 开始
     * @param etjrq 结束
     * @param tjks  科室code
     * @return
     */
    @ApiOperation(value = "查询明细数据")
    @GetMapping("/findByTjrqAndTjkb")
    public ResultUtil findByTjrqAndTjkb(String flag, String stjrq, String etjrq, String tjks) throws Exception {
        List<Map<String, Object>> entityList = hpRzZyService.selectByTjrqAndTjkb(flag, stjrq, etjrq, tjks);
        return ResultUtil.success(entityList, "查询成功");
    }

    @ApiOperation(value = "更新")
    @PostMapping("/updateAll")
    public ResultUtil updateAll(@RequestBody List<HpZyrzEntity> list) throws Exception {
        if (CollUtil.isEmpty(list)) {
            return ResultUtil.error("保存的内容不能为空");
        }
        ResultUtil result = hpRzZyService.updateByTjrqAndTjkb(list);
        if (null != result) {
            return result;
        }
        return ResultUtil.success("修改成功");
    }

    @ApiOperation(value = "调整开放床位数")
    @PostMapping("/updateKsCw")
    public ResultUtil updateKsCw(@RequestBody Map<String, String> ksBed) throws Exception {
        if (null == ksBed || ksBed.size() < 0) {
            return ResultUtil.success("无数据需要修改");
        }
        String sdate = ksBed.get("sdate");
        ResultUtil result = hpRzZyService.checkPreOption(sdate, false);
        if (null != result) {
            return result;
        }
        String edate = ksBed.get("edate");
        result = hpRzZyService.checkPreOption(edate, false);
        if (null != result) {
            return result;
        }
        String sql = "update hp_zyrz set sjkfcws=" + ksBed.get("bed") + " where tjkb='" + ksBed.get("ks") + "' and tjrq between '" + sdate + "' and '" + edate + "'";
        hpRzZyService.updateSqlWithSQL(sql);
        return ResultUtil.success("修改成功");
    }

    @ApiOperation(value = "是否能够初始化原有人数")
    @PostMapping("/testCanUpdate")
    public ResultUtil testCanUpdate(String sdate) throws Exception {
        ResultUtil result = hpRzZyService.checkPreOption(sdate, true);
        if (null != result) {
            return result;
        }
        //先查那天是否有数据
        List<HpZyrzEntity> hpZyrzEntities = hpRzZyService.selectByTjrq(sdate, sdate);
        if (CollUtil.isEmpty(hpZyrzEntities)) {
            //没有的话,初始化一下数据
            hpZyrzEntities = hpRzZyService.insertSomeByMaxTjrq(sdate);
        }
        return ResultUtil.success(hpZyrzEntities, "可以修改");
    }

    @ApiOperation(value = "查看报表")
    @GetMapping("/findForms")
    public ResultUtil findForms(String sdate, String edate, String tjkb) throws Exception {
        Map<String, Object> zyrzEntityList = hpRzZyService.selectFormsByTjrq(sdate, edate, tjkb);
        return ResultUtil.success(zyrzEntityList, "查询成功");
    }

    @ApiOperation(value = "导出报表")
    @GetMapping("/down")
    public void down(String sdate, String edate, String tjkb, HttpServletResponse response) throws Exception {
        hpRzZyService.down(sdate, edate, tjkb, response);
    }

    @ApiOperation(value = "新增日志明细数据")
    @PostMapping("/insertOrUpdateMxData")
    @ResponseBody
    public ResultUtil insertOrUpdateMxData(@RequestBody HpZyrzMxEntity hpZyrzMxEntity) throws Exception {
        hpZyrzMxEntity.setLrsj(DateUtil.formatFromDate2(new Date()));
        if (null == hpZyrzMxEntity.getId()) {
            hpZyrzMxService.insert(hpZyrzMxEntity);
        } else {
            hpZyrzMxService.updateSelective(hpZyrzMxEntity);
        }
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "新增日志明细数据")
    @DeleteMapping("/delMxData")
    @ResponseBody
    public ResultUtil delMxData(String id) throws Exception {
        hpZyrzMxService.deleteById(id);
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "查询明细")
    @GetMapping("/findBySome")
    @ResponseBody
    public ResultUtil findBySome(PageInfo pageInfo,
                                 @RequestParam(value = "type", defaultValue = "") String type,
                                 @RequestParam(value = "startTime", defaultValue = "") String startTime,
                                 @RequestParam(value = "endTime", defaultValue = "") String endTime,
                                 @RequestParam(value = "bah", defaultValue = "") String bah,
                                 @RequestParam(value = "tjks", defaultValue = "") String tjks
    ) throws Exception {
        pageInfo = hpZyrzMxService.selectBySome(pageInfo, type, startTime, endTime, bah, tjks);
        return ResultUtil.success(pageInfo, "操作成功");
    }
}
