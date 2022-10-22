package com.sxdl.product.dc.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcDictMapDao;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcDictMap;
import com.sxdl.product.dc.service.DcDictMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class DcDictMapServiceImpl extends BaseUUIDServiceImpl<DcDictMap> implements DcDictMapService {

    @Autowired
    private DcDictMapDao dictMapDao;

    public List<DcDictMap> findDataByHisCodeAndColId(String his_code, String col_id) {
        return  dictMapDao.findDataByHisCodeAndColId(his_code,col_id);
    }

    /**
     * 处理his到病案中的数据字典转换
     * @param map
     * @param hiscode
     * @return
     */
    List<DcDictMap> hpDictMaps;
    Map<String, List<DcDictMap>> collect;
    //TODO 其实这里可以考虑一下需不需要添加一个入参 表名称,防止不同表中的字段一样 那就尴了个尬了
    public Map<String, Object> operationMappingDictData(Map<String, Object> map,String hiscode){
        //1 查询出所有 hisiseanble 启用的字典转换数据
        hpDictMaps = dictMapDao.findDataByHisEnableAndHisCodeData(hiscode);
        //根据hp字段名称分组
        collect = hpDictMaps.stream().collect(Collectors.groupingBy(e -> e.getDc_column_name()));
        for(String key:collect.keySet()){
            if(!map.containsKey(key)||null==map.get(key)||StrUtil.isEmpty(map.get(key).toString())){
                continue;
            }
            //遍历该key分组里的列表
            for(DcDictMap e:collect.get(key)){
                if(null!=e.getHis_key()){
                    if(e.getHis_key().equals(map.get(key).toString().trim())){
                        map.put(key,e.getDc_key());
                        break;
                    }
                }
            }
        }
        return map;
    }
    public Map<String, Object> operationMappingDictDataAtoa(Map<String, Object> map,String hiscode){
        //1 查询出所有 hisiseanble 启用的字典转换数据
        List<DcDictMap> hpDictMaps = dictMapDao.findDataByHisEnableAndHisCodeData(hiscode);
        Map<String, List<DcDictMap>> collect = hpDictMaps.stream().collect(Collectors.groupingBy(e -> e.getDc_column_name()));
        /*
        缓存中获取数据
        * List<SysDictTable>  dcDitTableList2 = (List<SysDictTable>) HpApplicationRunnerImpl.contextMap.get("dcDitTableList");
        * */
        collect.forEach((key,val)->{
            val.forEach(e->{
                if(StringUtil.isNotEmpty(e.getHis_key())){
                    if(e.getHis_key().equals(map.get(StrUtil.lowerFirst(key)))){
                        map.put(key,e.getDc_key());
                    }
                }

            });
        });
        return map;
    }

    public Integer save(DcColumn dcColumn) {
        //先根据his_code 和 column_id 删除对映的数据,然后一次性的保存
        Integer del =0;
        if(null!=dcColumn){
           del = dictMapDao.deleteByHisCodeAndColId(dcColumn.getHis_code(),dcColumn.getId());
           //List<DcDictMap> dictMaps = dcColumn.getDcDictMaps();
//           if(CollUtil.isNotEmpty(dictMaps)){
//               for (DcDictMap dcDictMap : dictMaps) {
//                   dictMapDao.insert(dcDictMap);
//               }
//           }
        }
        return del;
    }

}
