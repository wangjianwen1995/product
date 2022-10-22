package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusControlWzxDao;
import com.sxdl.drplus.dto.DrQualityDBO;
import com.sxdl.drplus.entity.DrPlusControlWzx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DrPlusControlWzxService extends BaseServiceImpl<DrPlusControlWzx> {

    @Autowired
    private DrPlusControlWzxDao wzxDao  ;

    public List<DrPlusControlWzx> getWzxData(Object pid, Object val) {
        return wzxDao.getWzxData(convert(pid,Integer.class),convert(val,String.class));
    }

    public void saveQualityData(DrQualityDBO qualityDBO) {
        DrPlusControlWzx drPlusControlWzx = new DrPlusControlWzx();
        drPlusControlWzx.setDrplus_platform_detailed_id(qualityDBO.getDrplus_platform_detailed_id());
        drPlusControlWzx.setClassify(qualityDBO.getClassify());
        drPlusControlWzx.setSql(qualityDBO.getSql());
        drPlusControlWzx.setResult_message(qualityDBO.getResult_message());
        drPlusControlWzx.setTermlevel(qualityDBO.getTermlevel());
        drPlusControlWzx.setCreate_time(qualityDBO.getCreate_time());
        drPlusControlWzx.setField_name(qualityDBO.getField_name());
        drPlusControlWzx.setBelong(qualityDBO.getBelong());
        drPlusControlWzx.setIsqy(qualityDBO.getIsqy());
        if(StringUtils.isEmpty(qualityDBO.getId())){
            int insert = wzxDao.insert(drPlusControlWzx);
        }else{
            drPlusControlWzx.setId(qualityDBO.getId());
            int insert = wzxDao.updateByPrimaryKey(drPlusControlWzx);
        }

    }

    public void delData(Integer id) {
        int i = wzxDao.deleteByPrimaryKey(id);

    }
}
