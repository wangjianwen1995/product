package com.sxdl.hr.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.PageUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hr.dao.dao1.Handle1Dao;
import com.sxdl.hr.dao.dao1.HrTgrXytxDao;
import com.sxdl.hr.dao.dao2.HandleDao;
import com.sxdl.hr.entity.TgrXytxEntity;
import com.sxdl.hr.service.HrTgrxytxService;
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
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author shqrpknife
 * @create 2022-09-02-16:58
 */
@Api(tags = "血液透析调查")
@RequestMapping("/Hemodialysis")
@RestController
public class HrHemodialysisController {
    public static final String LineBreak = "\r\n";
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    Handle1Dao handle1Dao;

    @Autowired
    HrTgrXytxDao hrTgrXytxDao;

    @Autowired
    HrTgrxytxService hrTgrxytxService;
/**------------------------------------血液透析调查左侧开始---------------------------------*/
    /**
     * 新发起血液透析调查
     */
    @ApiOperation(value = "新发起血液透析调查 strkslist为科室代码通过#拼接")
    @GetMapping("/addHh")
    public ResultUtil addHh(@RequestParam Map<String, Object> paramst, HttpServletRequest request) {
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
                    handle1Dao.updateSqlWithSQL("insert into txytxname values ('" + dcgid + "','" + dcsj + "','" + dcname + "') ");
                    hrTgrXytxDao.addHh(dcgid, strkslist, dcsj, dcname);
                    return ResultUtil.success("成功发起血液透析调查");
                } else {
                    handle1Dao.updateSqlWithSQL("update txytxname set dcsj='" + dcsj + "',dcname='" + dcname + "' ");
                    return ResultUtil.success("调查信息修改成功");
                }
            }else{
                return ResultUtil.success("您没有权限发起血液透析调查");
            }

        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**
     * 删除血液透析调查
     */
    @ApiOperation(value = "删除血液透析调查")
    @GetMapping("/delHh")
    public ResultUtil delHh(String dcgid, HttpServletRequest request) {
        SysUser user = (SysUser)request.getSession().getAttribute("user");
        String code = user.getCode();
        String rolename = handle1Dao.selectSqlWithSQLStr("SELECT  a.role_name  FROM hr_sys_user_vs_role a, hr_sys_user b WHERE a.user_id=b.id AND b.code='"+code+"'");
        try {
            if(rolename!=null && !"".equals(rolename)&&(("超级管理员").equals(rolename) || ("院感科组").equals(rolename) )){
                hrTgrXytxDao.delHh(dcgid);
                handle1Dao.deleteSqlWithSQL("delete from txytxname where dcgid='" + dcgid + "' ");
                return ResultUtil.success("删除血液透析调查成功");
            }else{
                return ResultUtil.success("您没有权限删除血液透析调查");
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**
     * 根据条件查询血液透析项目
     */
    @ApiOperation(value = "根据条件查询血液透析项目")
    @GetMapping("/findPrByTime")
    public ResultUtil findPrByTime(String dcsj) {
        List<Map<String, Object>> lis = null;
        try {
            lis= handle1Dao.selectSqlWithSQL("select * from txytxname where dcsj like '%" + dcsj + "%'");
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(lis);
    }

    /**
     * 根据条件查询血液透析信息
     */
    @ApiOperation(value = "根据条件查询血液透析信息")
    @GetMapping("/findBySerch")
    public ResultUtil findBySerch(PageInfo pageInfo, @RequestParam Map<String, Object> paramst) {
        String dcgid = paramst.get("dcgid").toString();
        String zyh = paramst.get("zyh").toString();
        String status = paramst.get("status").toString();
        List<TgrXytxEntity> lis = null;
        try {
            lis = hrTgrXytxDao.findBySerch(dcgid, zyh, status);
            //lis = hrTgrBlmDao.findBySerch(dcgid, zyh, ksname, status, code);
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
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(pageInfo);
    }
    /**------------------------------------血液透析调查左侧结束---------------------------------*/
    /**------------------------------------血液透析病人信息开始---------------------------------*/
    /**
     * 增加单个病人调查信息
     */
    @ApiOperation(value = "增加单个病人调查信息")
    @GetMapping("/addSingle")
    public ResultUtil addSingle(String dcgid, String zyh) {
        List<Map<String, Object>> lis = null;
        try {
            if (hrTgrXytxDao.findByzyh(dcgid, zyh).size() > 0) {
                return ResultUtil.success("病人已经参与本次调查");
            } else {
                lis = handle1Dao.selectSqlWithSQL("SELECT TOP 1 a.zyh,hzxm ,CONVERT(varchar(10),hznl)hznl,Nldw,hzxb,Ryzd\n" +
                        " from HIS_rybr a, HIS_zkxx_js b WHERE a.blh =b.blh  and a.zyh ='" + zyh + "'  order by b.rksj DESC");
                return ResultUtil.success(lis);
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**
     * 保存病人调查信息
     */
    @ApiOperation(value = "修改/保存病人调查信息")
    @PostMapping("/saveBrInfo")
    public ResultUtil saveBrInfo(@RequestBody  Map jsonObject) {
        TgrXytxEntity tgrXytxEntity =new  TgrXytxEntity();

        String  sgid = (jsonObject.get("gid")+"").replace("null","");
        String  dcgid = jsonObject.get("dcgid")+"";
        String gid="";
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if(sgid ==null || "".equals(sgid)){
                gid=IdUtil.randomUUID();
                tgrXytxEntity.setGid(gid);
                tgrXytxEntity.setDcgid(dcgid);
                tgrXytxEntity.setZyh(jsonObject.get("zyh")+"");
                tgrXytxEntity.setHznl(jsonObject.get("hznl")+"");
                tgrXytxEntity.setNldw(jsonObject.get("nldw")+"");
                tgrXytxEntity.setHzxm(jsonObject.get("hzxm")+"");
                tgrXytxEntity.setHzxb(jsonObject.get("hzxb")+"");
                tgrXytxEntity.setRyzd(jsonObject.get("ryzd")+"");
            }else{
                gid=sgid;
                tgrXytxEntity =hrTgrXytxDao.findByGid(dcgid,gid);
            }
            tgrXytxEntity.setZdbm(jsonObject.get("zdbm")+"");
            tgrXytxEntity.setKssj(jsonObject.get("kssj")+"");
            tgrXytxEntity.setHscount(jsonObject.get("hscount")+"");
            tgrXytxEntity.setPlcount(jsonObject.get("plcount")+"");
            tgrXytxEntity.setXttype(jsonObject.get("xttype")+"");
            tgrXytxEntity.setIsyggr(jsonObject.get("isyggr")+"");
            tgrXytxEntity.setIsbggr(jsonObject.get("isbggr")+"");
            tgrXytxEntity.setIsazgr(jsonObject.get("isazgr")+"");
            tgrXytxEntity.setIsmdgr(jsonObject.get("ismdgr")+"");
            tgrXytxEntity.setIsfr(jsonObject.get("isfr")+"");
            tgrXytxEntity.setIskjy(jsonObject.get("iskjy")+"");
            tgrXytxEntity.setIsccgr(jsonObject.get("isccgr")+"");
            tgrXytxEntity.setIsxlgr(jsonObject.get("isxlgr")+"");
            tgrXytxEntity.setIsxggr(jsonObject.get("isxggr")+"");
            tgrXytxEntity.setIsfbgr(jsonObject.get("isfbgr")+"");
            tgrXytxEntity.setDcrmc(jsonObject.get("dcrmc")+"");
            tgrXytxEntity.setDcrq(jsonObject.get("dcrq")+"");
            tgrXytxEntity.setCjrq(df.format(t)+"");
            tgrXytxEntity.setIsconfirm("0");
            if(sgid ==null || "".equals(sgid)){
                hrTgrxytxService.insert(tgrXytxEntity);
            }else{
                hrTgrxytxService.update(tgrXytxEntity);
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
            TgrXytxEntity tgrXytxEntity = hrTgrXytxDao.findByGid(dcgid,gid);
            maps.put("gid",tgrXytxEntity.getGid());
            maps.put("dcgid",tgrXytxEntity.getDcgid());
            maps.put("zyh",tgrXytxEntity.getZyh());
            maps.put("hzxm",tgrXytxEntity.getHzxm());
            maps.put("hzxb",tgrXytxEntity.getHzxb());
            maps.put("hznl",tgrXytxEntity.getHznl());
            maps.put("nldw",tgrXytxEntity.getNldw());
            maps.put("ryzd",tgrXytxEntity.getRyzd());
            maps.put("zdbm",tgrXytxEntity.getZdbm());
            maps.put("kssj",tgrXytxEntity.getKssj());
            maps.put("hscount",tgrXytxEntity.getHscount());
            maps.put("plcount",tgrXytxEntity.getPlcount());
            maps.put("xttype",tgrXytxEntity.getXttype());
            maps.put("isyggr",tgrXytxEntity.getIsyggr());
            maps.put("isbggr",tgrXytxEntity.getIsbggr());
            maps.put("isazgr",tgrXytxEntity.getIsazgr());
            maps.put("ismdgr",tgrXytxEntity.getIsmdgr());
            maps.put("isfr",tgrXytxEntity.getIsfr());
            maps.put("iskjy",tgrXytxEntity.getIskjy());
            maps.put("isccgr",tgrXytxEntity.getIsccgr());
            maps.put("isxlgr",tgrXytxEntity.getIsxlgr());
            maps.put("isxggr",tgrXytxEntity.getIsxggr());
            maps.put("isfbgr",tgrXytxEntity.getIsfbgr());
            maps.put("dcrmc",tgrXytxEntity.getDcrmc());
            maps.put("cjrq",tgrXytxEntity.getCjrq());
            maps.put("isconfirm",tgrXytxEntity.getIsconfirm());
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
                hrTgrXytxDao.delByGid(gid);
                return ResultUtil.success("删除患者信息成功");
            }else{
                return ResultUtil.success("您没有权限删除患者信息");
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getCause().toString());
        }
    }
    /**------------------------------------血液透析病人信息结束---------------------------------*/
    /**------------------------------------血液透析病人信息审核流程开始---------------------------------*/
    /**
     * 批量审核操作
     * 参数gids：选中的病人的gid通过，拼接
     */

    @ApiOperation(value = "血液透析批量审核 参数gids：选中的病人的gid通过，拼接")
    @GetMapping("/plShPR")
    public ResultUtil plShPR(String status, String gids) {
        try {
            if (gids.indexOf(",") > 0) {
                String[] gid = gids.split(",");
                for (int i = 0; i < gid.length; i++) {
                    hrTgrXytxDao.updateStatus(status, gid[i]);
                }
                return ResultUtil.success("批量审核成功");
            } else {
                hrTgrXytxDao.updateStatus(status, gids);
                return ResultUtil.success("批量审核成功");
            }
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.success(e.getCause().toString());
        }
    }
    /**------------------------------------血液透析病人信息审核流程结束---------------------------------*/
    /**------------------------------------血液透析病人信息字典信息开始---------------------------------*/
    /**
     * 标准疾病诊断
     */
    @ApiOperation(value = "标准疾病诊断")
    @GetMapping("/getJbStandard")
    public ResultUtil getJbStandard() {
        List<Map<String, Object>> lis = null;
        try {
            lis = handle1Dao.selectSqlWithSQL("select * from txytx_bzzd");
        } catch (Exception e) {
            logger.error(e + LineBreak);
        }
        return ResultUtil.success(lis);
    }

    /**------------------------------------血液透析病人信息字典信息结束---------------------------------*/

    @ApiOperation(value = "导出血液透析数据", notes = "导出现血液透析数据")
    @GetMapping("/exportXhl")
    @ResponseBody
    public void exportXhl(@RequestParam(value = "dcgid",required = true) String dcgid, HttpServletResponse response) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String dcsj = handle1Dao.excuteSqlWithSQL("select dcsj from txytxname where dcgid='"+dcgid+"'");
            Date parse = dateFormat.parse(dcsj);
            Calendar c = Calendar.getInstance();
            c.setTime(parse);
            c.add(Calendar.DATE, -1);
            String kssj = dateFormat.format(c.getTime());
//            hrTgrBlmDao.xhlSh(kssj, dcsj);
            List<String> headers = new ArrayList<>();
            headers.add("状态");
            headers.add("编号");//这里的表头，根据数据的字段命名也行，随你喜欢
            headers.add("患者姓名");
            headers.add("患者性别");
            headers.add("患者年龄");
            headers.add("年龄单位");
            headers.add("诊断名称");
            headers.add("开始血液透析时间");
            headers.add("曾在几所医院接受过血液透析治疗");
            headers.add("调查人名称");
            headers.add("调查日期");
            List<TgrXytxEntity> datas = hrTgrXytxDao.findByDcGid(dcgid);
            List<String[]> operateListStr = new ArrayList<>();
            for (int i = 0; i < datas.size(); i++) {
                TgrXytxEntity data = datas.get(i);
                String[] strarr = new String[]{
                        (StringUtils.isEmpty(data.getIsconfirm()) ? "" : data.getIsconfirm().equals("1")?"已审核":data.getIsconfirm().equals("0")?"已编辑":"未编辑"),
                        (StringUtils.isEmpty(data.getZyh()) ? "" : data.getZyh()),
                        (StringUtils.isEmpty(data.getHzxm()) ? "" : data.getHzxm()),
                        (StringUtils.isEmpty(data.getHzxb()) ? "" : data.getHzxb()),
                        (StringUtils.isEmpty(data.getHznl()) ? "" : data.getHznl()),
                        (StringUtils.isEmpty(data.getNldw()) ? "" : data.getNldw()),
                        (StringUtils.isEmpty(data.getZdbm()) ? "" : "1".equals(data.getZdbm())?"慢性肾衰竭":"急性肾衰竭"),
                        (StringUtils.isEmpty(data.getKssj()) ? "" : data.getKssj()),
                        (StringUtils.isEmpty(data.getHscount()) ? "" : data.getHscount()),
                        (StringUtils.isEmpty(data.getPlcount()) ? "" : data.getPlcount()),
                        (StringUtils.isEmpty(data.getDcrmc()) ? "" : data.getDcrmc()),
                        (StringUtils.isEmpty(data.getDcrq()) ? "" : data.getDcrq())
                };
                operateListStr.add(strarr);
            }
            String strTableName = "医院血液透析数据"; //这个是标题
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
