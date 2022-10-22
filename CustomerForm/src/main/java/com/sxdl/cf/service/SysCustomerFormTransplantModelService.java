package com.sxdl.cf.service;

import com.alibaba.fastjson.JSONArray;
import com.sxdl.cf.dao.dao1.SysCustomerFormFactTableDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormFieldTableDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormHeaderColumnDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormProcessStepDao;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import com.sxdl.cf.entity.SysCustomerFormProcessStepEntity;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.FileUtil;
import com.sxdl.cf.util.ResultUtil;
import com.sxdl.cf.util.ZIPUtils;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tools.zip.ZipFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class SysCustomerFormTransplantModelService  {

    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final SysCustomerFormFactTableDao tableDao;
    private final SysCustomerFormFieldTableDao fieldDao;
    private final SysCustomerFormHeaderColumnDao headerDao;
    private final SysCustomerFormProcessStepDao stepDao;


    public static void main(String[] args) throws IOException {
        File.createTempFile("fieldFile_", ".json");
    }

    /**
     *  key id 字段固定死
     * sql(事实表[创建的表]
     * 事实管理表[sys_cf_facttable],
     * 字段表[sys_cf_fieldtable],
     * 展示表[sys_cf_headercolumn],
     * 流程表[sys_cf_processstep])
     * 主题分类不需要导出
     *
     */
    public List<File> createFileToZIP(String table_id, String table_name) throws IOException {
        List<File> fileList = new ArrayList<>();

        //1 导出事实表sql 获取事实表字段结构数据不要ID字段
        File tabelStructureFile = DataUtil.createTabelStructure(tableDao.getTabelStructure(table_name), table_name);
        fileList.add(tabelStructureFile);
        /**
         2  导出表数据
         */
          //管理表[sys_cf_facttable]
        List<SysCustomerFormFactTableEntity> tableList = tableDao.select(new SysCustomerFormFactTableEntity().setId(table_id));
        File tableFile = DataUtil.createBaseDataFile(File.createTempFile("tableFile_", ".json"), net.sf.json.JSONArray.fromObject(tableList));
        fileList.add(tableFile);
           //字段表[sys_cf_fieldtable]
        List<SysCustomerFormFieldTableEntity> fieldList = fieldDao.select(new SysCustomerFormFieldTableEntity().setFacttable_id(table_id));
        File fieldFile = DataUtil.createBaseDataFile(File.createTempFile("fieldFile_", ".json"), net.sf.json.JSONArray.fromObject(fieldList));
        fileList.add(fieldFile);
            //展示表[sys_cf_headercolumn],
        List<SysCustomerFormHeaderColumnEntity> headerList = headerDao.select(new SysCustomerFormHeaderColumnEntity().setFacttable_id(table_id));
        File headerFile = DataUtil.createBaseDataFile(File.createTempFile("headerFile_", ".json"), net.sf.json.JSONArray.fromObject(headerList));
        fileList.add(headerFile);
            //流程表[sys_cf_processstep])
        List<SysCustomerFormProcessStepEntity> stepList = stepDao.select(new SysCustomerFormProcessStepEntity().setForm_id(table_id));
        if(stepList.size()>0){
            File stepFile = DataUtil.createBaseDataFile(File.createTempFile("stepFile_", ".json"), net.sf.json.JSONArray.fromObject(stepList));
            fileList.add(stepFile);
        }

        Object o = FileUtil.allData.get(table_name + "." + table_id);
        //3 导出文件
        File layOutFile = DataUtil.createLayOutFile(table_name, table_id, o);
        fileList.add(layOutFile);


        /**
         4 判断是否有子表需要导出
             1 one 类型的子表(一对一)
             2 主键: [maintable_id] [varchar](50) NOT NULL 与主表id 值一样4
             3 布局文件: 有
             4 sql 事实表[创建的表] 字段表[sys_cf_fieldtable],  事实管理表[sys_cf_facttable],
         */
        List<SysCustomerFormFactTableEntity> childs = tableDao.select(new SysCustomerFormFactTableEntity().setMaintable_id(table_id));
        childs.stream().filter(f->f.getIs_childtable().equals(1)).forEach(e->{
            try {
                //1 布局文件
                File layOutFileToChildOne = DataUtil.createLayOutFile(e.getName(),e.getId(), FileUtil.allData.get(e.getName() + "." + e.getId()));
                fileList.add(layOutFileToChildOne);
                //2 建表sql
                File tabelStructureFileToChildsOne = DataUtil.createTabelStructureAuto(tableDao.getTabelStructure(e.getName()), e.getName());
                fileList.add(tabelStructureFileToChildsOne);
                //3 事实管理表[sys_cf_facttable]
                List<SysCustomerFormFactTableEntity> tableListToChildsOne = tableDao.select(new SysCustomerFormFactTableEntity().setId(e.getId()));
                File tableFileToChildsOne = DataUtil.createBaseDataFile(File.createTempFile("tableFile_"+e.getName(), ".json"), net.sf.json.JSONArray.fromObject(tableListToChildsOne));
                fileList.add(tableFileToChildsOne);
                //4 字段表[sys_cf_fieldtable]
                List<SysCustomerFormFieldTableEntity> fieldListToChildsOne = fieldDao.select(new SysCustomerFormFieldTableEntity().setFacttable_id(e.getId()));
                File fieldFileToChildsOne = DataUtil.createBaseDataFile(File.createTempFile("fieldFile_"+e.getName(), ".json"), net.sf.json.JSONArray.fromObject(fieldListToChildsOne));
                fileList.add(fieldFileToChildsOne);
            } catch (IOException ioException) {
                logger.error(ioException.getMessage());
                ioException.printStackTrace();
            }
        });

        /**
         1 many 类型的子表(一对多)
         2 主键: id是 uniqueidentifier 类型的   pid --> maintable_id 与主表id 值一样
         3 布局文件: key 没有
         4 sql 事实表[创建的表] 字段表[sys_cf_fieldtable],  事实管理表[sys_cf_facttable], 展示表[sys_cf_headercolumn],
         */
        //
        childs.stream().filter(f->f.getIs_childtable().equals(2)).forEach(e->{
            try {
                //1   建表sql
                File tabelStructureFileToChildsMany = DataUtil.createTabelStructure(tableDao.getTabelStructure(e.getName()), e.getName());
                fileList.add(tabelStructureFileToChildsMany);
                //2 事实管理表[sys_cf_facttable]
                List<SysCustomerFormFactTableEntity> tableListToChildsMany = tableDao.select(new SysCustomerFormFactTableEntity().setId(e.getId()));
                File tableFileToChildsMany = DataUtil.createBaseDataFile(File.createTempFile("tableFile_"+e.getName(), ".json"), net.sf.json.JSONArray.fromObject(tableListToChildsMany));
                fileList.add(tableFileToChildsMany);
                //3 字段表[sys_cf_fieldtable]
                List<SysCustomerFormFieldTableEntity> fieldListToChildsMany = fieldDao.select(new SysCustomerFormFieldTableEntity().setFacttable_id(e.getId()));
                File fieldFileToChildsMany = DataUtil.createBaseDataFile(File.createTempFile("fieldFile_"+e.getName(), ".json"), net.sf.json.JSONArray.fromObject(fieldListToChildsMany));
                fileList.add(fieldFileToChildsMany);
                //4  展示表[sys_cf_headercolumn]
                List<SysCustomerFormHeaderColumnEntity> headerListToChildsMany = headerDao.select(new SysCustomerFormHeaderColumnEntity().setFacttable_id(e.getId()));
                File headerFileToChildsMany = DataUtil.createBaseDataFile(File.createTempFile("headerFile_", ".json"), net.sf.json.JSONArray.fromObject(headerListToChildsMany));
                fileList.add( headerFileToChildsMany);
            } catch (IOException ioException) {
                logger.error(ioException.getMessage());
                ioException.printStackTrace();
            }
        });
        return fileList;
    }

    /**
     * key
     *   1 校验 MultipartFile
     *   2 转换成zipFile流
     *   3 获取zip文件中的内容
     *   4 删除文件zip
     * @param multipartFile
     * @return
     */
    public ResultUtil<Map<String, String>> checkZipFileParam(MultipartFile multipartFile)   {
        if (Objects.isNull(multipartFile)) {
            return ResultUtil.error("缺少配置文件包");
        }
        String contentType = multipartFile.getContentType();
        if (!"application/zip".equals(contentType) && !"application/x-zip-compressed".equals(contentType)) {
            return ResultUtil.error("上传的文件类型不正确");
        }
        Map<String, String> map  = null;
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), UUID.randomUUID() + "zip");
        File fileTemp = path.toFile();
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),fileTemp);
            ZipFile zip = new ZipFile(fileTemp,  "UTF-8" );
            map = ZIPUtils.unZipData(zip);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            boolean result = false;
            int tryCount = 0;
            while(!result && tryCount++ <10)
            {
                System.gc();
                result = fileTemp.delete();
            }

        }

        return ResultUtil.success(map);
    }


    public void coreMethod( String classifyid, ResultUtil<Map<String, String>> zipFileResultUtil) {
        Map<String, String> map =  zipFileResultUtil.getT() ;

        map.forEach((k,v)->{
            if(k.contains(".sql")){
                //执行 sql建表 与插入语句
                fieldDao.execSqlText(v);
            }else if (k.contains(".json")){
                // 保存数据到数据库
                if (k.contains("tableFile_")) {
                    List<SysCustomerFormFactTableEntity> tableEntities = JSONArray.parseArray(v, SysCustomerFormFactTableEntity.class);
                    tableEntities.forEach(e->tableDao.insert(e.setClassify_id(classifyid)));
                }
                if (k.contains("fieldFile_")) {
                    List<SysCustomerFormFieldTableEntity> fieldEntities = JSONArray.parseArray(v, SysCustomerFormFieldTableEntity.class);
                    fieldEntities.forEach(fieldDao::insert);
                }
                if (k.contains("headerFile_")) {
                    List<SysCustomerFormHeaderColumnEntity> headerEntities = JSONArray.parseArray(v, SysCustomerFormHeaderColumnEntity.class);
                    headerEntities.forEach(headerDao::insert);
                }
                if (k.contains("stepFile_")) {
                    List<SysCustomerFormProcessStepEntity> stepEntities = JSONArray.parseArray(v, SysCustomerFormProcessStepEntity.class);
                    stepEntities.forEach(stepDao::insert);
                }
            }else{
                //文件保存
                String filename = k.substring(0, k.indexOf("#"));
                JSONObject jsonObject = JSONObject.fromObject(v) ;
                // 覆盖文件内容
                try {
                    FileUtil.bufferedWriterToFile(FileUtil.path + File.separator + filename,jsonObject.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 处理缓存数据
                FileUtil.allData.put(filename,jsonObject);
            }

        });
    }

}
