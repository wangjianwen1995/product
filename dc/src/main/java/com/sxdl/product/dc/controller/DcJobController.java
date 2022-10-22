package com.sxdl.product.dc.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.dao.dao1.*;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.impl.DcJobServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = "数据中心接口请求类型接口")
@RestController
@RequestMapping("/dcjob")
public class DcJobController {

    List<DcTable> dcTableList;
    DcTable dcTable;
    @Autowired
    private DcJobServiceImpl dcJobService;
    @Autowired
    private DcJobDao dcJobDao;
    @Autowired
    private DcUserDao dcUserDao;
    @Autowired
    private DcHospitalDao dcHospitalDao;
    @Autowired
    private DcProductDao dcProductDao;
    private List<DcJob> dcJobs;
    private DcJob dcJob;
    private DcHospital dcHospital;
    private List<DcHospital> dcHospitals;
    private List<DcProduct> dcProducts;
    private DcProduct dcProduct;
    @Autowired
    private DcProcedureDao procedureDao;
    @Autowired
    private DcScheduleDao dcScheduleDao;
    @Autowired
    private DcRequestAPIDao requestAPIDao;
    @Autowired
    private DcTableDao dcTableDao;
    @Autowired
    private DcTransferDao dcTransferDao;
    @Autowired
    private DcVirtualTableDao dcVirtualTableDao;
    @Autowired
    private DcTableVsTableDao dcTableVsTableDao;
    @Autowired
    private DcColumnDao dcColumnDao;

    @GetMapping("t")
    public ResultUtil gett() {
        return ResultUtil.success("");
    }
    @ApiOperation(value = "工单表", notes = "工单表通过工单名称模糊查询")
    @GetMapping("/findJobByName")
    @ResponseBody
    public ResultUtil findJobByName(PageInfo pageInfo,
                                    @RequestParam(value = "job_name", required = false) String job_name,
                                    @RequestParam(value = "rule_id", required = false) String rule_id,
                                    @RequestParam(value = "stime", required = false) String stime,
                                    @RequestParam(value = "etime", required = false) String etime) {
        try {
            pageInfo = dcJobService.selectBySome(pageInfo, job_name, rule_id, stime, etime);
            //System.out.println("**********"+Thread.currentThread().getName());
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "工单表", notes = "工单表通过id查询")
    @GetMapping("/findJobById")
    @ResponseBody
    public ResultUtil<DcJob> findJobById(@RequestParam(value = "id", required = true) String id) {
        try {
            DcJob dcJob = dcJobDao.selectByPrimaryKey(id);
            dcProduct = dcProductDao.selectByPrimaryKey(dcJob.getProduct_id());
            dcHospital = dcHospitalDao.selectByPrimaryKey(dcJob.getHospital_id());
            dcJob = relationData(dcJob, dcHospital, dcProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(this.dcJob);
    }

    @ApiOperation(value = "工单表导出方案", notes = "导出方案")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtil findById(@RequestParam(value = "id", required = true) String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            //1.工单信息
            DcJob dcJob = dcJobDao.selectByPrimaryKey(id);

            List<DcProduct> products = new ArrayList<>();//操作相关的产品信息
            Set<String> productIDs = new HashSet<>();
            productIDs.add(dcJob.getProduct_id());
            //2.链接服务器信息
            DcTransfer dcTransfer = new DcTransfer();
            dcTransfer.setJob_id(id);
            List<DcTransfer> transferList = dcTransferDao.select(dcTransfer);
            if (null == transferList && transferList.size() == 0) {
                transferList = new ArrayList<>();
            } else {
                transferList.forEach(e -> {
                    productIDs.add(e.getProduct_id());
                });
            }

            List<DcSchedule> dcScheduleList = new ArrayList<>();
            dcTableList = new ArrayList<>();
            //3.web
            DcRequestAPI dcRequestAPI = new DcRequestAPI();
            dcRequestAPI.setJob_id(id);
            List<DcRequestAPI> requestAPIList = requestAPIDao.select(dcRequestAPI);
            if (null != requestAPIList && requestAPIList.size() > 0) {
                String tag;
                String[] ss;
                for (DcRequestAPI api : requestAPIList) {
                    productIDs.add(api.getProduct_id());
                    dcScheduleList.add(dcScheduleDao.selectByPrimaryKey(api.getSchedule_id()));
                    tag = api.getTag();
                    if (StrUtil.isNotEmpty(tag)) {
                        if (tag.contains(",")) {
                            ss = tag.split(",");
                            for (String e : ss) {
                                if (StrUtil.isNotEmpty(e)) {
                                    dcTableList = getTableInfo(null, e, dcTableList, api.getProduct_id());
                                }
                            }
                        } else {
                            dcTableList = getTableInfo(null, tag, dcTableList, api.getProduct_id());
                        }
                    }
                }
            } else {
                requestAPIList = new ArrayList<>();
            }

            //4.存储信息
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setJob_id(id);
            List<DcProcedure> procedureList = procedureDao.select(dcProcedure);
            if (null != procedureList && procedureList.size() > 0) {
                procedureList.forEach(e -> {
                    productIDs.add(e.getFrom_product_id());
                    productIDs.add(e.getTo_product_id());
                });
            } else {
                procedureList = new ArrayList<>();
            }

            //存放table id produceid 便于查询tableVStable 以及 table
            Set<String> tableSet = new HashSet<>();
            Set<String> procedureSet = new HashSet<>();

            if (null != procedureList && procedureList.size() > 0) {
                procedureList.forEach(e -> {
                    procedureSet.add(e.getId());
                });
            }
            List<DcTableVsTable> dcTableVsTableList = new ArrayList<>();
            List<DcVirtualTable> dcVirtualTableList = new ArrayList<>();
            DcTableVsTable dcTableVsTable = new DcTableVsTable();
            DcVirtualTable dcVirtualTable = new DcVirtualTable();
            DcSchedule dcSchedule = new DcSchedule();
            if (null != procedureSet && procedureSet.size() > 0) {
                procedureSet.forEach(e -> {
                    //7.tablevstable
                    dcTableVsTable.setProcedure_id(e);
                    List<DcTableVsTable> tables = dcTableVsTableDao.select(dcTableVsTable);
                    //dcTableVsTableList.put(e, tables);
                    dcTableVsTableList.addAll(tables);
                    tables.forEach(e2 -> {
                        if (null != e2.getFrom_table_id() && !"".equals(e2.getFrom_table_id())) {
                            tableSet.add(e2.getFrom_table_id());
                        }
                        if (null != e2.getTo_table_id() && !"".equals(e2.getTo_table_id())) {
                            tableSet.add(e2.getTo_table_id());
                        }
                    });
                    //8.virtualtable
                    dcVirtualTable.setProcedure_id(e);
                    List<DcVirtualTable> tableList = dcVirtualTableDao.select(dcVirtualTable);
                    // dcVirtualTableList.put(e, tableList);
                    dcVirtualTableList.addAll(tableList);
                    //9.调度
                    dcSchedule.setProcedure_id(e);
                    List<DcSchedule> scheduleList = dcScheduleDao.select(dcSchedule);
                    // dcScheduleList.put(e, scheduleList);
                    dcScheduleList.addAll(scheduleList);
                });
            }

            if (null != tableSet && tableSet.size() > 0) {
                tableSet.forEach(e -> {
                    //5.table
                    dcTableList = getTableInfo(e, null, dcTableList, null);
                });
            }

            //医院信息
            DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(dcJob.getHospital_id());

            productIDs.forEach(e -> {//产品列表
                products.add(dcProductDao.selectByPrimaryKey(e));
            });
            map.put("dcJobList", dcJob);
            map.put("dcHospital", dcHospital);
            map.put("dcTransferList", transferList);
            map.put("dcRequestAPIList", requestAPIList);
            map.put("dcProcedureList", procedureList);
            map.put("dcTableList", dcTableList);
            map.put("dcScheduleList", dcScheduleList);
            map.put("dcTableVsTableList", dcTableVsTableList);
            map.put("dcVirtualTableList", dcVirtualTableList);
            map.put("dcProductList", products);

            JSONObject jsonObject = JSONUtil.parseObj(map);
            return ResultUtil.success(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    public List<DcTable> getTableInfo(String id, String name, List<DcTable> tabls, String productid) {
        if (StrUtil.isNotEmpty(id)) {
            dcTable = dcTableDao.selectByPrimaryKey(id);
        } else if (StrUtil.isNotEmpty(name)) {
            dcTable = dcTableDao.selectByNameAndProdectID(name, productid);
        } else {
            return tabls;
        }
        dcTable.setDcColumnList(dcColumnDao.selectByTableid(dcTable.getId()));
        tabls.add(dcTable);
        return tabls;
    }

    @ApiOperation(value = "工单表", notes = "添加数据")
    @PostMapping("/insertJob")
    @ResponseBody
    public ResultUtil<List<DcJob>> insertJob(@RequestBody DcJob dcJob) {
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(date);
            dcJob.setCreat_time(format);
            dcJobDao.insertSelective(dcJob);
            return ResultUtil.success("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "工单表", notes = "修改数据")
    @PutMapping("/updateJob")
    @ResponseBody
    public ResultUtil<List<DcJob>> updateJob(@RequestBody DcJob dcJob) {
        try {

            String msg = dcJobService.updateByJob(dcJob);
            if(msg.contains("成功")){
                return ResultUtil.success(msg);
            }else{
                return ResultUtil.error(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }

    }


    @ApiOperation(value = "工单表", notes = "删除数据")
    @DeleteMapping("/deleteJob")
    @ResponseBody
    public ResultUtil<List<DcJob>> deleteJob(@RequestParam(value = "id", required = true) String id) {
        try {
            DcTransfer dcTransfer = new DcTransfer();
            dcTransfer.setJob_id(id);
            List<DcTransfer> transferList = dcTransferDao.select(dcTransfer);
            if (null != transferList && transferList.size() > 0) {
                return ResultUtil.error("此工单已有连接服务器信息不可删除");
            }
            dcJobDao.deleteByPrimaryKey(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }

    }


    @ApiOperation(value = "医院信息", notes = "医院查询全部信息")
    @GetMapping("/findHospitalAll")
    @ResponseBody
    public ResultUtil<List<DcHospital>> findHospitalAll() {
        try {
            this.dcHospitals = dcHospitalDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcHospitals);
    }

    @ApiOperation(value = "医院信息", notes = "医院查询id")
    @GetMapping("/findHospitalById")
    @ResponseBody
    public ResultUtil<DcHospital> findHospitalById(@RequestParam(value = "id", required = true) String id) {
        try {
            this.dcHospital = dcHospitalDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcHospital);
    }

    @ApiOperation(value = "医院信息", notes = "添加医院")
    @PostMapping("/insertHospital")
    @ResponseBody
    public ResultUtil<List<DcHospital>> insertHospital(@RequestBody DcHospital dcHospital) {
        try {
            dcHospitalDao.insert(dcHospital);
            this.dcHospitals = dcHospitalDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcHospitals, "添加成功");
    }


    @ApiOperation(value = "医院信息", notes = "修改医院")
    @PutMapping("/updateHospital")
    @ResponseBody
    public ResultUtil<List<DcHospital>> updateHospital(@RequestBody DcHospital dcHospital) {
        try {
            dcHospitalDao.updateByPrimaryKey(dcHospital);
            this.dcHospitals = dcHospitalDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcHospitals, "修改成功");
    }


    @ApiOperation(value = "医院信息", notes = "删除医院")
    @DeleteMapping("/deleteHospital")
    @ResponseBody
    public ResultUtil<List<DcHospital>> deleteHospital(@RequestParam(value = "id", required = true) String id) {
        try {
            dcHospitalDao.deleteByPrimaryKey(id);
            this.dcHospitals = dcHospitalDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcHospitals, "删除成功");
    }


    @ApiOperation(value = "产品项目", notes = "产品项目查询全部")
    @GetMapping("/findProductAll")
    @ResponseBody
    public ResultUtil<List<DcProduct>> findProductAll() {
        try {
            this.dcProducts = dcProductDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcProducts);
    }


    @ApiOperation(value = "产品项目", notes = "产品项目查询id")
    @GetMapping("/findProductById")
    @ResponseBody
    public ResultUtil<DcProduct> findProductById(@RequestParam(value = "id", required = true) String id) {
        try {
            this.dcProduct = dcProductDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcProduct);
    }


    @ApiOperation(value = "产品项目", notes = "添加产品")
    @PostMapping("/insertProduct")
    @ResponseBody
    public ResultUtil<List<DcProduct>> insertProduct(@RequestBody DcProduct dcProduct) {
        try {
            dcProductDao.insert(dcProduct);
            this.dcProducts = dcProductDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcProducts, "添加成功");
    }


    @ApiOperation(value = "导入", notes = "导入")
    @PostMapping("/insertByJob")
    @ResponseBody
    public ResultUtil insertByJob(MultipartFile files) {
        String result;
        try {
            result = IoUtil.read(files.getInputStream(), CharsetUtil.UTF_8);
//            JSON json=JSONUtil.parseObj(read);
//            String s = json.toString();
            if (!JSONUtil.isJson(result)) {
                return ResultUtil.error("数据格式不正确");
            }
            Map<String, Object> map = com.alibaba.fastjson.JSONObject.parseObject(result, Map.class);
            dcJobService.insertByJob(map);
            return ResultUtil.success("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = "上传失败";
            return ResultUtil.success(result + e.getCause());
        }
    }


    @ApiOperation(value = "产品项目", notes = "修改产品")
    @PutMapping("/updateProduct")
    @ResponseBody
    public ResultUtil<List<DcProduct>> updateProduct(@RequestBody DcProduct dcProduct) {
        try {
            dcProductDao.updateByPrimaryKey(dcProduct);
            this.dcProducts = dcProductDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcProducts, "修改成功");
    }


    @ApiOperation(value = "产品项目", notes = "删除产品")
    @DeleteMapping("/deleteProduct")
    @ResponseBody
    public ResultUtil<List<DcProduct>> deleteProduct(@RequestParam(value = "id", required = true) String id) {
        try {
            dcProductDao.deleteByPrimaryKey(id);
            this.dcProducts = dcProductDao.selectAll();
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(this.dcProducts, "删除成功");
    }


    /**
     * 数据关联修改回显时的名称
     *
     * @param jobs      如题
     * @param hospitals 如题
     * @return 如题
     */
    private List<DcJob> relationDatas(List<DcJob> jobs, List<DcHospital> hospitals, List<DcProduct> products, List<DcUser> dcUsers) {
        for (DcJob job : jobs) {
            for (DcHospital hospital : hospitals) {
                if (job.getHospital_id().equals(hospital.getId())) {
                    job.setHospitalName(hospital.getName());
                    break;
                }
            }

            for (DcProduct product : products) {
                if (job.getProduct_id().equals(product.getId())) {
                    job.setProductName(product.getName_zh());
                    break;
                }
            }

            for (DcUser dcUser : dcUsers) {
                if (job.getUser_id().equals(dcUser.getId())) {
                    job.setUserName(dcUser.getName_zh());
                    break;
                }
            }
        }


        return jobs;


    }


    private DcJob relationData(DcJob job, DcHospital hospital, DcProduct product) {
        job.setProductName(product.getName());
        job.setHospitalName(hospital.getName());
        return job;

    }

}