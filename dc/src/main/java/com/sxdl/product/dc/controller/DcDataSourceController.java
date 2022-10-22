package com.sxdl.product.dc.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcDataSource;
import com.sxdl.product.dc.entity.DcProcedure;
import com.sxdl.product.dc.entity.DcTransfer;
import com.sxdl.product.dc.service.DcDataSourceService;
import com.sxdl.product.dc.service.DcProcedureService;
import com.sxdl.product.dc.service.DcTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "数据源管理")
@RestController
@RequestMapping("/datasource")
public class DcDataSourceController {

    @Autowired
    private DcDataSourceService dcDataSourceService;

    @Autowired
    private DcTransferService dcTransferService;

    @Autowired
    private DcProcedureService dcProcedureService;

    @Autowired
    private HandleDao handleDao;



    @ApiOperation(value = "根据name_zh查询", notes = "根据名称模糊查询")
    @GetMapping("/findByName")
    public ResultUtil<PageInfo<DcDataSource>> findByName(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            DcDataSource source = new DcDataSource();
            if(StringUtil.isEmpty(name)) source.setName_zh(name);
            PageInfo<DcDataSource> list = dcDataSourceService.queryPageListOrderBy(pageInfo, source,"name","asc");
            return ResultUtil.success(list);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询数据源下拉框", notes = "查询数据源下拉框")
    @GetMapping("/findByCondition")
    public ResultUtil<List<DcDataSource>> findByCondition(@RequestParam(value = "name", defaultValue = "") String name) {
        try {
            List<DcDataSource> list = dcDataSourceService.findByCondition(name);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }



    @ApiOperation(value = "测试", notes = "测试链接服务器")
    @PostMapping("/findTest")
    public ResultUtil<DcDataSource> checkout(@RequestBody DcDataSource source) {
        try {
            //DB2OLEDB
            String fromType = source.getDb_type();
            String status = "";
            String linkStr = source.getLink_str();

            String name = source.getName();
            String fromUrl = source.getUrl();
            String username = source.getUsername();
            String pwd = source.getPwd();
            status = dcDataSourceService.findInfo(name, fromType, fromUrl, username, pwd, linkStr);

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

    @ApiOperation(value = "删除", notes = "删除链接服务器")
    @DeleteMapping("/deleteLink")
    public ResultUtil<DcDataSource> deleteLink(@RequestBody DcDataSource source) {
        try {

            DcTransfer transfer = new DcTransfer();
            transfer.setData_source_id(source.getId());
            List<DcTransfer> transfers = dcTransferService.select(transfer);

            if(CollUtil.isNotEmpty(transfers)){
                return ResultUtil.error("该链接服务器已被绑定,不可删除");
            }

            String sql = "exec sp_dropserver @name,'droplogins' ";
            dcDataSourceService.delete(source);
            dcDataSourceService.deleteServerLink(sql.replace("@name", source.getName()));
            dcDataSourceService.delete(source);
            return ResultUtil.success("删除链接服务器");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增", notes = "添加数据源")
    @PostMapping("/insert")
    public ResultUtil<DcDataSource> insertHospital(@RequestBody DcDataSource source) {
        try {

            if("".equals(source.getId()) || source.getId()==null){
                source.setTime(DateUtil.format(new Date(), "yyyy-MM-dd"));
                dcDataSourceService.insert(source);
            }else {
                source.setTime(DateUtil.format(new Date(), "yyyy-MM-dd"));

                DcTransfer transfer = new DcTransfer();
                transfer.setData_source_id(source.getId());
                List<DcTransfer> transfers = dcTransferService.select(transfer);
                if (CollUtil.isNotEmpty(transfers)) {
                    for (DcTransfer t : transfers) {

                        DcProcedure dcProcedure = new DcProcedure();
                        dcProcedure.setTransfer_id(t.getId());
                        List<DcProcedure> procedureList = dcProcedureService.select(dcProcedure);
                        if (CollUtil.isNotEmpty(procedureList)) {
                            String link_old = "";
                            String link_new = "";

                            if ("SQLOLEDB".equals(t.getFrom_type())) {
                                link_old = t.getName() + "." + t.getDbname() + ".dbo.";
                            } else {
                                link_old = t.getName();
                            }


                            if ("SQLOLEDB".equals(source.getDb_type())) {
                                link_new = source.getName() + "." + source.getDbname() + ".dbo.";
                            } else {
                                link_new = source.getName();
                            }


                            for (DcProcedure e : procedureList) {
                                if (null != e.getProc_type() && e.getProc_type() == 2) {
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

                            t.setFrom_type(source.getDb_type());
                            t.setName(source.getName());
                            t.setDbname(source.getDbname());
                            t.setLink_str(source.getLink_str());
                            dcTransferService.update(t);
                        }
                    }
                }
                dcDataSourceService.update(source);
            }
            return ResultUtil.success("保存成功！");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }



}
