package com.sxdl.cf.util;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    private static final String FILENAME="tableCU.sql";


    public static final  ConcurrentSkipListMap<String, Object> allData = new ConcurrentSkipListMap();
    public static final String path = System.getProperty("user.dir")+ File.separator+"files"+File.separator+"CustomerFormFile";

    /**
     * 图片转换成Base64 数据 ,
     *  1 格式分别是data:图片类型 ; 编码类型, data字符串数据
     *  2 放到浏览器地址栏回车
     *  3 例如: data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAAAaCAIAAACvsEzwAAABxElEQVR42tWYS2rDMB......
     * @param filepaht
     * @return
     */
    public static String TransformPhotoToBase64Data(String filepaht){
        Base64.Encoder encoder= Base64.getEncoder();  //获取Base64编码器
        byte [] ImgContainer = null ;    //数据集缓存器
        FileInputStream fileInputStream = null; //文件输入流
        try {
            System.out.println(filepaht);
            fileInputStream = new FileInputStream(filepaht);    //到指定路径寻找文件
            ImgContainer = new byte[fileInputStream.available()];          //设置图片字节数据缓冲区大小
            fileInputStream.read(ImgContainer);           //将数据流中的图片数据读进缓冲区
            String Base64ImgData =encoder.encodeToString(ImgContainer);  //将图片编码转换成Base64格式的数据集
            fileInputStream.close();      //关闭数据流
            return Base64ImgData;  //将缓冲区数据转换成字符数据返回
        } catch (FileNotFoundException e) {
            return "找不到指定文件!";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "null";
    }

    public static void main(String[] args) throws Exception {

        ReentrantLock lock = new ReentrantLock();
        int[] zuo={1,3,5};
        lock.lock();
        try {
            for (int i = 0; i <= zuo.length-1; i++) {
                for (int j = 0; j <= zuo.length-i-1; i++) {
                    if(zuo[i]>zuo[j+1]){
                        int you = zuo[j];
                        zuo[j] = zuo[j+1];
                        zuo[j+1] = you;
                    }
                }
            }

            System.out.println(zuo[0] );
            System.out.println(zuo[1] );
            System.out.println(zuo[2] );
        }catch (Exception e){
            throw new RuntimeException("线程异常:"+e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    public synchronized static void init() throws IOException {
        if (new File(path).listFiles()!=null){
            for (File file : Objects.requireNonNull(new File(path).listFiles())) {
                if(file.isFile()){
                    if(!file.getName().contains("删除")){
                        String data = ReaderToString(new File(path + File.separator + file.getName()));
                        allData.put(file.getName(), StringUtils.isEmpty(data)?"":data);
                    }
                }
            }
        }
        System.out.println(">>>>>>>>>>拦截器初始化完成<<<<<<<<<<");
    }

    public static String ReaderToString(File file) throws  IOException{
        StringBuilder sb  = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }


    public static String getSqlText() throws Exception{
        StringBuilder sb = new StringBuilder();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(FILENAME);
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        return sb.toString();
    }



    public static void bufferedWriterToFile(String path,String str) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path),false),"UTF-8"));
        bw.write(new String(str.getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
    }



    /**
     * 创建文件
     * @param filePath
     * @throws IOException
     */
    public static void createFile(String filePath) throws IOException {
        File  file = new File(filePath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if (!file.exists()){
            file.createNewFile();
        }

    }


    public static boolean existesFile(String filePath){
        File  file = new File(filePath);
        return file.exists();
    }

    /**
     * 将文件打包成zip 压缩文件
     * @param outputStream
     * @param file  要压缩的文件
     */
    public static void doZip(OutputStream outputStream, File file){

        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(outputStream);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(file);
            while ((len = in.read(buf)) != -1) {
                zipOutputStream.write(buf, 0, len);
                zipOutputStream.flush();
            }

            zipOutputStream.flush();
            zipOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {

                if (zipOutputStream != null ) {
                    zipOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     *
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
                zipEntry = new ZipEntry(srcFiles.get(i).getName());
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





}
