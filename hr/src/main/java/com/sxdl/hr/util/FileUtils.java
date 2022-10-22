package com.sxdl.hr.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils{
    /**
     * 压缩文件
     *
     * @param sourceFilePath 源文件路径
     * @param zipFilePath    压缩后文件存储路径
     * @param zipFilename    压缩文件名
     */
    public static void compressToZip(String sourceFilePath, String zipFilePath, String zipFilename) {
/*
       File[] files = sourceFile.listFiles();
*/
        File zipPath = new File(zipFilePath);
        try {
            String  zipName =zipFilePath+"\\"+zipFilename;
            ZipOutputStream out= new ZipOutputStream(new FileOutputStream((zipName)));


            File sourceFile = new File(sourceFilePath);
            compress(out,sourceFile,sourceFile.getName());


            out.close();
            System.out.print("压缩完成！");
            //文件压缩完成后，删除被压缩文件
            //  boolean flag = deleteDir(sourceFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }



    /**
     * 遍历所有文件，压缩
     *
     * @param srcfile       源文件目录
     * @param zipfile 压缩文件目录
     */
    public static void compress(ZipOutputStream out,File sourceFile,String base)throws  Exception{
        try {
            if(sourceFile.isDirectory()){
                File[] flist = sourceFile.listFiles();

                if(flist.length==0){
                    out.putNextEntry( new ZipEntry(base+"/"));
                }else{
                    for(int i=0;i<flist.length;i++){
                        compress(out,flist[i],base+"/"+flist[i].getName());
                    }
                }
            }else {
                out.putNextEntry(new ZipEntry(base));
                FileInputStream fos = new FileInputStream(sourceFile);
                BufferedInputStream bis = new BufferedInputStream(fos);

                int tag;
                while ((tag = bis.read()) != -1)
                {
                    out.write(tag);
                }
                bis.close();
                fos.close();
            }


            /*//ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream zipos=new ZipOutputStream(new FileOutputStream(zipfile));
            BufferedOutputStream bos= new BufferedOutputStream(zipos);

            for(File file:srcfile){
                ZipEntry entry = new ZipEntry(file.getName());
                zipos.putNextEntry(entry);
                FileInputStream fos=new FileInputStream(file);
               BufferedInputStream bis = new BufferedInputStream(fos);
               int tag;
               while ((tag=bis.read()) !=-1)
               {
                   bos.write(tag);
               }
               bis.close();
               fos.close();
            }
            zipos.close();*/
            System.out.println("压缩完成.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 删除文件夹
     *
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        //删除空文件夹
        return dir.delete();
    }
}

