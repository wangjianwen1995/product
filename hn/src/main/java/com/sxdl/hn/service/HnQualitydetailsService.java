package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HnQualitydetailsDao;
import com.sxdl.hn.entity.HnQualitydetails;
import com.sxdl.hn.util.HNApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


//护理质量考核细目
@Service
@Transactional
public class HnQualitydetailsService extends BaseServiceImpl<HnQualitydetails> {


    @Autowired
    private HnQualitydetailsDao detailsDao;

    public Integer insertCache(HnQualitydetails hnQualitydetails){
        Integer insert = insert(hnQualitydetails);
        //数据直接追加
        Integer suborder_id = hnQualitydetails.getSuborder_id();
        if(HNApplicationRunnerImpl.detailsMap.containsKey(suborder_id)){ //存在就追加到存在的key中的val中
            HNApplicationRunnerImpl.detailsMap.get(suborder_id).add(hnQualitydetails);
        }else {//不存在就 创建一个key 然后再key中添加val
            List<HnQualitydetails> list = new ArrayList<>();
            list.add(hnQualitydetails);
            HNApplicationRunnerImpl.detailsMap.put(suborder_id,list);
        }
        return insert;
    }


    public Integer updateCache(HnQualitydetails hnQualitydetails){
        Integer suborder_id = hnQualitydetails.getSuborder_id();
        Integer update = update(hnQualitydetails);
        for (int i = 0; i < HNApplicationRunnerImpl.detailsMap.get(suborder_id).size(); i++) {
            if(HNApplicationRunnerImpl.detailsMap.get(suborder_id).get(i).getId().equals(hnQualitydetails.getId())) {
                HNApplicationRunnerImpl.detailsMap.get(suborder_id).set(i, hnQualitydetails);
            }
        }
        return update;
    }


    @Deprecated
    public Integer eableDisable(String ids, Integer state,Integer type){
        Integer insert = null;
        if(type>-1){
            String sql = "update quality_details set state="+state+" where id in(  "+ids+" )";
            insert = updateSqlWithSQL(sql);
            List<String> list = Arrays.asList(ids.split(","));
            list.forEach(e->{
                for (int i = 0; i < HNApplicationRunnerImpl.detailsMap.get("details").size(); i++) {
                    if(HNApplicationRunnerImpl.detailsMap.get("details").get(i).getId().equals(Integer.valueOf(e))) {
                        HNApplicationRunnerImpl.detailsMap.get("details").get(i).setState(state);
                    }
                }
            });
        }else {
            String sql = "update quality_details set state="+state+" where id = "+ids ;
            insert = updateSqlWithSQL(sql);
            for (int i = 0; i < HNApplicationRunnerImpl.detailsMap.get("details").size(); i++) {
                if(HNApplicationRunnerImpl.detailsMap.get("details").get(i).getId().equals(Integer.valueOf(ids))) {
                    HNApplicationRunnerImpl.detailsMap.get("details").get(i).setState(state);
                }
            }
        }
        return insert;
    }


    public Integer delCache(Integer id,Integer suborder_id){
        Integer delete = deleteById(id);
        Iterator<HnQualitydetails> iterator = HNApplicationRunnerImpl.detailsMap.get(suborder_id).iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals(id))
                iterator.remove();
        }
        return delete;
    }


}
