package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpICCMHistoricalDataDz;
import com.sxdl.hp.service.HpBzdmkService;
import com.sxdl.hp.service.HpICCMHistoryDataDzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "编码对照")
@RestController
@RequestMapping("/dz")
public class HpICDHistoryDataDzController {


    @Autowired
    HpICCMHistoryDataDzService hpICCMHistoryDataDzService;

    PageInfo queryPageList;
    @Autowired
    HpBzdmkService bzdmkService;

    @ApiOperation(value = "根据标准版本查询对照数据")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(PageInfo pageInfo,
                                      @RequestParam(value = "version", required = true) String version,
                                      @RequestParam(value = "status", required = true) String status,
                                      @RequestParam(value = "type", required = true) String type,
                                      @RequestParam(value = "stime", required = true) String stime,
                                      @RequestParam(value = "etime", required = true) String etime) throws Exception {

        Map<String, Object> listPage = new HashMap<>();
        if (type.equals("")) {
            return ResultUtil.success(listPage);
        }
        // String table_name = getTable_name(type);
        List<Map<String, Object>> maps = hpICCMHistoryDataDzService.selectBySome(version, status, type, stime, etime);
        if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
            return ResultUtil.success(maps);
        }

        listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), maps);
        //System.out.println(listPage);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "自动匹配")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody Map<String, String> map) throws Exception {
        if (null == map || map.size() <= 0) {
            return ResultUtil.error("参数有误");
        }

        Boolean s = true;
        String version = map.get("version");
        String version_name = map.get("version_name");
        //System.out.println(version);
        String stime = map.get("stime");
        String etime = map.get("etime");
        String type = map.get("type");
        s = hpICCMHistoryDataDzService.saveDz(version, stime, etime, version_name, type);
        if (!s) {
            return ResultUtil.error("暂无数据");
        }
        return ResultUtil.success("保存成功");
           /* switch (type) {
                case "0":
                    //疾病
                    s = hpICDHistoryDataDzService.saveDz(version, stime, etime,version_name);

                    break;
                case "1":
                    //手术
                    s = hpICCMHistoryDataDzService.saveDz(version, stime, etime,version_name,type);
                    break;
                case "2":
                    //肿瘤
                    s = hpTumourHistoryDataDzService.saveDz(version, stime, etime,version_name);
                    break;
                case "3":
                    //损伤
                    s = hpSSZDHistoryDataDzService.saveDz(version, stime, etime,version_name);
                    break;
                case "4":
                    //中医病症法
                    s = hpZYBZFHistoryDataDzService.saveDz(version, stime, etime,version_name);
                    break;
            }*/
    }

    @ApiOperation(value = "批量修改映射")
    @PutMapping("/update")
    public ResultUtil update(@RequestBody List<HpICCMHistoricalDataDz> map) throws Exception {
        if (null == map || map.size() <= 0) {
            return ResultUtil.error("参数有误");
        }
        //List<HpICCMHistoricalDataDz> list = (List<HpICCMHistoricalDataDz>) map.values ().stream ().collect ( Collectors.toList () ).get ( 0 );
        map.forEach(e -> {
            if (null != e.getReport_dm() && !e.getReport_dm().equals("")) {
                e.setStatus("1");
            }
            hpICCMHistoryDataDzService.updateSelective(e);
        });
        //将标准代码库插入到永久临时表中
        bzdmkService.initBiaozuns();
        return ResultUtil.success("修改成功");
    }

    @ApiOperation(value = "保存或者修改映射")
    @PutMapping("/saveOrUpdate")
    public ResultUtil saveOrUpdate(@RequestBody HpICCMHistoricalDataDz hpICCMHistoricalDataDz) throws Exception {
        hpICCMHistoryDataDzService.saveOrUpdate(hpICCMHistoricalDataDz);
        return ResultUtil.success("修改成功");
    }

    /*private String getTable_name(String type
    ) {
       String tableName="";
        switch (type) {
            case "0":
                //疾病
                tableName="hp_history_icd_dz";
                break;
            case "1":
                //手术
                tableName="hp_history_iccm_dz";
                break;
            case "2":
                //肿瘤
                tableName="hp_history_tumour_dz";
                break;
            case "3":
                //损伤
                tableName="hp_history_sszd_dz";

                break;
            case "4":
                //中医病症法
                tableName="hp_history_zybzf_dz";

                break;
        }
        return tableName;
    }*/

}
