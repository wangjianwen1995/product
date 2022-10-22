package com.sxdl.hp.service;

import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.hp.dao.dao1.HpBzdmkDao;
import com.sxdl.hp.dao.dao1.HpICCMGxbDao;
import com.sxdl.hp.entity.HpICCMGxb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpICCMGxbService extends BaseServiceImpl<HpICCMGxb> {
    public static final String LineBreak = "\r\n";
    @Autowired
    public SysDictValDao sysDictValDao;
    @Autowired
    HpICCMGxbDao hpICCMGxbDao;
    @Autowired
    HpBzdmkDao hpBzdmkDao;

    public static HpICCMGxb getVersion(String leftVersion, String rightVersion)  {
        Map<Integer, List<SysDictVal>> baMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        List<SysDictVal> sysDictVals = baMap.get(89);
        HpICCMGxb hpICCMGxb = new HpICCMGxb();
        sysDictVals.forEach(e -> {
            if (leftVersion.equals(e.getVal())) {
                String left_dm = e.getRemark() + "dm";
                String left_mc = e.getRemark() + "mc";
                hpICCMGxb.setLeft_bm(left_dm);
                hpICCMGxb.setLeft_mc(left_mc);
            }
            if (rightVersion.equals(e.getVal())) {
                String right_dm = e.getRemark() + "dm";
                String right_mc = e.getRemark() + "mc";
                hpICCMGxb.setRight_dm(right_dm);
                hpICCMGxb.setRight_mc(right_mc);
            }
        });
        return hpICCMGxb;
    }

    public List<HpICCMGxb> selectSome(String leftVersion, String rightVersion, String table_name, String name)  {
        HpICCMGxb version = getVersion(leftVersion, rightVersion);
        String sql = "";
        if (!name.equals("")) {
            String likeName = getLikeName(name);
            sql = "where (" + version.getLeft_mc() + " like '" + likeName + "' or " + version.getRight_mc() + " like '" + likeName + "')";
        }

        List<HpICCMGxb> list = hpICCMGxbDao.selectByVersion(version.getLeft_bm(), version.getLeft_mc(),
                version.getRight_dm(), version.getRight_mc(), table_name, sql);

        return list;

    }

    public Map<String, List<HpICCMGxb>> selectLeftAndBzVersion(String leftVersion, String rightVersion, String type, String table_name)  {
        HpICCMGxb version = getVersion(leftVersion, rightVersion);
        Map<String, List<HpICCMGxb>> map = new HashMap<>();
        List<HpICCMGxb> list_left = hpICCMGxbDao.selectLeftByVersion(version.getLeft_bm(), version.getLeft_mc(), table_name);
        List<HpICCMGxb> list_right = hpICCMGxbDao.selectByTypeAndVersion(type, rightVersion);
        map.put("left", list_left);
        map.put("right", list_right);
        return map;
    }

    public List<HpICCMGxb> findWzdData(String rightVersion, String type, String leftMc)  {
        String left_mc = "";
        //gxType = leftVersion + "_" + rightVersion;
        if (!leftMc.equals("")) {
            String likeName = getLikeName(leftMc);
            left_mc = " and a.name like likeName  ";
        } else {
            left_mc = " ";
        }
        List<HpICCMGxb> list = hpICCMGxbDao.selectWdz(type, rightVersion, left_mc);
        return list;
    }

    public String getLikeName(String name)  {
        StringBuilder sb = new StringBuilder();
        sb.append("%");
        for (int i = 0; i < name.length(); i++) {
            sb.append(name.charAt(i)).append("%");
        }
        return sb.toString();
    }

    public String saveDz(String leftVersion, String rightVersion, String type, String tableName, String gxbName)  {
        String gxType = leftVersion + "_" + rightVersion;
        String sql = "select *  from  " + gxbName + " where status=0 and type='" + gxType + "'";
        //System.out.println(sql);
        //查找关系表中已存在的对照
        List<Map<String, Object>> list = hpICCMGxbDao.selectSqlWithSQL(sql);

        if (null != list && list.size() > 0) {
            return "当前关系表存在未对照关系，请核对";
        } else {
            HpICCMGxb version = getVersion(leftVersion, rightVersion);
            String right_mc = version.getRight_mc();
            String right_dm = version.getRight_dm();
            String left_dm = version.getLeft_bm();
            String left_mc = version.getLeft_mc();
            StringBuilder sb = new StringBuilder();
            List<Map<String, Object>> colum = getTableColum(tableName);
            String column = getColumn(colum);
            //查询版本对照表里是否有当前版本的字段
            String alterSql = "if not  exists (select * from syscolumns where id=object_id('" + tableName + "') and name in ('" + right_mc + "','" + right_dm + "'  ))\n" +
                    "begin alter table " + tableName + " add  " + right_dm + "  varchar(255)\n" +
                    "alter table " + tableName + " add  " + right_mc + " varchar(255)  end";
            hpICCMGxbDao.updateSqlWithSQL(alterSql);
            //对照
            sb.append("begin tran  begin try  DECLARE @start INT,@end INT  SELECT @start=COUNT(*) FROM dbo." + tableName + " ").append(LineBreak);
            sb.append("update " + tableName + " set  " + right_dm + " =b.right_dm," + right_mc + "=b.right_mc from " + tableName + "  a," + gxbName + " b where a." + left_dm + "=b.left_bm and b.type='" + gxType + "';").append(LineBreak);
            sb.append("with lsb as (select a.* from " + gxbName + " a left join " + tableName + " b on a.right_dm=b." + right_dm + "  and a.right_mc=b." + right_mc + " \n" +
                    "where   a.type='" + gxType + "'  and b." + right_dm + " is null and a.right_dm is not null)\n" +
                    "update c set c." + right_dm + " =d.right_dm,c." + right_mc + "=d.right_mc from " + tableName + " c , lsb d \n" +
                    "where c." + left_dm + "=d.left_bm  and c." + right_dm + " is null;\n" +
                    "with lsb2 as (select a.* from " + gxbName + " a left join " + tableName + " b on a.right_dm=b." + right_dm + "  and a.right_mc=b." + right_mc + " \n" +
                    "where   a.type='" + gxType + "'  and b." + right_dm + " is null and a.right_dm is not null)\n" +
                    "insert into " + tableName + " (" + column + "," + right_dm + "," + right_mc + ")\n" +
                    "select " + column + ", f.right_dm,right_mc from " + tableName + "  e , lsb2 f\n" +
                    " where e." + left_dm + "=f.left_bm  and e." + right_dm + " is not null and e." + right_dm + " !=f.right_dm ").append(LineBreak);
            sb.append("insert into " + tableName + " (id," + right_dm + ", " + right_mc + ") select NEWID(),code,name from hp_bzdmk a left join " + tableName + " b on   ( (a.code=b." + right_dm + " and a.name=b." + right_mc + " ) or  a.code=b." + right_dm + " or  a.name=b." + right_mc + ") \n" +
                    "where  a.type= " + type + " and a.version=" + rightVersion + " and b." + right_mc + " is null").append(LineBreak);

            sb.append(" SELECT @end=COUNT(*) FROM dbo." + tableName + "  SELECT  @end-@start end try  begin catch   SELECT -1  rollback tran end catch");
            //System.out.println(sb.toString());
            int i = hpICCMGxbDao.updateSqlWithSQL(sb.toString());
            if (i <= 0) {
                return "对照有误";
            } else {
                //对照完成后修改 关系表状态和类型
                String updateSql = "update " + gxbName + " set status=2  where  type='" + gxType + "'";
                hpICCMGxbDao.updateSqlWithSQL(updateSql);
            }
        }
        return "对照成功";
    }

    //拼接字段--用，隔开
    private String getColumn(List<Map<String, Object>> colum)  {
        if (null != colum && colum.size() > 0) {
            StringBuilder colums = new StringBuilder();
            colum.forEach(e -> {
                colums.append(e.get("name").toString()).append(",");
            });
            String s = colums.toString().substring(0, colums.length() - 1);
            return s;
        } else {
            return null;
        }

    }

    //获取未对照的版本号，版本名称
    public List getWdzVersion(String type, String tableName)  {
        String sql = "select distinct version,version_name  from hp_bzdmk  where type=" + type + " and version not in (select distinct c.val from sys.columns a \n" +
                "inner join sys.tables b on b.object_id=a.object_id \n" +
                "inner join hp_sys_dict_val c on SUBSTRING(a.name,0,LEN(a.name)-1)=c.remark \n" +
                "left join hp_bzdmk d on c.val=d.version and d.type=" + type + "\n" +
                "where b.name='" + tableName + "' and a.name not in ('id','lb','ssdj','iswc','isss','iszlxcz','isjr','ssdjversion'))";
        List<Map<String, Object>> list = hpICCMGxbDao.selectSqlWithSQL(sql);
        return list;
    }

    //获取已对照的版本号，版本名称
    public List getIcdYdzVersion(String tableName)  {
        String sql = "select distinct c.val,c.name from sys.columns a \n" +
                "inner join sys.tables b on b.object_id=a.object_id \n" +
                "inner join hp_sys_dict_val c on SUBSTRING(a.name,0,LEN(a.name)-1)=c.remark \n" +
                "where b.name='" + tableName + "' and a.name not in ('id','lb','ssdj','iswc','isss','iszlxcz','isjr','ssdjversion')";
        List<Map<String, Object>> list = hpICCMGxbDao.selectSqlWithSQL(sql);
        return list;
    }

    public List getIcdYdz2Version(String type)  {
        String sql = "select val,name from hp_sys_dict_val where remark='" + type + "' ";
        List<Map<String, Object>> list = hpICCMGxbDao.selectSqlWithSQL(sql);
        return list;
    }

    // 获取表的字段
    public List getTableColum(String tableName)  {
        String sql = "select distinct a.name name from sys.columns a \n" +
                "inner join sys.tables b on b.object_id=a.object_id \n" +
                "where b.name='" + tableName + "' and  a.name not in ('id','lb','ssdj','iswc','isss','iszlxcz','isjr')";
        List<Map<String, Object>> list = hpICCMGxbDao.selectSqlWithSQL(sql);
        return list;
    }

    //重置对照--删除大版本里面对应的版本的字段 （hpAuto....）修改关系表状态
    public void resetDz(String leftVersion, String rightVersion, String gxbName, String tableName)  {
        String gxType = leftVersion + "_" + rightVersion;
        HpICCMGxb version = getVersion(leftVersion, rightVersion);
        String right_mc = version.getRight_mc();
        String right_dm = version.getRight_dm();
        StringBuilder sb = new StringBuilder();
        sb.append("update " + gxbName + " set status=0  where  type='" + gxType + "'").append(LineBreak);
        sb.append("if   exists (select * from syscolumns where id=object_id('" + tableName + "') and name in ('" + right_mc + "','" + right_dm + "'  ))").append(LineBreak);
        sb.append("begin   alter table " + tableName + " DROP COLUMN " + right_dm).append(LineBreak);
        sb.append("alter table " + tableName + " DROP COLUMN  " + right_mc + "  end").append(LineBreak);
        //System.out.println(sb.toString());
        hpICCMGxbDao.updateSqlWithSQL(sb.toString());
    }

    //修改手术等级
    public void updateSSdj(String leftVersion, String rightVersion)  {
        HpICCMGxb version = getVersion(leftVersion, rightVersion);
        //System.out.println(version);
        String updateSsSql = "update a set a.lb=b.lb,a.ssdj=b.ssjb,a.iswc=b.iswc,a.isss=b.isss,a.iszdxcz=b.iszdxcz,a.iszlxcz=b.iszlxcz,a.isjr=b.isjr,a.ssdjversion=b.ssdjversion from hp_ICCMAutoDz a left join hp_2sscz b on \n" +
                "a." + version.getRight_dm() + "=b.zybm and a." + version.getRight_mc() + "=b.ssmc where  a." + version.getRight_dm() + " is not null \n" +
                "update a set a.lb='',a.ssdj=0,a.iswc=0,a.isss=0,a.iszlxcz=0,a.iszdxcz=0,a.isjr=0,a.ssdjversion='' from hp_ICCMAutoDz a where a." + version.getRight_dm() + " is  null  ";
        hpICCMGxbDao.updateSqlWithSQL(updateSsSql);

        Map<Integer, List<SysDictVal>> baMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        List<SysDictVal> sysDictVals = baMap.get(89);
        sysDictVals = sysDictVals.stream().filter(e -> null != e && e.getVal().equals(rightVersion)).collect(Collectors.toList());
        String name = "";
        if (null != sysDictVals && sysDictVals.size() > 0) {
            SysDictVal sysDictVal = sysDictVals.get(0);
            name = sysDictVal.getName();
        }
        String updateDictSql = "update hp_sys_dict_val set val=" + rightVersion + ", name='" + name + "' where dict_id=103";
        hpICCMGxbDao.updateSqlWithSQL(updateDictSql);
        List<SysDictVal> dcDitVals = sysDictValDao.selectAll();
        Map<Integer, List<SysDictVal>> baBmMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1 && "病案编码字典".equals(e.getSupplement_name())).collect(Collectors.groupingBy(e -> e.getDict_id()));
        ApplicationRunnerImpl.contextMap.put("baBmMap", baBmMap);
    }

    public String selectSSVersion(String table)  {
        String version = hpICCMGxbDao.selectSsVersion(table);
        return version;
    }
}
