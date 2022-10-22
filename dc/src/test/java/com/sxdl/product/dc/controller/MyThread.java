package com.sxdl.product.dc.controller;


import com.sxdl.product.dc.MainTest;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 线程测试
 */
public class MyThread  extends MainTest implements  Runnable {

    private  int count=10;
    @SneakyThrows
    @Override
    public void run() {
        count--;
        URL myURL = null;
        URLConnection httpsConn = null;
        myURL = new URL("http://localhost:8080//dcjob/fingAllJob");
        httpsConn = (URLConnection) myURL.openConnection();
        InputStreamReader insr = null;
        insr = new InputStreamReader(
                httpsConn.getInputStream(), "UTF-8");
        BufferedReader br = new BufferedReader(insr);
        String dataStr = br.readLine();
        System.out.println("线程： "+Thread.currentThread().getName());
    }
}
