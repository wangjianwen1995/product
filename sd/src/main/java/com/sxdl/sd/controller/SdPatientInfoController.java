package com.sxdl.sd.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
//import com.sxdl.base.entity.SysKs;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsRole;
//import com.sxdl.base.service.SysKsService;
import com.sxdl.base.service.SysUserService;
import com.sxdl.base.service.SysUserVsRoleService;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ExcelUtil;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.dao.dao1.Handle1Dao;
import com.sxdl.sd.dao.dao2.HandleDao;
import com.sxdl.sd.entity.SdInfo;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdPatientInfoService;
import com.sxdl.sd.service.SdPatientValService;
import com.sxdl.sd.util.SdApplicationRunnerImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/psi")
public class SdPatientInfoController {

    @Autowired
    SdPatientValService sdPatientValService;

    @Autowired
    SdPatientInfoService sdPatientInfoService;

    @Autowired
    SysUserVsRoleService sysUserVsRoleService;
    /*@Autowired
    SysKsService sysKsService;*/
    @Autowired
    SysUserService sysUserService;
    @Autowired
    HandleDao handleDao;
    @Autowired
    Handle1Dao handle1Dao;




    /*
     *类角标：uid，flag（类角标），status(7)
     *类下属单病种角标：uid，flag（角标），status(7),gid
     *单病种列表：uid,flag(病人列表),status,sid
     *
     * */
    @ApiOperation(value = " 单病种分类角标 ", notes = " 单病种分类角标")
    @GetMapping("/findAllSd")

    public ResultUtil findAllSd(PageInfo pageInfo, @RequestParam(value = "uid", required = true) Integer uid,
                                @RequestParam(value = "flag", required = true) String flag,
                                @RequestParam(value = "status", defaultValue = "7") Integer status,
                                Integer sid, Integer gid, String pid, String sdate, String edate) {
        // System.out.println ( pageInfo );
        Map<Integer, List<SdPatientInfo>> map = null;
        Map<Integer, Integer> count = new HashMap<>();
        List<SdPatientInfo> patientInfos = new ArrayList<>();
        List<SdInfo> sdInfos = (List<SdInfo>) SdApplicationRunnerImpl.contextMap.get("sdInfos");
        SysUserVsRole sysUserVsRole = new SysUserVsRole();
        sysUserVsRole.setUser_id(uid);
        try {
            List<SysUserVsRole> sysUserVsRoles = sysUserVsRoleService.select(sysUserVsRole);
            if (sysUserVsRoles == null || sysUserVsRoles.size() <= 0) {
                return ResultUtil.error("该用户权限存在问题");
            }
            SysUserVsRole userVsRole = sysUserVsRoles.get(0);
            String role_name = userVsRole.getRole_name();

            if (role_name.contains("管理员") || role_name.equals("院领导组")) {
                patientInfos = sdPatientInfoService.findBySome(status, 0, sid, role_name);
            } else {
                patientInfos = sdPatientInfoService.findBySome(status, uid, sid, role_name);
            }

            if (null != sdate && !"".equals(sdate) && null != edate && !"".equals(edate)) {
                patientInfos = patientInfos.stream().filter(e -> e != null && (e.getCy_time().compareTo(sdate) >= 0 && e.getCy_time().compareTo(edate) <= 0)).collect(Collectors.toList());
            }
            if (flag.contains("角标")) {
                if (flag.contains("类")) {
                    map = patientInfos.stream().collect(Collectors.groupingBy(e -> e.getSd_group_id()));
                } else {
                    patientInfos = patientInfos.stream().filter(e -> e != null && e.getSd_group_id().equals(gid)).collect(Collectors.toList());
                    map = patientInfos.stream().collect(Collectors.groupingBy(e -> e.getSd_info_id()));
                }
                map.forEach((k, v) -> {
                    count.put(k, v.size());
                });
                //System.out.println ( count );
                return ResultUtil.success(count);
            }
            //只有某一个单病种下面会展示病人list信息
            patientInfos.forEach(e -> {
                /*SysKs sKs = new SysKs();
                sKs.setCode(e.getKs_code());
                List<SysKs> sysKs = sysKsService.select(sKs);*/
                List<Map<String, Object>> sysKs  =handle1Dao.selectSqlWithSQL("select * from sys_ks where is_on=1 and code ='"+e.getKs_code()+"'");

                SysUser sysUser = new SysUser();
                sysUser.setCode(e.getDr_code());
                List<SysUser> users = sysUserService.select(sysUser);
                //System.out.println (users.size ());
                if (sysKs != null && sysKs.size() > 0) {
                    e.setKs_name(sysKs.get(0).get("name").toString());
                }
                if (users != null && users.size() > 0) {
                    e.setZr_name(users.get(0).getName());
                }
               /* List<SysStandardKs> sysStandardKs = sysStandardKsService.select ( standardKs );
                SysStandardKs sysStandardKs1 = sysStandardKs.get ( 0 );
                e.setKs_name ( sysStandardKs1.getName () );*/
            });
            if (pid != null && !"".equals(pid)) {
                patientInfos = patientInfos.stream().filter(e -> e != null && (e.getPatient_code().equals(pid) || e.getName().contains(pid))).collect(Collectors.toList());
            }

            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(patientInfos);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), patientInfos);
            //System.out.println ( listPage );
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            return ResultUtil.error("操作失败"+e.getMessage());
        }
    }


    @ApiOperation(value = "根据id查询", notes = "根据id查询")
    @GetMapping("/findByID")
    @ResponseBody
    public ResultUtil findByID(Integer sid, String patientCode) {
        try {
            SdPatientInfo sdPatientInfo = sdPatientInfoService.selectOne(sid, patientCode);
            return ResultUtil.success(sdPatientInfo);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "查例数", notes = "查例数")
    @GetMapping("/findByls")
    @ResponseBody
    public ResultUtil findByls() {
        try {
            SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String edate = myFmt.format(new Date());
            String zeroTime = DateUtil.getZeroTime();
            Map<String, Integer> map = sdPatientInfoService.selectLs(edate, zeroTime);
            return ResultUtil.success(map);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "根据出院时间,提交时间查明细", notes = "查明细")
    @GetMapping("/findByKs")
    @ResponseBody
    public ResultUtil findByKs(PageInfo pageInfo, String status, String cysdate, String cyedate,String tjsdate, String tjedate, String ks, String flag) {
        if (status.equals("7")) {
            status = "1=1";
        } else {
            status = "a.status=" + status;
        }
        try {
            if (flag.equals("例数")) {
                List<Map<String, Object>> list = sdPatientInfoService.findByKs(status, cysdate, cyedate,tjsdate, tjedate);
                if (null != ks && !"".equals(ks)) {
                    list = list.stream().filter(
                            e -> e.get("ks").toString().contains(ks)).collect(Collectors.toList());
                }
                ResultUtil page = getPage(list, pageInfo);
                return page;
            } else {
                if (null == ks || "".equals(ks)) {
                    return ResultUtil.error("科室明细查询失败");
                } else {
                    List<SdPatientInfo> list = sdPatientInfoService.findByksmx(ks, "ks_code", status, cysdate, cyedate,tjsdate, tjedate);
                    // List<SdPatientInfo> sdPatientInfos = setKsAndDr ( list );
                    return getPage(list, pageInfo);
                }
            }

        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }


//    @ApiOperation(value = "根据提交时间查明细", notes = "查明细")
//    @GetMapping("/findByTjsj")
//    @ResponseBody
//    public ResultUtil findByTjsj(PageInfo pageInfo, String status, String tjsdate, String tjedate, String ks, String flag) {
//        if (status.equals("7")) {
//            status = "1=1";
//        } else {
//            status = "a.status=" + status;
//        }
//        try {
//            if (flag.equals("例数")) {
//                List<Map<String, Object>> list = sdPatientInfoService.findByKsTj(status, tjsdate, tjedate);
//                if (null != ks && !"".equals(ks)) {
//                    list = list.stream().filter(
//                            e -> e.get("ks").toString().contains(ks)).collect(Collectors.toList());
//                }
//                ResultUtil page = getPage(list, pageInfo);
//                return page;
//            } else {
//                if (null == ks || "".equals(ks)) {
//                    return ResultUtil.error("科室明细查询失败");
//                } else {
//                    List<SdPatientInfo> list = sdPatientInfoService.findByksmxTj(ks, "ks_code", status, tjsdate, tjedate);
//                    // List<SdPatientInfo> sdPatientInfos = setKsAndDr ( list );
//                    return getPage(list, pageInfo);
//                }
//            }
//
//        } catch (Exception e) {
//            return ResultUtil.error("操作失败");
//        }
//    }


    private ResultUtil getPage(List list, PageInfo pageInfo) {
        if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
            return ResultUtil.success(list);
        }
        Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "查明细", notes = "查明细")
    @GetMapping("/findByDr")
    @ResponseBody
    public ResultUtil findByDr(PageInfo pageInfo, String dr, String cysdate, String cyedate,String tjsdate, String tjedate, String status, String flag) {
        try {
            if (status.equals("7")) {
                status = "1=1";
            } else {
                status = "a.status=" + status;
            }
            if (flag.equals("例数")) {
                List<Map<String, Object>> list = sdPatientInfoService.findBydr(status, cysdate, cyedate);
                if (null != dr && !"".equals(dr)) {
                    list = list.stream().filter(e ->
                            null != e.get("dr") && !"".equals(e.get("dr")) && e.get("dr").toString().contains(dr)).collect(Collectors.toList());
                }
                ResultUtil page = getPage(list, pageInfo);
                return page;

            } else {
                if (null == dr || "".equals(dr)) {
                    return ResultUtil.error("医生明细查询失败");
                } else {
                    List<SdPatientInfo> list = sdPatientInfoService.findByksmx(dr, "dr_code", status, cysdate, cyedate,tjsdate, tjedate);
                    List<SdPatientInfo> sdPatientInfos = setKsAndDr(list);
                    return getPage(sdPatientInfos, pageInfo);
                }
            }
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }


    @ApiOperation(value = "保存修改", notes = "保存修改单病种病人的值信息")
    @PostMapping("/save")

    public ResultUtil insert(@RequestBody SdPatientInfo sdPatientInfo) {
        //审核修改状态
        Integer id = sdPatientInfo.getId();
        if (null == id && "".equals(id) && id < 0) {
            return ResultUtil.error("数据错误");
        }
        try {
            sdPatientInfoService.updateSome(sdPatientInfo);
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("保存失败"+e.getCause());
        }
    }

    /* @ApiOperation(value = "批量审核", notes = "批量审核")
     @PostMapping("/plsh")
     public ResultUtil plsh(@RequestBody Map<String, SdPatientInfo> sdPatientInfo) {
         //审核修改状态
         //System.out.println (sdPatientInfo);
         if (sdPatientInfo == null || sdPatientInfo.size() <= 0) {
             return ResultUtil.success("没有数据");
         }
         try {
             sdPatientInfo.forEach((k, v) -> {
                 v.setStatus(6);
                 sdPatientInfoService.update(v);
             });
             return ResultUtil.success("操作成功");
         } catch (Exception e) {
             return ResultUtil.error("保存失败");
         }
     }
 */
    @ApiOperation(value = "批量审核", notes = "批量审核")
    @PostMapping("/plsh")
    public ResultUtil plsh(@RequestBody List<SdPatientInfo> list) {
        if (list == null || list.size() <= 0) {
            return ResultUtil.success("没有数据");
        }
        try {
            list.forEach(e -> {
                e.setStatus(6);
                sdPatientInfoService.update(e);
            });
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("保存失败"+e.getCause());
        }
    }

    @ApiOperation(value = "批量驳回", notes = "批量驳回")
    @PostMapping("/plbh")
    public ResultUtil plbh(@RequestBody List<SdPatientInfo> list) {
        if (list == null || list.size() <= 0) {
            return ResultUtil.success("没有数据");
        }
        try {
            list.forEach(e -> {
                e.setStatus(3);
                sdPatientInfoService.update(e);
            });
            list.forEach(e -> {
                e.setReject_reason("有必填项未填");
                sdPatientInfoService.update(e);
            });
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String realTime = formatter.format(date);
            list.forEach(e -> {
                e.setReject_time(realTime);
                sdPatientInfoService.update(e);
            });
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("保存失败"+e.getCause());
        }
    }

    private List<SdPatientInfo> setKsAndDr(List<SdPatientInfo> sdPatientInfos) {
        sdPatientInfos.forEach(e -> {
//            SysKs sKs = new SysKs();
//            sKs.setCode(e.getKs_code());
//            List<SysKs> sysKs = sysKsService.select(sKs);
            List<Map<String, Object>> sysKs  =handleDao.selectSqlWithSQL("select * from sys_ks where is_on=1 and code ='"+e.getKs_code()+"'");
            SysUser sysUser = new SysUser();
            sysUser.setCode(e.getDr_code());
            List<SysUser> users = sysUserService.select(sysUser);
            //System.out.println (users.size ());
            if (sysKs != null && sysKs.size() > 0) {
                e.setKs_name(sysKs.get(0).get("name").toString());
            }
            if (users != null && users.size() > 0) {
                e.setZr_name(users.get(0).getName());
            }
        });
        return sdPatientInfos;
    }


    @ApiOperation(value = "导出例数", notes = "导出EXCEL")
    @GetMapping("/exportOperateLog")
    @ResponseBody
    public void exportOperateLog(HttpServletRequest request, HttpServletResponse response, String status,
                                 String cysdate,String tjsdate, String tjedate, String cyedate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String sql = getSql(status);
        String status1 = getStatus(status);
        try {
            response.reset();
            //response.setContentType("text/html;charset=GBK");// 设置response内容的类型
            response.setContentType("application/force-download");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("各科室" + status1 + "例数") + dateFormat.format(new Date()) + ".xls;");
            String strTableName = "各科室" + status1 + "例数"; //这个是标题
            List<String> headers = new ArrayList<>();
            headers.add("科室"); //这里的表头，根据数据的字段命名也行，随你喜欢
            headers.add("例数");
            List<Map<String, Object>> datas = sdPatientInfoService.findByKs(sql, cysdate, cyedate,tjsdate,tjedate);
            List<String[]> operateListStr = new ArrayList<>();
            for (int i = 0; i < datas.size(); i++) {
                Map<String, Object> data = datas.get(i);
                String[] strarr = new String[]{(StringUtils.isEmpty(data.get("ks").toString()) ? "-" : data.get("ks").toString()),
                        (StringUtils.isEmpty(data.get("ls").toString()) ? "-" : data.get("ls").toString()),
                };
                operateListStr.add(strarr);
            }
            ExcelUtil.createExcel(strTableName, headers, operateListStr, response.getOutputStream());

        } catch (IOException e) {
            e.getMessage();

        }
    }

    @ApiOperation(value = "导出明细", notes = "导出EXCEL")
    @GetMapping("/exportMXLog")
    @ResponseBody

    public void exportMXLog(HttpServletRequest request, HttpServletResponse response, String status,
                            String cysdate, String cyedate,String tjsdate, String tjedate, String kscode, String ksName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String sql = getSql(status);
        String status1 = getStatus(status);
        try {
            response.reset();
            //response.setContentType("text/html;charset=GBK");// 设置response内容的类型
            response.setContentType("application/force-download");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(ksName + status1 + "患者明细例数") + dateFormat.format(new Date()) + ".xls;");
            String strTableName = ksName + status1 + "患者明细例数"; //这个是标题
            List<String> headers = new ArrayList<>();
            headers.add("病案号"); //这里的表头，根据数据的字段命名也行，随你喜欢
            headers.add("患者姓名");
            headers.add("单病种名称");
            headers.add("住院医师");
            headers.add("主任医师");
            headers.add("出院时间");
            headers.add("提交时间");
            headers.add("审核时间");
            headers.add("终审时间");
            headers.add("出院科室");
            headers.add("作废/驳回原因");
            headers.add("作废/驳回时间");

            List<SdPatientInfo> datas = sdPatientInfoService.findByksmx(kscode, "ks_code", sql, cysdate, cyedate,tjsdate,tjedate);
            List<String[]> operateListStr = new ArrayList<>();
            for (int i = 0; i < datas.size(); i++) {
                SdPatientInfo data = datas.get(i);
                String[] strarr = new String[]{(StringUtils.isEmpty(data.getPatient_code()) ? "-" : data.getPatient_code().toString()),
                        (StringUtils.isEmpty(data.getName()) ? "-" : data.getName().toString()),
                        (StringUtils.isEmpty(data.getSource()) ? "-" : data.getSource().toString()),
                        (StringUtils.isEmpty(data.getDr_code()) ? "-" : data.getDr_code().toString()),
                        (StringUtils.isEmpty(data.getDirector_code()) ? "-" : data.getDirector_code().toString()),
                        (StringUtils.isEmpty(data.getCy_time()) ? "-" : data.getCy_time().toString()),
                        (StringUtils.isEmpty(data.getSubmit_time()) ? "-" : data.getSubmit_time().toString()),
                        (StringUtils.isEmpty(data.getCheck_time()) ? "-" : data.getCheck_time().toString()),
                        (StringUtils.isEmpty(data.getCheck_ztime()) ? "-" : data.getCheck_ztime().toString()),
                        (StringUtils.isEmpty(data.getKs_code()) ? "-" : data.getKs_code().toString()),
                        (StringUtils.isEmpty(data.getReject_reason()) ? "-" : data.getReject_reason().toString()),
                        (StringUtils.isEmpty(data.getReject_time()) ? "-" : data.getReject_time().toString()),
                };
                operateListStr.add(strarr);
            }
            ExcelUtil.createExcel(strTableName, headers, operateListStr, response.getOutputStream());
        } catch (IOException e) {
            e.getMessage();
        }
    }


    private String getSql(String val) {
        String status = "";
        if (val.equals("7")) {
            status = "1=1";
        } else {
            status = "a.status=" + val;
        }
        return status;
    }

    private String getStatus(String status) {
        String name = "";
        switch (status) {
            case "1":
                name = "未审核未提交";
                break;
            case "2":
                name = "已提交未审核";
                break;
            case "3":
                name = "已提交已驳回";
                break;
            case "4":
                name = "已提交已通过";
                break;
            case "5":
                name = "已提交终驳回";
                break;
            case "6":
                name = "已提交终通过";
                break;
            case "7":
                name = "全部";
                break;
            case "-1":
                name = "作废";
                break;
        }
        return name;
    }

}
