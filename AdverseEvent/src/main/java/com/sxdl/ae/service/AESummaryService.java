package com.sxdl.ae.service;


import com.sxdl.ae.dao.dao1.AESummaryChildDao;
import com.sxdl.ae.dao.dao1.AESummaryDao;
import com.sxdl.ae.entity.AESummary;
import com.sxdl.ae.entity.AESummaryChild;
import com.sxdl.ae.service.base.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AESummaryService extends MapperService<AESummary> {

    private final AESummaryDao summaryDao;
    private final AESummaryChildDao childDao;


    public void saveAdverseEvent( AESummary summary) {
        if(StringUtils.isEmpty(summary.getId())){
            int insert = summaryDao.insert(summary);

            saveChild(summary);
        }else{
            int update = summaryDao.updateByPrimaryKey(summary);
            int delete = childDao.delete(new AESummaryChild().setPid(summary.getId()));
            saveChild(summary);
        }

    }
    private void saveChild(AESummary summary){
        if(!StringUtils.isEmpty(summary.getChild()) && summary.getChild().size()>0){
            summary.getChild().forEach(e->{
                int insert1 = childDao.insert(e.setPid(summary.getId()));
            });
        }
    }


    public void delAdverseEvent(String id) {
        List<AESummaryChild> childList = childDao.select(new AESummaryChild().setPid(id));
        if (childList!=null && childList.size()>0){
            int delete = childDao.delete(new AESummaryChild().setPid(id));
        }
        int i = summaryDao.deleteByPrimaryKey(id);
    }

    public List<AESummary> selectByExample(Example example){
        return summaryDao.selectByExample(example);
    }

    public AESummary getAdverseEventSummaryOne(String id) {
        AESummary aeSummary = summaryDao.selectByPrimaryKey(id);
        List<AESummaryChild> childList = childDao.select(new AESummaryChild().setPid(id));
        if (childList!=null && childList.size()>0){
            aeSummary.setChild(childList);
        }

        return aeSummary;
    }
}
