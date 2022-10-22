package com.sxdl.fm.controller;

import com.sxdl.fm.FmMainTest;
import com.sxdl.fm.dao.dao1.FmUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FmUserTest extends FmMainTest {
    @Autowired
    FmUserDao fmUserDao;

    @Test
    public void whenQuerySucc() throws  Exception{
        System.out.println(fmUserDao.selectAll());
    }
}
