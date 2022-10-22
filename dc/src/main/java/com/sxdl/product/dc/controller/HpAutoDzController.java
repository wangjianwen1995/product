package com.sxdl.product.dc.controller;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "icdAuto编码对照")
@RestController
@RequestMapping("/icddz")
public class HpAutoDzController {


    @Autowired
    HpICCMGxbService hpICCMGxbService;
    @Autowired
    HpICDGxbService hpICDGxbService;
    @Autowired
    HpSSZDGxbService hpSSZDGxbService;
    @Autowired
    HpTumourGxbService hpTumourGxbService;
    @Autowired
    HpZYBZFGxbService hpZYBZFGxbService;
    @Autowired
    HpSSCZService hpSSCZService;

    @ApiOperation(value = "根据不同版本查询已对照数据")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(PageInfo pageInfo, @RequestParam(value = "leftVersion", required = true) String leftVersion,
                                      @RequestParam(value = "rightVersion", required = true) String rightVersion,
                                      @RequestParam(value = "type", required = true) String type, @RequestParam(value = "name", required = true) String name) throws Exception {

        Map<String, Object> listPage = new HashMap<>();
        if (leftVersion.equals("") || rightVersion.equals("") || type.equals("")) {
            return ResultUtil.success(listPage);
        }
        Map<String, String> map = getTable_name(type);
        List<HpICCMGxb> list = hpICCMGxbService.selectSome(leftVersion, rightVersion, map.get("tableName"), name);
        if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
            return ResultUtil.success(list);
        }
        listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        return ResultUtil.success(listPage);
    }

    /*
     * status: 0:未对照 1：已对照 2：已导入 */
    @ApiOperation(value = "查询关系表")
    @GetMapping("/findGxb")
    public ResultUtil findGxb(PageInfo pageInfo, String leftVersion, String rightVersion, String type, String status) throws Exception {
        String gxType = leftVersion + "_" + rightVersion;
        PageInfo queryPageList = new PageInfo();

        switch (type) {
            case "0":
                //疾病
                HpICDGxb hpICDGxb = new HpICDGxb();
                hpICDGxb.setType(gxType);
                if (!status.equals("")) {
                    hpICDGxb.setStatus(status);
                }
                queryPageList = hpICDGxbService.queryPageList(pageInfo, hpICDGxb);
                break;

            case "1":
                //手术
                HpICCMGxb hpICCMGxb = new HpICCMGxb();
                hpICCMGxb.setType(gxType);
                if (!status.equals("")) {
                    hpICCMGxb.setStatus(status);
                }


                queryPageList = hpICCMGxbService.queryPageList(pageInfo, hpICCMGxb);

                break;
            case "2":
                //肿瘤
                HpTumourGxb hpTumourGxb = new HpTumourGxb();
                hpTumourGxb.setType(gxType);
                if (!status.equals("")) {
                    hpTumourGxb.setStatus(status);
                }

                queryPageList = hpTumourGxbService.queryPageList(pageInfo, hpTumourGxb);
                break;
            case "3":
                //损伤
                HpSSZDGxb hpSSZDGxb = new HpSSZDGxb();
                hpSSZDGxb.setType(gxType);
                if (!status.equals("")) {
                    hpSSZDGxb.setStatus(status);
                }

                queryPageList = hpSSZDGxbService.queryPageList(pageInfo, hpSSZDGxb);

                break;
            case "4":
                //中医病症法
                HpZYBZFGxb hpZYBZFGxb = new HpZYBZFGxb();
                hpZYBZFGxb.setType(gxType);
                if (!status.equals("")) {
                    hpZYBZFGxb.setStatus(status);
                }

                queryPageList = hpZYBZFGxbService.queryPageList(pageInfo, hpZYBZFGxb);
                break;
        }
        return ResultUtil.success(queryPageList);
    }

    /*
        @ApiOperation(value = "新增版本查询已对照数据")
        @GetMapping("/findNewByCondition")
        public ResultUtil findNewByCondition(PageInfo pageInfo, @RequestParam(value = "leftVersion", required = true) String leftVersion,
                                             @RequestParam(value = "rightVersion", required = true) String rightVersion,
                                             @RequestParam(value = "flag", required = true) String flag,
                                             @RequestParam(value = "type", required = true) String type
        ) {
            try {
                switch (type) {
                    case "0":
                        //疾病
                        list = hpICDGxbService.selectnNewVersionSome(leftVersion, rightVersion, flag, type);

                        break;
                    case "1":
                        //手术
                        list = hpICCMGxbService.selectnNewVersionSome(leftVersion, rightVersion, flag, type);
                        break;
                    case "2":
                        //肿瘤
                        list = hpTumourGxbService.selectnNewVersionSome(leftVersion, rightVersion, flag, type);
                        break;
                    case "3":
                        //损伤
                        list = hpSSZDGxbService.selectnNewVersionSome(leftVersion, rightVersion, flag, type);
                        break;
                    case "4":
                        //中医病症法
                        list = hpZYBZFGxbService.selectnNewVersionSome(leftVersion, rightVersion, flag, type);
                        break;
                }
                if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                    return ResultUtil.success(list);
                }
                Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
                return ResultUtil.success(listPage);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return ResultUtil.error("查询有误");
            }
        }
    */
    @ApiOperation(value = "模糊查询标准新版本数据")
    @GetMapping("/findWzdData")
    public ResultUtil findWzdData(
            @RequestParam(value = "rightVersion", required = true) String rightVersion,
            @RequestParam(value = "leftMc", required = true) String leftMc,
            @RequestParam(value = "type", required = true) String type) throws Exception {
        List list = hpICCMGxbService.findWzdData(rightVersion, type, leftMc);
        return ResultUtil.success(list);
    }

   /* @ApiOperation(value = "查询对照表的某一个版本以及标准库的某一个版本")
    @GetMapping("/findByVersion")
    public ResultUtil findByVersion(PageInfo pageInfo, @RequestParam(value = "leftVersion", required = true) String leftVersion,
                                    @RequestParam(value = "rightVersion", required = true) String rightVersion,
                                    @RequestParam(value = "type", required = true) String type

    ) {

        try {
            Map<String, String> tableName = getTable_name(type);
            Map<String, List<HpICCMGxb>> map = hpICCMGxbService.selectLeftAndBzVersion(leftVersion, rightVersion, type, tableName.get("tableName"));
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(map);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), map);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultUtil.error("查询有误");
        }
    }*/


    @ApiOperation(value = "保存关系表")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody Map<String, String> paramMap) throws Exception {
        if (null == paramMap || paramMap.size() <= 0) {
            return ResultUtil.error("参数有误");
        }
        String leftVersion = paramMap.get("leftVersion");
        String rightVersion = paramMap.get("rightVersion");
        String type = paramMap.get("type");
        if (null == type || type.equals("")) {
            return ResultUtil.success("请选择分类");
        }
        if (null == leftVersion || leftVersion.equals("") || null == rightVersion || rightVersion.equals("")) {
            return ResultUtil.success("请选择对应的版本");
        }
        Map<String, String> map = getTable_name(type);
        hpICDGxbService.saveGxb(leftVersion, rightVersion, type, map.get("tableName"), map.get("gxbName"));
           /* switch (type) {
                case "0":
                    //疾病
                    hpICDGxbService.saveGxb(leftVersion, rightVersion, type, map.get("tableName"), map.get("gxbName"));

                    break;
                case "1":
                    //手术
                    hpICCMGxbService.saveGxb(leftVersion, rightVersion, type, map.get("tableName"), map.get("gxbName"));
                    break;
                case "2":
                    //肿瘤
                    hpTumourGxbService.saveGxb(leftVersion, rightVersion, type, map.get("tableName"), map.get("gxbName"));
                    break;
                case "3":
                    //损伤
                    hpSSZDGxbService.saveGxb(leftVersion, rightVersion, type, map.get("tableName"), map.get("gxbName"));
                    break;
                case "4":
                    //中医病症法
                    hpZYBZFGxbService.saveGxb(leftVersion, rightVersion, type, map.get("tableName"), map.get("gxbName"));
                    break;
            }
*/
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "关系表完整自动导入版本对照")
    @PostMapping("/saveDz")
    public ResultUtil saveDz(@RequestBody Map<String, String> paramMap) throws Exception {
        if (null == paramMap || paramMap.size() <= 0) {
            return ResultUtil.error("参数有误");
        }
        String leftVersion = paramMap.get("leftVersion");
        String rightVersion = paramMap.get("rightVersion");
        String type = paramMap.get("type");
        if (null == type || type.equals("")) {
            return ResultUtil.success("请选择分类");
        }
        if (null == leftVersion || leftVersion.equals("") || null == rightVersion || rightVersion.equals("")) {
            return ResultUtil.success("请选择对应的版本");
        }
        Map<String, String> map = getTable_name(type);
        String result = hpICCMGxbService.saveDz(leftVersion, rightVersion, type, map.get("tableName"), map.get("gxbName"));
        return ResultUtil.success(result);
    }


    @ApiOperation(value = "查询手术等级版本")
    @GetMapping("/findBySSdjVersion")
    public ResultUtil findBySSdjVersion() throws Exception {
        Map<Integer, List<SysDictVal>> baMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        List<SysDictVal> sysDictVals = baMap.get(103);
        if (null == sysDictVals && sysDictVals.size() <= 0) {
            return ResultUtil.error("手术等级字典未初始化，查不到版本信息");
        }
        SysDictVal sysDictVal = sysDictVals.get(0);
        return ResultUtil.success(sysDictVal);
    }


    /*
     * leftVersion:当前使用版本
     * rightVersion：即将使用版本
     * */
    @ApiOperation(value = "更新手术等级")
    @PostMapping("/updateICCM")
    public ResultUtil updateICCM(@RequestBody Map<String, String> paramMap) throws Exception {
        if (null == paramMap || paramMap.size() <= 0) {
            return ResultUtil.error("参数有误");
        }
        String leftVersion = paramMap.get("leftVersion");
        String rightVersion = paramMap.get("rightVersion");
        if (null == leftVersion || leftVersion.equals("") || null == rightVersion || rightVersion.equals("")) {
            return ResultUtil.success("请选择对应的版本");
        }
        HpSSCZ hpSSCZ = new HpSSCZ();
        hpSSCZ.setSsdjversion(rightVersion);
        List<HpSSCZ> list = hpSSCZService.select(hpSSCZ);
        if (null == list || list.size() <= 0) {

            return ResultUtil.error("数据库手术等级版本库未更新");
        }
        hpICCMGxbService.updateSSdj(leftVersion, rightVersion);
        return ResultUtil.success("更新成功");
    }

    /*
     * status 1
     * */
    @ApiOperation(value = "修改关系表未匹配映射")
    @PutMapping("/update")
    public ResultUtil update(@RequestBody Map<String, Object> map) throws Exception {
        if (null == map || map.size() <= 0) {
            return ResultUtil.error("参数有误");
        }
        List<Object> list = (List<Object>) map.get("list");
        String type = (String) map.get("type");
        if (null == type || type.equals("")) {
            return ResultUtil.success("请选择分类");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        switch (type) {
            case "0":
                //疾病
                list.forEach(e -> {
                    HpICDGxb e1 = objectMapper.convertValue(e, HpICDGxb.class);
                    e1.setStatus("1");
                    hpICDGxbService.updateSelective(e1);
                });
                break;

            case "1":
                //手术
                list.forEach(e -> {
                    HpICCMGxb e2 = objectMapper.convertValue(e, HpICCMGxb.class);
                    e2.setStatus("1");
                    hpICCMGxbService.updateSelective(e2);
                });
                break;
            case "2":
                //肿瘤
                list.forEach(e -> {
                    HpTumourGxb e3 = objectMapper.convertValue(e, HpTumourGxb.class);
                    e3.setStatus("1");
                    hpTumourGxbService.updateSelective(e3);
                });
                break;
            case "3":
                //损伤
                list.forEach(e -> {
                    HpSSZDGxb e4 = objectMapper.convertValue(e, HpSSZDGxb.class);
                    e4.setStatus("1");
                    hpSSZDGxbService.updateSelective(e4);
                });
                break;
            case "4":
                //中医病症法
                list.forEach(e -> {
                    HpZYBZFGxb e5 = objectMapper.convertValue(e, HpZYBZFGxb.class);
                    e5.setStatus("1");
                    hpZYBZFGxbService.updateSelective(e5);
                });
                break;
        }
        return ResultUtil.success("修改成功");
    }


    @ApiOperation(value = "查询已对照大版本下拉框")
    @GetMapping("/findIcdColum")
    public ResultUtil findIcdYdzColum(@RequestParam(value = "type", required = true) String type) throws Exception {
        Map<String, String> tableName = getTable_name(type);
        List name = hpICCMGxbService.getIcdYdzVersion(tableName.get("tableName"));
        return ResultUtil.success(name);
    }

    @ApiOperation(value = "查询未对照大版本下拉框")
    @GetMapping("/findIcdWzdColum")
    public ResultUtil findIcdColum(@RequestParam(value = "type", required = true) String type) throws Exception {
        Map<String, String> tableName = getTable_name(type);
        List name = hpICCMGxbService.getWdzVersion(type, tableName.get("tableName"));
        return ResultUtil.success(name);
    }

    public Map<String, String> getTable_name(String type) throws Exception {
        Map<String, String> mapName = new HashMap<>();
        switch (type) {
            case "0":
                //疾病
                mapName.put("tableName", "hp_ICDAutoDz");
                mapName.put("gxbName", "hp_icd_gxb");
                break;
            case "1":
                //手术
                mapName.put("tableName", "hp_ICCMAutoDz");
                mapName.put("gxbName", "hp_iccm_gxb");
                break;
            case "2":
                //肿瘤
                mapName.put("tableName", "hp_TumourAutoDz");
                mapName.put("gxbName", "hp_tumour_gxb");
                break;
            case "3":
                //损伤
                mapName.put("tableName", "hp_SSZDAutoDz");
                mapName.put("gxbName", "hp_sszd_gxb");

                break;
            case "4":
                //中医病症法
                mapName.put("tableName", "hp_ZYBZFAutoDz");
                mapName.put("gxbName", "hp_zybzf_gxb");

                break;
        }
        return mapName;
    }

    @ApiOperation(value = "重置版本映射")
    @PutMapping("/resetDz")
    public ResultUtil resetDz(@RequestBody Map<String, String> paramMap) throws Exception {
        if (null == paramMap || paramMap.size() <= 0) {
            return ResultUtil.error("参数有误");
        }
        String leftVersion = paramMap.get("leftVersion");
        String rightVersion = paramMap.get("rightVersion");
        String type = paramMap.get("type");
        if (null == type || type.equals("")) {
            return ResultUtil.success("请选择分类");
        }
        if (null == leftVersion || leftVersion.equals("") || null == rightVersion || rightVersion.equals("")) {
            return ResultUtil.success("请选择对应的版本");
        }
        Map<String, String> map = getTable_name(type);
        hpICCMGxbService.resetDz(leftVersion, rightVersion, map.get("gxbName"), map.get("tableName"));
        return ResultUtil.success("重置成功");
    }
}
