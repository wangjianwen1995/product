package com.sxdl.drplus.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.dto.QQRDBO;
import com.sxdl.drplus.entity.DrPlusErrorQualityLog;
import com.sxdl.drplus.entity.DrPlusExtractDetailed;
import com.sxdl.drplus.service.*;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.FileUtil;
import com.sxdl.drplus.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "数据抽取模块")
@RestController
@RequestMapping("/extract")
public class DrPlusExtractDetailedController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private DrPlusCenterTableService   centerTableService;

    @Autowired
    private DrPlusControlBzxService bzxService;
    @Autowired
    private DrPlusControlWzxService wzxService;
    @Autowired
    private DrPlusControlLjxService ljxService;

    @Autowired
    private DrPlusExtractDetailedService extractDetailedService;

    /**
     *
     * @param pageInfo
     * @param pid
     * @param is_auto   1 手动抽取  2 自动抽取
     * @return
     */
    @ApiOperation(value = "获取抽取列表")
    @GetMapping("/getExtractData")
    public ResultUtil getExtractData(PageInfo pageInfo,
                                     @RequestParam(value = "pid",required = true) Integer pid ,
                                     @RequestParam(value = "is_auto",required = true) Integer is_auto) {
        Map<String, Object> listPage;
        if(pid==11){
            pid = 6;
        }else if(pid==12){
            pid = 7;
        }
        try {
            String tab="";
            if(6==pid||7==pid||10==pid|| 15==pid)
                tab = "a";
            List<DrPlusExtractDetailed> list = extractDetailedService.getQualityResultData(pid,is_auto,tab);
            /*if(list.size()<1)
                return  ResultUtil.error("此时间段没有数据");*/
            listPage = PageList.getListPage(pageInfo, list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "删除抽取列表")
    @DeleteMapping("/delExtractData")
    public ResultUtil delExtractData(  @RequestParam(value = "pid",required = true) Integer pid ,
                                       @RequestParam(value = "eid",required = true) Integer eid ) {
        if(pid==11){
            pid = 6;
        }else if(pid==12){
            pid = 7;
        }
        try {
            extractDetailedService.delExtractData(pid,eid);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    /**
     * 点击抽取数据 执行的 第一个步骤 先创建 一条数据 这里为手动抽取数据
     * @param pid
     * @param stime
     * @param etime
     * @param type
     * @return
     */
    @ApiOperation("创建抽取主条数获取id")
    @GetMapping("/getExtractId")
    public ResultUtil getExtractId(@RequestParam(value = "pid",required = true) Integer pid,
                                   @RequestParam(value = "stime",required = true) String stime,
                                   @RequestParam(value = "etime",required = true) String etime,
                                   @RequestParam(value = "type",required = true) Integer type,
                                   @RequestParam(value = "id",required = false) Integer id ){

        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            if(StringUtils.isEmpty(id)){
                DrPlusExtractDetailed drPlusExtractDetailed   = extractDetailedService.insertData(pid,stime,etime,type,1);
            }else {
                extractDetailedService.updateData(id,stime,etime,type);
            }
            //创建一条新的抽取记录获取到 抽取id

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }




    /**
     *
     * key 前端每次上报或者导出数据,都需要先调用该接口
     *
     *
     * @param pid
     * @param stime
     * @param etime
     * @param type  抽取类型 1抽取遗漏数据 2抽取未审核数据   3 重新抽取已审核数据  4 抽取上报失败数据 5 抽取除上报成功外的数据, 6抽取所有数据 7抽取质控报错数据
     * @return
     */
    @ApiOperation("手动抽取数据:无需审核")
    @GetMapping("/startManualExtractDataNoCheck")
    public ResultUtil startManualExtractDataNoCheck(@RequestParam(value = "pid",required = true) Integer pid,
                                                    @RequestParam(value = "stime",required = true) String stime,
                                                    @RequestParam(value = "etime",required = true) String etime,
                                                    @RequestParam(value = "type",required = true) Integer type,
                                                    @RequestParam(value = "extract_id",required = true) Integer extract_id){
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            //创建一条新的抽取记录获取到 抽取id
            Integer successNum = 0;
            if(6==pid||7==pid){
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd(extract_id,pid,stime,etime,type);
            }else if(10==pid){
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd10(extract_id,pid,stime,etime,type);
            }else if(15==pid){
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd15(extract_id,pid,stime,etime,type);
            }else{
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExec(extract_id,pid,stime,etime,type);
            }

            //将数据插入到 drplus_data_type 表中 同时修改抽取状态 把审核状态修改成已经审核
            extractDetailedService.setConfigDataType(pid,extract_id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            Integer update = extractDetailedService.updateSqlWithSQL("update drplus_extract_detailed set  state=-1 where id = "+extract_id);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success("抽取成功");
    }




    /**
     * 点击抽取数据 执行的 第二个步骤
     * 手动抽取数据,点击抽取数据后选择时间范围直接抽取数据
     *
     *
     * @param pid
     * @param stime
     * @param etime
     * @param type  抽取类型 1抽取遗漏数据 2抽取未审核数据   3 重新抽取已审核数据  4 抽取上报失败数据 5 抽取除上报成功外的数据, 6抽取所有数据 7抽取质控报错数据
     * @return
     */
    @ApiOperation("手动抽取数据")
    @GetMapping("/startManualExtractData")
    public ResultUtil startManualExtractData(@RequestParam(value = "pid",required = true) Integer pid,
                                             @RequestParam(value = "stime",required = true) String stime,
                                             @RequestParam(value = "etime",required = true) String etime,
                                             @RequestParam(value = "type",required = true) Integer type,
                                             @RequestParam(value = "extract_id",required = true) Integer extract_id){
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            //创建一条新的抽取记录获取到 抽取id
            Integer successNum = 0;
            if(6==pid||7==pid){
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd(extract_id,pid,stime,etime,type);
            }else if(10==pid){
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd10(extract_id,pid,stime,etime,type);
            }else if(15==pid){
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd15(extract_id,pid,stime,etime,type);
            }else{
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExec(extract_id,pid,stime,etime,type);
            }

            //将数据插入到 drplus_data_type 表中 同时修改抽取状态
            extractDetailedService.setConfig(pid,extract_id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            Integer update = extractDetailedService.updateSqlWithSQL("update drplus_extract_detailed set  state=-1 where id = "+extract_id);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success("抽取成功");
    }



    @ApiOperation("根据平台获取质控问题")
    @GetMapping("/getQualityQuestionResult")
    public ResultUtil getQualityQuestionResult(@RequestParam(value = "pid",required = true) Integer pid,
                                   @RequestParam(value = "eid",required = true) Integer eid ){
        Map<Integer, List<QQRDBO>> map = null;
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }

            List<QQRDBO> qqrdbos = extractDetailedService.getQualityQuestionResult(pid, eid);
            map = qqrdbos.stream().collect(Collectors.groupingBy(QQRDBO::getType));

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(map);
    }


    @ApiOperation(value = "导出质控问题")
    @GetMapping("/exportQuestionResult")
    public void exportQuestionResult(@RequestParam(value = "pid",required = true) Integer pid,
                             @RequestParam(value = "eid",required = true) Integer eid , HttpServletResponse response) {

        try {
            String s = "";
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }

            if(pid==6|| pid==7 || pid==10|| pid==15 ){
                s = pid+"a";
            }else{
                s = pid+"";
            }

            List<LinkedHashMap<String, Object>> dataList = extractDetailedService.getDataBySql(
                    " select a.PRIMAEYKEY ,a.BAH,a.ZYH,a.CYSJ,a.NAME,a.CQSJ,a.KSROLE,a.USERROLE,c.result_message from drplus_control_result c " +
                    " left join drplus_center_table_data" + s + "  a on a.drplus_extract_detailed_id =  c.drplus_extract_detailed_id and c.primary_keyval = a.PRIMAEYKEY  " +
                    " where   c.drplus_extract_detailed_id=" + eid + " " +
                    " order by a.PRIMAEYKEY , a.CQSJ ");

            setServletResponsePropertiesExecl("质控问题",response);
            FileUtil.doExcel3(dataList, Arrays.asList("PRIMAEYKEY,BAH,ZYH,CYSJ,NAME,CQSJ,KSROLE,USERROLE,result_message".split(",")),
                    Arrays.asList("主键,病案号,住院号,出院时间,患者姓名,系统抽取时间,科室,医生,质控问题".split(",")),response.getOutputStream());

        } catch (Exception e) {
            logger.error(e+LineBreak);
        }

    }

    private void setServletResponsePropertiesExecl(String fileName ,HttpServletResponse response) throws UnsupportedEncodingException {
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        //处理乱码问题
        response.setCharacterEncoding("UTF-8");
        //设置上下文类型
        response.setContentType("application/vnd.ms-excel;charset=GBK");
        //客户使用目标另存为对话框保存指定文件
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName,"utf-8")  + ".xls;");
    }



    /**
     *
     * @param pid   平台id
     * @param eid  抽取id
     * @param type   1 实际抽取下钻  2 质控问题下钻 3 审核通过 4 审核不通过 5 上报成功 6 上报失败
     * @param val   客户端检索词
     * @return
     */
    @ApiOperation("点击抽取列表的: 可下钻数据")
    @GetMapping("/drillDown")
    public ResultUtil drillDown(PageInfo pageInfo,@RequestParam(value = "pid",required = true) Integer pid,
                                             @RequestParam(value = "eid",required = true) Integer eid,
                                             @RequestParam(value = "type",required = true) Integer type,
                                             @RequestParam(value = "val",defaultValue ="") String val ){

        PageInfo listPage = null;
        if(pid==11){
            pid = 6;
        }else if(pid==12){
            pid = 7;
        }
        try {
            PageUtil.setPageInfo(pageInfo);
            listPage= PageUtil.getPageInfo(centerTableService.drillDown(pid, eid, val, type), pageInfo);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }

    /**
     * 可下钻数据
     * @param pageInfo
     * @param pid
     * @param eid
     * @return
     */
    @ApiOperation("点击抽取列表的: 质控报错")
    @GetMapping("/drillDownError")
    public ResultUtil drillDownError(PageInfo pageInfo,@RequestParam(value = "pid",required = true) Integer pid,
                                             @RequestParam(value = "eid",required = true) String eid  ){

        Map<String, Object> listPage = null;
        if(pid==11){
            pid = 6;
        }else if(pid==12){
            pid = 7;
        }
        try {
            List<DrPlusErrorQualityLog> list = centerTableService.drillDownError(pid,eid );
            list.forEach(e->{
                if(1==e.getType()){     //1 标准质控表
                    e.setName(bzxService.selectByKey(e.getDrplus_quality_id()).getResult_message());
                }else if(2==e.getType()){//2 完整质控表
                    e.setName(wzxService.selectByKey(e.getDrplus_quality_id()).getResult_message());
                }else if(3==e.getType()){ // 3 逻辑质控表
                    e.setName(ljxService.selectByKey(e.getDrplus_quality_id()).getResult_message());
                }
            });

            listPage = PageList.getListPage(pageInfo, list);

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }









}
