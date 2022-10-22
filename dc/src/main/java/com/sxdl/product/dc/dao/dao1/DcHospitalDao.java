package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcHospital;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcHospitalDao extends BaseUUIDDao<DcHospital> {

    @Select(value="select * from dc_hospital where name like #{0}")
    List<DcHospital> getByName(String s);
}