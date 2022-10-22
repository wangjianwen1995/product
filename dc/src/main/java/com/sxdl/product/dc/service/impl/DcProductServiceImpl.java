package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcProductDao;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.service.DcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("dcProductService")
@Transactional
public class DcProductServiceImpl extends BaseServiceImpl<DcProduct> implements DcProductService {
    @Autowired
    private DcProductDao dcProductDao;

    @Override
    public List<DcProduct> selectByExample(DcProduct product) {
        Class<? extends Object> class1 = product.getClass();
        Example example = new Example(class1);
        String name = product.getName();
        if (StringUtil.isNotEmpty(name)) {
            example.or().andLike("name_zh", "%" + name + "%");
            example.or().andLike("short_name", "%" + name + "%");
            example.or().andLike("short_name_zh", "%" + name + "%");
            return dcProductDao.selectByExample(example);
        }
        return dcProductDao.selectAll();

    }

    @Override
    public List<DcProduct> selectByIds(String ids) {
        return dcProductDao.selectBYIds(ids);
    }

}
