package com.sxdl.drplus;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SingTest {


    @Test
    public void test1(){

        HttpResponse execute = HttpRequest.get("http://192.168.248.1:23308/sys/scheduleTask/ssss").execute();
        System.out.println(execute.getStatus());
        System.out.println(execute);

    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("启动服务器....");
            Socket s = ss.accept();
            System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");

           // TimeUnit.SECONDS.sleep(10);
            int p  = 1/0;
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //读取客户端发送来的消息

            s.shutdownInput();

        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

}
