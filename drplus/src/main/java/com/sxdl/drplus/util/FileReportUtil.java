package com.sxdl.drplus.util;

import net.sf.json.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;

public class FileReportUtil {

    public  static  final String LineBreak ="\r\n";
    /**
     *   生成文件
     * @param path
     * @return
     * @throws Exception
     */
    public static File isExistsFile(String path) throws Exception{
        String filePath = path.replaceAll("\\\\", "\\\\\\\\")+"\\requestBat.txt";
        File file = new File(filePath);
        if(!file.getParentFile().exists()){ //判断文件父目录是否存在
            file.getParentFile().mkdirs();  //不存在创建父目录
        }
        if(!file.exists()){ //判断文件是否存在
            file.createNewFile();
        }
        return file;
    }


    public static void main(String[] args)  throws  Exception{
        txtRead("C:\\Users\\HP\\Desktop\\新建文件夹");

    }

    public static File isExistsFile2(String path) throws Exception{
        String filePath = path.replaceAll("\\\\", "\\\\\\\\")+"\\request.txt";
        File file = new File(filePath);
        if(!file.getParentFile().exists()){ //判断文件父目录是否存在
            file.getParentFile().mkdirs();  //不存在创建父目录
        }
        if(!file.exists()){ //判断文件是否存在
            file.createNewFile();
        }
        return file;
    }



    /**
     * 通过文件路径直接修改文件名
     *
     * @param filePath    需要修改的文件的完整路径
     *
     * @return
     */
    public static  void renameFile(String filePath) {
        filePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\requestBat.txt";
        File file = new File(filePath);
        String parent = file.getParent();
        File newfile = new File(parent+"\\request.txt");
        file.renameTo(newfile);

    }


    /**
     * 系统等待平台处理请求文件，
     * @param filePath
     * @throws Exception
     */
    public static void sleepTime(String filePath) throws Exception{
        filePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\request.txt";
        File file = new File(filePath);
        /*boolean flag=true;
        while (flag){
            if(!file.exists()){
                flag =false;
                break;
            }
            System.out.println("等待平台读取请求文件中....");
            Thread.sleep(500);
        }*/
        int flag=15;
        while (flag>0){
            if(file.exists()){
                flag=-1;
                break;
            }
            flag--;
            Thread.sleep(500);
            System.out.println("等待平台读取请求文件中....."+flag);
        }

    }

    /**
     * 获取平台相应数据
     *
     *
     * @param filePath
     * @return
     */
    public static LinkedHashMap<String ,String > txtRead(String  filePath) throws Exception{
        LinkedHashMap<String ,String > map = new LinkedHashMap<>();
        String newfilePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\reply.txt";
        File file = new File(newfilePath);

        int flag=50;
        while (flag>0){
            if(file.exists()){
                flag=-1;
                break;
            }
            flag--;
            Thread.sleep(500);
            System.out.println("等待平台返回相应文件中....."+flag);
        }

        flag = 50;
        while (flag>0){
            try {
                if(!file.renameTo(file)){
                    System.out.println("文件被占用 ,请等待..."+flag);
                    flag--;
                    Thread.sleep(2000);
                }else{
                    break;
                }
            }catch (Exception e){
                System.out.println("文件占用异常:"+e.getMessage());
                flag--;
                break;
            }
        }



        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                sb.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            System.out.println("外部系统结束写操作,开始读取文件失败...:"+e.getMessage());
        }

        String result  = sb.toString().replaceAll(LineBreak,"");
        System.out.println("结果数据:"+result);
        /*
        int re = result.indexOf("reply=")+"reply=".length();
        String reply = result.substring(re, result.indexOf("success="));
        if(!"TRUE".equals(reply)){
            Thread.sleep(500);
            System.out.println("警告：执行回调，文件reply状态不为TRUE");
            txtRead(filePath);
        }



        int su = result.indexOf("success=")+"success=".length();
        if(!result.contains("error")){
            String success = result.substring(su, result.indexOf("zylsh0="));
            int zy = result.indexOf("zylsh0=")+"zylsh0=".length();
            String zylsh0=result.substring(zy);
            map.put("success",success);
            map.put("error",null);
            map.put("zylsh0",zylsh0);
            map.put("reply",reply);
            return map;
        }
        String success = result.substring(su, result.indexOf("error="));
        int er = result.indexOf("error=")+"error=".length();
        String error = result.substring(er,result.indexOf("zylsh0="));
        int zy = result.indexOf("zylsh0=")+"zylsh0=".length();
        String zylsh0=result.substring(zy);*/
        map.put("error",result);


       return map;
    }

    /**
     *  删除reply.txt 文件
     * @param filePath
     * @throws Exception
     */
    public static void delFiletxt(String filePath) throws Exception{
        String newfilePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\reply.txt";
        File file  = new File(newfilePath);
        if(file.exists()){
            file.delete();
        }
    }






     public static JSONObject getJsonDate() throws Exception{
         String filename = "Product.json";
         StringBuilder sb = new StringBuilder();
         InputStream resourceAsStream = FileReportUtil.class.getClassLoader().getResourceAsStream(filename);
         InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
         BufferedReader br  =new BufferedReader(isr);
         String line;
         while((line = br.readLine())!=null){
             sb.append(line);
         }
         JSONObject jsonObject = JSONObject.fromObject(sb.toString());
         return jsonObject;
    }











}
