package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.dao.dao1.HnQualitySuborderDao;
import com.sxdl.hn.dao.dao1.HnQualitydetailsDao;
import com.sxdl.hn.entity.HnQualitySuborder;
import com.sxdl.hn.entity.HnQualitydetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//护理质量考核亚目
@Service
@Transactional
public class HnQualitySuborderService extends BaseServiceImpl<HnQualitySuborder> {

    @Autowired
    private HnQualitySuborderDao suborderDao;

    @Autowired
    private HnQualitydetailsDao detailsdao;

    @Autowired
    private HnHandleDao hnHandleDao;

    public List<HnQualitySuborder> findSuborderByCategoryid(Integer pid) {
        return  suborderDao.selectBypid(pid);
    }


    public boolean delSuborder(Integer id) {
        List<HnQualitydetails> qualitydetails = detailsdao.findBySuborderId(id);
        boolean flag=false;
        if (qualitydetails.size()>0){
            flag=false;
        }else {
            int i = suborderDao.deleteByPrimaryKey(id);
            flag = true;
        }
        return flag;

    }

}
