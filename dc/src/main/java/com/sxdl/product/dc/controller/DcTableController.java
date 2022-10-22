package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.entity.DcTable;
import com.sxdl.product.dc.entity.DcTableVsTable;
import com.sxdl.product.dc.service.DcProductService;
import com.sxdl.product.dc.service.DcTableVsTableService;
import com.sxdl.product.dc.service.impl.DcColumnServiceImpl;
import com.sxdl.product.dc.service.impl.DcTableServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "自定义表维护")
@RestController
@RequestMapping("/table")
public class DcTableController {

    @Autowired
    private DcTableServiceImpl tableService;

    @Autowired
    private DcColumnServiceImpl columnService;

    @Autowired
    private DcProductService dcProductService;
    @Autowired
    private DcTableVsTableService dcTableVsTableService;

   /* @Autowired
    private DcTableTypeService dcTableTypeService;*/


    @Autowired
    private HandleDao handleDao;


   /* @ApiOperation(value = "查询所有的自定表", notes = "查询所有的自定表")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DcTable>> findAll(PageInfo pageInfo, Integer productId, String name, String nameZh, Integer typeId) {
        try {
            DcTable table = new DcTable ();
            table.setProduct_id ( productId );
            table.setName ( name );
            table.setName_zh ( nameZh );
            table.setType_id ( typeId );
            List<DcTable> tableList = tableService.findAll ( table );
            List<DcTable> dcTableList = tableList.stream ().filter ( e -> null != e && e.getType_id () <= 3 ).collect ( Collectors.toList () );
            //PageInfo<DcTable> list = tableService.queryPageList ( pageInfo, table );

            for (DcTable dcTable : dcTableList) {
                dcTable.setProductName ( dcProductService.findById ( dcTable.getProduct_id () ).getName () );
                dcTable.setTypeName ( GetDataFromApp.getDcDitVal ( 4, dcTable.getType_id ().toString () ).getName () );
                //dcTable.setTypeName(dcTableTypeService.findById(dcTable.getType_id()).getName());
            }
            Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), dcTableList );

            return ResultUtil.success ( list );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }
*/

  /*  @ApiOperation(value = "查询所有的自定表", notes = "查询所有的自定表")
    @GetMapping("/findAll")
    public ResultUtil findAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, DcTable dcTable) {
        try {
            List<DcTable> dcTableList = tableService.findAllByDcTable(dcTable);
            // List<DcTable> dcTableList = tableList.stream ().filter ( e -> null != e && e.getType_id()!=1 &&e.getType_id () <= 3 ).collect ( Collectors.toList () );
            //PageInfo<DcTable> list = tableService.queryPageList ( pageInfo, table );
            if (dcTableList == null || dcTableList.size() < 0) {
                return ResultUtil.success("没有符合条件的数据");
            }
            for (DcTable table1 : dcTableList) {
                table1.setProductName(dcProductService.findById(table1.getProduct_id()).getName_zh());
                //table1.setTypeName(GetDataFromApp.getDcDitVal(4, table1.getType_id().toString()).getName());
                //dcTable.setTypeName(dcTableTypeService.findById(dcTable.getType_id()).getName());
            }
            Map<String, Object> listPage = PageList.getListPage(pageNum, pageSize, dcTableList);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }*/

    @ApiOperation(value = "查询所有的自定表", notes = "查询所有的自定表")
    @GetMapping("/findAll")
    public ResultUtil findAll(PageInfo pageInfo, String name, String name_zh, String product_id,@RequestParam(value = "type_id",required = false,defaultValue = "0") Integer type_id) {
        try {
            pageInfo=tableService.selectBySome(pageInfo,name,name_zh,product_id,type_id);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询所有需要质控的表", notes = "查询所有需要质控的表")
    @GetMapping("/findQcTables")
    public ResultUtil findQcTables() {
        try {
            DcTable table = new DcTable();
            table.setIs_qc(1);
            List<DcTable> list = tableService.select(table);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }



    @ApiOperation(value = "根据类型查询所有的自定表", notes = "根据类型查询所有的自定表")
    @GetMapping("/findByType")
    public ResultUtil<PageInfo<DcTable>> findByType(PageInfo pageInfo, @RequestParam(value = "type", defaultValue = "") Integer type) {
        try {
            DcTable table = new DcTable();
            table.setType_id(type);
            PageInfo<DcTable> list = tableService.queryPageList(pageInfo, table);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


/*

    @ApiOperation(value = "查询字典表")
    @GetMapping("/findzdTable")
    public ResultUtil findzdTable(@RequestParam(value = "type",required = true) Integer type){
        try {
            
            return ResultUtil.success()
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }
    }
*/


    @ApiOperation(value = "根据产品ID查询所有的自定表", notes = "根据产品ID查询所有的自定表")
    @GetMapping("/findByProductId")
    public ResultUtil<PageInfo<DcTable>> findByProductId(PageInfo pageInfo,
                                                         @RequestParam(value = "productId", required = true) String productId,
                                                         @RequestParam(value = "type_id", required = true) Integer type_id) {
        try {
            DcTable table = new DcTable();
            table.setProduct_id(productId);
            table.setType_id(type_id);
            PageInfo<DcTable> list = tableService.queryPageList(pageInfo, table);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据表ID查询所有的自定表", notes = "根据产品ID查询所有的自定表")
    @GetMapping("/findWBBytableId")
    public ResultUtil findWBBytableId(@RequestParam(value = "tableId", required = true) String tableId) {
        try {
            List<DcColumn> dcColumns = columnService.selectByTableid(tableId);
            DcTable table = tableService.findById(tableId);
            if (dcColumns != null && dcColumns.size() > 0) {
                table.setDcColumnList(dcColumns);
            }
            return ResultUtil.success(table);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询所有的维表", notes = "查询所有的维表")
    @GetMapping("/findWB")
    public ResultUtil findWB(PageInfo pageInfo, String name) {
        try {
            DcTable table = new DcTable();
            table.setProduct_id("22");
            table.setType_id(4);
            List<DcTable> dcTableList = tableService.findAllByDcTable(table);
            dcTableList = dcTableList.stream().filter(e -> null != e && (e.getName().contains(name) || e.getName_zh().contains(name))).collect(Collectors.toList());
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(dcTableList);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), dcTableList);


            return ResultUtil.success(listPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    //保存接口信息
    @ApiOperation(value = "保存", notes = "保存自定表信息")
    @PostMapping("/save")
    public ResultUtil saveOne(@RequestBody DcTable DcTable) {
        if (DcTable == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            if (null != DcTable.getType_id() && DcTable.getDcColumnList().size() > 0) {
                //保存维表,定义产品id--数据中心维表id--HBI id
                String dcProductId = "22";
                String hbiProductId = "12";
                List<DcTable> dcTableList = tableService.selectByNameAndProdect(DcTable.getName(), dcProductId, hbiProductId);
                if (dcTableList != null && dcTableList.size() > 0) {
                    return ResultUtil.error("保存失败,库中已经存在该表！");
                }
                List<String> pid = new ArrayList<>();
                pid.add(dcProductId);
                pid.add(hbiProductId);
                tableService.insertWB(DcTable, pid);
            } else {
               /* String name = DcTable.getName ();

                DcTable dcTable = tableService.selectByName ( name );
                if (dcTable == null) {
                    tableService.insert ( DcTable );
                } else {
                    return ResultUtil.error ( "保存失败,库中已经存在该表！" );
                }

                */
                List<com.sxdl.product.dc.entity.DcTable> dcTableList = tableService.selectByNameAndProdect(DcTable.getName(), DcTable.getProduct_id(), "");
                if (dcTableList != null && dcTableList.size() > 0) {
                    return ResultUtil.error("保存失败,库中已经存在该表！");
                }
                tableService.insert(DcTable);

            }


        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("保存失败" + e.getCause());
        }
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "建模根据数据库表创建表结构", notes = "根据数据库表创建表结构")
    @PostMapping("/saveByDB")
    public ResultUtil saveByDB(@RequestBody DcTable DcTable) {
        if (DcTable == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            DcTable.setIsexist("1");
            if ("dc".equalsIgnoreCase(DcTable.getProduct_id())) {
                DcProduct dcProduct = new DcProduct();
                dcProduct.setShort_name("dc");
                DcProduct product = dcProductService.selectOne(dcProduct);
                DcTable.setProduct_id(product.getId());
            }
            String s = tableService.saveByDB(DcTable);
            if(!"更新成功".equals(s)){
                return ResultUtil.error(s);
            }
            return ResultUtil.success(s);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("保存失败");
        }
    }

    @ApiOperation(value = "建模后更新", notes = "建模后更新")
    @PostMapping("/updateByDB")
    public ResultUtil updateByDB(@RequestBody DcTable DcTable) {
        if (DcTable == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            String result = tableService.insertOrUpdate(DcTable);
            return ResultUtil.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("保存失败");
        }

    }


    @ApiOperation(value = "修改", notes = "修改自定表信息")
    @PutMapping("/update")
    public ResultUtil<List<DcTable>> update(@RequestBody DcTable DcTable) {
        //DcTable DcTable1= tableService.findById ( DcTable.getId ());
        try {
            if (DcTable.getType_id() == 4 && DcTable.getDcColumnList().size() > 0) {
                List<DcColumn> dcColumnList = DcTable.getDcColumnList();
                tableService.updateWB(DcTable, dcColumnList);
            } else {
                tableService.update(DcTable);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("修改成功");
    }

    @ApiOperation(value = "删除自定义表（除了维表）", notes = "删除自定义表（除了维表）")
    @DeleteMapping("/deleteTable")
    public ResultUtil deleteTable(@RequestBody DcTable dcTable) {
        try {
            //删除表时，可以判断是否有表实体，如果表不存在 则可以把表和表字段删除掉(table 和column )
          /*  String sql = "select top 1 * from sysObjects where Id=OBJECT_ID(N'" + dcTable.getName() + "') and xtype='U'";
            List<Map<String, Object>> maps = tableService.selectSqlWithSQL(sql);
            if (maps.size() <= 0) {
                //删除掉TC表
                tableService.delete(dcTable);
                DcColumn c = new DcColumn();
                c.setTable_id(dcTable.getId());
                columnService.delete(c);
            }
*/
            List<DcColumn> dcColumns = columnService.selectByTableid(dcTable.getId());
            if (dcColumns.size() > 0) {
                return ResultUtil.error("表中存在字段不允许删除");
            }
            if(StringUtil.isNotEmpty(dcTable.getConversion_sql())){
                return ResultUtil.error("表为行列转换生成，删除行列转换配置即可");
            }
            tableService.deleteByTableId(dcTable);
            return ResultUtil.success("删除成功！");
        } catch (Exception e) {
            return ResultUtil.error("删除失败：" + e.getMessage());
        }
    }


    @ApiOperation(value = "删除维表", notes = "删除自定表信息")
    @DeleteMapping("/del")
    public ResultUtil delete(@RequestBody DcTable DcTable) {
        try {
            if (DcTable == null) {
                return ResultUtil.error("没有数据要删除");
            } else {
                //判断表类型---删除维表需要判断维表是否已使用
                if (DcTable.getType_id() == 4 || DcTable.getType_id() == 8) {
                    List<DcTableVsTable> list = dcTableVsTableService.findByReplaceTableId(DcTable.getId());
                    List<DcTableVsTable> list1 = dcTableVsTableService.findByToTableId(DcTable.getId());
                    if ((list.size() > 0) || (list1.size() > 0)) {
                        return ResultUtil.error("该维表已关联其他表,无法删除");
                    }
                    List<DcTable> dcTableList = tableService.selectByName2(DcTable.getName());
                    if (dcTableList != null && dcTableList.size() > 0) {
                        tableService.deleteWB(dcTableList);
                    }
                } else {
                    DcColumn column = new DcColumn();
                    column.setTable_id(DcTable.getId());
                    PageInfo pageInfo = new PageInfo();
                    pageInfo.setPageNum(1);
                    pageInfo.setPageSize(10);

                    PageInfo<DcColumn> columns = columnService.queryPageList(pageInfo, column);
                    if (columns.getList().size() > 0) {
                        return ResultUtil.error("该表中还有字段,无法删除");
                    } else {
                        tableService.delete(DcTable);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("删除成功");
    }


    @ApiOperation(value = "更新", notes = "在线更新数据库表")
    @GetMapping("/renewDatabase")
    public ResultUtil renewDatabase(@RequestParam(value = "id", required = true) String id) {
        StringBuilder sb = new StringBuilder();
        try {
            DcTable table = tableService.findById(id);
            //获取colums表中的字段
            List<DcColumn> dcColumns = columnService.selectByTableid(id);
            String oneTableOfColumns = handleDao.getOneTableOfColumns(table.getName());
            if (null != oneTableOfColumns) {
                //获取数据库中的表字段
                List<String> list = Arrays.asList(oneTableOfColumns.split(","));
                List<String> dbColumns = new ArrayList<>(); //防止contains方法报错
                dbColumns.addAll(list);
                // 数据库中没有字段开始创建  (数据不包含 视图页面字段的)
                for (DcColumn dc : dcColumns) {
                    String type = getTypeById(dc);
                    if (!dbColumns.contains(dc.getColumn_name())) {
                        /*if (2 == dc.getType_id ()) {  // 添加int类型的字段
                            handleDao.addTableOfInt ( table.getName (), dc.getColumn_name () );
                        } else if (1 == dc.getType_id ()) { // 添加String类型的字段
                            handleDao.addTableOfString ( table.getName (), dc.getColumn_name (), dc.getSize () );
                        }*/
                        handleDao.addTableOfDate(table.getName(), dc.getColumn_name(), type);
                    } else {
                        if (!"id".equalsIgnoreCase(dc.getColumn_name())) {
                            handleDao.alertTable(table.getName(), dc.getColumn_name(), type);
                        }
                    }
                }
                oneTableOfColumns = handleDao.getOneTableOfColumns(table.getName());
                dbColumns = Arrays.asList(oneTableOfColumns.split(","));
                List<String> listcol = new ArrayList<>();
                dcColumns.forEach(e -> {
                    listcol.add(e.getColumn_name());
                });
                // 数据库中多出来开始删除 （ 数据库 字段 比视图页面多的删除）
                for (String db : dbColumns) {
                    if (!listcol.contains(db)) {
                        handleDao.deleteTable(table.getName(), db);
                    }
                }

            } else {

                String isKey = "";
                sb.append("create TABLE ").append(table.getName()).append("( ");

                for (DcColumn dc : dcColumns) {
                    /*if (2 == dc.getType_id ()) {  // 添加int类型的字段
                        sb.append ( dc.getColumn_name () ).append ( " int null, " );
                    } else if (1 == dc.getType_id ()) { // 添加String类型的字段
                        sb.append ( dc.getColumn_name () ).append ( " varchar(" + dc.getSize () + ")" ).append ( " null, " );
                    } else if (3 == dc.getType_id ()) { //为主键 自增
                        isKey = dc.getColumn_name ();
                        sb.append ( dc.getColumn_name () ).append ( " IDENTITY(1,1) NOT NULL, " );
                    }*/
                    if (2 == dc.getType_id()) {  // 添加int类型的字段
                        if (dc.getColumn_name().equals("id")) {
                            isKey = dc.getColumn_name();
                            sb.append(dc.getColumn_name()).append("  int IDENTITY(1,1) NOT NULL, ");
                        } else {
                            sb.append(dc.getColumn_name()).append(" int null, ");
                        }

                    } else if (1 == dc.getType_id()) { // 添加String类型的字段

                        if (dc.getSize() >= 8000) {
                            sb.append(dc.getColumn_name()).append(" varchar(MAX)").append(" null, ");
                        } else {

                            if (dc.getColumn_name().equals("id")) {
                                isKey = dc.getColumn_name();
                                sb.append(dc.getColumn_name()).append("  varchar (" + dc.getSize() + ") default   newid() not null ,");
                            } else {
                                sb.append(dc.getColumn_name()).append("  varchar (" + dc.getSize() + ")").append(" null, ");
                            }
                        }
                    } else if (3 == dc.getType_id()) { //日期
                        sb.append(dc.getColumn_name()).append(" date null, ");
                    } else if (4 == dc.getType_id()) {
                        sb.append(dc.getColumn_name()).append(" datetime null, ");
                    } else if (5 == dc.getType_id()) {
                        sb.append(dc.getColumn_name()).append(" numeric (" + dc.getSize() + ", " + dc.getScale() + ") null,");
                    }
                }
                if ("".equals(isKey) || null == isKey) {
                    sb.append(")");
                } else {
                    sb.append(" CONSTRAINT PK_").append(table.getName()).append(" PRIMARY KEY CLUSTERED  ( " + isKey + " ASC ) )");
                }
                handleDao.createNewTable(sb.toString());
            }
            table.setIsexist("1");
            tableService.updateSelective(table);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }

        return ResultUtil.success("更新数据库表成功");

    }

    private String getTypeById(DcColumn dc) {
        String type = "";
        switch (dc.getType_id()) {
            case 1:
                type = dc.getSize() >= 8000 ? "varchar(max)" : "varchar (" + dc.getSize() + ") ";
                break;
            case 2:
                type = "int  ";
                break;
            case 3:
                type = "[date]";
                break;
            case 4:
                type = "[datetime]";
                break;
            case 5:
                type = "[numeric](" + dc.getSize() + ", " + dc.getScale() + ")";
                break;
        }
        return type;
    }

    @ApiOperation(value = "根据产品ID查询表", notes = "根据产品ID查询表")
    @GetMapping("/findByProductID")
    public ResultUtil<PageInfo<DcTable>> findByProductID(PageInfo pageInfo, @RequestParam(value = "productId", required = true) String productId,Integer etlp_type,String flag) {
        try {
            String type="";
            switch (etlp_type){
                case 1:
                    //type="1";
                    break;
                case 2:
                    if("left".equals(flag)) type="1,6";
                    if("right".equals(flag)) type="2";
                    break;
                case 3://TODO 加载到产品表中的左右下拉框数据
                    if("left".equals(flag)) type="";
                    if("right".equals(flag)) type="";
                    break;
                case 4:
                    type="";
                    break;
                default:
                    if("left".equals(flag)) type="";
                    if("right".equals(flag)) type="2,3";

            }
            if(pageInfo.getPageSize()==0){
                pageInfo.setPageSize(9000);
            }
            PageInfo<DcTable> list = tableService.selectBySome(pageInfo, productId,type);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

}