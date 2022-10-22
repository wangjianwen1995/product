package com.sxdl.hr.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hr.entity.TgrXytxEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shqrpknife
 * @create 2022-09-02-17:37
 */
public interface HrTgrXytxDao extends BaseUUIDDao<TgrXytxEntity> {
    @Select("update tgr_xytx set isconfirm='${status}' where gid = '${gid}'")
    void updateStatus(String status,String gid);

    @Select("exec xytx_dataimport '${dcgid}', '${strkslist}', '${dcsj}','${name}'")
    void addHh(String dcgid,String strkslist,String dcsj,String name);

    @Delete("delete from tgr_xytx where dcgid = '${dcgid}'")
    void delHh(String dcgid);

    @Delete("delete tgr_xytx  where gid = '${gid}'")
    void delByGid(String gid);

    @Select("${sql}")
    List<TgrXytxEntity> getallxytx(String sql);


    @Select("SELECT   [gid] ,dcgid, [zyh],hzxm, hzxb,CAST(hznl AS VARCHAR(10)) hznl,ryzd, nldw,kssj,dcrq,cjrq,dcrmc,\n" +
            "                (CASE\n" +
            "                    WHEN [IsConfirm] = '0' THEN  CONVERT(VarChar(15),'【已编辑】')\n" +
            "                    WHEN [IsConfirm] = '1' THEN  CONVERT(VarChar(15),'【已审核】')\n" +
            "                    WHEN [IsConfirm] = '9' THEN  CONVERT(VarChar(15),'【未编辑】')\n" +
            "                    ELSE CONVERT(NVarChar(5),'')\n" +
            "                 END) AS [isconfirm]\n" +
            "            FROM [DBO].[tgr_xytx] \n" +
            "            WHERE  ((CONVERT(NVarChar(MAX),[DcGID])) = '${dcgid}')  AND (([zyh] LIKE '%${zyh}%') OR ([hzxm] LIKE '%${zyh}%'))  \n" +
            "            AND [IsConfirm] LIKE (CASE '${status}' WHEN  '未编辑' THEN '%9%' WHEN '已编辑' THEN '%0%' WHEN '已审核' THEN '%1%' ELSE '%%' END)\n" +
            "             ORDER BY [zyh]")
    List<TgrXytxEntity> findBySerch(String dcgid, String zyh, String status);

    @Select("select * from  tgr_xytx  where dcgid='${dcgid}' and zyh='${zyh}'")
    List<TgrXytxEntity> findByzyh(String dcgid, String zyh);

    @Select("select * from  tgr_xytx  where dcgid='${dcgid}' and gid='${gid}'")
    TgrXytxEntity findByGid(String dcgid, String gid);

    @Select("select * from  tgr_xytx  where dcgid='${dcgid}'")
    List<TgrXytxEntity> findByDcGid(String dcgid);

}
