    truncate table sys_dict_val

  truncate table sys_dict_table


 /* 医保结算等级 1 */
 insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_1','医保结算等级','医保结算等级')
  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(1,'YBQD_1','1' ,'一级',1 ,'定点医疗机构医疗服务项目收费等级')
    insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(1,'YBQD_1','2' ,'二级',1 ,'定点医疗机构医疗服务项目收费等级')
    insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(1,'YBQD_1','3' ,'三级',1 ,'定点医疗机构医疗服务项目收费等级')

   /* 性别 2 */
 insert into sys_dict_table(name,name_zh,source_content)
  values ('YBQD_2','性别','按照《个人基本信息分类与代码第 1 部分：人的性别代码》（GB/T 2261.1-2003）标准')

  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(2,'YBQD_2','0' ,'未知的性别',1 ,'患者生理性别')
   insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(2,'YBQD_2','1' ,'男',1 ,'患者生理性别')
    insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(2,'YBQD_2','2' ,'女',1 ,'患者生理性别')
    insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(2,'YBQD_2','9' ,'未说明性别',1 ,'患者生理性别')

 /* 国籍 3*/

  insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_3','国籍','按照《世界各国和地区名称代码表》（GB/T 2659-2000）标准填写')
  select SCOPE_IDENTITY ()

 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 select 3, 'YBQD_3',dm ,mc,1 ,''  from ybjsqd..W_WT_GJ

 /* 民族 4 */


   insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_4','民族','按照《世界各国和地区名称代码表》（GB/T 2659-2000）标准')
  select SCOPE_IDENTITY ()


 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 select 4, 'YBQD_4',dm ,mc,1 ,''  from ybjsqd..W_WT_MZ

/* 患者证件类别 5 */
       insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_5','患者证件类别','按照《卫生信息数据元值域代码-第 3 部分人口学及社会 经济学特征：CV 02.01.101 身份证件类别代码》（WS 364.3-2011）标准')
  select SCOPE_IDENTITY ()


 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 select 5, 'YBQD_5',dm ,mc,1 ,''  from ybjsqd..W_WT_HZZJLB

 /* 职业 6 */
     insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_6','职业','按照《个人基本信息分类与代码》（GB/T2261.4-2003）标准')
  select SCOPE_IDENTITY ()


 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)

  select 6, 'YBQD_6',dm ,mc,1 ,''  from ybjsqd..W_WT_ZY


/* 联系人与患者关系 7 */
 insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_7','联系人与患者关系','参照《家庭关系代码》国家标准（GB/T4761-2008） 二位数字代码')
  select SCOPE_IDENTITY ()


 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)

  select 7, 'YBQD_7',dm ,mc,1 ,''  from ybjsqd..W_WT_LXRGX

/*医保类型 8 */
 insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_8','医保类型','医保类型')
  select SCOPE_IDENTITY ()


 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(8,'YBQD_8','1' ,'职工基本医疗保险',1 ,'')
  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(8,'YBQD_8','2' ,'城乡居民基本医疗保险（城镇居民基本 医疗保险、新型农村合作医疗保险）',1 ,'')
 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(8,'YBQD_8','9' ,'其他医疗保险',1 ,'')

/* 特殊人员类型 9*/
 insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_9','特殊人员类型','特殊人员类型')
  select SCOPE_IDENTITY ()


  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)

  select 9, 'YBQD_9',dm ,mc,1 ,''  from ybjsqd..W_WT_TSRYLX


/* 新生儿入院类型 10 */

 insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_10','新生儿入院类型','')
  select SCOPE_IDENTITY ()


 insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(10,'YBQD_10','1' ,'正常新生儿',1 ,'')
  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(10,'YBQD_10','2' ,'早产儿',1 ,'')
  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(10,'YBQD_10','3' ,'有疾病新生儿',1 ,'')
  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(10,'YBQD_10','4' ,'非无菌分娩',1 ,'')
  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
 values(10,'YBQD_10','9' ,'其它',1 ,'')



/* 科室代码 11 */
 insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_11','特殊人员类型','按照《医疗卫生机构业务科室分类与代码》（CT 08.00.002） 标准')
  select SCOPE_IDENTITY ()


  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)

  select 11, 'YBQD_11',cast(dm as varchar(20)) ,mc,1 ,''  from ybjsqd..W_WT_KS


 /* 住院医疗类型 12 */
 insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_12','住院医疗类型','')
  select SCOPE_IDENTITY ()


  insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(12,'YBQD_12','1' ,'住院',1 ,'')
     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(12,'YBQD_12','2' ,'日间手术',1 ,'')

 /*入院途径 13*/
  insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_13','入院途径','')
  select SCOPE_IDENTITY ()

   insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(13,'YBQD_13','1' ,'急诊',1 ,'')
     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(13,'YBQD_13','2' ,'门诊',1 ,'')
       insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(13,'YBQD_13','3' ,'其它医疗机构转入',1 ,'')
       insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(13,'YBQD_13','9' ,'其它',1 ,'')


   /*治疗类别 14  select * from sys_dict_table */
    insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_14','治疗类别','')
  select SCOPE_IDENTITY ()
      insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(14,'YBQD_14','1' ,'西医',1 ,'')
     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(14,'YBQD_14','2' ,'中医',1 ,'')
       insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(14,'YBQD_14','2.1' ,'中医',1 ,'')
       insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(14,'YBQD_14','2.2' ,'民族医',1 ,'')
          insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(14,'YBQD_14','3' ,'中西医',1 ,'')


      /*入院病情 15  select * from sys_dict_table */


       insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_15','入院病情','')
  select SCOPE_IDENTITY ()
         insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(15,'YBQD_15','1' ,'有',1 ,'对应本出院诊断在入院时就已明确。例如,患者因“乳腺癌”入院治疗, 入院前已经钼靶、针吸细胞学检查明确诊断为“乳腺癌”,术后经病理 亦诊断为乳腺癌。')
     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(15,'YBQD_15','2' ,'临床未确定',1 ,'对应本出院诊断在入院时临床未确定,或入院时该诊断为可疑诊断。例 如:患者因“乳腺恶性肿瘤不除外”、“乳腺癌”或“乳腺肿物”入院 治疗,因确少病理结果,肿物性质未确定,出院时有病理诊断明确为乳腺 癌或乳腺纤维瘤。')
       insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(15,'YBQD_15','3' ,'情况不明',1 ,' 对应本出院诊断在入院时情况不明,例如:乙型病毒性肝炎的窗口期、社 区获得性肺炎的潜伏期,因患者入院时处于窗口期或潜伏期,故入院时 未能考虑此诊断或主观上未能明确此诊断。患者合并的慢性疾病,经入 院后检查新发现的应选择“3”(情况不明),例如:高血压、高脂血症、 胆囊结石等,不能选择“4”(无)。')
       insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(15,'YBQD_15','4' ,'无',1 ,'在住院期间新发生的,入院时明确无对应本出院诊断的诊断条目。例如: 患者出现围手术期心肌梗死,住院期间发生的医院感染等。只有在住院 期间新发生的情况,才能选择此项;住院期间新发现的慢性合并疾病,应 选择“3”(情况不明)')


 /* 麻醉方式  16*/
     insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_16','麻醉方式','按照《麻醉方法代码表》（CV 06.00.103）标准')
  select SCOPE_IDENTITY ()

     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)

  select 16, 'YBQD_16',cast(dm as varchar(20)) ,mc,1 ,''  from ybjsqd..W_WT_MZFS


/*  重症监护病房类型 17 */
    insert into sys_dict_table(name,name_zh,source_content)
   values ('YBQD_17','重症监护病房类型',' ')
  select SCOPE_IDENTITY ()

     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)

  select 17, 'YBQD_17',cast(dm as varchar(20)) ,mc,1 ,''  from ybjsqd..W_WT_ZZJHS



/*  输血品种 18 */
    insert into sys_dict_table(name,name_zh,source_content)
   values ('YBQD_18','重症监护病房类型','参照《输血品种代码表》（CV 04.50.021）')
  select SCOPE_IDENTITY ()

     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)

  select 18, 'YBQD_18',cast(dm as varchar(20)) ,mc,1 ,''  from ybjsqd..W_WT_SXPZ

  /*离院方式 19  select * from sys_dict_table */


       insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_19','离院方式','')
  select SCOPE_IDENTITY ()

         insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
  values(19,'YBQD_19','1' ,'医嘱离院',1 ,'患者本次治疗结束后,按照医 嘱要求出院,回到住地进一步 康复等情况。')
     insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(19,'YBQD_19','2' ,'医嘱转院',1 ,'指医疗机构根据诊疗需要， 将患者转往相应医疗机构进 一步诊治，用于统计“双向 转诊”开展情况。如果接收 患者的医疗机构明确，需要 填写转入医疗机构的名称和 对应的医保定点医疗机构代 码。')

        insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(19,'YBQD_19','3' ,'医嘱转社区卫生服务机构/乡镇卫生院',1 ,'指医疗机构根据患者诊疗情 况，将患者转往相应社区卫 生服务机构进一步诊疗、康 复，用于统计“双向转诊” 开展情况。如果接收患者的 社区卫生服务机构明确，需 要填写社区卫生服务机构/ 乡镇卫生院名称和对应的医 保定点医疗机构代码。')

        insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(19,'YBQD_19','4' ,'非医嘱离院',1 ,'患者未按照医嘱要求而自动 离院,如:患者疾病需要住院 治疗,但患者出于个人原因要 求出院,此种出院并非由医务 人员根据患者病情决定,属于 非医嘱离院。')
        insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(19,'YBQD_19','5' ,'死亡',1 ,'患者在住院期间死亡。')
        insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(19,'YBQD_19','9' ,'其他',1 ,'除上述 5 种出院去向之外的 其他情况。')



   /*医保支付方式  20 */
          insert into sys_dict_table(name,name_zh,source_content)
 values ('YBQD_20','医保支付方式','')
  select SCOPE_IDENTITY ()

         insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(20,'YBQD_20','1' ,'按项目付费',1 ,'')
         insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(20,'YBQD_20','2' ,'按单病种付费',1 ,'')
            insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(20,'YBQD_20','3' ,'按病种分值付费',1 ,'')
         insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(20,'YBQD_20','4' ,'按疾病诊断相关分组（DRG）付费',1 ,'')
            insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(20,'YBQD_20','5' ,'按床日付费',1 ,'')
         insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(20,'YBQD_20','6' ,'按人头付费',1 ,'')
               insert into sys_dict_val(dict_id,dict_name,val,name,is_on,remark)
   values(20,'YBQD_20','9' ,'其他',1 ,'')
