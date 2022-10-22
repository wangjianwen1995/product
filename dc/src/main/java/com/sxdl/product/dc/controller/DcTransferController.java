package com.sxdl.product.dc.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.GetDataFromApp;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcProcedure;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.entity.DcTransfer;
import com.sxdl.product.dc.service.DcProcedureService;
import com.sxdl.product.dc.service.DcProductService;
import com.sxdl.product.dc.service.DcTableVsTableService;
import com.sxdl.product.dc.service.DcTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Api(tags = "多源数据库到DC传输信息")
@RestController
@RequestMapping("/transfer")
@ResponseBody
public class DcTransferController {
    @Autowired
    private DcTransferService dcTransferService;
    @Autowired
    private DcProcedureService dcProcedureService;
    @Autowired
    private DcTableVsTableService dcTableVsTableService;
    @Autowired
    YmlUtil ymlUtil;
    @Autowired
    private HandleDao handleDao;
   /* @Autowired
    private DcTransferDbtypeService dcTransferDbtypeService;*/

    //查询所有医院
    @ApiOperation(value = "查询", notes = "查询链接服务器信息")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DcTransfer>> findAll(PageInfo pageInfo) {
        try {
            DcTransfer dcTransfer = new DcTransfer();
            PageInfo<DcTransfer> list = dcTransferService.queryPageList(pageInfo, dcTransfer);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @Autowired
    DcProductService dcProductService;

    @ApiOperation(value = "查询", notes = "查询链接服务器信息")
    @GetMapping("/findByJobId")
    public ResultUtil findByJobId(PageInfo pageInfo, @RequestParam(value = "job_id", required = true) String job_id,
                                  @RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "from_type", required = false) String from_type) {
        try {
            DcTransfer dcTransfer = new DcTransfer();
            dcTransfer.setJob_id(job_id);
            dcTransfer.setName(name);
            dcTransfer.setFrom_type(from_type);
            List<DcProduct> products = dcProductService.findAll();
            Map<String, String> collect = products.stream().collect(Collectors.toMap(DcProduct::getId, DcProduct::getName_zh));
            Map<String, String> collect2 = products.stream().collect(Collectors.toMap(DcProduct::getId, DcProduct::getShort_name_zh));
            PageInfo<DcTransfer> list = dcTransferService.queryPageList(pageInfo, dcTransfer);
            list.getList().forEach(e -> {
                e.setFromPorductName(collect.get(e.getResource_product_id()));
                e.setToPorductName(collect.get(e.getProduct_id()));
                e.setToPorductShortName(collect2.get(e.getProduct_id()));
            });
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询", notes = "去映射根据id查询链接服务器信息")
    @GetMapping("/findById")
    public ResultUtil findById(@RequestParam(value = "dcTransfer_id", required = true) String dcTransfer_id) {
        try {
            Map<String, String> map = new HashMap<>();
            String transfer = "";
            DcTransfer byId = dcTransferService.findById(dcTransfer_id);

            String name = byId.getName();
            String dbname = byId.getDbname();
            Integer isogeny = byId.getIsogeny();
            String fromType = byId.getFrom_type();
            if (fromType.contains("OraOLEDB.Oracle")) {
                transfer = name + "..";
            } else {
                if (null != isogeny && isogeny == 1) {
                    transfer = dbname + ".dbo.";
                } else {
                    transfer = name + "." + dbname + ".dbo.";
                }
            }
            map.put("fromType", fromType);
            map.put("transfer", transfer);
            map.put("name", name);
            DcProduct dcProduct = dcProductService.findById(byId.getResource_product_id());
            map.put("prefix", dcProduct.getPrefix());
            return ResultUtil.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    //查询所有医院
    @ApiOperation(value = "查询", notes = "根据条件查询链接服务器信息")
    @GetMapping("/findByFactor")
    public ResultUtil<PageInfo<DcTransfer>> findByfactor(PageInfo pageInfo, @RequestParam(value = "formType", defaultValue = "") String fromType,
                                                         @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            DcTransfer dcTransfer = new DcTransfer();
            dcTransfer.setName(name);
            dcTransfer.setFrom_type(fromType);
            PageInfo<DcTransfer> list = dcTransferService.queryPageList(pageInfo, dcTransfer);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "测试", notes = "测试链接服务器")
    @PostMapping("/findTest")
    public ResultUtil<DcTransfer> checkout(@RequestBody DcTransfer dcTransfer) {
        try {
            //DB2OLEDB
            String fromType = dcTransfer.getFrom_type();
            String status = "";
            String linkStr = dcTransfer.getLink_str();

            String name = dcTransfer.getName();
            String fromUrl = dcTransfer.getFrom_uri();
            String username = dcTransfer.getFrom_username();
            String pwd = dcTransfer.getFrom_pwd();
            status = dcTransferService.findInfo(name, fromType, fromUrl, username, pwd, linkStr);

            if (status != null) {
                if ("1".equals(status)) {
                    return ResultUtil.error("该链接服务器已存在");
                } else if ("2".equals(status)) {
                    return ResultUtil.success("创建链接服务器成功");
                } else if ("3".equals(status)) {
                    return ResultUtil.error("创建链接服务器失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.error("创建链接服务器成功");
    }

    //删除医院信息
    @ApiOperation(value = "删除", notes = "删除链接服务器")
    @DeleteMapping("/delete")
    public ResultUtil<DcTransfer> deleteLink(@RequestBody DcTransfer dcTransfer) {
        try {
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setTransfer_id(dcTransfer.getId());
            List<DcProcedure> procedures = dcProcedureService.select(dcProcedure);
            if (null != procedures && procedures.size() > 0) {
                return ResultUtil.error("该链接服务器下面存在对照映射不可删除");
            }
            String sql = "exec sp_dropserver @name,'droplogins' ";
            dcTransferService.delete(dcTransfer);
            if (dcTransfer.getIsogeny() == 0) {
                dcTransferService.deleteServerLink(sql.replace("@name", dcTransfer.getName()));
            }
            return ResultUtil.success("删除链接服务器");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增", notes = "新增链接服务器")
    @PostMapping("/insert")
    public ResultUtil<DcTransfer> insertLink(@RequestBody DcTransfer dcTransfer) {
        try {
            String dataBaseType = "";
            String toDataBaseType = "";
            if (null == dcTransfer.getFrom_type_id() || "".equals(dcTransfer.getFrom_type_id())) {
                dataBaseType = "1";
            } else {
                dataBaseType = dcTransfer.getFrom_type_id().toString();
            }

            if (null == dcTransfer.getTo_type_id() || "".equals(dcTransfer.getTo_type_id())) {
                toDataBaseType = "1";
            } else {
                toDataBaseType = dcTransfer.getFrom_type_id().toString();
            }
            //判断是否同源同库
            String url = ymlUtil.getYmlValue("spring.datasource.primary.url");
            String DBName = url.split("=")[1];
            if(1== dcTransfer.getIsogenytk()){
                dcTransfer.setDbname(DBName);
                dcTransfer.setIsogeny(1);
            }
            if(1== dcTransfer.getTo_isogenytk()){
                dcTransfer.setTo_dbname(DBName);
                dcTransfer.setTo_isogeny(1);
            }


            //DcTransferDbtype dbtype = dcTransferDbtypeService.findById(dcTransfer.getFrom_type_id());
            SysDictVal dcDitVal = GetDataFromApp.getDcDitVal(5, dataBaseType);
            SysDictVal toDcDitVal = GetDataFromApp.getDcDitVal(5, toDataBaseType);
            //dcTransfer.setFrom_type(dbtype.getProp());
            dcTransfer.setFrom_type(dcDitVal.getRemark());
            dcTransfer.setTo_type(toDcDitVal.getRemark());
            dcTransfer.setTime(String.valueOf(System.currentTimeMillis()));
            dcTransferService.insert(dcTransfer);
            return ResultUtil.success("新增链接服务器成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    @ApiOperation(value = "修改", notes = "修改链接服务器")
    @PutMapping("/update")
    public ResultUtil<DcTransfer> updateLink(@RequestBody Map<String, DcTransfer> map) {
        try {
            //旧的
            DcTransfer dcTransfer1 = map.get("trans");
            //新的
            DcTransfer dcTransfer = map.get("DcTransfer");

            String url = ymlUtil.getYmlValue("spring.datasource.primary.url");
            String DBName = url.split("=")[1];
            if(1== dcTransfer.getIsogenytk()){
                dcTransfer.setDbname(DBName);
                dcTransfer.setIsogeny(1);
            }
            if(1== dcTransfer.getTo_isogenytk()){
                dcTransfer.setTo_dbname(DBName);
                dcTransfer.setTo_isogeny(1);
            }
            dcTransferService.update(dcTransfer);
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setTransfer_id(dcTransfer.getId());
            List<DcProcedure> procedureList = dcProcedureService.select(dcProcedure);
            if (null != procedureList && procedureList.size() > 0) {
                String link_old = "";
                String link_new = "";
                if (dcTransfer1.getIsogeny() != 1) {
                    if ("SQLOLEDB".equals(dcTransfer1.getFrom_type())) {
                        link_old = dcTransfer1.getName() + "." + dcTransfer1.getDbname() + ".dbo.";
                    } else {
                        link_old = dcTransfer1.getName();
                    }
                } else {
                    link_old = dcTransfer1.getDbname() + ".dbo.";
                }
                if (dcTransfer.getIsogeny() != 1) {
                    if ("SQLOLEDB".equals(dcTransfer1.getFrom_type())) {
                        link_new = dcTransfer.getName() + "." + dcTransfer.getDbname() + ".dbo.";
                    } else {
                        link_new = dcTransfer.getName();
                    }

                } else {
                    link_new = dcTransfer.getDbname() + ".dbo.";
                }
                for (DcProcedure e : procedureList) {
                    if (null!=e.getProc_type() && e.getProc_type() == 2) {
                        continue;
                    }
                    e.setJoin_sql(e.getJoin_sql().replaceAll(link_old, link_new));
                    e.setContent(e.getContent().replaceAll(link_old, link_new));
                    e.setMap_sql(e.getMap_sql().replaceAll(link_old, link_new));
                    e.setWhere_sql(e.getWhere_sql().replaceAll(link_old, link_new));
                    String sql = "if exists(select * from sys.procedures where name='" + e.getName() + "')\n" +
                            "drop procedure dbo." + e.getName() + " ";
                    handleDao.excuteSqlWithSQL(sql);
                    //5.2 生成存储过程
                    dcProcedureService.updateByPrimaryKeySelective(e);
                    // System.out.println(e.getContent());
                    handleDao.excuteSqlWithSQL(e.getContent());
                }
            }
            return ResultUtil.success("修改链接服务器成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }
}