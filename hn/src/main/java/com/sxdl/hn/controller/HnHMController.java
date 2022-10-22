package com.sxdl.hn.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.entity.*;
import com.sxdl.hn.service.*;
import com.sxdl.hn.util.DataUtil;
import com.sxdl.hn.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Api(tags = "侯马护理")
@RestController
@RequestMapping("/hmhn")
public class HnHMController {

    public static final String LineBreak = "\r\n";
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private HmnkvteService hmnkvteService;

    @Autowired
    private HmblsjService hmblsjService;
    @Autowired
    private HmwkvteService hmwkvteService;


    /****************************内科VTE*************************************/

    @ApiOperation(value = "获取内科VTE列表数据")
    @GetMapping("/getNkvteList")
    public ResultUtil getNkvteList(PageInfo pageInfo,
                                   @RequestParam(value = "stime", required = true) String stime,
                                   @RequestParam(value = "etime", required = true) String etime,
                                   @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                   @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmnkvte.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }

            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmnkvte> list = hmnkvteService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改内科VET")
    @PostMapping("/saveNkvte")
    public ResultUtil saveNkvte(@RequestBody Hmnkvte hmnkvte) {
        try {
            hmnkvteService.saveSimple(hmnkvte);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除内科VET")
    @DeleteMapping("/delNkvte")
    public ResultUtil delNkvte(@RequestParam(value = "id", required = true) String id) {
        try {
            hmnkvteService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /****************************护理不良事件*************************************/


    @ApiOperation(value = "获取护理不良事件列表数据")
    @GetMapping("/getblsjList")
    public ResultUtil getblsjList(PageInfo pageInfo,
                                  @RequestParam(value = "stime", required = true) String stime,
                                  @RequestParam(value = "etime", required = true) String etime,
                                  @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                  @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmblsj.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("bgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("bgsj desc");
            List<Hmblsj> list = hmblsjService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改不良事件")
    @PostMapping("/saveBlsj")
    public ResultUtil saveBlsj(@RequestBody Hmblsj hmblsj) {
        try {
            hmblsjService.saveSimple(hmblsj);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除不良事件")
    @DeleteMapping("/delBlsj")
    public ResultUtil delBlsj(@RequestParam(value = "id", required = true) String id) {
        try {
            hmblsjService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /****************************外科VTE*************************************/

    @ApiOperation(value = "获取外科VTE列表数据")
    @GetMapping("/getWkvteList")
    public ResultUtil getWkvteList(PageInfo pageInfo,
                                   @RequestParam(value = "stime", required = true) String stime,
                                   @RequestParam(value = "etime", required = true) String etime,
                                   @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                   @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmwkvte.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmwkvte> list = hmwkvteService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改外科VET")
    @PostMapping("/saveWkvte")
    public ResultUtil saveWkvte(@RequestBody Hmwkvte hmwkvte) {
        try {
            hmwkvteService.saveSimple(hmwkvte);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除外科VET")
    @DeleteMapping("/delWkvte")
    public ResultUtil delWkvte(@RequestParam(value = "id", required = true) String id) {
        try {
            hmwkvteService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**********************************入院患者评估表*******************************/
    @Autowired
    private HmRyhzpgbService hmRyhzpgbService;

    @ApiOperation(value = "获取列表数据 院患者评估")
    @GetMapping("/getRyhzpgbList")
    public ResultUtil getRyhzpgbList(PageInfo pageInfo,
                                     @RequestParam(value = "stime", required = true) String stime,
                                     @RequestParam(value = "etime", required = true) String etime,
                                     @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                     @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(HmRyhzpgb.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<HmRyhzpgb> list = hmRyhzpgbService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 院患者评估")
    @PostMapping("/saveRyhzpgb")
    public ResultUtil saveRyhzpgb(@RequestBody HmRyhzpgb data) {
        try {
            hmRyhzpgbService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 院患者评估")
    @DeleteMapping("/delRyhzpgb")
    public ResultUtil delRyhzpgb(@RequestParam(value = "id", required = true) String id) {
        try {
            hmRyhzpgbService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /***********************************手术室压疮危险因素评估表******************************/
    @Autowired
    private HmsssycService hmsssycService;

    @ApiOperation(value = "获取列表数据 手术室压疮危险因素评估表")
    @GetMapping("/getsssycList")
    public ResultUtil getsssycList(PageInfo pageInfo,
                                   @RequestParam(value = "stime", required = true) String stime,
                                   @RequestParam(value = "etime", required = true) String etime,
                                   @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                   @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmsssyc.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmsssyc> list = hmsssycService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 手术室压疮危险因素评估表")
    @PostMapping("/savesssyc")
    public ResultUtil savesssyc(@RequestBody Hmsssyc data) {
        try {
            hmsssycService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 手术室压疮危险因素评估表")
    @DeleteMapping("/delsssyc")
    public ResultUtil delsssyc(@RequestParam(value = "id", required = true) String id) {
        try {
            hmsssycService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /*********************************围手术期护理评估单********************************/

    @Autowired
    private HmwssqService hmwssqService;

    @ApiOperation(value = "获取列表数据 围手术期护理评估单")
    @GetMapping("/getwssqList")
    public ResultUtil getwssqList(PageInfo pageInfo,
                                  @RequestParam(value = "stime", required = true) String stime,
                                  @RequestParam(value = "etime", required = true) String etime,
                                  @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                  @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmwssq.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmwssq> list = hmwssqService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 围手术期护理评估单")
    @PostMapping("/savewssq")
    public ResultUtil savewssq(@RequestBody Hmwssq data) {
        try {
            hmwssqService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 围手术期护理评估单")
    @DeleteMapping("/delwssq")
    public ResultUtil delwssq(@RequestParam(value = "id", required = true) String id) {
        try {
            hmwssqService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /************************************疼痛评分*****************************/


    @Autowired
    private HmttpfService hmttpfService;

    @ApiOperation(value = "获取列表数据 疼痛评分")
    @GetMapping("/getttpfList")
    public ResultUtil getttpfList(PageInfo pageInfo,
                                  @RequestParam(value = "stime", required = true) String stime,
                                  @RequestParam(value = "etime", required = true) String etime,
                                  @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                  @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmttpf.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmttpf> list = hmttpfService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 疼痛评分")
    @PostMapping("/savettpf")
    public ResultUtil savettpf(@RequestBody Hmttpf data) {
        try {
            hmttpfService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 疼痛评分")
    @DeleteMapping("/delttpf")
    public ResultUtil delttpf(@RequestParam(value = "id", required = true) String id) {
        try {
            hmttpfService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /******************************烫伤评分***********************************/

    @Autowired
    private HmtspfService hmtspfService;

    @ApiOperation(value = "获取列表数据 烫伤评分")
    @GetMapping("/gettspfList")
    public ResultUtil gettspfList(PageInfo pageInfo,
                                  @RequestParam(value = "stime", required = true) String stime,
                                  @RequestParam(value = "etime", required = true) String etime,
                                  @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                  @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmtspf.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmtspf> list = hmtspfService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 烫伤评分")
    @PostMapping("/savetspf")
    public ResultUtil savetspf(@RequestBody Hmtspf data) {
        try {
            hmtspfService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 烫伤评分")
    @DeleteMapping("/deltspf")
    public ResultUtil deltspf(@RequestParam(value = "id", required = true) String id) {
        try {
            hmtspfService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**********************************压疮评分*******************************/


    @Autowired
    private HmycpfService hmycpfService;


    @ApiOperation(value = "获取列表数据 压疮")
    @GetMapping("/getycpfList")
    public ResultUtil getycpfList(PageInfo pageInfo,
                                  @RequestParam(value = "stime", required = true) String stime,
                                  @RequestParam(value = "etime", required = true) String etime,
                                  @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                  @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmycpf.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmycpf> list = hmycpfService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 压疮")
    @PostMapping("/saveycpf")
    public ResultUtil saveycpf(@RequestBody Hmycpf data) {
        try {
            hmycpfService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 压疮")
    @DeleteMapping("/delycpf")
    public ResultUtil delycpf(@RequestParam(value = "id", required = true) String id) {
        try {
            hmycpfService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /***********************************自理能力******************************/


    @Autowired
    private HmzlnlpfService hmzlnlpfService;

    @ApiOperation(value = "获取列表数据 自理能力")
    @GetMapping("/getzlnlpfList")
    public ResultUtil getzlnlpfList(PageInfo pageInfo,
                                    @RequestParam(value = "stime", required = true) String stime,
                                    @RequestParam(value = "etime", required = true) String etime,
                                    @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                    @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmzlnlpf.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmzlnlpf> list = hmzlnlpfService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 自理能力")
    @PostMapping("/savezlnlpf")
    public ResultUtil savezlnlpf(@RequestBody Hmzlnlpf data) {
        try {
            hmzlnlpfService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 自理能力")
    @DeleteMapping("/delzlnlpf")
    public ResultUtil delzlnlpf(@RequestParam(value = "id", required = true) String id) {
        try {
            hmzlnlpfService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**********************************跌倒坠床评估*******************************/

    @Autowired
    private HmddzcpfService hmddzcpfService;

    @ApiOperation(value = "获取列表数据 跌倒坠床评估")
    @GetMapping("/getddzcpfList")
    public ResultUtil getddzcpfList(PageInfo pageInfo,
                                    @RequestParam(value = "stime", required = true) String stime,
                                    @RequestParam(value = "etime", required = true) String etime,
                                    @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                    @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmddzcpf.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmddzcpf> list = hmddzcpfService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 跌倒坠床评估")
    @PostMapping("/saveddzcpf")
    public ResultUtil saveddzcpf(@RequestBody Hmddzcpf data) {
        try {
            hmddzcpfService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 跌倒坠床评估")
    @DeleteMapping("/delddzcpf")
    public ResultUtil delddzcpf(@RequestParam(value = "id", required = true) String id) {
        try {
            hmddzcpfService.deleteById(id);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /*******************************管路脱出评分**********************************/

    @Autowired
    private HmglhcpfService hmglhcpfService;


    @ApiOperation(value = "获取列表数据 管路脱出评分")
    @GetMapping("/getHmglhcpfList")
    public ResultUtil getHmglhcpfList(PageInfo pageInfo,
                                      @RequestParam(value = "stime", required = true) String stime,
                                      @RequestParam(value = "etime", required = true) String etime,
                                      @RequestParam(value = "kscode", defaultValue = "") String kscode,
                                      @RequestParam(value = "val", required = false, defaultValue = "") String val) {
        PageInfo pageList = null;
        try {

            Example example = new Example(Hmglhcpf.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andBetween("pgsj", stime, etime);
            if (!StringUtils.isEmpty(kscode)) {
                criteria.andEqualTo("ry_code", kscode);
            }
            if (!StringUtils.isEmpty(val)) {
                criteria.andLike("name", "%" + val + "%")
                        .orLike("zyh", "%" + val + "%");
            }
            example.setOrderByClause("pgsj desc");
            List<Hmglhcpf> list = hmglhcpfService.selectByExample(example);
            pageList = PageUtil.getPageInfo(list, pageInfo);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(pageList);
    }


    @ApiOperation(value = "保存修改 管路脱出评分")
    @PostMapping("/saveglhcpf")
    public ResultUtil saveglhcpf(@RequestBody Hmglhcpf data) {
        try {
            hmglhcpfService.saveSimple(data);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除 管路脱出评分")
    @DeleteMapping("/delglhcpf")
    public ResultUtil delglhcpf(@RequestParam(value = "id", required = true) String id) {
        try {
            hmglhcpfService.deleteById(id);
            return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            return ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
    }




}
