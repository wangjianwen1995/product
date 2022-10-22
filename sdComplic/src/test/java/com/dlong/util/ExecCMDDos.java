package com.dlong.util;

import java.io.IOException;

public class ExecCMDDos {


    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("ping www.baidu.com");
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
