package com.sxdl.cf.controller;


import com.sxdl.cf.dao.dao1.SysDictTableDao2;
import com.sxdl.cf.dto.*;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import com.sxdl.cf.entity.SysCustomerFormProcessStepEntity;
import com.sxdl.cf.service.SysCustomerFormFactTableService;
import com.sxdl.cf.service.SysCustomerFormFieldTableService;
import com.sxdl.cf.service.SysCustomerFormHeaderColumnService;
import com.sxdl.cf.service.SysCustomerFormProcessStepService;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.FileUtil;
import com.sxdl.cf.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "表单布局" )
@RestController
@RequestMapping("/dev/formLayout")
@RequiredArgsConstructor
public class SysCustomerFormLayoutController {

    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final SysCustomerFormFieldTableService fieldService;

    private final SysCustomerFormFactTableService tableService;

    private final SysCustomerFormHeaderColumnService columnService;

    private final SysDictTableDao2 dictTableDao2;

    private final SysCustomerFormProcessStepService processStepService;

    @ApiOperation(value = "获取布局数据")
    @GetMapping("/getLayout")
    public ResultUtil getLayout( @RequestParam(value = "table_id") String table_id,
                                 @RequestParam(value = "table_name") String table_name){
        JSONObject jsonObject = new JSONObject();
        try {
            if(FileUtil.allData.containsKey(table_name+"."+table_id)){
                Object o = FileUtil.allData.get(table_name + "." + table_id);
                String str = "{}";
                if(!StringUtils.isEmpty(o)){
                    str = o.toString();
                }
                jsonObject = JSONObject.fromObject(str);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(  jsonObject.toString(),"查询成功" );
    }


    /**
     *  这里修改名称 同步字段表与列表展示表
     * @param tableId
     * @param fieldName
     * @param fieldNameZh
     * @return
     */
    @ApiOperation(value = "重设左侧字段名称")
    @GetMapping("/setFieldName")
    public ResultUtil setFieldName( @RequestParam(value = "tableId") String tableId,
                                    @RequestParam(value = "fieldName") String fieldName,
                                    @RequestParam(value = "fieldNameZh") String fieldNameZh){
        try {
            SysCustomerFormFieldTableEntity sysCustomerFormFieldTableEntity = fieldService.selectOne(new SysCustomerFormFieldTableEntity().setFacttable_id(tableId)
                    .setName(fieldName));

            SysCustomerFormHeaderColumnEntity sysCustomerFormHeaderColumnEntity = columnService.selectOne(new SysCustomerFormHeaderColumnEntity().setFacttable_id(tableId)
                    .setProp(fieldName));
            columnService.setFieldName(sysCustomerFormFieldTableEntity.setLabel(fieldNameZh),sysCustomerFormHeaderColumnEntity.setLabel(fieldNameZh));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success();
    }



    /**
     *  前端返回数据JSON 中加filename--> 由 表name.表id 组成
     * @param objectMap
     * @return
     */
    @ApiOperation(value = "修改保存布局数据")
    @PostMapping("/saveLayout")
    public ResultUtil saveLayout( @RequestBody  Map<String,Object> objectMap ){
        try {
            tableService.saveLayout( objectMap);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(  DataUtil.SUCCESS_MASSAGE);
    }

    @ApiOperation(value = "预览布局")
    @GetMapping("/previewLayout")
    public ResultUtil previewLayout( @RequestParam(value = "table_id") String table_id  ){
        FormQueryResult formQueryResult  = new FormQueryResult();
        try {
            Map<String,Object> objectMap = new LinkedHashMap<>();

            List<SysCustomerFormFieldTableEntity> fieldList = fieldService.getFieldList(table_id, "");
            fieldList.stream().filter(e->!StringUtils.isEmpty(e.getDictortsql())).forEach(e->{
                if(e.getDictortsql()==1){
                    e.setOptionList(dictTableDao2.getDictData(e.getData_code()));
                }
            });
            Map<String, Object> maps = fieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1));


            SysCustomerFormFactTableEntity tableEntity = tableService.selectByKey(table_id);
            if(tableEntity.getIs_childtable()>0){ //是子表 不需要其他 数据
                formQueryResult.setFieldPropsMap(maps);
                return ResultUtil.success(formQueryResult);
            }

            //对其下子表进行查询赋值
            SysCustomerFormFactTableEntity reference = new SysCustomerFormFactTableEntity().setMaintable_id(table_id);
            List<SysCustomerFormFactTableEntity> childsToMany = tableService.select(reference.setIs_childtable(2));
            if(childsToMany.size()>0) { //证明有一对多的子表
                objectMap.putAll(maps);
                childsToMany.forEach(e->{
                    ChildDBO childDBO = new ChildDBO().setTable_id(e.getId()).setName(e.getName())
                            .setLabel(e.getLabel())
                            .setType("many")
                            .setColumnList(columnService.getColumnbyPid(e.getId()).stream().filter(e2 -> (StringUtils.isEmpty(e2.getDefault_show()) ? 0 : e2.getDefault_show()) == 1).collect(Collectors.toList()));

                    List<SysCustomerFormFieldTableEntity> childfieldList = fieldService.getFieldList(e.getId(), "");
                    childfieldList.stream().filter(childf->!StringUtils.isEmpty(childf.getDictortsql()) && childf.getDictortsql()==1).forEach(childe->{
                        childe.setOptionList(dictTableDao2.getDictData(childe.getData_code()));
                    });
                    childDBO.setFieldList(childfieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1)));

                    objectMap.put(childDBO.getName(),childDBO);
                });
                formQueryResult.setFieldPropsMap(objectMap);
            }else{
                formQueryResult.setFieldPropsMap(maps);
            }


        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( formQueryResult );
    }



    @ApiOperation(value = "查询字段列表(点击表单设计时查询左侧字段数据)")
    @GetMapping("/getFieldListOfLayOut")
    public ResultUtil getFieldListOfLayOut(@RequestParam (value = "pid",required =true) String pid,
                                    @RequestParam (value = "val",defaultValue = "") String val){

        List<Object> list = new ArrayList<>();
        try {
            //查询本表单本身的数据
            List<SysCustomerFormFieldTableEntity> data =  fieldService.getFieldList(pid,val);

            list.addAll(data);
            //判断本表是否是子表
            SysCustomerFormFactTableEntity tableEntity = tableService.selectByKey(pid);
            if(tableEntity.getIs_childtable()>0){ //是子表 不需要其他 数据
                return ResultUtil.success(list);
            }

            //对其下子表进行查询赋值
            SysCustomerFormFactTableEntity reference = new SysCustomerFormFactTableEntity().setMaintable_id(pid);
            List<SysCustomerFormFactTableEntity> childsToMany = tableService.select(reference.setIs_childtable(2));
            if(childsToMany.size()>0) { //证明有一对多的子表
                childsToMany.forEach(e->{
                    ChildDBO childDBO = new ChildDBO().setTable_id(e.getId()).setName(e.getName())
                            .setLabel(e.getLabel())
                            .setType("many")
                            .setColumnList(columnService.getColumnbyPid(e.getId()).stream().filter(e2 -> (StringUtils.isEmpty(e2.getDefault_show()) ? 0 : e2.getDefault_show()) == 1).collect(Collectors.toList()));

                    List<SysCustomerFormFieldTableEntity> childfieldList = fieldService.getFieldList(e.getId(), "");
                    childfieldList.stream().filter(childf->!StringUtils.isEmpty(childf.getDictortsql()) && childf.getDictortsql()==1).forEach(childe->{
                        childe.setOptionList(dictTableDao2.getDictData(childe.getData_code()));
                    });
                    childDBO.setFieldList(childfieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1)));
                    list.add(childDBO);
                });
            }



        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }


    //key ***************************************************************************表单 篇***********************************************************************
    /**
     *
     * @param table_id
     * @param table_name
     * @param pageNum
     * @param pageSize
     * @param ks_role    事实表中的onable_role=1  科室权限 数据要求|科室1|科室2| 前后都需要有|
     * @param user_role  事实表中的onable_role=2 人员数据 数据要求 当前登录人
     * @param map
     * @return
     */
    @ApiOperation(value = "1.1 查询列表数据")
    @GetMapping("/initDataList")
    public ResultUtil initDataList( @RequestParam(value = "table_id") String table_id ,
                                    @RequestParam(value = "table_name") String table_name,
                                    @RequestParam(value = "pageNum") Integer pageNum,
                                    @RequestParam(value = "pageSize") Integer pageSize,
                                    @RequestParam(value = "ks_role",required = false) String ks_role,
                                    @RequestParam(value = "user_role",required = false) String user_role,
                                    Map<String,Object> map){



        ListQueryResult result = new ListQueryResult() ;

        List<LinkedHashMap<String, Object>>  dataList = new ArrayList<>();
        try {
            //key  0 获取 列表数据
            List<SysCustomerFormHeaderColumnEntity> columnList = columnService.getColumnbyPid(table_id);

            List<SysCustomerFormHeaderColumnEntity> collect = columnList.stream()
                    .filter(e -> (StringUtils.isEmpty(e.getDefault_show()) ? 0 : e.getDefault_show()) == 1)
                    .collect(Collectors.toList());

            // 判断当前表单是否有开启的流程 如果有就需要在里面加上一条显示列表数据   toexamine_result 需要根据 SysCustomerFormProcessStepEntity里面有没有开启的流程数据
            if( processStepService.select(new SysCustomerFormProcessStepEntity().setForm_id(table_id).setStateon(1)).size()>0){
                collect.add(new SysCustomerFormHeaderColumnEntity().setLabel("审核状态").setWidth("120").setProp("toexamine_result").setAlign("center").setFormatter("formatterProcess"));
            }
            result.setColumnList(collect);

            //key 0  获取查询条件  ,由order_number 决定先后顺序

            List<SysCustomerFormHeaderColumnEntity>  conditionList =  columnService.getTargetList(table_id, "")
                    .stream()
                    .map(f-> {
                        if(!StringUtils.isEmpty(f.getType()) &&  ("option".equals(f.getType())||"options".equals(f.getType())||"checkbox".equals(f.getType()) ||"radio".equals(f.getType()))){
                            return  f.setOptionList(dictTableDao2.getDictData(f.getType_content()));
                        }else {
                            return f;
                        }
                    }).filter(e-> (StringUtils.isEmpty(e.getDefault_query()) ? 0 : e.getDefault_query()) == 1)
                    .collect(Collectors.toList());
            result.setConditionList(conditionList);

            //key 1   拼接查询数据  同时 查询条件中的数据
            List<QueryDBO> queryDBOS = new ArrayList<>();
            Integer onable_role = tableService.selectByKey(table_id).getOnable_role();
            String sql = columnService.getListQueryText(table_id,map,table_name,ks_role,user_role,queryDBOS,onable_role);
            List<LinkedHashMap<String, Object>> sqlData = columnService.getLinkedMap(sql);

            //处理多选框中的数据筛选  type类型是-->option,sql,radio,options,sqls,checkbox
            dataList = columnService.getQueryCore(queryDBOS, sqlData);
            //开始分页
            List<LinkedHashMap<String, Object>> resultCollect =  dataList.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            if(resultCollect.size()==0 && pageNum >=2 ){
                resultCollect = dataList.stream().skip((pageNum - 2) * pageSize).limit(pageSize).collect(Collectors.toList());
                pageNum = pageNum-1;
            }
            //汉化数据
            resultCollect = columnService.setCodeZH(table_id,resultCollect);
            result.setDataList(resultCollect);

            //key  3 分页数据赋值
            result.setPagination(new PaginationCF(pageSize,pageNum,dataList.size()));

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }

        return  ResultUtil.success( result );

    }


    @ApiOperation(value = "1.2 新增表单数据")
    @GetMapping("/formCreateQuery")
    public ResultUtil formCreateQuery( @RequestParam(value = "table_id") String table_id ,
                                       @RequestParam(value = "table_name") String table_name ){
        FormQueryResult formQueryResult  = new FormQueryResult();

        Map<String,Object> childList = new HashMap<>();
        try {
            String jsonstr ="{}";
            //1 查询布局数据
            if(FileUtil.allData.containsKey(table_name+"."+table_id)){
                 jsonstr = JSONObject.fromObject(FileUtil.allData.get(table_name + "." + table_id)).toString();
            }
            formQueryResult.setLayoutJson(jsonstr);

            //2 查询字段属性数据,同时将字典数据查询出来放到字段中
            List<SysCustomerFormFieldTableEntity> fieldList = fieldService.getFieldList(table_id, "");
            fieldList.stream().filter(e->!StringUtils.isEmpty(e.getDictortsql())).forEach(e->{
                if(e.getDictortsql()==1){
                    e.setOptionList(dictTableDao2.getDictData(e.getData_code()));
                }
            });

            Map<String,Object> objectMap = new LinkedHashMap<>();
            Map<String, Object> maps = fieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1));
            SysCustomerFormFactTableEntity tableEntity = tableService.selectByKey(table_id);

            //key  开始判断是否有子表单
            if(tableEntity.getIs_childtable()>0){ //是子表 不需要其他 数据
                formQueryResult.setFieldPropsMap(maps);
            }else{
                SysCustomerFormFactTableEntity reference = new SysCustomerFormFactTableEntity().setMaintable_id(table_id);
                List<SysCustomerFormFactTableEntity> childsToMany = tableService.select(reference.setIs_childtable(2));
                if(childsToMany.size()>0) { //证明有一对多的子表
                    objectMap.putAll(maps);
                    childsToMany.forEach(e->{
                        ChildDBO childDBO = new ChildDBO().setTable_id(e.getId()).setName(e.getName())
                                .setLabel(e.getLabel())
                                .setType("many")
                                .setColumnList(columnService.getColumnbyPid(e.getId()).stream().filter(e2 -> (StringUtils.isEmpty(e2.getDefault_show()) ? 0 : e2.getDefault_show()) == 1).collect(Collectors.toList()));

                        List<SysCustomerFormFieldTableEntity> childfieldList = fieldService.getFieldList(e.getId(), "");
                        childfieldList.stream().filter(childf->!StringUtils.isEmpty(childf.getDictortsql()) && childf.getDictortsql()==1).forEach(childe->{
                                childe.setOptionList(dictTableDao2.getDictData(childe.getData_code()));
                        });
                        childDBO.setFieldList(childfieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1)));


                        objectMap.put(childDBO.getName(),childDBO);

                        // key 加载子表FormData 数据 由于此处新增 所以给[] 数组
                        childList.put(e.getName(),new ArrayList<>());

                    });
                    formQueryResult.setFieldPropsMap(objectMap);
                }else{
                    formQueryResult.setFieldPropsMap(maps);
                }
            }

            //  3 初始化数据库表回显数据 如果有子表 map中添加一个 children 属性
            Map<String,Object> formData = new LinkedHashMap<>();
            fieldList.forEach(e->{
                formData.put(e.getName(),null);

            });

            if(childList.size()>0){
                formData.putAll(childList);
            }

            //子表单


            formQueryResult.setFormData(formData);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( formQueryResult );
    }


    @ApiOperation(value = "1.3 修改表单回显数据")
    @GetMapping("/formUpdateQuery")
    public ResultUtil formUpdateQuery( @RequestParam(value = "table_id") String table_id ,
                                       @RequestParam(value = "data_id") String data_id ,
                                       @RequestParam(value = "table_name") String table_name,
                                       @RequestParam(value = "isprint",required = false) String isprint){
        FormQueryResult formQueryResult  = new FormQueryResult();
        try {
            String jsonstr ="{}";
            //1 查询布局数据
            if(FileUtil.allData.containsKey(table_name+"."+table_id)){
                jsonstr = JSONObject.fromObject(FileUtil.allData.get(table_name + "." + table_id)).toString();
            }
            formQueryResult.setLayoutJson(jsonstr);
            List<SysCustomerFormFieldTableEntity> fieldList = fieldService.getFieldList(table_id, "");

            //存放数据库表数据,主表数据,一对多子表数据
            LinkedHashMap<String, Object> formData = dictTableDao2.getDataFormById(table_name, data_id);

            //有值表示为打印,需要汉化 下拉框中的数据
            if(!StringUtils.isEmpty(isprint))
                columnService.setCodeZHPrint(table_id,formData);

            //填充空数据字段
            fieldList.forEach(e->{
                if (!formData.containsKey(e.getName())){
                    formData.put(e.getName(),null);
                }
            });


            //2 查询字段属性数据 加载字段数据  sql下拉框数据在 打开页面的时候前端后查询 避免数据过大带来的加载压力
            fieldList.stream().filter(e->!StringUtils.isEmpty(e.getDictortsql())).forEach(e->{
                if(e.getDictortsql()==1){
                    e.setOptionList(dictTableDao2.getDictData(e.getData_code()));
                }else{
                    SqlQueryDBO queryDBO = new SqlQueryDBO();
                    queryDBO.setSql(e.getField_sql());
                    if(!StringUtils.isEmpty(formData.get(e.getName()))){
                        queryDBO.setCode(formData.get(e.getName()).toString());
                    }
                    e.setOptionList( fieldService.getDataBysql(queryDBO));
                }
            });

            //开始处理子表数据 ,存放 字段数据---> fieldPropsMap 中
            Map<String,Object> objectMap = new LinkedHashMap<>();
            Map<String, Object> maps = fieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1));
            SysCustomerFormFactTableEntity tableEntity = tableService.selectByKey(table_id);


            //key 是子表 不需要其他 数据
            if(tableEntity.getIs_childtable()>0){
                formQueryResult.setFieldPropsMap(maps);
            }else{
                // key  处理一对多子表数据
                SysCustomerFormFactTableEntity reference = new SysCustomerFormFactTableEntity().setMaintable_id(table_id);
                List<SysCustomerFormFactTableEntity> childsToMany = tableService.select(reference.setIs_childtable(2));
                if(childsToMany.size()>0) { //证明有一对多的子表
                    objectMap.putAll(maps);



                    childsToMany.forEach(e->{
                        ChildDBO childDBO = new ChildDBO().setTable_id(e.getId()).setName(e.getName())
                                .setLabel(e.getLabel())
                                .setType("many")
                                .setColumnList(columnService.getColumnbyPid(e.getId()).stream().filter(e2 -> (StringUtils.isEmpty(e2.getDefault_show()) ? 0 : e2.getDefault_show()) == 1).collect(Collectors.toList()));

                        List<SysCustomerFormFieldTableEntity> childfieldList = fieldService.getFieldList(e.getId(), "");
                        childfieldList.stream().filter(childf->!StringUtils.isEmpty(childf.getDictortsql())  ).forEach(childe->{
                            if(childe.getDictortsql()==1){
                                childe.setOptionList(dictTableDao2.getDictData(childe.getData_code()));
                            }else{
                                //表名
                                String table = e.getName();
                                //表单 sql 字段名
                                String column = childe.getName();
                                //用户选择的代码
                                String sqlCodes = fieldService.selectString(" select stuff((select distinct ','+ convert(varchar(50),[" + column + "])  from " + table + " where ISNULL([" + column + "],'')!=''   for xml path('')),1,1,'')");
                                SqlQueryDBO queryDBO = new SqlQueryDBO();
                                queryDBO.setSql(childe.getField_sql());
                                if(!StringUtils.isEmpty(sqlCodes)){
                                    queryDBO.setCode(sqlCodes );
                                }
                                childe.setOptionList( fieldService.getDataBysql(queryDBO));
                            }
                        });
                        childDBO.setFieldList(childfieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1)));

                        objectMap.put(childDBO.getName(),childDBO);

                        //  加载子表FormData 数据 字段数据
                        List<SysCustomerFormFieldTableEntity> childFields = fieldService.getFieldList(e.getId(), "");

                        //数据库数据
                        List<LinkedHashMap<String, Object>> childFormData = dictTableDao2.getDataFormByPid(e.getName(), data_id);


                        //打印时汉化数据
                        if(!StringUtils.isEmpty(isprint)){
                            childFormData.forEach(formDatachild->{
                                columnService.setCodeZHPrint(e.getId(),formDatachild);
                            });
                        }
                        //进行字段补充 查询出来为null的字段会没有
                        childFormData.forEach(data->{
                            childFields.forEach(field->{
                               if( !data.containsKey(field.getName() )){
                                   data.put(field.getName(),null);
                               }
                            });
                        });
                        formData.put(e.getName(),childFormData);

                    });
                    formQueryResult.setFieldPropsMap(objectMap);
                }else{
                    formQueryResult.setFieldPropsMap(maps);
                }


                // key 处理一对一子表
                List<SysCustomerFormFactTableEntity> childsToOne = tableService.select(reference.setIs_childtable(1));
                List<Map<String,String>> oneToOneChilds = new ArrayList<>();

                childsToOne.forEach(e->{
                    //数据库数据
                    List<LinkedHashMap<String, Object>> childFormoneData = dictTableDao2.getDataFormByPid(e.getName(), data_id);
                    if(childFormoneData.size()>0){
                        //data_id  table_id  table_name table_name_zh
                        Map<String,String> m = new HashMap<>();
                        m.put("data_id",data_id);
                        m.put("table_id",e.getId());
                        m.put("table_name",e.getName());
                        m.put("table_name_zh",e.getLabel());
                        oneToOneChilds.add(m);
                    }
                });
                formQueryResult.setOneToOneChilds(oneToOneChilds);
            }

            formQueryResult.setFormData(formData);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( formQueryResult );
    }

    @ApiOperation(value = "1.3.1 子表单请求查询")
    @GetMapping("/formchildQuery")
    public ResultUtil formchildQuery( @RequestParam(value = "table_id") String table_id ,
                                       @RequestParam(value = "data_id",required = false) String data_id ,
                                       @RequestParam(value = "table_name") String table_name,
                                       @RequestParam(value = "isprint",required = false) String isprint){
        FormQueryResult formQueryResult  = new FormQueryResult();
        try {


            //1 查询布局数据
            String jsonstr ="{}";
            if(FileUtil.allData.containsKey(table_name+"."+table_id)){
                jsonstr = JSONObject.fromObject(FileUtil.allData.get(table_name + "." + table_id)).toString();
            }
            formQueryResult.setLayoutJson(jsonstr);

            //2 查询字段属性数据,同时将字典数据查询出来放到字段中
            List<SysCustomerFormFieldTableEntity> fieldList = fieldService.getFieldList(table_id, "");
            fieldList.stream().filter(e->!StringUtils.isEmpty(e.getDictortsql())).forEach(e->{
                if(e.getDictortsql()==1){
                    e.setOptionList(dictTableDao2.getDictData(e.getData_code()));
                }
            });
            Map<String, Object> maps = fieldList.stream().collect(Collectors.toMap(SysCustomerFormFieldTableEntity::getName, v -> v, (k1, k2) -> k1));
            formQueryResult.setFieldPropsMap(maps);

            //  3 初始化数据库表回显数据
            if(StringUtils.isEmpty(data_id)){
                Map<String,Object> formData = new LinkedHashMap<>();
                fieldList.forEach(e->{
                    formData.put(e.getName(),null);
                });
                formQueryResult.setFormData(formData);
            }else{
                LinkedHashMap<String, Object> formData = dictTableDao2.getDataFormByPidOfOneToOne(table_name, data_id);
                if(formData==null || formData.size()<=0){
                    formData = new LinkedHashMap<>();
                    LinkedHashMap<String, Object> finalFormData = formData;
                    fieldList.forEach(e->{
                        finalFormData.put(e.getName(),null);
                    });
                    formQueryResult.setFormData(formData);
                }else{
                    //有值表示为打印,需要汉化 下拉框中的数据
                    if(!StringUtils.isEmpty(isprint))
                        columnService.setCodeZHPrint(table_id,formData);
                    formQueryResult.setFormData(formData);
                }
            }

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( formQueryResult );
    }



    /**
     *
     *  主表: owner_department-->owner_department
     *  主表: owner_user->owner_user
     *  主表从表都有: created_user/modified_user-->user_role
     *
     *    一对一子表单 ,保存时候,父表中没有代子表单,就代表删除数据
     * @param table_id
     * @param table_name
     * @param operation_type   1 新增 2修改
     * @param data_id
     * @param formDataDBO
     * @return
     */
    @ApiOperation(value = "1.4 保存表单数据")
    @PostMapping("/saveRecord")
    public ResultUtil saveRecord( @RequestParam(value = "table_id") String table_id ,
                                  @RequestParam(value = "table_name") String table_name,
                                  @RequestParam(value = "operation_type") Integer operation_type,
                                  @RequestParam(value = "data_id",defaultValue = "",required = false) String data_id,
                                  @RequestBody FormDataDBO formDataDBO){
        try {
            columnService.saveRecord(table_id,table_name,data_id,operation_type,formDataDBO);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( DataUtil.SUCCESS_MASSAGE );
    }


    /**
     *
     * @param pageNum
     * @param pageSize
     * @param table_id
     * @param table_name
     * @param ks_role    事实表中的onable_role=1  科室权限 数据要求|科室1|科室2| 前后都需要有|
     * @param user_role  事实表中的onable_role=2 人员数据 当前登录人
     * @param map
     * @return
     */
    @ApiOperation(value = "1.5 点击查询表单列表数据")
    @PostMapping("/listQuery")
    public ResultUtil listQuery(  @RequestParam(value = "pageNum") Integer pageNum,
                                  @RequestParam(value = "pageSize") Integer pageSize,
                                  @RequestParam(value = "table_id") String table_id ,
                                  @RequestParam(value = "table_name") String table_name,
                                  @RequestParam(value = "ks_role",required = false) String ks_role,
                                  @RequestParam(value = "user_role",required = false) String user_role,
                                  @RequestBody  Map<String,Object> map){

        ListQueryResult result = new ListQueryResult() ;
        List<LinkedHashMap<String, Object>>  dataList = new ArrayList<>();
        try {
            List<QueryDBO> queryDBOS = new ArrayList<>();
            Integer onable_role = tableService.selectByKey(table_id).getOnable_role();
            String sql = columnService.getListQueryText(table_id,map,table_name,ks_role,user_role,queryDBOS,onable_role);

            List<LinkedHashMap<String, Object>> sqlData = columnService.getLinkedMap(sql);


            //处理多选框中的数据筛选  type类型是-->option,sql,radio,options,sqls,checkbox
            dataList = columnService.getQueryCore(queryDBOS, sqlData);
            //开始分页
            List<LinkedHashMap<String, Object>> resultCollect =  dataList.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            if(resultCollect.size()==0 && pageNum >=2 ){
                resultCollect = dataList.stream().skip((pageNum - 2) * pageSize).limit(pageSize).collect(Collectors.toList());
                pageNum = pageNum-1;
            }
            //汉化数据
            resultCollect = columnService.setCodeZH(table_id,resultCollect);
            result.setDataList(resultCollect);

            //key  3 分页数据赋值
            result.setPagination(new PaginationCF(pageSize,pageNum,dataList.size()));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( result );

    }


    /**
     *  1 只允许填写人删除本数据
     *  2 删除数据时候需要删除流程数据
     *  3 删除数据时候需要判断有没有子表有子表需要删除子表数据
     * @param table_id
     * @param data_id
     * @param table_name
     * @return
     */
    @ApiOperation(value = "1.6 删除表单数据")
    @PostMapping("/deleteRecord")
    public ResultUtil deleteRecord( @RequestParam(value = "table_id") String table_id ,
                                    @RequestParam(value = "data_id") String data_id ,
                                    @RequestParam(value = "table_name") String table_name ,
                                    @RequestParam(value = "usercode") String usercode){
        return  columnService.deleteRecord(table_id, table_name, data_id, usercode);
    }



    /**
     * @param data_id
     * @param table_name
     * @return
     */
    @ApiOperation(value = "1.7 删除表一对一表单数据")
    @DeleteMapping("/deleteRecordOfOne")
    public ResultUtil deleteRecordOfOne(
                                    @RequestParam(value = "data_id") String data_id ,
                                    @RequestParam(value = "table_name") String table_name
                                    ){
        return  columnService.deleteRecordOfOne(table_name, data_id);
    }

}
