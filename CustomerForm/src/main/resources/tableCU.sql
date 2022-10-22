

declare @cfversion varchar(10)='1.0版本'
  
/*
  检查表存在
*/
 if not Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'sys_cf_classify') and xtype='U')
begin
    CREATE TABLE [dbo].[sys_cf_classify](
        [id] [varchar](50) NOT NULL,
        [name] [varchar](50) NOT NULL,
        [order_number] [int] NOT NULL,
        [remarks] [varchar](500) NULL,
     CONSTRAINT [PK_sys_cf_classify] PRIMARY KEY CLUSTERED
    (
        [id] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
    ) ON [PRIMARY]
   EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value= @cfversion , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_cf_classify'
end


 if not Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'sys_cf_facttable') and xtype='U')
begin
    CREATE TABLE [dbo].[sys_cf_facttable](
        [id] [varchar](50) NOT NULL,
        [name] [varchar](50) NOT NULL,
        [label] [varchar](50) NOT NULL,
        [is_reviewed] [int] NOT NULL,
        [is_childtable] [int] NOT NULL,
        [onable_role] [int] NOT NULL,
        [classify_id] [varchar](50) NOT NULL,
        [maintable_id] [varchar](50) NULL,
        [maintable_name] [varchar](50) NULL,
        [order_number] [int]  NOT NULL,

     CONSTRAINT [PK_sys_cf_facttable] PRIMARY KEY CLUSTERED
    (
        [id] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
    ) ON [PRIMARY]

    EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value= @cfversion , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_cf_facttable'
end


 if not Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'sys_cf_fieldtable') and xtype='U')
begin
    CREATE TABLE [dbo].[sys_cf_fieldtable](
        [id] [varchar](50) NOT NULL,
        [name] [varchar](50) NOT NULL,
        [table_name] [varchar](50) NOT NULL,
        [label] [varchar](50) NOT NULL,
        [type] [int] NOT NULL,
        [is_mainfield] [int] NOT NULL,
        [is_system] [int] NOT NULL,
        [facttable_id] [varchar](50) NOT NULL,
        [order_number] [int]   NOT NULL,
        [is_null] [int] NULL,
        [is_edit] [int] NULL,
        [verifiable] [varchar](500) NULL,
        [data_code] [varchar](150) NULL,
        [file_size] [int] NULL,
        [num_length] [int] NULL,
        [field_length] [int] NULL,
        [file_path] [varchar](250) NULL,
        [image_path] [varchar](250) NULL,
        [dictortsql] [int]  NULL,
        [codename_allshow] [int]  NULL,
        [field_sql] [varchar](500) NULL,
        [associated_table_id] [varchar](5000) NULL,
        [associated_table_name] [varchar](5000) NULL,
        [associated_tablename_zh] [varchar](5000) NULL,
        [assignment_formula] [varchar](MAX) NULL,
     CONSTRAINT [PK_sys_cf_fieldtable] PRIMARY KEY CLUSTERED
    (
        [id] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
    ) ON [PRIMARY]
    EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value= @cfversion , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_cf_fieldtable'

end



 if not Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'sys_cf_headercolumn') and xtype='U')
begin
    CREATE TABLE [dbo].[sys_cf_headercolumn](
        [id] [varchar](50) NOT NULL,
        [facttable_id] [varchar](50) NOT NULL,
        [prop] [varchar](50) NOT NULL,
        [label] [varchar](50) NOT NULL,
        [width] [varchar](50)  NULL,
        [align] [varchar](50)  NULL,
        [type] [varchar](50)  NULL,
        [type_content] [varchar](500)  NULL,
        [order_number] [int]  NULL,
        [default_show] [int]  NULL,
        [is_system] [int]  NULL,
        [default_query] [int]  NULL,
     CONSTRAINT [PK_sys_cf_headercolumn] PRIMARY KEY CLUSTERED
    (
        [id] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
    ) ON [PRIMARY]
    EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value= @cfversion , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_cf_headercolumn'

end



 if not Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'sys_cf_processstep') and xtype='U')
begin
    CREATE TABLE [dbo].[sys_cf_processstep](
        [id] [varchar](50) NOT NULL,
        [form_id] [varchar](50) NOT NULL,
        [process_code] [varchar](50)  NULL,
        [process_explain] [varchar](500)  NULL,
        [step_number] [INT]  NULL,
        [step_explain] [varchar](500)  NULL,
        [branch_explain] [varchar](500)  NULL,
        [toexamine_users] [varchar](500)  NULL,
        [toexamine_names] [varchar](500)  NULL,
        [stateon]  [int]  NULL,
     CONSTRAINT [PK_sys_cf_processstep] PRIMARY KEY CLUSTERED
    (
        [id] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
    ) ON [PRIMARY]
    EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value= @cfversion , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_cf_processstep'

end


 if not Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'sys_cf_history_toexamine') and xtype='U')
begin
    CREATE TABLE [dbo].[sys_cf_history_toexamine](
        [id] [varchar](50) NOT NULL,
        [form_id] [varchar](50) NOT NULL,
        [formdata_id] [varchar](50)  NULL,
        [toexamine_process] [varchar](50)  NULL,
        [toexamine_step] [INT]  NULL,
        [toexamine_branch] [varchar](50)  NULL,
        [toexamine_usercode] [varchar](50)  NULL,
        [toexamine_username] [varchar](50)  NULL,
        [toexamine_time] [varchar](50)  NULL,
        [toexamine_info] [varchar](50)  NULL,
        [ispass] [INT]  NULL,
     CONSTRAINT [PK_sys_cf_history_toexamine] PRIMARY KEY CLUSTERED
    (
        [id] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
    ) ON [PRIMARY]
    EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value= @cfversion , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_cf_history_toexamine'

end

/*  更新表结构 如果以后有字段增加 这里处理添加的字段   检查版本是否统一,不统一就开始更新字段

if  not Exists(SELECT  ds.value
               FROM sys.extended_properties ds
               LEFT JOIN  sysobjects tbs  ON  ds.major_id=tbs.id
               WHERE ds.minor_id=0 and tbs.name='sys_cf_facttable'  and    ds.value=@cfversion   )
begin

   IF NOT EXISTS ( SELECT TOP 1 1  FROM    INFORMATION_SCHEMA.COLUMNS
                   WHERE   [TABLE_NAME] = 'sys_cf_facttable' AND [COLUMN_NAME] = '添加的字段' )
    BEGIN
         ALTER TABLE sys_cf_facttable ADD 添加的字段 int IDENTITY(1,1) NOT NULL

    END

end

if  not Exists(SELECT  ds.value
               FROM sys.extended_properties ds
               LEFT JOIN  sysobjects tbs  ON  ds.major_id=tbs.id
               WHERE ds.minor_id=0 and tbs.name='sys_cf_fieldtable'  and    ds.value=@cfversion   )
begin

   IF NOT EXISTS ( SELECT TOP 1 1  FROM    INFORMATION_SCHEMA.COLUMNS
                   WHERE   [TABLE_NAME] = 'sys_cf_fieldtable' AND [COLUMN_NAME] = '添加的字段' )
    BEGIN
         ALTER TABLE sys_cf_fieldtable ADD 添加的字段 int IDENTITY(1,1) NOT NULL
        
    END 
 
   
end


  */
         
 