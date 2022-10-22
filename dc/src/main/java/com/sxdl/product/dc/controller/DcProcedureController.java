package com.sxdl.product.dc.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcScheduleConfigDao;
import com.sxdl.product.dc.dao.dao1.DcTransferDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.dbo.CreatTableDBO;
import com.sxdl.product.dc.dbo.FindProblemDBO;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.DcScheduleService;
import com.sxdl.product.dc.service.DcTableService;
import com.sxdl.product.dc.service.DcTableVsTableService;
import com.sxdl.product.dc.service.impl.DcProcedureServiceImpl;
import com.sxdl.product.dc.util.DirectLinkLibraryUtil;
import com.sxdl.product.dc.util.WebSoapUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Api(tags = "存储过程")
@RestController
@RequestMapping("/dcProcedure")
public class DcProcedureController {


    List<Map<String, Object>> s;
    @Autowired
    private DcTransferDao dcTransferDao;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcTableService dcTableService;
    @Autowired
    private DcScheduleService dcScheduleService;
    @Autowired
    private DcProcedureServiceImpl dcProcedureService;
    private DcProcedure dcProcedure;
    private PageInfo<DcProcedure> dcProcedurePageInfo;
    @Autowired
    private DcTableVsTableService dcTableVsTableService;

    @Autowired
    private DcScheduleConfigDao dcScheduleConfigDao;

    //根据name模糊查询信息
    @ApiOperation(value = "根据name查询", notes = "根据存储名称模糊查询")
    @GetMapping("/findByName")
    public ResultUtil<PageInfo<DcProcedure>> findByName(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select * from dbo.dc_procedure where type_id = 4 ");
            if (name != null && !"".equals(name)) {
                sb.append(" and ").append(" (name like ").append(" '%" + name + "%' or ").append("name_zh like ").append(" '%" + name + "%' )");
            }
            PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getSize());
            PageInfo pi2 = new PageInfo<DcProcedure>(dcProcedureService.findByName(sb.toString()));
            pi2.setPageSize(pageInfo.getPageSize());
            pi2.setPageNum(pageInfo.getPageNum());
            return ResultUtil.success(pi2, "查询存储成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @Deprecated
    //根据name模糊查询信息
    @ApiOperation(value = "根据表名查询", notes = "根据存储名称中的表名模糊查询")
    @GetMapping("/findDcProcedureByTableName")
    public ResultUtil findByTableName(@RequestParam(value = "transferId", defaultValue = "") String transferId, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setTransfer_id(transferId);
            List<DcProcedure> procedureList = dcProcedureService.select(dcProcedure);
            procedureList = procedureList.stream().filter(e -> null != e && (e.getName().toLowerCase().contains(name.toLowerCase()))).collect(Collectors.toList());
            return ResultUtil.success(procedureList, "查询存储成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //根据name模糊查询信息
    @ApiOperation(value = "根据表名查询", notes = "根据表名模糊查询")
    @GetMapping("/findTableByTableName")
    public ResultUtil findTableByTableName(@RequestParam(value = "productId", defaultValue = "") String productId, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            DcTable dcTable = new DcTable();
            dcTable.setProduct_id(productId);
            List<DcTable> tableList = dcTableService.select(dcTable);
            tableList = tableList.stream().filter(e -> null != e && (e.getName().toLowerCase().contains(name.toLowerCase()) || e.getName_zh().contains(name))).collect(Collectors.toList());
            return ResultUtil.success(tableList, "查询表成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //根据name模糊查询信息
    @ApiOperation(value = "根据字段名查询", notes = "根据字段名模糊查询对照关系")
    @GetMapping("/findTVTByTableName")
    public ResultUtil findTVTByTableName(@RequestParam(value = "produceId", defaultValue = "") String produceId, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            DcTableVsTable dcTableVsTable = new DcTableVsTable();
            dcTableVsTable.setProcedure_id(produceId);
            List<DcTableVsTable> vsTableList = dcTableVsTableService.select(dcTableVsTable);
            vsTableList = vsTableList.stream().filter(e -> null != e && (e.getFrom_table_column().toLowerCase().contains(name.toLowerCase()) || e.getFrom_table_column_zh().contains(name) || e.getTo_table_column().toLowerCase().contains(name.toLowerCase()) || e.getTo_table_column_zh().contains(name)))
                    .collect(Collectors.toList());
            return ResultUtil.success(vsTableList, "查询对照关系成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "直连存储", notes = "获取所有直连库存储过程")
    @GetMapping("/findAll")
    @ResponseBody
    public ResultUtil findAll(PageInfo<DcProcedure> pageInfo) {
        try {
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setType_id(1);
            dcProcedurePageInfo = dcProcedureService.queryPageList(pageInfo, dcProcedure);
            for (DcProcedure procedure : dcProcedurePageInfo.getList()) {
                DcSchedule byId = dcScheduleService.findById(procedure.getSchedule_id());
                procedure.setRule_id(byId.getRule_id());
                procedure.setScope(byId.getScope());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        ResultUtil<PageInfo<DcProcedure>> success = ResultUtil.success(dcProcedurePageInfo);
        return success;
    }

    @ApiOperation(value = "直连存储通过工单直连库的id", notes = "直连存储通过工单直连库的id")
    @GetMapping("/findBytransferId")
    @ResponseBody
    public ResultUtil findBytransferId(PageInfo p, @RequestParam(value = "transfer_id", required = true) String transfer_id, String name) {
        try {
//            DcProcedure dcProcedure = new DcProcedure();
//            //dcProcedure.setType_id(1);
//            dcProcedure.setTransfer_id(transfer_id);
//            dcProcedurePageInfo = dcProcedureService.queryPageList(pageInfo, dcProcedure);
            String sql = "from dc_procedure p left join dc_schedule s on p.id=s.procedure_id\n" +
                    "where transfer_id ='";
            sql += transfer_id + "' ";
            if (StrUtil.isNotEmpty(name)) {
                sql += " and (p.name like '%" + name + "%' or p.name_zh like '%" + name + "%')";
            }
            p = dcProcedureService.selectPageinfoWithSQL(DcProcedure.class, " p.*,s.status ", sql, "p.name", p, true);
            return ResultUtil.success(p);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "源表到标准表", notes = "源表到标准表的映射")
    @GetMapping("/findAllOts")
    @ResponseBody
    public ResultUtil findAllOts(PageInfo<DcProcedure> pageInfo, @RequestParam(value = "type_id", required = true) Integer type_id, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            if (type_id == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(" select * from dbo.dc_procedure where type_id = 2 ");
                if (name != null && !"".equals(name)) {
                    sb.append(" and ").append(" (name like ").append(" '%" + name + "%' or ").append("name_zh like ").append(" '%" + name + "%' )");
                }
                PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getSize());
                PageInfo pi2 = new PageInfo<DcProcedure>(dcProcedureService.findByName(sb.toString()));
                pi2.setPageSize(pageInfo.getPageSize());
                pi2.setPageNum(pageInfo.getPageNum());
                return ResultUtil.success(pi2, "查询存储成功");
            } else if (type_id == 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(" select * from dbo.dc_procedure where type_id = 3 ");
                if (name != null && !"".equals(name)) {
                    sb.append(" and ").append(" (name like ").append(" '%" + name + "%' or ").append("name_zh like ").append(" '%" + name + "%' )");
                }
                PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getSize());
                PageInfo pi2 = new PageInfo<DcProcedure>(dcProcedureService.findByName(sb.toString()));
                pi2.setPageSize(pageInfo.getPageSize());
                pi2.setPageNum(pageInfo.getPageNum());
                return ResultUtil.success(pi2, "查询存储成功");
            } else {
                DcProcedure dcProcedure = new DcProcedure();
                dcProcedure.setType_id(type_id);
                dcProcedurePageInfo = dcProcedureService.queryPageList(pageInfo, dcProcedure);
                ResultUtil<PageInfo<DcProcedure>> success = ResultUtil.success(dcProcedurePageInfo);
                return success;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据id获取存储", notes = "根据id获取直连库存储过程")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtil findById(@RequestParam(value = "id", required = true) String id) {
        try {
            dcProcedure = dcProcedureService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        ResultUtil<DcProcedure> success = ResultUtil.success(this.dcProcedure);
        return success;
    }

    @ApiOperation(value = "修改", notes = "修改数据")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtil update(@RequestBody DcProcedure dcProcedure) {
        try {
            dcProcedureService.update(dcProcedure);
            handleDao.execSelectSql(dcProcedure.getContent());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("修改成功");
    }

    @ApiOperation(value = "删除", notes = "删除数据")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody DcProcedure dcProcedure) {
        try {
            dcProcedureService.deleteByProce(dcProcedure);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "测试按钮", notes = "测试存储过程回显给前端页面,同时 创建/更新 存储过程")
    @PutMapping("/testProc")
    @ResponseBody
    public ResultUtil testProc(@RequestBody DcProcedure dcProcedure) {
        String sqlProcText = "";
        try {
            String procname = dcProcedure.getName();
            Integer isparam = dcProcedure.getIsparam();
            String tablename = dcProcedure.getTable_mian_name();
            String columnname = dcProcedure.getTime_column_name();
            Integer timeLenth = dcProcedure.getTiem_length();
            DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
            String dbname = dcTransfer.getDbname();
            String transfername = dcTransfer.getName();
            String fromType = dcTransfer.getFrom_type();
            String tableColumssql = null;
            String tableColums = null;
            String columsAndType = null;
            String selectColumns = null;
            if (fromType.equals("SQLOLEDB")) {
                tableColumssql = DirectLinkLibraryUtil.getTableColums(transfername, dbname, tablename, fromType);
                tableColums = handleDao.execSelectSql(tableColumssql);
                columsAndType = DirectLinkLibraryUtil.getColumsAndType(transfername, dbname, tablename);
                selectColumns = handleDao.execSelectSql(columsAndType);
                if (3 == isparam) { //获取不带参数的存储过程sql脚本
                    sqlProcText = DirectLinkLibraryUtil.getProc(transfername, dbname, procname, tablename, tableColums, selectColumns);
                } else if (1 == isparam) {//获取带参数(时间范围)的存储过程sql脚本
                    sqlProcText = DirectLinkLibraryUtil.getProcParam(transfername, dbname, procname, tablename, columnname, timeLenth, tableColums, selectColumns);
                }
            } else if (fromType.equals("DB2OLEDB")) {
                tableColumssql = DirectLinkLibraryUtil.getTableColumsOfDB2(transfername, dbname, tablename);
                tableColums = handleDao.execSelectSql(tableColumssql);
                columsAndType = DirectLinkLibraryUtil.getColumsAndTypeOfDB2(transfername, dbname, tablename);
                selectColumns = handleDao.execSelectSql(columsAndType);
                if (3 == isparam) { //获取不带参数的存储过程sql脚本
                    sqlProcText = DirectLinkLibraryUtil.getProcOfDB2(transfername, dbname, procname, tablename, tableColums, selectColumns);
                } else if (1 == isparam) {//获取带参数(时间范围)的存储过程sql脚本
                    sqlProcText = DirectLinkLibraryUtil.getProcParamOfDB2(transfername, dbname, procname, tablename, columnname, timeLenth, tableColums, selectColumns);
                }
            } else {
                tableColumssql = DirectLinkLibraryUtil.getTableColumsOfOrcale(transfername, dbname, tablename);
                tableColums = handleDao.execSelectSql(tableColumssql);
                columsAndType = DirectLinkLibraryUtil.getColumsAndTypeOfOracle(transfername, dbname, tablename);
                selectColumns = handleDao.execSelectSql(columsAndType);
                if (3 == isparam) { //获取不带参数的存储过程sql脚本
                    sqlProcText = DirectLinkLibraryUtil.getProcOfOracle(transfername, dbname, procname, tablename, tableColums, selectColumns);
                } else if (1 == isparam) {//获取带参数(时间范围)的存储过程sql脚本
                    sqlProcText = DirectLinkLibraryUtil.getProcParamOfCracle(transfername, dbname, procname, tablename, columnname, timeLenth, tableColums, selectColumns);
                }
            }
            //执行 创建存储过程
            handleDao.excuteSqlWithSQL(sqlProcText);
            dcProcedure.setContent(sqlProcText);
            return ResultUtil.success(dcProcedure, "测试成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    /**
     * 保存的时候创建表
     *
     * @param dcProcedure 如题
     * @return 如题
     */
    @ApiOperation(value = "保存", notes = "导入表结构")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil save(@RequestBody CreatTableDBO creatTableDBO) {
        String SorE = "";
        try {
            DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(creatTableDBO.getTransfer_id());
            String dbname = dcTransfer.getDbname();
            String transfername = dcTransfer.getName();
            Integer isogeny = dcTransfer.getIsogeny();
            String fromType = dcTransfer.getFrom_type();
            String productId="";
            if(null !=creatTableDBO.getIsview() && 1==creatTableDBO.getIsview()){
                if (1 == creatTableDBO.getProduct_type()) {//源产品
                    productId = dcTransfer.getResource_product_id();
                }else {
                    productId = dcTransfer.getProduct_id();
                }
                dcProcedureService.saveTableColumn(productId, transfername, dbname, creatTableDBO.getName(), creatTableDBO.getName_zh(), fromType, creatTableDBO.getIscreateatdc(),dcTransfer.getEtlp_type());
            }else{
                dcTableService.creatTC(creatTableDBO, dcTransfer);
            }

            SorE = "保存成功";
        } catch (Exception e) {
            SorE = e.getMessage();
        }
        return new ResultUtil((SorE.equals("保存成功")) ? "success" : "error", SorE);
    }

    @ApiOperation(value = "抽取直连库数据", notes = "抽取历史数据信息(源表的数据)")
    @PostMapping(value = "/getExtract")
    @ResponseBody
    public ResultUtil getExtract(@RequestBody DcProcedure dcProcedure) {
        String SorE = "";
        try {
            String name = "";
            if (3 == dcProcedure.getIsparam()) {//无参数
                name = dcProcedure.getName();
                handleDao.excuteCallProcedue(name);
            } else if (1 == dcProcedure.getIsparam()) { //时间范围参数胡
                DcSchedule byId = dcScheduleService.findById(dcProcedure.getSchedule_id());
                String param_unit = byId.getParam_unit();
                List<String> splicTimeParam = WebSoapUtil.getSplicTimeParam(dcProcedure.getStime(), dcProcedure.getEtime(), param_unit, byId.getParam());
                for (String param : splicTimeParam) {
                    LinkedHashMap<String, String> keyValues = WebSoapUtil.getKeyValues(param);
                    handleDao.excuteCallProcedueWithParams(dcProcedure.getName(), keyValues.get("startDate"), keyValues.get("endDate"));
                }
            }
            return ResultUtil.success("抽取成功");
        } catch (Exception e) {
            return ResultUtil.error("抽取失败，原因：" + e.getMessage());
        }
    }

    /**
     * 抽取工单下某个直联库下的所有历史数据
     *
     * @param transferId
     * @return
     */
    @GetMapping("extractDateAll")
    @ResponseBody
    public ResultUtil extractDateAll(String transferId, String start, String end,String bah) {
        try {
            String s = dcProcedureService.extractDateAll(transferId, start, end,bah);
            return ResultUtil.success(s);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "抽取数据", notes = "抽取历史数据信息(标准/产品)")
    @PostMapping(value = "/extractDate")
    @ResponseBody
    public ResultUtil extractDate(@RequestBody DcProcedure dcProcedure) {
        try {
            String msg="";
            String status="";
            s = dcProcedureService.extractDate(dcProcedure);
            if(CollUtil.isNotEmpty(s)){
                msg=JSONUtil.toJsonStr(s.get(0));
                status=JSONUtil.toJsonStr(s.get(0).get("状态"));
            }else{
                msg="抽取成功";
            }
            if("err".equals(status)){
                return ResultUtil.error(msg);
            }
            return ResultUtil.success(msg);
        } catch (Exception e) {
            return ResultUtil.error("抽取有误" + e.getCause());
        }
    }

    @ApiOperation(value = "抽取数据(维表)", notes = "抽取历史数据信息(维表)")
    @PostMapping(value = "/extractDateWb")
    @ResponseBody
    public ResultUtil extractDateWb(@RequestBody DcProcedure dcProcedure) {
        try {
            String procedureName = dcProcedure.getName();
            String to_table_id = dcProcedure.getTo_table_id();
            DcTable byId = dcTableService.findById(to_table_id);
            int Scount = handleDao.countSum(byId.getName());
            String replace = procedureName.replace("_otsw_", "_otaw_");
            handleDao.excuteCallProcedue(procedureName);
            handleDao.excuteCallProcedue(replace);
            int Ecount = handleDao.countSum(byId.getName());
            return ResultUtil.success("抽取了" + (Ecount - Scount) + "条数据");
        } catch (Exception e) {
            return ResultUtil.error("抽取有误");
        }
    }


    /**
     * 直连库自动抽取数据
     *
     * @param jsonArray 如题
     */
    public void saveAutoEverySql(JSONArray jsonArray) {
        try {
            dcProcedureService.saveAutoEverySql(jsonArray);
            dcProcedureService.saveAutoEverySql2(jsonArray);
            dcProcedureService.saveAutoEverySql3(jsonArray);
            dcProcedureService.saveAutoEverySql4(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /************************                               到标准表映射 功能       ***********************/
    @ApiOperation(value = "标准列表", notes = "获取所有标准列表存储过程")
    @GetMapping("/findAllToStandard")
    @ResponseBody
    public ResultUtil findAllToStandard(PageInfo<DcProcedure> pageInfo) {
        String SorE = "";
        try {
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setType_id(1);
            dcProcedurePageInfo = dcProcedureService.queryPageList(pageInfo, dcProcedure);
            SorE = "";
        } catch (Exception e) {
            SorE = e.getMessage();
        }
        ResultUtil.success(dcProcedurePageInfo);
        return new ResultUtil((SorE.equals("")) ? "success" : "error", SorE);
    }

    /*
     * 要求生成的存储
     * 参数要求 @startDate varchar(10),  @endDate varchar(10)  ,@bah varchar(500)
     * */
    @ApiOperation(value = "新增", notes = "新增自定义存储")
    @PutMapping("/insert")
    @ResponseBody
    public ResultUtil insert(@RequestBody DcProcedure dcProcedure) {
        try {
            //dcProcedure.setIsparam(1);
            if(StringUtil.isNotEmpty(dcProcedure.getId())){
                dcProcedureService.update(dcProcedure);
            }else{
                dcProcedureService.insert(dcProcedure);
            }

            //修改已经配置好的调度信息
            List<DcScheduleConfig> select = dcScheduleConfigDao.findAlreadyPz(dcProcedure.getId());
            if(CollUtil.isNotEmpty(select)){
                select.forEach(e -> {
                    e.setScope(dcProcedure.getScope());
                    dcScheduleConfigDao.updateByPrimaryKeySelective(e);
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("修改成功");
    }


    @ApiOperation(value = "排忧解难", notes = "排忧解难")
    @GetMapping("/findProblem")
    @ResponseBody
    public ResultUtil findProblem(FindProblemDBO dbo) {
        try {
            String result = "";
            String startDate = dbo.getStartDate();
            String endDate = dbo.getEndDate();


            StringBuilder sb = new StringBuilder();
            sb.append(" use dl_merge\n" +
                    " \n" +
                    " if exists(select * from tempdb..sysobjects where id=object_id('tempdb..#temp'))\n" +
                    "BEGIN\n" +
                    "DROP TABLE #temp\n" +
                    "end \n");
            sb.append("DECLARE @startDate varchar(max),@endDate varchar(max) \n" +
                    "set @startDate='" + startDate + "' \n" +
                    "set @endDate='" + endDate + "' ");
            //传入存储的ID
            DcProcedure dcProcedure = dcProcedureService.findById(dbo.getId());
            //判断来源表中是否有虚拟表
            String from_table_id = dcProcedure.getFrom_table_id();
            if (from_table_id.contains(",")) {
                DcTable dcTable = new DcTable();
                for (String tableId : from_table_id.split(",")) {
                    dcTable = dcTableService.findById(tableId);
                    //如果查询到的表类型是虚拟表，则需要去拼接虚拟表的转化sql
                    if (dcTable.getType_id() == 6) {
                        sb.append(dcTable.getConversion_sql());
                    }
                }
            }
            //拿到前置sql
            sb.append("\r\n");


            //逐行排除错误（子查询返回多行）   --子查询返回的值不止一个。当子查询跟随在 =、!=、<、<=、>、>= 之后，或子查询用作表达式时，这种情况是不允许的。错误号: 512,严重性: 16,错误状态号: 1,发生在第 1 行
            if ("1".equals(dbo.getType())) {
                String presql = dcProcedure.getPresql();
                String cloumns = presql.substring(presql.indexOf("select") + 6, presql.lastIndexOf("from"));
                String raletion = presql.substring(presql.lastIndexOf("from"), presql.length());
                //正则：以“,”分割，但是不包含括号内的逗号
                //String[] split = cloumns.split(",(?![^()]*+\\))");
                List<String> split = split(cloumns);

                for (String e : split) {
                    String sql = sb.toString() + " select " + e + "\n" + raletion;
                    //System.out.println(sb.toString());
                    try {
                        List<Map<String, Object>> maps = dcProcedureService.selectSqlWithSQL(sql);
                    } catch (Exception e1) {
                        result = result+","+e.substring(e.indexOf("AS") + 3, e.length());
                        //System.out.println(result);
                    }
                }

            }
            //类型转换错误（包含错误内容）    --在将 varchar 值 'sssssssss' 转换成数据类型 int 时失败。错误号: 245,严重性: 16,错误状态号: 1,发生在第 1 行
            else if ("2".equals(dbo.getType())) {
                //拼接臨時表
                sb.append(" select * into #temp  from (");

                sb.append(dcProcedure.getPresql());

                sb.append(" ) tess");
                sb.append("\r\n");
                sb.append(" use tempdb");
                sb.append("\r\n");
                //sb.append(" select name from sys.columns where object_id=OBJECT_ID('#temp') ");

                sb.append("\n" +
                        "declare @cnames varchar(max)\n" +
                        "set @cnames=''\n" +
                        "\n" +
                        "declare my_cursor cursor for --my_cursor为游标的名称，随便起\n" +
                        "select name from sys.columns where object_id=OBJECT_ID('#temp')  --这是游标my_cursor的值，这里随便发挥看业务场景\n" +
                        "--打开游标\n" +
                        "open my_cursor --没什么好说的\n" +
                        "--变量\n" +
                        "\n" +
                        "declare @name varchar(50) --这里是两个变量用来接收游标的值\n" +
                        "\n" +
                        "\n" +
                        "--循环游标\n" +
                        "fetch next from my_cursor into @name --获取my_cursor的下一条数据，其中为两个字段分别赋值给@id,@name\n" +
                        "while @@FETCH_STATUS=0 --假如检索到了数据继续执行\n" +
                        "begin\n" +
                        "\n" +
                        "declare @c int \n" +
                        "declare @sqls varchar(max) \n" +
                        "\n" +
                        "set @sqls='  select  COUNT(*) a into ##temp2 from #temp where '+@name+' like ''%" + dbo.getMsg() + "%'''\n" +
                        "exec (@sqls)\n" +
                        "\n" +
                        "select @c=a from ##temp2\n" +
                        "\n" +
                        "drop table ##temp2\n" +
                        "\n" +
                        "\n" +
                        "IF (@c!='0')  begin \n" +
                        "if LEN(@cnames)=0\n" +
                        "\tbegin \n" +
                        "\tset @cnames=@cnames+@name\n" +
                        "\tend \n" +
                        "\telse begin \n" +
                        "\tset @cnames=@cnames+','+@name\n" +
                        "\tend\n" +
                        "end \n" +
                        "print @cnames\n" +
                        "\n" +
                        "fetch next from my_cursor into @name --获取下一条数据并赋值给变量\n" +
                        "\n" +
                        "end--关闭释放游标\n" +
                        "close my_cursor\n" +
                        "deallocate my_cursor ");
                sb.append("select  @cnames as errName");

                List<Map<String, Object>> maps = dcProcedureService.selectSqlWithSQL(sb.toString());
                result = maps.stream().map(e -> {
                    return e.get("errName").toString();
                }).collect(Collectors.joining(","));
                //System.out.println(result);

            }
            //截断二进制错误   --将截断字符串或二进制数据。错误号: 8152,严重性: 16,错误状态号: 14,发生在第 1 行
            else if ("3".equals(dbo.getType())) {
                sb.append(" select * into #temp  from (");
                sb.append(dcProcedure.getPresql());
                sb.append(" ) tess");
                sb.append(" EXEC [sys_binary] '" + dcProcedure.getTo_table_name() + "','#temp' ");
                List<Map<String, Object>> maps = dcProcedureService.selectSqlWithSQL(sb.toString());
                result = maps.stream().map(e -> {
                    return e.get("columnName").toString();
                }).collect(Collectors.joining(","));
                //System.out.println(result);
            }
            //类型转化错误（不包含错误内容）   --从数据类型 varchar 转换为 numeric 时出错。错误号: 8114,严重性: 16,错误状态号: 5,发生在第 1 行
            else if ("4".equals(dbo.getType())) {
                String to_table_name = dcProcedure.getTo_table_name();
                String sql= "SELECT c.[name] \n" +
                        "FROM sys.tables AS t\n" +
                        "INNER JOIN sys.columns\n" +
                        "AS c ON t.object_id = c.object_id\n" +
                        "LEFT JOIN sys.extended_properties AS ep\n" +
                        "ON ep.major_id = c.object_id AND ep.minor_id = c.column_id \n" +
                        "LEFT JOIN sys.types AS tp\n" +
                        "ON tp.user_type_id = c.user_type_id\n" +
                        "where t.name = '"+to_table_name+"'\n" +
                        "and tp.name='"+dbo.getErrType()+"'\n";
                List<Map<String, Object>> maps = dcProcedureService.selectSqlWithSQL(sql);
                result = maps.stream().map(e -> {
                    return e.get("name").toString();
                }).collect(Collectors.joining(","));
                //System.out.println(maps);
            }


            return ResultUtil.success(result);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
    }



    public static List<String> split(String input) {

        int nParens = 0;
        int start = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {

            switch (input.charAt(i)) {
                case ',':
                    if (nParens == 0) {
                        result.add(input.substring(start, i));
                        start = i + 1;
                    }
                    break;
                case '(':
                    nParens++;
                    break;
                case ')':
                    nParens--;
                    if (nParens < 0)
                        throw new IllegalArgumentException("Unbalanced parenthesis at offset #" + i);
                    break;
            }
        }
        if (nParens > 0) throw new IllegalArgumentException("Missing closing parenthesis");

        result.add(input.substring(start));

        return result;

    }

}
