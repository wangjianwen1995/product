package com.sxdl.product.dc.util;


/**
 *  直连库 工具类
 */
public class DirectLinkLibraryUtil {


    public static final String LineBreak = "\r\n";
    public static final String Tab = "\t";

    public static void main(String[] args) {



    }


    /**
     * 动态创建存储过程,该存储过程的（不带参数类型的）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */
    public static String  getcreateSqlOfDB2(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();

        //判断临时表是否存在 ,存在删除
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("      Declare @columns varchar(5000),@DcColumns varchar(5000),@fromSql varchar(500)").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+"."+dbname+"."+tablename+" where 1=2").append(LineBreak);
        sb.append("      set @fromSql = '' from "+ transfername+ "."+dbname+"."+tablename+" where 1=2 '' ").append(LineBreak);
        sb.append("         select @columns = stuff((SELECT '',''+ convert(varchar(5000),name)    FROM tempdb.dbo.SYSCOLUMNS WHERE ID=OBJECT_ID(''tempdb.dbo.#proctable'' ) for xml path('''')),1,1,'''')").append(LineBreak);
        sb.append("          if  NOT EXISTS (select 1 from sysobjects where  Name =''"+tablename+"''  And Type In (''S'',''U'')) begin").append(LineBreak);
        sb.append("                 exec DcCreateTable ''"+tablename+"'',@fromSql").append(LineBreak);
        sb.append("             end else begin").append(LineBreak);
        sb.append("                 select @DcColumns = stuff((SELECT '',''+ convert(varchar(5000),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID(''"+tablename+"'') for xml path('''')),1,1,'''') ").append(LineBreak);
        sb.append("                 exec DcAlterTable ''"+tablename+"'',@columns,@DcColumns").append(LineBreak);
        sb.append("             end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }


    /**
     * 动态创建存储过程,该存储过程的（不带参数类型的）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */
    public static String  getcreateSql(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();

        //判断临时表是否存在 ,存在删除
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("      Declare @columns varchar(5000),@DcColumns varchar(5000),@fromSql varchar(500)").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+"."+dbname+".dbo."+tablename+" where 1=2").append(LineBreak);
        sb.append("      set @fromSql = '' from "+ transfername+ "."+dbname+".dbo."+tablename+" where 1=2 '' ").append(LineBreak);
        sb.append("         select @columns = stuff((SELECT '',''+ convert(varchar(5000),name)    FROM tempdb.dbo.SYSCOLUMNS WHERE ID=OBJECT_ID(''tempdb.dbo.#proctable'' ) for xml path('''')),1,1,'''')").append(LineBreak);
        sb.append("          if  NOT EXISTS (select 1 from sysobjects where  Name =''"+tablename+"''  And Type In (''S'',''U'')) begin").append(LineBreak);
        sb.append("                 exec DcCreateTable ''"+tablename+"'',@fromSql").append(LineBreak);
        sb.append("             end else begin").append(LineBreak);
        sb.append("                 select @DcColumns = stuff((SELECT '',''+ convert(varchar(5000),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID(''"+tablename+"'') for xml path('''')),1,1,'''') ").append(LineBreak);
        sb.append("                 exec DcAlterTable ''"+tablename+"'',@columns,@DcColumns").append(LineBreak);
        sb.append("             end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }

    /**
     * 动态创建存储过程,该存储过程的（不带参数类型的）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */
    public static String  getcreateSqlOfOrcale(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();

        //判断临时表是否存在 ,存在删除
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("      Declare @columns varchar(5000),@DcColumns varchar(5000),@fromSql varchar(500)").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+".."+dbname+"."+tablename+" where 1=2").append(LineBreak);
        sb.append("      set @fromSql = '' from "+ transfername+ ".."+dbname+"."+tablename+" where 1=2 '' ").append(LineBreak);
        sb.append("         select @columns = stuff((SELECT '',''+ convert(varchar(5000),name)    FROM tempdb.dbo.SYSCOLUMNS WHERE ID=OBJECT_ID(''tempdb.dbo.#proctable'' ) for xml path('''')),1,1,'''')").append(LineBreak);
        sb.append("          if  NOT EXISTS (select 1 from sysobjects where  Name =''"+tablename+"''  And Type In (''S'',''U'')) begin").append(LineBreak);
        sb.append("                 exec DcCreateTable ''"+tablename+"'',@fromSql").append(LineBreak);
        sb.append("             end else begin").append(LineBreak);
        sb.append("                 select @DcColumns = stuff((SELECT '',''+ convert(varchar(5000),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID(''"+tablename+"'') for xml path('''')),1,1,'''') ").append(LineBreak);
        sb.append("                 exec DcAlterTable ''"+tablename+"'',@columns,@DcColumns").append(LineBreak);
        sb.append("             end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }

    /**
     * 获取远程表的字段
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */

    public static String getTableColums(String transfername,String dbname,String tablename,String fromType){
       String fromAfterSql="";
        if (fromType.equals("SQLOLEDB")) {
            fromAfterSql = transfername+"."+dbname+".dbo."+tablename+" where 1=2";
        } else if (fromType.equals("DB2OLEDB")) {
            fromAfterSql = transfername+"."+dbname+".dbo."+tablename;
        } else {
            fromAfterSql = "openquery("+transfername+",''select * from \""+tablename+"\" where 1=2'')";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+fromAfterSql).append(LineBreak);
        sb.append("         select  stuff((SELECT '',''+ convert(varchar(5000),name)    FROM tempdb.dbo.SYSCOLUMNS WHERE ID=OBJECT_ID(''tempdb.dbo.#proctable'' ) for xml path('''')),1,1,'''')").append(LineBreak);
        sb.append(" '").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }


    /**
     * 获取远程表的字段
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */

    public static String getTableColumsOfDB2(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+"."+dbname+"."+tablename+" where 1=2 ").append(LineBreak);
        sb.append("         select  stuff((SELECT '',''+ convert(varchar(5000),name)    FROM tempdb.dbo.SYSCOLUMNS WHERE ID=OBJECT_ID(''tempdb.dbo.#proctable'' ) for xml path('''')),1,1,'''')").append(LineBreak);
        sb.append(" '").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }

    /**
     * 获取远程表的字段 和 字段类型
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */

    public static String getColumsAndType(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#tmpe2'')) BEGIN DROP TABLE #tmpe2  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+"."+dbname+".dbo."+tablename+" where 1=2 ").append(LineBreak);
        sb.append("        SELECT  b.name type,a.name name  INTO #temp2 FROM    tempdb.dbo.SYSCOLUMNS a LEFT JOIN systypes b ON  a.xtype =b.xusertype WHERE   ID = OBJECT_ID(N''tempdb.dbo.#proctable'')  ").append(LineBreak);
       // sb.append("        UPDATE #temp2 SET name= ''CONVERT(VARCHAR(max),CONVERT(VARBINARY(max),''+name+''))'' WHERE type=''image''  ").append(LineBreak);
        sb.append("         UPDATE #temp2 SET name= ''CONVERT(VARCHAR(20),cast(''+name+'' as datetime),120) '' WHERE type=''datetime''   ").append(LineBreak);
        sb.append("          select  stuff((SELECT '',''+ convert(varchar(5000),name)    FROM #temp2  for xml path('''')),1,1,'''') ").append(LineBreak);
        sb.append(" '").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }


    /**
     * 获取远程表的字段 和 字段类型
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */

    public static String getColumsAndTypeOfDB2(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#tmpe2'')) BEGIN DROP TABLE #tmpe2  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+"."+dbname+"."+tablename+" where 1=2 ").append(LineBreak);
        sb.append("        SELECT  b.name type,a.name name  INTO #temp2 FROM    tempdb.dbo.SYSCOLUMNS a LEFT JOIN systypes b ON  a.xtype =b.xusertype WHERE   ID = OBJECT_ID(N''tempdb.dbo.#proctable'')  ").append(LineBreak);
        // sb.append("        UPDATE #temp2 SET name= ''CONVERT(VARCHAR(max),CONVERT(VARBINARY(max),''+name+''))'' WHERE type=''image''  ").append(LineBreak);
        sb.append("         UPDATE #temp2 SET name= ''CONVERT(VARCHAR(20),cast(''+name+'' as datetime ),120) '' WHERE type=''datetime''   ").append(LineBreak);
        sb.append("          select  stuff((SELECT '',''+ convert(varchar(5000),name)    FROM #temp2  for xml path('''')),1,1,'''') ").append(LineBreak);
        sb.append(" '").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }

    /**
     * 获取远程表的字段 和 字段类型
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */

    public static String getColumsAndTypeOfOracle(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#tmpe2'')) BEGIN DROP TABLE #tmpe2  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+".."+dbname+"."+tablename+" where 1=2").append(LineBreak);
        sb.append("        SELECT  b.name type,a.name name  INTO #temp2 FROM    tempdb.dbo.SYSCOLUMNS a " +
                           " LEFT JOIN systypes b ON  a.xtype =b.xusertype " +
                           " WHERE   ID = OBJECT_ID(N''tempdb.dbo.#proctable'')  ").append(LineBreak);
        //sb.append("        UPDATE #temp2 SET name= ''CONVERT(VARCHAR(max),CONVERT(VARBINARY(max),''+name+''))'' WHERE type=''image''  ").append(LineBreak);
        sb.append("         UPDATE #temp2 SET name= ''CONVERT(VARCHAR(20),cast(''+name+'' as datetime),120) '' WHERE type=''datetime''   ").append(LineBreak);
        sb.append("          select  stuff((SELECT '',''+ convert(varchar(5000),name)    FROM #temp2  for xml path('''')),1,1,'''') ").append(LineBreak);
        sb.append(" '").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }


    /**
     * 获取远程表的字段
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param tablename     表名称
     * @return
     */

    public static String getTableColumsOfOrcale(String transfername,String dbname,String tablename){
        StringBuilder sb = new StringBuilder();
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql=' ").append(LineBreak);
        sb.append("       IF EXISTS(select * from tempdb..sysobjects where id=object_id(''tempdb..#proctable'')) BEGIN DROP TABLE #proctable  END").append(LineBreak);
        sb.append("       select * into #proctable  from "+transfername+".."+dbname+"."+tablename+" where 1=2").append(LineBreak);
        sb.append("         select  stuff((SELECT '',''+ convert(varchar(5000),name)    FROM tempdb.dbo.SYSCOLUMNS WHERE ID=OBJECT_ID(''tempdb.dbo.#proctable'' ) for xml path('''')),1,1,'''')").append(LineBreak);
        sb.append(" '").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }


    /**
     * 动态创建存储过程,该存储过程的（不带参数类型的）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param procname      存储过程名称
     * @param tablename     表名称
     * @return
     */
    public static String  getProc(String transfername,String dbname,String procname,String tablename,String columns,String selectColumns){
        StringBuilder sb = new StringBuilder();

        //判断临时表是否存在 ,存在删除
        sb.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].["+procname+"]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].["+procname+"] end ").append(LineBreak);
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql='CREATE  PROC "+procname).append(LineBreak);
        sb.append("             AS").append(LineBreak);
        sb.append("          BEGIN").append(LineBreak);
        sb.append ( "begin tran mytran --开启事物" ).append ( LineBreak );
        sb.append ( "begin try" ).append ( LineBreak );
        sb.append("             truncate table "+tablename).append ( LineBreak );
        sb.append("              insert into "+tablename+"("+columns+")").append ( LineBreak );
        sb.append("             select "+selectColumns+"  from "+transfername+"."+dbname+".dbo."+tablename).append(LineBreak);
        sb.append ( "commit tran  --提交事物" ).append ( LineBreak );
        sb.append ( "end try" ).append ( LineBreak );
        sb.append ( "begin catch " ).append ( LineBreak );
        sb.append ( " rollback tran  --事物回滚" ).append ( LineBreak );
        sb.append ( "end catch" ).append ( LineBreak );
        sb.append("           end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }



    /**
     * 动态创建存储过程,该存储过程的（不带参数类型的）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param procname      存储过程名称
     * @param tablename     表名称
     * @return
     */
    public static String  getProcOfDB2(String transfername,String dbname,String procname,String tablename,String columns,String selectColumns){
        StringBuilder sb = new StringBuilder();

        //判断临时表是否存在 ,存在删除
        sb.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].["+procname+"]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].["+procname+"] end ").append(LineBreak);
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql='CREATE  PROC "+procname).append(LineBreak);
        sb.append("             AS").append(LineBreak);
        sb.append("          BEGIN").append(LineBreak);
        sb.append ( "begin tran mytran --开启事物" ).append ( LineBreak );
        sb.append ( "begin try" ).append ( LineBreak );
        sb.append("             truncate table "+tablename).append ( LineBreak );
        sb.append("              insert into "+tablename+"("+columns+")").append ( LineBreak );
        sb.append("             select "+selectColumns+"  from "+transfername+"."+dbname+"."+tablename).append(LineBreak);
        sb.append ( "commit tran  --提交事物" ).append ( LineBreak );
        sb.append ( "end try" ).append ( LineBreak );
        sb.append ( "begin catch " ).append ( LineBreak );
        sb.append ( " rollback tran  --事物回滚" ).append ( LineBreak );
        sb.append ( "end catch" ).append ( LineBreak );
        sb.append("           end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }



    /**
     * 动态创建存储过程,该存储过程的（不带参数类型的）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param procname      存储过程名称
     * @param tablename     表名称
     * @param selectColumns  select 的字段（里面存在数据转换）
     * @return
     */
    public static String  getProcOfOracle(String transfername,String dbname,String procname,String tablename,String columns,String selectColumns){
        StringBuilder sb = new StringBuilder();

        //判断临时表是否存在 ,存在删除
        sb.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].["+procname+"]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].["+procname+"] end ").append(LineBreak);
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql='CREATE  PROC "+procname).append(LineBreak);
        sb.append("             AS").append(LineBreak);
        sb.append("          BEGIN").append(LineBreak);
        sb.append ( "begin tran mytran --开启事物" ).append ( LineBreak );
        sb.append ( "begin try" ).append ( LineBreak );
        sb.append("             truncate table "+tablename).append ( LineBreak );
        sb.append("              insert into "+tablename+"("+columns+")").append ( LineBreak );
        sb.append("             select "+selectColumns+"  from "+transfername+".."+dbname+"."+tablename).append(LineBreak);
        sb.append ( "commit tran  --提交事物" ).append ( LineBreak );
        sb.append ( "end try" ).append ( LineBreak );
        sb.append ( "begin catch " ).append ( LineBreak );
        sb.append ( " rollback tran  --事物回滚" ).append ( LineBreak );
        sb.append ( "end catch" ).append ( LineBreak );
        sb.append("           end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }


    /**
     * 动态创建存储过程,该存储过程的（带参数类型的,时间范围）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param procname      存储过程名称
     * @param tablename     表名称
     * @return
     */

    public static String getProcParam(String transfername,String dbname,String procname,String tablename,String  columnname,Integer timeLength,String columns,String selectColumns){
        StringBuilder sb = new StringBuilder();
        //判断临时表是否存在 ,存在删除
        sb.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].["+procname+"]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].["+procname+"] end ").append(LineBreak);
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql='CREATE  PROC "+procname).append(LineBreak);
        sb.append("                 @startTime varchar("+timeLength+"),@endTime varchar("+timeLength+")").append(LineBreak);
        sb.append("             AS").append(LineBreak);
        sb.append("          BEGIN").append(LineBreak);
        sb.append ( "begin tran mytran --开启事物" ).append (LineBreak );
        sb.append ( "begin try" ).append ( LineBreak );
        sb.append("              delete from "+tablename+" where convert(varchar(19),cast("+columnname+" as datetime),120)  between @startTime and @endTime ").append ( LineBreak );
        sb.append("              insert into "+tablename+"("+columns+") ").append ( LineBreak );
        sb.append("             select "+selectColumns+" from "+transfername+"."+dbname+".dbo."+tablename+" where "+columnname+" between @startTime and @endTime ").append(LineBreak);
        sb.append ( "commit tran  --提交事物" ).append ( LineBreak );
        sb.append ( "end try" ).append ( LineBreak );
        sb.append ( "begin catch " ).append ( LineBreak );
        sb.append ( " rollback tran  --事物回滚" ).append ( LineBreak );
        sb.append ( "end catch" ).append ( LineBreak );
        sb.append("           end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }


    /**
     * 动态创建存储过程,该存储过程的（带参数类型的,时间范围）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param procname      存储过程名称
     * @param tablename     表名称
     * @return
     */

    public static String getProcParamOfDB2(String transfername,String dbname,String procname,String tablename,String  columnname,Integer timeLength,String columns,String selectColumns){
        StringBuilder sb = new StringBuilder();
        //判断临时表是否存在 ,存在删除
        sb.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].["+procname+"]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].["+procname+"] end ").append(LineBreak);
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql='CREATE  PROC "+procname).append(LineBreak);
        sb.append("                 @startTime varchar("+timeLength+"),@endTime varchar("+timeLength+")").append(LineBreak);
        sb.append("             AS").append(LineBreak);
        sb.append("          BEGIN").append(LineBreak);
        sb.append ( "begin tran mytran --开启事物" ).append (LineBreak );
        sb.append ( "begin try" ).append ( LineBreak );
        sb.append("              delete from "+tablename+" where  convert(varchar(19),cast("+columnname+" as datetime),120)  between @startTime and @endTime ").append ( LineBreak );
        sb.append("              insert into "+tablename+"("+columns+") ").append ( LineBreak );
        sb.append("             select "+selectColumns+" from "+transfername+"."+dbname+"."+tablename+" where "+columnname+" between @startTime and @endTime ").append(LineBreak);
        sb.append ( "commit tran  --提交事物" ).append ( LineBreak );
        sb.append ( "end try" ).append ( LineBreak );
        sb.append ( "begin catch " ).append ( LineBreak );
        sb.append ( " rollback tran  --事物回滚" ).append ( LineBreak );
        sb.append ( "end catch" ).append ( LineBreak );
        sb.append("           end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }

    /**
     * 动态创建存储过程,该存储过程的（带参数类型的,时间范围）
     * 作用：用来同步直连库对象的表字段
     * @param transfername  连接名
     * @param dbname        数控库名
     * @param procname      存储过程名称
     * @param tablename     表名称
     * @return
     */

    public static String getProcParamOfCracle(String transfername,String dbname,String procname,String tablename,String  columnname,Integer timeLength,String columns,String selectColumns){
        StringBuilder sb = new StringBuilder();
        //判断临时表是否存在 ,存在删除
        sb.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].["+procname+"]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].["+procname+"] end ").append(LineBreak);
        sb.append("          DECLARE @sql VARCHAR(8000)").append(LineBreak);
        sb.append("set @sql='CREATE  PROC "+procname).append(LineBreak);
        sb.append("                 @startTime varchar("+timeLength+"),@endTime varchar("+timeLength+")").append(LineBreak);
        sb.append("             AS").append(LineBreak);
        sb.append("          BEGIN").append(LineBreak);
        sb.append ( "begin tran mytran --开启事物" ).append (LineBreak );
        sb.append ( "begin try" ).append ( LineBreak );
        sb.append("              delete from "+tablename+" where  convert(varchar(19),cast("+columnname+" as datetime),120)  between @startTime and @endTime ").append ( LineBreak );
        sb.append("              insert into "+tablename+"("+columns+") ").append ( LineBreak );
        sb.append("             select "+selectColumns+" from "+transfername+".."+dbname+"."+tablename+" where "+columnname+" between @startTime and @endTime ").append(LineBreak);
        sb.append ( "commit tran  --提交事物" ).append ( LineBreak );
        sb.append ( "end try" ).append ( LineBreak );
        sb.append ( "begin catch " ).append ( LineBreak );
        sb.append ( " rollback tran  --事物回滚" ).append ( LineBreak );
        sb.append ( "end catch" ).append ( LineBreak );
        sb.append("           end'").append(LineBreak);
        sb.append("EXEC (@sql)     ").append(LineBreak);
        return sb.toString();
    }












}
