package com.sxdl.report.util.scheduled;

import com.sxdl.report.dao.dao1.HandleDao;
import com.sxdl.report.entity.DrReprotRecord;
import com.sxdl.report.entity.DrTable;
import com.sxdl.report.entity.DrTemplate;
import com.sxdl.report.service.DrReprotRecordService;
import com.sxdl.report.service.DrTableService;
import com.sxdl.report.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

@Component(value = "dataTask")
public class MyDLongTask  {

    @Autowired
    DrTableService tableService;


    @Autowired
    HandleDao handle;

    @Autowired
    private DrReprotRecordService drReprotRecordService;

    private  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DrReprotRecord repostData;
    String UUID="";
    String sTime=null;
    String eTime=null;
    String insertSql="";
    public void doTask(DrTemplate template) {

      /*  //判断是否到截止日期
        String endTime = template.getEnd_time();
        String now = DateUtil.today();
        DateTime beginMonth=null;
        DateTime endMonth=null;
        long betweenDay =DateUtil.between(DateUtil.parse(now) , DateUtil.parse(endTime), DateUnit.DAY);
        if(betweenDay> 0){
            return;
        }

        System.out.println("自动上报----任务启动成功！***********************************************************");

        DrReturn drReturn= new DrReturn();
        //所有调度进来分四步走
        DrTable proc = new DrTable();
        proc.setTemplate_id(template.getId());
        proc.setAuto_procdure(1);         // 自动调度开启的
        List<DrTable> tables = tableService.select(proc);
        if(tables.size()<0){
            return;
        }


        //自动生成时间开始--------------
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        SimpleDateFormat simpleDateFormat = null;
        String template_type = template.getTemplate_type();
        switch (template.getScope_unit()){
            case "1":
                //抽取单位设置的是天
                calendar.add(calendar.get(Calendar.DAY_OF_YEAR) ,-Integer.parseInt(template.getScope()));
                date = calendar.getTime();
                beginMonth= DateUtil.beginOfMonth(date);
                endMonth=DateUtil.date();
                break;
            case "2":
                //抽取单位设置的是月
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - Integer.parseInt(template.getScope())); // 设置为上一个月
                date = calendar.getTime();
                beginMonth= DateUtil.beginOfMonth(date);
                endMonth= DateUtil.endOfMonth(date);
                break;
        }
        String autoStime=null;
        String autoEtime=null;
        if("2".equals(template_type)){ //长治市医保
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            autoStime = simpleDateFormat.format(beginMonth);
            autoEtime = simpleDateFormat.format(endMonth);
        }else if("3".equals(template_type)){
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            autoStime = simpleDateFormat.format(beginMonth);
            autoEtime = simpleDateFormat.format(endMonth);
        }

        //自动生成时间结束--------------

        System.out.println("自动生成时间："+autoStime+"《---》" +autoEtime);

        for (DrTable e : tables)  {

            //根据 前台选择的条件 将数据抽取 到中间容器中
            tableService.EtlDRG(template_type,e,autoStime,autoEtime,"");
            //获取中间容器中的所有数据（包括字段值为null的字段数据<本框架字段值为null就会少字段>）
            List<LinkedHashMap> dataList = tableService.execAllData( e.getName() );
            if (dataList.size()<0) {
                continue;
            }

            for (LinkedHashMap map : dataList) {
                try {
                    repostData = setReportData(template.getId(), template, e, map);
                    sTime = sdf.format(new Date());
                    JSONObject jsonObject = JSONObject.fromObject(map);
                    JSONObject jo=null;
                    if("3".equals(template.getTemplate_type())){ //单病种
                        jo = RequestUtil.sentOutSd(jsonObject.toString(),template.getReport_url(),template.getReport_type());
                    }else if("2".equals(template.getTemplate_type())){//长治医保
                        jo = RequestUtil.sendOut(jsonObject.toString(),template.getReport_url(),template.getEnd_time(),template.getReport_type(),template.getToken());
                    }
                    eTime = sdf.format(new Date());
                    if("3".equals(template.getTemplate_type())){ //单病种
                        repostData.setUpload_end_time(eTime);
                        repostData.setResult_type(jo.getString("code"));
                        repostData.setResult_content(jo.getString("message"));
                    }else if("2".equals(template.getTemplate_type())){//长治医保
                        repostData.setUpload_end_time(eTime);
                        repostData.setResult_type(jo.getString("code"));
                        repostData.setResult_content(jo.getString("message")+" -《分割》- "+jo.getString("data"));
                    }
                    insertSql = " insert into "+e.getName()+"_bak select *,'"+UUID+"' from "+e.getName()+" where "+e.getPrimarykey()+"='"+map.get(e.getPrimarykey())+"'";
                    System.out.println("sql _bak: "+insertSql);
                    handle.excuteSqlWithSQL(insertSql);
                    drReprotRecordService.insert(repostData);
                }catch (Exception exception){
                    repostData = setReportData(template.getId(), template, e, map);
                    sTime = sdf.format(new Date());
                    repostData.setUpload_end_time(sTime);
                    repostData.setResult_type("本地故障：500");
                    repostData.setResult_content("自动上报出错，请联系管理员:"+exception.getMessage());
                    insertSql = " insert into "+e.getName()+"_bak select *,'"+UUID+"' from "+e.getName()+" where "+e.getPrimarykey()+"='"+map.get(e.getPrimarykey())+"'";
                    handle.excuteSqlWithSQL(insertSql);
                    drReprotRecordService.insert(repostData);
                }

            }
        }*/



    }

    DrReprotRecord setReportData(Integer templateId, DrTemplate template,DrTable table,LinkedHashMap map){
        repostData = new DrReprotRecord();
        UUID = java.util.UUID.randomUUID().toString();
        repostData.setTemplate_id(templateId);
        repostData.setProduct_id( template.getProduct_id() );
        repostData.setPrimarykey(map.get(DataUtil.stringReplaces(table.getPrimarykey())).toString());
        repostData.setUpload_start_time(sTime);
        repostData.setKs_code_ry(map.get(table.getKs_code_ry())==null?null:map.get(DataUtil.stringReplaces(table.getKs_code_ry())).toString());
        repostData.setKs_code_cy(map.get(table.getKs_code_cy())==null?null:map.get(DataUtil.stringReplaces(table.getKs_code_cy())).toString());
        repostData.setZyh(map.get(table.getZyh())==null?null:map.get(DataUtil.stringReplaces(table.getZyh())).toString());
        repostData.setSex(map.get(table.getSex())==null?null:map.get(DataUtil.stringReplaces(table.getSex())).toString());
        repostData.setPrimary_diagnosis(map.get(table.getPrimary_diagnosis())==null?null:map.get(DataUtil.stringReplaces(table.getPrimary_diagnosis())).toString());
        repostData.setAge(map.get(table.getAge())==null?null:map.get(DataUtil.stringReplaces(table.getAge())).toString());
        repostData.setQuerytime(map.get(table.getQuerytime())==null?null:map.get(DataUtil.stringReplaces(table.getQuerytime())).toString());
        repostData.setAge_unit(map.get(table.getAge_unit())==null?null:map.get(DataUtil.stringReplaces(table.getAge_unit())).toString());
        repostData.setZhxm(map.get(table.getZhxm())==null?null:map.get(DataUtil.stringReplaces(table.getZhxm())).toString());
        repostData.setUuid(UUID);
        return repostData;
    }



}
