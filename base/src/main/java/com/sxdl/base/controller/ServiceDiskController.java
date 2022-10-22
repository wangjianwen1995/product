package com.sxdl.base.controller;


import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.entity.SysLog;
import com.sxdl.base.service.ServiceDiskService;
import com.sxdl.base.service.SysLogService;
import com.sxdl.base.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags="系统日志系统")
@RestController
@RequestMapping("/disk")
public class ServiceDiskController {

    @Autowired
    private ServiceDiskService ServiceDiskService;
    @Autowired
    private SysLogService syslogService;
    @ApiOperation(value = "查询首页", notes = "查询首页相关信息")
    @GetMapping("/findDbInfo")
    public ResultUtil<Map<String,List<Map<String,Object>>>> findDbInfo() {
        try {
            Map<String,List<Map<String,Object>>> map = ServiceDiskService.findDbInfo();
            return ResultUtil.success ( map ,"查询首页相关信息成功");
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "清理日志", notes = "清理日志")
    @GetMapping("/clearUpLogs")
    public ResultUtil clearUpLogs(String dbName) {
        try {
            ServiceDiskService.clearUpLogs(dbName);
            return ResultUtil.success ("清理日志成功");
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


    @ApiOperation(value = "查询", notes = "根据条件查询日志信息")
    @GetMapping("/findByFactor")
    public ResultUtil findByFactor(PageInfo pageInfo, @RequestParam(value = "dctime", defaultValue = "") String dctime, @RequestParam(value = "level", defaultValue = "") String level ) {
        try {
            StringBuilder sb = new StringBuilder(" from "+ PrefixConfig.PREFIX+"sys_log where 1=1 ");
            String columsql=" select id,level,user_id,operator, LEFT(content,100) as content,time,name,use_time ";
            if (StrUtil.isNotEmpty(dctime)&&dctime.contains(",")){
                String[] times= dctime.split(",");
                sb.append(" and ").append(" time between ").append("'"+ times[0] +"'").append(" and ").append("'"+times[1]+"'") ;
            }
            if (level !=null && !"".equals(level)){
                sb.append(" and ").append(" level like ").append("'%" +level+"%'");
            }
            pageInfo = syslogService.selectPageinfoWithSQL(SysLog.class, columsql, sb.toString(), "time", pageInfo, true);
            return ResultUtil.success ( pageInfo,"查询日志成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }



}
