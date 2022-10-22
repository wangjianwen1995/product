package com.sxdl.hp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpRzJz;
import com.sxdl.hp.service.HpRzJzService;
import com.sxdl.hp.service.HpRzJzYyService;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//急诊日志
@RestController
@RequestMapping("/rzjz")
public class HpRzJzController {
    @Autowired
    HpRzJzService hpRzJzService;
    @Autowired
    HpRzJzYyService hpRzJzYyService;
    @Autowired
    SysDictValService sysDictValService;

    /**
     * 查询列表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @param p     分页信息
     * @return 结构
     */
    @GetMapping("/findlist")
    public ResultUtil findList(String ksid, String start, String end, PageInfo p) throws Exception {
        return ResultUtil.success(hpRzJzService.findlist(ksid, start, end, p));
    }

    /**
     * 查询单条
     *
     * @param id 急诊日志id
     */
    @GetMapping("/findOne")
    public ResultUtil findOne(String id) throws Exception {
        return ResultUtil.success(hpRzJzYyService.findByJZRZid(id));
    }

    /**
     * 查询报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    @GetMapping("/find")
    public ResultUtil find(String ksid, String start, String end) throws Exception {
        return ResultUtil.success(hpRzJzService.selectJZRZ(ksid, start, end));
    }

    /**
     * 下载报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    @GetMapping("down")
    public void down(String ksid, String start, String end, HttpServletResponse response) throws Exception {
        Map<String, Object> map = hpRzJzService.selectJZRZ(ksid, start, end);
        List<Map<String, Object>> jz = (List<Map<String, Object>>) map.get("jz");
        List<Map<String, Object>> yy = (List<Map<String, Object>>) map.get("yy");
        jz.add(new HashMap<>());

        ExcelWriter writer = ExcelUtil.getWriter(HpApplicationRunnerImpl.FILESPATH + "/execl/医院急诊报表.xsl");
        writer.addHeaderAlias("ks", "科室");
        writer.addHeaderAlias("jzrc", "急诊人次");
        writer.addHeaderAlias("lyrc", "离院人次(非死亡)");
        writer.addHeaderAlias("rgcsrc", "入观人次");
        writer.addHeaderAlias("ryrc", "入院人次");
        writer.addHeaderAlias("swrc", "死亡人次");
        writer.addHeaderAlias("cccs", "出车次数");
        writer.addHeaderAlias("急诊住院率", "急诊住院率");
        writer.addHeaderAlias("wzqjrc", "抢救人次");
        writer.addHeaderAlias("wzqjcgrc", "抢救成功人次");
        writer.addHeaderAlias("ynswrc", "院内死亡人次");
        writer.addHeaderAlias("yqswrc", "院前死亡人次");
        writer.addHeaderAlias("抢救成功率", "抢救成功率");
        writer.merge((Integer) map.get("jzlen"), "医院急诊报表");
        writer.write(jz, true);

        writer.addHeaderAlias("yy", "抢救原因");
        writer.addHeaderAlias("cgrc", "成功人次");
        writer.addHeaderAlias("swrc", "死亡人次");
        writer.addHeaderAlias("zrc", "总人次");
        writer.merge((Integer) map.get("yylen"), "医院急诊抢救原因报表");
        Workbook workbook = writer.write(yy, true).getWorkbook();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("医院急诊报表", "UTF-8") + ".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    /**
     * 查询抢救原因列表
     */
    @GetMapping("/wzqjyy")
    public ResultUtil findWZQJYY(Integer ison) throws Exception {
        return ResultUtil.success(hpRzJzService.getWZQJYYDict(ison));
    }

    /**
     * 查询急诊科室列表
     */
    @GetMapping("/jzks")
    public ResultUtil findJZKS() throws Exception {
        return ResultUtil.success(hpRzJzService.getJZKSDict());
    }

    /**
     * 更新字典
     *
     * @param val 字典信息
     * @return
     */
    @GetMapping("/updateRzDict")
    public ResultUtil update(SysDictVal val) throws Exception {
        if (null == val.getId()) {
            sysDictValService.insertDV(val);
        } else {
            sysDictValService.updateByPrimaryKeySelective(val);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 修改或删除急诊日志信息
     *
     * @param hpRzJz 急诊日志信息
     * @return
     */
    @PostMapping("/merge")
    public ResultUtil insert(@RequestBody HpRzJz hpRzJz) throws Exception {
        return hpRzJzService.insertorupdate(hpRzJz);
    }

    @GetMapping("/del")
    public ResultUtil delete(String id) throws Exception {
        hpRzJzService.deleteAll(id);
        return ResultUtil.success("操作成功!");
    }
}
