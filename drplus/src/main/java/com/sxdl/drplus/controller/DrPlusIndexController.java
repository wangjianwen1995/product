package com.sxdl.drplus.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.entity.DrplusIndexRemind;
import com.sxdl.drplus.service.DrPlusPlatformDetailedService;
import com.sxdl.drplus.service.DrplusIndexService;
import com.sxdl.drplus.util.ChainCron;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "首页")
@RestController
@RequestMapping("/drindex")
@RequiredArgsConstructor
public class DrPlusIndexController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    private final DrPlusPlatformDetailedService platformdService;

    private final DrplusIndexService indexService;




    @ApiOperation(value = "首页文件模块")
    @GetMapping("/indexFiles")
    public ResultUtil indexFiles( ) {
        Map<Object, List<Map>> pfiles =null;
        try {
            //文件 模块
            String path = System.getProperty("user.dir")+"\\files\\drPlusFiles";
            FileUtil.createFileFolder(path);
            List<Map> file = FileUtil.getFile(path, new ArrayList<Map>());
            if(file!=null||file.size()>0)
                pfiles= file.stream().collect(Collectors.groupingBy(e -> e.get("pid")));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(pfiles);
    }




    @ApiOperation(value = "首页提示模块")
    @GetMapping("/indexRemind")
    public ResultUtil indexRemind( ) {
        Map<Integer, List<DrplusIndexRemind>> collect = null;
        try {
            //key 第一步 处理 过期 的提示
            List<DrplusIndexRemind> list = indexService.getOnRemind();
            //expire
            list.forEach(e->{
                if(!ChainCron.isCanDoExpression(e.getCron())){
                    indexService.expireRemind(e.getId(),-1);
                }
            });

            //key 第二步 处理 正在 提示的
            List<DrPlusPlatformDetailed> platformLists = platformdService.getSheduledData();
            platformLists.forEach(e->{
                if(!StringUtils.isEmpty(e.getCronindex())){
                    //当前时间 符合 cron 表达式 正在执行的
                    if(ChainCron.isCanDoExpression(e.getCronindex())){
                        //判断drplus_index_remind 表中是否 已经存在 提示消息 不存在开始创建
                        String keyRuleStr = ChainCron.getKeyRuleStr(e.getCronindex(), e.getId());
                        if(indexService.isExists(keyRuleStr) == 0){
                            //保存需要提示的信息 ,默认状态是 提醒(未完成操作)
                            saveIndex(e.getId(),e.getCronindex(),keyRuleStr);
                        }
                    }
                }

            });
            //String dateTimeKey = DataUtil.getDateTimeKey();
            //返回信息
            List<DrplusIndexRemind> dataList  = indexService.getRemindData();
            collect = dataList.stream().collect(Collectors.groupingBy(DrplusIndexRemind::getDrplus_platform_detailed_id));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(collect);
    }



    @ApiOperation(value = "关闭提示模块")
    @GetMapping("/OffIndexRemind")
    public ResultUtil OffIndexRemind(@RequestParam(value = "id",required = true) Integer id) {
        try {
              indexService.OffIndexRemind(id,1);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }






    private void saveIndex(Integer pid,String cron,String keyRuleStr){
        DrplusIndexRemind remind = new DrplusIndexRemind();
        remind.setDrplus_platform_detailed_id(pid);
        remind.setCron(cron);
        remind.setCreate_time( DataUtil.getDateTime());
        remind.setStates(0);
        remind.setId_rule(keyRuleStr);
        remind.setContentinfo(ChainCron.translateToChinese(cron, ChainCron.CRON_TIME_CN));
        Integer integer = indexService.saveSimple(remind);
    }

}
