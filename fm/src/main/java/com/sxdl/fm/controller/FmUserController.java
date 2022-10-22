package com.sxdl.fm.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.controller.SysUserController;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.SysUserService;
import com.sxdl.base.util.*;
import com.sxdl.fm.entity.FmKhdy;
import com.sxdl.fm.entity.FmUser;
import com.sxdl.fm.service.FmKhdyService;
import com.sxdl.fm.service.FmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("fmuser")
public class FmUserController extends SysUserController {
    @Autowired
    FmUserService fmUserService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    FmKhdyService fmKhdyService;
    FmUser fmUser;
    SysUser sysUser;
    List<FmUser> fmUserList;
    List<FmKhdy> khs;
    List<SysDictVal> valsTitle, valsPosition, valsTitleName;
    Map<String, Object> results;
   /**
     * app端用户登录
     *
     * @param gh 如题
     * @param pwd 如题
     */
    @GetMapping("loginApp")
    public ResultUtil loginApp(String gh, String pwd) {
        fmUser = new FmUser();
        fmUser.setCode(gh);
        fmUser.setPwd(MD5Util.toMD5(gh + pwd));
        fmUserList = fmUserService.select(fmUser);
        if (null == fmUserList || fmUserList.size() == 0) return ResultUtil.error("帐号密码错误");
        fmUser = fmUserList.get(0);
//        if(2==fmUser.getStatus() ||fmUser.getTitleLev()<)
        return ResultUtil.success(fmUser);
    }

    @PutMapping("updatePWD")
    public ResultUtil updatePWD(String gh,String pwd,String pwdNew){
        fmUser = new FmUser();
        fmUser.setCode(gh);
        fmUser.setPwd(MD5Util.toMD5(gh + pwd));
        fmUserList = fmUserService.select(fmUser);
        if (null == fmUserList || fmUserList.size() == 0) return ResultUtil.error("原密码错误");
        fmUser = fmUserList.get(0);
        fmUser.setPwd(MD5Util.toMD5(gh + pwdNew));
        fmUserService.update(fmUser);
        sysUser=new SysUser();
        sysUser.setCode(gh);
        sysUser.setPwd(MD5Util.toMD5(gh + pwd));
        sysUser= sysUserService.selectOne(sysUser);
        sysUser.setPwd(MD5Util.toMD5(gh + pwdNew));
        sysUserService.update(sysUser);
        return ResultUtil.success("修改成功！");
    }
    @GetMapping("/findList")
    @ResponseBody
    public ResultUtil findAll(PageInfo pageInfo, String name) {
        fmUser = new FmUser();
        fmUser.setStatus(2);
        fmUserList = fmUserService.select(fmUser);
        if (StringUtil.isNotEmpty(name))
            fmUserList = fmUserList.stream().filter(e -> e.getName().contains(name) || name.equals(e.getKs_name()) || name.equals(e.getLogin_name()) || name.equals(e.getCode())).collect(Collectors.toList());
        results = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), fmUserList );
        return ResultUtil.success(results);
    }

    @GetMapping("getInfos")
    public ResultUtil getInfos() {
        results = new HashMap<>();
        Map<Integer, List<SysDictVal>> dvOnMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("dvOnMap");
        if(dvOnMap.containsKey(15)||dvOnMap.containsKey(16)||dvOnMap.containsKey(17))
        valsTitle = dvOnMap.get(15);//fm_title
        results.put("titels", valsTitle);
        valsPosition = dvOnMap.get(16);//fm_position
        results.put("positions", valsPosition);
        valsTitleName = dvOnMap.get(17);//fm_title_name
        results.put("titelNames", valsTitleName);
        khs = fmKhdyService.findAll();
        khs = khs.stream().filter(e -> e.getIson() == 1).collect(Collectors.toList());
        results.put("khs", khs);
        return ResultUtil.success(results);
    }
    @GetMapping("updateFmuser")
    public ResultUtil updateFmuser(@RequestParam Integer id){
        sysUser=sysUserService.findById(id);
        fmUser=matchFmUser(sysUser);
        fmUserService.update(fmUser);
        return ResultUtil.success(fmUser);
    }
    @PostMapping("add")
    public ResultUtil add(FmUser user) {
        fmUser=new FmUser();
        fmUser.setName(user.getName());
        fmUser.setCode(user.getCode());
        fmUserList= fmUserService.select(fmUser);
        if(fmUserList.size()>0) return ResultUtil.error("已存在当前用户!请勿重复添加");
        user.setPwd(MD5Util.toMD5(user.getCode() + "123"));
        user.setUpdate_time(LocalDateTime.now().toString());
        fmUserService.insert(user);
        sysUser = matchUser(user);
        sysUserService.insert(sysUser);
        return ResultUtil.success("");
    }

    @PostMapping("update")
    public ResultUtil update(@RequestBody FmUser user) {
        if(null== user.getId()||user.getId()<1) return  ResultUtil.error("ID不能为空");
        fmUser=fmUserService.findById(user.getId());
        fmUser.setKhdyId(user.getKhdyId());
        fmUser.setKhdyName(user.getKhdyName());
        fmUser.setTitle(user.getTitle());
        fmUser.setTitleLev(user.getTitleLev());
        fmUser.setTitleName(user.getTitleName());
        fmUser.setTitleNameId(user.getTitleNameId());
        fmUser.setPosition(user.getPosition());
        fmUser.setPositionId(user.getPositionId());
        fmUser.setUpdate_time(LocalDateTime.now().toString());
        fmUserService.update(fmUser);
        sysUser = matchUser(user);
        sysUserService.update(sysUser);
        return ResultUtil.success("修改成功");
    }

    /**
     * 传入FM用户,匹配成SYS用户
     *
     * @param user 如题
     */
    public SysUser matchUser(FmUser user) {
        sysUser = new SysUser();
        sysUser.setName(user.getName());
        sysUser.setPwd(user.getPwd());
        sysUser.setCode(user.getCode());
        sysUser.setLogin_name(user.getLogin_name());
        sysUser.setTitle(user.getTitle());
        sysUser.setPosition(user.getPosition());
        sysUser.setYq_id(user.getYq_id());
        sysUser.setYq_name(user.getYq_name());
        sysUser.setKs_id(user.getKs_id());
        sysUser.setKs_name(user.getKs_name());
        sysUser.setStaff_type(user.getStaff_type());
        sysUser.setUpdate_time(user.getUpdate_time());
        sysUser.setStaff_id(user.getStaff_id());
        sysUser.setImg(user.getImg());
        sysUser.setKk_ks(user.getKk_ks());
        sysUser.setKk_standard(user.getKk_standard());
        sysUser.setParent_id(user.getParent_id());
        sysUser.setStatus(user.getStatus());
        return sysUser;
    }/**
     * 传入SYS用户,匹配成FM用户
     *
     * @param user 如题
     */
    public FmUser matchFmUser(SysUser user) {
        fmUser = fmUserService.findById(user.getId());
        fmUser.setName(user.getName());
        fmUser.setPwd(user.getPwd());
        fmUser.setCode(user.getCode());
        fmUser.setLogin_name(user.getLogin_name());
        fmUser.setTitle(user.getTitle());
        fmUser.setPosition(user.getPosition());
        fmUser.setYq_id(user.getYq_id());
        fmUser.setYq_name(user.getYq_name());
        fmUser.setKs_id(user.getKs_id());
        fmUser.setKs_name(user.getKs_name());
        fmUser.setStaff_type(user.getStaff_type());
        fmUser.setUpdate_time(user.getUpdate_time());
        fmUser.setStaff_id(user.getStaff_id());
        fmUser.setImg(user.getImg());
        fmUser.setKk_ks(user.getKk_ks());
        fmUser.setKk_standard(user.getKk_standard());
        fmUser.setParent_id(user.getParent_id());
        fmUser.setStatus(user.getStatus());
        return fmUser;
    }

}
