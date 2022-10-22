package com.sxdl.hp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "homepage")
public class HomepageEntity {

    @Id
    @JsonProperty("id")
    @KeySql(genId = UUIdGenId.class)
    private String id;
    @Column(name="A_id")
    @JsonProperty("A_id")
    private String A_id;
    @Column(name="ZZJGDM")
    @JsonProperty("ZZJGDM")
    private String zzjgdm;
    @Column(name="JGMC")
    @JsonProperty("JGMC")
    private String jgmc;
    @Column(name="ZZJGDM2")
    @JsonProperty("ZZJGDM2")
    private String zzjgdm2;
    @Column(name="USERNAME")
    @JsonProperty("USERNAME")
    private String username;
    @Column(name="YLFKFS")
    @JsonProperty("YLFKFS")
    private String ylfkfs;
    @Column(name="JKKH")
    @JsonProperty("JKKH")
    private String jkkh;
    @Column(name="ZYCS")
    @JsonProperty("ZYCS")
    private Integer zycs;
    @Column(name="BAH")
    @JsonProperty("BAH")
    private String bah;
    @Column(name="XM")
    @JsonProperty("XM")
    private String xm;
    @Column(name="XB")
    @JsonProperty("XB")
    private String xb; //private Integer xb;
    @Column(name="CSRQ")
    @JsonProperty("CSRQ")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date csrq;
    @Column(name="NL")
    @JsonProperty("NL")
    private Integer nl;
    @Column(name="GJ")
    @JsonProperty("GJ")
    private String gj;
    @Column(name="BZYZS_NL")
    @JsonProperty("BZYZS_NL")
    private Double bzyzsNl;
    @Column(name="XSETZ")
    @JsonProperty("XSETZ")
    private Integer xsetz;
    @Column(name="XSETZ2")
    @JsonProperty("XSETZ2")
    private Integer xsetz2;
    @Column(name="XSETZ3")
    @JsonProperty("XSETZ3")
    private Integer xsetz3;
    @Column(name="XSETZ4")
    @JsonProperty("XSETZ4")
    private Integer xsetz4;
    @Column(name="XSETZ5")
    @JsonProperty("XSETZ5")
    private Integer xsetz5;
    @Column(name="XSERYTZ")
    @JsonProperty("XSERYTZ")
    private Integer xserytz;
    @Column(name="CSD_sheng")
    @JsonProperty("CSD_sheng")
    private String csd_sheng;
    @Column(name="CSD_sheng_dm")
    @JsonProperty("CSD_sheng_dm")
    private String csd_sheng_dm;
    @Column(name="CSD_shi")
    @JsonProperty("CSD_shi")
    private String csd_shi;
    @Column(name="CSD_shi_dm")
    @JsonProperty("CSD_shi_dm")
    private String csd_shi_dm;
    @Column(name="CSD_xian")
    @JsonProperty("CSD_xian")
    private String csd_xian;
    @Column(name="CSD_xian_dm")
    @JsonProperty("CSD_xian_dm")
    private String csd_xian_dm;
    @Column(name="CSD_addr")
    @JsonProperty("CSD_addr")
    private String csd_addr;
    @Column(name="CSD_addr_all")
    @JsonProperty("CSD_addr_all")
    private String csd_addr_all;
    @Column(name="JG_sheng")
    @JsonProperty("JG_sheng")
    private String jg_sheng;
    @Column(name="JG_sheng_dm")
    @JsonProperty("JG_sheng_dm")
    private String jg_sheng_dm;
    @Column(name="JG_shi")
    @JsonProperty("JG_shi")
    private String jg_shi;
    @Column(name="JG_shi_dm")
    @JsonProperty("JG_shi_dm")
    private String jg_shi_dm;
    @Column(name="JG_all")
    @JsonProperty("JG_all")
    private String jg_all;
    @Column(name="MZ")
    @JsonProperty("MZ")
    private String mz;
    @Column(name="SFZH")
    @JsonProperty("SFZH")
    private String sfzh;
    @Column(name="ZY")
    @JsonProperty("ZY")
    private String zy;
    @Column(name="HY")
    @JsonProperty("HY")
    private String hy;
    @Column(name="XZZ_sheng")
    @JsonProperty("XZZ_sheng")
    private String xzz_sheng;
    @Column(name="XZZ_sheng_dm")
    @JsonProperty("XZZ_sheng_dm")
    private String xzz_sheng_dm;
    @Column(name="XZZ_shi")
    @JsonProperty("XZZ_shi")
    private String xzz_shi;
    @Column(name="XZZ_shi_dm")
    @JsonProperty("XZZ_shi_dm")
    private String xzz_shi_dm;
    @Column(name="XZZ_xian")
    @JsonProperty("XZZ_xian")
    private String xzz_xian;
    @Column(name="XZZ_xian_dm")
    @JsonProperty("XZZ_xian_dm")
    private String xzz_xian_dm;
    @Column(name="XZZ_addr")
    @JsonProperty("XZZ_addr")
    private String xzz_addr;
    @Column(name="XZZ_addr_all")
    @JsonProperty("XZZ_addr_all")
    private String xzz_addr_all;
    @Column(name="DH")
    @JsonProperty("DH")
    private String dh;
    @Column(name="YB1")
    @JsonProperty("YB1")
    private String yb1;
    @Column(name="HKDZ_sheng")
    @JsonProperty("HKDZ_sheng")
    private String hkdz_sheng;
    @Column(name="HKDZ_sheng_dm")
    @JsonProperty("HKDZ_sheng_dm")
    private String hkdz_sheng_dm;
    @Column(name="HKDZ_shi")
    @JsonProperty("HKDZ_shi")
    private String hkdz_shi;
    @Column(name="HKDZ_shi_dm")
    @JsonProperty("HKDZ_shi_dm")
    private String hkdz_shi_dm;
    @Column(name="HKDZ_xian")
    @JsonProperty("HKDZ_xian")
    private String hkdz_xian;
    @Column(name="HKDZ_xian_dm")
    @JsonProperty("HKDZ_xian_dm")
    private String hkdz_xian_dm;
    @Column(name="HKDZ_addr")
    @JsonProperty("HKDZ_addr")
    private String hkdz_addr;
    @Column(name="HKDZ_addr_all")
    @JsonProperty("HKDZ_addr_all")
    private String hkdz_addr_all;
    @Column(name="YB2")
    @JsonProperty("YB2")
    private String yb2;
    @Column(name="GZDWJDZ")
    @JsonProperty("GZDWJDZ")
    private String gzdwjdz;
    @Column(name="DWDH")
    @JsonProperty("DWDH")
    private String dwdh;
    @Column(name="YB3")
    @JsonProperty("YB3")
    private String yb3;
    @Column(name="LXRXM")
    @JsonProperty("LXRXM")
    private String lxrxm;
    @Column(name="GX")
    @JsonProperty("GX")
    private String gx;
    @Column(name="LXR_sheng")
    @JsonProperty("LXR_sheng")
    private String lxr_sheng;
    @Column(name="LXR_sheng_dm")
    @JsonProperty("LXR_sheng_dm")
    private String lxr_sheng_dm;
    @Column(name="LXR_shi")
    @JsonProperty("LXR_shi")
    private String lxr_shi;
    @Column(name="LXR_shi_dm")
    @JsonProperty("LXR_shi_dm")
    private String lxr_shi_dm;
    @Column(name="LXR_xian")
    @JsonProperty("LXR_xian")
    private String lxr_xian;
    @Column(name="LXR_xian_dm")
    @JsonProperty("LXR_xian_dm")
    private String lxr_xian_dm;
    @Column(name="LXR_addr")
    @JsonProperty("LXR_addr")
    private String lxr_addr;
    @Column(name="LXR_addr_all")
    @JsonProperty("LXR_addr_all")
    private String lxr_addr_all;
    @Column(name="DH1")
    @JsonProperty("DH1")
    private String dh1;
    @Column(name="RYTJ")
    @JsonProperty("RYTJ")
    private String rytj;
    @Column(name="ZLLB")
    @JsonProperty("ZLLB")
    private String zllb;
    @Column(name="RYSJ")
    @JsonProperty("RYSJ")
    private Timestamp rysj;
    @Column(name="RYSJ_S")
    @JsonProperty("RYSJ_S")
    private String rysj_S;
    @Column(name="RYKB")
    @JsonProperty("RYKB")
    private String rykb;
    @Column(name="RYBF")
    @JsonProperty("RYBF")
    private String rybf;
    @Column(name="ZKKB")
    @JsonProperty("ZKKB")
    private String zkkb;
    @Column(name="CYSJ")
    @JsonProperty("CYSJ")
    private Timestamp cysj;
    @Column(name="CYSJ_S")
    @JsonProperty("CYSJ_S")
    private String cysj_S;
    @Column(name="CYKB")
    @JsonProperty("CYKB")
    private String cykb;
    @Column(name="CYBF")
    @JsonProperty("CYBF")
    private String cybf;
    @Column(name="SJZY")
    @JsonProperty("SJZY")
    private Integer sjzy;
    @Column(name="MZD_ZYZD")
    @JsonProperty("MZD_ZYZD")
    private String mzd_zyzd;
    @Column(name="JBDM")
    @JsonProperty("JBDM")
    private String jbdm;
    @Column(name="MZZD_XYZD")
    @JsonProperty("MZZD_XYZD")
    private String mzzd_xyzd;
    @Column(name="JBBM")
    @JsonProperty("JBBM")
    private String jbbm;
    @Column(name="SSLCLJ")
    @JsonProperty("SSLCLJ")
    private String sslclj;
    @Column(name="ZYYJ")
    @JsonProperty("ZYYJ")
    private String zyyj;
    @Column(name="ZYZLSB")
    @JsonProperty("ZYZLSB")
    private String zyzlsb;
    @Column(name="ZYZLJS")
    @JsonProperty("ZYZLJS")
    private String zyzljs;
    @Column(name="BZSH")
    @JsonProperty("BZSH")
    private String bzsh;
    @Column(name="ZB")
    @JsonProperty("ZB")
    private String zb;
    @Column(name="ZB_JBBM")
    @JsonProperty("ZB_JBBM")
    private String zb_jbbm;
    @Column(name="ZB_RYBQ")
    @JsonProperty("ZB_RYBQ")
    private String zb_rybq;
    @Column(name="ZYZD")
    @JsonProperty("ZYZD")
    private String zyzd;
    @Column(name="ZYZD_JBBM")
    @JsonProperty("ZYZD_JBBM")
    private String zyzd_jbbm;
    @Column(name="ZYZD_JBBM_ALLC")
    @JsonProperty("ZYZD_JBBM_ALLC")
    private String zyzd_jbbm_allc;
    @Column(name="ZYZD_CYQK")
    @JsonProperty("ZYZD_CYQK")
    private String ZYZD_CYQK;
    @Column(name="XY_RYBQ")
    @JsonProperty("XY_RYBQ")
    private String xy_rybq;
    @Column(name="ZZ1")
    @JsonProperty("ZZ1")
    private String zz1;
    @Column(name="ZZ2")
    @JsonProperty("ZZ2")
    private String zz2;
    @Column(name="ZZ3")
    @JsonProperty("ZZ3")
    private String zz3;
    @Column(name="ZZ4")
    @JsonProperty("ZZ4")
    private String zz4;
    @Column(name="ZZ5")
    @JsonProperty("ZZ5")
    private String zz5;
    @Column(name="ZZ6")
    @JsonProperty("ZZ6")
    private String zz6;
    @Column(name="ZZ7")
    @JsonProperty("ZZ7")
    private String zz7;
    @Column(name="ZZ_JBBM1")
    @JsonProperty("ZZ_JBBM1")
    private String zz_jbbm1;
    @Column(name="ZZ_JBBM2")
    @JsonProperty("ZZ_JBBM22")
    private String zz_jbbm2;
    @Column(name="ZZ_JBBM3")
    @JsonProperty("ZZ_JBBM3")
    private String zz_jbbm3;
    @Column(name="ZZ_JBBM4")
    @JsonProperty("ZZ_JBBM4")
    private String zz_jbbm4;
    @Column(name="ZZ_JBBM5")
    @JsonProperty("ZZ_JBBM5")
    private String zz_jbbm5;
    @Column(name="ZZ_JBBM6")
    @JsonProperty("ZZ_JBBM6")
    private String zz_jbbm6;
    @Column(name="ZZ_JBBM7")
    @JsonProperty("ZZ_JBBM7")
    private String zz_jbbm7;
    @Column(name="ZZ_RYBQ1")
    @JsonProperty("ZZ_RYBQ1")
    private String zz_rybq1;
    @Column(name="ZZ_RYBQ2")
    @JsonProperty("ZZ_RYBQ2")
    private String zz_rybq2;
    @Column(name="ZZ_RYBQ3")
    @JsonProperty("ZZ_RYBQ3")
    private String zz_rybq3;
    @Column(name="ZZ_RYBQ4")
    @JsonProperty("ZZ_RYBQ4")
    private String zz_rybq4;
    @Column(name="ZZ_RYBQ5")
    @JsonProperty("ZZ_RYBQ5")
    private String zz_rybq5;
    @Column(name="ZZ_RYBQ6")
    @JsonProperty("ZZ_RYBQ6")
    private String zz_rybq6;
    @Column(name="ZZ_RYBQ7")
    @JsonProperty("ZZ_RYBQ7")
    private String zz_rybq7;
    @Column(name="QTZD1")
    @JsonProperty("QTZD1")
    private String qtzd1;
    @Column(name="QTZD2")
    @JsonProperty("QTZD2")
    private String qtzd2;
    @Column(name="QTZD3")
    @JsonProperty("QTZD3")
    private String qtzd3;
    @Column(name="QTZD4")
    @JsonProperty("QTZD4")
    private String qtzd4;
    @Column(name="QTZD5")
    @JsonProperty("QTZD5")
    private String qtzd5;
    @Column(name="QTZD6")
    @JsonProperty("QTZD6")
    private String qtzd6;
    @Column(name="QTZD7")
    @JsonProperty("QTZD7")
    private String qtzd7;
    @Column(name="QTZD8")
    @JsonProperty("QTZD8")
    private String qtzd8;
    @Column(name="QTZD9")
    @JsonProperty("QTZD9")
    private String qtzd9;
    @Column(name="QTZD10")
    @JsonProperty("QTZD10")
    private String qtzd10;
    @Column(name="QTZD11")
    @JsonProperty("QTZD11")
    private String qtzd11;
    @Column(name="QTZD12")
    @JsonProperty("QTZD12")
    private String qtzd12;
    @Column(name="QTZD13")
    @JsonProperty("QTZD13")
    private String qtzd13;
    @Column(name="QTZD14")
    @JsonProperty("QTZD14")
    private String qtzd14;
    @Column(name="QTZD15")
    @JsonProperty("QTZD15")
    private String qtzd15;
    @Column(name="QTZD16")
    @JsonProperty("QTZD16")
    private String qtzd16;
    @Column(name="QTZD17")
    @JsonProperty("QTZD17")
    private String qtzd17;
    @Column(name="QTZD18")
    @JsonProperty("QTZD18")
    private String qtzd18;
    @Column(name="QTZD19")
    @JsonProperty("QTZD19")
    private String qtzd19;
    @Column(name="QTZD20")
    @JsonProperty("QTZD20")
    private String qtzd20;
    @Column(name="QTZD21")
    @JsonProperty("QTZD21")
    private String qtzd21;
    @Column(name="QTZD22")
    @JsonProperty("QTZD22")
    private String qtzd22;
    @Column(name="QTZD23")
    @JsonProperty("QTZD23")
    private String qtzd23;
    @Column(name="QTZD24")
    @JsonProperty("QTZD24")
    private String qtzd24;
    @Column(name="QTZD25")
    @JsonProperty("QTZD25")
    private String qtzd25;
    @Column(name="QTZD26")
    @JsonProperty("QTZD26")
    private String qtzd26;
    @Column(name="QTZD27")
    @JsonProperty("QTZD27")
    private String qtzd27;
    @Column(name="QTZD28")
    @JsonProperty("QTZD28")
    private String qtzd28;
    @Column(name="QTZD29")
    @JsonProperty("QTZD29")
    private String qtzd29;
    @Column(name="QTZD30")
    @JsonProperty("QTZD30")
    private String qtzd30;
    @Column(name="QTZD31")
    @JsonProperty("QTZD31")
    private String qtzd31;
    @Column(name="QTZD32")
    @JsonProperty("QTZD32")
    private String qtzd32;
    @Column(name="QTZD33")
    @JsonProperty("QTZD33")
    private String qtzd33;
    @Column(name="QTZD34")
    @JsonProperty("QTZD34")
    private String qtzd34;
    @Column(name="QTZD35")
    @JsonProperty("QTZD35")
    private String qtzd35;
    @Column(name="QTZD36")
    @JsonProperty("QTZD36")
    private String qtzd36;
    @Column(name="QTZD37")
    @JsonProperty("QTZD37")
    private String qtzd37;
    @Column(name="QTZD38")
    @JsonProperty("QTZD38")
    private String qtzd38;
    @Column(name="QTZD39")
    @JsonProperty("QTZD39")
    private String qtzd39;
    @Column(name="QTZD40")
    @JsonProperty("QTZD40")
    private String qtzd40;
    @Column(name="ZYZD_JBBM1")
    @JsonProperty("ZYZD_JBBM1")
    private String zyzd_jbbm1;
    @Column(name="ZYZD_JBBM2")
    @JsonProperty("ZYZD_JBBM2")
    private String zyzd_jbbm2;
    @Column(name="ZYZD_JBBM3")
    @JsonProperty("ZYZD_JBBM3")
    private String zyzd_jbbm3;
    @Column(name="ZYZD_JBBM4")
    @JsonProperty("ZYZD_JBBM4")
    private String zyzd_jbbm4;
    @Column(name="ZYZD_JBBM5")
    @JsonProperty("ZYZD_JBBM5")
    private String zyzd_jbbm5;
    @Column(name="ZYZD_JBBM6")
    @JsonProperty("ZYZD_JBBM6")
    private String zyzd_jbbm6;
    @Column(name="ZYZD_JBBM7")
    @JsonProperty("ZYZD_JBBM7")
    private String zyzd_jbbm7;
    @Column(name="ZYZD_JBBM8")
    @JsonProperty("ZYZD_JBBM8")
    private String zyzd_jbbm8;
    @Column(name="ZYZD_JBBM9")
    @JsonProperty("ZYZD_JBBM9")
    private String zyzd_jbbm9;
    @Column(name="ZYZD_JBBM10")
    @JsonProperty("ZYZD_JBBM10")
    private String zyzd_jbbm10;
    @Column(name="ZYZD_JBBM11")
    @JsonProperty("ZYZD_JBBM11")
    private String zyzd_jbbm11;
    @Column(name="ZYZD_JBBM12")
    @JsonProperty("ZYZD_JBBM12")
    private String zyzd_jbbm12;
    @Column(name="ZYZD_JBBM13")
    @JsonProperty("ZYZD_JBBM13")
    private String zyzd_jbbm13;
    @Column(name="ZYZD_JBBM14")
    @JsonProperty("ZYZD_JBBM14")
    private String zyzd_jbbm14;
    @Column(name="ZYZD_JBBM15")
    @JsonProperty("ZYZD_JBBM15")
    private String zyzd_jbbm15;
    @Column(name="ZYZD_JBBM16")
    @JsonProperty("ZYZD_JBBM16")
    private String zyzd_jbbm16;
    @Column(name="ZYZD_JBBM17")
    @JsonProperty("ZYZD_JBBM17")
    private String zyzd_jbbm17;
    @Column(name="ZYZD_JBBM18")
    @JsonProperty("ZYZD_JBBM18")
    private String zyzd_jbbm18;
    @Column(name="ZYZD_JBBM19")
    @JsonProperty("ZYZD_JBBM19")
    private String zyzd_jbbm19;
    @Column(name="ZYZD_JBBM20")
    @JsonProperty("ZYZD_JBBM20")
    private String zyzd_jbbm20;
    @Column(name="ZYZD_JBBM21")
    @JsonProperty("ZYZD_JBBM21")
    private String zyzd_jbbm21;
    @Column(name="ZYZD_JBBM22")
    @JsonProperty("ZYZD_JBBM22")
    private String zyzd_jbbm22;
    @Column(name="ZYZD_JBBM23")
    @JsonProperty("ZYZD_JBBM23")
    private String zyzd_jbbm23;
    @Column(name="ZYZD_JBBM24")
    @JsonProperty("ZYZD_JBBM24")
    private String zyzd_jbbm24;
    @Column(name="ZYZD_JBBM25")
    @JsonProperty("ZYZD_JBBM25")
    private String zyzd_jbbm25;
    @Column(name="ZYZD_JBBM26")
    @JsonProperty("ZYZD_JBBM26")
    private String zyzd_jbbm26;
    @Column(name="ZYZD_JBBM27")
    @JsonProperty("ZYZD_JBBM27")
    private String zyzd_jbbm27;
    @Column(name="ZYZD_JBBM28")
    @JsonProperty("ZYZD_JBBM28")
    private String zyzd_jbbm28;
    @Column(name="ZYZD_JBBM29")
    @JsonProperty("ZYZD_JBBM29")
    private String zyzd_jbbm29;
    @Column(name="ZYZD_JBBM30")
    @JsonProperty("ZYZD_JBBM30")
    private String zyzd_jbbm30;
    @Column(name="ZYZD_JBBM31")
    @JsonProperty("ZYZD_JBBM31")
    private String zyzd_jbbm31;
    @Column(name="ZYZD_JBBM32")
    @JsonProperty("ZYZD_JBBM32")
    private String zyzd_jbbm32;
    @Column(name="ZYZD_JBBM33")
    @JsonProperty("ZYZD_JBBM33")
    private String zyzd_jbbm33;
    @Column(name="ZYZD_JBBM34")
    @JsonProperty("ZYZD_JBBM34")
    private String zyzd_jbbm34;
    @Column(name="ZYZD_JBBM35")
    @JsonProperty("ZYZD_JBBM35")
    private String zyzd_jbbm35;
    @Column(name="ZYZD_JBBM36")
    @JsonProperty("ZYZD_JBBM36")
    private String zyzd_jbbm36;
    @Column(name="ZYZD_JBBM37")
    @JsonProperty("ZYZD_JBBM37")
    private String zyzd_jbbm37;
    @Column(name="ZYZD_JBBM38")
    @JsonProperty("ZYZD_JBBM38")
    private String zyzd_jbbm38;
    @Column(name="ZYZD_JBBM39")
    @JsonProperty("ZYZD_JBBM39")
    private String zyzd_jbbm39;
    @Column(name="ZYZD_JBBM40")
    @JsonProperty("ZYZD_JBBM40")
    private String zyzd_jbbm40;
    @Column(name="RYBQ1")
    @JsonProperty("RYBQ1")
    private String rybq1;
    @Column(name="RYBQ2")
    @JsonProperty("RYBQ2")
    private String rybq2;
    @Column(name="RYBQ3")
    @JsonProperty("RYBQ3")
    private String rybq3;
    @Column(name="RYBQ4")
    @JsonProperty("RYBQ4")
    private String rybq4;
    @Column(name="RYBQ5")
    @JsonProperty("RYBQ5")
    private String rybq5;
    @Column(name="RYBQ6")
    @JsonProperty("RYBQ6")
    private String rybq6;
    @Column(name="RYBQ7")
    @JsonProperty("RYBQ7")
    private String rybq7;
    @Column(name="RYBQ8")
    @JsonProperty("RYBQ8")
    private String rybq8;
    @Column(name="RYBQ9")
    @JsonProperty("RYBQ9")
    private String rybq9;
    @Column(name="RYBQ10")
    @JsonProperty("RYBQ10")
    private String rybq10;
    @Column(name="RYBQ11")
    @JsonProperty("RYBQ11")
    private String rybq11;
    @Column(name="RYBQ12")
    @JsonProperty("RYBQ12")
    private String rybq12;
    @Column(name="RYBQ13")
    @JsonProperty("RYBQ13")
    private String rybq13;
    @Column(name="RYBQ14")
    @JsonProperty("RYBQ14")
    private String rybq14;
    @Column(name="RYBQ15")
    @JsonProperty("RYBQ15")
    private String rybq15;
    @Column(name="RYBQ16")
    @JsonProperty("RYBQ16")
    private String rybq16;
    @Column(name="RYBQ17")
    @JsonProperty("RYBQ17")
    private String rybq17;
    @Column(name="RYBQ18")
    @JsonProperty("RYBQ18")
    private String rybq18;
    @Column(name="RYBQ19")
    @JsonProperty("RYBQ19")
    private String rybq19;
    @Column(name="RYBQ20")
    @JsonProperty("RYBQ20")
    private String rybq20;
    @Column(name="RYBQ21")
    @JsonProperty("RYBQ21")
    private String rybq21;
    @Column(name="RYBQ22")
    @JsonProperty("RYBQ22")
    private String rybq22;
    @Column(name="RYBQ23")
    @JsonProperty("RYBQ23")
    private String rybq23;
    @Column(name="RYBQ24")
    @JsonProperty("RYBQ24")
    private String rybq24;
    @Column(name="RYBQ25")
    @JsonProperty("RYBQ25")
    private String rybq25;
    @Column(name="RYBQ26")
    @JsonProperty("RYBQ26")
    private String rybq26;
    @Column(name="RYBQ27")
    @JsonProperty("RYBQ27")
    private String rybq27;
    @Column(name="RYBQ28")
    @JsonProperty("RYBQ28")
    private String rybq28;
    @Column(name="RYBQ29")
    @JsonProperty("RYBQ29")
    private String rybq29;
    @Column(name="RYBQ30")
    @JsonProperty("RYBQ30")
    private String rybq30;
    @Column(name="RYBQ31")
    @JsonProperty("RYBQ31")
    private String rybq31;
    @Column(name="RYBQ32")
    @JsonProperty("RYBQ32")
    private String rybq32;
    @Column(name="RYBQ33")
    @JsonProperty("RYBQ33")
    private String rybq33;
    @Column(name="RYBQ34")
    @JsonProperty("RYBQ34")
    private String rybq34;
    @Column(name="RYBQ35")
    @JsonProperty("RYBQ35")
    private String rybq35;
    @Column(name="RYBQ36")
    @JsonProperty("RYBQ36")
    private String rybq36;
    @Column(name="RYBQ37")
    @JsonProperty("RYBQ37")
    private String rybq37;
    @Column(name="RYBQ38")
    @JsonProperty("RYBQ38")
    private String rybq38;
    @Column(name="RYBQ39")
    @JsonProperty("RYBQ39")
    private String rybq39;
    @Column(name="RYBQ40")
    @JsonProperty("RYBQ40")
    private String rybq40;
    @Column(name="CYQK1")
    @JsonProperty("CYQK1")
    private String CYQK1;
    @Column(name="CYQK2")
    @JsonProperty("CYQK2")
    private String CYQK2;
    @Column(name="CYQK3")
    @JsonProperty("CYQK3")
    private String CYQK3;
    @Column(name="CYQK4")
    @JsonProperty("CYQK4")
    private String CYQK4;
    @Column(name="CYQK5")
    @JsonProperty("CYQK5")
    private String CYQK5;
    @Column(name="CYQK6")
    @JsonProperty("CYQK6")
    private String CYQK6;
    @Column(name="CYQK7")
    @JsonProperty("CYQK7")
    private String CYQK7;
    @Column(name="CYQK8")
    @JsonProperty("CYQK8")
    private String CYQK8;
    @Column(name="CYQK9")
    @JsonProperty("CYQK9")
    private String CYQK9;
    @Column(name="CYQK10")
    @JsonProperty("CYQK10")
    private String CYQK10;
    @Column(name="CYQK11")
    @JsonProperty("CYQK11")
    private String CYQK11;
    @Column(name="CYQK12")
    @JsonProperty("CYQK12")
    private String CYQK12;
    @Column(name="CYQK13")
    @JsonProperty("CYQK13")
    private String CYQK13;
    @Column(name="CYQK14")
    @JsonProperty("CYQK14")
    private String CYQK14;
    @Column(name="CYQK15")
    @JsonProperty("CYQK15")
    private String CYQK15;
    @Column(name="CYQK16")
    @JsonProperty("CYQK16")
    private String CYQK16;
    @Column(name="CYQK17")
    @JsonProperty("CYQK17")
    private String CYQK17;
    @Column(name="CYQK18")
    @JsonProperty("CYQK18")
    private String CYQK18;
    @Column(name="CYQK19")
    @JsonProperty("CYQK19")
    private String CYQK19;
    @Column(name="CYQK20")
    @JsonProperty("CYQK20")
    private String CYQK20;

    @Column(name="CYQK21")
    @JsonProperty("CYQK21")
    private String CYQK21;
    @Column(name="CYQK22")
    @JsonProperty("CYQK22")
    private String CYQK22;
    @Column(name="CYQK23")
    @JsonProperty("CYQK23")
    private String CYQK23;
    @Column(name="CYQK24")
    @JsonProperty("CYQK24")
    private String CYQK24;
    @Column(name="CYQK25")
    @JsonProperty("CYQK25")
    private String CYQK25;
    @Column(name="CYQK26")
    @JsonProperty("CYQK26")
    private String CYQK26;
    @Column(name="CYQK27")
    @JsonProperty("CYQK27")
    private String CYQK27;
    @Column(name="CYQK28")
    @JsonProperty("CYQK28")
    private String CYQK28;
    @Column(name="CYQK29")
    @JsonProperty("CYQK29")
    private String CYQK29;
    @Column(name="CYQK30")
    @JsonProperty("CYQK30")
    private String CYQK30;

    @Column(name="CYQK31")
    @JsonProperty("CYQK31")
    private String CYQK31;
    @Column(name="CYQK32")
    @JsonProperty("CYQK32")
    private String CYQK32;
    @Column(name="CYQK33")
    @JsonProperty("CYQK33")
    private String CYQK33;
    @Column(name="CYQK34")
    @JsonProperty("CYQK34")
    private String CYQK34;
    @Column(name="CYQK35")
    @JsonProperty("CYQK35")
    private String CYQK35;
    @Column(name="CYQK36")
    @JsonProperty("CYQK36")
    private String CYQK36;
    @Column(name="CYQK37")
    @JsonProperty("CYQK37")
    private String CYQK37;
    @Column(name="CYQK38")
    @JsonProperty("CYQK38")
    private String CYQK38;
    @Column(name="CYQK39")
    @JsonProperty("CYQK39")
    private String CYQK39;
    @Column(name="CYQK40")
    @JsonProperty("CYQK40")
    private String CYQK40;


    @Column(name="WBYY")
    @JsonProperty("WBYY")
    private String wbyy;
    @Column(name="JBBM1")
    @JsonProperty("JBBM1")
    private String jbbm1;
    @Column(name="BLZD")
    @JsonProperty("BLZD")
    private String blzd;
    @Column(name="JBBM2")
    @JsonProperty("JBBM2")
    private String jbbm2;
    @Column(name="BLH")
    @JsonProperty("BLH")
    private String blh;
    @Column(name="YWGM")
    @JsonProperty("YWGM")
    private String ywgm;
    @Column(name="GMYW")
    @JsonProperty("GMYW")
    private String gmyw;
    @Column(name="SJ")
    @JsonProperty("SJ")
    private String sj;
    @Column(name="XX")
    @JsonProperty("XX")
    private String xx;
    @Column(name="RH")
    @JsonProperty("RH")
    private String rh;
    @Column(name="KZR")
    @JsonProperty("KZR")
    private String kzr;
    @Column(name="KZRDM")
    @JsonProperty("KZRDM")
    private String kzrdm;
    @Column(name="ZRYS")
    @JsonProperty("ZRYS")
    private String zrys;
    @Column(name="ZRYSDM")
    @JsonProperty("ZRYSDM")
    private String zrysdm;
    @Column(name="ZZYS")
    @JsonProperty("ZZYS")
    private String zzys;
    @Column(name="ZZYSDM")
    @JsonProperty("ZZYSDM")
    private String zzysdm;
    @Column(name="ZYYS")
    @JsonProperty("ZYYS")
    private String zyys;
    @Column(name="ZYYSDM")
    @JsonProperty("ZYYSDM")
    private String zyysdm;
    @Column(name="ZRHS")
    @JsonProperty("ZRHS")
    private String zrhs;
    @Column(name="ZRHSDM")
    @JsonProperty("ZRHSDM")
    private String zrhsdm;
    @Column(name="JXYS")
    @JsonProperty("JXYS")
    private String jxys;
    @Column(name="JXYSDM")
    @JsonProperty("JXYSDM")
    private String jxysdm;
    @Column(name="SXYS")
    @JsonProperty("SXYS")
    private String sxys;
    @Column(name="SXYSDM")
    @JsonProperty("SXYSDM")
    private String sxysdm;
    @Column(name="BMY")
    @JsonProperty("BMY")
    private String bmy;
    @Column(name="BAZL")
    @JsonProperty("BAZL")
    private String bazl;
    @Column(name="ZKYS")
    @JsonProperty("ZKYS")
    private String zkys;
    @Column(name="ZKYSDM")
    @JsonProperty("ZKYSDM")
    private String zkysdm;
    @Column(name="ZKHS")
    @JsonProperty("ZKHS")
    private String zkhs;
    @Column(name="ZKHSDM")
    @JsonProperty("ZKHSDM")
    private String zkhsdm;
    @Column(name="ZKRQ")
    @JsonProperty("ZKRQ")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date zkrq;
    @Column(name="SSJCZBMALLC")
    @JsonProperty("SSJCZBMALLC")
    private String SSJCZBMALLC;
    @Column(name="SSJCZBM1")
    @JsonProperty("SSJCZBM1")
    private String ssjczbm1;
    @Column(name="SSJCZMC1")
    @JsonProperty("SSJCZMC1")
    private String ssjczmc1;
    @Column(name="SSJCZRQ1")
    @JsonProperty("SSJCZRQ1")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq1;
    @Column(name="SSJB1")
    @JsonProperty("SSJB1")
    private String ssjb1;
    @Column(name="SZ1")
    @JsonProperty("SZ1")
    private String sz1;
    @Column(name="YZ1")
    @JsonProperty("YZ1")
    private String yz1;
    @Column(name="EZ1")
    @JsonProperty("EZ1")
    private String ez1;
    @Column(name="QKDJ1")
    @JsonProperty("QKDJ1")
    private String qkdj1;
    @Column(name="QKYLB1")
    @JsonProperty("QKYLB1")
    private String qkylb1;
    @Column(name="MZFS1")
    @JsonProperty("MZFS1")
    private String mzfs1;
    @Column(name="MZYS1")
    @JsonProperty("MZYS1")
    private String mzys1;
    @Column(name="SSJCZBM2")
    @JsonProperty("SSJCZBM2")
    private String ssjczbm2;
    @Column(name="SSJCZBM3")
    @JsonProperty("SSJCZBM3")
    private String ssjczbm3;
    @Column(name="SSJCZBM4")
    @JsonProperty("SSJCZBM4")
    private String ssjczbm4;
    @Column(name="SSJCZBM5")
    @JsonProperty("SSJCZBM5")
    private String ssjczbm5;
    @Column(name="SSJCZBM6")
    @JsonProperty("SSJCZBM6")
    private String ssjczbm6;
    @Column(name="SSJCZBM7")
    @JsonProperty("SSJCZBM7")
    private String ssjczbm7;
    @Column(name="SSJCZBM8")
    @JsonProperty("SSJCZBM8")
    private String ssjczbm8;
    @Column(name="SSJCZBM9")
    @JsonProperty("SSJCZBM9")
    private String ssjczbm9;
    @Column(name="SSJCZBM10")
    @JsonProperty("SSJCZBM10")
    private String ssjczbm10;
    @Column(name="SSJCZBM11")
    @JsonProperty("SSJCZBM11")
    private String ssjczbm11;
    @Column(name="SSJCZBM12")
    @JsonProperty("SSJCZBM12")
    private String ssjczbm12;
    @Column(name="SSJCZBM13")
    @JsonProperty("SSJCZBM13")
    private String ssjczbm13;
    @Column(name="SSJCZBM14")
    @JsonProperty("SSJCZBM14")
    private String ssjczbm14;
    @Column(name="SSJCZBM15")
    @JsonProperty("SSJCZBM15")
    private String ssjczbm15;
    @Column(name="SSJCZBM16")
    @JsonProperty("SSJCZBM16")
    private String ssjczbm16;
    @Column(name="SSJCZBM17")
    @JsonProperty("SSJCZBM17")
    private String ssjczbm17;
    @Column(name="SSJCZBM18")
    @JsonProperty("SSJCZBM18")
    private String ssjczbm18;
    @Column(name="SSJCZBM19")
    @JsonProperty("SSJCZBM19")
    private String ssjczbm19;
    @Column(name="SSJCZBM20")
    @JsonProperty("SSJCZBM20")
    private String ssjczbm20;
    @Column(name="SSJCZBM21")
    @JsonProperty("SSJCZBM21")
    private String ssjczbm21;
    @Column(name="SSJCZBM22")
    @JsonProperty("SSJCZBM22")
    private String ssjczbm22;
    @Column(name="SSJCZBM23")
    @JsonProperty("SSJCZBM23")
    private String ssjczbm23;
    @Column(name="SSJCZBM24")
    @JsonProperty("SSJCZBM24")
    private String ssjczbm24;
    @Column(name="SSJCZBM25")
    @JsonProperty("SSJCZBM25")
    private String ssjczbm25;
    @Column(name="SSJCZBM26")
    @JsonProperty("SSJCZBM26")
    private String ssjczbm26;
    @Column(name="SSJCZBM27")
    @JsonProperty("SSJCZBM27")
    private String ssjczbm27;
    @Column(name="SSJCZBM28")
    @JsonProperty("SSJCZBM28")
    private String ssjczbm28;
    @Column(name="SSJCZBM29")
    @JsonProperty("SSJCZBM29")
    private String ssjczbm29;
    @Column(name="SSJCZBM30")
    @JsonProperty("SSJCZBM30")
    private String ssjczbm30;
    @Column(name="SSJCZBM31")
    @JsonProperty("SSJCZBM31")
    private String ssjczbm31;
    @Column(name="SSJCZBM32")
    @JsonProperty("SSJCZBM32")
    private String ssjczbm32;
    @Column(name="SSJCZBM33")
    @JsonProperty("SSJCZBM33")
    private String ssjczbm33;
    @Column(name="SSJCZBM34")
    @JsonProperty("SSJCZBM34")
    private String ssjczbm34;
    @Column(name="SSJCZBM35")
    @JsonProperty("SSJCZBM35")
    private String ssjczbm35;
    @Column(name="SSJCZBM36")
    @JsonProperty("SSJCZBM36")
    private String ssjczbm36;
    @Column(name="SSJCZBM37")
    @JsonProperty("SSJCZBM37")
    private String ssjczbm37;
    @Column(name="SSJCZBM38")
    @JsonProperty("SSJCZBM38")
    private String ssjczbm38;
    @Column(name="SSJCZBM39")
    @JsonProperty("SSJCZBM39")
    private String ssjczbm39;
    @Column(name="SSJCZBM40")
    @JsonProperty("SSJCZBM40")
    private String ssjczbm40;
    @Column(name="SSJCZBM41")
    @JsonProperty("SSJCZBM41")
    private String ssjczbm41;
    @Column(name="SSJCZMC2")
    @JsonProperty("SSJCZMC2")
    private String ssjczmc2;
    @Column(name="SSJCZMC3")
    @JsonProperty("SSJCZMC3")
    private String ssjczmc3;
    @Column(name="SSJCZMC4")
    @JsonProperty("SSJCZMC4")
    private String ssjczmc4;
    @Column(name="SSJCZMC5")
    @JsonProperty("SSJCZMC5")
    private String ssjczmc5;
    @Column(name="SSJCZMC6")
    @JsonProperty("SSJCZMC6")
    private String ssjczmc6;
    @Column(name="SSJCZMC7")
    @JsonProperty("SSJCZMC7")
    private String ssjczmc7;
    @Column(name="SSJCZMC8")
    @JsonProperty("SSJCZMC8")
    private String ssjczmc8;
    @Column(name="SSJCZMC9")
    @JsonProperty("SSJCZMC9")
    private String ssjczmc9;
    @Column(name="SSJCZMC10")
    @JsonProperty("SSJCZMC10")
    private String ssjczmc10;
    @Column(name="SSJCZMC11")
    @JsonProperty("SSJCZMC11")
    private String ssjczmc11;
    @Column(name="SSJCZMC12")
    @JsonProperty("SSJCZMC12")
    private String ssjczmc12;
    @Column(name="SSJCZMC13")
    @JsonProperty("SSJCZMC13")
    private String ssjczmc13;
    @Column(name="SSJCZMC14")
    @JsonProperty("SSJCZMC14")
    private String ssjczmc14;
    @Column(name="SSJCZMC15")
    @JsonProperty("SSJCZMC15")
    private String ssjczmc15;
    @Column(name="SSJCZMC16")
    @JsonProperty("SSJCZMC16")
    private String ssjczmc16;
    @Column(name="SSJCZMC17")
    @JsonProperty("SSJCZMC17")
    private String ssjczmc17;
    @Column(name="SSJCZMC18")
    @JsonProperty("SSJCZMC18")
    private String ssjczmc18;
    @Column(name="SSJCZMC19")
    @JsonProperty("SSJCZMC19")
    private String ssjczmc19;
    @Column(name="SSJCZMC20")
    @JsonProperty("SSJCZMC20")
    private String ssjczmc20;
    @Column(name="SSJCZMC21")
    @JsonProperty("SSJCZMC21")
    private String ssjczmc21;
    @Column(name="SSJCZMC22")
    @JsonProperty("SSJCZMC22")
    private String ssjczmc22;
    @Column(name="SSJCZMC23")
    @JsonProperty("SSJCZMC23")
    private String ssjczmc23;
    @Column(name="SSJCZMC24")
    @JsonProperty("SSJCZMC24")
    private String ssjczmc24;
    @Column(name="SSJCZMC25")
    @JsonProperty("SSJCZMC25")
    private String ssjczmc25;
    @Column(name="SSJCZMC26")
    @JsonProperty("SSJCZMC26")
    private String ssjczmc26;
    @Column(name="SSJCZMC27")
    @JsonProperty("SSJCZMC27")
    private String ssjczmc27;
    @Column(name="SSJCZMC28")
    @JsonProperty("SSJCZMC28")
    private String ssjczmc28;
    @Column(name="SSJCZMC29")
    @JsonProperty("SSJCZMC29")
    private String ssjczmc29;
    @Column(name="SSJCZMC30")
    @JsonProperty("SSJCZMC30")
    private String ssjczmc30;
    @Column(name="SSJCZMC31")
    @JsonProperty("SSJCZMC31")
    private String ssjczmc31;
    @Column(name="SSJCZMC32")
    @JsonProperty("SSJCZMC32")
    private String ssjczmc32;
    @Column(name="SSJCZMC33")
    @JsonProperty("SSJCZMC33")
    private String ssjczmc33;
    @Column(name="SSJCZMC34")
    @JsonProperty("SSJCZMC34")
    private String ssjczmc34;
    @Column(name="SSJCZMC35")
    @JsonProperty("SSJCZMC35")
    private String ssjczmc35;
    @Column(name="SSJCZMC36")
    @JsonProperty("SSJCZMC36")
    private String ssjczmc36;
    @Column(name="SSJCZMC37")
    @JsonProperty("SSJCZMC37")
    private String ssjczmc37;
    @Column(name="SSJCZMC38")
    @JsonProperty("SSJCZMC38")
    private String ssjczmc38;
    @Column(name="SSJCZMC39")
    @JsonProperty("SSJCZMC39")
    private String ssjczmc39;
    @Column(name="SSJCZMC40")
    @JsonProperty("SSJCZMC40")
    private String ssjczmc40;
    @Column(name="SSJCZMC41")
    @JsonProperty("SSJCZMC41")
    private String ssjczmc41;
    @Column(name="SSJCZRQ2")
    @JsonProperty("SSJCZRQ2")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq2;
    @Column(name="SSJCZRQ3")
    @JsonProperty("SSJCZRQ3")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq3;
    @Column(name="SSJCZRQ4")
    @JsonProperty("SSJCZRQ4")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq4;
    @Column(name="SSJCZRQ5")
    @JsonProperty("SSJCZRQ5")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq5;
    @Column(name="SSJCZRQ6")
    @JsonProperty("SSJCZRQ6")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq6;
    @Column(name="SSJCZRQ7")
    @JsonProperty("SSJCZRQ7")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq7;
    @Column(name="SSJCZRQ8")
    @JsonProperty("SSJCZRQ8")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq8;
    @Column(name="SSJCZRQ9")
    @JsonProperty("SSJCZRQ9")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq9;
    @Column(name="SSJCZRQ10")
    @JsonProperty("SSJCZRQ10")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq10;
    @Column(name="SSJCZRQ11")
    @JsonProperty("SSJCZRQ11")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq11;
    @Column(name="SSJCZRQ12")
    @JsonProperty("SSJCZRQ12")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq12;
    @Column(name="SSJCZRQ13")
    @JsonProperty("SSJCZRQ13")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq13;
    @Column(name="SSJCZRQ14")
    @JsonProperty("SSJCZRQ14")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq14;
    @Column(name="SSJCZRQ15")
    @JsonProperty("SSJCZRQ15")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq15;
    @Column(name="SSJCZRQ16")
    @JsonProperty("SSJCZRQ16")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq16;
    @Column(name="SSJCZRQ17")
    @JsonProperty("SSJCZRQ17")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq17;
    @Column(name="SSJCZRQ18")
    @JsonProperty("SSJCZRQ18")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq18;
    @Column(name="SSJCZRQ19")
    @JsonProperty("SSJCZRQ19")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq19;
    @Column(name="SSJCZRQ20")
    @JsonProperty("SSJCZRQ20")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq20;
    @Column(name="SSJCZRQ21")
    @JsonProperty("SSJCZRQ21")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq21;
    @Column(name="SSJCZRQ22")
    @JsonProperty("SSJCZRQ22")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq22;
    @Column(name="SSJCZRQ23")
    @JsonProperty("SSJCZRQ23")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq23;
    @Column(name="SSJCZRQ24")
    @JsonProperty("SSJCZRQ24")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq24;
    @Column(name="SSJCZRQ25")
    @JsonProperty("SSJCZRQ25")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq25;
    @Column(name="SSJCZRQ26")
    @JsonProperty("SSJCZRQ26")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq26;
    @Column(name="SSJCZRQ27")
    @JsonProperty("SSJCZRQ27")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq27;
    @Column(name="SSJCZRQ28")
    @JsonProperty("SSJCZRQ28")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq28;
    @Column(name="SSJCZRQ29")
    @JsonProperty("SSJCZRQ29")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq29;
    @Column(name="SSJCZRQ30")
    @JsonProperty("SSJCZRQ30")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq30;
    @Column(name="SSJCZRQ31")
    @JsonProperty("SSJCZRQ31")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq31;
    @Column(name="SSJCZRQ32")
    @JsonProperty("SSJCZRQ32")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq32;
    @Column(name="SSJCZRQ33")
    @JsonProperty("SSJCZRQ33")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq33;
    @Column(name="SSJCZRQ34")
    @JsonProperty("SSJCZRQ34")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq34;
    @Column(name="SSJCZRQ35")
    @JsonProperty("SSJCZRQ35")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq35;
    @Column(name="SSJCZRQ36")
    @JsonProperty("SSJCZRQ36")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq36;
    @Column(name="SSJCZRQ37")
    @JsonProperty("SSJCZRQ37")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq37;
    @Column(name="SSJCZRQ38")
    @JsonProperty("SSJCZRQ38")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq38;
    @Column(name="SSJCZRQ39")
    @JsonProperty("SSJCZRQ39")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq39;
    @Column(name="SSJCZRQ40")
    @JsonProperty("SSJCZRQ40")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq40;
    @Column(name="SSJCZRQ41")
    @JsonProperty("SSJCZRQ41")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Timestamp ssjczrq41;
    @Column(name="SSJB2")
    @JsonProperty("SSJB2")
    private String ssjb2;
    @Column(name="SSJB3")
    @JsonProperty("SSJB3")
    private String ssjb3;
    @Column(name="SSJB4")
    @JsonProperty("SSJB4")
    private String ssjb4;
    @Column(name="SSJB5")
    @JsonProperty("SSJB5")
    private String ssjb5;
    @Column(name="SSJB6")
    @JsonProperty("SSJB6")
    private String ssjb6;
    @Column(name="SSJB7")
    @JsonProperty("SSJB7")
    private String ssjb7;
    @Column(name="SSJB8")
    @JsonProperty("SSJB8")
    private String ssjb8;
    @Column(name="SSJB9")
    @JsonProperty("SSJB9")
    private String ssjb9;
    @Column(name="SSJB10")
    @JsonProperty("SSJB10")
    private String ssjb10;
    @Column(name="SSJB11")
    @JsonProperty("SSJB11")
    private String ssjb11;
    @Column(name="SSJB12")
    @JsonProperty("SSJB12")
    private String ssjb12;
    @Column(name="SSJB13")
    @JsonProperty("SSJB13")
    private String ssjb13;
    @Column(name="SSJB14")
    @JsonProperty("SSJB14")
    private String ssjb14;
    @Column(name="SSJB15")
    @JsonProperty("SSJB15")
    private String ssjb15;
    @Column(name="SSJB16")
    @JsonProperty("SSJB16")
    private String ssjb16;
    @Column(name="SSJB17")
    @JsonProperty("SSJB17")
    private String ssjb17;
    @Column(name="SSJB18")
    @JsonProperty("SSJB18")
    private String ssjb18;
    @Column(name="SSJB19")
    @JsonProperty("SSJB19")
    private String ssjb19;
    @Column(name="SSJB20")
    @JsonProperty("SSJB20")
    private String ssjb20;
    @Column(name="SSJB21")
    @JsonProperty("SSJB21")
    private String ssjb21;
    @Column(name="SSJB22")
    @JsonProperty("SSJB22")
    private String ssjb22;
    @Column(name="SSJB23")
    @JsonProperty("SSJB23")
    private String ssjb23;
    @Column(name="SSJB24")
    @JsonProperty("SSJB24")
    private String ssjb24;
    @Column(name="SSJB25")
    @JsonProperty("SSJB25")
    private String ssjb25;
    @Column(name="SSJB26")
    @JsonProperty("SSJB26")
    private String ssjb26;
    @Column(name="SSJB27")
    @JsonProperty("SSJB27")
    private String ssjb27;
    @Column(name="SSJB28")
    @JsonProperty("SSJB28")
    private String ssjb28;
    @Column(name="SSJB29")
    @JsonProperty("SSJB29")
    private String ssjb29;
    @Column(name="SSJB30")
    @JsonProperty("SSJB30")
    private String ssjb30;
    @Column(name="SSJB31")
    @JsonProperty("SSJB31")
    private String ssjb31;
    @Column(name="SSJB32")
    @JsonProperty("SSJB32")
    private String ssjb32;
    @Column(name="SSJB33")
    @JsonProperty("SSJB33")
    private String ssjb33;
    @Column(name="SSJB34")
    @JsonProperty("SSJB34")
    private String ssjb34;
    @Column(name="SSJB35")
    @JsonProperty("SSJB35")
    private String ssjb35;
    @Column(name="SSJB36")
    @JsonProperty("SSJB36")
    private String ssjb36;
    @Column(name="SSJB37")
    @JsonProperty("SSJB37")
    private String ssjb37;
    @Column(name="SSJB38")
    @JsonProperty("SSJB38")
    private String ssjb38;
    @Column(name="SSJB39")
    @JsonProperty("SSJB39")
    private String ssjb39;
    @Column(name="SSJB40")
    @JsonProperty("SSJB40")
    private String ssjb40;
    @Column(name="SSJB41")
    @JsonProperty("SSJB41")
    private String ssjb41;
    @Column(name="SZ2")
    @JsonProperty("SZ2")
    private String sz2;
    @Column(name="SZ3")
    @JsonProperty("SZ3")
    private String sz3;
    @Column(name="SZ4")
    @JsonProperty("SZ4")
    private String sz4;
    @Column(name="SZ5")
    @JsonProperty("SZ5")
    private String sz5;
    @Column(name="SZ6")
    @JsonProperty("SZ6")
    private String sz6;
    @Column(name="SZ7")
    @JsonProperty("SZ7")
    private String sz7;
    @Column(name="SZ8")
    @JsonProperty("SZ8")
    private String sz8;
    @Column(name="SZ9")
    @JsonProperty("SZ9")
    private String sz9;
    @Column(name="SZ10")
    @JsonProperty("SZ10")
    private String sz10;
    @Column(name="SZ11")
    @JsonProperty("SZ11")
    private String sz11;
    @Column(name="SZ12")
    @JsonProperty("SZ12")
    private String sz12;
    @Column(name="SZ13")
    @JsonProperty("SZ13")
    private String sz13;
    @Column(name="SZ14")
    @JsonProperty("SZ14")
    private String sz14;
    @Column(name="SZ15")
    @JsonProperty("SZ15")
    private String sz15;
    @Column(name="SZ16")
    @JsonProperty("SZ16")
    private String sz16;
    @Column(name="SZ17")
    @JsonProperty("SZ17")
    private String sz17;
    @Column(name="SZ18")
    @JsonProperty("SZ18")
    private String sz18;
    @Column(name="SZ19")
    @JsonProperty("SZ19")
    private String sz19;
    @Column(name="SZ20")
    @JsonProperty("SZ20")
    private String sz20;
    @Column(name="SZ21")
    @JsonProperty("SZ21")
    private String sz21;
    @Column(name="SZ22")
    @JsonProperty("SZ22")
    private String sz22;
    @Column(name="SZ23")
    @JsonProperty("SZ23")
    private String sz23;
    @Column(name="SZ24")
    @JsonProperty("SZ24")
    private String sz24;
    @Column(name="SZ25")
    @JsonProperty("SZ25")
    private String sz25;
    @Column(name="SZ26")
    @JsonProperty("SZ26")
    private String sz26;
    @Column(name="SZ27")
    @JsonProperty("SZ27")
    private String sz27;
    @Column(name="SZ28")
    @JsonProperty("SZ28")
    private String sz28;
    @Column(name="SZ29")
    @JsonProperty("SZ29")
    private String sz29;
    @Column(name="SZ30")
    @JsonProperty("SZ30")
    private String sz30;
    @Column(name="SZ31")
    @JsonProperty("SZ31")
    private String sz31;
    @Column(name="SZ32")
    @JsonProperty("SZ32")
    private String sz32;
    @Column(name="SZ33")
    @JsonProperty("SZ33")
    private String sz33;
    @Column(name="SZ34")
    @JsonProperty("SZ34")
    private String sz34;
    @Column(name="SZ35")
    @JsonProperty("SZ35")
    private String sz35;
    @Column(name="SZ36")
    @JsonProperty("SZ36")
    private String sz36;
    @Column(name="SZ37")
    @JsonProperty("SZ37")
    private String sz37;
    @Column(name="SZ38")
    @JsonProperty("SZ38")
    private String sz38;
    @Column(name="SZ39")
    @JsonProperty("SZ39")
    private String sz39;
    @Column(name="SZ40")
    @JsonProperty("SZ40")
    private String sz40;
    @Column(name="SZ41")
    @JsonProperty("SZ41")
    private String sz41;
    @Column(name="YZ2")
    @JsonProperty("YZ2")
    private String yz2;
    @Column(name="YZ3")
    @JsonProperty("YZ3")
    private String yz3;
    @Column(name="YZ4")
    @JsonProperty("YZ4")
    private String yz4;
    @Column(name="YZ5")
    @JsonProperty("YZ5")
    private String yz5;
    @Column(name="YZ6")
    @JsonProperty("YZ6")
    private String yz6;
    @Column(name="YZ7")
    @JsonProperty("YZ7")
    private String yz7;
    @Column(name="YZ8")
    @JsonProperty("YZ8")
    private String yz8;
    @Column(name="YZ9")
    @JsonProperty("YZ9")
    private String yz9;
    @Column(name="YZ10")
    @JsonProperty("YZ10")
    private String yz10;
    @Column(name="YZ11")
    @JsonProperty("YZ11")
    private String yz11;
    @Column(name="YZ12")
    @JsonProperty("YZ12")
    private String yz12;
    @Column(name="YZ13")
    @JsonProperty("YZ13")
    private String yz13;
    @Column(name="YZ14")
    @JsonProperty("YZ14")
    private String yz14;
    @Column(name="YZ15")
    @JsonProperty("YZ15")
    private String yz15;
    @Column(name="YZ16")
    @JsonProperty("YZ16")
    private String yz16;
    @Column(name="YZ17")
    @JsonProperty("YZ17")
    private String yz17;
    @Column(name="YZ18")
    @JsonProperty("YZ18")
    private String yz18;
    @Column(name="YZ19")
    @JsonProperty("YZ19")
    private String yz19;
    @Column(name="YZ20")
    @JsonProperty("YZ20")
    private String yz20;
    @Column(name="YZ21")
    @JsonProperty("YZ21")
    private String yz21;
    @Column(name="YZ22")
    @JsonProperty("YZ22")
    private String yz22;
    @Column(name="YZ23")
    @JsonProperty("YZ23")
    private String yz23;
    @Column(name="YZ24")
    @JsonProperty("YZ24")
    private String yz24;
    @Column(name="YZ25")
    @JsonProperty("YZ25")
    private String yz25;
    @Column(name="YZ26")
    @JsonProperty("YZ26")
    private String yz26;
    @Column(name="YZ27")
    @JsonProperty("YZ27")
    private String yz27;
    @Column(name="YZ28")
    @JsonProperty("YZ28")
    private String yz28;
    @Column(name="YZ29")
    @JsonProperty("YZ29")
    private String yz29;
    @Column(name="YZ30")
    @JsonProperty("YZ30")
    private String yz30;
    @Column(name="YZ31")
    @JsonProperty("YZ31")
    private String yz31;
    @Column(name="YZ32")
    @JsonProperty("YZ32")
    private String yz32;
    @Column(name="YZ33")
    @JsonProperty("YZ33")
    private String yz33;
    @Column(name="YZ34")
    @JsonProperty("YZ34")
    private String yz34;
    @Column(name="YZ35")
    @JsonProperty("YZ35")
    private String yz35;
    @Column(name="YZ36")
    @JsonProperty("YZ36")
    private String yz36;
    @Column(name="YZ37")
    @JsonProperty("YZ37")
    private String yz37;
    @Column(name="YZ38")
    @JsonProperty("YZ38")
    private String yz38;
    @Column(name="YZ39")
    @JsonProperty("YZ39")
    private String yz39;
    @Column(name="YZ40")
    @JsonProperty("YZ40")
    private String yz40;
    @Column(name="YZ41")
    @JsonProperty("YZ41")
    private String yz41;
    @Column(name="EZ2")
    @JsonProperty("EZ2")
    private String ez2;
    @Column(name="EZ3")
    @JsonProperty("EZ3")
    private String ez3;
    @Column(name="EZ4")
    @JsonProperty("EZ4")
    private String ez4;
    @Column(name="EZ5")
    @JsonProperty("EZ5")
    private String ez5;
    @Column(name="EZ6")
    @JsonProperty("EZ6")
    private String ez6;
    @Column(name="EZ7")
    @JsonProperty("EZ7")
    private String ez7;
    @Column(name="EZ8")
    @JsonProperty("EZ8")
    private String ez8;
    @Column(name="EZ9")
    @JsonProperty("EZ9")
    private String ez9;
    @Column(name="EZ10")
    @JsonProperty("EZ10")
    private String ez10;
    @Column(name="EZ11")
    @JsonProperty("EZ11")
    private String ez11;
    @Column(name="EZ12")
    @JsonProperty("EZ12")
    private String ez12;
    @Column(name="EZ13")
    @JsonProperty("EZ13")
    private String ez13;
    @Column(name="EZ14")
    @JsonProperty("EZ14")
    private String ez14;
    @Column(name="EZ15")
    @JsonProperty("EZ15")
    private String ez15;
    @Column(name="EZ16")
    @JsonProperty("EZ16")
    private String ez16;
    @Column(name="EZ17")
    @JsonProperty("EZ17")
    private String ez17;
    @Column(name="EZ18")
    @JsonProperty("EZ18")
    private String ez18;
    @Column(name="EZ19")
    @JsonProperty("EZ19")
    private String ez19;
    @Column(name="EZ20")
    @JsonProperty("EZ20")
    private String ez20;
    @Column(name="EZ21")
    @JsonProperty("EZ21")
    private String ez21;
    @Column(name="EZ22")
    @JsonProperty("EZ22")
    private String ez22;
    @Column(name="EZ23")
    @JsonProperty("EZ23")
    private String ez23;
    @Column(name="EZ24")
    @JsonProperty("EZ24")
    private String ez24;
    @Column(name="EZ25")
    @JsonProperty("EZ25")
    private String ez25;
    @Column(name="EZ26")
    @JsonProperty("EZ26")
    private String ez26;
    @Column(name="EZ27")
    @JsonProperty("EZ27")
    private String ez27;
    @Column(name="EZ28")
    @JsonProperty("EZ28")
    private String ez28;
    @Column(name="EZ29")
    @JsonProperty("EZ29")
    private String ez29;
    @Column(name="EZ30")
    @JsonProperty("EZ30")
    private String ez30;
    @Column(name="EZ31")
    @JsonProperty("EZ31")
    private String ez31;
    @Column(name="EZ32")
    @JsonProperty("EZ32")
    private String ez32;
    @Column(name="EZ33")
    @JsonProperty("EZ33")
    private String ez33;
    @Column(name="EZ34")
    @JsonProperty("EZ34")
    private String ez34;
    @Column(name="EZ35")
    @JsonProperty("EZ35")
    private String ez35;
    @Column(name="EZ36")
    @JsonProperty("EZ36")
    private String ez36;
    @Column(name="EZ37")
    @JsonProperty("EZ37")
    private String ez37;
    @Column(name="EZ38")
    @JsonProperty("EZ38")
    private String ez38;
    @Column(name="EZ39")
    @JsonProperty("EZ39")
    private String ez39;
    @Column(name="EZ40")
    @JsonProperty("EZ40")
    private String ez40;
    @Column(name="EZ41")
    @JsonProperty("EZ41")
    private String ez41;
    @Column(name="QKDJ2")
    @JsonProperty("QKDJ2")
    private String qkdj2;
    @Column(name="QKDJ3")
    @JsonProperty("QKDJ3")
    private String qkdj3;
    @Column(name="QKDJ4")
    @JsonProperty("QKDJ4")
    private String qkdj4;
    @Column(name="QKDJ5")
    @JsonProperty("QKDJ5")
    private String qkdj5;
    @Column(name="QKDJ6")
    @JsonProperty("QKDJ6")
    private String qkdj6;
    @Column(name="QKDJ7")
    @JsonProperty("QKDJ7")
    private String qkdj7;
    @Column(name="QKDJ8")
    @JsonProperty("QKDJ8")
    private String qkdj8;
    @Column(name="QKDJ9")
    @JsonProperty("QKDJ9")
    private String qkdj9;
    @Column(name="QKDJ10")
    @JsonProperty("QKDJ10")
    private String qkdj10;
    @Column(name="QKDJ11")
    @JsonProperty("QKDJ11")
    private String qkdj11;
    @Column(name="QKDJ12")
    @JsonProperty("QKDJ12")
    private String qkdj12;
    @Column(name="QKDJ13")
    @JsonProperty("QKDJ13")
    private String qkdj13;
    @Column(name="QKDJ14")
    @JsonProperty("QKDJ14")
    private String qkdj14;
    @Column(name="QKDJ15")
    @JsonProperty("QKDJ15")
    private String qkdj15;
    @Column(name="QKDJ16")
    @JsonProperty("QKDJ16")
    private String qkdj16;
    @Column(name="QKDJ17")
    @JsonProperty("QKDJ17")
    private String qkdj17;
    @Column(name="QKDJ18")
    @JsonProperty("QKDJ18")
    private String qkdj18;
    @Column(name="QKDJ19")
    @JsonProperty("QKDJ19")
    private String qkdj19;
    @Column(name="QKDJ20")
    @JsonProperty("QKDJ20")
    private String qkdj20;
    @Column(name="QKDJ21")
    @JsonProperty("QKDJ21")
    private String qkdj21;
    @Column(name="QKDJ22")
    @JsonProperty("QKDJ22")
    private String qkdj22;
    @Column(name="QKDJ23")
    @JsonProperty("QKDJ23")
    private String qkdj23;
    @Column(name="QKDJ24")
    @JsonProperty("QKDJ24")
    private String qkdj24;
    @Column(name="QKDJ25")
    @JsonProperty("QKDJ25")
    private String qkdj25;
    @Column(name="QKDJ26")
    @JsonProperty("QKDJ26")
    private String qkdj26;
    @Column(name="QKDJ27")
    @JsonProperty("QKDJ27")
    private String qkdj27;
    @Column(name="QKDJ28")
    @JsonProperty("QKDJ28")
    private String qkdj28;
    @Column(name="QKDJ29")
    @JsonProperty("QKDJ29")
    private String qkdj29;
    @Column(name="QKDJ30")
    @JsonProperty("QKDJ30")
    private String qkdj30;
    @Column(name="QKDJ31")
    @JsonProperty("QKDJ31")
    private String qkdj31;
    @Column(name="QKDJ32")
    @JsonProperty("QKDJ32")
    private String qkdj32;
    @Column(name="QKDJ33")
    @JsonProperty("QKDJ33")
    private String qkdj33;
    @Column(name="QKDJ34")
    @JsonProperty("QKDJ34")
    private String qkdj34;
    @Column(name="QKDJ35")
    @JsonProperty("QKDJ35")
    private String qkdj35;
    @Column(name="QKDJ36")
    @JsonProperty("QKDJ36")
    private String qkdj36;
    @Column(name="QKDJ37")
    @JsonProperty("QKDJ37")
    private String qkdj37;
    @Column(name="QKDJ38")
    @JsonProperty("QKDJ38")
    private String qkdj38;
    @Column(name="QKDJ39")
    @JsonProperty("QKDJ39")
    private String qkdj39;
    @Column(name="QKDJ40")
    @JsonProperty("QKDJ40")
    private String qkdj40;
    @Column(name="QKDJ41")
    @JsonProperty("QKDJ41")
    private String qkdj41;
    @Column(name="QKYLB2")
    @JsonProperty("QKYLB2")
    private String qkylb2;
    @Column(name="QKYLB3")
    @JsonProperty("QKYLB3")
    private String qkylb3;
    @Column(name="QKYLB4")
    @JsonProperty("QKYLB4")
    private String qkylb4;
    @Column(name="QKYLB5")
    @JsonProperty("QKYLB5")
    private String qkylb5;
    @Column(name="QKYLB6")
    @JsonProperty("QKYLB6")
    private String qkylb6;
    @Column(name="QKYLB7")
    @JsonProperty("QKYLB7")
    private String qkylb7;
    @Column(name="QKYLB8")
    @JsonProperty("QKYLB8")
    private String qkylb8;
    @Column(name="QKYLB9")
    @JsonProperty("QKYLB9")
    private String qkylb9;
    @Column(name="QKYLB10")
    @JsonProperty("QKYLB10")
    private String qkylb10;
    @Column(name="QKYLB11")
    @JsonProperty("QKYLB11")
    private String qkylb11;
    @Column(name="QKYLB12")
    @JsonProperty("QKYLB12")
    private String qkylb12;
    @Column(name="QKYLB13")
    @JsonProperty("QKYLB13")
    private String qkylb13;
    @Column(name="QKYLB14")
    @JsonProperty("QKYLB14")
    private String qkylb14;
    @Column(name="QKYLB15")
    @JsonProperty("QKYLB15")
    private String qkylb15;
    @Column(name="QKYLB16")
    @JsonProperty("QKYLB16")
    private String qkylb16;
    @Column(name="QKYLB17")
    @JsonProperty("QKYLB17")
    private String qkylb17;
    @Column(name="QKYLB18")
    @JsonProperty("QKYLB18")
    private String qkylb18;
    @Column(name="QKYLB19")
    @JsonProperty("QKYLB19")
    private String qkylb19;
    @Column(name="QKYLB20")
    @JsonProperty("QKYLB20")
    private String qkylb20;
    @Column(name="QKYLB21")
    @JsonProperty("QKYLB21")
    private String qkylb21;
    @Column(name="QKYLB22")
    @JsonProperty("QKYLB22")
    private String qkylb22;
    @Column(name="QKYLB23")
    @JsonProperty("QKYLB23")
    private String qkylb23;
    @Column(name="QKYLB24")
    @JsonProperty("QKYLB24")
    private String qkylb24;
    @Column(name="QKYLB25")
    @JsonProperty("QKYLB25")
    private String qkylb25;
    @Column(name="QKYLB26")
    @JsonProperty("QKYLB26")
    private String qkylb26;
    @Column(name="QKYLB27")
    @JsonProperty("QKYLB27")
    private String qkylb27;
    @Column(name="QKYLB28")
    @JsonProperty("QKYLB28")
    private String qkylb28;
    @Column(name="QKYLB29")
    @JsonProperty("QKYLB29")
    private String qkylb29;
    @Column(name="QKYLB30")
    @JsonProperty("QKYLB30")
    private String qkylb30;
    @Column(name="QKYLB31")
    @JsonProperty("QKYLB31")
    private String qkylb31;
    @Column(name="QKYLB32")
    @JsonProperty("QKYLB32")
    private String qkylb32;
    @Column(name="QKYLB33")
    @JsonProperty("QKYLB33")
    private String qkylb33;
    @Column(name="QKYLB34")
    @JsonProperty("QKYLB34")
    private String qkylb34;
    @Column(name="QKYLB35")
    @JsonProperty("QKYLB35")
    private String qkylb35;
    @Column(name="QKYLB36")
    @JsonProperty("QKYLB36")
    private String qkylb36;
    @Column(name="QKYLB37")
    @JsonProperty("QKYLB37")
    private String qkylb37;
    @Column(name="QKYLB38")
    @JsonProperty("QKYLB38")
    private String qkylb38;
    @Column(name="QKYLB39")
    @JsonProperty("QKYLB39")
    private String qkylb39;
    @Column(name="QKYLB40")
    @JsonProperty("QKYLB40")
    private String qkylb40;
    @Column(name="QKYLB41")
    @JsonProperty("QKYLB41")
    private String qkylb41;
    @Column(name="MZFS2")
    @JsonProperty("MZFS2")
    private String mzfs2;
    @Column(name="MZFS3")
    @JsonProperty("MZFS3")
    private String mzfs3;
    @Column(name="MZFS4")
    @JsonProperty("MZFS4")
    private String mzfs4;
    @Column(name="MZFS5")
    @JsonProperty("MZFS5")
    private String mzfs5;
    @Column(name="MZFS6")
    @JsonProperty("MZFS6")
    private String mzfs6;
    @Column(name="MZFS7")
    @JsonProperty("MZFS7")
    private String mzfs7;
    @Column(name="MZFS8")
    @JsonProperty("MZFS8")
    private String mzfs8;
    @Column(name="MZFS9")
    @JsonProperty("MZFS9")
    private String mzfs9;
    @Column(name="MZFS10")
    @JsonProperty("MZFS10")
    private String mzfs10;
    @Column(name="MZFS11")
    @JsonProperty("MZFS11")
    private String mzfs11;
    @Column(name="MZFS12")
    @JsonProperty("MZFS12")
    private String mzfs12;
    @Column(name="MZFS13")
    @JsonProperty("MZFS13")
    private String mzfs13;
    @Column(name="MZFS14")
    @JsonProperty("MZFS14")
    private String mzfs14;
    @Column(name="MZFS15")
    @JsonProperty("MZFS15")
    private String mzfs15;
    @Column(name="MZFS16")
    @JsonProperty("MZFS16")
    private String mzfs16;
    @Column(name="MZFS17")
    @JsonProperty("MZFS17")
    private String mzfs17;
    @Column(name="MZFS18")
    @JsonProperty("MZFS18")
    private String mzfs18;
    @Column(name="MZFS19")
    @JsonProperty("MZFS19")
    private String mzfs19;
    @Column(name="MZFS20")
    @JsonProperty("MZFS20")
    private String mzfs20;
    @Column(name="MZFS21")
    @JsonProperty("MZFS21")
    private String mzfs21;
    @Column(name="MZFS22")
    @JsonProperty("MZFS22")
    private String mzfs22;
    @Column(name="MZFS23")
    @JsonProperty("MZFS23")
    private String mzfs23;
    @Column(name="MZFS24")
    @JsonProperty("MZFS24")
    private String mzfs24;
    @Column(name="MZFS25")
    @JsonProperty("MZFS25")
    private String mzfs25;
    @Column(name="MZFS26")
    @JsonProperty("MZFS26")
    private String mzfs26;
    @Column(name="MZFS27")
    @JsonProperty("MZFS27")
    private String mzfs27;
    @Column(name="MZFS28")
    @JsonProperty("MZFS28")
    private String mzfs28;
    @Column(name="MZFS29")
    @JsonProperty("MZFS29")
    private String mzfs29;
    @Column(name="MZFS30")
    @JsonProperty("MZFS30")
    private String mzfs30;
    @Column(name="MZFS31")
    @JsonProperty("MZFS31")
    private String mzfs31;
    @Column(name="MZFS32")
    @JsonProperty("MZFS32")
    private String mzfs32;
    @Column(name="MZFS33")
    @JsonProperty("MZFS33")
    private String mzfs33;
    @Column(name="MZFS34")
    @JsonProperty("MZFS34")
    private String mzfs34;
    @Column(name="MZFS35")
    @JsonProperty("MZFS35")
    private String mzfs35;
    @Column(name="MZFS36")
    @JsonProperty("MZFS36")
    private String mzfs36;
    @Column(name="MZFS37")
    @JsonProperty("MZFS37")
    private String mzfs37;
    @Column(name="MZFS38")
    @JsonProperty("MZFS38")
    private String mzfs38;
    @Column(name="MZFS39")
    @JsonProperty("MZFS39")
    private String mzfs39;
    @Column(name="MZFS40")
    @JsonProperty("MZFS40")
    private String mzfs40;
    @Column(name="MZFS41")
    @JsonProperty("MZFS41")
    private String mzfs41;
    @Column(name="MZYS2")
    @JsonProperty("MZYS2")
    private String mzys2;
    @Column(name="MZYS3")
    @JsonProperty("MZYS3")
    private String mzys3;
    @Column(name="MZYS4")
    @JsonProperty("MZYS4")
    private String mzys4;
    @Column(name="MZYS5")
    @JsonProperty("MZYS5")
    private String mzys5;
    @Column(name="MZYS6")
    @JsonProperty("MZYS6")
    private String mzys6;
    @Column(name="MZYS7")
    @JsonProperty("MZYS7")
    private String mzys7;
    @Column(name="MZYS8")
    @JsonProperty("MZYS8")
    private String mzys8;
    @Column(name="MZYS9")
    @JsonProperty("MZYS9")
    private String mzys9;
    @Column(name="MZYS10")
    @JsonProperty("MZYS10")
    private String mzys10;
    @Column(name="MZYS11")
    @JsonProperty("MZYS11")
    private String mzys11;
    @Column(name="MZYS12")
    @JsonProperty("MZYS12")
    private String mzys12;
    @Column(name="MZYS13")
    @JsonProperty("MZYS13")
    private String mzys13;
    @Column(name="MZYS14")
    @JsonProperty("MZYS14")
    private String mzys14;
    @Column(name="MZYS15")
    @JsonProperty("MZYS15")
    private String mzys15;
    @Column(name="MZYS16")
    @JsonProperty("MZYS16")
    private String mzys16;
    @Column(name="MZYS17")
    @JsonProperty("MZYS17")
    private String mzys17;
    @Column(name="MZYS18")
    @JsonProperty("MZYS18")
    private String mzys18;
    @Column(name="MZYS19")
    @JsonProperty("MZYS19")
    private String mzys19;
    @Column(name="MZYS20")
    @JsonProperty("MZYS20")
    private String mzys20;
    @Column(name="MZYS21")
    @JsonProperty("MZYS21")
    private String mzys21;
    @Column(name="MZYS22")
    @JsonProperty("MZYS22")
    private String mzys22;
    @Column(name="MZYS23")
    @JsonProperty("MZYS23")
    private String mzys23;
    @Column(name="MZYS24")
    @JsonProperty("MZYS24")
    private String mzys24;
    @Column(name="MZYS25")
    @JsonProperty("MZYS25")
    private String mzys25;
    @Column(name="MZYS26")
    @JsonProperty("MZYS26")
    private String mzys26;
    @Column(name="MZYS27")
    @JsonProperty("MZYS27")
    private String mzys27;
    @Column(name="MZYS28")
    @JsonProperty("MZYS28")
    private String mzys28;
    @Column(name="MZYS29")
    @JsonProperty("MZYS29")
    private String mzys29;
    @Column(name="MZYS30")
    @JsonProperty("MZYS30")
    private String mzys30;
    @Column(name="MZYS31")
    @JsonProperty("MZYS31")
    private String mzys31;
    @Column(name="MZYS32")
    @JsonProperty("MZYS32")
    private String mzys32;
    @Column(name="MZYS33")
    @JsonProperty("MZYS33")
    private String mzys33;
    @Column(name="MZYS34")
    @JsonProperty("MZYS34")
    private String mzys34;
    @Column(name="MZYS35")
    @JsonProperty("MZYS35")
    private String mzys35;
    @Column(name="MZYS36")
    @JsonProperty("MZYS36")
    private String mzys36;
    @Column(name="MZYS37")
    @JsonProperty("MZYS37")
    private String mzys37;
    @Column(name="MZYS38")
    @JsonProperty("MZYS38")
    private String mzys38;
    @Column(name="MZYS39")
    @JsonProperty("MZYS39")
    private String mzys39;
    @Column(name="MZYS40")
    @JsonProperty("MZYS40")
    private String mzys40;
    @Column(name="MZYS41")
    @JsonProperty("MZYS41")
    private String mzys41;

    @Column(name="MZFJ1")
    @JsonProperty("MZFJ1")
    private String MZFJ1;
    @Column(name="MZFJ2")
    @JsonProperty("MZFJ2")
    private String MZFJ2;
    @Column(name="MZFJ3")
    @JsonProperty("MZFJ3")
    private String MZFJ3;
    @Column(name="MZFJ4")
    @JsonProperty("MZFJ4")
    private String MZFJ4;
    @Column(name="MZFJ5")
    @JsonProperty("MZFJ5")
    private String MZFJ5;
    @Column(name="MZFJ6")
    @JsonProperty("MZFJ6")
    private String MZFJ6;
    @Column(name="MZFJ7")
    @JsonProperty("MZFJ7")
    private String MZFJ7;
    @Column(name="MZFJ8")
    @JsonProperty("MZFJ8")
    private String MZFJ8;
    @Column(name="MZFJ9")
    @JsonProperty("MZFJ9")
    private String MZFJ9;
    @Column(name="MZFJ10")
    @JsonProperty("MZFJ10")
    private String MZFJ10;
    @Column(name="MZFJ11")
    @JsonProperty("MZFJ11")
    private String MZFJ11;
    @Column(name="MZFJ12")
    @JsonProperty("MZFJ12")
    private String MZFJ12;
    @Column(name="MZFJ13")
    @JsonProperty("MZFJ13")
    private String MZFJ13;
    @Column(name="MZFJ14")
    @JsonProperty("MZFJ14")
    private String MZFJ14;
    @Column(name="MZFJ15")
    @JsonProperty("MZFJ15")
    private String MZFJ15;
    @Column(name="MZFJ16")
    @JsonProperty("MZFJ16")
    private String MZFJ16;
    @Column(name="MZFJ17")
    @JsonProperty("MZFJ17")
    private String MZFJ17;
    @Column(name="MZFJ18")
    @JsonProperty("MZFJ18")
    private String MZFJ18;
    @Column(name="MZFJ19")
    @JsonProperty("MZFJ19")
    private String MZFJ19;
    @Column(name="MZFJ20")
    @JsonProperty("MZFJ20")
    private String MZFJ20;
    @Column(name="MZFJ21")
    @JsonProperty("MZFJ21")
    private String MZFJ21;
    @Column(name="MZFJ22")
    @JsonProperty("MZFJ22")
    private String MZFJ22;
    @Column(name="MZFJ23")
    @JsonProperty("MZFJ23")
    private String MZFJ23;
    @Column(name="MZFJ24")
    @JsonProperty("MZFJ24")
    private String MZFJ24;
    @Column(name="MZFJ25")
    @JsonProperty("MZFJ25")
    private String MZFJ25;
    @Column(name="MZFJ26")
    @JsonProperty("MZFJ26")
    private String MZFJ26;
    @Column(name="MZFJ27")
    @JsonProperty("MZFJ27")
    private String MZFJ27;
    @Column(name="MZFJ28")
    @JsonProperty("MZFJ28")
    private String MZFJ28;
    @Column(name="MZFJ29")
    @JsonProperty("MZFJ29")
    private String MZFJ29;
    @Column(name="MZFJ30")
    @JsonProperty("MZFJ30")
    private String MZFJ30;
    @Column(name="MZFJ31")
    @JsonProperty("MZFJ31")
    private String MZFJ31;
    @Column(name="MZFJ32")
    @JsonProperty("MZFJ32")
    private String MZFJ32;
    @Column(name="MZFJ33")
    @JsonProperty("MZFJ33")
    private String MZFJ33;
    @Column(name="MZFJ34")
    @JsonProperty("MZFJ34")
    private String MZFJ34;
    @Column(name="MZFJ35")
    @JsonProperty("MZFJ35")
    private String MZFJ35;
    @Column(name="MZFJ36")
    @JsonProperty("MZFJ36")
    private String MZFJ36;
    @Column(name="MZFJ37")
    @JsonProperty("MZFJ37")
    private String MZFJ37;
    @Column(name="MZFJ38")
    @JsonProperty("MZFJ38")
    private String MZFJ38;
    @Column(name="MZFJ39")
    @JsonProperty("MZFJ39")
    private String MZFJ39;
    @Column(name="MZFJ40")
    @JsonProperty("MZFJ40")
    private String MZFJ40;
    @Column(name="MZFJ41")
    @JsonProperty("MZFJ41")
    private String MZFJ41;

    @Column(name="SSCZBW1")
    @JsonProperty("SSCZBW1")
    private String SSCZBW1;
    @Column(name="SSCZBW2")
    @JsonProperty("SSCZBW2")
    private String SSCZBW2;
    @Column(name="SSCZBW3")
    @JsonProperty("SSCZBW3")
    private String SSCZBW3;
    @Column(name="SSCZBW4")
    @JsonProperty("SSCZBW4")
    private String SSCZBW4;
    @Column(name="SSCZBW5")
    @JsonProperty("SSCZBW5")
    private String SSCZBW5;
    @Column(name="SSCZBW6")
    @JsonProperty("SSCZBW6")
    private String SSCZBW6;
    @Column(name="SSCZBW7")
    @JsonProperty("SSCZBW7")
    private String SSCZBW7;
    @Column(name="SSCZBW8")
    @JsonProperty("SSCZBW8")
    private String SSCZBW8;
    @Column(name="SSCZBW9")
    @JsonProperty("SSCZBW9")
    private String SSCZBW9;
    @Column(name="SSCZBW10")
    @JsonProperty("SSCZBW10")
    private String SSCZBW10;
    @Column(name="SSCZBW11")
    @JsonProperty("SSCZBW11")
    private String SSCZBW11;
    @Column(name="SSCZBW12")
    @JsonProperty("SSCZBW12")
    private String SSCZBW12;
    @Column(name="SSCZBW13")
    @JsonProperty("SSCZBW13")
    private String SSCZBW13;
    @Column(name="SSCZBW14")
    @JsonProperty("SSCZBW14")
    private String SSCZBW14;
    @Column(name="SSCZBW15")
    @JsonProperty("SSCZBW15")
    private String SSCZBW15;
    @Column(name="SSCZBW16")
    @JsonProperty("SSCZBW16")
    private String SSCZBW16;
    @Column(name="SSCZBW17")
    @JsonProperty("SSCZBW17")
    private String SSCZBW17;
    @Column(name="SSCZBW18")
    @JsonProperty("SSCZBW18")
    private String SSCZBW18;
    @Column(name="SSCZBW19")
    @JsonProperty("SSCZBW19")
    private String SSCZBW19;
    @Column(name="SSCZBW20")
    @JsonProperty("SSCZBW20")
    private String SSCZBW20;
    @Column(name="SSCZBW21")
    @JsonProperty("SSCZBW21")
    private String SSCZBW21;
    @Column(name="SSCZBW22")
    @JsonProperty("SSCZBW22")
    private String SSCZBW22;
    @Column(name="SSCZBW23")
    @JsonProperty("SSCZBW23")
    private String SSCZBW23;
    @Column(name="SSCZBW24")
    @JsonProperty("SSCZBW24")
    private String SSCZBW24;
    @Column(name="SSCZBW25")
    @JsonProperty("SSCZBW25")
    private String SSCZBW25;
    @Column(name="SSCZBW26")
    @JsonProperty("SSCZBW26")
    private String SSCZBW26;
    @Column(name="SSCZBW27")
    @JsonProperty("SSCZBW27")
    private String SSCZBW27;
    @Column(name="SSCZBW28")
    @JsonProperty("SSCZBW28")
    private String SSCZBW28;
    @Column(name="SSCZBW29")
    @JsonProperty("SSCZBW29")
    private String SSCZBW29;
    @Column(name="SSCZBW30")
    @JsonProperty("SSCZBW30")
    private String SSCZBW30;
    @Column(name="SSCZBW31")
    @JsonProperty("SSCZBW31")
    private String SSCZBW31;
    @Column(name="SSCZBW32")
    @JsonProperty("SSCZBW32")
    private String SSCZBW32;
    @Column(name="SSCZBW33")
    @JsonProperty("SSCZBW33")
    private String SSCZBW33;
    @Column(name="SSCZBW34")
    @JsonProperty("SSCZBW34")
    private String SSCZBW34;
    @Column(name="SSCZBW35")
    @JsonProperty("SSCZBW35")
    private String SSCZBW35;
    @Column(name="SSCZBW36")
    @JsonProperty("SSCZBW36")
    private String SSCZBW36;
    @Column(name="SSCZBW37")
    @JsonProperty("SSCZBW37")
    private String SSCZBW37;
    @Column(name="SSCZBW38")
    @JsonProperty("SSCZBW38")
    private String SSCZBW38;
    @Column(name="SSCZBW39")
    @JsonProperty("SSCZBW39")
    private String SSCZBW39;
    @Column(name="SSCZBW40")
    @JsonProperty("SSCZBW40")
    private String SSCZBW40;
    @Column(name="SSCZBW41")
    @JsonProperty("SSCZBW41")
    private String SSCZBW41;


    @Column(name="LYFS")
    @JsonProperty("LYFS")
    private String lyfs;
    @Column(name="YZZY_JGMC")
    @JsonProperty("YZZY_JGMC")
    private String yzzy_jgmc;
    @Column(name="WSY_JGMC")
    @JsonProperty("WSY_JGMC")
    private String wsy_jgmc;
    @Column(name="ZZYJH")
    @JsonProperty("ZZYJH")
    private String zzyjh; //private Integer zzyjh;
    @Column(name="MD")
    @JsonProperty("MD")
    private String md;
    @Column(name="RYQ_T")
    @JsonProperty("RYQ_T")
    private Integer ryq_t;
    @Column(name="RYQ_XS")
    @JsonProperty("RYQ_XS")
    private Integer ryq_xs;
    @Column(name="RYQ_FZ")
    @JsonProperty("RYQ_FZ")
    private Integer ryq_fz;
    @Column(name="RYH_T")
    @JsonProperty("RYH_T")
    private Integer ryh_t;
    @Column(name="RYH_XS")
    @JsonProperty("RYH_XS")
    private Integer ryh_xs;
    @Column(name="RYH_FZ")
    @JsonProperty("RYH_FZ")
    private Integer ryh_fz;
    @Column(name="ZFY")
    @JsonProperty("ZFY")
    private Double zfy;
    @Column(name="ZFJE")
    @JsonProperty("ZFJE")
    private Double zfje;
    @Column(name="YLFWF")
    @JsonProperty("YLFWF")
    private Double ylfwf;
    @Column(name="BZLZF")
    @JsonProperty("BZLZF")
    private Double bzlzf;
    @Column(name="ZYBLZHZF")
    @JsonProperty("ZYBLZHZF")
    private Double zyblzhzf;
    @Column(name="ZLCZF")
    @JsonProperty("ZLCZF")
    private Double zlczf;
    @Column(name="HLF")
    @JsonProperty("HLF")
    private Double hlf;
    @Column(name="QTFY")
    @JsonProperty("QTFY")
    private Double qtfy;
    @Column(name="BLZDF")
    @JsonProperty("BLZDF")
    private Double blzdf;
    @Column(name="ZDF")
    @JsonProperty("ZDF")
    private Double zdf;
    @Column(name="YXXZDF")
    @JsonProperty("YXXZDF")
    private Double yxxzdf;
    @Column(name="LCZDXMF")
    @JsonProperty("LCZDXMF")
    private Double lczdxmf;
    @Column(name="FSSZLXMF")
    @JsonProperty("FSSZLXMF")
    private Double fsszlxmf;
    @Column(name="ZLF")
    @JsonProperty("ZLF")
    private Double zlf;
    @Column(name="SSZLF")
    @JsonProperty("SSZLF")
    private Double sszlf;
    @Column(name="MZF")
    @JsonProperty("MZF")
    private Double mzf;
    @Column(name="SSF")
    @JsonProperty("SSF")
    private Double ssf;
    @Column(name="KFF")
    @JsonProperty("KFF")
    private Double kff;
    @Column(name="ZYL_ZYZD")
    @JsonProperty("ZYL_ZYZD")
    private Double zyl_zyzd;
    @Column(name="ZYZL")
    @JsonProperty("ZYZL")
    private Double zyzl;
    @Column(name="ZYWZ")
    @JsonProperty("ZYWZ")
    private Double zywz;
    @Column(name="ZYGS")
    @JsonProperty("ZYGS")
    private Double zygs;
    @Column(name="ZCYJF")
    @JsonProperty("ZCYJF")
    private Double zcyjf;
    @Column(name="ZYTNZL")
    @JsonProperty("ZYTNZL")
    private Double zytnzl;
    @Column(name="ZYGCZL")
    @JsonProperty("ZYGCZL")
    private Double zygczl;
    @Column(name="ZYTSZL")
    @JsonProperty("ZYTSZL")
    private Double zytszl;
    @Column(name="ZYQT")
    @JsonProperty("ZYQT")
    private Double zyqt;
    @Column(name="ZYTSTPJG")
    @JsonProperty("ZYTSTPJG")
    private Double zytstpjg;
    @Column(name="BZSS")
    @JsonProperty("BZSS")
    private Double bzss;
    @Column(name="XYF")
    @JsonProperty("XYF")
    private Double xyf;
    @Column(name="KJYWF")
    @JsonProperty("KJYWF")
    private Double kjywf;
    @Column(name="ZCYF")
    @JsonProperty("ZCYF")
    private Double zcyf;
    @Column(name="ZYZJF")
    @JsonProperty("ZYZJF")
    private Double zyzjf;
    @Column(name="ZCYF1")
    @JsonProperty("ZCYF1")
    private Double zcyf1;
    @Column(name="XF")
    @JsonProperty("XF")
    private Double xf;
    @Column(name="BDBLZPF")
    @JsonProperty("BDBLZPF")
    private Double bdblzpf;
    @Column(name="QDBLZPF")
    @JsonProperty("QDBLZPF")
    private Double qdblzpf;
    @Column(name="NXYZLZPF")
    @JsonProperty("NXYZLZPF")
    private Double nxyzlzpf;
    @Column(name="XBYZLZPF")
    @JsonProperty("XBYZLZPF")
    private Double xbyzlzpf;
    @Column(name="JCYYCLF")
    @JsonProperty("JCYYCLF")
    private Double jcyyclf;
    @Column(name="YYCLF")
    @JsonProperty("YYCLF")
    private Double yyclf;
    @Column(name="SSYCXCLF")
    @JsonProperty("SSYCXCLF")
    private Double ssycxclf;
    @Column(name="QTF")
    @JsonProperty("QTF")
    private Double qtf;

    @Column(name="ZZICULX")
    @JsonProperty("ZZICULX")
    private String ZZICULX;
    @Column(name="ZZICULX2")
    @JsonProperty("ZZICULX2")
    private String ZZICULX2;
    @Column(name="ZZICULX3")
    @JsonProperty("ZZICULX3")
    private String ZZICULX3;
    @Column(name="ZZICULX4")
    @JsonProperty("ZZICULX4")
    private String ZZICULX4;
    @Column(name="ZZICULX5")
    @JsonProperty("ZZICULX5")
    private String ZZICULX5;

    @Column(name="ZZRZSJ")
    @JsonProperty("ZZRZSJ")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZRZSJ;
    @Column(name="ZZRZSJ2")
    @JsonProperty("ZZRZSJ2")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZRZSJ2;
    @Column(name="ZZRZSJ3")
    @JsonProperty("ZZRZSJ3")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZRZSJ3;
    @Column(name="ZZRZSJ4")
    @JsonProperty("ZZRZSJ4")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZRZSJ4;
    @Column(name="ZZRZSJ5")
    @JsonProperty("ZZRZSJ5")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZRZSJ5;

    @Column(name="ZZZCSJ")
    @JsonProperty("ZZZCSJ")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZZCSJ;
    @Column(name="ZZZCSJ2")
    @JsonProperty("ZZZCSJ2")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZZCSJ2;
    @Column(name="ZZZCSJ3")
    @JsonProperty("ZZZCSJ3")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZZCSJ3;
    @Column(name="ZZZCSJ4")
    @JsonProperty("ZZZCSJ4")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZZCSJ4;
    @Column(name="ZZZCSJ5")
    @JsonProperty("ZZZCSJ5")
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date ZZZCSJ5;

    @Column(name="ZZZRICUJH")
    @JsonProperty("ZZZRICUJH")
    private String ZZZRICUJH;// private Integer ZZZRICUJH;
    @Column(name="ZZZRICUJH2")
    @JsonProperty("ZZZRICUJH2")
    private String ZZZRICUJH2;// private Integer ZZZRICUJH2;
    @Column(name="ZZZRICUJH3")
    @JsonProperty("ZZZRICUJH3")
    private String ZZZRICUJH3;//  private Integer ZZZRICUJH3;
    @Column(name="ZZZRICUJH4")
    @JsonProperty("ZZZRICUJH4")
    private String ZZZRICUJH4;// private Integer ZZZRICUJH4;
    @Column(name="ZZZRICUJH5")
    @JsonProperty("ZZZRICUJH5")
    private String ZZZRICUJH5;// private Integer ZZZRICUJH5;

    @Column(name="ZZZRZYY")
    @JsonProperty("ZZZRZYY")
    private String ZZZRZYY;
    @Column(name="ZZZRZYY2")
    @JsonProperty("ZZZRZYY2")
    private String ZZZRZYY2;
    @Column(name="ZZZRZYY3")
    @JsonProperty("ZZZRZYY3")
    private String ZZZRZYY3;
    @Column(name="ZZZRZYY4")
    @JsonProperty("ZZZRZYY4")
    private String ZZZRZYY4;
    @Column(name="ZZZRZYY5")
    @JsonProperty("ZZZRZYY5")
    private String ZZZRZYY5;

    @Column(name="ZZJHSPF")
    @JsonProperty("ZZJHSPF")
    private Integer ZZJHSPF;
    @Column(name="ZZJHSPF2")
    @JsonProperty("ZZJHSPF2")
    private Integer ZZJHSPF2;
    @Column(name="ZZJHSPF3")
    @JsonProperty("ZZJHSPF3")
    private Integer ZZJHSPF3;
    @Column(name="ZZJHSPF4")
    @JsonProperty("ZZJHSPF4")
    private Integer ZZJHSPF4;
    @Column(name="ZZJHSPF5")
    @JsonProperty("ZZJHSPF5")
    private Integer ZZJHSPF5;

    @Column(name="ZXFLAG")
    @JsonProperty("ZXFLAG")
    private String ZXFLAG;
    @Column(name="ZDGS")
    @JsonProperty("ZDGS")
    private Integer ZDGS;
    @Column(name="SSGS")
    @JsonProperty("SSGS")
    private Integer SSGS;
    @Column(name="STATUS")
    @JsonProperty("STATUS")
    private String STATUS;


    @Column(name="GJMC")
    @JsonProperty("GJMC")
    private String GJMC;

    @Column(name="ZYH")
    @JsonProperty("ZYH")
    private String ZYH;

    @Column(name="RYKBMC")
    @JsonProperty("RYKBMC")
    private String RYKBMC;

    @Column(name="CYKBMC")
    @JsonProperty("CYKBMC")
    private String CYKBMC;

    @Column(name="GJPYM")
    @JsonProperty("GJPYM")
    private String GJPYM;

    @Column(name="isManual")
    @JsonProperty("isManual")
    private String isManual;

    @Column(name="InputReason")
    @JsonProperty("InputReason")
    private String InputReason;

    @Column(name="SQZYTS")
    @JsonProperty("SQZYTS")
    private Integer SQZYTS;

    @Column(name="SHZYTS")
    @JsonProperty("SHZYTS")
    private Integer SHZYTS;

    @Column(name="CFTS")
    @JsonProperty("CFTS")
    private Integer CFTS;

    @Column(name="nldw")
    @JsonProperty("nldw")
    private String nldw;

    @Column(name="yyqxdm")
    @JsonProperty("yyqxdm")
    private String yyqxdm;

    @Column(name="yysjdm")
    @JsonProperty("yysjdm")
    private String yysjdm;

    @Column(name="yydsdm")
    @JsonProperty("yydsdm")
    private String yydsdm;

    @Column(name="CH0K16")
    @JsonProperty("CH0K16")
    @ApiModelProperty(value = "中医治法名称1")
    private String CH0K16;

    @Column(name="CH0K16ID")
    @JsonProperty("CH0K16ID")
    @ApiModelProperty(value = "中医治法编码1")
    private String CH0K16ID;

    @Column(name="ZZ_ZFMC2")
    @JsonProperty("ZZ_ZFMC2")
    @ApiModelProperty(value = "中医治法名称2")
    private String ZZ_ZFMC2;



    @Column(name="ZZ_ZFBM2")
    @JsonProperty("ZZ_ZFBM2")
    @ApiModelProperty(value = "中医治法编码2")
    private String ZZ_ZFBM2;

    @Column(name="ZZ_ZFMC3")
    @JsonProperty("ZZ_ZFMC3")
    @ApiModelProperty(value = "中医治法名称3")
    private String ZZ_ZFMC3;

    @Column(name="ZZ_ZFBM3")
    @JsonProperty("ZZ_ZFBM3")
    @ApiModelProperty(value = "中医治法编码3")
    private String ZZ_ZFBM3;

    @Column(name="ZZ_ZFMC4")
    @JsonProperty("ZZ_ZFMC4")
    @ApiModelProperty(value = "中医治法名称4")
    private String ZZ_ZFMC4;

    @Column(name="ZZ_ZFBM4")
    @JsonProperty("ZZ_ZFBM4")
    @ApiModelProperty(value = "中医治法编码4")
    private String ZZ_ZFBM4;


    @Column(name="ZZ_ZFMC5")
    @JsonProperty("ZZ_ZFMC5")
    @ApiModelProperty(value = "中医治法名称5")
    private String ZZ_ZFMC5;

    @Column(name="ZZ_ZFBM5")
    @JsonProperty("ZZ_ZFBM5")
    @ApiModelProperty(value = "中医治法编码5")
    private String ZZ_ZFBM5;


    @Column(name="ZZ_ZFMC6")
    @JsonProperty("ZZ_ZFMC6")
    @ApiModelProperty(value = "中医治法名称6")
    private String ZZ_ZFMC6;

    @Column(name="ZZ_ZFBM6")
    @JsonProperty("ZZ_ZFBM6")
    @ApiModelProperty(value = "中医治法编码6")
    private String ZZ_ZFBM6;


    @Column(name="ZZ_ZFMC7")
    @JsonProperty("ZZ_ZFMC7")
    @ApiModelProperty(value = "中医治法名称7")
    private String ZZ_ZFMC7;

    @Column(name="ZZ_ZFBM7")
    @JsonProperty("ZZ_ZFBM7")
    @ApiModelProperty(value = "中医治法编码7")
    private String ZZ_ZFBM7;

    @Column(name="JBDM_ZZ1")
    @JsonProperty("JBDM_ZZ1")
    @ApiModelProperty(value = " 门(急)诊中医证候诊断编码（中医证候诊断）1")
    private String JBDM_ZZ1;

    @Column(name="JBDM_ZZ2")
    @JsonProperty("JBDM_ZZ2")
    @ApiModelProperty(value = "门(急)诊中医证候诊断编码（中医证候诊断）2")
    private String JBDM_ZZ2;


    @Column(name="MZD_ZZ1")
    @JsonProperty("MZD_ZZ1")
    @ApiModelProperty(value = "门(急)诊中医证候诊断名称（中医证候诊断）1")
    private String MZD_ZZ1;

    @Column(name="MZD_ZZ2")
    @JsonProperty("MZD_ZZ2")
    @ApiModelProperty(value = "门(急)诊中医证候诊断名称（中医证候诊断）2")
    private String MZD_ZZ2;

    @Column(name="ZY_CYQK_ZB")
    @JsonProperty("ZY_CYQK_ZB")
    @ApiModelProperty(value = "中医转归")
    private String ZY_CYQK_ZB;



    @Column(name="CH0AJZLSH")
    @JsonProperty("CH0AJZLSH")
    @ApiModelProperty(value = "就诊流水号", position = 2)
    private String CH0AJZLSH;

    @Column(name="ZZ_CYQK1")
    @JsonProperty("ZZ_CYQK1")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）1")
    private String ZZ_CYQK1;

    @Column(name="ZZ_CYQK2")
    @JsonProperty("ZZ_CYQK2")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）2")
    private String ZZ_CYQK2;


    @Column(name="ZZ_CYQK3")
    @JsonProperty("ZZ_CYQK3")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）3")
    private String ZZ_CYQK3;

    @Column(name="ZZ_CYQK4")
    @JsonProperty("ZZ_CYQK4")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）4")
    private String ZZ_CYQK4;


    @Column(name="ZZ_CYQK5")
    @JsonProperty("ZZ_CYQK5")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）5")
    private String ZZ_CYQK5;


    @Column(name="ZZ_CYQK6")
    @JsonProperty("ZZ_CYQK6")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）6")
    private String ZZ_CYQK6;


    @Column(name="ZZ_CYQK7")
    @JsonProperty("ZZ_CYQK7")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）7")
    private String ZZ_CYQK7;

    @Column(name="sfzjlx")
    @JsonProperty("sfzjlx")
    @ApiModelProperty(value = "身份证件类型", position = 2)
    private String sfzjlx;
    @Column(name="QTYLJGMC")
    @JsonProperty("QTYLJGMC")
    @ApiModelProperty(value = "其他医疗机构转入名称", position = 2)
    private String QTYLJGMC;
}
