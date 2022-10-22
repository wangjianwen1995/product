package com.sxdl.performance.util;

import org.junit.jupiter.api.Test;

public class ParseXMLtoSQLUtilTest {

    @Test
    public void test() throws Exception {
        ParseXMLtoSQLUtil.coverToSQL("D:\\workspaces\\IDEA\\sxdl\\adr\\files\\1.xml");
        ParseXMLtoSQLUtil.coverToSQL("D:\\workspaces\\IDEA\\sxdl\\adr\\files\\事实表.xml");
        ParseXMLtoSQLUtil.coverToSQL("D:\\workspaces\\IDEA\\sxdl\\adr\\files\\维表.xml");
    }
}