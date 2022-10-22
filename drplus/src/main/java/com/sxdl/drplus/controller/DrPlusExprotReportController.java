package com.sxdl.drplus.controller;


import com.sxdl.drplus.dto.CVSDBO;
import com.sxdl.drplus.entity.DrPlusCenterTable;
import com.sxdl.drplus.service.DrPlusCenterTableService;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Api(tags = "导出上报数据")
@RestController
@RequestMapping("/exprotReport")
public class DrPlusExprotReportController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";

    @Autowired
    private DrPlusCenterTableService tableService;


    @Value("${DrHospitalName}")
    private String DrHospitalName;

    /**
     * key 这里是 抽取那块使用的按钮
     *
     *  6/7/11/12  --->csv zip  8/9 -->csv execl dbf zip   13-->dbf    14-->execl
     *
     * 平台  绩效中(6)西(7)医  8 9  上报需要导出文件,由于上报数据分离,在这里上报数据
     *  key 如果抽取或者上报字段没有对映,这里不予导出该字段
     *   1 csv 2 execl 3 dbf 4 csv zip 5 execl zip  6dbf zip
     * @param cvsdbo
     * @param response
     */
    @ApiOperation(value = "导出CSV文件2")
    @GetMapping("/exportExecl2")
    public void exportExecl2( CVSDBO cvsdbo, HttpServletResponse response) {

        //Integer ypid = cvsdbo.getPid();
        if(cvsdbo.getPid()==11){
            cvsdbo.setPid(6);
        }else if(cvsdbo.getPid()==12){
            cvsdbo.setPid(7);
        }
        try {

            String[] tile = FileUtil.getStrColbyJson(cvsdbo.getPid());
            if (tile.length<1)
                return  ;
            String fileName = cvsdbo.getFileName();
            //准备上报数据
            List<LinkedHashMap<String, Object>> dataList =  getDataListByEid(cvsdbo);
            //设置浏览器
            if("1".equals(cvsdbo.getType())){ //csv
                setServletResponsePropertiesCsv(fileName,response,"GBK");
                FileUtil.doCSV(dataList,tile,response.getOutputStream(),"GBK");
            }else if("2".equals(cvsdbo.getType())){ //execl
                setServletResponsePropertiesExecl(fileName,response);
                FileUtil.doExcel2(dataList,Arrays.asList(tile),response.getOutputStream());
            }else if("3".equals(cvsdbo.getType())){ //dbf
                setServletResponsePropertiesDbf(fileName,response);
                if(cvsdbo.getPid()==13){
                    FileUtil.doDbf2(dataList,Arrays.asList(tile),response.getOutputStream());
                }else{
                    FileUtil.doDbf(dataList,Arrays.asList(tile),response.getOutputStream());
                }

            }else if("4".compareTo(cvsdbo.getType())<=0){
                setServletResponsePropertiesZip(fileName,response);
                // 1 创建临时文件
                File tempFile =null;
                try {
                    //2 文件内容逻辑
                    if("4".equals(cvsdbo.getType())){ //zip-->Csv

                        tempFile = new File(System.getProperty("user.dir")+ File.separator+fileName+".csv");
                        if(!tempFile.getParentFile().exists()){ //判断文件父目录是否存在
                            tempFile.getParentFile().mkdirs();  //不存在创建父目录
                        }
                        if (!tempFile.exists()){
                            tempFile.createNewFile();
                        }
                        OutputStream fos = new FileOutputStream(tempFile);
                        FileUtil.doCSV(dataList,tile,fos,"GBK");
                    }else if("5".equals(cvsdbo.getType())){  //zip-->xls
                        tempFile = new File(System.getProperty("user.dir")+ File.separator+fileName+".xls");
                        if(!tempFile.getParentFile().exists()){ //判断文件父目录是否存在
                            tempFile.getParentFile().mkdirs();  //不存在创建父目录
                        }
                        if (!tempFile.exists()){
                            tempFile.createNewFile();
                        }
                        OutputStream fos = new FileOutputStream(tempFile);
                        FileUtil.doExcel2(dataList,Arrays.asList(tile),fos);
                    }else if("6".equals(cvsdbo.getType())){ //zip-->dbf
                        tempFile = new File(System.getProperty("user.dir")+ File.separator+fileName+".dbf");
                        if(!tempFile.getParentFile().exists()){ //判断文件父目录是否存在
                            tempFile.getParentFile().mkdirs();  //不存在创建父目录
                        }
                        if (!tempFile.exists()){
                            tempFile.createNewFile();
                        }
                        OutputStream fos = new FileOutputStream(tempFile);
                        FileUtil.doDbf(dataList,Arrays.asList(tile),fos);
                    }
                    //3 打包zip文件
                    FileUtil.doZip(  response.getOutputStream(),tempFile);
                } finally {//4 最后删除临时文件
                    boolean result = false;
                    int tryCount = 0;
                    while(!result && tryCount++ <10)
                    {
                        System.gc();
                        result = tempFile.delete();
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
        }
    }




    private List<LinkedHashMap<String ,Object>> getDataListBysql(CVSDBO cvsdbo){
        Integer pid = cvsdbo.getPid();
        String sql="";
        List<DrPlusCenterTable> cols = tableService.getReportColumn(pid);
        if(StringUtils.isEmpty(cvsdbo.getBlh())){
            sql = DataUtil.getPatientDataByTimeAdd(pid,"CQSJ",cvsdbo.getStime(),cvsdbo.getEtime(),cols);
        }else{
            sql = DataUtil.getPatientDataByBahAdd(pid,"PRIMAEYKEY",cvsdbo.getBlh(),cols);
        }
        List<LinkedHashMap<String ,Object>> list = tableService.getPatientData(sql);
        return list;
    }

    private List<LinkedHashMap<String ,Object>> getDataListByEid(CVSDBO cvsdbo){
        Integer pid = cvsdbo.getPid();
        String eid = cvsdbo.getEid();
        String sql="";
        List<DrPlusCenterTable> cols = tableService.getReportColumn(pid);
        sql = DataUtil.getPatientDataByEidAdd(pid,eid,cols);
        List<LinkedHashMap<String ,Object>> list = tableService.getPatientData(sql);
        return list;
    }

    /**
     *
     * @param fileName
     * @param response
     * @param uniCode GBK / GB2312 / UTF-8
     * @throws UnsupportedEncodingException
     */
    private void setServletResponsePropertiesCsv(String fileName , HttpServletResponse response,String uniCode) throws UnsupportedEncodingException {
        String fn  = fileName+".csv";
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        //处理乱码问题
        //response.setCharacterEncoding("UTF-8");
        //设置上下文类型
        //response.setHeader("content-type", "application/octet-stream; charset=UTF-8" );
        //response.setContentType("text/csv");
        //response.setContentType("application/csv;charset=GBK");
        response.setContentType("application/csv;charset="+uniCode);
        //客户使用目标另存为对话框保存指定文件
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fn,"utf-8")   );

    }



    private void setServletResponsePropertiesExecl(String fileName ,HttpServletResponse response) throws UnsupportedEncodingException {
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        //处理乱码问题
        response.setCharacterEncoding("UTF-8");
        //设置上下文类型
        response.setContentType("application/vnd.ms-excel;charset=GBK");
        //客户使用目标另存为对话框保存指定文件
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName,"utf-8")  + ".xls;");
    }


    private void setServletResponsePropertiesDbf(String fileName ,HttpServletResponse response) throws UnsupportedEncodingException {
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        //处理乱码问题
        //response.setCharacterEncoding("UTF-8");
        //设置上下文类型
        //response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setContentType("application/dbf;charset=GBK");
        //客户使用目标另存为对话框保存指定文件
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName,"utf-8")  + ".dbf;");
    }


    private void setServletResponsePropertiesZip( String fileName,HttpServletResponse response) throws UnsupportedEncodingException {
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+ URLEncoder.encode(fileName,"utf-8") +".zip");
    }

}
