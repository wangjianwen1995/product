package com.sxdl.report.controller;

import com.sxdl.base.dao.dao1.SysRoleVsMenuDao;
import com.sxdl.report.DrMainTest;
import com.sxdl.report.dao.dao1.HandleDao;
import com.sxdl.report.entity.DrTable;
import com.sxdl.report.service.DrTableService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class DrTableControllerTest extends DrMainTest {

    private DrTable table;

    public  static  final String LineBreak ="\r\n";
    @Autowired
    private HandleDao handleDao;


    public static Map<String ,String > txtRead(String  filePath){
        Map<String ,String > map = new HashMap<>();
        filePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\reply.txt";
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                sb.append(System.lineSeparator()+s);

            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        String result  = sb.toString().replaceAll(LineBreak,"");
        int re = result.indexOf("reply=")+"reply=".length();
        String reply = result.substring(re, result.indexOf("success="));

        int su = result.indexOf("success=")+"success=".length();
        String success = result.substring(su, result.indexOf("error="));
        int er = result.indexOf("error=")+"error=".length();
        String error = result.substring(er,result.indexOf("zylsh0="));
        int zy = result.indexOf("zylsh0=")+"zylsh0=".length();
        String zylsh0=result.substring(zy);
        map.put("success",success);
        map.put("error",error);
        map.put("zylsh0",zylsh0);
        map.put("reply",reply);

        return map;
    }


    public void sleepTime(String filePath) throws Exception{
        filePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\request.txt";
        File file = new File(filePath);
        boolean flag=true;
        while (flag){
            if(!file.exists()){
                flag =false;
                break;
            }
            Thread.sleep(500);
        }

    }
    @Autowired
    SysRoleVsMenuDao baseService ;
        //execAllData






    /**
     * 通过文件路径直接修改文件名
     *
     * @param filePath    需要修改的文件的完整路径
     *
     * @return
     */
    public String FixFileName(String filePath) {
        filePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\requestBat.txt";
        File file = new File(filePath);
        String parent = file.getParent();
        File newfile = new File(parent+"\\request.txt");
        file.renameTo(newfile);
        return "sss";
    }



    @Autowired
    DrTableService drTableService;

    @Test
    public void ssss(){
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("统计异常池数量异常,异常信息如下:e.getStackTrace().toString()....");
        System.out.println("sdfsdfsdfsdfsdfdsfdsfsdfsdfsdf");
    }









}
