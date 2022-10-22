package com.sxdl.hp.controller;

import com.sxdl.base.service.SysStaffService;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpVsch0ADao;
import com.sxdl.hp.dbo.ModelC;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.entity.HpVsch0AEntity;
import com.sxdl.hp.service.*;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "病案录入")
@RestController
@RequestMapping("/hp_input")
public class HpInputController {

    @Autowired
    HpVsch0AService hpVsch0AService;
    @Autowired
    HpVsch0BService hpVsch0BService;
    @Autowired
    HpVsch0CService hpVsch0CService;
    @Autowired
    HpVsch0EService hpVsch0EService;
    @Autowired
    HpFllowService hpFllowService;
    @Autowired
    HpVsch0PService hpVsch0PService;
    @Autowired
    HpVsch0FService hpVsch0FService;
    @Autowired
    HpTableService hpTableService;
    @Autowired
    HpBmVersionService hpBmVersionService;
    @Autowired
    HpBzdmkService hpBzdmkService;
    @Autowired
    HpVsch0KService hpVsch0KService;
    @Autowired
    HpVsch0HService hpVsch0HService;
    @Autowired
    HpVsch0ADao hpVsch0ADao;
    @Autowired
    HpVsch0SService hpVsch0SService;
    @Autowired
    HpVsWt47CfnewService hpVsWt47CfnewService;
    @Autowired
    HpFileService hpFileService;
    @Autowired
    HpHomepageService hpHomepageService;
    @Autowired
    private SysStaffService sysStaffService;
    private HpHospiatlInfo hpHospiatlInfo;

    @ApiOperation(value = "录入初始化", notes = "查询中间库患者信息")
    @GetMapping("/findAll")
    public ResultUtil findAll(String year, String bah) throws Exception {
        return hpVsch0AService.findAllInit(year, bah);
    }

    @ApiOperation(value = "查询疾病编码", notes = "查询疾病编码包括:疾病,病理,中医,损伤")
    @GetMapping("/findICD")
    public ResultUtil findICD(String type, String name) throws Exception {
        return hpVsch0AService.getDmkInfos(type, name);
    }

    @ApiOperation(value = "查询手术编码", notes = "查询手术编码")
    @GetMapping("/findICCM")
    public ResultUtil findICCM(String name) throws Exception {
        return hpVsch0AService.getDmkInfos(null, name);
    }

    @ApiOperation(value = "录入精神代码初始化", notes = "查询精神代码字典信息")
    @GetMapping("/findJSDM")
    public ResultUtil findJSDM(String name) throws Exception {
        String sql = "select top 30  DM,  DMMC  from Vsjsdm  where DM like '%" + name + "%' or DMMC like '%" + name + "%' or PYM like '%" + name + "%' or DM like '%" + name + "%' order by len(dm),dm ";
        List<Map<String, Object>> maps = hpBzdmkService.selectSqlWithSQL(sql);
        return ResultUtil.success(maps);
    }

    @ApiOperation(value = "录入人员初始化", notes = "查询人员信息")
    @GetMapping("/findStaff")
    public ResultUtil findStaff(String name) throws Exception {
        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        String sql = "select top 100 code,name from sys_staff where name like '%" + name + "%' or code like '%" + name + "%' " + " or pym like '%" + name + "%' order by len(name),name asc ";
        //查询人员信息，页面上的人员下拉框
        List<Map<String, Object>> maps = sysStaffService.selectSqlWithSQL(sql);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "-");
        map.put("name", "-");
        maps.add(map);
        return ResultUtil.success(maps);
    }

    @ApiOperation(value = "编码员(用户)初始化", notes = "编码员(用户)初始化")
    @GetMapping("/findUser")
    public ResultUtil findUser(String name) throws Exception {
        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        String sql = "select code,name from hp_sys_user a left join hp_sys_user_vs_role b  on a.id=b.user_id  where " + "(name like '%" + name + "%' or code like '%" + name + "%')  and b.role_name like '%编码员%'";
        //查询人员信息，页面上的人员下拉框
        List<Map<String, Object>> maps = sysStaffService.selectSqlWithSQL(sql);
        return ResultUtil.success(maps);
    }

    @ApiOperation(value = "保存", notes = "页面录入保存")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody ModelC data) throws Exception {
        if (data == null) {
            return ResultUtil.error("没有数据要保存");
        }
        hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        return hpHomepageService.inserOrUpdate(data, hpHospiatlInfo);
    }

    @ApiOperation(value = "删除病案", notes = "删除病案重新抽取")
    @GetMapping("/deleteOne")
    public ResultUtil deleteOne(String id) throws Exception {
        if (!"".equals(id) && null != id) {
            HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
            if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
                return ResultUtil.error("医院信息未维护，请先维护医院信息");
            }

            String table_name = "";
            if (1 == hpHospiatlInfo.getHomepage_type()) {
                table_name = hpHospiatlInfo.getChinese_medicine();
            } else {
                table_name = hpHospiatlInfo.getWestern_medicine();
            }
            String deletesql = "update m set m.status=1 from hp_mid_table m,vsch0a a where a.ch0a01=m.bah and a.id='" + id + "'\n" + "delete vsch0A where ID ='" + id + "'\n" + "delete vsch0B where A_ID ='" + id + "'\n" + "delete vsch0C where A_ID ='" + id + "'\n" + "delete vsch0E where A_ID ='" + id + "'\n" + "delete vsch0H where A_ID ='" + id + "'\n" + "delete vsch0K where A_ID ='" + id + "'\n" + "delete vsch0S where A_ID ='" + id + "'\n" + "delete dl_fllow where A_ID ='" + id + "'\n" + "delete VsWT47_CFNew where A_ID ='" + id + "'\n" + "delete homepage where A_ID ='" + id + "'\n" + "delete " + table_name + " where A_ID ='" + id + "'\n";
            hpVsch0AService.updateSqlWithSQL(deletesql);
        }
        return ResultUtil.success("删除成功！");
    }

    @ApiOperation(value = "修改页面回显", notes = "修改页面回显")
    @GetMapping("/findOne")
    public ResultUtil findOne(String id) throws Exception {
        return hpVsch0AService.findOneBa(id);
    }

    @ApiOperation(value = "状态变更为已审核")
    @GetMapping("/audit")
    public ResultUtil audit(String id) throws Exception {
        hpVsch0AService.changeStatus(id, "4");
        return ResultUtil.success("数据审核通过");
    }

    @ApiOperation(value = "批量质控后,通过质控的数据变更数据为已审核")
    @GetMapping("/auditList")
    public ResultUtil auditList(String start, String end, String qcid, String qctime) throws Exception {
        hpVsch0AService.auditList(start, end, qcid, qctime);
        return ResultUtil.success("数据审核通过");
    }

    @ApiOperation(value = "上报后的修改页面回显", notes = "上报后的修改页面回显")
    @GetMapping("/findOneWhenReport")
    public ResultUtil findOneWhenReport(String id) throws Exception {
        Object aidobj = hpVsch0AService.getAidByBah(id);
        if (null == aidobj) {
            return ResultUtil.error("没有查到相应的数据,请联系管理员核查数据!");
        }
        String aid = aidobj.toString();
        hpVsch0AService.changeStatus(aid, "2");
        return hpVsch0AService.findOneBa(aid);
    }

    @ApiOperation(value = "撤销审核", notes = "撤销审核")
    @GetMapping("/revokeCheck")
    public ResultUtil revokeCheck(String id) throws Exception {
        hpVsch0AService.changeStatus(id, "2");
        return ResultUtil.success("撤销审核成功！");
    }

    @ApiOperation(value = "首页数据汇总", notes = "首页数据汇总")
    @GetMapping("index")
    public ResultUtil indexInfo() throws Exception {
        Calendar now = Calendar.getInstance();
        String endtime = DateUtil.formatFromDate(now.getTime());
        now.add(Calendar.DAY_OF_YEAR, -30);
        String starttime = DateUtil.formatFromDate(now.getTime());
        return ResultUtil.success(hpFileService.findCount(starttime, endtime));
    }

    @ApiOperation(value = "根据住院年度，住院号，住院次数查询单个病案信息", notes = "查询单个病案信息")
    @GetMapping("/findByBano")
    public ResultUtil findByBano(String year, String bah, Integer zycs) throws Exception {
        //根据ID查询病人首页基本信息
        HpVsch0AEntity entityA = hpVsch0AService.findByBano(year, bah, zycs);
        if (null != entityA) {
            return ResultUtil.success(entityA);
        } else {
            return ResultUtil.error("在此年度查无此人！");
        }
    }


    @ApiOperation(value = "修改病案号", notes = "修改病案号")
    @GetMapping("/updateBano")
    public ResultUtil updateBano(String id, String newBano, Integer newZycs) throws Exception {
        return hpVsch0AService.updateBano(id, newBano, newZycs);
    }

    @ApiOperation(value = "批量保存", notes = "批量保存")
    @GetMapping("/merge")
    public ResultUtil merge(String stardate, String enddate) throws Exception {
        hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        return hpVsch0AService.mergeOldBa(stardate, enddate, hpHospiatlInfo);
    }
}
