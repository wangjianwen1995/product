package com.sxdl.product.dc.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.RsaUtil;
import com.sxdl.product.dc.dao.dao1.DcUserDao;
import com.sxdl.product.dc.entity.DcUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 */

@Api(tags = "登录接口")
@RestController
@RequestMapping("/login")
public class DcLoginController {
    @Autowired
    private DcUserDao dcUserDao;
    public static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcpG8DCdF58Ue8n6ikvfH0AXZTIMm95ELdi0BMPU827N69ERfphYqX7BNdc0KWYXc/bZYSAAmpWM2F7CWwzqYyYi4w1IPDDVYKGi77UJjIVS9t6Yz1J8842wKEepxulxjAnqL5cKdRabFF06HzvsrmJ9PmrvqouwIKgsfvV5WZdQIDAQAB";
    public static final String b = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANykbwMJ0XnxR7yfqKS98fQBdlMgyb3kQt2LQEw9Tzbs3r0RF+mFipfsE11zQpZhdz9tlhIACalYzYXsJbDOpjJiLjDUg8MNVgoaLvtQmMhVL23pjPUnzzjbAoR6nG6XGMCeovlwp1FpsUXTofO+yuYn0+au+qi7AgqCx+9XlZl1AgMBAAECgYEAutqyfMM62GdiVjZr7qBBoGAAoeOZliwSCGbeW/Jr/FrbQwiP1J7YQVKXD8QFty7xexDGT5YimHzxCKJ1ROeszFnMd9c3Blkl2W8EMYwIsxWuTWpLZQDFm0iJtHJH1LKZwr8XWnt4Ffjmg6CdzscK1ARJJTSgpYfB3D4o3op7eIECQQDxLA3XHsCndPoDnQKy0brNwXiGZk66ksWpxB3/8o3JeOYkPdgUhhbA0zrNfhAsUkNP0M1V8GFi0vwAEcMLxJ7VAkEA6jU/8bKj56bZnDXy1yNI0RSi74LZPNDLFC4lVPRy8dJKMujbXZWxh3maUPQS2xtHOq2P31bYkEB99op63BigIQJBAKSC+Znxl1djexw14V5bpIKwY+fCKBgrAHyylAhAy6lQOCUmrpwpb6HvNOByCtRA9Tuf4kGqLLQ92bquYw9G+1UCQHovGZLwTU3236P9CRlvkPdyuqYVL1vo2WlHwbYWaTj7KjZxALBL/ffdWsJM8uFX08sq7NnpJsXqv0w1Zm8YccECQDLW13qJ3rfMt1N2XCpD2BroJCXlJzHqF6jEhvtLXVFg1w24Mrf9COd2LaCz9f/SP90ybjMsaRILPr8F+Uc1XV4=";

    //查询请求类型列表
    @ApiOperation(value = "登录验证", notes = "验证用户信息")
    @PostMapping("/login")
    @CrossOrigin
    @ResponseBody
    public ResultUtil findUser(@RequestBody Map<String, String> data, HttpServletRequest request, HttpServletResponse response) {
        //System.out.println ( data );
        HttpSession session = request.getSession ();
        String name = RsaUtil.decrypt ( data.get ( "name" ), b );
        String pwd = RsaUtil.decrypt ( data.get ( "pwd" ), b );
        // String decrypt = RsaUtil.decrypt(param, b);
        //System.out.println ( name );
        DcUser dcUser1 = new DcUser ();
        dcUser1.setName ( name );
        dcUser1.setPwd ( pwd );
        try {
            DcUser dcUser2 = dcUserDao.selectOne ( dcUser1 );
            //System.out.println ( dcUser2 );
            if (dcUser2 == null) {
                return ResultUtil.error ( "账号或者密码错误" );
            }
            session.setAttribute ( "user", dcUser2 );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
        return ResultUtil.success ( "登录成功" );
    }


    @ApiOperation(value = "修改用户名或者密码", notes = "修改密码")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtil update(@RequestBody DcUser dcUser) {
        try {
            dcUserDao.updateByPrimaryKey ( dcUser );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
        return ResultUtil.success ( "修改成功" );
    }

    @ApiOperation(value = "获取登录用户的信息", notes = "详细信息")
    @PostMapping("/userInfo")
    @ResponseBody

    public ResultUtil userInfo(@RequestBody DcUser dcUser, HttpServletRequest request, HttpServletResponse response) {

        DcUser dcUser2 = null;
        Map<String, String> map = new HashMap<> ();
        try {
            dcUser2 = dcUserDao.selectOne ( dcUser );
            if (dcUser2 != null) {
                map.put ( "permissions", dcUser2.getName () );
                map.put ( "username", dcUser2.getName () );
                map.put ( "avatar", "https://i.gtimg.cn/club/item/face/img/2/15922_100.gif" );
            }
            // System.out.println (dcUser2 );
            HttpSession session = request.getSession ();
            session.setAttribute ( "user", dcUser2 );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
        return ResultUtil.success ( map );
    }

    @ApiOperation(value = "获取user信息", notes = "详细信息")
    @GetMapping("/getuserList")
    @ResponseBody
    public ResultUtil getuserList(){

        List<DcUser> dcUsers = new ArrayList<>();
        try {
            dcUsers= dcUserDao.selectAll();
        }catch (Exception e){
           return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(dcUsers,"返回成功");

    }







}
