package com.sxdl.hpqc.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hpqc.dao.dao1.DrPlusControlBzxDao;
import com.sxdl.hpqc.dbo.DrQualityDBO;
import com.sxdl.hpqc.entity.DrPlusControlBzx;
import com.sxdl.hpqc.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DrPlusControlBzxService extends BaseServiceImpl<DrPlusControlBzx> {


    @Autowired
    private DrPlusControlBzxDao bzxDao;



    public List<DrPlusControlBzx> getBzxData(Object pid,Object val) {
        return bzxDao.getBzxData(convert(pid,Integer.class),convert(val,String.class));
    }

    public void saveQualityData(DrQualityDBO qualityDBO) {
        DrPlusControlBzx drPlusControlBzx = new DrPlusControlBzx();
        drPlusControlBzx.setDrplus_platform_detailed_id(qualityDBO.getDrplus_platform_detailed_id());
        drPlusControlBzx.setClassify(qualityDBO.getClassify());
        drPlusControlBzx.setSql(qualityDBO.getSql());
        drPlusControlBzx.setResult_message(qualityDBO.getResult_message());
        drPlusControlBzx.setTermlevel(qualityDBO.getTermlevel());
        drPlusControlBzx.setCreate_time(DataUtil.getDateTime());
        drPlusControlBzx.setField_name(qualityDBO.getField_name());
        drPlusControlBzx.setBelong(qualityDBO.getBelong());
        drPlusControlBzx.setIsqy(qualityDBO.getIsqy());
        if(StringUtils.isEmpty(qualityDBO.getId())){
            int insert = bzxDao.insert(drPlusControlBzx);
        }else{
            drPlusControlBzx.setId(qualityDBO.getId());
            int insert = bzxDao.updateByPrimaryKey(drPlusControlBzx);
        }

    }

    public void delData(Integer id) {

        int i = bzxDao.deleteByPrimaryKey(id);
    }
}
