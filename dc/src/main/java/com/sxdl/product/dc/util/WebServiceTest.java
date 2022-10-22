package com.sxdl.product.dc.util;


import com.sxdl.product.dc.entity.DcJob;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class WebServiceTest {


    @WebMethod(operationName="fingAll")
    public List<DcJob> fingAll(){
        List<DcJob> list = new ArrayList<>();
        DcJob dcJob = new DcJob();
        dcJob.setName("143");
        dcJob.setUserName("骨科");
        dcJob.setId("1");
        list.add(dcJob);
        dcJob = new DcJob();
        dcJob.setName("176");
        dcJob.setUserName("神经内科");
        dcJob.setId("2");

        list.add(dcJob);
        dcJob = new DcJob();
        dcJob.setName("156");
        dcJob.setUserName("疼痛科");
        dcJob.setId("3");
        list.add(dcJob);

        dcJob = new DcJob();
        dcJob.setName("158");
        dcJob.setUserName("院感科");
        dcJob.setId("4");
        list.add(dcJob);

        dcJob = new DcJob();
        dcJob.setName("160");
        dcJob.setUserName("病案室");
        dcJob.setId("5");
        list.add(dcJob);
        return list;
    }

    @WebMethod(operationName="getByid")
    public List<DcJob> getByid(String blh){
        List<DcJob> list = new ArrayList<>();
        DcJob dcJob = new DcJob();
        dcJob.setName("1322");
        dcJob.setUserName("张三");
        dcJob.setId("1");
        list.add(dcJob);
        dcJob = new DcJob();
        dcJob.setName("1244");
        dcJob.setUserName("李四");
        dcJob.setId("2");

        list.add(dcJob);
        dcJob = new DcJob();
        dcJob.setName("1584");
        dcJob.setUserName("王五");
        dcJob.setId("3");
        list.add(dcJob);
        return list;
    }

    @WebMethod(operationName="getByTime")
    public List<DcJob> getByTime(String stime,String etime){
        List<DcJob> list = new ArrayList<>();
        DcJob dcJob = new DcJob();
        dcJob.setName("巴斯巴");
        dcJob.setUserName("22222");
        dcJob.setProductName("2020-05-01");
        dcJob.setId("1");
        list.add(dcJob);
        dcJob = new DcJob();
        dcJob.setName("手术室");
        dcJob.setUserName("44444");
        dcJob.setProductName("2020-05-02");
        dcJob.setId("2");

        list.add(dcJob);
        dcJob = new DcJob();
        dcJob.setName("似懂非懂");
        dcJob.setUserName("66666");
        dcJob.setProductName("2020-05-05");
        dcJob.setId("3");
        list.add(dcJob);
        return list;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://192.168.66.11:8081/WebServiceTest/fingAll", new WebServiceTest());
        System.out.println("接口发布成功");
    }


}
