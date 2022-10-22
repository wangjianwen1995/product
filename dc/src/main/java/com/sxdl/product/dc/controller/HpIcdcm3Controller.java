package com.sxdl.product.dc.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.entity.SysLog;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.service.SysLogService;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.HpIcdcm3;
import com.sxdl.product.dc.service.HpIcdcm3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("iccm3")
public class HpIcdcm3Controller {

    @Autowired
    HpIcdcm3Service hpIcdcm3Service;
    @Autowired
    SysLogService sysLogService;
    @Autowired
    SysDictValService sysDictValService;

    /**
     * 初始化数据
     *
     * @param bz     标准id
     * @param bzname 标准名称
     * @return 结果
     */
    @GetMapping("initData")
    public ResultUtil initData(String bz, String bzname) throws Exception {
        if (StrUtil.isEmpty(bz) || StrUtil.isEmpty(bzname)) {
            return ResultUtil.error("参数不能为空!");
        }
        if (!hpIcdcm3Service.checkHasData(bz, bzname)) {
            return ResultUtil.success("该标准已经有数据,无需初始化!");
        } else {
            hpIcdcm3Service.initData(bz, bzname);
            return ResultUtil.success("初始化成功!");
        }
    }

    /**
     * 查询手术编码版本信息
     *
     * @param name 名称编码
     * @param ssdj 级别
     * @param lb   类别
     * @param wc   是否微创
     * @param rj   是否日间
     * @param p    分页信息
     * @return 结果
     */
    @GetMapping("findIccm")
    public ResultUtil findIccm(String name, String ssdj, String lb, String wc, String rj, PageInfo p) throws Exception {
        PageInfo iccm = hpIcdcm3Service.findIccm(name, ssdj, lb, wc, rj, p);
        return ResultUtil.success(iccm);
    }

    /**
     * 查询手术执行标准字典数据
     *
     * @return 结果
     */
    @GetMapping("findBz")
    public ResultUtil findBz() throws Exception {
        return ResultUtil.success(hpIcdcm3Service.findBZDicts());
    }

    /**
     * 新增手术执行标准字典数据
     *
     * @return 结果
     */
    @GetMapping("insertBz")
    public ResultUtil insertBz(SysDictVal val) throws Exception {
        if (null == val.getId()) {
            sysDictValService.insertDV(val);
        } else {
            sysDictValService.updateByPrimaryKeySelective(val);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 修改手术信息
     *
     * @param icdcm3
     * @return
     */
    @PostMapping("updateIccm")
    public ResultUtil updateIccm(@RequestBody HpIcdcm3 icdcm3, HttpServletRequest request) throws Exception {
        long start = System.currentTimeMillis(), end;
        String oldssdj = icdcm3.getOldssdj(), oldrj = icdcm3.getOldrj(), oldwc = icdcm3.getOldwc();
        //可修改项都没有修改,直接返回
        if (oldssdj.equals(icdcm3.getSsdj()) && oldrj.equals(icdcm3.getIsrj()) && oldwc.equals(icdcm3.getIswc())) {
            return ResultUtil.success("保存成功!");
        }
        icdcm3.setModify_time(DateUtil.date());
        hpIcdcm3Service.update(icdcm3);
        SysLog log = new SysLog();
        log.setLevel("WARING");
        log.setOperator("updateICCM3");
        end = System.currentTimeMillis();
        log.setTime(end + "");
        log.setUse_time("耗时:" + (end - start) / 1000.0 + "秒");
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if (null == user) {
            user = new SysUser();
            user.setId(1);
            user.setName("admin");
        }
        log.setUser_id(user.getId());
        log.setName(user.getName());
        log.setContent("国临3.0手术名称为: " + icdcm3.getLc3_0mc() + ",手术编码为: " + icdcm3.getLc3_0dm() + " 的原有信息为:手术等级=" + oldssdj + ",是否微创=" + oldwc + ",是否日间=" + oldrj + ";修改为手术等级=" + icdcm3.getSsdj() + ",是否微创=" + icdcm3.getIswc() + ",是否日间=" + icdcm3.getIsrj());
        sysLogService.insert(log);
        return ResultUtil.success("保存成功!");
    }
}
