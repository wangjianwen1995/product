package com.sxdl.cf.controller;

import com.sxdl.cf.service.*;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.ResultUtil;
import com.sxdl.cf.util.ZIPUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Api(tags = "移植表单模块" )
@RestController
@RequestMapping("/dev/transplantModel")
@RequiredArgsConstructor
public class SysCustomerFormTransplantModelController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";

    private final SysCustomerFormTransplantModelService modelService;
    private final SysCustomerFormFactTableService tableService;
    private final SysCustomerFormFieldTableService fieldService;
    private final SysCustomerFormHeaderColumnService headerService;
    private final SysCustomerFormProcessStepService stepService;
    /**
     *
     * key 只能单个导出,并且导出的时候只能导出主表(这块做处理将一对一一对多的子表数据全部导出)
     * 导出表单配置,可多选表单 , 里面包括,
     * sql(事实表[创建的表]
     * 事实管理表[sys_cf_facttable],
     * 字段表[sys_cf_fieldtable],
     * 展示表[sys_cf_headercolumn],
     * 流程表[sys_cf_processstep])
     * 主题分类不需要导出
     *
     * @param response
     */
    @ApiOperation(value = "导出ZIP配置文件")
    @GetMapping("/exportZip")
    public void exportZip( @RequestParam(value = "table_id") String table_id,
                           @RequestParam(value = "table_name") String table_name,
                           HttpServletResponse response) {
        try {

            //设置浏览器
            setServletResponsePropertiesZip(response,table_name);
            List<File> tempFiles = null;
            try {
                tempFiles = modelService.createFileToZIP(table_id,table_name);
                ZIPUtils.zipFiles(tempFiles,response.getOutputStream());
            } finally {
                // 最后删除临时文件
                tempFiles.forEach(e->{
                    boolean result = false;
                    int tryCount = 0;
                    while(!result && tryCount++ <10)
                    {
                        System.gc();
                        result = e.delete();
                    }
                });

            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
        }
    }


    /***
     *  上传配置文件
     * @param multipartFile
     * @return
     */
    @PostMapping("/importZipFile")
    public ResultUtil<Map<String, String>> importZipFile(@RequestParam("multipartFile") MultipartFile multipartFile,@RequestParam("classifyid")  String classifyid) {
        // 1.校验入参 将MultipartFile转换成zipFile
        try {
            ResultUtil<Map<String, String>> zipFileResultUtil = modelService.checkZipFileParam(multipartFile);
            if(zipFileResultUtil.getState().equals("error"))
                return zipFileResultUtil;
            modelService.coreMethod(classifyid, zipFileResultUtil);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error( DataUtil.ERROR_MASSAGE);

        }

        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }




    private void setServletResponsePropertiesZip( HttpServletResponse response,String  name) throws UnsupportedEncodingException {
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+URLEncoder.encode("("+name+")表单配置文件","utf-8")+".zip");
    }

}
