package com.dlong.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ExecCMDDos {

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("回车继续");
        String timeday = input.nextLine();
        System.out.println("xxx开始执行...");
        timeday = input.nextLine();
        System.out.println("结束");


    }

    //执行jar包的动态编译
    public static void execCMDAll(){
        //替换
        execCMD("javac -encoding UTF-8  -Djava.ext.dirs=./lib -d   ./BOOT-INF/classes  ./entity/*.java");
        System.out.println("报告: class文件编译完成");
        //替换class文件
        execCMD("jar uf ./lib/sd.jar ./BOOT-INF/classes/com/sxdl/sd/entity/*.class");
        System.out.println("报告: JAR包更新class完成");
        //C:\Users\HP\Desktop\dbz\BOOT-INF\classes\static\sd\drgs
        execCMD("jar uf ./lib/sd.jar ./BOOT-INF/classes/static/sd/drgs/*.html");
        System.out.println("报告: JAR包更新drgs下的josn文件完成");
        //TODO 这块js 文件 json /html 文件的路径注意下,我这里先 暂时这样
        execCMD("jar uf ./lib/sd.jar ./BOOT-INF/classes/static/sd/js/*.json");
        System.out.println("报告: JAR包更新drgs下的josn文件完成");
        //TODO 这块js 文件 json /html 文件的路径注意下,我这里先 暂时这样
        execCMD("jar uf ./lib/sd.jar ./BOOT-INF/classes/static/sd/js/*.json");
        System.out.println("报告: JAR包更新drgs下的josn文件完成");

    }

    public static void execCMD(String dosStr){
        try {
            Process process = Runtime.getRuntime().exec(dosStr);
            new CleanInputCache(process.getInputStream(),"INFO").start();
            new CleanInputCache(process.getErrorStream(),"ERROR").start();
            process.waitFor();
            System.out.println("任务执行完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
