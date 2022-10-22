package com.sxdl.product.dc.controller;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcConversion;
import com.sxdl.product.dc.entity.DcTable;
import com.sxdl.product.dc.service.DcTableService;
import com.sxdl.product.dc.service.impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = "自定义表字段维护")
@RestController
@RequestMapping("/column")
public class DcColumnController {

    @Autowired
    private DcColumnServiceImpl dcColumnService;

    @Autowired
    private DcTableService dcTableService;

    @Autowired
    private DcTableVsTableServiceImpl dcTableVsTableService;

    @Autowired
    private DcVirtualTableServiceImpl dcVirtualTableService;


    @Autowired
    private DcProcedureServiceImpl dcProcedureService;

    @Autowired
    private DcConversionServiceImpl dcConversionService;

    @ApiOperation(value = "根据表id查询所有的字段", notes = "根据表id查询所有的字段")
    @GetMapping("/findByTableId")
    public ResultUtil findByTableId(PageInfo pageInfo, @RequestParam(value = "tableid", defaultValue = "") String tableid, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            /*DcColumn column = new DcColumn();
            column.setTable_id(tableid);
            PageInfo<List<DcColumn>> list = dcColumnService.queryPageList(pageInfo, column);*/
            List<DcColumn> columns = dcColumnService.selectBySome(tableid, "%" + name + "%");
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(columns);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), columns);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据多表id查询所有的字段", notes = "根据多表id查询所有的字段")
    @GetMapping("/findByTableIds/{tableids}")
    public ResultUtil<List<DcColumn>> findByTableIds(PageInfo pageInfo, @PathVariable String[] tableids) {
        try {


            List<DcColumn> returnDate = new ArrayList<>();
            for (String tableid : tableids) {
                DcTable table = dcTableService.findById(tableid);
                List<DcColumn> dcColumns = dcColumnService.selectByTableid(table.getId());
                for (DcColumn dcColumn : dcColumns) {
                    dcColumn.setColumn_name(table.getName() + "." + dcColumn.getColumn_name());
                    dcColumn.setColumn_name_zh(table.getName_zh() + "." + dcColumn.getColumn_name_zh());
                    returnDate.add(dcColumn);
                }
            }
            return ResultUtil.success(returnDate);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    @ApiOperation(value = "保存", notes = "保存字段信息")
    @PostMapping("/save")
    public ResultUtil saveOne(@RequestBody DcColumn dcColumn) {
        if (dcColumn == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            DcColumn column = dcColumnService.selectByTidName(dcColumn.getTable_id(), dcColumn.getColumn_name());
            if (column == null) {


                dcColumnService.insert(dcColumn);
            } else {
                return ResultUtil.error("改表中已经存在该字段！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("保存失败");
        }
        return ResultUtil.success("保存成功");
    }


    @ApiOperation(value = "修改", notes = "修改字段信息")
    @PutMapping("/update")
    public ResultUtil<List<DcColumn>> update(@RequestBody DcColumn DcColumn) {
        try {
            dcColumnService.update(DcColumn);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("修改成功");
    }


    @ApiOperation(value = "删除事实表字段(标准/产品表)", notes = "删除事实表字段(标准/产品表)")
    @DeleteMapping("/deleteColumn")
    public ResultUtil deleteColumn(@RequestBody DcColumn dcColumn) {
        try {
            Set<String> set = new HashSet<>();
            List<KeyValueDBO> keyValueDBOS = dcTableVsTableService.usedColumn(dcColumn.getId());
            if (keyValueDBOS.size() > 0) {
                for (KeyValueDBO keyValueDBO : keyValueDBOS) {
                    set.add(keyValueDBO.getValue());
                }
                return ResultUtil.success("该字段已经在" + set.toString() + "的字段映射中使用,处理后才可删除");
            }
            keyValueDBOS = dcVirtualTableService.usedColumn(dcColumn.getId());
            if (keyValueDBOS.size() > 0) {
                for (KeyValueDBO keyValueDBO : keyValueDBOS) {
                    set.add(keyValueDBO.getValue());
                }
                return ResultUtil.success("该字段已经在" + set.toString() + "的关联关系中使用,处理后才可删除");
            }

            String colname = dcColumnService.findtableAndcolName(dcColumn.getId());
            keyValueDBOS = dcProcedureService.usedColumn(colname);
            if (keyValueDBOS.size() > 0) {
                for (KeyValueDBO keyValueDBO : keyValueDBOS) {
                    set.add(keyValueDBO.getValue());
                }
                return ResultUtil.success("该字段已经在" + set.toString() + "的筛选条件中使用,处理后才可删除");
            }
            DcConversion dcConversion = new DcConversion();
            dcConversion.setFrom_table_id(dcColumn.getTable_id());
            List<DcConversion> conversionList = dcConversionService.select(dcConversion);
            if (CollUtil.isNotEmpty(conversionList)) {
                return ResultUtil.error("该表有行转列配置，字段不允许删除");
            }
            dcColumnService.delete(dcColumn);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "删除整表字段(标准/产品表)", notes = "删除整表字段(标准/产品表)")
    @DeleteMapping("/deleteColumnByList")
    public ResultUtil deleteColumn(@RequestBody ArrayList<DcColumn> dcColumnList) {
        try {
            ResultUtil resultUtil = dcColumnService.deleteByList(dcColumnList);
            return resultUtil;

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


}