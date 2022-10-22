package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HnQualityCategoryDao;
import com.sxdl.hn.dao.dao1.HnQualitySuborderDao;
import com.sxdl.hn.entity.HnQualityCategory;
import com.sxdl.hn.entity.HnQualitySuborder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//护理质量考核类目
@Service
@Transactional
public class HnQualityCategoryService   extends BaseServiceImpl<HnQualityCategory> {

    @Autowired
    private HnQualityCategoryDao categoryDao;

    @Autowired
    private HnQualitySuborderDao suborderDao;

   /* @Autowired
    private HNApplicationRunnerImpl runner;*/

    /**
     * 判断类目下是否存在亚目
     * @param id 如题

     */
    public boolean deleteByidExistschil(Integer id) {
       boolean fals = false;
       List<HnQualitySuborder> suborders =  suborderDao.selectBypid(id);
       if (suborders.size()>0){
           fals=false;
       }else{
           int i = categoryDao.deleteByPrimaryKey(id);

           fals= true;
       }
       return fals;

    }


/*    public Integer insertCache(HnQualityCategory category){
        int insert = categoryDao.insert(category);
        runner.setLmYm();
        return insert;
    }


    public Integer updateCache(HnQualityCategory category){
        int i = categoryDao.updateByPrimaryKey(category);
        runner.setLmYm();
        return i;
    }*/
}

