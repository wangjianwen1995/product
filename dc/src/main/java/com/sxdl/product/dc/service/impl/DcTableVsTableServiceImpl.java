package com.sxdl.product.dc.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcProductDao;
import com.sxdl.product.dc.dao.dao1.DcTableDao;
import com.sxdl.product.dc.dao.dao1.DcTableVsTableDao;
import com.sxdl.product.dc.dao.dao1.DcTransferDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.DcProcedureService;
import com.sxdl.product.dc.service.DcTableVsTableService;
import com.sxdl.product.dc.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("dcTableVsTableService")
@Transactional
public class DcTableVsTableServiceImpl extends BaseUUIDServiceImpl<DcTableVsTable> implements DcTableVsTableService {

    @Value("${spring.datasource.primary.url}")
    public String url;
    @Autowired
    private DcTableVsTableDao tableVsTableDao;
    @Autowired
    private DcTableDao dcTableDao;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcProductDao productDao;
    @Autowired
    private DcTransferDao dcTransferDao;

    public List<KeyValueDBO> usedColumn(String id) {
        return tableVsTableDao.usedColumn(id);
    }

    public DcTableVsTable selectByColId(Integer tableid) {
        return tableVsTableDao.selectByColId(tableid);
    }

    @Override
    public List<DcTableVsTable> findByReplaceTableId(String id) {
        List<DcTableVsTable> list = tableVsTableDao.selectByReplaceTableId(id);
        return list;
    }

    @Override
    public List<DcTableVsTable> selectByPid(DcTableVsTable dcTableVsTable) {
        List<DcTableVsTable> dcTableVsTables = tableVsTableDao.select(dcTableVsTable);
        return dcTableVsTables;
    }

    @Override
    public List<DcTableVsTable> findByToTableId(String id) {
        List<DcTableVsTable> dcTableVsTables = tableVsTableDao.selectByToTableId(id);
        return dcTableVsTables;
    }


    /* @Override
     public String testProcedure(DcProcedure dcProcedure) {
         String content = "";
         StringBuilder sb = new StringBuilder();
         StringBuilder sb2 = new StringBuilder();


         List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
         List<DcTableVsTable> collect = dcProcedure.getDcTableVsTables().stream().filter
                 (e -> StringUtil.isNotEmpty(dcProcedure.getTime_column_id()) && dcProcedure.getTime_column_id().equals(e.getFrom_table_column_id())).collect(Collectors.toList());
         String toTimeColumn = "";
         String toTableName = "";
         if (null != collect && collect.size() > 0) {
             DcTableVsTable dcTableVsTable = collect.get(0);
             toTimeColumn = dcTableVsTable.getTo_table_column();
             toTableName = dcTableDao.selectByPrimaryKey(dcTableVsTable.getTo_table_id()).getName();
         } else {
             toTableName = dcTableDao.selectByPrimaryKey(dcTableVsTables.get(0).getTo_table_id()).getName();
         }


         //获取去向表的名称
         String dcbaseName = url.split("=")[1];

         String to_product_id = dcProcedure.getTo_product_id();
         DcProduct dcProduct = productDao.selectByPrimaryKey(to_product_id);
         DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
         if (!"dc".equals(dcProduct.getShort_name())) {
             //DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
             String dbname = dcTransfer.getDbname();
             String transfername = dcTransfer.getName();
             if (dcTransfer.getIsogeny() == 0) {
                 //是否同源 不同源更改表 名称 拼接链接服务器
                 toTableName = transfername + "." + dbname + ".dbo." + toTableName;
             } else {
                 toTableName = dbname + ".dbo." + toTableName;
             }

         }
         //开始创建存储过程
         sb2.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[" + dcProcedure.getName() + "]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].[" + dcProcedure.getName() + "] end ").append(WebUtil.LineBreak);
         handleDao.excuteSqlWithSQL(sb2.toString());
 //            sb.append ( "          DECLARE @sql VARCHAR(8000)" ).append ( WebUtil.LineBreak );
 //            sb.append ( "set @sql=' create proc " + dcProcedure.getName () ).append ( WebUtil.LineBreak );
         sb.append("create proc " + dcProcedure.getName()).append(WebUtil.LineBreak);
         if (1 == dcProcedure.getIsparam()) {
             sb.append("@startDate varchar(10),  @endDate varchar(10)  ").append(WebUtil.LineBreak);
         }
         sb.append("as ").append(WebUtil.LineBreak);
         sb.append("begin").append(WebUtil.LineBreak);
         // 解决跨服务器提交事务的问题
         sb.append("set xact_abort ON").append(WebUtil.LineBreak);
         sb.append("begin tran mytran ").append(WebUtil.LineBreak);
         sb.append("begin try").append(WebUtil.LineBreak);
         // 开始核心抽取数据
         sb.append("declare @stime varchar(255)=convert(char(24),getdate(),120)\n" +
                 "declare @sqlText varchar(max)").append(WebUtil.LineBreak);
         if (toTableName.contains("sys_ks") && dcProcedure.getName().contains("dl_ks")) {
             sb.append("declare my_cursor cursor for     --my_cursor为游标的名称，随便起\n" +
                     "select code,name,is_on,standard_ks_id,standard_ks_name from dl_ks        --这是游标my_cursor的值，这里随便发挥看业务场景\n" +
                     "print '--'\n" +
                     "--打开游标\n" +
                     "open my_cursor                  --没什么好说的\n" +
                     "--变量\n" +
                     "declare   @code varchar(50)               --声明变量  ‘declare’为声明变量 ‘@name’为变量名称 后面为变量类型\n" +
                     "declare   @name varchar(50)     --这里是两个变量用来接收游标的值\n" +
                     "declare   @is_on varchar(1) \n" +
                     "declare   @istodo int  --1:code、name 都相同；2:code=，name!=;3:code!= name=;4:新增；\n" +
                     "declare   @aa_count int \n" +
                     "declare   @standard_ks_id varchar(50) \n" +
                     "declare   @standard_ks_name varchar(50) \n" +
                     "select  @aa_count=COUNT(*) from sys_ks \n" +
                     "update dl_ks set is_on='0' where is_on is null  \n" +
                     "-- update a set a.is_on='0',a.name=a.name+'作废' from sys_ks a where @aa_count>0 and  a.code not in (select code from dl_ks) and a.is_on!='0'\n" +
                     " update a set a.is_on='0',a.short_name=a.name+'_作废' from sys_ks a where @aa_count>0 and  a.code not in (select code from dl_ks) and a.is_on!='0'\n" +
                     "--循环游标\n" +
                     "fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name  --获取my_cursor的下一条数据，其中为两个字段分别赋值给@id,@name\n" +
                     "while @@FETCH_STATUS=0 --假如检索到了数据继续执行\n" +
                     "begin\n" +
                     "print '**'\n" +
                     " --这里是具体业务了\n" +
                     " select  @aa_count=COUNT(*) from sys_ks \n" +
                     " set @istodo=5\n" +
                     "\n" +
                     " select @istodo=4 from sys_ks where  @code not in (select code  from sys_ks ) and @name not in (select name from sys_ks) \n" +
                     " select @istodo=1 from sys_ks where sys_ks.code=@code and sys_ks.name=@name --and sys_ks.is_on=1\n" +
                     " select @istodo=2 from sys_ks where sys_ks.code=@code and sys_ks.name!=@name and @name not in (select name from sys_ks)  --and sys_ks.is_on=1\n" +
                     " select @istodo=3 from sys_ks where sys_ks.code!=@code and sys_ks.name=@name and  @code not in (select code  from sys_ks )  --and (case when @is_on='0' then '1' else '0' end)='1' and sys_ks.is_on='1'\n" +
                     "\n" +
                     " update a set a.short_name=a.name+'_作废' from sys_ks a where a.is_on='0' and a.short_name not like '%_作废'\n" +
                     "\n" +
                     "update a set a.name=b.name from  sys_group_ks a ,sys_ks b  where a.code=b.group_ks_id and   b.is_on='0'\n" +
                     "update b set b.group_ks_name=b.name from  sys_ks b  where b.code=b.group_ks_id and  b.is_on='0'\n" +
                     " print @istodo\n" +
                     "if(@istodo=1)begin \n" +
                     " fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name\n" +
                     " continue\n" +
                     " end\n" +
                     "  if(@istodo=2)begin \n" +
                     "update sys_ks set sys_ks.name=@name where sys_ks.code=@code and sys_ks.is_on='1'\n" +
                     " update sys_ks set sys_ks.group_ks_name=@name where sys_ks.code=@code  and sys_ks.group_ks_id=@code  and sys_ks.is_on='1'\n" +
                     " update sys_group_ks set sys_group_ks.name=@name where sys_group_ks.code=@code and  sys_group_ks.is_on='1'\n" +
                     " end\n" +
                     "  if(@istodo=3) begin \n" +
                     " insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name,group_ks_id,group_ks_name,short_name)\n" +
                     " values (@code,@name,case when @is_on='0' then '1' else '0' end,@standard_ks_id,@standard_ks_name, @code,@name,@name) \n" +
                     " insert into sys_group_ks(code,name,is_on) values (@code,@name,case when @is_on='0' then '1' else '0' end)\n" +
                     " end\n" +
                     " \n" +
                     " --if(@istodo=4) begin \n" +
                     " --print 'a4'\n" +
                     " -- insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name)\n" +
                     " --select distinct @code,@name,case when @is_on=0 then 1 else 0 end,@standard_ks_id,@standard_ks_name, @code,@name from dl_ks where  (case when @is_on=0 then 1 else 0 end)=1\n" +
                     " --insert into sys_group_ks(code,name,is_on)  select distinct @code,@name,(case when @is_on=0 then 1 else 0 end) from dl_ks where (case when @is_on=0 then 1 else 0 end)=1\n" +
                     " --end \n" +
                     " \n" +
                     "  \n" +
                     " --if(@istodo=4) begin \n" +
                     " --print 'a4'\n" +
                     " -- insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name)\n" +
                     " --select distinct code,name,case when is_on='0' then '1' else '0' end,standard_ks_id,standard_ks_name, code,name from dl_ks where code=@code and name=@name and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                     " --insert into sys_group_ks(code,name,is_on)  select distinct code,name,(case when is_on='0' then '1' else '0' end) from dl_ks where code=@code and name=@name and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                     " --end \n" +
                     " \n" +
                     "  \n" +
                     " if(@istodo=4) begin \n" +
                     " print 'a4'\n" +
                     "  insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name,short_name)\n" +
                     " select distinct code,name,case when is_on='0' then '1' else '0' end,standard_ks_id,standard_ks_name, code,name,name from dl_ks where code=@code and name=@name --and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                     " insert into sys_group_ks(code,name,is_on)  select distinct code,name,(case when is_on='0' then '1' else '0' end) from dl_ks where code=@code and name=@name --and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                     " end \n" +
                     " \n" +
                     "  if(@istodo=5) begin \n" +
                     "  print 'a5'\n" +
                     " insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name,short_name)\n" +
                     " values  (@code,@name,(case when @is_on='0' then '1' else '0' end),@standard_ks_id,@standard_ks_name, @code,@name,@name) \n" +
                     " insert into sys_group_ks(code,name,is_on)  \n" +
                     " values (@code,@name,case when @is_on='0' then '1' else '0'end)\n" +
                     " end \n" +
                     " select  @aa_count=COUNT(*) from sys_ks \n" +
                     "print @aa_count\n" +
                     "fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name --获取下一条数据并赋值给变量\n" +
                     "end--关闭释放游标\n" +
                     "close my_cursor\n" +
                     "deallocate my_cursor  \n" +
                     "update a set a.is_id=b.is_id,a.bed=b.bed,a.is_ed=b.is_ed,a.is_od=b.is_od from sys_ks a ,dl_ks b where a.code=b.code and a.name=b.name ").append(WebUtil.LineBreak);
         } else {

             if (StrUtil.isNotEmpty( toTimeColumn)) {
                 sb.append(" delete from " + toTableName + " where " + toTimeColumn + " between @startDate and @endDate ").append(WebUtil.LineBreak).append(WebUtil.LineBreak);
             } else {
                 sb.append(" delete  " + toTableName).append(WebUtil.LineBreak).append(WebUtil.LineBreak);
             }
             if (dcTransfer.getFrom_type().toLowerCase().contains("oraoledb")) {
                 sb.append("set @sqlText='");
                 sb.append(" " + dcProcedure.getMap_sql()).append(WebUtil.LineBreak);
                 if (dcProcedure.getJoin_sql().contains("'")) {
                     sb.append(" " + dcProcedure.getJoin_sql().replace("'", "''''")).append(WebUtil.LineBreak);
                 }else {
                     sb.append(" " + dcProcedure.getJoin_sql()).append(WebUtil.LineBreak);
                 }

                 if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                     sb.append(" where " + dcProcedure.getTime_column_name() + " between ''''' +  @startDate + ''''' and '''''+ @endDate + '''''").append(WebUtil.LineBreak);
                 } else {
                     sb.append(" where  1=1").append(WebUtil.LineBreak);
                 }

                 if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {

                     if (dcProcedure.getWhere_sql().contains("'")) {

                         sb.append("  and " +  dcProcedure.getWhere_sql().replace("'", "''''")).append(WebUtil.LineBreak);
                     }else{
                         sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
                     }

                 }
                 sb.append(" '')' print @sqlText   exec (@sqlText)");
             } else {
                 sb.append(" " + dcProcedure.getMap_sql()).append(WebUtil.LineBreak);
                 sb.append(" " + dcProcedure.getJoin_sql()).append(WebUtil.LineBreak);
                 if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                     sb.append(" where " + dcProcedure.getTime_column_name() + " between  @startDate  and  @endDate ").append(WebUtil.LineBreak);
                 }else {
                     sb.append(" where  1=1").append(WebUtil.LineBreak);
                 }
                 if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
                     sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
                 }
             }
            /* if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
                if (dcTransfer.getFrom_type().equalsIgnoreCase("oraoledb")) {
                    if (dcProcedure.getWhere_sql().contains("'")) {
                        dcProcedure.getWhere_sql().replace("'", "''''");
                    }
                    sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
                } else {
                    sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
                }

            }
            if (dcTransfer.getFrom_type().equalsIgnoreCase("oraoledb")) {
                sb.append(" '')' print @sqlText   exec (@sqlText)");
            }*//*
        }
        //标准格式返回值
        sb.append("SELECT @@ROWCOUNT AS 影响行数,'suc' as 状态,'执行成功!' as 信息 ").append(WebUtil.LineBreak);
        sb.append("commit tran").append(WebUtil.LineBreak);
        sb.append("end try").append(WebUtil.LineBreak);
        sb.append("begin catch ").append(WebUtil.LineBreak);
        //标准格式返回值
        sb.append("SELECT @@ROWCOUNT AS 影响行数,'err' as 状态,ERROR_MESSAGE()+'错误号: '+cast(ERROR_NUMBER() as varchar(255))+',严重性: '+cast(ERROR_SEVERITY() as varchar(255))+',错误状态号: '+cast(ERROR_STATE() as varchar(255))+',发生在第 '+cast(ERROR_LINE() as varchar(255))+' 行' as 信息 ").append(WebUtil.LineBreak);
        sb.append(" rollback tran").append(WebUtil.LineBreak);
        sb.append("end catch").append(WebUtil.LineBreak);
        sb.append("end ");
        content = sb.toString();
        int i = handleDao.excuteSqlWithSQL(content);
        return content;
    }*/
    @Autowired
    DcProcedureService dcProcedureService;


    @Override
    public String testProcedure(DcProcedure dcProcedure) {
        String content = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String toTableName = dcProcedure.getTo_table_name();
        String toTimeColumn = "";
//        String bahColumn="";
//        String ksColumn="";
        DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
        //判断该对照映射是否是抽取外部数据，如果不是，根据TVT进行查找该时间字段对应的目标表字段
        if (!"1".equals(dcTransfer.getEtlp_type())) {
            //TVT流化 筛选时间字段不为空且有fromColumn是该时间字段的所有对照集合
            List<DcTableVsTable> collect = dcProcedure.getDcTableVsTables().stream().filter
                    (e -> StringUtil.isNotEmpty(dcProcedure.getTime_column_id()) && dcProcedure.getTime_column_id().equals(e.getFrom_table_column_id())).collect(Collectors.toList());
            //如果有对照关系，则去第一条对照关系，取其中的目标表字段
            if (null != collect && collect.size() > 0) toTimeColumn = collect.get(0).getTo_table_column();
        }

        //查询库中保存的存储信息
        DcProcedure oldproc = dcProcedureService.findById(dcProcedure.getId());
        //判断旧的存储名称和页面测试保存的存储名称是否一致
        if (null != oldproc && StrUtil.isNotEmpty(oldproc.getName()) && StrUtil.isNotEmpty(dcProcedure.getName()) && !oldproc.getName().equals(dcProcedure.getName())) {
            //删除掉旧的存储过程
            String dropoldsql = "if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[" + oldproc.getName() + "]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].[" + oldproc.getName() + "] end ";
            handleDao.excuteSqlWithSQL(dropoldsql);
        }

        //查询目标产品
        DcProduct dcProduct = productDao.selectByPrimaryKey(dcProcedure.getTo_product_id());
        //如果目标产品不是DC，则需要处理目标表的前缀  合库之后取消判断-注释掉
//        if (!"dc".equals(dcProduct.getShort_name())) {
            String dbname = dcTransfer.getTo_dbname();
            String transfername = dcTransfer.getTo_name();
            if (dcTransfer.getTo_isogeny() == 0) {
                //是否同源 不同源更改表 名称 拼接链接服务器
                toTableName = transfername + "." + dbname + ".dbo." + toTableName;
            } else {
                toTableName = dbname + ".dbo." + toTableName;
            }

//        }
        //先删掉该存储，再进行创建
        sb2.append(" if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[" + dcProcedure.getName() + "]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].[" + dcProcedure.getName() + "] end ").append(WebUtil.LineBreak);
        handleDao.excuteSqlWithSQL(sb2.toString());

        if (toTableName.contains("sys_ks") && dcProcedure.getTable_mian_name().contains("dl_ks")) {
            //开始创建存储过程
            sb.append("create proc " + dcProcedure.getName()).append(WebUtil.LineBreak);
            sb.append("as ").append(WebUtil.LineBreak).append("begin").append(WebUtil.LineBreak);
            sb.append("begin try").append(WebUtil.LineBreak);
            sb.append("set xact_abort ON ").append(WebUtil.LineBreak);
            sb.append("begin tran mytran ").append(WebUtil.LineBreak);
            sb.append("declare my_cursor cursor for     \n" +
                    "select code,name,is_on,standard_ks_id,standard_ks_name from dl_ks   \n" +
                    "print '--'\n" +
                    "--打开游标\n" +
                    "open my_cursor                 \n" +
                    "declare   @code varchar(50)    \n" +
                    "declare   @name varchar(50)     " +
                    "declare   @is_on varchar(1) \n" +
                    "declare   @istodo int  --1:code、name 都相同；2:code=，name!=;3:code!= name=;4:新增；\n" +
                    "declare   @aa_count int \n" +
                    "declare   @standard_ks_id varchar(50) \n" +
                    "declare   @standard_ks_name varchar(50) \n" +
                    "select  @aa_count=COUNT(*) from sys_ks \n" +
                    "update dl_ks set is_on='0' where is_on is null  \n" +
                    "-- update a set a.is_on='0',a.name=a.name+'作废' from sys_ks a where @aa_count>0 and  a.code not in (select code from dl_ks) and a.is_on!='0'\n" +
                    " update a set a.is_on='0',a.short_name=a.name+'_作废' from sys_ks a where @aa_count>0 and  a.code not in (select code from dl_ks) and a.is_on!='0'  and a.is_id=1 \n" +
                    "--循环游标\n" +
                    "fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name  --获取my_cursor的下一条数据，其中为两个字段分别赋值给@id,@name\n" +
                    "while @@FETCH_STATUS=0 --假如检索到了数据继续执行\n" +
                    "begin\n" +
                    "print '**'\n" +
                    " --这里是具体业务了\n" +
                    " select  @aa_count=COUNT(*) from sys_ks \n" +
                    " set @istodo=5\n" +
                    "\n" +
                    " select @istodo=4 from sys_ks where  @code not in (select code  from sys_ks ) and @name not in (select name from sys_ks) \n" +
                    " select @istodo=1 from sys_ks where sys_ks.code=@code and sys_ks.name=@name --and sys_ks.is_on=1\n" +
                    " select @istodo=2 from sys_ks where sys_ks.code=@code and sys_ks.name!=@name and @name not in (select name from sys_ks)  --and sys_ks.is_on=1\n" +
                    " select @istodo=3 from sys_ks where sys_ks.code!=@code and sys_ks.name=@name and  @code not in (select code  from sys_ks )  --and (case when @is_on='0' then '1' else '0' end)='1' and sys_ks.is_on='1'\n" +
                    "\n" +
                    " update a set a.short_name=a.name+'_作废' from sys_ks a where a.is_on='0' and a.short_name not like '%_作废'\n" +
                    "\n" +
                    "update a set a.name=b.name from  sys_group_ks a ,sys_ks b  where a.code=b.group_ks_id and   b.is_on='0'\n" +
                    "update b set b.group_ks_name=b.name from  sys_ks b  where b.code=b.group_ks_id and  b.is_on='0'\n" +
                    " print @istodo\n" +
                    "if(@istodo=1)begin \n" +
                    " fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name\n" +
                    " continue\n" +
                    " end\n" +
                    "  if(@istodo=2)begin \n" +
                    "update sys_ks set sys_ks.name=@name where sys_ks.code=@code and sys_ks.is_on='1'\n" +
                    " update sys_ks set sys_ks.group_ks_name=@name where sys_ks.code=@code  and sys_ks.group_ks_id=@code  and sys_ks.is_on='1'\n" +
                    " update sys_group_ks set sys_group_ks.name=@name where sys_group_ks.code=@code and  sys_group_ks.is_on='1'\n" +
                    " end\n" +
                    "  if(@istodo=3) begin \n" +
                    " insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name,group_ks_id,group_ks_name,short_name)\n" +
                    " values (@code,@name,case when @is_on='0' then '1' else '0' end,@standard_ks_id,@standard_ks_name, @code,@name,@name) \n" +
                    " insert into sys_group_ks(code,name,is_on) values (@code,@name,@is_on)\n" +
                    " end\n" +
                    "  \n" +
                    " if(@istodo=4) begin \n" +
                    " print 'a4'\n" +
                    "  insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name,short_name)\n" +
                    " select distinct code,name,is_on,standard_ks_id,standard_ks_name, code,name,name from dl_ks where code=@code and name=@name --and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                    " insert into sys_group_ks(code,name,is_on)  select distinct code,name,is_on from dl_ks where code=@code and name=@name --and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                    " end \n" +
                    " \n" +
                    "  if(@istodo=5) begin \n" +
                    "  print 'a5'\n" +
                    " insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name,short_name)\n" +
                    " values  (@code,@name,@is_on,@standard_ks_id,@standard_ks_name, @code,@name,@name) \n" +
                    " insert into sys_group_ks(code,name,is_on)  \n" +
                    " values (@code,@name,@is_on)\n" +
                    " end \n" +
                    " select  @aa_count=COUNT(*) from sys_ks \n" +
                    "print @aa_count\n" +
                    "fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name --获取下一条数据并赋值给变量\n" +
                    "end--关闭释放游标\n" +
                    "close my_cursor\n" +
                    "deallocate my_cursor  \n" +
                    "--update a set a.is_id=b.is_id,a.bed=b.bed,a.is_ed=b.is_ed,a.is_od=b.is_od from sys_ks a ,dl_ks b where a.code=b.code and a.name=b.name ").append(WebUtil.LineBreak);
        }else{
        /***============================= 存储过程内容开始 =============================================================*/
        //开始创建存储过程
        sb.append("create proc " + dcProcedure.getName()).append(WebUtil.LineBreak);
        //判断是否有参数，如果有，则进行参数拼接
        if (1 == dcProcedure.getIsparam()) {
            sb.append("@startDate varchar(10),  @endDate varchar(10)  ");
        }
        //再判断是否有单抽字段，如果有值则进行选填参数拼接
        Map<String, String> singleMap = new HashMap<>();
        if ("1".equals(dcProcedure.getSupport_single())) {
            sb.append(",@bah varchar(500)");
        } else {
            sb.append(WebUtil.LineBreak);
        }
        sb.append("as ").append(WebUtil.LineBreak).append("begin").append(WebUtil.LineBreak);
        // 解决跨服务器提交事务的问题   PS：oracle数据库不支持事务操作
        if (!dcTransfer.getFrom_type().toLowerCase().contains("oraoledb")) {
            sb.append("set xact_abort ON").append(WebUtil.LineBreak).append("begin tran mytran ").append(WebUtil.LineBreak);
        }
        //捕获存储执行的信息，影响条数及错误信息
        sb.append("begin try").append(WebUtil.LineBreak);
        // 开始核心抽取数据
        sb.append("declare @stime varchar(255)=convert(char(24),getdate(),120),@sqlText varchar(max),@delSql varchar(max)").append(WebUtil.LineBreak);

        String fromTableId = dcProcedure.getFrom_table_id();

        // 抽取数据前先删除数据 --考虑附表抽取时，关联的是主表的时间字段，删除时也应该关联删除
        sb.append("set @delSql=' ");
        //如果在TVT中找到目标表的时间字段
        if (StrUtil.isNotEmpty(toTimeColumn)) {
            sb.append(" delete " + toTableName + " where CONVERT(varchar(100), case when isdate(convert(varchar,"+toTimeColumn+")) =1 then  cast ("+ toTimeColumn+" as datetime) else convert(varchar(19),"+toTimeColumn+") end , 23)   between '''+@startDate+''' and '''+@endDate+''' ").append(WebUtil.LineBreak).append(WebUtil.LineBreak);
        } else {
            //判断该对照映射是否是抽取外部数据，如果是，则就是抽取外部原表数据，原表数据全字段端，所以来源表和目标表的时间字段是一样的
            if ("1".equals(dcTransfer.getEtlp_type())) {
                if (fromTableId.contains(",") ) {
                    sb.append(" delete " + toTableName + " " + dcProcedure.getTarget_join_sql()+ " where CONVERT(varchar(100), case when isdate(convert(varchar,"+dcProcedure.getTime_column_name()+")) =1 then  cast ("+ dcProcedure.getTime_column_name()+" as datetime) else convert(varchar(19),"+dcProcedure.getTime_column_name()+") end , 23)    between '''+@startDate+''' and '''+@endDate+''' ");
                }else{
                    if(dcProcedure.getIsparam()==1){
                        DcTable dcTable = dcTableDao.selectByPrimaryKey(fromTableId);
                        sb.append(" delete " + toTableName + " from "+ toTableName+" as "+dcTable.getName() +" where CONVERT(varchar(100), case when isdate(convert(varchar,"+dcProcedure.getTime_column_name()+")) =1 then  cast ("+ dcProcedure.getTime_column_name()+" as datetime) else convert(varchar(19),"+dcProcedure.getTime_column_name()+") end , 23) between '''+@startDate+''' and '''+@endDate+''' ");
                    }else{
                        sb.append(" delete " + toTableName+ " where 1=1");
                    }
                }
            }else {
                sb.append(" delete " + toTableName+ " where 1=1");
            }



        }
        sb.append(" ' ").append(WebUtil.LineBreak).append(WebUtil.LineBreak);
        //考虑，如果支持单抽，则删除时也应该拼接单抽传入的病案号
        if ("1".equals(dcProcedure.getSupport_single())) {
            if("1".equals(dcTransfer.getEtlp_type())){
                if (StringUtil.isNotEmpty(dcProcedure.getSingelbah_id())) {
                    sb.append(" if(@bah is not null and len(@bah)>0) begin set  @delSql= @delSql+' and " + dcProcedure.getSingelbah_id().replace("'","''") + " ='''+@bah+''' ' end");
                }

            }else{
                if (StringUtil.isNotEmpty(dcProcedure.getSingelbah())) {
                    sb.append(" if(@bah is not null and len(@bah)>0) begin set  @delSql= @delSql+' and " + dcProcedure.getSingelbah() + " ='''+@bah+''' ' end");
                }

            }

        }
        sb.append(WebUtil.LineBreak);
        sb.append(" exec (@delSql) ");
        sb.append(WebUtil.LineBreak);
        //来源表多个 用【，】分割
        String[] split = fromTableId.split(",");
        DcTable dcTable = new DcTable();
        for (String id : split) {
            dcTable = dcTableDao.selectByPrimaryKey(id);
            //如果查询到的表类型是虚拟表，则需要去拼接虚拟表的转化sql TODO 未测试 拼接行转列的执行sql
            if (dcTable.getType_id() == 6) sb.append(dcTable.getConversion_sql());
        }
        System.out.println("----------------------------------------------");
        // 判断源数据库类型，如果是oracle 则需要拼接openquery语句
        if (dcTransfer.getFrom_type().toLowerCase().contains("oraoledb")) {
            sb.append("set @sqlText='");

            //openquery语句拼接   需要把页面中的单引号替换成五个
            sb.append(" " + dcProcedure.getMap_sql().replaceAll("'", "''")).append(WebUtil.LineBreak);
            sb.append(" " + dcProcedure.getJoin_sql().replace("'", "''''")).append(WebUtil.LineBreak);
            //判断如果有时间字段，需要拼接日期范围的条件，oracle需要加函数转化
            if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                sb.append(" where To_CHAR(" + dcProcedure.getTime_column_name() + ",''''YYYY-MM-DD'''')" + " between ''''' +  @startDate +'''''  and '''''+ @endDate + ''''' ").append(WebUtil.LineBreak);
            } else {
                sb.append(" where  1=1").append(WebUtil.LineBreak);
            }


            if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
                sb.append("  and " + dcProcedure.getWhere_sql().replace("'", "''''")).append(WebUtil.LineBreak);
            }

            //如果有单抽字段的配置，则需要拼接单抽字段的条件
            if ("1".equals(dcProcedure.getSupport_single())) {
                sb.append(" ' ");
                if (StringUtil.isNotEmpty(dcProcedure.getSingelbah_id())) {
                    sb.append(" if(@bah is not null and len(@bah)>0) begin set  @sqlText= @sqlText+' and " + dcProcedure.getSingelbah_id().replace("'", "''''") + " ='+@bah+' ' end");
                }

                sb.append(" set  @sqlText= @sqlText+''')' ");
            } else {
                sb.append(" '') ' ");
            }

            //sb.append(" print @sqlText ").append(WebUtil.LineBreak);

            sb.append(" exec (@sqlText) ").append(WebUtil.LineBreak);

        } else {
            sb.append("set @sqlText='");
            sb.append(" " + dcProcedure.getMap_sql().replace("'","''")).append(WebUtil.LineBreak);
            sb.append(" '").append(WebUtil.LineBreak);
            sb.append("set @sqlText=@sqlText+' ").append(WebUtil.LineBreak);
            sb.append(" " + dcProcedure.getJoin_sql().replace("'","''")).append(WebUtil.LineBreak);
            //先判断是否有参数,再拼接时间字段的参数
            if (1 == dcProcedure.getIsparam() && null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                sb.append(" where CONVERT(varchar(100), case when isdate(convert(varchar,"+dcProcedure.getTime_column_name()+")) =1 then  cast ("+ dcProcedure.getTime_column_name()+" as datetime) " +
                        "else convert(varchar(19),"+dcProcedure.getTime_column_name()+") end , 23)  between  '''+@startDate+''' and  '''+@endDate+''' '").append(WebUtil.LineBreak);
            } else {
                sb.append(" where  1=1 '").append(WebUtil.LineBreak);
            }

            if ("1".equals(dcProcedure.getSupport_single())) {

                if (StringUtil.isNotEmpty(dcProcedure.getSingelbah_id())) {
                    sb.append(" if(@bah is not null and len(@bah)>0) begin set  @sqlText= @sqlText+' and " + dcProcedure.getSingelbah_id().replace("'","''") + " ='''+@bah+''' ' end  ");
                }

            }

            if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
                sb.append(" set @sqlText=@sqlText+' and " + dcProcedure.getWhere_sql().replace("'","''")).append(WebUtil.LineBreak);
                sb.append("'");
            }
            /*else{
                sb.append("'");
            }*/
            sb.append(" exec(@sqlText)").append(WebUtil.LineBreak);
        }

        /***============================= 存储过程内容结束 =============================================================*/
        }
        sb.append("SELECT @@ROWCOUNT AS 影响行数,'suc' as 状态,'执行成功!' as 信息 ").append(WebUtil.LineBreak);
        if (!dcTransfer.getFrom_type().toLowerCase().contains("oraoledb"))
            sb.append("commit tran").append(WebUtil.LineBreak);

        sb.append("end try").append(WebUtil.LineBreak);
        sb.append("begin catch ").append(WebUtil.LineBreak);
        //标准格式返回值
        sb.append("SELECT @@ROWCOUNT AS 影响行数,'err' as 状态,ERROR_MESSAGE()+'错误号: '+cast(ERROR_NUMBER() as varchar(255))+',严重性: '+cast(ERROR_SEVERITY() as varchar(255))+',错误状态号: '+cast(ERROR_STATE() as varchar(255))+',发生在第 '+cast(ERROR_LINE() as varchar(255))+' 行' as 信息 ").append(WebUtil.LineBreak);
        if (!dcTransfer.getFrom_type().toLowerCase().contains("oraoledb"))
            sb.append(" rollback tran").append(WebUtil.LineBreak);
        sb.append("end catch").append(WebUtil.LineBreak);
        sb.append("end ");
        content = sb.toString();
        return content;


    }

    public String testProcedure1(DcProcedure dcProcedure) {
        String content = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
        List<DcTableVsTable> collect = dcProcedure.getDcTableVsTables().stream().filter
                (e -> StringUtil.isNotEmpty(dcProcedure.getTime_column_id()) && dcProcedure.getTime_column_id().equals(e.getFrom_table_column_id())).collect(Collectors.toList());
        String toTimeColumn = "";
        String toTableName = "";
        if (null != collect && collect.size() > 0) {
            DcTableVsTable dcTableVsTable = collect.get(0);
            toTimeColumn = dcTableVsTable.getTo_table_column();
            toTableName = dcTableDao.selectByPrimaryKey(dcTableVsTable.getTo_table_id()).getName();
        } else {
            toTableName = dcTableDao.selectByPrimaryKey(dcTableVsTables.get(0).getTo_table_id()).getName();
        }
        //查询库中保存的存储信息
        DcProcedure oldproc = dcProcedureService.findById(dcProcedure.getId());
        //判断旧的存储名称和页面测试保存的存储名称是否一致
        if (null != oldproc && StrUtil.isNotEmpty(oldproc.getName()) && StrUtil.isNotEmpty(dcProcedure.getName()) && !oldproc.getName().equals(dcProcedure.getName())) {
            //删除掉旧的存储过程
            String dropoldsql = "if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[" + oldproc.getName() + "]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].[" + oldproc.getName() + "] end ";
            handleDao.excuteSqlWithSQL(dropoldsql);
        }

        //获取去向表的名称
        String dcbaseName = url.split("=")[1];

        String to_product_id = dcProcedure.getTo_product_id();
        DcProduct dcProduct = productDao.selectByPrimaryKey(to_product_id);
        DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
        if (!"dc".equals(dcProduct.getShort_name())) {
            //DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
            String dbname = dcTransfer.getDbname();
            String transfername = dcTransfer.getName();
            if (dcTransfer.getIsogeny() == 0) {
                //是否同源 不同源更改表 名称 拼接链接服务器
                toTableName = transfername + "." + dbname + ".dbo." + toTableName;
            } else {
                toTableName = dbname + ".dbo." + toTableName;
            }

        }
        //开始创建存储过程
        sb2.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[" + dcProcedure.getName() + "]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].[" + dcProcedure.getName() + "] end ").append(WebUtil.LineBreak);
        handleDao.excuteSqlWithSQL(sb2.toString());
        //            sb.append ( "          DECLARE @sql VARCHAR(8000)" ).append ( WebUtil.LineBreak );
        //            sb.append ( "set @sql=' create proc " + dcProcedure.getName () ).append ( WebUtil.LineBreak );
        sb.append("create proc " + dcProcedure.getName()).append(WebUtil.LineBreak);
        if (1 == dcProcedure.getIsparam()) {
            sb.append("@startDate varchar(10),  @endDate varchar(10)  ").append(WebUtil.LineBreak);
        }
        sb.append("as ").append(WebUtil.LineBreak);
        sb.append("begin").append(WebUtil.LineBreak);
        // 解决跨服务器提交事务的问题
        sb.append("set xact_abort ON").append(WebUtil.LineBreak);
        sb.append("begin tran mytran ").append(WebUtil.LineBreak);
        sb.append("begin try").append(WebUtil.LineBreak);
        // 开始核心抽取数据
        sb.append("declare @stime varchar(255)=convert(char(24),getdate(),120)\n" +
                "declare @sqlText varchar(max)").append(WebUtil.LineBreak);
        if (toTableName.contains("sys_ks") && dcProcedure.getName().contains("dl_ks")) {
            sb.append("declare my_cursor cursor for     --my_cursor为游标的名称，随便起\n" +
                    "select code,name,is_on,standard_ks_id,standard_ks_name from dl_ks        --这是游标my_cursor的值，这里随便发挥看业务场景\n" +
                    "print '--'\n" +
                    "--打开游标\n" +
                    "open my_cursor                  --没什么好说的\n" +
                    "--变量\n" +
                    "declare   @code varchar(50)               --声明变量  ‘declare’为声明变量 ‘@name’为变量名称 后面为变量类型\n" +
                    "declare   @name varchar(50)     --这里是两个变量用来接收游标的值\n" +
                    "declare   @is_on varchar(1) \n" +
                    "declare   @istodo int  --1:code、name 都相同；2:code=，name!=;3:code!= name=;4:新增；\n" +
                    "declare   @aa_count int \n" +
                    "declare   @standard_ks_id varchar(50) \n" +
                    "declare   @standard_ks_name varchar(50) \n" +
                    "select  @aa_count=COUNT(*) from sys_ks \n" +
                    "update dl_ks set is_on='0' where is_on is null  \n" +
                    "-- update a set a.is_on='0',a.name=a.name+'作废' from sys_ks a where @aa_count>0 and  a.code not in (select code from dl_ks) and a.is_on!='0'\n" +
                    " update a set a.is_on='0',a.short_name=a.name+'_作废' from sys_ks a where @aa_count>0 and  a.code not in (select code from dl_ks) and a.is_on!='0'\n" +
                    "--循环游标\n" +
                    "fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name  --获取my_cursor的下一条数据，其中为两个字段分别赋值给@id,@name\n" +
                    "while @@FETCH_STATUS=0 --假如检索到了数据继续执行\n" +
                    "begin\n" +
                    "print '**'\n" +
                    " --这里是具体业务了\n" +
                    " select  @aa_count=COUNT(*) from sys_ks \n" +
                    " set @istodo=5\n" +
                    "\n" +
                    " select @istodo=4 from sys_ks where  @code not in (select code  from sys_ks ) and @name not in (select name from sys_ks) \n" +
                    " select @istodo=1 from sys_ks where sys_ks.code=@code and sys_ks.name=@name --and sys_ks.is_on=1\n" +
                    " select @istodo=2 from sys_ks where sys_ks.code=@code and sys_ks.name!=@name and @name not in (select name from sys_ks)  --and sys_ks.is_on=1\n" +
                    " select @istodo=3 from sys_ks where sys_ks.code!=@code and sys_ks.name=@name and  @code not in (select code  from sys_ks )  --and (case when @is_on='0' then '1' else '0' end)='1' and sys_ks.is_on='1'\n" +
                    "\n" +
                    " update a set a.short_name=a.name+'_作废' from sys_ks a where a.is_on='0' and a.short_name not like '%_作废'\n" +
                    "\n" +
                    "update a set a.name=b.name from  sys_group_ks a ,sys_ks b  where a.code=b.group_ks_id and   b.is_on='0'\n" +
                    "update b set b.group_ks_name=b.name from  sys_ks b  where b.code=b.group_ks_id and  b.is_on='0'\n" +
                    " print @istodo\n" +
                    "if(@istodo=1)begin \n" +
                    " fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name\n" +
                    " continue\n" +
                    " end\n" +
                    "  if(@istodo=2)begin \n" +
                    "update sys_ks set sys_ks.name=@name where sys_ks.code=@code and sys_ks.is_on='1'\n" +
                    " update sys_ks set sys_ks.group_ks_name=@name where sys_ks.code=@code  and sys_ks.group_ks_id=@code  and sys_ks.is_on='1'\n" +
                    " update sys_group_ks set sys_group_ks.name=@name where sys_group_ks.code=@code and  sys_group_ks.is_on='1'\n" +
                    " end\n" +
                    "  if(@istodo=3) begin \n" +
                    " insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name,group_ks_id,group_ks_name,short_name)\n" +
                    " values (@code,@name,case when @is_on='0' then '1' else '0' end,@standard_ks_id,@standard_ks_name, @code,@name,@name) \n" +
                    " insert into sys_group_ks(code,name,is_on) values (@code,@name,case when @is_on='0' then '1' else '0' end)\n" +
                    " end\n" +
                    " \n" +
                    " --if(@istodo=4) begin \n" +
                    " --print 'a4'\n" +
                    " -- insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name)\n" +
                    " --select distinct @code,@name,case when @is_on=0 then 1 else 0 end,@standard_ks_id,@standard_ks_name, @code,@name from dl_ks where  (case when @is_on=0 then 1 else 0 end)=1\n" +
                    " --insert into sys_group_ks(code,name,is_on)  select distinct @code,@name,(case when @is_on=0 then 1 else 0 end) from dl_ks where (case when @is_on=0 then 1 else 0 end)=1\n" +
                    " --end \n" +
                    " \n" +
                    "  \n" +
                    " --if(@istodo=4) begin \n" +
                    " --print 'a4'\n" +
                    " -- insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name)\n" +
                    " --select distinct code,name,case when is_on='0' then '1' else '0' end,standard_ks_id,standard_ks_name, code,name from dl_ks where code=@code and name=@name and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                    " --insert into sys_group_ks(code,name,is_on)  select distinct code,name,(case when is_on='0' then '1' else '0' end) from dl_ks where code=@code and name=@name and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                    " --end \n" +
                    " \n" +
                    "  \n" +
                    " if(@istodo=4) begin \n" +
                    " print 'a4'\n" +
                    "  insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name,short_name)\n" +
                    " select distinct code,name,case when is_on='0' then '1' else '0' end,standard_ks_id,standard_ks_name, code,name,name from dl_ks where code=@code and name=@name --and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                    " insert into sys_group_ks(code,name,is_on)  select distinct code,name,(case when is_on='0' then '1' else '0' end) from dl_ks where code=@code and name=@name --and  (case when @is_on='0' then '1' else '0' end)='1'\n" +
                    " end \n" +
                    " \n" +
                    "  if(@istodo=5) begin \n" +
                    "  print 'a5'\n" +
                    " insert into sys_ks(code,name,is_on,standard_ks_id,standard_ks_name, group_ks_id,group_ks_name,short_name)\n" +
                    " values  (@code,@name,(case when @is_on='0' then '1' else '0' end),@standard_ks_id,@standard_ks_name, @code,@name,@name) \n" +
                    " insert into sys_group_ks(code,name,is_on)  \n" +
                    " values (@code,@name,case when @is_on='0' then '1' else '0'end)\n" +
                    " end \n" +
                    " select  @aa_count=COUNT(*) from sys_ks \n" +
                    "print @aa_count\n" +
                    "fetch next from my_cursor into @code,@name,@is_on,@standard_ks_id,@standard_ks_name --获取下一条数据并赋值给变量\n" +
                    "end--关闭释放游标\n" +
                    "close my_cursor\n" +
                    "deallocate my_cursor  \n" +
                    "--update a set a.is_id=b.is_id,a.bed=b.bed,a.is_ed=b.is_ed,a.is_od=b.is_od from sys_ks a ,dl_ks b where a.code=b.code and a.name=b.name ").append(WebUtil.LineBreak);
        } else
            {

            if (StrUtil.isNotEmpty(toTimeColumn)) {
                sb.append(" delete from " + toTableName + " where " + toTimeColumn + " between @startDate and @endDate ").append(WebUtil.LineBreak).append(WebUtil.LineBreak);
            } else {
                sb.append(" delete  " + toTableName).append(WebUtil.LineBreak).append(WebUtil.LineBreak);
            }

//           if (dcTransfer.getFrom_type().toLowerCase().contains("oraoledb")) {
//               sb.append("set @sqlText='");
//
//               if (dcProcedure.getJoin_sql().contains("''''")) {
//                   sb.append(" " + dcProcedure.getMap_sql().replaceAll("''''", "''")).append(WebUtil.LineBreak);
//               }else {
//                   sb.append(" " + dcProcedure.getMap_sql()).append(WebUtil.LineBreak);
//               }
//              // sb.append(" " + dcProcedure.getMap_sql()).append(WebUtil.LineBreak);
//               if (dcProcedure.getJoin_sql().contains("'")) {
//                   sb.append(" " + dcProcedure.getJoin_sql().replace("'", "''")).append(WebUtil.LineBreak);
//               }else {
//                   sb.append(" " + dcProcedure.getJoin_sql()).append(WebUtil.LineBreak);
//               }
//
//               if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
//                   sb.append(" where " + dcProcedure.getTime_column_name() + " between ''' +  @startDate + ''' and '''+ @endDate + '''").append(WebUtil.LineBreak);
//               } else {
//                   sb.append(" where  1=1").append(WebUtil.LineBreak);
//               }
//               if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
//
//                   if (dcProcedure.getWhere_sql().contains("'")) {
//
//                       sb.append("  and " +  dcProcedure.getWhere_sql().replace("'", "''")).append(WebUtil.LineBreak);
//                   }else{
//                       sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
//                   }
//               }
//               sb.append("' print @sqlText ").append(WebUtil.LineBreak);;
//               sb.append(" INSERT INTO ").append(toTableName) .append(" exec (@sqlText) at  ").append(dcTransfer.getName()).append(WebUtil.LineBreak);;
//           } else {
            sb.append(" " + dcProcedure.getMap_sql()).append(WebUtil.LineBreak);
            sb.append(" " + dcProcedure.getJoin_sql()).append(WebUtil.LineBreak);
            //先判断是否有参数,再拼接时间字段的参数
            if (1 == dcProcedure.getIsparam()) {
                if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                    if (dcTransfer.getFrom_type().toLowerCase().contains("oraoledb")) {
                        sb.append(" where " + dcProcedure.getTime_column_name().substring(dcProcedure.getTime_column_name().indexOf(".") + 1) + " between  @startDate  and  @endDate ").append(WebUtil.LineBreak);
                    } else {
                        sb.append(" where " + dcProcedure.getTime_column_name() + " between  @startDate  and  @endDate ").append(WebUtil.LineBreak);
                    }
                }
            } else {
                sb.append(" where  1=1 ").append(WebUtil.LineBreak);
            }
            if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
                sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
            }
            //          }
           /* if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
                if (dcTransfer.getFrom_type().equalsIgnoreCase("oraoledb")) {
                    if (dcProcedure.getWhere_sql().contains("'")) {
                        dcProcedure.getWhere_sql().replace("'", "''''");
                    }
                    sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
                } else {
                    sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
                }

            }
            if (dcTransfer.getFrom_type().equalsIgnoreCase("oraoledb")) {
                sb.append(" '')' print @sqlText   exec (@sqlText)");
            }*/
        }
        //标准格式返回值
        sb.append("SELECT @@ROWCOUNT AS 影响行数,'suc' as 状态,'执行成功!' as 信息 ").append(WebUtil.LineBreak);
        sb.append("commit tran").append(WebUtil.LineBreak);
        sb.append("end try").append(WebUtil.LineBreak);
        sb.append("begin catch ").append(WebUtil.LineBreak);
        //标准格式返回值
        sb.append("SELECT @@ROWCOUNT AS 影响行数,'err' as 状态,ERROR_MESSAGE()+'错误号: '+cast(ERROR_NUMBER() as varchar(255))+',严重性: '+cast(ERROR_SEVERITY() as varchar(255))+',错误状态号: '+cast(ERROR_STATE() as varchar(255))+',发生在第 '+cast(ERROR_LINE() as varchar(255))+' 行' as 信息 ").append(WebUtil.LineBreak);
        sb.append(" rollback tran").append(WebUtil.LineBreak);
        sb.append("end catch").append(WebUtil.LineBreak);
        sb.append("end ");
        content = sb.toString();
        int i = handleDao.excuteSqlWithSQL(content);
        return content;
    }

}