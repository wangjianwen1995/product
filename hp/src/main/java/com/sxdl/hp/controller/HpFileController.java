package com.sxdl.hp.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.HpDataCancel;
import com.sxdl.hp.entity.HpMidTableEntity;
import com.sxdl.hp.service.HpDataCancelService;
import com.sxdl.hp.service.HpFileService;
import com.sxdl.hp.service.HpVsch0AService;
import com.sxdl.hp.service.HpVsch0BService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "病案归档")
@RestController
@RequestMapping("/hp_mid")
public class HpFileController {

    @Autowired
    HpFileService hpFileService;
    @Autowired
    HpVsch0AService hpVsch0AService;
    @Autowired
    HpDataCancelService hpDataCancelService;
    @Autowired
    HpVsch0BService hpVsch0BService;

    /**
     * 病案管理查询列表功能
     *
     * @param pageInfo 分页
     * @param strTime  开始时间
     * @param endTime  结束时间
     * @param blh      病历号
     * @param status   状态,0,未归档;1,已归档;2,已录入;3,待审核;4,已审核;5,已废弃
     * @param kscode   科室code
     * @return 列表
     * @return
     */
    @ApiOperation(value = "查询", notes = "查询时间段或者是固定住院号的患者")
    @GetMapping("/findAll")
    public ResultUtil findAll(PageInfo pageInfo, String strTime, String endTime, String blh, Integer status, String kscode) throws Exception {
        if (StrUtil.isNotEmpty(blh.trim()) && 99 == status) {//有病历号就查全部状态的数据
            pageInfo = hpFileService.findAll(pageInfo, null, null, blh, 99, null);
            return ResultUtil.success(pageInfo);
        } else if (StrUtil.isEmpty(strTime) || StrUtil.isEmpty(endTime)) {//没病历号时候时间字段是必填的
            return ResultUtil.error("时间段查询参数是必填项!");
        }
        if (10 == endTime.length()) {
            endTime += " 23:59:59";
        }
        pageInfo = hpFileService.findAll(pageInfo, strTime, endTime, blh, status, kscode);
        return ResultUtil.success(pageInfo);
    }

    @ApiOperation(value = "归档", notes = "归档操作，保存到中间库里")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody HpMidTableEntity midTable, HttpServletRequest request) throws Exception {
        if (midTable == null) {
            return ResultUtil.error("没有数据要保存!");
        }
        if (StringUtil.isEmpty(midTable.getId())) {
            String bah = midTable.getBah();
            String year = midTable.getYear() + "";
            ResultUtil<Object> error = hpFileService.getTakUpResult(bah, year, "mid");
            if (error != null) {
                return error;
            }
            if (hpFileService.ifExistData(midTable)) {
                return ResultUtil.error("数据已经重复,请联系管理员!");
            }
            SysUser user = (SysUser) StpUtil.getSession().get("user");
            String username = "";
            if (null != user) {
                username = user.getName();
            }
            midTable.setFileman(username);
            Map map = new HashMap();
            boolean b = hpFileService.hasLinking(midTable.getBah());
            if (b) {
                midTable.setStatus(2);
                map.put("status", 2);
            } else {
                midTable.setStatus(1);
                map.put("status", 1);
            }
            String id = hpFileService.insertobj(midTable);
            map.put("id", id);
            if (b) {
                String aid = hpVsch0AService.findAIDByBah(midTable.getBah());
                if (StrUtil.isNotEmpty(aid)) {
                    map.put("id", aid);
                } else {
                    return ResultUtil.error("正式数据异常");
                }
            }


            return ResultUtil.success(map, "归档成功");
        }
        return ResultUtil.error("数据异常");
    }

    @ApiOperation(value = "批量归档", notes = "批量归档操作")
    @PostMapping("/saveSome")
    public ResultUtil saveSome(@RequestBody List<HpMidTableEntity> HpMidTables, HttpServletRequest request) throws Exception {
        SysUser user = (SysUser) StpUtil.getSession().get("user");
        String username = "";
        if (null != user) {
            username = user.getName();
        }
        if (HpMidTables.size() > 0) {
            String bah, year;
            ResultUtil<Object> error;
            for (HpMidTableEntity midTable : HpMidTables) {
                bah = midTable.getBah();
                year = midTable.getYear() + "";
                error = hpFileService.getTakUpResult(bah, year, "mid");//缓存中有数据,过滤重复提交
                if (error != null) {
                    return error;
                }
                if (hpFileService.ifExistData(midTable)) {//数据库中有数据,重复数据
                    continue;
                }
                if (StrUtil.isEmpty(midTable.getId())) {
                    midTable.setFileman(username);
                    midTable.setStatus(1);
                    hpFileService.insertobj(midTable);
                }
            }
        }
        return ResultUtil.success("操作成功！");
    }

    @ApiOperation(value = "取消归档", notes = "取消归档")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id", required = true) String id) throws Exception {
        hpFileService.deleteById(id);
        return ResultUtil.success("取消成功");
    }

    /**
     * 慧慧写的
     * 排除上报操作,将状态改成5,同时记录作废原因
     *
     * @param entity
     * @return
     */
    @ApiOperation(value = "作废", notes = "作废操作")
    @GetMapping("/cancel")
    public ResultUtil cancel(HpDataCancel entity, HttpServletRequest request) throws Exception {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if (null != user) {
            entity.setUser_id(user.getId());
            entity.setUser_name(user.getName());
        }
        entity.setTime(DateUtil.formatFromDate2(new Date()));
        entity.setType("5");
        hpDataCancelService.insertSelective(entity);
        hpVsch0AService.changeStatus(entity.getHp_aid(), "5");
        return ResultUtil.success("作废成功！");
    }

    /**
     * 张慧写的
     * 重启操作,将状态从5改成3,同时记录重启原因
     *
     * @param entity
     * @return
     */
    @ApiOperation(value = "重启", notes = "重启操作")
    @GetMapping("/restart")
    public ResultUtil restart(HpDataCancel entity, HttpServletRequest request) throws Exception {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if (null != user) {
            entity.setUser_id(user.getId());
            entity.setUser_name(user.getName());
        }
        entity.setTime(DateUtil.formatFromDate2(new Date()));
        entity.setType("2");
        hpDataCancelService.insertSelective(entity);
        hpVsch0AService.changeStatus(entity.getHp_aid(), "2");
        return ResultUtil.success("重启成功！");
    }

    /**
     * 查询超期归档人数列表
     *
     * @param ksid    科室id
     * @param start   开始时间
     * @param end     结束时间
     * @param p       分页信息
     * @param fileday 归档天数
     * @return 结果
     */
    @GetMapping("/findlist")
    public ResultUtil findList(String ksid, String start, String end, PageInfo p, String fileday) throws Exception {
        return ResultUtil.success(hpFileService.findlist(ksid, start, end, p, fileday));
    }

    /**
     * 查询归档率分科报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     */
    @GetMapping("findPreviewByks")
    public ResultUtil findPreviewByks(String ksid, String start, String end) throws Exception {
        return ResultUtil.success(hpFileService.findBeyondDeadlineByKs(ksid, start, end));
    }

    /**
     * 下载归档率报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    @GetMapping("downKS")
    public void downKS(String ksid, String start, String end, HttpServletResponse response) throws Exception {
        hpFileService.downKS(ksid, start, end, response);
    }

    /**
     * 查询超期归档人数报表预览
     *
     * @param ksid    科室id
     * @param start   开始时间
     * @param end     结束时间
     * @param fileday 归档天数
     */
    @GetMapping("findPreview")
    public ResultUtil findPreview(String ksid, String start, String end, String fileday) throws Exception {
        return ResultUtil.success(hpFileService.findBeyondDeadline(ksid, start, end, fileday));
    }

    /**
     * 下载超期归档人数报表
     *
     * @param ksid    科室id
     * @param start   开始时间
     * @param end     结束时间
     * @param fileday 归档天数
     * @return
     */
    @GetMapping("down")
    public void down(String ksid, String start, String end, String fileday, HttpServletResponse response) throws Exception {
        hpFileService.down(ksid, start, end, fileday, response);
    }

    /**
     * 查询工作量总计报表
     *
     * @param kscode 科室
     * @param start  开始时间
     * @param end    结束时间
     * @return
     */
    @GetMapping("findGzlList")
    public ResultUtil findGzlList(String kscode, String start, String end) throws Exception {
        return ResultUtil.success(hpFileService.findGzlList(kscode, start, end));
    }

    @GetMapping("downGzllist")
    public void downGzllist(String kscode, String start, String end, HttpServletResponse response) throws Exception {
        hpFileService.downGzllist(kscode, start, end, response);
    }

    /**
     * 查询工作量明细数据
     *
     * @param p        分页
     * @param fileName 归档人
     * @param kscode   病人科室code
     * @param start    开始时间
     * @param end      结束时间
     */
    @GetMapping("findGzlmxList")
    public ResultUtil findGzlmxList(PageInfo p, String fileName, String kscode, String start, String end) throws Exception {
        return ResultUtil.success(hpFileService.findGzlmxList(p, fileName, kscode, start, end));
    }

    @GetMapping("downGzlmxList")
    public void downGzlmxList(String fileName, String kscode, String start, String end, HttpServletResponse response) throws Exception {
        hpFileService.downGzlmxList(fileName, kscode, start, end, response);
    }

    /**
     * 当数据保存后,更新费用相关信息
     */
    @GetMapping("updateFare")
    public ResultUtil updateFare(String start,String end,  String bah) throws Exception {
        return hpVsch0BService.updateHpFareInfo(start,end, bah);
    }
}