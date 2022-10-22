package com.sxdl.product.dc;

import com.sxdl.product.dc.entity.DcSchedule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T {
    @Test
    public  void testGroup(){
        List<DcSchedule> dcSchedules =new ArrayList<>();
        DcSchedule ds=new DcSchedule();
        ds.setOrdernum(1);
        ds.setType_id(1);
        dcSchedules.add(ds);

        ds=new DcSchedule();
        ds.setOrdernum(2);
        ds.setType_id(2);
        dcSchedules.add(ds);

        ds=new DcSchedule();
        ds.setOrdernum(3);
        ds.setType_id(2);
        dcSchedules.add(ds);
        dcSchedules.sort(Comparator.comparing(DcSchedule::getOrdernum));
        Map<Integer, List<DcSchedule>> collect = dcSchedules.stream().collect(Collectors.groupingBy(DcSchedule::getType_id));

        collect.forEach((k,v)->{
            v.forEach(e-> System.out.println(e.getOrdernum()+"  "+e.getType_id()));
        });
    }
    @Test
    public void tt(){
        int i=1;
        i-=2;
        System.out.println(i);
    }
    @Test
    public void testTime(){
        try {
            for(int i=0;i<5;i++){
                s1(i);
                s2(i);
            }
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }
    public void s1(int a) throws InterruptedException {
        System.out.println(1+" start "+a);
        Thread.sleep(1000);
        System.out.println(1+" end "+a);
    }
    public void s2(int a) throws InterruptedException {
        System.out.println(2+" start "+a);
        Thread.sleep(1000);
        System.out.println(2+" end "+a);
    }
}
