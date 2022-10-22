package com.sxdl.report.util;

import java.sql.*;

public class JDBCtest {


    /**
     * 启用单例模式
     * @param args
     */
    public static void main(String[] args) {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=ybjsqd";
        String username="sa";
        String password="sa";

        Connection connection =null;
        Statement statement =null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT \n" +
                    " \n" +
                    "CONVERT(varchar, getdate(), 120 ) as qdscrq\n" +
                    ", qdlsh QDLSH \n" +
                    ", username USERNAME \n" +
                    ", usercode DDYLJGDM \n" +
                    ", ybjsdj YBJSDJ \n" +
                    ", ybbh YBBH \n" +
                    ",bah+'_'+CONVERT(VARCHAR(8),cast(cysj as datetime),112) BAH \n" +
                    ", sbsj SBSJ \n" +
                    ",xm XM \n" +
                    ", xb XB \n" +
                    ", CONVERT(VARCHAR(8),cast(csrq as datetime),112) CSRQ \n" +
                    ", nl NL \n" +
                    ", nlt BZYZSNL \n" +
                    ", gj GJ \n" +
                    ", mz MZ \n" +
                    ", hzzjlb HZZJLB \n" +
                    ", hzzjhm HZZJHM \n" +
                    ", zy ZY \n" +
                    ", xzzsheng JZDZ_SHENG \n" +
                    ",xzzs JZDZ_SHI \n" +
                    ",xzzx JZDZ_XIAN \n" +
                    ", xzzxx JZDZ_XXDZ \n" +
                    ", gzdwmc GZDWMC \n" +
                    ",gzdwdz GZDWDZ \n" +
                    ", dwdh DWDH \n" +
                    ", yb3 YB \n" +
                    ", lxrxm LXRXM \n" +
                    ", gx GX \n" +
                    ", dzsheng LXDZ_SHENG \n" +
                    ",dzs LXDZ_SHI \n" +
                    ",dzx LXDZ_XIAN \n" +
                    ", dzxx LXDZ_XXDZ \n" +
                    ", dh DH \n" +
                    ",yblx YBLX \n" +
                    ", tsrylx TSRYLX \n" +
                    ",cbd CBD \n" +
                    ", xxerylx SSERYLX \n" +
                    ", xsecstz XSECSTZ \n" +
                    ", xserytz XSERYTZ \n" +
                    ", mzmtbzdkb MT_ZDKB \n" +
                    ", mzmtbzdrq MT_JZRQ \n" +
                    ", mzmtbzdmc1 MT_ZDMC1 \n" +
                    ", mzmtbzddm1 MT_ZDDM1 \n" +
                    ", mzmtbssjczmc1 MT_SSJCZMC1 \n" +
                    ", mzmtbssjczdm1 MT_SSJCZDM1\n" +
                    ",mzmtbzdmc2 as mzmtbzdmc2\n" +
                    ",mzmtbzddm2 as mzmtbzddm2\n" +
                    ",mzmtbssjczmc2 as mzmtbssjczmc2\n" +
                    ",mzmtbssjczdm2 as mzmtbssjczdm2\n" +
                    ",mzmtbzdmc3 as mzmtbzdmc3\n" +
                    ",mzmtbzddm3 as mzmtbzddm3\n" +
                    ",mzmtbssjczmc3 as mzmtbssjczmc3\n" +
                    ",mzmtbssjczdm3 as mzmtbssjczdm3\n" +
                    ",mzmtbzdmc4 as mzmtbzdmc4\n" +
                    ",mzmtbzddm4 as mzmtbzddm4\n" +
                    ",mzmtbssjczmc4 as mzmtbssjczmc4\n" +
                    ",mzmtbssjczdm4 as mzmtbssjczdm4\n" +
                    ",mzmtbzdmc5 as mzmtbzdmc5\n" +
                    ",mzmtbzddm5 as mzmtbzddm5\n" +
                    ",mzmtbssjczmc5 as mzmtbssjczmc5\n" +
                    ",mzmtbssjczdm5 as mzmtbssjczdm5\n" +
                    ",mzmtbzdmc6 as mzmtbzdmc6\n" +
                    ",mzmtbzddm6 as mzmtbzddm6\n" +
                    ",mzmtbssjczmc6 as mzmtbssjczmc6\n" +
                    ",mzmtbssjczdm6   as mzmtbssjczdm6 \n" +
                    ", zyyllx ZYYLLX \n" +
                    ", rytj RYTJ \n" +
                    ", zllb ZLLX \n" +
                    ", rysj RYSJ \n" +
                    ", rykb RYKB \n" +
                    ", zkkb ZKKB \n" +
                    ", cysj CYSJ \n" +
                    ", cykb CYKB \n" +
                    ", sjzyts SJZYTS \n" +
                    ", mjzzdxyzd MZZD_XY \n" +
                    ", mjzzdxyzdjbbm JBBM_XY \n" +
                    ", mjzzdzyzd MZZD_ZY \n" +
                    ", mjzzdzyzdjbbm JBBM_ZY \n" +
                    ", zyzd ZYZD \n" +
                    ", jbdm JBDM \n" +
                    ", rybq RYBQ \n" +
                    ", qtzd1 QTZD1\t \n" +
                    ", jbdm1 JBDM1 \n" +
                    ",rybq1 RYBQ1\t \n" +
                    ", qtzd2 QTZD2\t \n" +
                    ", jbdm2 JBDM2\t \n" +
                    ", rybq2 RYBQ2\t \n" +
                    ", qtzd3 QTZD3\t \n" +
                    ", jbdm3 JBDM3\t \n" +
                    ",rybq3 RYBQ3\t \n" +
                    ", qtzd4 QTZD4\t \n" +
                    ",jbdm4 JBDM4\t \n" +
                    ", rybq4 RYBQ4 \n" +
                    ",qtzd5 QTZD5\t \n" +
                    ", jbdm5 JBDM5\t \n" +
                    ", rybq5 RYBQ5\t \n" +
                    ", qtzd6 QTZD6\t \n" +
                    ", jbdm6 JBDM6 \n" +
                    ", rybq6 RYBQ6\t \n" +
                    ", qtzd7 QTZD7\t \n" +
                    ",jbdm7 JBDM7\t \n" +
                    ", rybq7 RYBQ7\t \n" +
                    ", qtzd8 QTZD8 \t \n" +
                    ", jbdm8 JBDM8 \t \n" +
                    ",rybq8 RYBQ8\t \n" +
                    ", qtzd9 QTZD9\t \n" +
                    ",jbdm9 JBDM9\t \n" +
                    ", rybq9 RYBQ9\t \n" +
                    ", qtzd10 QTZD10 \t \n" +
                    ", jbbm10 JBDM10\t \n" +
                    ", rybq10 RYBQ10\t\n" +
                    ",  QTZD11 as qtzd11\t \n" +
                    ",  JBDM11  as jbdm11\n" +
                    ", RYBQ11\t as rybq11 \n" +
                    ",  QTZD12\t as qtzd12 \n" +
                    ",  JBDM12 as jbdm12\t \n" +
                    ",  RYBQ12 as rybq12\t \n" +
                    ",  QTZD13 as qtzd13\t \n" +
                    ",  JBDM13 as jbdm13\t \n" +
                    ", RYBQ13\t  as rybq13\n" +
                    ",  QTZD14 as qtzd14 \n" +
                    ", JBDM14\t as jbdm14\n" +
                    ",  RYBQ14 as rybq14 \n" +
                    ", QTZD15\tas qtzd15 \n" +
                    ",  JBDM15 as jbdm15\t \n" +
                    ",  RYBQ15 as rybq15\t \n" +
                    ",  QTZD16 as qtzd16\t \n" +
                    ",  JBDM16  as jbdm16\n" +
                    ",  RYBQ16 as rybq16\t \n" +
                    ",  QTZD17 as qtzd17\t \n" +
                    ", JBDM17\t as jbdm17 \n" +
                    ",  RYBQ17 as rybq17\t \n" +
                    ",  QTZD18  as qtzd18\t \n" +
                    ",  JBDM18 as jbdm18 \t \n" +
                    ", RYBQ18\t as rybq18 \n" +
                    ",  QTZD19 as qtzd19\t \n" +
                    ", JBDM19 as jbdm19\t \n" +
                    ",  RYBQ19 as rybq19\t \n" +
                    ",  QTZD20 as qtzd20 \n" +
                    ",  JBDM20 as jbbm20\t \n" +
                    ",  RYBQ20 as rybq20\t  \n" +
                    ", cyzyzd CYZYZD_ZB \n" +
                    ",cyjbdm CYJBDM_ZB \n" +
                    ", zyrybq RYBQ_ZYZB \n" +
                    ", '' CYZYZD_ZZ \n" +
                    ",'' CYJBDM_ZZ \n" +
                    ", '' RYBQ_ZYZZ \n" +
                    ",qtzyzd2 as  qtzyzd2\n" +
                    ",qtzydm2 as qtzydm2\n" +
                    ",qtzyrybq2 as qtzyrybq2\n" +
                    ",qtzyzd3 as  qtzyzd3\n" +
                    ",qtzydm3 as qtzydm3\n" +
                    ",qtzyrybq3 as qtzyrybq3\n" +
                    ",qtzyzd4 as  qtzyzd4\n" +
                    ",qtzydm4 as qtzydm4\n" +
                    ",qtzyrybq4 as qtzyrybq4\n" +
                    ",qtzyzd5 as  qtzyzd5\n" +
                    ",qtzydm5 as qtzydm5\n" +
                    ",qtzyrybq5 as qtzyrybq5\n" +
                    ",qtzyzd6 as  qtzyzd6\n" +
                    ",qtzydm6 as qtzydm6\n" +
                    ",qtzyrybq6 as qtzyrybq6\n" +
                    ",qtzyzd7 as  qtzyzd7\n" +
                    ",qtzydm7 as qtzydm7\n" +
                    ",qtzyrybq7 as qtzyrybq7\n" +
                    ",qtzyzd8 as  qtzyzd8\n" +
                    ",qtzydm8 as qtzydm8\n" +
                    ",qtzyrybq8 as qtzyrybq8\n" +
                    ",qtzyzd9 as  qtzyzd9\n" +
                    ",qtzydm9 as qtzydm9\n" +
                    ",qtzyrybq9 as qtzyrybq9\n" +
                    ",qtzyzd10 as  qtzyzd10\n" +
                    ",qtzydm10 as qtzydm10\n" +
                    ",qtzyrybq10 as qtzyrybq10\n" +
                    ",qtzyzd11 as  qtzyzd11\n" +
                    ",qtzydm11 as qtzydm11\n" +
                    ",qtzyrybq11 as qtzyrybq11\n" +
                    ",qtzyzd12 as  qtzyzd12\n" +
                    ",qtzydm12 as qtzydm12\n" +
                    ",qtzyrybq12 as qtzyrybq12\n" +
                    ",qtzyzd13 as  qtzyzd13\n" +
                    ",qtzydm13 as qtzydm13\n" +
                    ",qtzyrybq13 as qtzyrybq13\n" +
                    ",qtzyzd14 as  qtzyzd14\n" +
                    ",qtzydm14 as qtzydm14\n" +
                    ",qtzyrybq14 as qtzyrybq14\n" +
                    ",qtzyzd15 as  qtzyzd15\n" +
                    ",qtzydm15 as qtzydm15\n" +
                    ",qtzyrybq15 as qtzyrybq15\n" +
                    ",qtzyzd16 as  qtzyzd16\n" +
                    ",qtzydm16 as qtzydm16\n" +
                    ",qtzyrybq16 as qtzyrybq16\n" +
                    ",qtzyzd17 as  qtzyzd17\n" +
                    ",qtzydm17 as qtzydm17\n" +
                    ",qtzyrybq17 as qtzyrybq17\n" +
                    ",qtzyzd18 as  qtzyzd18\n" +
                    ",qtzydm18 as qtzydm18\n" +
                    ",qtzyrybq18 as qtzyrybq18\n" +
                    ",qtzyzd19 as  qtzyzd19\n" +
                    ",qtzydm19 as qtzydm19\n" +
                    ",qtzyrybq19 as qtzyrybq19\n" +
                    ",qtzyzd20 as  qtzyzd20\n" +
                    ",qtzydm20 as qtzydm20\n" +
                    ",qtzyrybq20 as qtzyrybq20\n" +
                    ", zddmjs ZDDMJS \n" +
                    ", ssjczmc SSJCZMC \n" +
                    ", ssjczbm SSJCZBM \n" +
                    ", CONVERT(VARCHAR(8),cast(ssjczrq as datetime),112) SSJCZRQ\t \n" +
                    ",\tmzfs MZFS\t \n" +
                    ",\tsz SZ\t \n" +
                    ",\tszysdm SZYSDM\t \n" +
                    ",\tmzys MZYS\t \n" +
                    ",mzysdm MZYSDM\t \n" +
                    ", ssjczmc1 SSJCZMC1 \n" +
                    ", ssjczbm1 SSJCZBM1 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq1 as datetime),112) SSJCZRQ1\t \n" +
                    ",mzfs1 MZFS1\t \n" +
                    ",\tsz1 SZ1\t \n" +
                    ",\tszysdm1 SZYSDM1\t \n" +
                    ",\tmzys1 MZYS1\t \n" +
                    ",\tmzysdm1 MZYSDM1\t \n" +
                    ", ssjczmc2 SSJCZMC2 \n" +
                    ", ssjczbm2 SSJCZBM2 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq2 as datetime),112) SSJCZRQ2\t \n" +
                    ",\tmzfs2 MZFS2\t \n" +
                    ",\tsz2 SZ2\t \n" +
                    ",\tszysdm2 SZYSDM2\t \n" +
                    ",\tmzys2 MZYS2\t \n" +
                    ",mzysdm2 MZYSDM2\t \n" +
                    ", ssjczmc3 SSJCZMC3 \n" +
                    ", ssjczbm3 SSJCZBM3 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq3 as datetime),112) SSJCZRQ3\t \n" +
                    ",\tmzfs3 MZFS3\t \n" +
                    ",\tsz3 SZ3\t \n" +
                    ",\tszysdm3 SZYSDM3\t \n" +
                    ",\tmzys3 MZYS3\t \n" +
                    ",mzysdm3 MZYSDM3\t \n" +
                    ", ssjczmc4 SSJCZMC4 \n" +
                    ", ssjczbm4 SSJCZBM4 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq4 as datetime),112) SSJCZRQ4\t \n" +
                    ",\tmzfs4 MZFS4\t \n" +
                    ",\tsz4 SZ4\t \n" +
                    ",szysdm4 SZYSDM4\t \n" +
                    ",\tmzys4 MZYS4\t \n" +
                    ",\tmzysdm4 MZYSDM4\t \n" +
                    ", ssjczmc5 SSJCZMC5 \n" +
                    ",ssjczbm5 SSJCZBM5 \n" +
                    ",CONVERT(VARCHAR(8),cast(ssjczrq5 as datetime),112) SSJCZRQ5\t \n" +
                    ",\tmzfs5 MZFS5\t \n" +
                    ",\tsz5 SZ5\t \n" +
                    ",szysdm5 SZYSDM5\t \n" +
                    ",\tmzys5 MZYS5\t \n" +
                    ",\tmzysdm5 MZYSDM5\t \n" +
                    ", ssjczmc6 SSJCZMC6 \n" +
                    ", ssjczbm6 SSJCZBM6 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq6 as datetime),112) SSJCZRQ6\t \n" +
                    ",\tmzfs6 MZFS6\t \n" +
                    ",\tsz6 SZ6\t \n" +
                    ",szysdm6 SZYSDM6\t \n" +
                    ",\tmzys6 MZYS6\t \n" +
                    ",mzysdm6 MZYSDM6\t \n" +
                    ",ssjczmc7 SSJCZMC7 \n" +
                    ", ssjczbm7 SSJCZBM7 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq7 as datetime),112)SSJCZRQ7\t \n" +
                    ",\tmzfs7 MZFS7\t \n" +
                    ",\tsz7 SZ7\t \n" +
                    ",\tszysdm7 SZYSDM7\t \n" +
                    ",\tmzys7 MZYS7 \n" +
                    ",\tmzysdm7 MZYSDM7\t \n" +
                    ", ssjczmc8 SSJCZMC8 \n" +
                    ", ssjczbm8 SSJCZBM8 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq8 as datetime),112) SSJCZRQ8\t \n" +
                    ",\tmzfs8 MZFS8\t \n" +
                    ",\tsz8 SZ8\t \n" +
                    ",szysdm8 SZYSDM8\t \n" +
                    ",\tmzys8 MZYS8\t \n" +
                    ",mzysdm8 MZYSDM8\t \n" +
                    ", ssjczmc9 SSJCZMC9 \n" +
                    ", ssjczbm9 SSJCZBM9 \n" +
                    ",\tCONVERT(VARCHAR(8),cast(ssjczrq9 as datetime),112) SSJCZRQ9\t \n" +
                    ",\tmzfs9 MZFS9\t \n" +
                    ",\tsz9 SZ9\t \n" +
                    ",szysdm9 SZYSDM9\t \n" +
                    ",mzys9 MZYS9\t \n" +
                    ",mzysdm9 MZYSDM9\n" +
                    ",  SSJCZMC10 as ssjczmc10\n" +
                    ",  SSJCZBM10 as ssjczbm10\n" +
                    ",\t CONVERT(VARCHAR(8),cast(ssjczrq10 as datetime),112) as ssjczrq10\t \n" +
                    ", MZFS10\tas mzfs10 \n" +
                    ",\t SZ10 as sz10\t \n" +
                    ",\t SZYSDM10 as szysdm10\t \n" +
                    ",\t MZYS10\tas mzys10 \n" +
                    ",\t MZYSDM10 AS  mzysdm10\t\n" +
                    ",  SSJCZMC11 as ssjczmc11\n" +
                    ",  SSJCZBM11 as ssjczbm11\n" +
                    ",\tCONVERT(VARCHAR(8),cast(SSJCZRQ11 as datetime),112)  as ssjczrq11\t \n" +
                    ", MZFS11\tas mzfs11 \n" +
                    ",\t SZ11 as sz11\t \n" +
                    ",\t SZYSDM11 as szysdm11\t \n" +
                    ",\t MZYS11\tas mzys11 \n" +
                    ",\t MZYSDM11 AS  mzysdm11\n" +
                    ",  SSJCZMC12 as ssjczmc12\n" +
                    ",  SSJCZBM12 as ssjczbm12\n" +
                    ",\t CONVERT(VARCHAR(8),cast(SSJCZRQ12 as datetime),112) as ssjczrq12\t \n" +
                    ", MZFS12\tas mzfs12 \n" +
                    ",\t SZ12 as sz12\t \n" +
                    ",\t SZYSDM12 as szysdm12\t \n" +
                    ",\t MZYS12\tas mzys12 \n" +
                    ",\t MZYSDM12 AS  mzysdm12\n" +
                    ",  SSJCZMC13 as ssjczmc13\n" +
                    ",  SSJCZBM13 as ssjczbm13\n" +
                    ",\t  CONVERT(VARCHAR(8),cast(SSJCZRQ13 as datetime),112)  as ssjczrq13\t \n" +
                    ", MZFS13\tas mzfs13 \n" +
                    ",\t SZ13 as sz13\t \n" +
                    ",\t SZYSDM13 as szysdm13\t \n" +
                    ",\t MZYS13\tas mzys13 \n" +
                    ",\t MZYSDM13 AS  mzysdm13\n" +
                    ",  SSJCZMC14 as ssjczmc14\n" +
                    ",  SSJCZBM14 as ssjczbm14\n" +
                    ",\t  CONVERT(VARCHAR(8),cast(SSJCZRQ14 as datetime),112)  as ssjczrq14\t \n" +
                    ", MZFS14\tas mzfs14 \n" +
                    ",\t SZ14 as sz14\t \n" +
                    ",\t SZYSDM14 as szysdm14\t \n" +
                    ",\t MZYS14\tas mzys14 \n" +
                    ",\t MZYSDM14 AS  mzysdm14\n" +
                    ",  SSJCZMC15 as ssjczmc15\n" +
                    ",  SSJCZBM15 as ssjczbm15\n" +
                    ",\t CONVERT(VARCHAR(8),cast(SSJCZRQ15 as datetime),112) as ssjczrq15\t \n" +
                    ", MZFS15\tas mzfs15 \n" +
                    ",\t SZ15 as sz15\t \n" +
                    ",\t SZYSDM15 as szysdm15\t \n" +
                    ",\t MZYS15\tas mzys15 \n" +
                    ",\t MZYSDM15 AS  mzysdm15\t\n" +
                    ",  SSJCZMC16 as ssjczmc16\n" +
                    ",  SSJCZBM16 as ssjczbm16\n" +
                    ",\t CONVERT(VARCHAR(8),cast(SSJCZRQ16 as datetime),112) as ssjczrq16\t \n" +
                    ", MZFS16\tas mzfs16 \n" +
                    ",\t SZ16 as sz16\t \n" +
                    ",\t SZYSDM16 as szysdm16\t \n" +
                    ",\t MZYS16\tas mzys16 \n" +
                    ",\t MZYSDM16 AS  mzysdm16\n" +
                    ",  SSJCZMC17 as ssjczmc17\n" +
                    ",  SSJCZBM17 as ssjczbm17\n" +
                    ",\t CONVERT(VARCHAR(8),cast(SSJCZRQ17 as datetime),112) as ssjczrq17\t \n" +
                    ", MZFS17\tas mzfs17 \n" +
                    ",\t SZ17 as sz17\t \n" +
                    ",\t SZYSDM17 as szysdm17\t \n" +
                    ",\t MZYS17\tas mzys17 \n" +
                    ",\t MZYSDM17 AS  mzysdm17\t\n" +
                    ",  SSJCZMC18 as ssjczmc18\n" +
                    ",  SSJCZBM18 as ssjczbm18\n" +
                    ",\t CONVERT(VARCHAR(8),cast(SSJCZRQ18 as datetime),112) as ssjczrq18\t \n" +
                    ", MZFS18\tas mzfs18 \n" +
                    ",\t SZ18 as sz18\t \n" +
                    ",\t SZYSDM18 as szysdm18\t \n" +
                    ",\t MZYS18\tas mzys18 \n" +
                    ",\t MZYSDM18 AS  mzysdm18\n" +
                    ",  SSJCZMC19 as ssjczmc19\n" +
                    ",  SSJCZBM19 as ssjczbm19\n" +
                    ",\t CONVERT(VARCHAR(8),cast(SSJCZRQ19 as datetime),112) as ssjczrq19\t \n" +
                    ", MZFS19\tas mzfs19 \n" +
                    ",\t SZ19 as sz19\t \n" +
                    ",\t SZYSDM19 as szysdm19\t \n" +
                    ",\t MZYS19\tas mzys19 \n" +
                    ",\t MZYSDM19 AS  mzysdm19\n" +
                    ",  SSJCZMC20 as ssjczmc20\n" +
                    ",  SSJCZBM20 as ssjczbm20\n" +
                    ",\tCONVERT(VARCHAR(8),cast(SSJCZRQ20 as datetime),112)  as ssjczrq20\t \n" +
                    ", MZFS20\tas mzfs20 \n" +
                    ",\t SZ20 as sz20\t \n" +
                    ",\t SZYSDM20 as szysdm20\t \n" +
                    ",\t MZYS20\tas mzys20 \n" +
                    ",\t MZYSDM20 AS  mzysdm20\t\t\n" +
                    ", ssjczdmjs SSJCZDMJS \n" +
                    ", hxjsysjt HXJSY_TS \n" +
                    ", hxjsysjxs HXJSY_XS \n" +
                    ", hxjsysjfz HXJSY_FZ \n" +
                    ", ryq_t RYQ_T \n" +
                    ", ryq_xs RYQ_XS \n" +
                    ", ryq_f RYQ_F \n" +
                    ", ryh_t RYH_T \n" +
                    ", ryh_xs RYH_XS \n" +
                    ", ryh_f RYH_F \n" +
                    ", zzjhbflx1 ICU_BFLX1 \n" +
                    ", jzzjhssj1 ICU_JRSJ1 \n" +
                    ", czzjhssj1 ICU_ZCSJ1 \n" +
                    ",\thj1 ICU_HJXS1 \n" +
                    ", zzjhbflx2 ICU_BFLX2 \n" +
                    ", jzzjhssj2 ICU_JRSJ2 \n" +
                    ", czzjhssj2 ICU_ZCSJ2 \n" +
                    ",\thj2 ICU_HJXS2 \n" +
                    ", zzjhbflx3 ICU_BFLX3 \n" +
                    ", jzzjhssj3 ICU_JRSJ3 \n" +
                    ", czzjhssj3 ICU_ZCSJ3 \n" +
                    ",\thj3 ICU_HJXS3 \n" +
                    ", sxpz SXPZ \n" +
                    ", sxl SXL \n" +
                    ", sxjldw SXLDW \n" +
                    ",\ttjhlts TJHLTS \n" +
                    ",\tyjhlts YJHLTS \n" +
                    ",\tejhlts EJHLTS \n" +
                    ",\tsjhlts SJHLTS \n" +
                    ", lyfs LYFS \n" +
                    ", njsjgmc YZZY_JGMC \n" +
                    ", njsjgdm YZZY_JGDM \n" +
                    ",  njsjgmc1 as njsjgmc1\n" +
                    ",  njsjgdm1 as njsjgdm1\n" +
                    ", sfzzyjh SFZZYJH \n" +
                    ",md MD\n" +
                    ", zzysmc ZZYSXM \n" +
                    ", zzysdm ZZYSDM \n" +
                    ", ywlsh YWLSH \n" +
                    ", pjdm PJDM \n" +
                    ", pjhm PJHM \n" +
                    ", jsksrq JSQJKS \n" +
                    ", jsjsrq JSQJJZ \n" +
                    ", cwfje CWF_JE \n" +
                    ", cwfjl CWF_JL \n" +
                    ",\tcwfyl CWF_YL \n" +
                    ",\tcwfzf CWF_ZF \n" +
                    ",\tcwfqt CWF_QT \n" +
                    ",\tzcfje ZCF_JE \n" +
                    ",\tzcfjl ZCF_JL \n" +
                    ",zcfyl ZCF_YL \n" +
                    ",\tzcfzf ZCF_ZF \n" +
                    ",zcfqt ZCF_QT \n" +
                    ", jcfje JCF_JE \n" +
                    ", jcfjl JCF_JL \n" +
                    ",\tjcfyl JCF_YL \n" +
                    ", jcfzf JCF_ZF \n" +
                    ",\tjcfqt JCF_QT \n" +
                    ",\thyfje HYF_JE\t \n" +
                    ", \thyfjl\tHYF_JL \n" +
                    ", hyfyl\tHYF_YL \n" +
                    ",\thyfzf HYF_ZF\t \n" +
                    ", \thyfqt\tHYF_QT \n" +
                    ",\tzlfje\tZLF_JE \n" +
                    ",\tzlfjl\tZLF_JL \n" +
                    ",\tzlfyl\tZLF_YL \n" +
                    ",\tzlfzf\tZLF_ZF \n" +
                    ",\tzlfqt ZLF_QT\t \n" +
                    ",\tssfje SSF_JE\t \n" +
                    ",\tssfjl SSF_JL\t \n" +
                    ", \tssfyl SSF_YL\t \n" +
                    ",\tssfzf SSF_ZF\t \n" +
                    ", \tssfqt SSF_QT\t \n" +
                    ", hlfje\tHLF_JE \n" +
                    ",\thlfjl HLF_JL\t \n" +
                    ", \thlfyl HLF_YL\t \n" +
                    ",\thlfzf HLF_ZF\t \n" +
                    ", hlfqt\tHLF_QT \n" +
                    ",\twsclfje WSCLF_JE\t \n" +
                    ",\twsclfjl\tWSCLF_JL \n" +
                    ",\twsclfyl\tWSCLF_YL \n" +
                    ", \twsclfzf\tWSCLF_ZF \n" +
                    ",\twsclfqt\tWSCLF_QT \n" +
                    ",\txyfje\tXYF_JE \n" +
                    ",\txyfjl XYF_JL\t \n" +
                    ",\txyfyl XYF_YL\t \n" +
                    ", xyfzf\tXYF_ZF \n" +
                    ",\txyfqt\tXYF_QT \n" +
                    ", \tzyypfje ZYYPF_JE\t \n" +
                    ",\tzyypfjl\tZYYPF_JL \n" +
                    ", \tzyypfyl\tZYYPF_YL \n" +
                    ",\tzyypfzf\tZYYPF_ZF \n" +
                    ", \tzyypfqt\tZYYPF_QT \n" +
                    ", \tzcyfje ZCYF_JE\t \n" +
                    ", \tzcyfjl\tZCYF_JL \n" +
                    ", \tzcyfyl\tZCYF_YL \n" +
                    ", \tzcyfzf\tZCYF_ZF \n" +
                    ",\tzcyfqt\tZCYF_QT \n" +
                    ", \tybzlfje\tYBZLF_JE \n" +
                    ", \tybzlfjl\tYBZLF_JL \n" +
                    ",\tybzlfyl\tYBZLF_YL \n" +
                    ",\tybzlfzf\tYBZLF_ZF \n" +
                    ", \tybzlfqt\tYBZLF_QT \n" +
                    ", \tghfje\tGHF_JE \n" +
                    ",\tghfjl\tGHF_JL \n" +
                    ",\tghfyl\tGHF_YL \n" +
                    ",\tghfzf\tGHF_ZF \n" +
                    ",\tghfqt\tGHF_QT \n" +
                    ",\tqtfje\tQTF_JE \n" +
                    ",\tqtfjl\tQTF_JL \n" +
                    ", \tqtfyl\tQTF_YL \n" +
                    ",\tqtfzf\tQTF_ZF \n" +
                    ",\tqtfqt\tQTF_QT \n" +
                    ",\tconvert(varchar(30),jehj ) \tJEHJ_JE \n" +
                    ",\titemjehjjl\tJEHJ_JL \n" +
                    ", \titemjehjyl\tJEHJ_YL \n" +
                    ",\titemjehjzf\tJEHJ_ZF \n" +
                    ",\t\titemjehjqt\tJEHJ_QT \n" +
                    ",ybtcjjzf\tYBTCJJZF \n" +
                    ", dbbx\tDBBX \n" +
                    ",\tyljz\tYLJZ \n" +
                    ",\tgwyylbz\tGWYYLBZ \n" +
                    ", debz DEBC \n" +
                    ", \tqybz QYBC\t \n" +
                    ", grzf \tGRZIF \n" +
                    ", \tgrzf2\tGRZF \n" +
                    ", \tgrzhzf\tGRZHZF \n" +
                    ", \tgrxjzf\tGRXJZF \n" +
                    ",'1' \tYBZFFS \n" +
                    ",crt_mdtrt_sumfee as crt_mdtrt_sumfee\n" +
                    ",hif_pay_sumamt as hif_pay_sumamt \n" +
                    ",paybydise_payamt as paybydise_payamt\n" +
                    ",hifcs_payamt as hifcs_payamt\n" +
                    ",oth_subs_pay as oth_subs_pay\n" +
                    ",rh_mdcs_payamt as rh_mdcs_payamt\n" +
                    ",hifdm_payamt as hifdm_payamt\n" +
                    ",hifra_pay as hifra_pay\n" +
                    ",injr_fund_pay as injr_fund_pay\n" +
                    ",nemp_fund_pay as nemp_fund_pay\n" +
                    ",matn_fund_pay as matn_fund_pay\n" +
                    ",army_conv_cadre_subs_pay as army_conv_cadre_subs_pay\n" +
                    ",mafca_pay as mafca_pay\n" +
                    ",pfa_fund_pay as pfa_fund_pay\n" +
                    ",hosp_part_pay as hosp_part_pay\n" +
                    ",mihi_scp_in_amt as mihi_scp_in_amt\n" +
                    ",mihi_scp_out_amt as  mihi_scp_out_amt\n" +
                    ",sdry_cmps_mihi_pay as sdry_cmps_mihi_pay\n" +
                    ",setl_amt_ext_eld1 as setl_amt_ext_fld1\n" +
                    ",setl_amt_ext_eld2 as setl_amt_ext_fld2\n" +
                    ",setl_amt_ext_eld3 as setl_amt_ext_fld3\n" +
                    ",setl_amt_ext_eld4 as setl_amt_ext_fld4\n" +
                    ",setl_amt_ext_eld5 as setl_amt_ext_fld5\n" +
                    ",setl_amt_ext_eld6 as setl_amt_ext_fld6\n" +
                    ",setl_amt_ext_eld7 as setl_amt_ext_fld7\n" +
                    ",setl_amt_ext_eld8 as setl_amt_ext_fld8\n" +
                    ",setl_amt_ext_eld9 as setl_amt_ext_fld9\n" +
                    ",setl_amt_ext_eld10 as setl_amt_ext_fld10\n" +
                    ",ext_fld1 as ext_fld1\n" +
                    ",ext_fld2 as ext_fld2\n" +
                    ",ext_fld3 as ext_fld3\n" +
                    ",ext_fld4 as ext_fld4\n" +
                    ",ext_fld5 as ext_fld5\n" +
                    ",ext_fld6 as ext_fld6\n" +
                    ",ext_fld7 as ext_fld7\n" +
                    ",ext_fld8 as ext_fld8\n" +
                    ",ext_fld9 as ext_fld9\n" +
                    "\n" +
                    ",ext_fld10 as ext_fld10\n" +
                    ",\tyljgtbbm\tYLJGTBBM \n" +
                    ", \tyljgtbr YLJGTBR\t \n" +
                    ", \tybjg YBJG\t \n" +
                    ",\tybjgjbr\tYBJGJBR \n" +
                    ",'' SDYWH \n" +
                    ",'' BMY\n" +
                    ",'' baba  \n" +
                    ", cykb   s_cyks \n" +
                    ",convert(varchar(30) ,jehj ) jehj\n" +
                    ",jsjsrq dischargedate\n" +
                    "from LFYBJSQD_WH\n" +
                    "Where 1=2\n" +
                    " ");
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i + 1);
                System.out.println(columnName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
