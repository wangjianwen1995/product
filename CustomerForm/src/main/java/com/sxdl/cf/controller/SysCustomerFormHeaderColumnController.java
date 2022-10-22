package com.sxdl.cf.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.cf.dao.dao1.SysDictTableDao2;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import com.sxdl.cf.service.SysCustomerFormFactTableService;
import com.sxdl.cf.service.SysCustomerFormFieldTableService;
import com.sxdl.cf.service.SysCustomerFormHeaderColumnService;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.PageUtil;
import com.sxdl.cf.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Api(tags = "列表展示设置" )
@RestController
@RequestMapping("/dev/headerColumn")
@RequiredArgsConstructor
public class SysCustomerFormHeaderColumnController {
    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final SysCustomerFormFactTableService tableService;

    private final SysCustomerFormFieldTableService fieldService;

    private final SysCustomerFormHeaderColumnService headerService;

    private final SysDictTableDao2 dictTableDao2;

    @ApiOperation(value = "查询列表展示属性")
    @GetMapping("/getColumnShow")
    public ResultUtil getColumnShow(PageInfo pageInfo,
                                       @RequestParam(value = "table_id") String table_id,
                                       @RequestParam(value = "val",defaultValue = "") String val){
        PageInfo list =null;
        try {
            list = PageUtil.getPageInfoData(pageInfo, headerService::getTargetList,table_id,val);

            //list = PageUtil.getPageInfoData(pageInfo, (a,b)->headerService.getTargetList(a,b),table_id,val);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }



    @ApiOperation(value = "修改列表展示属性")
    @PostMapping("/updateColumnShow")
    public ResultUtil updateColumnShow(@RequestBody SysCustomerFormHeaderColumnEntity columnEntity ){
        try {
            Integer integer = headerService.saveSimple(columnEntity);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(  DataUtil.SUCCESS_MASSAGE);
    }





}
