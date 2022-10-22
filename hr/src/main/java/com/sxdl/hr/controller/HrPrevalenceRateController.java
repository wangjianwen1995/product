package com.sxdl.hr.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hr.dao.dao1.*;
import com.sxdl.hr.entity.TgrBlmEntity;
import com.sxdl.hr.entity.TxhlGrbwxxEntity;
import com.sxdl.hr.entity.TxhlTdbytymjgEntity;
import com.sxdl.hr.service.HrTgrBlmService;
import com.sxdl.hr.service.HrTxhlGrbwxxService;
import com.sxdl.hr.service.HrTxhlTdbytymjgService;
import com.sxdl.hr.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author shqrpknife
 * @create 2022-08-05-11:27
 * 现患率调查
 */
@Api(tags = "现患率调查")
@RestController
@RequestMapping("/PrevalenceRate")
public class HrPrevalenceRateController {
    public static final String LineBreak = "\r\n";
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private Handle1Dao handle1Dao;
   /* @Autowired
    private HrPrevalenceRate hrPrevalenceRate;*/
    @Autowired
    private HrTgrBlmDao hrTgrBlmDao;
    @Autowired
    private HrTxhlGrbwxx hrTxhlGrbwxx;
    @Autowired
    private HrTxhlTdbytymjg hrTxhlTdbytymjg;
    @Autowired
    private HrTgrBlmService  hrTgrBlmService;
    @Autowired
    private HrTxhlGrbwxxService hrTxhlGrbwxxService;
    @Autowired
    private HrTxhlTdbytymjgService hrTxhlTdbytymjgService;

    /**------------------------------------现患率调查左侧开始---------------------------------*/
    /**
     * 新发起现患率调查
     */
    @ApiOperation(value = "新发起现患率调查 strkslist为科室代码通过#拼接")
    @GetMapping("/addPR")
    public ResultUtil addPR(@RequestParam Map<String, Object> paramst, HttpServletRequest request) {
        SysUser user = (SysUser)request.getSession().getAttribute("user");
        String code = user.getCode();
        String rolename = handle1Dao.selectSqlWithSQLStr("SELECT  a.role_name  FROM hr_sys_user_vs_role a, hr_sys_user b WHERE a.user_id=b.id AND b.code='"+code+"'");

        String dcgid = paramst.get("dcgid").toString();
        String strkslist = paramst.get("strkslist").toString();
        String dcsj = paramst.get("dcsj").toString();
        String dcname = paramst.get("dcname").toString();
        try {
            if(rolename!=null && !"".equals(rolename)&&(("超级管理员").equals(rolename) || ("院感科组").equals(rolename) )) {
                if (dcgid == null || dcgid.equals("null") || dcgid.equals("")) {
                    dcgid = UUID.randomUUID().toString();
                    handle1Dao.updateSqlWithSQL("insert into TXHLName values ('" + dcgid + "','" + dcsj + "','" + dcname + "') ");
                    hrTgrBlmDao.addPR(dcgid, strkslist, dcsj, dcname);
                    return ResultUtil.success("成功发起现患率调查");
                } else {
                    handle1Dao.updateSqlWithSQL("update TXHLName set dcsj='" + dcsj + "',dcname='" + dcname + "' ");
                    return ResultUtil.success("调查信息修改成功");
                }
            }else{
                return ResultUtil.success("您没有权限发起现患率调查");
            }

        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }

    /**
     * 取消现患率调查
     */
    @ApiOperation(value = "取消现患率调查")
    @GetMapping("/delPR")
    public ResultUtil delPR(String dcgid, HttpServletRequest request) {
        SysUser user = (SysUser)request.getSession().getAttribute("user");
        String code = user.getCode();
        String rolename = handle1Dao.selectSqlWithSQLStr("SELECT  a.role_name  FROM hr_sys_user_vs_role a, hr_sys_user b WHERE a.user_id=b.id AND b.code='"+code+"'");
        try {
            if(rolename!=null && !"".equals(rolename)&&(("超级管理员").equals(rolename) || ("院感科组").equals(rolename) )){
                hrTgrBlmDao.delPR(dcgid);
                handle1Dao.deleteSqlWithSQL("delete from TXHLName where dcgid='" + dcgid + "' ");
                handle1Dao.deleteSqlWithSQL("delete from TXHLDcRs where pkgid='" + dcgid + "' ");
                return ResultUtil.success("删除现患率调查成功");
            }else{
                return ResultUtil.success("您没有权限删除现患率调查");
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**
     * 根据条件查询现患率项目
     */
    @ApiOperation(value = "根据条件查询现患率项目")
    @GetMapping("/findPrByTime")
    public ResultUtil findPrByTime(String dcsj) {
        List<Map<String, Object>> lis = null;
        try {
            lis= handle1Dao.selectSqlWithSQL("select * from TXHLName where dcsj like '%" + dcsj + "%'");
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(lis);
    }

    /**
     * 根据条件查询现患率信息
     */
    @ApiOperation(value = "根据条件查询现患率信息")
    @GetMapping("/findBySerch")
    public ResultUtil findBySerch(PageInfo pageInfo,@RequestParam Map<String, Object> paramst) {
        String dcgid = paramst.get("dcgid").toString();
        String zyh = paramst.get("zyh").toString();
        String ksname = paramst.get("ksname").toString();
        String status = paramst.get("status").toString();
        String code = paramst.get("code").toString();
        List<TgrBlmEntity> lis = null;
        try {
            String sysname = handle1Dao.selectSqlWithSQLStr("SELECT name_zh FROM dbo.hr_sys_dict_table WHERE name='systemname'");
            if("net".equals(sysname)){
                lis = hrTgrBlmDao.findBySerch(dcgid, zyh, ksname, status, code);
            }else if("java".equals(sysname)){
                lis = hrTgrBlmDao.findBySerch1(dcgid, zyh, ksname, status, code);
            }
            //合并数据较多情况下
            int datasize = lis.size();
            int size = pageInfo.getPageSize();
            if (size >= datasize) {
                pageInfo.setList(lis);
            } else {
                int no = pageInfo.getPageNum() - 1;
                int start = PageUtil.getStart(no, size);
                int end = PageUtil.getEnd(no, size);
                if (end > datasize) {
                    end = datasize;
                }
                pageInfo.setList(lis.subList(start, end));
            }
            pageInfo.setTotal(datasize);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            System.out.println("dcgid:"+dcgid+";zyh:"+zyh+";ksname"+ksname+";status:"+status+";code:"+code);
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(pageInfo);
    }
    /**------------------------------------现患率调查左侧结束---------------------------------*/
    /**------------------------------------现患率病人信息开始---------------------------------*/
    /**
     * 增加单个病人调查信息
     */
    @ApiOperation(value = "增加单个病人调查信息")
    @GetMapping("/addSingle")
    public ResultUtil addSingle(String dcgid, String zyh) {
        List<Map<String, Object>> lis = null;
        try {
            if (hrTgrBlmDao.findByzyh(dcgid, zyh).size() > 0) {
                return ResultUtil.success("病人已经参与本次调查");
            } else {
                String sysname = handle1Dao.selectSqlWithSQLStr("SELECT name_zh FROM dbo.hr_sys_dict_table WHERE name='systemname'");
                if("net".equals(sysname)){
                    lis = handle1Dao.selectSqlWithSQL("SELECT TOP 1 a.blh,a.zyh,b.cwh blm02,hzxm blm04,CONVERT(varchar(10),hznl) blm06,c.KsName as ksname,b.szks as kscode,a.hzxb blm05,a.Ryzd blm07,CONVERT(VARCHAR(19),a.rysj,120) rysj\n" +
                            "   from HIS_rybr a, HIS_zkxx_js b,TUseKs c WHERE a.blh =b.blh AND b.szks=c.KsCode and a.zyh ='" + zyh + "'  order by b.rksj desc");
                }else if("java".equals(sysname)){
                    lis = handle1Dao.selectSqlWithSQL("SELECT TOP 1 a.blh,a.zyh,b.cwh blm02,hzxm blm04,CONVERT(varchar(10),hznl) blm06,c.name as ksname,b.szks as kscode,a.hzxb blm05,a.Ryzd blm07,CONVERT(VARCHAR(19),a.rysj,120) rysj\n" +
                            "    from HIS_rybr a, HIS_zkxx_js b,sys_ks c WHERE a.blh =b.blh AND b.szks=c.code and a.zyh ='" + zyh + "' order by b.rksj desc");
                }

                return ResultUtil.success(lis);
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**
     * 保存病人调查信息
     * sun
     */
    @ApiOperation(value = "修改/保存病人调查信息")
    @PostMapping("/saveBrInfo")
    public ResultUtil saveBrInfo(@RequestBody  Map jsonObject) {
        //JSONObject jsonObject = JSONUtil.parseObj(jsonstr);
        TgrBlmEntity tgrBlmEntity =new  TgrBlmEntity();

        String  sgid = (jsonObject.get("gid")+"").replace("null","");
        String  dcgid = jsonObject.get("dcgid")+"";
        String gid="";
        try {
            if(sgid ==null || "".equals(sgid)){
                gid=IdUtil.randomUUID();
                tgrBlmEntity.setGid(gid);
                tgrBlmEntity.setDcgid(dcgid);
                tgrBlmEntity.setBlh(jsonObject.get("blh")+"");
                tgrBlmEntity.setZyh(jsonObject.get("zyh")+"");
                tgrBlmEntity.setZycs(jsonObject.get("zycs")+"");
                tgrBlmEntity.setDcsj(jsonObject.get("dcsj")+"");
                tgrBlmEntity.setKscode(jsonObject.get("kscode")+"");
                tgrBlmEntity.setKsname(jsonObject.get("ksname")+"");
                tgrBlmEntity.setBlm02(jsonObject.get("blm02")+"");
                tgrBlmEntity.setBlm04(jsonObject.get("blm04")+"");
                tgrBlmEntity.setBlm05(jsonObject.get("blm05")+"");
                tgrBlmEntity.setBlm06(jsonObject.get("blm06")+"");
                tgrBlmEntity.setRysj(jsonObject.get("rysj")+"");
                tgrBlmEntity.setZgys(jsonObject.get("zgys")+"");
                tgrBlmEntity.setBlm07(jsonObject.get("blm07")+"");
            }else{
                gid=sgid;
                tgrBlmEntity =hrTgrBlmDao.findByGid(dcgid,gid);
            }
            tgrBlmEntity.setBlm05(jsonObject.get("blm05")+"");
            tgrBlmEntity.setZd(jsonObject.get("zd")+"");
            tgrBlmEntity.setBlm08(jsonObject.get("blm08")+"" );
            tgrBlmEntity.setBlm09(jsonObject.get("blm09")+"" );
            tgrBlmEntity.setBlm10(jsonObject.get("blm10")+"" );

            String blm11= jsonObject.get("blm11")+"";
            if("1".equals(blm11)){
                tgrBlmEntity.setScyygrrq(jsonObject.get("scyygrrq")+"" );
            }else{
                tgrBlmEntity.setScyygrrq("");
            }
            tgrBlmEntity.setBlm11(jsonObject.get("blm11")+"" );
            tgrBlmEntity.setIssqgr(jsonObject.get("issqgr")+"" );
            tgrBlmEntity.setIsywgr(jsonObject.get("isywgr")+"" );
            tgrBlmEntity.setIsshfy(jsonObject.get("isshfy")+"" );
            tgrBlmEntity.setBlm36(jsonObject.get("blm36")+"" );
            tgrBlmEntity.setBlm38(jsonObject.get("blm38")+"" );
            tgrBlmEntity.setBlm37(jsonObject.get("blm37")+"");
            tgrBlmEntity.setBlm39(jsonObject.get("blm39")+"");
            tgrBlmEntity.setSpysjwkjywsyq(jsonObject.get("spysjwkjywsyq")+"" );
            tgrBlmEntity.setBbglrs(jsonObject.get("bbglrs")+"");
            tgrBlmEntity.setBbksrs(jsonObject.get("bbksrs")+"" );
            tgrBlmEntity.setBbmzrs(jsonObject.get("bbmzrs")+"" );
            tgrBlmEntity.setBbjycs(jsonObject.get("bbjycs")+"" );
            tgrBlmEntity.setBlm40(jsonObject.get("blm40")+"" );
            String formatDateTime = DateUtil.formatDateTime(DateUtil.date());
            tgrBlmEntity.setTbsj(formatDateTime);
            tgrBlmEntity.setIsconfirm("0");
            if(sgid ==null || "".equals(sgid)){
                hrTgrBlmService.insert(tgrBlmEntity);
            }else{
                hrTgrBlmService.update(tgrBlmEntity);
            }
            //先删除感染部位和药敏信息
            handle1Dao.deleteSqlWithSQL("delete from txhl_grbwxx where gid='" + gid + "' ");
            handle1Dao.deleteSqlWithSQL("delete from txhl_tdbytymjg where gid='" + gid + "' ");
            //医院感染
            List arr1= (ArrayList) jsonObject.get("yygr");
            if("1".equals(blm11)){
               for (int i=0;i<arr1.size();i++){
                   //保存病原体信息
                   TxhlGrbwxxEntity txhlGrbwxxEntity =new TxhlGrbwxxEntity();
                   Map<String,Object> map1 =new HashMap<>();
                   map1 = (Map<String, Object>) arr1.get(i);
                   txhlGrbwxxEntity.setGid(gid);
                   String uuid = IdUtil.randomUUID();
                   txhlGrbwxxEntity.setGrgid(uuid);
                   txhlGrbwxxEntity.setGrbwdm((String) map1.get("grbwdm"));
                   txhlGrbwxxEntity.setGrbwmc((String) map1.get("grbwmc"));
                   txhlGrbwxxEntity.setZyh(tgrBlmEntity.getZyh());
                   txhlGrbwxxEntity.setGrlx("医院感染");
                   txhlGrbwxxEntity.setTbsj(formatDateTime);
                   hrTxhlGrbwxxService.insert(txhlGrbwxxEntity);
                   List arr2= (ArrayList) (map1.get("bytxx"));
                   for(int j=0;j<arr2.size();j++){
                       //保存抗菌药物信息
                       TxhlTdbytymjgEntity txhlTdbytymjgEntity =new TxhlTdbytymjgEntity();
                       Map<String,Object> map2 =new HashMap<>();
                       map2 = (Map<String, Object>) arr2.get(j);
                       txhlTdbytymjgEntity.setGrgid(uuid);
                       txhlTdbytymjgEntity.setByt((String) map2.get("byt"));
                       txhlTdbytymjgEntity.setGid(gid);
                       List arr3= (ArrayList) map2.get("ym");
                       if(arr3.size()>0){
                           for(int m=0;m<arr3.size();m++){
                               Map<String,Object> map3 =new HashMap<>();
                               map3 = (Map<String, Object>) arr3.get(m);
                               txhlTdbytymjgEntity.setYwdm((String) map3.get("ywdm"));
                               txhlTdbytymjgEntity.setYmjg(map3.get("ymjg")+"");
                               txhlTdbytymjgEntity.setBytid(IdUtil.randomUUID());
                               hrTxhlTdbytymjgService.insert(txhlTdbytymjgEntity);
                           }
                       }else{
                           txhlTdbytymjgEntity.setBytid(IdUtil.randomUUID());
                           hrTxhlTdbytymjgService.insert(txhlTdbytymjgEntity);
                       }
                   }
               }
           }

            //社区感染
            List arr22= (ArrayList) jsonObject.get("sqgr");
            String issqgr= jsonObject.get("issqgr")+"";
            if("1".equals(issqgr)){
                for (int i=0;i<arr22.size();i++){
                    //保存病原体信息
                    TxhlGrbwxxEntity txhlGrbwxxEntity =new TxhlGrbwxxEntity();
                    Map<String,Object> map1 =new HashMap<>();
                    map1 = (Map<String, Object>) arr22.get(i);
                    txhlGrbwxxEntity.setGid(gid);
                    String uuid = IdUtil.randomUUID();
                    txhlGrbwxxEntity.setGrgid(uuid);
                    txhlGrbwxxEntity.setGrbwdm((String) map1.get("grbwdm"));
                    txhlGrbwxxEntity.setGrbwmc((String) map1.get("grbwmc"));
                    txhlGrbwxxEntity.setZyh(tgrBlmEntity.getZyh());
                    txhlGrbwxxEntity.setGrlx("社区感染");
                    txhlGrbwxxEntity.setTbsj(formatDateTime);
                    hrTxhlGrbwxxService.insert(txhlGrbwxxEntity);
                    List arr2= (ArrayList) (map1.get("bytxx"));
                    for(int j=0;j<arr2.size();j++){
                        //保存抗菌药物信息
                        TxhlTdbytymjgEntity txhlTdbytymjgEntity =new TxhlTdbytymjgEntity();
                        Map<String,Object> map2 =new HashMap<>();
                        map2 = (Map<String, Object>) arr2.get(j);
                        txhlTdbytymjgEntity.setGrgid(uuid);
                        txhlTdbytymjgEntity.setByt((String) map2.get("byt"));
                        txhlTdbytymjgEntity.setGid(gid);
                        List arr3= (ArrayList) map2.get("ym");
                        if(arr3.size()>0) {
                            for (int m = 0; m < arr3.size(); m++) {
                                Map<String, Object> map3 = new HashMap<>();
                                map3 = (Map<String, Object>) arr3.get(m);
                                txhlTdbytymjgEntity.setYwdm((String) map3.get("ywdm"));
                                txhlTdbytymjgEntity.setYmjg(map3.get("ymjg") + "");
                                txhlTdbytymjgEntity.setBytid(IdUtil.randomUUID());
                                hrTxhlTdbytymjgService.insert(txhlTdbytymjgEntity);
                            }
                        }else{
                            txhlTdbytymjgEntity.setBytid(IdUtil.randomUUID());
                            hrTxhlTdbytymjgService.insert(txhlTdbytymjgEntity);
                        }
                    }
                }
            }

            //社区感染（外院）
            List arr33= (ArrayList) jsonObject.get("ywgr");
            String isywgr= jsonObject.get("isywgr")+"";
            if("1".equals(isywgr)){
                for (int i=0;i<arr33.size();i++){
                    //保存病原体信息
                    TxhlGrbwxxEntity txhlGrbwxxEntity =new TxhlGrbwxxEntity();
                    Map<String,Object> map1 =new HashMap<>();
                    map1 = (Map<String, Object>) arr33.get(i);
                    txhlGrbwxxEntity.setGid(gid);
                    String uuid = IdUtil.randomUUID();
                    txhlGrbwxxEntity.setGrgid(uuid);
                    txhlGrbwxxEntity.setGrbwdm((String) map1.get("grbwdm"));
                    txhlGrbwxxEntity.setGrbwmc((String) map1.get("grbwmc"));
                    txhlGrbwxxEntity.setZyh(tgrBlmEntity.getZyh());
                    txhlGrbwxxEntity.setGrlx("社区感染（外院）");
                    txhlGrbwxxEntity.setTbsj(formatDateTime);
                    hrTxhlGrbwxxService.insert(txhlGrbwxxEntity);
                    List arr2= (ArrayList) (map1.get("bytxx"));
                    for(int j=0;j<arr2.size();j++){
                        //保存抗菌药物信息
                        TxhlTdbytymjgEntity txhlTdbytymjgEntity =new TxhlTdbytymjgEntity();
                        Map<String,Object> map2 =new HashMap<>();
                        map2 = (Map<String, Object>) arr2.get(j);
                        txhlTdbytymjgEntity.setGrgid(uuid);
                        txhlTdbytymjgEntity.setByt((String) map2.get("byt"));
                        txhlTdbytymjgEntity.setGid(gid);
                        txhlTdbytymjgEntity.setZyh(tgrBlmEntity.getZyh());
                        List arr3= (ArrayList) map2.get("ym");
                        if(arr3.size()>0){
                            for(int m=0;m<arr3.size();m++){
                                Map<String,Object> map3 =new HashMap<>();
                                map3 = (Map<String, Object>) arr3.get(m);
                                txhlTdbytymjgEntity.setYwdm((String) map3.get("ywdm"));
                                txhlTdbytymjgEntity.setYmjg(map3.get("ymjg")+"");
                                txhlTdbytymjgEntity.setBytid(IdUtil.randomUUID());
                                hrTxhlTdbytymjgService.insert(txhlTdbytymjgEntity);
                            }
                        }else{
                            txhlTdbytymjgEntity.setBytid(IdUtil.randomUUID());
                            hrTxhlTdbytymjgService.insert(txhlTdbytymjgEntity);
                        }
                    }
                }
            }

        } catch (Exception e) {
            return ResultUtil.error("保存患者信息失败" +e.getCause().toString());
        }
        return ResultUtil.success("保存患者信息成功");
    }

    /**
     * 修改病人调查信息
     * @param jsonstr
     * @return sun
     */
    @ApiOperation(value = "查询单个病人调查信息")
    @GetMapping("/findBrInfo")
    public ResultUtil findBrInfo(@RequestParam(value = "dcgid",required = true) String dcgid,@RequestParam(value = "gid",required = true) String gid) {
        Map<String,Object> maps =new HashMap<String,Object>();
        try {
            TgrBlmEntity tgrBlmEntity = hrTgrBlmDao.findByGid(dcgid,gid);
            maps.put("gid",tgrBlmEntity.getGid());
            maps.put("dcgid",tgrBlmEntity.getDcgid());
            maps.put("blh",tgrBlmEntity.getBlh());
            maps.put("zyh",tgrBlmEntity.getZyh());
            maps.put("zycs",tgrBlmEntity.getZycs());
            maps.put("dcsj",tgrBlmEntity.getDcsj());
            maps.put("kscode",tgrBlmEntity.getKscode());
            maps.put("ksname",tgrBlmEntity.getKsname());
            maps.put("blm02",tgrBlmEntity.getBlm02());
            maps.put("blm04",tgrBlmEntity.getBlm04());
            maps.put("blm05",tgrBlmEntity.getBlm05());
            maps.put("blm06",tgrBlmEntity.getBlm06());
            maps.put("rysj",tgrBlmEntity.getRysj());
            maps.put("zgys",tgrBlmEntity.getZgys());
            maps.put("zd",tgrBlmEntity.getZd());
            maps.put("blm07",tgrBlmEntity.getBlm07());
            maps.put("blm08",tgrBlmEntity.getBlm08());
            maps.put("blm09",tgrBlmEntity.getBlm09());
            maps.put("blm10",tgrBlmEntity.getBlm10());
            maps.put("scyygrrq",tgrBlmEntity.getScyygrrq());
            maps.put("blm11",tgrBlmEntity.getBlm11());
            maps.put("issqgr",tgrBlmEntity.getIssqgr());
            maps.put("isywgr",tgrBlmEntity.getIsywgr());
            maps.put("isshfy",tgrBlmEntity.getIsshfy());
            maps.put("blm36",tgrBlmEntity.getBlm36());
            maps.put("blm38",tgrBlmEntity.getBlm38());
            maps.put("blm37",tgrBlmEntity.getBlm37());
            maps.put("blm39",tgrBlmEntity.getBlm39());
            maps.put("spysjwkjywsyq",tgrBlmEntity.getSpysjwkjywsyq());
            maps.put("bbglrs",tgrBlmEntity.getBbglrs());
            maps.put("bbksrs",tgrBlmEntity.getBbksrs());
            maps.put("bbmzrs",tgrBlmEntity.getBbmzrs());
            maps.put("bbjycs",tgrBlmEntity.getBbjycs());
            maps.put("blm40",tgrBlmEntity.getBlm40());
            maps.put("tbsj",tgrBlmEntity.getTbsj());
            maps.put("isconfirm",tgrBlmEntity.getIsconfirm());
            List<Map<String, Object>>  arrays = handle1Dao.selectSqlWithSQL("SELECT grbwdm,grbwmc FROM dbo.txhl_grbwxx ");
            //医院感染信息
            List arr =new ArrayList<>();
            List<Map<String, Object>> arraygrbw = handle1Dao.selectSqlWithSQL("SELECT grbwdm,grbwmc,grgid FROM dbo.txhl_grbwxx where gid ='"+gid+"' and grlx ='医院感染' ");
            for(int i=0;i<arraygrbw.size();i++){
                List arr3 =new ArrayList<>();
                Map<String, Object> mapayym1 =new HashMap<>();

                Map<String, Object> mapayym3 =new HashMap<>();
                mapayym3.put("grbwdm",arraygrbw.get(i).get("grbwdm"));
                mapayym3.put("grbwmc",arraygrbw.get(i).get("grbwmc"));

                String grgid = (String) arraygrbw.get(i).get("grgid");
                Map<String, Object> mapayym2 =new HashMap<>();

                List<Map<String, Object>> arrayymadd = handle1Dao.selectSqlWithSQL("SELECT distinct byt FROM dbo.txhl_tdbytymjg where grgid='"+grgid+"'");
                for (int m=0;m<arrayymadd.size();m++){
                    Map<String, Object> maparradd =new HashMap<>();
                    maparradd.put("byt",arrayymadd.get(m).get("byt"));
                    List arr2 =new ArrayList<>();
                    List<Map<String, Object>> arrayym = handle1Dao.selectSqlWithSQL("SELECT byt, ywdm, ymjg, grgid FROM dbo.txhl_tdbytymjg where grgid='"+grgid+"' and byt ='"+arrayymadd.get(m).get("byt")+"'");
                    for(int j=0;j<arrayym.size();j++){
                        Map<String, Object> maparr =new HashMap<>();
                        maparr.put("ywdm",arrayym.get(j).get("ywdm")) ;
                        maparr.put("ymjg",arrayym.get(j).get("ymjg")) ;
                        arr2.add(maparr);
                        maparradd.put("ym",arr2);
                    }
                    arr3.add(maparradd);
                }
                mapayym3.put("bytxx",arr3);
                arr.add(mapayym3);
            }
            //System.out.println(arr);
            maps.put("yygr",arr);
            //社区感染信息
            List arrsq =new ArrayList<>();
            List<Map<String, Object>> arraygrbwsq = handle1Dao.selectSqlWithSQL("SELECT grbwdm,grbwmc,grgid FROM dbo.txhl_grbwxx where gid ='"+gid+"' and grlx ='社区感染' ");
            for(int i=0;i<arraygrbwsq.size();i++){
                List arr3 =new ArrayList<>();
                Map<String, Object> mapayym1 =new HashMap<>();

                Map<String, Object> mapayym3 =new HashMap<>();
                mapayym3.put("grbwdm",arraygrbwsq.get(i).get("grbwdm"));
                mapayym3.put("grbwmc",arraygrbwsq.get(i).get("grbwmc"));

                String grgid = (String) arraygrbwsq.get(i).get("grgid");
                Map<String, Object> mapayym2 =new HashMap<>();

                List<Map<String, Object>> arrayymadd = handle1Dao.selectSqlWithSQL("SELECT distinct byt FROM dbo.txhl_tdbytymjg where grgid='"+grgid+"'");
                for (int m=0;m<arrayymadd.size();m++){
                    Map<String, Object> maparradd =new HashMap<>();
                    maparradd.put("byt",arrayymadd.get(m).get("byt"));
                    List arr2 =new ArrayList<>();
                    List<Map<String, Object>> arrayym = handle1Dao.selectSqlWithSQL("SELECT byt, ywdm, ymjg, grgid FROM dbo.txhl_tdbytymjg where grgid='"+grgid+"' and byt ='"+arrayymadd.get(m).get("byt")+"'");
                    for(int j=0;j<arrayym.size();j++){
                        Map<String, Object> maparr =new HashMap<>();
                        maparr.put("ywdm",arrayym.get(j).get("ywdm")) ;
                        maparr.put("ymjg",arrayym.get(j).get("ymjg")) ;
                        arr2.add(maparr);
                        maparradd.put("ym",arr2);
                    }
                    arr3.add(maparradd);
                }
                mapayym3.put("bytxx",arr3);
                arrsq.add(mapayym3);
            }
            maps.put("sqgr",arrsq);
            //社区感染（外院）
            List arrsqwy =new ArrayList<>();
            List<Map<String, Object>> arraygrbwsqwy = handle1Dao.selectSqlWithSQL("SELECT grbwdm,grbwmc,grgid FROM dbo.txhl_grbwxx where gid ='"+gid+"' and grlx ='社区感染（外院）' ");
            for(int i=0;i<arraygrbwsqwy.size();i++){
                List arr3 =new ArrayList<>();
                Map<String, Object> mapayym1 =new HashMap<>();

                Map<String, Object> mapayym3 =new HashMap<>();
                mapayym3.put("grbwdm",arraygrbwsqwy.get(i).get("grbwdm"));
                mapayym3.put("grbwmc",arraygrbwsqwy.get(i).get("grbwmc"));

                String grgid = (String) arraygrbwsqwy.get(i).get("grgid");
                Map<String, Object> mapayym2 =new HashMap<>();

                List<Map<String, Object>> arrayymadd = handle1Dao.selectSqlWithSQL("SELECT distinct byt FROM dbo.txhl_tdbytymjg where grgid='"+grgid+"'");
                for (int m=0;m<arrayymadd.size();m++){
                    Map<String, Object> maparradd =new HashMap<>();
                    maparradd.put("byt",arrayymadd.get(m).get("byt"));
                    List arr2 =new ArrayList<>();
                    List<Map<String, Object>> arrayym = handle1Dao.selectSqlWithSQL("SELECT byt, ywdm, ymjg, grgid FROM dbo.txhl_tdbytymjg where grgid='"+grgid+"' and byt ='"+arrayymadd.get(m).get("byt")+"'");
                    for(int j=0;j<arrayym.size();j++){
                        Map<String, Object> maparr =new HashMap<>();
                        maparr.put("ywdm",arrayym.get(j).get("ywdm")) ;
                        maparr.put("ymjg",arrayym.get(j).get("ymjg")) ;
                        arr2.add(maparr);
                        maparradd.put("ym",arr2);
                    }
                    arr3.add(maparradd);
                }
                mapayym3.put("bytxx",arr3);
                arrsqwy.add(mapayym3);
            }
            maps.put("ywgr",arrsqwy);
        } catch (Exception e) {
            return ResultUtil.error("获取患者信息失败" +e.getCause().toString());
        }
        return ResultUtil.success(maps);
    }

    /**
     * 删除单个患者调查信息
     */

    @ApiOperation(value = "删除单个患者信息")
    @GetMapping("/delByGid")
    public ResultUtil delByGid(String gid,HttpServletRequest request) {
        SysUser user = (SysUser)request.getSession().getAttribute("user");
        String code = user.getCode();
        String rolename = handle1Dao.selectSqlWithSQLStr("SELECT  a.role_name  FROM hr_sys_user_vs_role a, hr_sys_user b WHERE a.user_id=b.id AND b.code='"+code+"'");
        try {
            if(rolename!=null && !"".equals(rolename)&&(("超级管理员").equals(rolename) || ("院感科组").equals(rolename) )) {
                hrTgrBlmDao.delByGid(gid);
                //先删除感染部位和药敏信息
                handle1Dao.deleteSqlWithSQL("delete from txhl_grbwxx where gid='" + gid + "' ");
                handle1Dao.deleteSqlWithSQL("delete from txhl_tdbytymjg where gid='" + gid + "' ");
                return ResultUtil.success("删除患者信息成功");
            }else{
                return ResultUtil.success("您没有权限删除患者信息成功");
            }

        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**------------------------------------现患率病人信息结束---------------------------------*/
    /**------------------------------------现患率病人信息审核流程开始---------------------------------*/
    /**
     * 批量审核操作
     * 参数gids：选中的病人的gid通过，拼接
     */

    @ApiOperation(value = "现患率批量审核 参数gids：选中的病人的gid通过，拼接")
    @GetMapping("/plShPR")
    public ResultUtil plShPR(String status, String gids) {
        try {
            if (gids.indexOf(",") > 0) {
                String[] gid = gids.split(",");
                for (int i = 0; i < gid.length; i++) {
                    hrTgrBlmDao.updateStatus(status, gid[i]);
                }
                return ResultUtil.success("批量审核成功");
            } else {
                hrTgrBlmDao.updateStatus(status, gids);
                return ResultUtil.success("批量审核成功");
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.success(e.getCause().toString());
        }
    }
    /**------------------------------------现患率病人信息审核流程结束---------------------------------*/
    /**------------------------------------现患率病人信息字典信息开始---------------------------------*/
    /**
     * 标准疾病诊断
     */
    @ApiOperation(value = "标准疾病诊断")
    @GetMapping("/getJbStandard")
    public ResultUtil getJbStandard() {
        List<Map<String, Object>> lis = null;
        try {
            lis = handle1Dao.selectSqlWithSQL("select * from txhl_bzzd");
        } catch (Exception e) {
            logger.error(e + LineBreak);
        }
        return ResultUtil.success(lis);
    }
    /**
     * 标准病原体信息带抗菌药物
     * @author sun
     */
    @ApiOperation(value = "标准病原体信息")
    @GetMapping("/getBytYmStandard")
    public ResultUtil getBytYmStandard() {
        List<Map<String, Object>> lis = null;
        List<Map<String, Object>> lis2 = null;
        String hh ="";
        try{
            lis = handle1Dao.selectSqlWithSQL("SELECT * FROM bzbyt");
            for (int i=0;i<lis.size();i++){
                String bm = (String) lis.get(i).get("bm");
                hh=bm;
                lis2 = handle1Dao.selectSqlWithSQL("SELECT * from txhl_tdbytkss WHERE bm='"+bm+"'  ORDER BY wy");
                if (lis2.size()>0){
                    List arr1=new ArrayList();
                    for (int m=0;m<lis2.size();m++){
                        Map<String, Object> map1 =new HashMap<>();
                        map1.put("ymymmc",lis2.get(m).get("ymymmc"));
                        map1.put("ymymbm",lis2.get(m).get("ymymbm"));
                        arr1.add(map1);
                    }
                    lis.get(i).put("ym",arr1);
                }
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
        }
        return ResultUtil.success(lis);
    }

   /**
     * 标准病原体信息
     */
    @ApiOperation(value = "标准感染部位信息")
    @GetMapping("/getGrbwStandard")
    public ResultUtil getGrbwStandard() {
        List<Map<String, Object>> lis = null;
        try {
            lis = handle1Dao.selectSqlWithSQL("SELECT * FROM bzgrbw");
        } catch (Exception e) {
            logger.error(e + LineBreak);
        }
        return ResultUtil.success(lis);
    }

   /**------------------------------------现患率病人信息字典信息结束---------------------------------*/

    @ApiOperation(value = "导出现患率数据", notes = "导出现患率数据")
    @GetMapping("/exportXhl")
    @ResponseBody
    public void exportXhl(@RequestParam(value = "dcgid",required = true) String dcgid, HttpServletResponse response) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String dcsj = handle1Dao.excuteSqlWithSQL("select dcsj from txhlname where dcgid='"+dcgid+"'");
            Date parse = dateFormat.parse(dcsj);
            Calendar c = Calendar.getInstance();
            c.setTime(parse);
            c.add(Calendar.DATE, -1);
            String kssj = dateFormat.format(c.getTime());
            hrTgrBlmDao.xhlSh(kssj, dcsj);
            List<String> headers = new ArrayList<>();
            headers.add("状态");
            headers.add("住院号");
            headers.add("病历号"); //这里的表头，根据数据的字段命名也行，随你喜欢
            headers.add("科室名称");
            headers.add("患者姓名");
            headers.add("床位号");
            headers.add("性别");
            headers.add("年龄");
            headers.add("住院次数");
            headers.add("入院诊断");
            headers.add("是否手术");
            headers.add("手术切口类型");
            headers.add("是否感染");
            headers.add("调查者");
            headers.add("填写时间");
            headers.add("入院时间");
            List<TgrBlmEntity> datas = hrTgrBlmService.findByDcgid(dcgid);
            List<String[]> operateListStr = new ArrayList<>();
            for (int i = 0; i < datas.size(); i++) {
                TgrBlmEntity data = datas.get(i);
                String[] strarr = new String[]{
                        (StringUtils.isEmpty(data.getIsconfirm()) ? "" : data.getIsconfirm().equals("1")?"已审核":data.getIsconfirm().equals("0")?"已编辑":"未编辑"),
                        (StringUtils.isEmpty(data.getZyh()) ? "" : data.getZyh()),
                        (StringUtils.isEmpty(data.getBlh()) ? "" : data.getBlh()),
                        (StringUtils.isEmpty(data.getKsname()) ? "" : data.getKsname()),
                        (StringUtils.isEmpty(data.getBlm04()) ? "" : data.getBlm04()),
                        (StringUtils.isEmpty(data.getBlm02()) ? "" : data.getBlm02()),
                        (StringUtils.isEmpty(data.getBlm05()) ? "" : data.getBlm05()),
                        (StringUtils.isEmpty(data.getBlm06()) ? "" : data.getBlm06()),
                        (StringUtils.isEmpty(data.getZycs()) ? "" : data.getZycs()),
                        (StringUtils.isEmpty(data.getBlm07()) ? "" : data.getBlm07()),
                        (StringUtils.isEmpty(data.getBlm08()) ? "" : data.getBlm08().equals("1")?"是":"否"),
                        (StringUtils.isEmpty(data.getBlm09())||data.getBlm09().equals("-1") ? "" : data.getBlm09().equals("1")?"一类切口":data.getBlm09().equals("2")?"二类切口":data.getBlm09().equals("3")?"三类切口":"四类切口"),
                        (StringUtils.isEmpty(data.getBlm10()) ? "" : data.getBlm10().equals("1")?"是":"否"),
                        (StringUtils.isEmpty(data.getBlm40()) ? "" : data.getBlm40()),
                        (StringUtils.isEmpty(data.getTbsj()) ? "" : data.getTbsj()),
                        (StringUtils.isEmpty(data.getRysj()) ? "" : data.getRysj())
                };
                operateListStr.add(strarr);
            }
            String strTableName = "医院现患率数据"; //这个是标题
            //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
            response.reset();
            //处理乱码问题
            response.setCharacterEncoding("UTF-8");
            //设置上下文类型
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //客户使用目标另存为对话框保存指定文件
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(strTableName, "utf-8") + ".xls;");
            ExcelUtil.createExcel(strTableName, headers, operateListStr, response.getOutputStream());
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
