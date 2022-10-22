package com.sxdl.report.controller;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.RsaUtil;
import com.sxdl.report.dao.dao1.DrDbzinfoDao;
import com.sxdl.report.dao.dao1.HandleDao;
import com.sxdl.report.entity.DrDbzinfo;
import com.sxdl.report.entity.DrReprotRecord;
import com.sxdl.report.entity.DrTable;
import com.sxdl.report.entity.DrTemplate;
import com.sxdl.report.service.DrReprotRecordService;
import com.sxdl.report.service.DrTableService;
import com.sxdl.report.service.DrTemplateService;
import com.sxdl.report.util.DataUtil;
import com.sxdl.report.util.PoiUtil;
import com.sxdl.report.util.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = "上报数据以及平台返回消息")
@RestController
@RequestMapping("/report")
public class DrReprotRecordController {

    @Autowired
    DrReprotRecordService drReprotRecordService;

    @Autowired
    DrTemplateService drTemplateService;

    @Autowired
    DrTableService drTableService;

    @Autowired
    DrDbzinfoDao drDbzinfoDao;

    @Autowired
    HandleDao handleDao;



    private String UUID="";




    @ApiOperation(value = "导出Excel" )
    @GetMapping("/exportExecl")
    public void exportExecl( @RequestParam(value = "stime") String stime,
                             @RequestParam(value = "etime") String etime,
                             @RequestParam(value = "zyh") String  zyh,
                             @RequestParam(value = "template_id") String template_id,
                             @RequestParam(value = "primarykey") String primarykey,
                             @RequestParam(value = "stime2") String stime2,
                             @RequestParam(value = "etime2") String etime2,
                            HttpServletResponse response) {
        try {
            StringBuilder sb = new StringBuilder(" select isnull(b.name,'') template_name,isnull(a.primarykey,'') primarykey,isnull(a.zyh,'') zyh,isnull(a.zhxm,'') zhxm,isnull(a.querytime,'') querytime,isnull(a.result_type,'') result_type ,isnull(a.result_content,'') result_content,isnull(a.upload_start_time ,'') upload_start_time from dr_reprot_record a left join dr_template b on a.template_id=b.id where 1=1 ");

            String cysj ="querytime";
            if(!StringUtils.isEmpty(zyh)){
                sb.append(" and a.zyh = '"+zyh+"' ");
            }
            if(!StringUtils.isEmpty(template_id)){
                sb.append(" and a.template_id='"+template_id+"' ");
            }

            if(!"".equals(primarykey) && null!=primarykey){
                sb.append(" and a.primarykey='"+primarykey+"' " );
            }

            if(!StringUtils.isEmpty(stime) && !StringUtils.isEmpty(etime)  ){
                sb.append(" and a.querytime between '"+stime+"' and '"+etime+"' ");
            }
            if(!StringUtils.isEmpty(stime2) && !StringUtils.isEmpty(etime2)  ){
                sb.append(" and a.upload_start_time  between '"+stime2+"' and '"+etime2+"' ");
            }

            //初始化数据题头
            List<String> header = initializationHeard();
            //设置HttpServletResponse中的属性
            setServletResponseProperties(response);

            List<LinkedHashMap<String, Object>> dataBySql = drReprotRecordService.getExcelData(sb.toString());
            HSSFWorkbook wb = PoiUtil.createExcel2("查询数据结果", header, dataBySql);
            OutputStream outputStream = response.getOutputStream();
            wb.write(response.getOutputStream());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    private void setServletResponseProperties(HttpServletResponse response) throws UnsupportedEncodingException {
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        //处理乱码问题
        response.setCharacterEncoding("UTF-8");
        //设置上下文类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //客户使用目标另存为对话框保存指定文件
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode("上报结果","utf-8")  + ".xls;");

    }





    @ApiOperation(value = "根据条件查询", notes = "根据条件查询")
    @GetMapping("/findByCondition")
    @ResponseBody
    public ResultUtil findByCondition(PageInfo pageInfo,
                                      @RequestParam(value = "stime") String stime,
                                      @RequestParam(value = "etime") String etime,
                                      @RequestParam(value = "zyh") String  zyh,
                                      @RequestParam(value = "template_id") String template_id,
                                      @RequestParam(value = "primarykey") String primarykey,
                                      @RequestParam(value = "stime2",required = false) String stime2,
                                      @RequestParam(value = "etime2",required = false) String etime2) {

        try {

            StringBuilder sb = new StringBuilder(" select b.name template_name,a.primarykey,a.zyh,a.zhxm,a.querytime,a.result_type ,a.result_content,a.upload_start_time   from dr_reprot_record a left join dr_template b on a.template_id=b.id where 1=1 ");

            String cysj ="querytime";
            if(!StringUtils.isEmpty(zyh)){
                sb.append(" and a.zyh = '"+zyh+"' ");
            }
            if(!StringUtils.isEmpty(template_id)){
                sb.append(" and a.template_id='"+template_id+"' ");
            }

            if(!"".equals(primarykey) && null!=primarykey){
                sb.append(" and a.primarykey='"+primarykey+"' " );
            }

            if(!StringUtils.isEmpty(stime) && !StringUtils.isEmpty(etime)  ){
                sb.append(" and a.querytime between '"+stime+"' and '"+etime+"' ");
            }
            if(!StringUtils.isEmpty(stime2) && !StringUtils.isEmpty(etime2)  ){
                sb.append(" and a.upload_start_time  between '"+stime2+"' and '"+etime2+"' ");
            }
            List<LinkedHashMap<String, Object>> dataBySql = drReprotRecordService.getExcelData(sb.toString());
            Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), dataBySql );
         /* List<DrTemplate> select = drTemplateService.select(new DrTemplate());
            String cysj ="querytime";
            DrReprotRecord reprotRecord = new DrReprotRecord();
            if(!"".equals(zyh) && null!=zyh){
                reprotRecord.setZyh(zyh);
            }
            if(!StringUtils.isEmpty(template_id)){
                reprotRecord.setTemplate_id(Integer.valueOf(template_id));
            }

            if(!"".equals(primarykey) && null!=primarykey){
                reprotRecord.setPrimarykey(primarykey);
            }
            PageInfo<DrReprotRecord> pagedata = drReprotRecordService.queryPageListBuffer(pageInfo, reprotRecord, cysj, stime, etime);
            pagedata.getList().forEach(e->{
                select.forEach(l->{
                    if(e.getTemplate_id().equals(l.getId())){
                        e.setTemplate_name(l.getName());
                    }
                });

            });*/
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }



    @ApiOperation(value = "根据条件查询单病种接口")
    @GetMapping("/findByConditionDBZ")
    @ResponseBody
    public ResultUtil<PageInfo<DrReprotRecord>> findByConditionDBZ(PageInfo pageInfo,
                                      @RequestParam(value = "stime",required = false) String stime,
                                      @RequestParam(value = "etime",required = false) String etime,
                                      @RequestParam(value = "zyh") String  zyh,
                                      @RequestParam(value = "sid") String sid,
                 @RequestParam(value = "timeColumn") String timeColumn
                                      ) {
        try {
            List<DrTemplate> select = drTemplateService.select(new DrTemplate());
            DrReprotRecord reprotRecord = new DrReprotRecord();
            if(!"".equals(zyh) && null!=zyh){
                reprotRecord.setZyh(zyh); /*reprotRecord.setProduct_id(product_id);*/
            }
            //根据对映关系找到 单病种id对映dr 模板的id
            DrDbzinfo dbzinfo = null;
            if(!StringUtils.isEmpty(sid)){
                dbzinfo = drDbzinfoDao.selectByPrimaryKey(Integer.valueOf(sid));
                if(StringUtils.isEmpty(dbzinfo.getTemplateid())){
                    return ResultUtil.error ( "dr数据库的 dr_dbzinfo 表中没有配置对映模板,需要模板与单病种配置好" );
                }else{
                    reprotRecord.setTemplate_id(dbzinfo.getTemplateid());
                }
            }
            PageInfo<DrReprotRecord> pagedata = drReprotRecordService.queryPageListBuffer(pageInfo, reprotRecord, timeColumn, stime, etime);
            pagedata.getList().forEach(e->{
                select.forEach(l->{
                    if(e.getTemplate_id().equals(l.getId())){
                        e.setTemplate_name(l.getName());
                    }
                });
            });
            return ResultUtil.success(pagedata);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


    /// 获取 单病种  模板id 根据 template_type  返回模板值
    @GetMapping("/getDbzdata")
    public ResultUtil getDbzdata(){
        return ResultUtil.success(drDbzinfoDao.selectAll());
    }


    @GetMapping("/getTemplateByType")
    public List<DrTemplate> getTemplateByType(){
       return drTemplateService.getTemplateByType();
    }

    //获取 table
    @ApiOperation(value = "根据 template_type获取模板", notes = "根据 template_type获取模板")
    @GetMapping("/getTableByTemplateId")
    public List<DrTable> getTableByTemplateId(){
        return drTableService.getDBZDate();
    }

    @ApiOperation(value = "更新", notes = "根据 template_type获取模板")
    @PostMapping("/updateDzb")
    public ResultUtil updateDzb(@RequestBody DrDbzinfo drDbzinfo){
        try {
            DrDbzinfo dbzEnitity = drDbzinfoDao.selectByPrimaryKey(drDbzinfo.getSid());
            drDbzinfoDao.updateByPrimaryKey(drDbzinfo);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("更新成功");
    }

    private String sTime="";
    private String eTime="";
    String privateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDi7ow2mH8WIXHwYkByznxMAY8J/O/jSAnBtj5umKSL2Mn9jAj1UjrF9lASrX5fiS4SxrFCzpngLwC0LfgYfk467DESXMtVffKVLQX8V+XWgROsOYIME2EMQ0Up8WGC188aExyVJbI/7GlWji5QQXlPpnmS3BQj2Q4CAWzLM78LtJ6u0mZ7s5LIpyXzsVDh2041cy8Cx4L9lqs+mLpcBET6Wo0TRx4Sp+/1iE1HBxu37oX7aHo+bVHnLQT4ClNxg4Cso8g/FKYIUfhfHYdmC3620GYxUqgEjSwO5j5kSxwc09TcwBCTdvUFzZbJL5vtauKCCk4/0J6qMvd8Fn0FUajPAgMBAAECggEAW/4F2u/wvMDsFl1N8PxhiNIs8QiXGlSOl/dP0beRJJvKLj1BOGmQJ8XU6e1oyEOs6LGhFAr6d9W1/FSSOSOihOJQdjgluU9oMi7hOU1Mf6stlWhunoSQl88BT6JpPAhODSzoLlHss1sbzJmwjposGizLJcyPYYTQ1+FKAAnHDW/0ZTSYyqXvxFLQyBqXb3x9VRRIPbwg8qWdVZXFLM1DeTK8EPqN5jvFy2n1ev86+MiIzekfsXP3wL3F7fHJhi1jwGy0BVygGqgWplwhHWlCoaqfYjG2ZghETIcRBUEFZjLxOOy4d6kITHSgw6uF8BNrNI8PTC/K81gVGcHLmYtYQQKBgQDxOSThOE+DIiZQ9DANEpYVt9RAYCV1Awn3TpVtQIkeq+48s4X21u//AD4BSNEcCdEEqWr/y6PGjsBhHTXqbegeFO+KaFAtNlVuU9ZHx+EPwJKEh67VDQp7iUeLRaqBAdthYMwJVl9aEiH5PtA2u7qHN3OmxaJK/wf3HIyzZkPcIQKBgQDw1UlTR2R2O5/lw/hU+Hv+V21o27uEGWEjfeR/RszjqMI8WmkBEStGQR5POLRO1Inu/jwO8/1/7fXq+x9sDL4kli1cqfah7zXtqp8f17pKAistcSmOfutEGXiuKeQ3KwpDmC/zbF8OhYClcuWDW9LhNoEl48f7PNNeBH0QigJm7wKBgDgglL02zgF0I7g4aSnRhkx9XoywEmcckugRR+GI357cYG2NVAFwV51c4BCKceV1P0Y3aWclafEcbBTsqAvpENZXBrmMtgMfHleyeCxxjKOOqkjeDUcTZroB4jy8tASaewI4dKFDkKIzj+YfwHDL04X82BMY7z9GAgN0iCSCCg4hAoGBAI9Vka+D9RG9SNw592my/jERHafj50WmyT6TZdQucjEotnmvIYGmE0hb50slJ4MnUfSw0VPg+UYTfWJeFYR8TQp/av4UlhoowcLy4oPUJCZ6BfKkwCPz+9frBP07J32CGzjBsgBBxo1g/YD60giNNQQfKVxApjwsJmx1ZW3bhbR3AoGAO+vtAqTBKpT3hN89UsOReWbJpb2N32xM4UV1csuSkAx+XN6fTHpraM/dcLVS08qm2tD1fHeHGRXBjJushFeSX4Qauxj2HOZgRybU9JlEFMuwREhCBDw/ySrxyWlcJwQQcsUwex1SdFO1B5YiC1yPwzXPz/ndVDeF3k/Y2gqNSbM=";
    //url: 实际请求：模板id+tableID+主键值+秘钥
    //  根据dr_dbzinfo 可以获取模板id+tableID  url: sid+key+秘钥
    @ApiOperation(value = "根据 template_type获取模板", notes = "根据 template_type获取模板")
    @PostMapping(value = "/sendDBZ" )
    public ResultUtil<List<DrReprotRecord>> sendDBZ(@RequestParam(value = "sid",required = true) Integer sid,
                              @RequestParam(value = "starTime",required = true) String starTime,
                              @RequestParam(value = "endTime",required = true) String endTime,
                              @RequestParam(value = "RSA",required = true) String RSA
                                   ){
        List<DrReprotRecord> list = new ArrayList<>();
        try {
            System.out.println("看到我只能看一次哦"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            DrDbzinfo dbzinfo = drDbzinfoDao.selectByPrimaryKey(sid);
            if(StringUtils.isEmpty(dbzinfo.getTemplateid()) || StringUtils.isEmpty(dbzinfo.getTableid())){
                return ResultUtil.error("警告：模板与单病种没有匹配");
            }
            DrTable table = drTableService.selectByKey(dbzinfo.getTableid());
            DrTemplate template = drTemplateService.selectByKey(dbzinfo.getTemplateid());
            String insertSql="";
            String decrypt = RsaUtil.decrypt(RSA, privateKey);
            //返回给单病种系统 病人是否上报成功
            if(format.equals(decrypt)){ //通过rsa 秘钥验证 开始上报数据
                //根据 前台选择的条件 将数据抽取 到中间容器中
                int i1 = drTableService.EtlDRG("3", table, starTime, endTime, null);
                System.out.println("处理了"+ i1 + " 条数据...");
                //获取中间容器中的所有数据（包括字段值为null的字段数据<本框架字段值为null就会少字段>）
                List<LinkedHashMap> dataList = drTableService.selectAllTableData( table.getName() );
                if (dataList.size()<1) {
                    return ResultUtil.error("警告：试图表中没有数据");
                } else {
                    for (LinkedHashMap map : dataList) {
                        try {
                            sTime = simpleDateFormat.format(new Date());
                            DrReprotRecord repostData = setReportData(template.getId(), template, table, map);
                            JSONObject jsonObject = JSONUtil.parseObj(map);
                            //向平台发送数据
                            net.sf.json.JSONObject jo = RequestUtil.sentOutSd(jsonObject.toString(),template.getReport_url(),template.getReport_type());
                            eTime = simpleDateFormat.format(new Date());
                            repostData.setUpload_end_time(eTime);
                            repostData.setResult_type(jo.getString("code"));
                            repostData.setResult_content(jo.getString("message"));
                            insertSql = " insert into "+table.getName()+"_bak select *,'"+UUID+"' from "+table.getName()+" where "+table.getPrimarykey()+"='"+map.get(table.getPrimarykey())+"'";
                            int i = handleDao.excuteSqlWithSQL(insertSql);
                            Integer insert = drReprotRecordService.insert(repostData);
                            list.add(repostData);
                        } catch (Exception e) {
                            sTime = simpleDateFormat.format(new Date());
                            DrReprotRecord repostData = setReportData(template.getId(), template, table, map);
                            repostData.setUpload_end_time(sTime);
                            repostData.setResult_type("本地故障：500");
                            repostData.setResult_content("自动上报出错，请联系管理员:"+e.getMessage());
                            insertSql = " insert into "+table.getName()+"_bak select *,'"+UUID+"' from "+table.getName()+" where "+table.getPrimarykey()+"='"+map.get(table.getPrimarykey())+"'";
                            int i = handleDao.excuteSqlWithSQL(insertSql);
                            Integer insert = drReprotRecordService.insert(repostData);
                            list.add(repostData);
                        }
                    }
                }
            }else{
                return ResultUtil.error("警告：非法访问本web接口，本次操作已经记录");
            }
        } catch (Exception e) {
            return ResultUtil.error("系统catch:" +e.getMessage());
        }
        System.out.println("张慧:"+list.toString());
        return ResultUtil.success(StringUtils.isEmpty(list)?new ArrayList<>() :list,"上报完成,请查看日志信息");
    }






    DrReprotRecord setReportData(Integer templateId, DrTemplate template,DrTable table,LinkedHashMap map){
        DrReprotRecord repostData = new DrReprotRecord();
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




    public List<String> initializationHeard(){
        List<String> header = new ArrayList<>();
        header.add("模板名称");
        header.add("主键");
        header.add("住院号");
        header.add("患者姓名");
        header.add("(出院时间/其他时间)");
        header.add("平台返回值");
        header.add("平台返回详情");
        header.add("上报时间");
        return header;
    }








}
