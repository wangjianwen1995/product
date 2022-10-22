package com.sxdl.report.dao;

import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.report.DrMainTest;
import com.sxdl.report.dao.dao1.DrProgramDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class DrProgramDaoTest extends DrMainTest {

    @Autowired
    DrProgramDao drProgramDao;

    @Autowired
    SysUserDao sysUserDao;

    @Test
    public void whenQuerySucc() throws Exception {
        System.out.println(drProgramDao.selectAll());
    }


    @Test
    public void test1() {
        Integer integer = sysUserDao.AutoUpateUser();
        System.out.println(integer);
    }
}
