package com.sxdl.hr.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hr.entity.TgrBlmEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author shqrpknife
 * @create 2022-08-09-10:34
 */
public interface HrTgrBlmDao extends BaseUUIDDao<TgrBlmEntity> {
    @Select("update tgr_blm set isconfirm='${status}' where gid = '${gid}'")
    void updateStatus(String status,String gid);

    @Delete("delete tgr_blm  where gid = '${gid}'")
    void delByGid(String gid);

    @Select("SELECT [t0].[GID] AS [gid], [t0].[blh], [t0].[BLM02], [t0].[BLM04], [t0].[BLM05], [t0].[BLM06], [t0].[BLM07],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[BLM08] = '1' THEN '是'\n" +
            "        ELSE '否'\n" +
            "     END) AS [BLM08], [t3].[ssmc] AS [BLM09],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[isshfy] = '1' THEN '是'\n" +
            "        ELSE '否'\n" +
            "     END) AS [isshfy],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[BLM10] = '1' THEN '是'\n" +
            "        ELSE '否'\n" +
            "     END) AS [BLM10],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[BLM11] = '1' THEN '是'\n" +
            "        ELSE '否'\n" +
            "     END) AS [BLM11],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[BLM36] = '1' THEN '是'\n" +
            "        ELSE '否'\n" +
            "     END) AS [BLM36],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[BLM37] = '0' THEN CONVERT(NVarChar(5),'治疗')\n" +
            "        WHEN [t0].[BLM37] = '1' THEN CONVERT(NVarChar(5),'预防')\n" +
            "        WHEN [t0].[BLM37] = '2' THEN  CONVERT(VarChar(20),'治疗+预防')\n" +
            "        ELSE CONVERT(NVarChar(5),'')\n" +
            "     END) AS [BLM37],\n" +
            "   [BLM38],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[BLM39] = '1' THEN '是'\n" +
            "        ELSE '否'\n" +
            "     END) AS [BLM39], [t0].[BLM40], [t0].[DcGID], [t0].[DcSj],  [t0].[zyh], [t0].[zycs],\n" +
            "     [t2].[zdmc] AS [zd], [t1]. [KsName], [t1].[KsCode], [t0].[TbSj], [t0].[IsConfirm],\n" +
            "     [t0].[lsh],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[isSqGr] = 1 THEN '是'\n" +
            "        ELSE '否'\n" +
            "     END) AS [isSqGr],\n" +
            "    (CASE\n" +
            "        WHEN [t0].[IsConfirm] = '0' THEN  CONVERT(VarChar(15),'【已编辑】')\n" +
            "        WHEN [t0].[IsConfirm] = '1' THEN  CONVERT(VarChar(15),'【已审核】')\n" +
            "        WHEN [t0].[IsConfirm] = '9' THEN  CONVERT(VarChar(15),'【未编辑】')\n" +
            "        ELSE CONVERT(NVarChar(5),'')\n" +
            "     END) AS [isconfirm], t0.rysj ,t4.username zgys\n" +
            "FROM [DBO].[TGR_BLM] AS [t0]\n" +
            "LEFT OUTER JOIN [DBO].[TUseKs] AS [t1] ON [t0].[KsCode] = [t1].[KsCode]\n" +
            "LEFT OUTER JOIN [DBO].[txhl_bzzd] AS [t2] ON ([t0].[zd] = [t2].[zddm])\n" +
            "LEFT OUTER JOIN [DBO].[txhl_ssqk] AS [t3] ON ([t0].[BLM09] = [t3].[ssdm])\n" +
            " LEFT OUTER JOIN [DBO].[TUserInfo] AS [t4] ON ([t0].[zgys] = [t4].[loginname])\n" +
            "WHERE ((CONVERT(NVarChar(MAX),[t0].[DcGID])) = '${dcgid}')  AND (([t0].[zyh] LIKE '%${zyh}%') OR ([t0].[BLM04] LIKE '%${zyh}%')) AND t1.KsName  LIKE '%${ksname}%'  AND [t0].[IsConfirm] LIKE '%${status}%'  and ([t0].[KsCode] in (select kscode from TDoctor_ks\n" +
            "   Where Userid='${code}'))\n" +
            " ORDER BY [t0].[lsh]")
    List<TgrBlmEntity> findBySerch(String dcgid, String zyh, String ksname, String status, String code);

    @Select("select * from  tgr_blm  where dcgid='${dcgid}' and zyh='${zyh}'")
    List<TgrBlmEntity> findByzyh(String dcgid,String zyh);

    @Select("select * from  tgr_blm  where dcgid='${dcgid}' and gid='${gid}'")
    TgrBlmEntity findByGid(String dcgid,String gid);

    @Select("exec XHLSB '${kssj}','${jssj}'")
    void xhlSh(String kssj,String jssj);

    @Select("select COUNT(*) from  TGR_BLM a inner join [txhl_bzzd] b  on a.zd=b.zddm\n" +
            "    inner join TUseKs t on a.KsCode=t.KsCode inner join Dzks d on d.yyksname=t.KsName\n" +
            "    where IsConfirm ='1'   AND DcSj between  '${kssj}' and  '${jssj}'")
    int getCount(String kssj,String jssj);

    @Select("select COUNT(*) from  TGR_BLM a inner join [txhl_bzzd] b  on a.zd=b.zddm\n" +
            "    inner join sys_ks t on a.KsCode=t.code inner join Dzks d on d.yyksname=t.name\n" +
            "    where IsConfirm ='1'   AND DcSj between  '${kssj}' and  '${jssj}'")
    int getCount1(String kssj, String jssj);

    @Select("select a.GID as gid, a.zyh as zyh,blh as  blh, t.Ksname as Ksname,d.dzid as Kscode,\n" +
            "                    case when  ISNULL(Blm02,'')='' then t.Ksname else Blm02 end as Blm02,\n" +
            "                    a.zycs as zycs,a.zgys AS zgys,\n" +
            "                    ISNULL(Blm08,0) as Blm08,\n" +
            "                    ISNULL(Blm05,0) as Blm05,\n" +
            "                    ISNULL(Blm04,'') as Blm04,\n" +
            "                    ISNULL(Blm38,0) as Blm38,\n" +
            "                    a.Spysjwkjywsyq,\n" +
            "                    a.Blm37,\n" +
            "                    ISNULL(Blm09,'') as  Blm09,\n" +
            "                    ISNULL(Blm10,0) as Blm10,\n" +
            "                    ISNULL(a.Issqgr,0) as Issqgr,\n" +
            "                    ISNULL(a.isywgr,0) as isywgr,\n" +
            "                    a.Blm39,\n" +
            "                    ISNULL(Blm11,0) as Blm11,\n" +
            "                    ISNULL(Blm06,0) as Blm06,\n" +
            "                    Isconfirm as Isconfirm,\n" +
            "                    b.zdmc as zd,\n" +
            "                    ISNULL(Isshfy,0)  as Isshfy,\n" +
            "                    convert(varchar(19),Dcsj,120)Dcsj,\n" +
            "                    ISNULL(Blm36,0) as Blm36,\n" +
            "                    ISNULL(Blm40,'') as Blm40,\n" +
            "                     convert(varchar(19),Tbsj,120)Tbsj,\n" +
            "                    convert(varchar(19),rysj,120)rysj,\n" +
            "                    convert(varchar(19),ISNULL(scyygrrq,''),120) scyygrrq,\n" +
            "                    a.bbglrs,a.bbksrs,a.bbmzrs,a.bbjycs\n" +
            "                    from TGR_BLM a \n" +
            "                    INNER join dbo.txhl_bzzd b  on a.zd=b.zddm\n" +
            "                    inner join TUseKs t on a.KsCode=t.KsCode \n" +
            "                    INNER join Dzks d on d.yyksname=t.KsName\n" +
            "                    where IsConfirm ='1'   AND DcSj between  '${kssj}' and  '${jssj}'")
    List<TgrBlmEntity> getAllTgrblm(String kssj,String jssj);
    @Select("select a.GID as gid, a.zyh as zyh,blh as  blh, t.name as Ksname,d.dzid as Kscode,\n" +
            "                    case when  ISNULL(Blm02,'')='' then t.name else Blm02 end as Blm02,\n" +
            "                    a.zycs as zycs,a.zgys AS zgys,\n" +
            "                    ISNULL(Blm08,0) as Blm08,\n" +
            "                    ISNULL(Blm05,0) as Blm05,\n" +
            "                    ISNULL(Blm04,'') as Blm04,\n" +
            "                    ISNULL(Blm38,0) as Blm38,\n" +
            "                    a.Spysjwkjywsyq,\n" +
            "                    a.Blm37,\n" +
            "                    ISNULL(Blm09,'') as  Blm09,\n" +
            "                    ISNULL(Blm10,0) as Blm10,\n" +
            "                    ISNULL(a.Issqgr,0) as Issqgr,\n" +
            "                    ISNULL(a.isywgr,0) as isywgr,\n" +
            "                    a.Blm39,\n" +
            "                    ISNULL(Blm11,0) as Blm11,\n" +
            "                    ISNULL(Blm06,0) as Blm06,\n" +
            "                    Isconfirm as Isconfirm,\n" +
            "                    b.zdmc as zd,\n" +
            "                    ISNULL(Isshfy,0)  as Isshfy,\n" +
            "                    convert(varchar(19),Dcsj,120)Dcsj,\n" +
            "                    ISNULL(Blm36,0) as Blm36,\n" +
            "                    ISNULL(Blm40,'') as Blm40,\n" +
            "                     convert(varchar(19),Tbsj,120)Tbsj,\n" +
            "                    convert(varchar(19),rysj,120)rysj,\n" +
            "                    convert(varchar(19),ISNULL(scyygrrq,''),120) scyygrrq,\n" +
            "                    a.bbglrs,a.bbksrs,a.bbmzrs,a.bbjycs\n" +
            "                    from TGR_BLM a \n" +
            "                    INNER join dbo.txhl_bzzd b  on a.zd=b.zddm\n" +
            "                    inner join sys_ks t on a.KsCode=t.Code \n" +
            "                    INNER join Dzks d on d.yyksname=t.Name\n" +
            "                    where IsConfirm ='1'   AND DcSj between  '${kssj}' and  '${endsj}'")
    List<TgrBlmEntity> getAllTgrblm1(String kssj, String endsj);

    @Select("exec Xhl_DataImport  '${dcgid}', '${strkslist}', '${dcsj}','','${name}'")
    void addPR(String dcgid, String strkslist, String dcsj,  String name);

    @Delete("delete from tgr_blm where dcgid = '${dcgid}'")
    int delPR(String dcgid);

    Integer update(T obj);

    @Select("select * from tgr_blm where gid= '${gid}'")
    TgrBlmEntity checkInfo(String gid);

    @Select("select * from tgr_blm where dcgid= '${dcgid}'")
    List<TgrBlmEntity> findByDcgid(String dcgid);

    @Select(value="SELECT [t0].[GID] AS [gid], [t0].[blh], [t0].[BLM02], [t0].[BLM04], [t0].[BLM05], [t0].[BLM06], [t0].[BLM07],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[BLM08] = '1' THEN '是'\n" +
            "                    ELSE '否'\n" +
            "                 END) AS [BLM08], [t3].[ssmc] AS [BLM09],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[isshfy] = '1' THEN '是'\n" +
            "                    ELSE '否'\n" +
            "                 END) AS [isshfy],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[BLM10] = '1' THEN '是'\n" +
            "                    ELSE '否'\n" +
            "                 END) AS [BLM10],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[BLM11] = '1' THEN '是'\n" +
            "                    ELSE '否'\n" +
            "                 END) AS [BLM11],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[BLM36] = '1' THEN '是'\n" +
            "                    ELSE '否'\n" +
            "                 END) AS [BLM36],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[BLM37] = '0' THEN CONVERT(NVarChar(5),'治疗')\n" +
            "                    WHEN [t0].[BLM37] = '1' THEN CONVERT(NVarChar(5),'预防')\n" +
            "                    WHEN [t0].[BLM37] = '2' THEN  CONVERT(VarChar(20),'治疗+预防')\n" +
            "                    ELSE CONVERT(NVarChar(5),'')\n" +
            "                 END) AS [BLM37],\n" +
            "               [BLM38],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[BLM39] = '1' THEN '是'\n" +
            "                    ELSE '否'\n" +
            "                 END) AS [BLM39], [t0].[BLM40], [t0].[DcGID], [t0].[DcSj],  [t0].[zyh], [t0].[zycs],\n" +
            "                 [t2].[zdmc] AS [zd], [t1]. [name] [KsName], [t1].[code] [KsCode], [t0].[TbSj], [t0].[IsConfirm],\n" +
            "                 [t0].[lsh],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[isSqGr] = 1 THEN '是'\n" +
            "                    ELSE '否'\n" +
            "                 END) AS [isSqGr],\n" +
            "                (CASE\n" +
            "                    WHEN [t0].[IsConfirm] = '0' THEN  CONVERT(VarChar(15),'【已编辑】')\n" +
            "                    WHEN [t0].[IsConfirm] = '1' THEN  CONVERT(VarChar(15),'【已审核】')\n" +
            "                    WHEN [t0].[IsConfirm] = '9' THEN  CONVERT(VarChar(15),'【未编辑】')\n" +
            "                    ELSE CONVERT(NVarChar(5),'')\n" +
            "                 END) AS [isconfirm] , t0.rysj,t4.name zgys\n" +
            "            FROM [DBO].[TGR_BLM] AS [t0]\n" +
            "            LEFT OUTER JOIN [DBO].[Sys_KS] AS [t1] ON [t0].[kscode] = [t1].[code]\n" +
            "            LEFT OUTER JOIN [DBO].[txhl_bzzd] AS [t2] ON ([t0].[zd] = [t2].[zddm])\n" +
            "            LEFT OUTER JOIN [DBO].[txhl_ssqk] AS [t3] ON ([t0].[BLM09] = [t3].[ssdm])\n" +
            "            LEFT OUTER JOIN [DBO].[sys_staff] AS [t4] ON ([t0].[zgys] = [t4].[code])\n" +
            "             WHERE ((CONVERT(NVarChar(MAX),[t0].[dcgid])) = '${dcgid}') AND (([t0].[zyh] LIKE '%${zyh}%') OR ([t0].[blm04] LIKE '%${zyh}%')) AND t1.name  LIKE '%${ksname}%' AND [t0].[isconfirm] like '%${status}%' and ([t0].[kscode] in (Select c.code from sys_user_ks a\n" +
            "                          inner join Sys_Staff b on a.userid=b.id\n" +
            "                          inner join Sys_KS c on a.ksid=c.id\n" +
            "                          Where b.code='${code}')) ORDER BY [t0].[lsh]\n" +
            "            \n ")
    List<TgrBlmEntity> findBySerch1(String dcgid, String zyh, String ksname, String status, String code);



}
