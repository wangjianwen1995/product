package com.sxdl.ae.controller;



import com.github.pagehelper.PageInfo;
import com.sxdl.ae.entity.AEPatient;
import com.sxdl.ae.entity.AESummary;
import com.sxdl.ae.service.AESummaryService;
import com.sxdl.ae.util.DataUtil;
import com.sxdl.ae.util.PageUtil;
import com.sxdl.ae.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "不良事件总表" )
@RestController
@RequestMapping("ae/summary")
@RequiredArgsConstructor
public class AESummaryController {
    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    
    private final AESummaryService summaryService;

    @ApiOperation(value = "获取不良事件总表数据")
    @GetMapping("/getAdverseEventSummaryList")
    public ResultUtil getAdverseEventSummaryList(PageInfo pageInfo,
                                                 @RequestParam(value = "val",defaultValue = "") String val,
                                                 @RequestParam(value = "type",defaultValue = "") String type
                                                 ){
        PageInfo listpage = null;
        try {

            Example example = Example.builder(AESummary.class)
                    .where(Sqls.custom()
                            .andLike("hz_xm", "%"+val+"%")
                            .orLike("hz_zyh","%"+val+"%")
                    ).orderByDesc("bgrq")
                    .build();
            List<AESummary> list = summaryService.selectByExample(example);

            List<AESummary> collect = list.stream().filter(f -> Arrays.asList(f.getSjfl_gllb().split(",")).contains(type)).collect(Collectors.toList());
            listpage = PageUtil.getPageInfo(collect,pageInfo);

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( listpage);
    }

    @ApiOperation(value = "回显数据")
    @GetMapping("/getAdverseEventSummaryOne")
    public ResultUtil getAdverseEventSummaryOne(@RequestParam(value = "id",required = true) String id){
        AESummary aeSummary =null;
        try {
            aeSummary = summaryService.getAdverseEventSummaryOne(id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( aeSummary);
    }

    @ApiOperation(value = "保存修改")
    @PostMapping("/saveAdverseEvent")
    public ResultUtil saveAdverseEvent(@RequestBody  AESummary summary ) {
        try {
            summaryService.saveAdverseEvent(summary);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除")
    @DeleteMapping("/delAdverseEvent")
    public ResultUtil delAdverseEvent( @RequestParam(value = "id",required = true) String id ){
        try {
            summaryService.delAdverseEvent(id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }









}
