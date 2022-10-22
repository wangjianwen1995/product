package com.sxdl.hp;

import cn.hutool.core.io.FileUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.ZipDao;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestFields extends HpMainTest {
    @Autowired
    ZipDao zipDao;
    String sql = "SELECT\n" +
            "    表名 = case when a.colorder = 1 then d.name else '' end,\n" +
            "    表说明 = case when a.colorder = 1 then isnull(f.value, '') else '' end,\n" +
            "    字段序号 = a.colorder,\n" +
            "    字段名 = a.name,\n" +
            "    标识 = case when COLUMNPROPERTY(a.id, a.name, 'IsIdentity')= 1 then '√'else '' end,\n" +
            "    主键 = case when exists(SELECT 1 FROM sysobjects where xtype = 'PK' and parent_obj = a.id and name in (\n" +
            "               SELECT name FROM sysindexes WHERE indid in(SELECT indid FROM sysindexkeys WHERE id = a.id AND colid = a.colid))) then '√' else '' end,\n" +
            "    类型 = b.name,\n" +
            "    占用字节数 = a.length,\n" +
            "    长度 = COLUMNPROPERTY(a.id, a.name, 'PRECISION'),\n" +
            "    小数位数 = isnull(COLUMNPROPERTY(a.id, a.name, 'Scale'), 0),\n" +
            "    允许空 = case when a.isnullable = 1 then '√'else '' end,\n" +
            "    默认值 = isnull(e.text, ''),\n" +
            "    字段说明 = isnull(g.[value], '')\n" +
            "FROM\n" +
            "    syscolumns a\n" +
            "left join\n" +
            "    systypes b\n" +
            "on\n" +
            "    a.xusertype = b.xusertype\n" +
            "inner join\n" +
            "    sysobjects d\n" +
            "on\n" +
            "    a.id = d.id  and d.xtype = 'U' and d.name <> 'dtproperties'\n" +
            "left join\n" +
            "    syscomments e\n" +
            "on\n" +
            "    a.cdefault = e.id\n" +
            "left join\n" +
            "sys.extended_properties g\n" +
            "on\n" +
            "    a.id = G.major_id and a.colid = g.minor_id\n" +
            "left join\n" +
            "sys.extended_properties f\n" +
            "on\n" +
            "    d.id = f.major_id and f.minor_id = 0\n" +
            "where\n" +
            "    d.name = '@@@@'" +
            "order by\n" +
            "    a.id,a.colorder";
    String sql2 = "select * from hp_column where table_name='@@@@'", name;
    List<Map<String, Object>> maps, maps2;
    Field[] fields;
    Map<String, compared> result;
    Map<String, compared> result2;
    Map<String, compared> result3, allresult;
    compared cop;
    StringBuilder sb;

    @Test
    public void TestFields() throws ClassNotFoundException {
        File fils = new File("src\\main\\java\\com\\sxdl\\hp\\entity");
        FileUtil.del("compareCol");
        for (File f : fils.listFiles()) {
            name = f.getPath().split("java\\\\")[1];
            name = name.substring(0, name.length() - 5).replaceAll("\\\\", ".");
            comparaFields(name);
        }
    }

    /**
     * 根据传入的类名称,比较entity,数据库实际表和数据库TC表记录,并记录到文件中
     *
     * @param classname
     */
    private void comparaFields(String classname) throws ClassNotFoundException {
        result = new HashMap<>();
        result2 = new HashMap<>();
        result3 = new HashMap<>();
        allresult = new HashMap<>();
        Class T = Class.forName(classname);
        fields = T.getDeclaredFields();
        String dbn, col;
        ApiModelProperty annotation;

        if (!T.isAnnotationPresent(Table.class)) {
            return;
        }
        Table tAnnotation = (Table) T.getAnnotation(Table.class);
        String tablename = tAnnotation.name();
        sb = new StringBuilder();
        for (Field f : fields) {
            col = f.getName();
            if ("serialVersionUID".equals(col)) {
                continue;
            }
            if (f.isAnnotationPresent(Transient.class)) {
                continue;
            }
            if (f.isAnnotationPresent(ApiModelProperty.class)) {
                annotation = f.getAnnotation(ApiModelProperty.class);
                dbn = annotation.value();
                dbn = StringUtil.isNotEmpty(dbn) ? dbn : "无";
                result.put(col, new compared(col, dbn, "", ""));
            } else {
                result.put(col, new compared(col, "无", "", ""));
            }
            allresult.put(col, result.get(col));
        }
        sb.append("entity中字段数量 " + result.size()).append("\n");
        maps = zipDao.selectSqlWithSQL(sql.replace("@@@@", tablename));
        for (Map m : maps) {
            col = m.get("字段名").toString();
            dbn = m.get("字段说明").toString();
            dbn = StringUtil.isNotEmpty(dbn) ? dbn : "无";
            if (result.containsKey(col)) {
                cop = result.get(col);
                cop.setDbName(dbn);
            } else {
                result2.put(col, new compared(col, "", dbn, ""));
                allresult.put(col, result2.get(col));
            }
        }
        sb.append("数据库 " + maps.size()).append("\n");
        maps2 = zipDao.selectSqlWithSQL(sql2.replace("@@@@", tablename));
        for (Map m : maps2) {
            col = m.get("name").toString();
            dbn = m.get("name_zh").toString();
            dbn = StringUtil.isNotEmpty(dbn) ? dbn : "无";
            if (result.containsKey(col)) {
                cop = result.get(col);
                cop.setTcname(dbn);
            } else if (result2.containsKey(col)) {
                cop = result2.get(col);
                cop.setTcname(dbn);
            } else {
                result3.put(col, new compared(col, "", "", dbn));
                allresult.put(col, result3.get(col));
            }
        }
        sb.append("fields of Table's colums is " + maps2.size()).append("\n");

        sb.append("3组数据合并后共有 " + allresult.size()).append("\n");
        List<compared> etlist = allresult.values().stream().filter(e -> StringUtil.isEmpty(e.getEntityName())).collect(Collectors.toList());
        List<compared> dblist = allresult.values().stream().filter(e -> StringUtil.isEmpty(e.getDbName())).collect(Collectors.toList());
        List<compared> tclist = allresult.values().stream().filter(e -> StringUtil.isEmpty(e.getTcname())).collect(Collectors.toList());
        sb.append("entity类中欠缺的   " + etlist).append("\n");
        sb.append("实际表中欠缺的   " + dblist).append("\n");
        sb.append("系统tc表-column表中欠缺的   " + tclist);

        FileUtil.writeUtf8String(sb.toString(), "compareCol\\" + classname.split("\\.")[4] + ".txt");
    }
}

@Data
class compared {
    private String key;
    private String entityName;
    private String dbName;
    private String tcname;

    public compared() {
    }

    public compared(String key, String entityName, String dbName, String tcname) {
        this.key = key;
        this.entityName = entityName;
        this.dbName = dbName;
        this.tcname = tcname;
    }

    @Override
    public String toString() {
        return key + ",entity注释= " + entityName + ",库表注释= " + dbName + ",tc表中文注释= " + tcname + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        compared compared = (compared) o;
        return Objects.equals(key, compared.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}