package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmnkvteDao;
import com.sxdl.hn.dao.dao1.HnAssessmentQuestionsDao;
import com.sxdl.hn.entity.Hmnkvte;
import com.sxdl.hn.entity.HnAssessmentQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;



@Service
@Transactional
public class HmnkvteService extends BaseServiceImpl<Hmnkvte> {

    @Autowired
    private HmnkvteDao hmnkvteDao;

    public List<Hmnkvte> selectByExample(Example example) {
        return hmnkvteDao.selectByExample(example);
    }


}
