package com.sxdl.report.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.dao.dao1.DrColumnDao;
import com.sxdl.report.dao.dao1.DrTableDao;
import com.sxdl.report.dao.dao1.DrTemplateDao;
import com.sxdl.report.dao.dao1.HandleDao;
import com.sxdl.report.entity.DrColumn;
import com.sxdl.report.entity.DrTable;
import com.sxdl.report.entity.DrTemplate;
import com.sxdl.report.service.DrTableService;
import com.sxdl.report.util.FileReportUtil;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("drTableService")

public class DrTableServiceImpl extends BaseServiceImpl<DrTable> implements DrTableService {

    @Autowired
    HandleDao handleDao;

    @Autowired
    DrTemplateDao drTemplateDao;

    @Autowired
    DrTableDao drTableDao;

    @Autowired
    DrColumnDao drColumnDao;




    private String LineBreak ="\r\n";

    //根据模板创建表
    @Override
    public ResultUtil creatTableByLinkView(DrTable table){
        try{
            Integer tempID = table.getTemplate_id();
            DrTemplate temp = drTemplateDao.selectByPrimaryKey(tempID);

            //测试视图名存在不存在
            Integer linkType = temp.getReport_source();
            String linkName="";
            switch (linkType){
                case 1:
                    linkName="DRBA";
                    break;
                case 2:
                    linkName="DRBA";
                    break;
                case 3:
                    linkName="DRSD";
                    break;

            }
            String dbName = temp.getDb_name();
            String tableName=table.getName();
            String viewName = table.getView_name();
/*

            String result = handleDao.execSelectSql("select * from "+linkName+"."+dbName+".dbo."+viewName+" where 1=2 ");
*/

            String s = handleDao.execSelectSql(" select * into "+tableName+" from "+linkName+"."+dbName+".dbo."+viewName+" where 1=0 ");
            String ss = handleDao.execSelectSql(" select *  ,CAST('' AS VARCHAR(200)) uuid into "+tableName+"_bak from "+linkName+"."+dbName+".dbo."+viewName+" where 1=0 ");
            DrColumn DrColumn = new DrColumn();
            drTableDao.insert(table) ;
            List<Map<String, Object>> list =  handleDao.findDbInfo("sp_columns "+tableName+"");
            list.forEach(e -> {
                DrColumn.setName(e.get("COLUMN_NAME").toString());
                DrColumn.setName_zh(e.get("COLUMN_NAME").toString());
                DrColumn.setColumn_type(Integer.parseInt(e.get("DATA_TYPE").toString()));
                DrColumn.setSize(Integer.parseInt(e.get("LENGTH").toString()));
                DrColumn.setScale(Integer.parseInt((e.get("SCALE")==null ? "0": e.get("SCALE")).toString()));
                DrColumn.setTable_id(table.getId());
                drColumnDao.insert(DrColumn);
            });

            return ResultUtil.success("操作成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }

    }
    @Override
    public int EtlDRG(String type, DrTable table, String startTime, String endTime, String no){

        Integer tempID = table.getTemplate_id();
        DrTemplate template = drTemplateDao.selectByPrimaryKey(tempID);
        String linkName = "";

        String dbName=template.getDb_name();
        String sql="";
        if("1".equals(type) ||"2".equals(type) || "5".equals(type) ){
            linkName = "DRBA";
        }else if("3".equals(type) || "4".equals(type) ){
            linkName = "DRSD";
        }
        if("1".equals(type) || "3".equals(type) || "4".equals(type) || "5".equals(type)){//大同五院 DRG上报
             sql = " truncate table "+table.getName() +
                    "  insert into "+table.getName()+
                    "  select * from "+linkName+"."+dbName+".dbo."+table.getView_name()+" " +
                    "  where CONVERT(VARCHAR(10),"+table.getQuerytime()+",120 ) between '"+startTime+"'  and  '"+endTime+"' " ;
            if(!StringUtils.isEmpty(no)){
                sql = " truncate table "+table.getName() +
                        "  insert into "+table.getName()+
                        "  select * from "+linkName+"."+dbName+".dbo."+table.getView_name()+" " +
                        "  where "+table.getPrimarykey()+" = '"+no+"' " ;
            }

        }else if("2".equals(type)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

             sql = " truncate table "+table.getName() +
                    "  insert into "+table.getName()+
                    "  select * from "+linkName+"."+dbName+".dbo."+table.getView_name()+" " +
                    "  where Left("+table.getQuerytime()+",8) between '"+startTime+"'  and  '"+ endTime+ "' " ;
            if(!"".equals(no) && no!=null){
                sql = " truncate table "+table.getName() +
                        "  insert into "+table.getName()+
                        "  select * from "+linkName+"."+dbName+".dbo."+table.getView_name()+" " +
                        "  where "+table.getPrimarykey()+" = '"+no+"' " ;
            }

        }
        int i = handleDao.excuteSqlWithSQL(sql);
        return i;
    }







    @Override
    @Transactional
    public List<DrTable> findByTempId(Integer tempID){
        DrTable table = new DrTable();
        table.setTemplate_id(tempID);
        List<DrTable> drTables = drTableDao.select(table);
        return drTables;
    }

   /* @Override
    public  LinkedHashMap<String, String> fileDRGTemplate (LinkedHashMap map, DrTemplate template) throws Exception {
        //0. 判断reply.txt 是否存在，存在就删除文件
        FileReportUtil.delFiletxt(template.getPath_file());
       //1.生成requestBat.txt文件 并且注入数据
        File file = FileReportUtil.isExistsFile(template.getPath_file());
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write( template.getFile_header().replaceAll("\\n",LineBreak));
        bw.write(LineBreak);

        map.forEach((k,v)->{
            try {
                bw.write(k.toString()+"="+ (StringUtils.isEmpty(v)?"":v.toString()));
                bw.write(LineBreak);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bw.flush();
        bw.close();
        //2：修改文件名称
        FileReportUtil.renameFile(template.getPath_file());
        // 3.判断请求文件是否存在，存在就等待平台返回，返回后继续开始执行
        FileReportUtil.sleepTime(template.getPath_file());
        //4 .读取平台数据：检测应答文件时，应当等到应答文件的reply=TRUE时，方可进行读取工作
        LinkedHashMap<String, String> stringStringMap = FileReportUtil.txtRead(template.getPath_file());
        return stringStringMap;

    }*/


    @Override
    @Transactional
    public  LinkedHashMap<String, String> fileDRGTemplate (LinkedHashMap map, DrTemplate template,String keycol) throws Exception {
        //1. 判断reply.txt 是否存在，存在就删除文件
        FileReportUtil.delFiletxt(template.getPath_file());
        // 2创建文件并且独占文件开始写入数据
        createfile(map,template,keycol);
        // 3.判断请求文件是否存在，存在就等待平台返回，返回后继续开始执行
         FileReportUtil.sleepTime(template.getPath_file());
        //4 .读取平台数据：检测应答文件时，应当等到应答文件的reply=TRUE时，方可进行读取工作
        LinkedHashMap<String, String> stringStringMap = FileReportUtil.txtRead(template.getPath_file());
        return stringStringMap;

    }

    @Transactional
    public synchronized  void createfile (LinkedHashMap map, DrTemplate template,String keycol) throws Exception{
        //1.生成requestBat.txt文件 并且注入数据
        File file = FileReportUtil.isExistsFile2(template.getPath_file());
        OutputStreamWriter writer=null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(file),"GBK");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write( template.getFile_header().replaceAll("\\n",LineBreak));
        bw.write(LineBreak);

        map.forEach((k,v)->{
            try {
                if(k.toString().equals(keycol)){
                    bw.write(k.toString()+"="+ (StringUtils.isEmpty(v)?"":v.toString().trim()));
                }else {
                    bw.write(k.toString()+"="+ (StringUtils.isEmpty(v)?"":v.toString()));
                }
                bw.write(LineBreak);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }






    @Transactional
    public void delete(Integer id){
        DrTable drTable = drTableDao.selectByPrimaryKey(id);
        //删除字段表
        drColumnDao.deleByPid(id);
        //删除table表
        drTableDao.deleteByPrimaryKey(id);
        //删除容器表
        drTableDao.dropTable(drTable.getName());
        //删除备份数据表
        drTableDao.dropTable(drTable.getName()+"_bak");
    }

    @Transactional
    public List<DrTable> getDBZDate(){
        return drTableDao.getDBZDate();
    }

}
