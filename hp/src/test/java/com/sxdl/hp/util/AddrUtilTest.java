package com.sxdl.hp.util;

import com.sxdl.hp.HpMainTest;
import com.sxdl.hp.entity.HpAreaZip;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class AddrUtilTest extends HpMainTest {
    @Test
    public void t(){
        List<String> addresses = new ArrayList<>();
//        addresses.add("北京市朝阳区国家会议中心");
//        addresses.add("北京朝阳区");
//        addresses.add("广东省深圳市南山区深云村");
//        addresses.add("深圳市南山区南山大道光大村");
//        addresses.add("朝阳区啦啦队");
//        addresses.add("上海市真华路XX弄XX号XXX室");
//        addresses.add("天津市汉沽区明城北岸XXX");
//        addresses.add("广东省开平市新昌新安路XXXX");
//        addresses.add("湖南省郴州市临武县舜峰镇两路交叉口");
//        addresses.add("广东省广州市六运X街X号XXX");
//        addresses.add("广东省广州市黄浦区测试小区2栋");
//        addresses.add("山西省太原市小店区亲凤苑北区");
//        addresses.add("山西省临猗县牛杜工贸区姚村第六居民组");
//        addresses.add("山西省运城市绛县1234567");
        addresses.add("山西省运城市新绛县7654321");

        AddressUtil au=new AddressUtil();
        for(String e:addresses){
            Map map = au.addrResolut(e);
            if(null==map.get("area")){
                System.out.println(e+"    "+"地址不合适");
            }else{
                System.out.println(e+"    "+map);
            }
        }
    }
    @Test
    public void tt(){
        List<HpAreaZip> hpAreaZips = (List<HpAreaZip>) HpApplicationRunnerImpl.contextMap.get("areaZip");
        Map<String, List<HpAreaZip>> xians = hpAreaZips.stream().filter(e -> e.getGrade() == 4).collect(Collectors.groupingBy(HpAreaZip::getName));
        Map<String, List<HpAreaZip>> xianall = hpAreaZips.stream().filter(e -> e.getGrade() == 4).collect(Collectors.groupingBy(HpAreaZip::getName));
        AtomicReference<Integer> i= new AtomicReference<>(0);
        xians.forEach((k,v)->{
            xianall.forEach((k1,v1)->{
                if(k1.contains(k)&&!k.equals(k1)){
                    for(HpAreaZip e:v){
                        for(HpAreaZip e1:v1){
//                            if(e1.getShi().equals(e.getShi())){
                                System.out.println(i+e.getXian()+"  "+e1.getXian()+"  "+e.getShi()+"  "+e1.getShi()+"  "+e.getFullname()+"    "+e1.getFullname());
                                i.getAndSet(i.get() + 1);
//                            }

                        }
                    }
//                    System.out.println(v1.toString()+v);
                    System.out.println();
                }
            });
        });
    }
}
