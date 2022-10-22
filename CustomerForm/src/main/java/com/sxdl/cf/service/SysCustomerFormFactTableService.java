package com.sxdl.cf.service;

import com.sxdl.cf.dao.dao1.SysCustomerFormFactTableDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormFieldTableDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormHeaderColumnDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormProcessStepDao;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import com.sxdl.cf.entity.SysCustomerFormProcessStepEntity;
import com.sxdl.cf.service.base.BaseUUIDServiceImpl;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.FileUtil;
import com.sxdl.cf.util.ResultUtil;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SysCustomerFormFactTableService extends BaseUUIDServiceImpl<SysCustomerFormFactTableEntity> {


    private final SysCustomerFormFieldTableDao fieldDao;

    private final SysCustomerFormFactTableDao factTableDao;

    private final SysCustomerFormHeaderColumnDao columnDao;


    private final SysCustomerFormProcessStepDao sysProcessStepDao;


    public Integer existsTable(String id) {
        return factTableDao.existsTable(id);
    }

    public List<SysCustomerFormFactTableEntity> getDataofVal(String val) {
        return factTableDao.getDataofVal(val);
    }

    public List<SysCustomerFormFactTableEntity> getDataOfClassify(String classify_id, String val) {
        return factTableDao.getDataOfClassify(classify_id,val);
    }

    /**
     *
     *    is_childtable 0 否  1(一对一弹框式) 2(一对多列表式) 如果是 2类型就不需要生成文件布局
     *  1 创建表,并且 创建默认字段
     *  2 保存数据
     *  3 保存列表展示属性数据
     *  4 创建布局数据文件
     * @param tableEntity
     */
    public void addFactTable(SysCustomerFormFactTableEntity tableEntity) throws IOException {
        //保存事实表 的模型数据
        int insert = factTableDao.insert(tableEntity);
        String id = tableEntity.getId();
        String name = tableEntity.getName();
        //同步模型到数据库表中(初始化时候默认有系统字段不能删除),同时字段也添加到 字段表中
        addFieldByName(id, name,tableEntity.getIs_childtable());
        //保存列表展示属性数据
        addcolumnByName(id,tableEntity.getIs_childtable());
        // 创建布局数据文件 以事实表 名称+id 作为文件名称   2类型就不需要生成文件布局
        if(2!=tableEntity.getIs_childtable()){
            String path = FileUtil.path+File.separator+name+"."+id;
            FileUtil.createFile(path);
        }
    }



    public ResultUtil delFactTable(String id, String name,Integer is_childtable) {
        // 1 判断表是否有关联关系 2 判断表中是否有数据

        // 1.1是主表开始判断maintable_id字段是否有 子表关联该主表
        if (is_childtable==0){
            //判断一对多
            List<SysCustomerFormFactTableEntity> tables = factTableDao.select(new SysCustomerFormFactTableEntity().setMaintable_id(id));
            if (tables.size()>0){
                String collect = tables.stream().map(SysCustomerFormFactTableEntity::getName).collect(Collectors.toList()).toString();
                return ResultUtil.error("警告:有 ["+tables.size()+"] 张表与该表存在关系,分别是:"+collect);
            }

            //判断一对一 根据该表字段中associated_table_id有值判断与其他表有关联关系
            List<String> tableLists = fieldDao.getChildByTableId(id);
            if(tableLists.size()>0){
                return  ResultUtil.error("警告:"+tableLists.toString());
            }

        }
        /**
         * 确定没有关联关系判断表是否存在
          */
        if (factTableDao.existsTableByTableName(name)>0){
            //删除数据库表
            factTableDao.dropTable("["+name+"]");
        }
        //删除管理表
        int i = factTableDao.deleteByPrimaryKey(id);
        //删除 列表属性数据
        Integer ii = columnDao.deletebyPid(id);
        ii = fieldDao.deletebyPid(id);
        String path = FileUtil.path+File.separator+name+"."+id;
        if (FileUtil.existesFile(path)){
            boolean result = false;
            int tryCount = 0;
            while(!result && tryCount++ <10)
            {
                System.gc();
                result = new File(path).delete();
            }
        }
        /**
         * 判断流程数据
         */

        List<SysCustomerFormProcessStepEntity> processList = sysProcessStepDao.select(new SysCustomerFormProcessStepEntity().setForm_id(id));
        if(processList.size()>0)
            processList.forEach(sysProcessStepDao::delete);

        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);

    }


    public void addFieldByName(String pid, String name,Integer isChildtable){
        if(isChildtable==0){//主表创建
            List<SysCustomerFormFieldTableEntity> list = DataUtil.InitField(pid,name);
            list.forEach(fieldDao::insert);
            fieldDao.execSqlText(DataUtil.InitFieldSql(name));
        }else if(2==isChildtable){ //一对多
            List<SysCustomerFormFieldTableEntity> list = DataUtil.InitFieldChildrenMany(pid,name);
            list.forEach(fieldDao::insert);
            fieldDao.execSqlText(DataUtil.InitFieldChildManySql(name));
        }else if(1==isChildtable){ //一对一
            List<SysCustomerFormFieldTableEntity> list = DataUtil.InitFieldChildrenOne(pid,name);
            list.forEach(fieldDao::insert);
            fieldDao.execSqlText(DataUtil.InitFieldChildOneSql(name));
        }

    }
    // key  一对一不需要 显示列表
    public void addcolumnByName(String pid ,Integer isChildtable){
        if(isChildtable==0){//主表创建
            List<SysCustomerFormHeaderColumnEntity> list = DataUtil.InitColumn(pid);
            list.forEach(columnDao::insert);
        }else if(2==isChildtable){ //一对多
            List<SysCustomerFormHeaderColumnEntity> list = DataUtil.InitChildManyColumn(pid);
            list.forEach(columnDao::insert);
        }
    }

    /**
     * 保存 文件数据 同事处理缓存数据
     * @param objectMap
     */
    public void saveLayout(  Map<String,Object> objectMap  ) throws IOException {

        //key 第一步 获取到联动数据 保存到 字段表中(sys_cf_fieldtable)
        JSONArray jsonArray = JSONArray.fromObject(objectMap.get("relationFields") );
        jsonArray.forEach(e->{
            JSONObject object = JSONObject.fromObject(e);

            String associated_table_id = !StringUtils.isEmpty(object.getString("associated_table_id"))?object.getString("associated_table_id").equals("null")?"[]":object.getString("associated_table_id") :"[]";

            JSONArray jsonArray1 = JSONArray.fromObject(associated_table_id);

            JSONArray associated_table_name_jsonArray  = new JSONArray();
            JSONArray associated_tablename_zh_jsonArray  = new JSONArray();

            if(jsonArray1.size()>0){
                jsonArray1.forEach(j->{
                    SysCustomerFormFactTableEntity tableEntity = factTableDao.selectByPrimaryKey(j.toString());
                    associated_table_name_jsonArray.add(tableEntity.getName());
                    associated_tablename_zh_jsonArray.add(tableEntity.getLabel());
                });
            }

            String associated_table_name = associated_table_name_jsonArray.toString();
            String associated_tablename_zh =associated_tablename_zh_jsonArray.toString();
           // String associated_value = !StringUtils.isEmpty(object.getString("associated_value"))?"'"+object.getString("associated_value").replaceAll("'","''")+"'":"NULL";
           // String assignment_formula=!StringUtils.isEmpty(object.getString("assignment_formula"))?"'"+object.getString("assignment_formula").replaceAll("'","''")+"'":"NULL";
            String assignment_formula = !StringUtils.isEmpty(object.getString("assignment_formula"))?object.getString("assignment_formula").replaceAll("'","''").equals("null")?"[]":object.getString("assignment_formula").replaceAll("'","''") :"[]";


            String table_name = object.getString("table_name");
            String field_name = object.getString("name");
            String sql = " update sys_cf_fieldtable set  associated_table_id='"+associated_table_id+"' "
                    + ",associated_table_name='"+associated_table_name+"' "
                    +",associated_tablename_zh='"+associated_tablename_zh+"' "
                    +", assignment_formula='"+assignment_formula+"' "
                    + " where table_name='"+table_name+"' and name='"+field_name+"'";
            fieldDao.execSqlText(sql);

        });

        //key 第二步 保存文件到磁盘中
        String filename = objectMap.get("filename").toString();
        JSONObject jsonObject = JSONObject.fromObject(objectMap) ;
        // 覆盖文件内容
        FileUtil.bufferedWriterToFile(FileUtil.path + File.separator + filename,jsonObject.toString());
        // 处理缓存数据
        FileUtil.allData.put(filename,jsonObject);

    }

    public boolean existsToexamineData(String formId,String processCode) {
        SysCustomerFormFactTableEntity face = factTableDao.selectByPrimaryKey(formId);
        Integer num = factTableDao.selectInteger("select count(*) from " + face.getName() + " where toexamine_process='" + processCode + "' and toexamine_result= 1");
        return num>0;
    }
}
