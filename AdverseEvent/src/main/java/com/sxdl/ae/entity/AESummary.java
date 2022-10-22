package com.sxdl.ae.entity;

import com.sxdl.ae.config.AESummaryChildHandler;
import com.sxdl.ae.util.GUID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "ae_summary", description = "不良事件总表")
@Entity
@Data
@Table(name="ae_summary")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class AESummary implements Serializable {


    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;

    @ApiModelProperty(value = "报告日期")
    private String bgrq;

    @ApiModelProperty(value = "就诊日期")
    @Column(name = "hz_jzrq")
    private String hz_jzrq;

    @ApiModelProperty(value = "是否匿名提交")
    private String sfnmtj;

 //    A   患者信息 模块

    @ApiModelProperty(value = "患者:姓名")
    private String hz_xm;

    @ApiModelProperty(value = "患者:病案号")
    private String hz_bah;

    @ApiModelProperty(value = "患者:住院号")
    private String hz_zyh;

    @ApiModelProperty(value = "患者:年龄")
    private String hz_nl;

    @ApiModelProperty(value = "患者:性别")
    private String hz_xb;

    @ApiModelProperty(value = "患者:病区")
    private String hz_bq;

    @ApiModelProperty(value = "患者:床号")
    private String hz_ch;

    @ApiModelProperty(value = "患者:职业")
    private String hz_zy;

    @ApiModelProperty(value = "患者:诊疗类型")
    private String hz_zdlx;

    @ApiModelProperty(value = "患者:医疗付费类别")
    private String hz_fflb;

    @ApiModelProperty(value = "患者:临床主要诊断")
    private String hz_lczyzd;

    @ApiModelProperty(value = "患者:主要诊断ICD-10编码")
    private String hz_zyzdicdbm;

    @ApiModelProperty(value = "患者:发生时间")
    private String hz_fssj;

    //key json
    @ApiModelProperty(value = "患者:日期类型")
    private String hz_rqlx;

    @ApiModelProperty(value = "患者:工作日")
    private String hz_gzr;

    @ApiModelProperty(value = "患者:节假日")
    private String hz_jjr;

    @ApiModelProperty(value = "患者:周末")
    private String hz_zm;

    @ApiModelProperty(value = "患者:发生时段")
    private String hz_fssd;

    @ApiModelProperty(value = "患者:同时发生其他类事件")
    private String hz_tsfsqtlsj;

    ///   B.医疗安全不良事件发生相关情况  fsxgqk_

    //key json 数据直接处理
    @ApiModelProperty(value = "发生相关情况:医疗安全不良事件或错误名称")
    private String fsxgqk_cwmc;

    @ApiModelProperty(value = "发生相关情况:药品使用与管理错误")
    private String fsxgqk_ypsyyglcw;

    @ApiModelProperty(value = "发生相关情况:诊疗应用与管理错误 ")
    private String fsxgqk_zlyyyglcw;

    @ApiModelProperty(value = "发生相关情况:诊疗处置使用与管理错误")
    private String fsxgqk_zlclsyyglcw;

    @ApiModelProperty(value = "发生相关情况:体格检查应用与管理错误")
    private String fsxgqk_tgjcyyyglcw;

    @ApiModelProperty(value = "发生相关情况:医技检查使用与管理错误")
    private String fsxgqk_yjjcsyyglcw;

    @ApiModelProperty(value = "发生相关情况:手术操作与管理错误")
    private String fsxgqk_ssczyglcw;

    @ApiModelProperty(value = "发生相关情况:麻醉应用与管理错误")
    private String fsxgqk_mzyyyglcw;

    @ApiModelProperty(value = "发生相关情况:导管介入诊疗操作与管理错误")
    private String fsxgqk_dgjrzlczyglcw;

    @ApiModelProperty(value = "发生相关情况:导管插入输注与管理错误")
    private String fsxgqk_dgcrszyglcw;

    @ApiModelProperty(value = "发生相关情况:基础护理操作与管理错误")
    private String fsxgqk_jchlczyglcw;

    @ApiModelProperty(value = "发生相关情况:输血应用与管理错误")
    private String fsxgqk_sxyyyglcw;

    @ApiModelProperty(value = "发生相关情况:医疗设施设备使用与管理错误")
    private String fsxgqk_ylsssbsyyylcw;

    @ApiModelProperty(value = "发生相关情况:功能检查应用与管理错误")
    private String fsxgqk_gnjcyyyglcw;

    @ApiModelProperty(value = "发生相关情况:口腔修复操作与管理错误")
    private String fsxgqk_kqxfczyglcw;

    @ApiModelProperty(value = "发生相关情况:急救处置与管理错误")
    private String fsxgqk_jjclyglcw;

    @ApiModelProperty(value = "发生相关情况:内镜应用与管理错误")
    private String fsxgqk_njyyyglcw;

    @ApiModelProperty(value = "发生相关情况:产科分娩操作与管理错误")
    private String fsxgqk_ckfmczyglcw;

    @ApiModelProperty(value = "发生相关情况:医学影像应用与管理错误")
    private String fsxgqk_yxyxyyyglcw;

    @ApiModelProperty(value = "发生相关情况:诊疗常规指南操作规程应用与管理错误")
    private String fsxgqk_zlcgznczgcyyyglcw;

    @ApiModelProperty(value = "发生相关情况:医院管理其他错误")
    private String fsxgqk_yyglqtcw;

    @ApiModelProperty(value = "发生相关情况:病历与其他诊疗记录文件书写与使用错误")
    private String fsxgqk_blyqtzljlwjsxysycw;

    @ApiModelProperty(value = "发生相关情况:信息传递应用与管理错误")
    private String fsxgqk_xxcdyyyglcw;

    @ApiModelProperty(value = "发生相关情况:医疗安全不良事件发生现场的诊疗科室名称")
    private String fsxgqk_zlksmc;

    @ApiModelProperty(value = "发生相关情况:在场相关人员")
    private String fsxgqk_zcxgry;

    @ApiModelProperty(value = "发生相关情况:医疗安全不良事件发生场所")
    private String fsxgqk_fscs;

    @ApiModelProperty(value = "发生相关情况:医疗安全不良事件发生就诊环节")
    private String fsxgqk_jzhj;

    @ApiModelProperty(value = "发生相关情况:医疗安全不良事件发生服务环节")
    private String fsxgqk_fwhj;

    //  C.医疗安全不良事件发生的患者情况 fshzqk_

    @ApiModelProperty(value = "发生患者情况:事件发生前患者状态")
    private String fshzqk_sjfsqhzqk;

    @ApiModelProperty(value = "发生患者情况:事件发生后患者状态")
    private String fshzqk_sjfshhzqk;

    @ApiModelProperty(value = "发生患者情况:事件给患者造成损害的轻重程度")
    private String fshzqk_sjghzzcshdqzcd;

    // D.医疗安全（不良）事件分类   sjfl_
    @ApiModelProperty(value = "事件分类:按医疗风险发生前预防与否分类")
    private String sjfl_aylfxfsqyfyffl;

    @ApiModelProperty(value = "事件分类:按医疗风险影响损害群体分类")
    private String sjfl_aylfxyxshqtfl;

    @ApiModelProperty(value = "事件分类:按医疗缺陷分类")
    private String sjfl_aylqxfl;

    //key json 保存
    @ApiModelProperty(value = "事件分类:管理类别")
    private String sjfl_gllb;

     @ApiModelProperty(value = "事件分类:医疗管理类")
    private String sjfl_ylgll;

    @ApiModelProperty(value = "事件分类:护理管理类")
    private String sjfl_hlgll;

    @ApiModelProperty(value = "事件分类:药品管理类")
    private String sjfl_ypgll;

    @ApiModelProperty(value = "事件分类:医技管理类")
    private String sjfl_yjgll;

    @ApiModelProperty(value = "事件分类:输血管理类")
    private String sjfl_sxgll;

    @ApiModelProperty(value = "事件分类:器械管理类")
    private String sjfl_qxgll;

    @ApiModelProperty(value = "事件分类:院内感染管理类")
    private String sjfl_yngrgll;

    @ApiModelProperty(value = "事件分类:职业防护管理类")
    private String sjfl_zyfhgll;

    @ApiModelProperty(value = "事件分类:信息管理类")
    private String sjfl_xxgll;

    @ApiModelProperty(value = "事件分类:后勤管理类")
    private String sjfl_hqgll;

    @ApiModelProperty(value = "事件分类:治安管理类")
    private String sjfl_zagll;

    @ApiModelProperty(value = "事件分类:事件类别")
    private String sjfl_sjlb;


    // F.医疗安全（不良）事件发生后及时处理与分析情况 jsclhfxqk_

    //key 前端处理json数据直接保存到里面 {1:"wangxx,xxx" , 2: "李lll"}
    @ApiModelProperty(value = "及时处理与分析情况:立即通知人员类别及姓名(医生 护士...)")
    private String jsclhfxqk_lb;

   @ApiModelProperty(value = "及时处理与分析情况:医生")
    private String jsclhfxqk_ys;



    @ApiModelProperty(value = "及时处理与分析情况:护士")
    private String jsclhfxqk_hs;

    @ApiModelProperty(value = "及时处理与分析情况:技师")
    private String jsclhfxqk_js;

    @ApiModelProperty(value = "及时处理与分析情况:药师")
    private String jsclhfxqk_yaosho;

    @ApiModelProperty(value = "及时处理与分析情况:行政后勤")
    private String jsclhfxqk_xzhq;

    @ApiModelProperty(value = "及时处理与分析情况:院级领导")
    private String jsclhfxqk_yjld;

    @ApiModelProperty(value = "及时处理与分析情况:家属或其他")
    private String jsclhfxqk_hshqt;

    //key json 保存
    @ApiModelProperty(value = "及时处理与分析情况:可能原因分析与相关因素(人为因素.设备仪器因素...)")
    private String jsclhfxqk_knyyfxyxgys;


    @ApiModelProperty(value = "及时处理与分析情况:人为因素")
    private String jsclhfxqk_ryys;

    @ApiModelProperty(value = "及时处理与分析情况:设备仪器因素")
    private String jsclhfxqk_sbyqys;

    @ApiModelProperty(value = "及时处理与分析情况:耗材药品因素")
    private String jsclhfxqk_hcypys;

    @ApiModelProperty(value = "及时处理与分析情况:制度职责因素")
    private String jsclhfxqk_zdzzys;

    @ApiModelProperty(value = "及时处理与分析情况:业务流程因素")
    private String jsclhfxqk_ywlcys;

    @ApiModelProperty(value = "及时处理与分析情况:环境因素")
    private String jsclhfxqk_hjys;

    @ApiModelProperty(value = "及时处理与分析情况:公共设施")
    private String jsclhfxqk_ggss;


    @ApiModelProperty(value = "及时处理与分析情况:立即采取的措施")
    private String jsclhfxqk_ljcqdcs;

    @ApiModelProperty(value = "及时处理与分析情况:事件处理情况及结果")
    private String jsclhfxqk_sjclqkjjg;


    // G.事件报告人信息  sjbgrxx_

    @ApiModelProperty(value = "事件报告人信息:报告人")
    private String sjbgrxx_bgr;

    @ApiModelProperty(value = "事件报告人信息:职称")
    private String sjbgrxx_zc;

    @ApiModelProperty(value = "事件报告人信息:报告人签名")
    private String sjbgrxx_bgrqm;

    @ApiModelProperty(value = "事件报告人信息:报告科室")
    private String sjbgrxx_bgks;

    @ApiModelProperty(value = "事件报告人信息:联系电话")
    private String sjbgrxx_lxdh;

    @ApiModelProperty(value = "事件报告人信息:科室负责人提出改进意见与措施")
    private String sjbgrxx_ksfzrtcgjyjycs;

    @ApiModelProperty(value = "事件报告人信息:科室负责人审核签字")
    private String sjbgrxx_ksfzrshqz;

    @ApiModelProperty(value = "事件报告人信息:审核日期")
    private String sjbgrxx_shrq;



    // H.不良事件处理结果评价（主管部门填写） cljgpj_
    @ApiModelProperty(value = "处理结果评价:事件处理结果")
    private String cljgpj_sjcljg;

    @ApiModelProperty(value = "处理结果评价:引起纠纷类别")
    private String cljgpj_yqjflb;

    @ApiModelProperty(value = "处理结果评价:鉴定级别")
    private String cljgpj_jdjb;

    @ApiModelProperty(value = "处理结果评价:一级医疗损害")
    private String cljgpj_yjylsh;

    @ApiModelProperty(value = "处理结果评价:二级医疗损害")
    private String cljgpj_ejylsh;

    @ApiModelProperty(value = "处理结果评价:三级医疗损害")
    private String cljgpj_sjylsh;



    @ApiModelProperty(value = "处理结果评价:医院责任")
    private String cljgpj_yyzr;

    @ApiModelProperty(value = "处理结果评价:成处理时间")
    private String cljgpj_cclsj;

    @ApiModelProperty(value = "处理结果评价:对责任人的处理")
    private String cljgpj_dzrrdcl;

    @ApiModelProperty(value = "处理结果评价:对责任人的处理其他")
    private String cljgpj_dzrrdcl_qt;

    @ApiModelProperty(value = "处理结果评价:主管部门意见及持续改进措施陈述")
    private String cljgpj_zgbmyjjcxgjcscs;


    @ApiModelProperty(value = "处理结果评价:主管部门审核人签名")
    private String cljgpj_zgbmshrqm;

    @ApiModelProperty(value = "处理结果评价:审核日期")
    private String cljgpj_shrq;


    @ApiModelProperty(value = "子表")
    @Transient
    //@ColumnType(typeHandler = AESummaryChildHandler.class)
    private List<AESummaryChild> child;

 /*
    @ApiModelProperty(value = "???")
    private String ???;

    @ApiModelProperty(value = "???")
    private String ???;
*/




}
