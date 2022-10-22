package com.sxdl.hn.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.entity.HnBasicInfo;
import com.sxdl.hn.service.PersonnelFilesService;
import com.sxdl.hn.util.FileUploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "护理人员档案")
@RestController
@RequestMapping("/personnelFiles")
public class PersonnelFilesController {

    @Autowired
    private PersonnelFilesService filesService;

    @Autowired
    HnHandleDao hnHandleDao;

    /**'
     *
     * @param pageInfo
     * @param
     * @param stime
     * @param etime
     * @param isadmin  1 护理部  -1 护士  2 护士长
     * @param allkscodes
     * @param ks_id  当前登录人所属科室
     * @param kscode 页面选择的科室
     * @param logincode 登录工号
     * @param  state 是否离职 默认没有
     */

    @ApiOperation(value = "查询数据")
    @GetMapping("/findpersonnels")
    public ResultUtil findpersonnels(PageInfo  pageInfo,
                                     @RequestParam(value = "stime" ,required = false) String stime,
                                     @RequestParam(value = "etime" ,required = false) String etime,
                                     @RequestParam(value = "isadmin",required = true) Integer isadmin,
                                     @RequestParam(value = "allkscodes",required = false,defaultValue = "") String  allkscodes,
                                     @RequestParam(value = "ks_id",required = false,defaultValue = "") String  ks_id,
                                     @RequestParam(value = "kscode",required = false) String kscode,
                                     @RequestParam(value = "logincode",required = true) String logincode,
                                     @RequestParam(value = "state",required = false,defaultValue = "1") Integer state,
                                     @RequestParam(value = "nowtitle",required = false) String nowtitle,
                                     @RequestParam(value = "maxeducation",required = false) String maxeducation){
        Map<String, Object> listPage =null;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(" select a.* from basic_info a ");
            if(StringUtils.isEmpty(kscode)){ //没有选择科室
                if(isadmin.equals(1)){ //  没有选择了科室 and  是护理部  -->看全部
                    sb.append("   ");
                }else if(isadmin.equals(2)){ // 没有选择了科室 and  是护士长 -->看可看科室
                    sb.append(" where  a.ks_code in (  select b.ks_id FROM dbo.sys_user a,sys_user_vs_ks b where a.id =b.user_id and  " +
                            "login_name ='"+logincode+"') " );
                }else if(isadmin.equals(-1)){ // 没有选择了科室 and  是普通护士  -->看自己
                    sb.append(" where a.logincode ='"+logincode+"'");
                }
            }else{  //选择了科室
                if(isadmin.equals(1)){ //   选择了科室 and  是护理部  -->看这个科室
                    sb.append(" where  a.ks_code in (  " +kscode +") " );
                }else if(isadmin.equals(2)){ // 选择了科室 and  是护士长 -->看这个科室
                    sb.append(" where  a.ks_code in (  " +kscode +") " );
                }else if(isadmin.equals(-1)){ // 选择了科室 and  是普通护士  -->看自己
                    sb.append(" where a.logincode ='"+logincode+"'");
                }
            }
            // 是否离职
            if(StringUtils.isEmpty(state) || state.equals(1)){
                if(!sb.toString().contains("where")){
                    sb.append(" where  a.leave_whether = 1 ");
                }else{
                    sb.append(" and a.leave_whether = 1 ");
                }
            }else{
                if(!sb.toString().contains("where")){
                    sb.append(" where  a.leave_whether = -1 ");
                }else{
                    sb.append(" and a.leave_whether = -1 ");
                }
            }
            //是否选择了  inauguration_time 查询时候
            if(!StringUtils.isEmpty(stime)&& !StringUtils.isEmpty(etime)){
                sb.append(" and a.inauguration_time between '"+stime+"' and  '"+etime+"' ");
            }

            if(!StringUtils.isEmpty(nowtitle)){ //现职称
                sb.append(" and nowtitle = '"+ nowtitle+"' ");
            }
            if(!StringUtils.isEmpty(maxeducation)){//最高学历
                sb.append(" and maxeducation = '"+ maxeducation+"' ");
            }
            String sql = sb.toString();
            List<HnBasicInfo> list = filesService.findbySql(sql);
            listPage =  PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
            List<HnBasicInfo> list1 = (List<HnBasicInfo>)listPage.get("list");
            if(!StringUtils.isEmpty(list1)){
                for (HnBasicInfo hnBasicInfo : list1) {
                    filesService.setchildren(hnBasicInfo);
                }
            }else{
                return ResultUtil.success(null);
            }
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(listPage);
    }


    @ApiOperation(value = "文件上传")
    @PostMapping("/fileupload")
    public ResultUtil fileupload(@RequestParam("file")  MultipartFile file,
                                 @RequestParam(value = "pathUrl" ,required = true) String pathUrl,
                                 @RequestParam(value = "name" ,required = true) String name ){
        Map<String,String> maps = new HashMap<>();
        try {
            String craetapath = "files"+ "\\"+pathUrl+"\\";
            String returnUrl = FileUploadUtil.fileSave(file, name, craetapath);
            String  Filename = file.getOriginalFilename();
            maps.put("fileName",Filename);
            maps.put("filePath",returnUrl);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(maps);
    }




    @ApiOperation(value = "取消时,删除已经上传的文件")
    @PostMapping("/deletefiles")
    public ResultUtil deletefiles(@RequestBody List<String> list){
        try {
            for (String filePath : list) {
                FileUploadUtil.deleteFile(filePath);
            }
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("未保存的文件已被删除");
    }


    @ApiOperation(value = "删除已经上传的文件")
    @GetMapping("/deletefile")
    public ResultUtil deleteFile(@RequestParam (value="filepath" , required = true) String filepath){
        try {
            boolean b = FileUploadUtil.deleteFile(filepath);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("未保存的文件已被删除");
    }

    @ApiOperation(value = "保存修改")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HnBasicInfo basicInfo){
        Integer integer=null;
        try {
            if(basicInfo.getKs_code()  ==null ||  "".equals(basicInfo.getKs_code())){
                String ks_code = hnHandleDao.selectSqlWithSQLStr("SELECT ks_id FROM dbo.sys_user WHERE login_name =" + basicInfo.getLogincode());
                basicInfo.setKs_code(ks_code);
            }
            if (StringUtils.isEmpty(basicInfo.getId())){
                integer =  filesService.save(basicInfo);
            }else {
                integer = filesService.update(basicInfo);
            }
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }
    @ApiOperation(value = "离职")
    @GetMapping("/updatestate")
    public ResultUtil updatestate(@RequestParam(value = "id",required = true) Integer id,
                             @RequestParam(value = "state",required = true) Integer state){
        Integer integer=null;
        try {
            integer =  filesService.updatestate(id,state);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }

    //删除技术档案信息
    @ApiOperation(value = "删除", notes = "删除离职人员技术档案信息")
    @GetMapping("/delete")
    public ResultUtil<HnBasicInfo> delete(@RequestParam(value = "id") Integer id, @RequestParam(value = "isadmin",required = true) Integer isadmin) {
        try {
            if(!isadmin.equals(1)){
                return ResultUtil.success("护理部可以删除，其它角色不允许删除");
            }else{
                Integer num =  filesService.delete(id);
                return ResultUtil.success("删除离职人员技术档案信息成功");
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }





}
