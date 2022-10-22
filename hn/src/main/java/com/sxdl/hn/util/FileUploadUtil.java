package com.sxdl.hn.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUploadUtil {


    /**
     *
     * @param file 判断非空后的file
     * @param pname 人员名称
     * @param filePath 配置文件url + 要保存文件的模块名称
     * @throws Exception
     */
    public static String fileSave(MultipartFile file , String pname, String filePath) throws Exception{
        // [人名 + 时间日期 ]+  filePath
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
        //生成文件全名称
        String createFileName =  pname+"_"+sim.format(new Date())+"_"+file.getOriginalFilename();
        //生成文件全路径+文件名
        String createUrl = filePath.replaceAll("\\\\", "\\\\\\\\")+createFileName;
        //判断文件父目录是否存在 不存在创建父目录 创建文件或者直接覆盖文件
        File createFile = new File(createUrl);
        if(!createFile.getParentFile().exists()){ //判断文件父目录是否存在
            createFile.getParentFile().mkdirs();  //不存在创建父目录
        }
        createFile.createNewFile();//创建文件或者直接覆盖文件

        BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(createFile));
        byte[] bys = new byte[10000];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
        return createUrl.replaceAll("\\\\\\\\","/");
    }


    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("temp",".txt",new File("D:/"));
        System.out.println("File path: "+file.getAbsolutePath());

    }


    public static  boolean deleteFile(String filePath) throws  Exception{
        File file = new File(filePath);
        boolean delete = file.delete();
        return delete;
    }
}
