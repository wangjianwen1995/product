package com.sxdl.base.controller;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsKs;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.base.service.SysUserService;
import com.sxdl.base.service.SysUserVsKsService;
import com.sxdl.base.service.SysUserVsRoleService;
import com.sxdl.base.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired

    private SysUserVsRoleService sysUserVsRoleService;
    @Autowired
    private SysUserVsKsService sysUserVsKsService;

    @Value("${server.application.name}")
    private String productName;
    private JSONObject j;

    @ApiOperation(value = "查所有", notes = "查所有")
    @GetMapping("/findAll")
    @ResponseBody
    public ResultUtil findAll(PageInfo pageInfo, String name) {

        try {
            //PageInfo<List<SysUser>> list = sysUserService.queryPageList ( pageInfo, new SysUser () );
            List<SysUser> userList = sysUserService.findAll();
            userList = userList.stream().filter(e -> e != null && null != e.getStatus() && e.getStatus().equals(2)).collect(Collectors.toList());
            if (null != name && !"".equals(name)) {
                userList = userList.stream().filter(e -> e != null && null != e.getKs_name() && null != e.getKs_id() &&  null !=e.getName() &&  null !=e.getKs_name() &&  null !=e.getKs_name()
                        &&  null !=e.getLogin_name() &&  null != e.getCode()
                        && (e.getLogin_name().equals(name) || e.getCode().equals(name) || e.getName().contains(name) || e.getKs_name().contains(name) || e.getKs_id().equals(name))).collect(Collectors.toList());
            }
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(userList);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), userList);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据用户id获取用户内容", notes = "根据用户id获取用户内容")
    @GetMapping("/findBySysUserId")
    @ResponseBody
    public ResultUtil findBySysUserId(@RequestParam(value = "id", required = true) Integer id) {

        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        SysUserVsRole sysUserVsRole = new SysUserVsRole();
        sysUserVsRole.setUser_id(id);
        SysUserVsKs sysUserVsKs = new SysUserVsKs();
        sysUserVsKs.setUser_id(id);
        try {
            SysUser sysUser1 = sysUserService.selectOne(sysUser);
            List<SysUserVsRole> userVsRoles = sysUserVsRoleService.select(sysUserVsRole);
            List<SysUserVsKs> ksList = sysUserVsKsService.select(sysUserVsKs);
            sysUser1.setRoles(userVsRoles);
            sysUser1.setKss(ksList);
            return ResultUtil.success(sysUser1);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存用户信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysUser sysUser) {
        if (sysUser == null) {
            return ResultUtil.error("没有数据要保存");
        }
        SysUser sysUser1 = new SysUser();
        try {
            Integer id = sysUser.getId();
            if ("".equals(id) || null == id) {
                //完全新增用户--会同时添加角色和所看科室信息
                sysUser1.setCode(sysUser.getCode());
                SysUser sysUser2 = sysUserService.selectOne(sysUser1);
                if (sysUser2 != null) {
                    //判断用户状态
                    if (null != sysUser2.getStatus() && sysUser2.getStatus().equals(1)) {
                        sysUser2.setStatus(2);
                        sysUser2.setPwd(toMD5(sysUser.getLogin_name() + "123"));
                        sysUser2.setUpdate_time(DateUtil.formatFromDate2(new Date()));
                        sysUser2.setKs_name(sysUser.getKs_name());
                        sysUser2.setKs_id(sysUser.getKs_id());
                        sysUser2.setYq_id(sysUser.getYq_id());
                        sysUser2.setYq_name(sysUser.getYq_name());
                        sysUser2.setLogin_name(sysUser.getLogin_name());
                        sysUser2.setName(sysUser.getName());
                        sysUser2.setUpdate_time(DateUtil.formatFromDate2(new Date()));
                        sysUserService.update(sysUser2);
                        return ResultUtil.success("操作成功");
                    }
                    return ResultUtil.error("该代码的用户已存在");
                }
                sysUser.setPwd(toMD5(sysUser.getLogin_name() + "123"));
                sysUser.setStatus(2);
                sysUserService.insertSysUser(sysUser);
            } else {
                //TODO
                SysUser sysUserOld = sysUserService.findById(id);
                if (sysUserOld != null && !sysUser.getLogin_name().equals(sysUserOld.getLogin_name())) {
                    sysUser1.setLogin_name(sysUser.getLogin_name());
                    SysUser sysUser2 = sysUserService.selectOne(sysUser1);
                    if (sysUser2 != null && sysUser2.getLogin_name() != null) {
                        return ResultUtil.error("该代码的用户已存在");
                    }
                    //如果修改 登录名 会重新初始化登录密码
                    sysUser.setPwd(toMD5(sysUser.getLogin_name() + "123"));
                }
                sysUserService.updateSysUser(sysUser);
            }
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysUser sysUser) {
        try {
            SysUser sysUser1 = sysUserService.selectOne(sysUser);
            if (null == sysUser1) {
                return ResultUtil.error("该用户不存在");
            }
            sysUser1.setStatus(1);
            sysUserService.update(sysUser1);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    //登录
    public static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcpG8DCdF58Ue8n6ikvfH0AXZTIMm95ELdi0BMPU827N69ERfphYqX7BNdc0KWYXc/bZYSAAmpWM2F7CWwzqYyYi4w1IPDDVYKGi77UJjIVS9t6Yz1J8842wKEepxulxjAnqL5cKdRabFF06HzvsrmJ9PmrvqouwIKgsfvV5WZdQIDAQAB";
    public static final String b = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANykbwMJ0XnxR7yfqKS98fQBdlMgyb3kQt2LQEw9Tzbs3r0RF+mFipfsE11zQpZhdz9tlhIACalYzYXsJbDOpjJiLjDUg8MNVgoaLvtQmMhVL23pjPUnzzjbAoR6nG6XGMCeovlwp1FpsUXTofO+yuYn0+au+qi7AgqCx+9XlZl1AgMBAAECgYEAutqyfMM62GdiVjZr7qBBoGAAoeOZliwSCGbeW/Jr/FrbQwiP1J7YQVKXD8QFty7xexDGT5YimHzxCKJ1ROeszFnMd9c3Blkl2W8EMYwIsxWuTWpLZQDFm0iJtHJH1LKZwr8XWnt4Ffjmg6CdzscK1ARJJTSgpYfB3D4o3op7eIECQQDxLA3XHsCndPoDnQKy0brNwXiGZk66ksWpxB3/8o3JeOYkPdgUhhbA0zrNfhAsUkNP0M1V8GFi0vwAEcMLxJ7VAkEA6jU/8bKj56bZnDXy1yNI0RSi74LZPNDLFC4lVPRy8dJKMujbXZWxh3maUPQS2xtHOq2P31bYkEB99op63BigIQJBAKSC+Znxl1djexw14V5bpIKwY+fCKBgrAHyylAhAy6lQOCUmrpwpb6HvNOByCtRA9Tuf4kGqLLQ92bquYw9G+1UCQHovGZLwTU3236P9CRlvkPdyuqYVL1vo2WlHwbYWaTj7KjZxALBL/ffdWsJM8uFX08sq7NnpJsXqv0w1Zm8YccECQDLW13qJ3rfMt1N2XCpD2BroJCXlJzHqF6jEhvtLXVFg1w24Mrf9COd2LaCz9f/SP90ybjMsaRILPr8F+Uc1XV4=";

    @GetMapping("islogin")
    public boolean islogin() {
        return StpUtil.isLogin();
    }

    //查询请求类型列表
    @ApiOperation(value = "登录验证", notes = "验证用户信息")
    @PostMapping("/login")
    @CrossOrigin
    @ResponseBody
    public ResultUtil login(@RequestBody Map<String, String> data, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String name = RsaUtil.decrypt(data.get("name"), b);
        String pwd = RsaUtil.decrypt(data.get("pwd"), b);
//        String pname = RsaUtil.decrypt(data.get("pwd"), b);
        SysUser dcUser1 = new SysUser();
        dcUser1.setLogin_name(name);
        dcUser1.setPwd(toMD5(name + pwd));
        dcUser1.setStatus(2);
        SysUser dcUser2 = null;
        try {
            dcUser2 = sysUserService.selectOne(dcUser1);
            if (dcUser2 == null) {
                return ResultUtil.error("账号或者密码错误");
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        boolean flag = (Boolean) ApplicationRunnerImpl.contextMap.get("verify");
        if (!flag) {
            return ResultUtil.error("请联系管理员重新注册!");
        }
        session.setAttribute("user", dcUser2);
        session.setAttribute("DevRequestParam", dcUser2.getLogin_name());
        StpUtil.login(dcUser2.getId());
        StpUtil.getSession(true).set("user",dcUser2);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        j = new JSONObject();
        j.putOpt("tokenName", "sxdl");
        j.putOpt("tokenValue", tokenInfo.getTokenValue());
        j.putOpt("SessionTimeout", tokenInfo.getSessionTimeout());
        j.putOpt("uid", dcUser2.getId());
        if (productName.indexOf("护理") != -1) {
            //这里有 admin 没有科室问题
            List<SysUserVsKs> byuserId = sysUserVsKsService.findByuserId(dcUser2.getId());
            List<SysUserVsRole> roles = sysUserVsRoleService.findByuserId(dcUser2.getId());
            List<String> allkscodes = sysUserVsKsService.findAllkscodes(dcUser2.getId(), dcUser2.getStaff_id());

            String kscodes = "";
            if (CollUtil.isNotEmpty(allkscodes)) {
                kscodes = String.join(",", allkscodes);
            }
            dcUser2.setRoles(roles);
            dcUser2.setKss(byuserId);
            Integer isadmin = -1;
            if (CollUtil.isNotEmpty(roles)) {
                for (SysUserVsRole e : roles) {
                    if ("超级管理员".equals(e.getRole_name()) || "护理部".equals(e.getRole_name()) || "管理员".equals(e.getRole_name())) {
                        isadmin = 1;
                    }
                }
            }
            dcUser2.setIsadmin(isadmin);
            dcUser2.setAllkscodes(kscodes);
            session.setAttribute("user", dcUser2);
            StpUtil.login(dcUser2.getId());
            //这里进行预警操作
            return ResultUtil.success(j, "登录成功");
        }
        session.setAttribute("user", dcUser2);
        return ResultUtil.success(j, "登录成功");
    }



    //查询请求类型列表
    @ApiOperation(value = "登录验证", notes = "验证用户信息")
    @GetMapping("/exteriorLogin/{lname}")
    @CrossOrigin
    @ResponseBody
    public ResultUtil exteriorLogin(@PathVariable String lname, HttpServletRequest request,HttpServletResponse response ) throws IOException {
        HttpSession session = request.getSession();

        SysUser dcUser1 = new SysUser();
        dcUser1.setLogin_name(lname);
        dcUser1.setStatus(2);
        SysUser dcUser2 = null;
        try {
            dcUser2 = sysUserService.selectOne(dcUser1);
            if (dcUser2 == null) {
                return ResultUtil.error("账号或者密码错误");
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        boolean flag = (Boolean) ApplicationRunnerImpl.contextMap.get("verify");
        if (!flag) {
            return ResultUtil.error("请联系管理员重新注册!");
        }
        session.setAttribute("user", dcUser2);
        session.setAttribute("DevRequestParam", dcUser2.getLogin_name());
        StpUtil.login(dcUser2.getId());
        StpUtil.getSession(true).set("user",dcUser2);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        j = new JSONObject();
        j.putOpt("tokenName", "sxdl");
        j.putOpt("tokenValue", tokenInfo.getTokenValue());
        j.putOpt("SessionTimeout", tokenInfo.getSessionTimeout());
        j.putOpt("uid", dcUser2.getId());
        if (productName.indexOf("护理") != -1) {
            //这里有 admin 没有科室问题
            List<SysUserVsKs> byuserId = sysUserVsKsService.findByuserId(dcUser2.getId());
            List<SysUserVsRole> roles = sysUserVsRoleService.findByuserId(dcUser2.getId());
            List<String> allkscodes = sysUserVsKsService.findAllkscodes(dcUser2.getId(), dcUser2.getStaff_id());

            String kscodes = "";
            if (CollUtil.isNotEmpty(allkscodes)) {
                kscodes = String.join(",", allkscodes);
            }
            dcUser2.setRoles(roles);
            dcUser2.setKss(byuserId);
            Integer isadmin = -1;
            if (CollUtil.isNotEmpty(roles)) {
                for (SysUserVsRole e : roles) {
                    if ("超级管理员".equals(e.getRole_name()) || "护理部".equals(e.getRole_name()) || "管理员".equals(e.getRole_name())) {
                        isadmin = 1;
                    }
                }
            }
            dcUser2.setIsadmin(isadmin);
            dcUser2.setAllkscodes(kscodes);
            session.setAttribute("user", dcUser2);
            StpUtil.login(dcUser2.getId());
            //这里进行预警操作
            return ResultUtil.success(j, "登录成功");
        }
        session.setAttribute("user", dcUser2);

        return ResultUtil.success(j, "登录成功");
    }

    @ApiOperation(value = "新增病案系统人员", notes = "新增病案系统人员")
    @PostMapping("/saveBa")
    @ResponseBody
    public ResultUtil insertBa(@RequestBody SysUser sysUser) {
        if (null == sysUser) {
            return ResultUtil.error("没有数据要保存");
        }
        if (null == sysUser.getYq_id()) {
            return ResultUtil.error("医院信息未维护");
        }
        SysUser sysUser1 = new SysUser();
        try {
            Integer id = sysUser.getId();
            if ("".equals(id) || null == id) {
                //
                sysUser1.setCode(sysUser.getCode());
                SysUser sysUser2 = sysUserService.selectOne(sysUser1);
                // 当前code 能够查询到用户
                if (sysUser2 != null) {
                    //判断用户状态
                    if (null != sysUser2.getStatus() && sysUser2.getStatus().equals(1)) {
                        sysUser2.setStatus(2);
                        sysUser2.setPwd(toMD5(sysUser.getLogin_name() + "123"));
                        sysUser2.setUpdate_time(DateUtil.formatFromDate2(new Date()));
                        sysUser2.setKs_name(sysUser.getKs_name());
                        sysUser2.setKs_id(sysUser.getKs_id());
                        sysUser2.setYq_id(sysUser.getYq_id());
                        sysUser2.setYq_name(sysUser.getYq_name());
                        sysUser2.setLogin_name(sysUser.getLogin_name());
                        sysUser2.setName(sysUser.getName());
                        sysUser2.setUpdate_time(DateUtil.formatFromDate2(new Date()));
                        sysUserService.update(sysUser2);
                        return ResultUtil.success("操作成功");
                    }
                    return ResultUtil.error("该代码的用户已存在");
                }
                sysUser.setPwd(toMD5(sysUser.getLogin_name() + "123"));
                sysUser.setStatus(2);
                sysUser.setUpdate_time(DateUtil.formatFromDate2(new Date()));
                sysUserService.insertBaUser(sysUser);
            } else {
                sysUserService.updateSysUser(sysUser);
            }
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    //查询请求类型列表
    @ApiOperation(value = "其他系统验证", notes = "验证用户信息")
    @GetMapping("/getKey")
    @CrossOrigin
    @ResponseBody
    public ResultUtil getKey(@RequestParam(value = "code") String code, @RequestParam(value = "pname") String pname) {
        String key = null;
        if (null == code || code.trim().equals("") || null == pname || pname.trim().equals("")) {
            return ResultUtil.error("请查看参数是否异常");
        }
        try {
            long l = System.currentTimeMillis();
            String time = String.valueOf(l);
            String str = code + "," + pname + "," + time;
            key = encrypt_Base64(str);
            //System.out.println (key);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(key, "请求成功");
    }


    //查询请求类型列表
    @ApiOperation(value = "其他系统登录验证", notes = "验证用户信息")
    @GetMapping("/toLogin")
    @CrossOrigin
    @ResponseBody
    public ResultUtil login1(@RequestParam(value = "code") String code, @RequestParam(value = "pname") String pname, @RequestParam(value = "key") String key, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        SysUser sysUser = new SysUser();
        try {
            String decode = URLUtil.decode(key);

            String s = decrypt_Base64(decode);
            String[] split = s.split(",");
            String codeKey = split[0];
            String pnameKey = split[1];
            if (!code.equals(codeKey) || !pname.equals(pnameKey)) {
                return ResultUtil.error("两次传入数据不同");
            }
            if (!pname.equals("SXDLSingleDisease")) {
                return ResultUtil.error("项目名错误");
            }
            sysUser.setCode(code);
            SysUser sysUser1 = sysUserService.selectOne(sysUser);
            if (sysUser1 == null) {
                return ResultUtil.error("该用户工号不存在");
            }
            session.setAttribute("user", sysUser1);
            return ResultUtil.success(sysUser1.getId(), "登录成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }

    }

   /* @ApiOperation(value = "登录验证", notes = "验证用户信息")
    @PostMapping("/login")
    @CrossOrigin
    @ResponseBody
    public ResultUtil findUser(@RequestBody SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
        System.out.println ( sysUser );
        HttpSession session = request.getSession ();
        SysUser dcUser2 = null;
        SysUser dcUser1 = new SysUser ();
        dcUser1.setLogin_name ( sysUser.getLogin_name () );
        dcUser1.setPwd ( toMD5 ( sysUser.getLogin_name () + sysUser.getPwd () ) );
        try {
            dcUser2 = sysUserService.selectOne ( dcUser1 );
            if (dcUser2 == null) {
                return ResultUtil.error ( "账号或者密码错误" );
            }
            //session.setAttribute ( "user", dcUser2 );
            return ResultUtil.success ( dcUser2.getId (), "登录成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }*/


    //用户修改密码
    @ApiOperation(value = "用户修改密码", notes = "用户修改密码")
    @GetMapping("/updatePwd")
    @ResponseBody
    public ResultUtil updatePwd(Integer uid, String loginPwd, String newPwd1, String newPwd2, HttpServletRequest request, HttpServletResponse response) {
        try {
            SysUser user = sysUserService.findById(uid);
            String pwd = toMD5(user.getLogin_name() + loginPwd);
            if (pwd.equals(user.getPwd())) {
                if (newPwd1.equals(newPwd2)) {
                    String newpwd = toMD5(user.getLogin_name() + newPwd1);
                    user.setPwd(newpwd);
                    sysUserService.updateByPrimaryKey(user);
                } else {
                    return ResultUtil.error("两次密码不一样");
                }
            } else {
                return ResultUtil.error("旧密码错误！");
            }
        } catch (Exception e) {
            return ResultUtil.error("修改密码失败");
        }
        return ResultUtil.success("修改成功");
    }

    //用户修改密码
    @ApiOperation(value = "退出登录", notes = "退出登录")
    @GetMapping("/out")
    @ResponseBody
    public ResultUtil out(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            Enumeration e = session.getAttributeNames();
            while (e.hasMoreElements()) {
                String sessionName = (String) e.nextElement();
                session.removeAttribute(sessionName);
            }
            StpUtil.logout();
        } catch (Exception e) {
            //System.out.println ( e.getMessage () );
            return ResultUtil.error("退出登录失败");
        }
        return ResultUtil.success("退出登录成功");
    }


    //管理员修改密码
    @ApiOperation(value = "管理员修改其他用户密码", notes = "管理员修改其他用户密码")
    @PutMapping("/updatePwdByAdmin")
    @ResponseBody
    public ResultUtil updatePwdByAdmin(@RequestBody Map<String, Object> map) {
        String newPwd1 = "";
        String newPwd2 = "";
        SysUser sysUser = new SysUser();

        try {
            if (null == map || map.size() < 0) {
                return ResultUtil.error("参数为空");
            }

            if (map.containsKey("sysUser")) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                Object user = map.get("sysUser");
                sysUser = objectMapper.convertValue(user, SysUser.class);
            }
            if (map.containsKey("newPwd1")) {
                newPwd1= String.valueOf(map.get("newPwd1"));
            }
            if (map.containsKey("newPwd2")) {
                newPwd2= String.valueOf(map.get("newPwd2"));
            }

            if (newPwd1.equals(newPwd2)) {
                String newpwd = toMD5(sysUser.getLogin_name() + newPwd1);
                sysUser.setPwd(newpwd);
                sysUserService.updateByPrimaryKey(sysUser);
            } else {
                return ResultUtil.success("两次密码不一样");
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("修改成功");
    }

    @Autowired
    YmlUtil ymlUtil;

    @ApiOperation(value = "获取登录用户的信息", notes = "详细信息")
    @PostMapping("/userInfo")
    @ResponseBody
    public ResultUtil userInfo(@RequestBody SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
        //System.out.println ( sysUser );
        SysUser dcUser2 = null;
        Map<String, Object> map = new HashMap<>();
        List<Integer> roles = new ArrayList<>();
        try {
            dcUser2 = sysUserService.findById(sysUser.getId());
            if (dcUser2 != null) {
                SysUserVsRole sysUserVsRole = new SysUserVsRole();
                sysUserVsRole.setUser_id(sysUser.getId());
                List<SysUserVsRole> sysUserVsRoles = sysUserVsRoleService.select(sysUserVsRole);
                sysUserVsRoles.forEach(e -> {
                    roles.add(e.getRole_id());
                });
                map.put("permissions", roles);
                map.put("username", dcUser2.getName());
                map.put("user", dcUser2);
                map.put("dcip", ymlUtil.getYmlValue("dcip"));
                map.put("drip", ymlUtil.getYmlValue("drip"));
                map.put("qcip", ymlUtil.getYmlValue("qcip"));
            }
            //System.out.println ( map );
            HttpSession session = request.getSession();

            if (productName.indexOf("护理") != -1) {
                //这里有 admin 没有科室问题
                List<SysUserVsKs> byuserId = sysUserVsKsService.findByuserId(dcUser2.getId());
                List<SysUserVsRole> roles2 = sysUserVsRoleService.findByuserId(dcUser2.getId());
                List<String> allkscodes = sysUserVsKsService.findAllkscodes(dcUser2.getId(), dcUser2.getStaff_id());
                String kscodes = "";
                if (CollUtil.isNotEmpty(allkscodes)) {
                    kscodes = String.join(",", allkscodes);
                }
                dcUser2.setRoles(roles2);
                dcUser2.setKss(byuserId);
                Integer isadmin = -1;
                if (CollUtil.isNotEmpty((roles2))) {
                    for (SysUserVsRole e : roles2) {
                        if ("超级管理员".equals(e.getRole_name()) || "护理部".equals(e.getRole_name()) || "管理员".equals(e.getRole_name())) {
                            isadmin = 1;
                        } else if ("护士长".equals(e.getRole_name())) {
                            isadmin = 2;
                        }
                    }
                }
                dcUser2.setIsadmin(isadmin);
                dcUser2.setAllkscodes(kscodes);
                session.setAttribute("user", dcUser2);
                //这里进行预警操作
                map.put("user", dcUser2);
            }
            session.setAttribute("user", dcUser2);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(map);
    }


    //首次批量导入人员信息为用户
    @ApiOperation(value = "首次批量导入用户", notes = "首次批量导入用户")
    @GetMapping("/insertUserList")
    @ResponseBody
    public ResultUtil insertUserList() {

        try {
            Integer integer = sysUserService.AutoUpateUser();
            if (integer <= 0) {
                return ResultUtil.success("此次没有导入数据");
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("导入用户成功成功");

    }


    public String toMD5(String plainText) {

        StringBuffer buf = new StringBuffer();
        try {
            //生成实现指定摘要算法的 MessageDigest 对象。
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用指定的字节数组更新摘要。
            md.update(plainText.getBytes());
            //通过执行诸如填充之类的最终操作完成哈希计算。
            byte[] b = md.digest();
            //生成具体的md5密码到buf数组
            int i;

            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

//            System.out.println("32位: " + buf.toString());// 32位的加密
//            System.out.println("16位: " + buf.toString().substring(8, 24));// 16位的加密，其实就是32位加密后的截取
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf.toString();
    }


    public static String encrypt_Base64(String str) throws Exception {
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt_Base64(String str) throws Exception {
        return new String(Base64.getDecoder().decode(str), StandardCharsets.UTF_8);
    }

}
