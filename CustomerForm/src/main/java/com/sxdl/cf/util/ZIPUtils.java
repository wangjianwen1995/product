package com.sxdl.cf.util;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ZIPUtils {

    private static int BUFFER = 1024;

    public static void main(String[] args) throws  Exception {
        //testZipCompress();
        //UnZip();




    }

    /***
     * 测试多文件压缩
     * @throws FileNotFoundException
     */
    public static void testZipCompress() throws FileNotFoundException {
        List<File> srcFiles = new ArrayList<>();
        File file = new File("C:\\Users\\HP\\Desktop\\ttt\\1.sql");
        File file3 = new File("C:\\Users\\HP\\Desktop\\ttt\\2.txt");
        srcFiles.add(file);
        srcFiles.add(file3);
        zipFiles(srcFiles,new FileOutputStream(new File("C:\\Users\\HP\\Desktop\\ttt\\压缩.zip")));
        boolean result = false;
        boolean result2 = false;
        int tryCount = 0;
        while(!result &&!result2 && tryCount++ <10)
        {
            System.gc();
            if(!result)  result = file3.delete();
            if(!result2) result2 = file.delete();

        }
    }

    public static void UnZip() throws IOException {
        ZipFile zipFile = new ZipFile(new File("C:\\Users\\HP\\Desktop\\ttt\\压缩.zip"));
        Map<String, String> map = unZipData(zipFile);
        System.out.println(map);
    }



    /**
     *   压缩的多个文件成ZIP
     * @param srcFiles  要压缩的多个文件
     * @param outputStream   springMVC提供的输出流
     */
    public static void zipFiles(List<File> srcFiles, OutputStream outputStream) {

        // 创建 ZipOutputStream  实例化 ZipOutputStream 对象
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        // 创建 FileInputStream 对象
        FileInputStream in = null;
        try {
            // 创建 ZipEntry 对象
            ZipEntry zipEntry = null;
            // 遍历源文件数组

            for (int i = 0; i < srcFiles.size(); i++) {
                // 将源文件数组中的当前文件读入 FileInputStream 流中
                in = new FileInputStream(srcFiles.get(i));
                // 实例化 ZipEntry 对象，源文件数组中的当前文件
                zipEntry = new  ZipEntry(srcFiles.get(i).getName());
                zipOutputStream.putNextEntry(zipEntry);
                // 该变量记录每次真正读的字节个数
                int len;
                // 定义每次读取的字节数组
                byte[] buf = new byte[1024];
                while ((len = in.read(buf)) > 0) {
                    zipOutputStream.write(buf, 0, len);
//                    zipOutputStream.flush();
                }
            }
            in.close();
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 解压 zip 文件里面的数据
     * @param zipFile
     * @return
     */
    public  static Map<String,String> unZipData(ZipFile zipFile  ) {
        Map<String,String> map = new HashMap<>() ;
        try {
            BufferedReader br  = null;
            for(Enumeration entries = zipFile.getEntries(); entries.hasMoreElements() ; ){
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String name = entry.getName();

                StringBuilder sb  = new StringBuilder();
                br  =new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(zipFile.getInputStream(entry)),"UTF-8")
                );

                String line;
                while((line = br.readLine())!=null){
                    sb.append(line);
                }
                map.put(name,sb.toString());
            }
            br.close();
            zipFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  map;
    }


    /**
     * 将MultipartFile转换为zipFile，用断言过滤
     * @param inFile
     */
    public void checkZip(MultipartFile inFile) {
        InputStream fileStream = null;
        File file = null;
        ZipFile zipFile = null;
        //临时文件

        Path path = Paths.get(System.getProperty("java.io.tmpdir"), inFile.getName() + UUID.randomUUID() + "zip");
        file = path.toFile();
        try {
            fileStream = inFile.getInputStream();
            org.apache.commons.io.FileUtils.copyInputStreamToFile(fileStream, file);
            zipFile = new ZipFile(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                fileStream.close();
                zipFile.close();
                //删除临时文件
                org.apache.commons.io.FileUtils.deleteQuietly(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}
