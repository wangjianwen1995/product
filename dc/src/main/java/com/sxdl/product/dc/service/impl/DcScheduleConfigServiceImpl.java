package com.sxdl.product.dc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcProductDao;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.entity.DcScheduleConfig;
import com.sxdl.product.dc.service.DcScheduleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("dcScheduleConfigService")
@Transactional
public class DcScheduleConfigServiceImpl extends BaseUUIDServiceImpl<DcScheduleConfig> implements DcScheduleConfigService {

    @Autowired
    private com.sxdl.product.dc.dao.dao1.DcScheduleConfigDao dcScheduleConfigDao;

    @Autowired
    private DcProductDao dcProductDao;


    @Override
    public List<DcScheduleConfig> findData(String flag) {
        /*if(StringUtil.isNotEmpty(flag)&&"单抽".equals(flag)){
            flag="where isnull(support_single,0)=1";
        }else{
            flag=" ";
        }*/
        flag=" ";
        return dcScheduleConfigDao.findData(flag);
    }

    @Override
    public List<DcScheduleConfig> selectCanAutoRun(String info) {

        return dcScheduleConfigDao.selectCanAutoRun(info);
    }

    @Override
    public List<DcScheduleConfig> selectByProduct(String id) {
        return  dcScheduleConfigDao.selectByProduct(id);
    }

    @Override
    public List<DcScheduleConfig> findPzProduct() {
        return  dcScheduleConfigDao.findPzProduct();
    }
 @Override
    public void insertOrupdate(Map<String, Object> map) {
        String id = map.get("id").toString();
        int isSingle=1;//默认是自动调度
        if(map.containsKey("is_single")){
            isSingle= Integer.parseInt(map.get("is_single").toString());
        }

        // 删除之前的配置，重新插入--意思就是每次配置都是删掉重新插入
        DcScheduleConfig configs =new DcScheduleConfig();
        configs.setProduct_id(id);
        if(isSingle==2)  configs.setSingle_id(map.get("single_id").toString());
        configs.setIs_single(isSingle);
        dcScheduleConfigDao.delete(configs);

        DcProduct byId=new DcProduct();
        if(StringUtil.isNotEmpty(id)){
            byId = dcProductDao.selectByPrimaryKey(id);
        }
        List<DcScheduleConfig> list = JSONArray.parseArray(JSONArray.toJSONString(map.get("list")), DcScheduleConfig.class);

        int ordernum=0;

        for (DcScheduleConfig config : list) {
            config.setId(null);
            config.setProduct_id(id);
            config.setProduct_name(byId.getName_zh());
            if(isSingle==2){
                config.setSingle_id(map.get("single_id").toString());
            }
            config.setIs_single(isSingle);
            config.setOrdernum(ordernum);
            dcScheduleConfigDao.insert(config);
            ordernum++;
            for (DcScheduleConfig child : config.getChildren()) {
                child.setId(null);
                child.setProduct_id(id);
                child.setProduct_name(byId.getName_zh());
                if(isSingle==2){
                    child.setSingle_id(map.get("single_id").toString());
                }
                child.setIs_single(isSingle);
                child.setOrdernum(ordernum);
                dcScheduleConfigDao.insert(child);
                ordernum++;
            }
        };
    }

    @Override
    public List<DcScheduleConfig> selectBySingleId(String ids,String column,Integer is_single) {

        return  dcScheduleConfigDao.selectBySingleId(ids,column,is_single);
    }

    @Override
    public List<DcScheduleConfig> selectSort(String id, String singleId) {
        return dcScheduleConfigDao.selectSort(id,singleId);
    }
}


