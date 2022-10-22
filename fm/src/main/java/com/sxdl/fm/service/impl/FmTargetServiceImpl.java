package com.sxdl.fm.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.fm.entity.FmTarget;
import com.sxdl.fm.service.FmTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FmTargetServiceImpl extends BaseServiceImpl<FmTarget> implements FmTargetService {

}
