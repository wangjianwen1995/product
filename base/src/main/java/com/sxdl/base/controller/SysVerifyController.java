package com.sxdl.base.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.service.SysUserService;
import com.sxdl.base.util.*;
import com.sxdl.base.util.verify.VerifyReturn;
import com.sxdl.base.util.verify.VerifyUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Api(tags = "注册接口")
@RestController
@RequestMapping("verify")
public class SysVerifyController {
    @Autowired
    SysUserService sysUserService;
    private String suffix;
    private File serverFile;
    @Autowired
    private YmlUtil ymlUtil;

    @GetMapping("isVerify")
    public ResultUtil isVerify() {
        try {
            ApplicationRunnerImpl.verify(ApplicationRunnerImpl.PATH);
            boolean flag = (Boolean) ApplicationRunnerImpl.contextMap.get("verify");
            if (!flag) {
                return ResultUtil.error("请联系管理员重新注册!");
            } else {
                return ResultUtil.success(ApplicationRunnerImpl.contextMap.get("verifyInfo"));
            }
        } catch (Exception e) {
            return ResultUtil.error("请联系管理员排查系统,错误原因:" + e.getCause());
        }
    }


    @GetMapping("getPName")
    public ResultUtil getPName() {
        try {
            String productName = ymlUtil.getYmlValue("server.application.name");
            return ResultUtil.success(productName);


        } catch (Exception e) {
            return ResultUtil.error("请联系管理员排查系统,错误原因:" + e.getCause());
        }
    }

    /**
     * 本公司集群产品,互相单点登录接口
     * @param val 加密参数
     * @return 返回值
     */
    @GetMapping("sxdlmssl")
    public ResultUtil get(String val) {
        if (StrUtil.isEmpty(val)) {
            return ResultUtil.error("接口错误");
        }
        try {
            val = MD5Util.decryptSelf(val);
            if (!val.contains("sxdlmicroserversl")) {
                return ResultUtil.error("接口错误");
            }
            if (!val.contains("233")) {
                return ResultUtil.error("接口错误");
            }
            List<Map<String, Object>> maps = sysUserService.selectSqlWithSQL("select top 1 id from "+ PrefixConfig.PREFIX+"_sys_user where code='admin' and login_name='admin'");
            if (maps.isEmpty()) {
                return ResultUtil.error("接口错误");
            }
            String id = maps.get(0).get("id").toString();
            StpUtil.login(id);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            JSONObject j = new JSONObject();
            j.putOpt("tokenName", "sxdl");
            j.putOpt("tokenValue", tokenInfo.getTokenValue());
            j.putOpt("uid", id);
            return ResultUtil.success(j);
        } catch (Exception e) {
            return ResultUtil.error("接口错误");
        }
    }

    @GetMapping("getCipher")
    @ResponseBody
    public ResultUtil getCipher() {
        //获取本地密文,需要将密文传回公司,按照客户具体情况注册
        return ResultUtil.success(VerifyUtil.generatVerify());
    }

    @PostMapping("upload")
    public ResultUtil upload(@RequestPart(value = "file", required = true) MultipartFile file) {
        suffix = file.getOriginalFilename();
        suffix = StringUtil.isNotEmpty(suffix) ? suffix : "";
        if (!suffix.trim().endsWith(".lisp")) {
            return ResultUtil.error("请重新上传正确的文件!");
        }
        if (!suffix.trim().equals("longlicenses.lisp")) {
            return ResultUtil.error("请重新上传正确的文件!");
        }
        //超大文件,超过1k
        if (file.getSize() / 1024 >= 1 || file.getSize() == 0) {
            return ResultUtil.error("请重新上传正确的文件!");
        }
        try {
            byte[] content = file.getBytes();
            String txt = new String(content);
            VerifyReturn verify = VerifyUtil.builder().verify(txt, ApplicationRunnerImpl.PATH);
            if (!verify.getFlag()) {
                //TODO 应该跳转验证页面
                return ResultUtil.error(verify.getMeg());
            }
            serverFile = FileUtil.writeBytes(content, new File(ApplicationRunnerImpl.PATH));
            if (!serverFile.exists()) {
                return ResultUtil.error("文件保存失败,请联系管理员查看服务器系统安装目录是否有读/写权限!");
            }
            ApplicationRunnerImpl.contextMap.put("verify", true);
            ApplicationRunnerImpl.contextMap.put("verifyInfo", JSONUtil.parseObj(verify.getMeg()));
        } catch (IOException e) {
            return ResultUtil.error("文件有问题!");
        }
        return ResultUtil.success("上传并验证成功!");
    }
}
