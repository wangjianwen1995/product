package com.sxdl.fm.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.fm.entity.HbiTlfgzlzb;
import com.sxdl.fm.util.app.FmAllTwenty;

import java.util.List;

public interface HbiTlfgzlzbService extends BaseService<HbiTlfgzlzb> {

    void insertSome(List<FmAllTwenty> list, String time);
}
