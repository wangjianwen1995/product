package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcLogError;
import com.sxdl.product.dc.service.DcLogErrorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Api(tags = ("错误日志反馈"))
@RestController
@RequestMapping("/logError")
public class DcLogErrorController {
    @Autowired
    private DcLogErrorService dcLogErrorService;

    //查询所有错误日志
    @ApiOperation(value = "查询", notes = "查询所有错误日志信息")
    @GetMapping("/findAll")
    public ResultUtil findByAll(PageInfo pageInfo, @RequestParam(value = "title", defaultValue = "") String title) {
        try {
            DcLogError log = new DcLogError();
            log.setTitle(title);
            PageInfo<DcLogError> list =dcLogErrorService.queryPageList(pageInfo, log);
            return ResultUtil.success ( list,"查询错误日志成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    //新建保存错误日志信息
    @ApiOperation(value = "新增", notes = "添加错误日志信息")
    @PostMapping("/insert")
    public ResultUtil<DcLogError> insertHospital(@RequestBody DcLogError dcLogError ) {
        try {
            if (dcLogError.getStatus()==null){
                dcLogError.setStatus("-1");
            }
            Date date = new Date();
            long dateTime=date.getTime();
            Date date1=new Date(dateTime);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String a= formatter.format(date1);
            if(dcLogError.getSubmitTime()==null){
                dcLogError.setSubmitTime(a);
            }

            /*if(dcLogError.getJpg()!=null){
                *//**
                 * 图片转化成base64字符串
                 * @param imgPath
                 * @return
                 *//*
                            String imgFile = dcLogError.getJpg();// 待处理的图片
                            InputStream in = null;
                            byte[] data = null;
                            String encode = null; // 返回Base64编码过的字节数组字符串
                            // 对字节数组Base64编码
                            BASE64Encoder encoder = new BASE64Encoder();
                            try {
                                    // 读取图片字节数组
                                     in = new FileInputStream(imgFile);
                                     data = new byte[in.available()];
                                    in.read(data);
                                    encode = encoder.encode(data);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } finally {
                                    try {
                                            in.close();
                                         } catch (IOException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                 }
                         }*/
            dcLogErrorService.insert(dcLogError);
            return ResultUtil.success ( "添加错误日志成功");
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    //修改错误日志信息
    @ApiOperation(value = "修改", notes = "修改错误日志信息")
    @PutMapping("/update")
    public ResultUtil<DcLogError> updateHospital(@RequestBody DcLogError dcLogError) {
        try {
            Date date = new Date();
            long dateTime=date.getTime();
            Date date1=new Date(dateTime);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String a= formatter.format(date1);
            if(dcLogError.getUpdateTime()==null){
                dcLogError.setUpdateTime(a);
            }
            if (dcLogError.getStatus()!=null){
                dcLogError.setStatus("1");
            }
            dcLogErrorService.update(dcLogError);
            return ResultUtil.success ( "修改错误日志信息成功");
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    //删除错误日志信息
    @ApiOperation(value = "删除", notes = "删除错误日志信息")
    @DeleteMapping("/delete")
    public ResultUtil<DcLogError> delete( @RequestBody DcLogError dcLogError) {

        try {
            dcLogErrorService.delete(dcLogError);
            return ResultUtil.success ( "删除错误日志信息成功");
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }
}
