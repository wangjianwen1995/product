package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusControlLjxDao;
import com.sxdl.drplus.dto.DrQualityDBO;
import com.sxdl.drplus.entity.DrPlusControlLjx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DrPlusControlLjxService extends BaseServiceImpl<DrPlusControlLjx> {



    @Autowired
    private DrPlusControlLjxDao ljxDao;


    public List<DrPlusControlLjx> getLjxData(Object pid, Object val) {
        return ljxDao.getLjxData(convert(pid,Integer.class),convert(val,String.class));
    }

    public void saveQualityData(DrQualityDBO qualityDBO) {
        DrPlusControlLjx drPlusControlLjx = new DrPlusControlLjx();
        drPlusControlLjx.setDrplus_platform_detailed_id(qualityDBO.getDrplus_platform_detailed_id());
        drPlusControlLjx.setClassify(qualityDBO.getClassify());
        drPlusControlLjx.setSql(qualityDBO.getSql());
        drPlusControlLjx.setResult_message(qualityDBO.getResult_message());
        drPlusControlLjx.setTermlevel(qualityDBO.getTermlevel());
        drPlusControlLjx.setCreate_time(qualityDBO.getCreate_time());
        drPlusControlLjx.setField_name(qualityDBO.getField_name());
        drPlusControlLjx.setBelong(qualityDBO.getBelong());
        drPlusControlLjx.setIsqy(qualityDBO.getIsqy());
        if(StringUtils.isEmpty(qualityDBO.getId())){
            int insert = ljxDao.insert(drPlusControlLjx);
        }else{
            drPlusControlLjx.setId(qualityDBO.getId());
            int insert = ljxDao.updateByPrimaryKey(drPlusControlLjx);
        }

    }

    public void delData(Integer id) {
        int i = ljxDao.deleteByPrimaryKey(id);

    }
}
