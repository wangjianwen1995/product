package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@ApiModel(value = "hm_ryhz", description = "入院患者评估表")
@Entity
@Data
@Table(name="hm_ryhz")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class HmRyhzpgb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @ApiModelProperty(value = "评估时间")
    @Column(name = "pgsj")
    private String pgsj;
    @ApiModelProperty(value = "入院科室名称")
    private String ry_codename;
    @ApiModelProperty(value = "出院科室名称")
    private String cy_codename;
    @ApiModelProperty(value = "患者编号")
    @Column(name = "blh")
    private String blh;
    @ApiModelProperty(value = "床位号")
    @Column(name = "cwh")
    private String cwh;
    @ApiModelProperty(value = "住院次数")
    @Column(name = "zycs")
    private Integer zycs;

    @ApiModelProperty(value = "入院时间")
    @Column(name = "ry_time")
    private String ry_time;


    @ApiModelProperty(value = "出院时间")
    @Column(name = "cy_time")
    private String cy_time;

    @ApiModelProperty(value = "入院科室代码")
    @Column(name = "ry_code")
    private String ry_code;

    @ApiModelProperty(value = "出院科室代码")
    @Column(name = "cy_code")
    private String cy_code;

    @ApiModelProperty(value = "患者姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "患者住院号")
    @Column(name = "zyh")
    private String zyh;

    @ApiModelProperty(value = "患者年龄")
    @Column(name = "age")
    private String age;

    @ApiModelProperty(value = "患者性别")
    @Column(name = "sex")
    private String sex;

    @ApiModelProperty(value = "入院诊断")
    @Column(name = "ryzd")
    private String ryzd;

    @ApiModelProperty(value = "入院诊断:中医")
    @Column(name = "ryzd_zy")
    private String ryzd_zy;

    @ApiModelProperty(value = "职业")
    @Column(name = "zy")
    private String zy;


    @ApiModelProperty(value = "民族")
    @Column(name = "mz")
    private String mz;

    @ApiModelProperty(value = "文化程度")
    @Column(name = "whcd")
    private String whcd;

    @ApiModelProperty(value = "婚姻状况")
    @Column(name = "hyzk")
    private String hyzk;

    @ApiModelProperty(value = "几子")
    @Column(name = "jz")
    private String jz;

    @ApiModelProperty(value = "几女")
    @Column(name = "jn")
    private String jn;

    @ApiModelProperty(value = "宗教信仰")
    @Column(name = "zzxy")
    private String zzxy;

    @ApiModelProperty(value = "宗教信仰:有")
    private String zzxy_y;


    @ApiModelProperty(value = "发病节气")
    @Column(name = "fbjq")
    private String fbjq;


    @ApiModelProperty(value = "既往史（诊断+时间+治愈）")
    @Column(name = "jws")
    private String jws;

    @ApiModelProperty(value = "过敏史")
    @Column(name = "gms")
    private String gms;

    @ApiModelProperty(value = "过敏史药物")
    private String gms_yw;

    @ApiModelProperty(value = "过敏史食物")
    private String gms_sw;

    @ApiModelProperty(value = "过敏史其他")
    private String gms_qt;



    @ApiModelProperty(value = "生命体征T")
    private String smtz_t;
    @ApiModelProperty(value = "生命体征P")
    private String smtz_p;
    @ApiModelProperty(value = "生命体征R")
    private String smtz_r;
    @ApiModelProperty(value = "生命体征BP")
    private String smtz_bp;
    @ApiModelProperty(value = "生命体征kg")
    private String smtz_kg;

    @ApiModelProperty(value = "入院方式")
    private String ryfs;

    @ApiModelProperty(value = "入院方式其它")
    private String ryfs_qt;
    //
    @ApiModelProperty(value = "管路")
    private String gl;

    @ApiModelProperty(value = "管路类型")
    private String gllx;

    @ApiModelProperty(value = "管路置管时间")
    private String glzgsj;


    @ApiModelProperty(value = "神志")
    private String sz;

    @ApiModelProperty(value = "神志其它")
    private String sz_qt;



    @ApiModelProperty(value = "面色")
    private String ms;

    @ApiModelProperty(value = "面色其它")
    private String ms_qt;

    @ApiModelProperty(value = "形态")
    private String xt;
    //
    @ApiModelProperty(value = "形态其它")
    private String xt_qt;

    @ApiModelProperty(value = "皮肤")
    private String pf;

    @ApiModelProperty(value = "皮肤其它")
    private String pf_qt;

    @ApiModelProperty(value = "舌象舌质")
    private String sxsz;

    @ApiModelProperty(value = "舌象舌质其它")
    private String sxsz_qt;

    @ApiModelProperty(value = "舌象舌苔")
    private String sxst;


    @ApiModelProperty(value = "舌象舌苔其它")
    private String sxst_qt;
    @ApiModelProperty(value = "病室")
    private String bingshi;

    @ApiModelProperty(value = "语言")
    private String yy;
    @ApiModelProperty(value = "语言其它")
    private String yy_qt;
    @ApiModelProperty(value = "呼吸")
    private String hx;
    @ApiModelProperty(value = "呼吸其它")
    private String hx_qt;
    @ApiModelProperty(value = "咳嗽")
    private String ks;
    @ApiModelProperty(value = "痰")
    private String tan;
    @ApiModelProperty(value = "有痰")
    private String ytan;
    @ApiModelProperty(value = "色")
    private String se;

    @ApiModelProperty(value = "质")
    private String zhi;
    @ApiModelProperty(value = "有痰其它")
    private String ytan_qt;
    @ApiModelProperty(value = "嗅气味")
    private String xqw;

    @ApiModelProperty(value = "嗅气味有")
    private String yxqw;
    @ApiModelProperty(value = "嗅气味其它")
    private String xqw_qt;


    @ApiModelProperty(value = "进食情况")
    private String jsqk;

    @ApiModelProperty(value = "进食情况置管日期")
    private String jsqkzgrq;

    //
    @ApiModelProperty(value = "口渴")
    private String kk;
    //
    @ApiModelProperty(value = "口渴其它")
    private String kk_qt;


    @ApiModelProperty(value = "听力")
    private String tl;

    @ApiModelProperty(value = "听力其它")
    private String tl_qt;



    @ApiModelProperty(value = "视力")
    private String sl;


    @ApiModelProperty(value = "视力左右")
    private String sl_zy;

    @ApiModelProperty(value = "视力其它")
    private String sl_qt;


    @ApiModelProperty(value = "睡眠")
    private String sm;

    @ApiModelProperty(value = "睡眠辅助用药")
    private String sm_fzyy;

    @ApiModelProperty(value = "睡眠其他")
    private String sm_qt;


    @ApiModelProperty(value = "大便")
    private String db;

    @ApiModelProperty(value = "大便其它")
    private String db_qt;


    @ApiModelProperty(value = "小便")
    private String xb;

    @ApiModelProperty(value = "小便置管日期")
    private String xb_zgrq;


    @ApiModelProperty(value = "嗜好")
    private String sh;

    @ApiModelProperty(value = "嗜好其它")
    private String sh_qt;


    @ApiModelProperty(value = "脉象")
    private String mx;

    @ApiModelProperty(value = "脉象其它")
    private String mx_qt;


    @ApiModelProperty(value = "脘腹")
    private String wf;

    @ApiModelProperty(value = "脘腹其它")
    private String wf_qt;


    @ApiModelProperty(value = "情志")
    private String qz;

    @ApiModelProperty(value = "情志其它")
    private String qz_qt;


    @ApiModelProperty(value = "对疾病")
    private String djb;


    @ApiModelProperty(value = "家庭关系")
    private String jtgx;

    @ApiModelProperty(value = "家庭关系其它")
    private String jtgx_qt;


    @ApiModelProperty(value = "自理能力")
    private String zlnl;

    @ApiModelProperty(value = "证型")
    private String zx;

    @ApiModelProperty(value = "一般护理")
    private String ybhl;

    @ApiModelProperty(value = "情志护理")
    private String qzhl;

    @ApiModelProperty(value = "饮食护理")
    private String yshl;

    @ApiModelProperty(value = "给药护理")
    private String gyhl;

    @ApiModelProperty(value = "临证施护")
    private String lzsh;

    @ApiModelProperty(value = "责任护士")
    private String zrhs;

    @ApiModelProperty(value = "责任护士:中文")
    private String zrhs_zh;

    @ApiModelProperty(value = "家属签字")
    private String jsqz;



}
