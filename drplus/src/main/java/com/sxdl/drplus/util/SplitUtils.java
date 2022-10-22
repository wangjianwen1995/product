package com.sxdl.drplus.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitUtils {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3");
        List<List<String>> lists = splitList(list, 5);


        System.out.println(lists);

        Map<Integer,String> map =new HashMap<>();
        for (int i1 = 0; i1 < 56; i1++) {
            map.put(i1,"w"+i1);
        }


        List<Map<Integer, String>> maps = splitMap(map, 5);
        System.out.println(maps);


    }

    public static<T> List<List<T>> splitList(List<T> list,Integer splitNum) {
        //集合大小
        BigDecimal aBig = new BigDecimal(list.size());
        //每一份数据分成多大
        BigDecimal bBig = new BigDecimal(splitNum);
        //向上取整
        int num1 = (int)Math.ceil(aBig.divide(bBig).doubleValue());

        List<List<T>> splitList = Stream.iterate(0, n->n+1).limit(num1).parallel().map(a->{
            return list.stream().skip(a*splitNum).limit(splitNum).parallel().collect(Collectors.toList());
        }).collect(Collectors.toList());

        return splitList;
    }


    /**
     * Map拆分 (指定分组大小)
     * @param map Map
     * @param chunkSize 每个分组的大小 (>=1)
     * @param <K> lKey
     * @param <V> Value
     * @return 子Map列表
     */
    public static <K,V> List<Map<K,V>> splitMap(Map<K,V> map, int chunkSize){
        if(StringUtils.isEmpty(map)  || chunkSize<1){
            //空map或者分组大小<1，无法拆分
            return Collections.emptyList();
        }

        int mapSize = map.size(); //键值对总数
        int groupSize = mapSize/chunkSize + (mapSize%chunkSize==0?0:1); //计算分组个数
        List<Map<K,V>> list = Lists.newArrayListWithCapacity(groupSize); //子Map列表

        if(chunkSize >= mapSize){ //只能分1组的情况
            list.add(map);
            return list;
        }

        int count = 0; //每个分组的组内计数
        Map<K,V> subMap = Maps.newHashMapWithExpectedSize(chunkSize); //子Map

        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (count < chunkSize) {
                //给每个分组放chunkSize个键值对，最后一个分组可能会装不满
                subMap.put(entry.getKey(), entry.getValue());
                count++; //组内计数+1
            } else {
                //结束上一个分组
                list.add(subMap); //当前分组装满了->加入列表

                //开始下一个分组
                subMap = Maps.newHashMapWithExpectedSize(chunkSize); //新的分组
                subMap.put(entry.getKey(), entry.getValue()); //添加当前键值对
                count = 1; //组内计数重置为1
            }
        }

        list.add(subMap);  //添加最后一个分组
        return list;
    }
}
