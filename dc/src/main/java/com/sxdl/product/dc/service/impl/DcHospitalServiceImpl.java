package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.entity.DcHospital;
import com.sxdl.product.dc.service.DcHospitalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dcHospitalService")
@Transactional
public class DcHospitalServiceImpl extends BaseUUIDServiceImpl<DcHospital> implements DcHospitalService {

}
