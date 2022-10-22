package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcTransfer;

public interface DcTransferService extends BaseService<DcTransfer> {

    String findInfo(String name, String fromType, String fromUrl, String username, String pwd,String linkStr);

    void deleteServerLink(String sql);
}
