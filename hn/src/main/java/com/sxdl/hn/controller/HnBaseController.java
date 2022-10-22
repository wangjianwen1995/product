package com.sxdl.hn.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.base.service.SysDictTableService;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.GetDataFromApp;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.entity.Hnpatientinfo;
import com.sxdl.hn.service.HnBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = "护理基础模块")
@RestController
@RequestMapping("/hnBase")
public class HnBaseController {


    @Autowired
    private HnBaseService baseService;

    @Autowired
    private SysDictValService dcDitValService;
    @Autowired
    private SysDictTableService dcDitTableService;


    @Autowired
    private HnHandleDao hnHandleDao;


    @ApiOperation(value = "查询患者信息")
    @GetMapping("/findhzinfo")
    public ResultUtil findhzinfo(PageInfo pageInfo,
                                 @RequestParam(value = "kscode", required = false) String kscode,
                                 @RequestParam(value = "zyhOrname", required = false) String zyhOrname) {
        Map<String, Object> listPage = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select top 100 * from hnpatientinfo where 1=1 ");
            if (!StringUtils.isEmpty(kscode)) {
                sb.append(" and ry_code='" + kscode + "' ");
            }
            if (!StringUtils.isEmpty(zyhOrname)) {
                sb.append(" and ( zyh like '%" + zyhOrname + "%' or name like '%" + zyhOrname + "%' ) ");
            }
            sb.append(" order by ry_time desc ");
            String sql = sb.toString();
            List<Hnpatientinfo> hzxx = hnHandleDao.findHzxx(sql);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hzxx);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(listPage);
    }

    //根据表名查询字典表值信息
    @ApiOperation(value = "查询", notes = "根据条件查询字典表值信息")
    @GetMapping("/findByFactor")
    public ResultUtil findByfactor(  @RequestParam(value = "dict_id", defaultValue = "") Integer dict_id) {
        List<SysDictVal> dcDitVals = new ArrayList<>();
        try {
             dcDitVals = GetDataFromApp.findDcDitVals ( dict_id );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
        return ResultUtil.success ( dcDitVals );
    }


    /**
     * 消息提示
     *
     *
     */
    @ApiOperation(value = "提示信息 院级考核")
    @GetMapping("/getWarningYj")
    public ResultUtil getWarningYj( @RequestParam(value = "code" ,required = true) String code ){
        List<LinkedHashMap<String, String>> warning = new ArrayList<>();
        try {
            warning = baseService.getWarningYj(code);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(warning);
    }

    @ApiOperation(value = "提示信息 科级考核")
    @GetMapping("/getWarningKs")
    public ResultUtil getWarningKs( @RequestParam(value = "code" ,required = true) String code ){
        List<LinkedHashMap<String, String>> warning = new ArrayList<>();
        try {
            warning = baseService.getWarningKj(code);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(warning);
    }

    /**
     * 这里的数据到时候要修改成 查询缓存中的数据
     * @return
     */
    @ApiOperation(value = "根据姓名或者代码 查询 护士")
    @GetMapping("/findNurseBynameOrCode")
    public ResultUtil findNurseBynameOrCode(  PageInfo pageInfo, @RequestParam(value = "kscode" ,required = false,defaultValue = "") String kscode,
                                            @RequestParam(value = "val",required = false,defaultValue = "") String val){
        Map<String, Object> listPage =null;
        try {
            List<SysUser> list  = baseService.findNurseBynameOrCode(kscode,val);
             listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(listPage);
    }

    /**
     * 这里的数据到时候要修改成 查询缓存中的数据
     * @return
     */
    @ApiOperation(value = "查看所有护士")
    @GetMapping("/findAllNurse")
    public ResultUtil findAllNurse(){
        List<SysUser> list = new ArrayList<>();
        try {
            list = baseService.findAllNurse();
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(list);
    }


    /**
     * 这里的数据到时候要修改成 查询缓存中的数据
     * @return
     */
    @ApiOperation(value = "查看所有科室")
    @GetMapping("/findAllKs")
    public ResultUtil findAllKs(){
        //List<SysKs> list = new ArrayList<>();
        List<Map<String, Object>> kss =new ArrayList<>();
        try {
             kss =hnHandleDao.selectSqlWithSQL("select * from sys_ks where is_on=1");
             //list = baseService.findAllKs();
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(kss);
    }


    /**
     * 这里的数据到时候要修改成 查询缓存中的数据
     * @return
     */
    @ApiOperation(value = "查询所属科室")
    @GetMapping("/findPlaceKs")
    public ResultUtil findPlaceKs(@RequestParam(value = "usrid" ,required = true) Integer userid){
        SysUser user = new SysUser();
        try {
            user = baseService.findPlaceKs(userid);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(user);
    }

    /**
     * 这里的数据到时候要修改成 查询缓存中的数据
     * @return
     */
    @ApiOperation(value = "修改所属科室")
    @GetMapping("/updatePlaceKs")
    public ResultUtil updatePlaceKs(@RequestParam(value = "usrid" ,required = true) Integer userid,
                                    @RequestParam(value = "kscode" ,required = true) String kscode,
                                    @RequestParam(value = "ksname" ,required = true) String ksname){
        try {
            Integer integer = baseService.updatePlaceKs(userid,kscode,ksname);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功,请重新登录");
    }

    /**
     * 这里 护理部/管理员查询科室的时候是全部科室, 其他人员都是可看科室的权限
     * @param userid
     * @return
     */
    @ApiOperation(value = "查询可看科室")
    @GetMapping("/findCanseeKs")
    public ResultUtil findCanseeKs(@RequestParam(value = "usrid" ,required = true) Integer userid){
        //List<SysKs> list = new ArrayList<>();
        List<SysUserVsRole> roles = baseService.findroleByuserid(userid);

        List<Map<String, Object>> kss = new ArrayList<Map<String, Object>>();
        try {
            if(roles.size()>0){
               if( roles.get(0).getRole_name().equals("超级管理员")|| roles.get(0).getRole_name().equals("护理部")){
                   kss =hnHandleDao.selectSqlWithSQL("select * from sys_ks where is_on=1");
               }else{
                   kss = baseService.findCanseeKs(userid);
               }
            }else{
                return   ResultUtil.error("该人员没有对应权限");
            }
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(kss);
    }

    @ApiOperation(value = "根据科室获取菜单内容", notes = "根据科室获取菜单内容")
    @GetMapping("/findByKsId")
    @ResponseBody
    public ResultUtil findByKsId(PageInfo pageInfo, String name) {
        List<Map<String, Object>> sysKsList = new ArrayList<Map<String, Object>>();
        try {
            sysKsList = hnHandleDao.selectSqlWithSQL("select * from sys_ks where is_on=1");
            if (null != name && !"".equals(name)) {
                //sysKsList = sysKsList.stream().filter(e -> e != null && null != e.getName() && null != e.getCode() && (e.getName().contains(name) || e.getCode().equals(name))).collect(Collectors.toList());
                sysKsList = hnHandleDao.selectSqlWithSQL("select * from sys_ks where  is_on =1 and (name like '%"+name +"%' or code like '%"+name+"%' )");
            }
            //sysKsList.sort(Comparator.comparing(SysKs::getIs_on).reversed());
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(sysKsList);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), sysKsList);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据医院科室组id获取详细内容", notes = "根据医院科室组id获取详细内容")
    @GetMapping("/findAllBySysGroupKs")
    @ResponseBody
    public ResultUtil findAllBySysGroupKs() {

        try {
            List<Map<String,Object>> sysGroupKsList = hnHandleDao.selectSqlWithSQL("select * from dbo.sys_group_ks");
            Map<String, Object> kssss;
            if (null == sysGroupKsList || sysGroupKsList.size() <= 0) {
                List<Map<String,Object>> sysKs = hnHandleDao.selectSqlWithSQL("select * from dbo.sys_ks where  is_on =1");
                Map<String, Object> maps = new HashMap<String,Object>();
                for (Map<String, Object> stringObjectMap : sysKs) {
                    kssss = new HashMap<>();
                    kssss.put("name", stringObjectMap.get("name"));
                    kssss.put("code", stringObjectMap.get("code"));
                    sysGroupKsList.add(kssss);
                    //maps.put((String) stringObjectMap.get("name"),stringObjectMap.get("code"));
                }
            }
            return ResultUtil.success(sysGroupKsList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据院区id获取院区内容", notes = "根据院区id获取院区内容")
    @GetMapping("/findBySysYqId")
    @ResponseBody
    public ResultUtil findBySysYqId(Integer id) {

        try {
            if (id != null && !id.equals ( "" ) && id > 0) {
                List<Map<String,Object>> lists = hnHandleDao.selectSqlWithSQL("select * from dbo.sys_yq where id ="+id+ " ");
                return ResultUtil.success ( lists );
            }
            List<Map<String,Object>> lists = hnHandleDao.selectSqlWithSQL("select * from dbo.sys_yq");
            return ResultUtil.success ( lists );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }



}
