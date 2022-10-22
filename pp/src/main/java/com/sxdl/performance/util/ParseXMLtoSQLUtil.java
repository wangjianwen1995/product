package com.sxdl.performance.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 旧hbi导出的xml数据解析成可执行sql的工具类
 */
public class ParseXMLtoSQLUtil {
    final static String biProject = "biProject", DsnAnalysisFrom = "DsnAnalysisFrom", DsnAnalysisFromopt = "DsnAnalysisFromopt", DsnAnalysisFromField = "DsnAnalysisFromField", DsnAnalysisFromGridOpt = "DsnAnalysisFromGridOpt",
            DsnAnalysisFromHtml = "DsnAnalysisFromHtml", Market_Table = "Market_Table", Market_Field = "Market_Field", Market_tablexy_cxcs = "Market_tablexy_cxcs",
            MarketTargetCxCsOpt = "MarketTargetCxCsOpt", Market_Targets = "Market_Targets", Market_Fl = "Market_Fl", Wei_Table = "Wei_Table", Wei_Field = "Wei_Field", Weitableqxsql = "Weitableqxsql", Wei_table_wTj = "Wei_table_wTj", wei_table_fl = "wei_table_fl";
    static Map<String, String> maps;

    static {
        maps = new HashMap<>();
        maps.put(DsnAnalysisFrom, "delete from DsnAnalysisFrom where ID =@@@@\r\n insert into DsnAnalysisFrom ([ID], [aid], [mc], [issh], [isedt], [isdel], [isnew], [cdate], [bz], [dm], [otherid], [lx], [pid]) VALUES (");
        maps.put(DsnAnalysisFromopt, "delete from DsnAnalysisFromopt where ID =@@@@\r\n INSERT INTO DsnAnalysisFromOpt ([Id], [aid], [fid], [pagecount], [keylx], [savejscode], [shfieldid], [keyfield], [lenfield]) VALUES (");
        maps.put(DsnAnalysisFromField, "delete from DsnAnalysisFromField where ID =@@@@\r\n INSERT INTO [DsnAnalysisFromField]([ID], [aid], [fid], [htmlvcl], [htmlid], [fieldid], [lx], [lxbz], [css], [cssclass], [jscode], [isedt], [NoAir], [NoRepeat], [Mrfield], [tipxx]) VALUES (");
        maps.put(DsnAnalysisFromGridOpt, "delete from DsnAnalysisFromGridOpt where ID =@@@@\r\n insert into [DsnAnalysisFromGridOpt]([ID], [aid], [fid], [fieldid], [xh], [titlemc], [width]) VALUES (");
        maps.put(DsnAnalysisFromHtml, "delete from DsnAnalysisFromHtml where ID =@@@@\r\n insert into DsnAnalysisFromHtml ([ID], [aid], [htmltext], [fid]) VALUES (");
        maps.put(biProject, "delete from biProject where ID =@@@@\r\n insert into biProject ([Id], [mc], [lx]) VALUES (");
        maps.put(Market_Table, "delete from Market_table where ID=@@@@\r\n insert into [Market_table] ([Id],[mcode],[mc],[bz] ,[pym],[cdate],[Ms_sql],[Oracle_sql],[mySql],[DbSql],[fl_Id],[datelx],[xh],[isxy],[Isinfo],[ismx]) values (");
        maps.put(Market_Field, "DELETE FROM Market_Field WHERE ID =@@@@\r\n INSERT into [Market_Field] ([Id],[tid],[fcode],[mc],[pym],[bz],[cdate],[lx],[cd],[xs],[iskey],[ldfield],[wid],[wfid],[wfid2],[wlx],[xh] )values(");
        maps.put(Market_tablexy_cxcs, "delete Market_tablexy_cxcs where ID=@@@@\r\n insert into [Market_tablexy_cxcs] ([Id],[tid],[xh],[mc],[code],[bz],[code2],[mrval])values(");
        maps.put(MarketTargetCxCsOpt, "delete from MarketTargetCxCsOpt where ID=@@@@\r\n insert into [MarketTargetCxCsOpt] ([Id],[tid],[xh],[mc],[sqlbz],[bz],[cdate])values(");
        maps.put(Market_Targets, "delete from Market_Targets where ID=@@@@\r\n insert into [Market_Targets] ([Id],[fl2Id],[mc],[bz],[jsfz],[bdz1],[bdz2],[tId],[fieldmc],[xsws],[xh],[pym])values(");
        maps.put(Market_Fl, "delete from Market_Fl where ID=@@@@\r\n insert into [Market_Fl] ([Id],[mc],[xh],[pid])values(");
        maps.put(Wei_Table, "delete from Wei_table where ID=@@@@\r\n insert into Wei_table([Id],[mcode],[mc],[bz],[pym],[cdate],[Ms_sql],[Oracle_sql],[mySql],[DbSql],[xh],[fl],[mc2],[isbz],[isplan])values(");
        maps.put(Wei_Field, "delete from Wei_Field where ID=@@@@\r\n insert into Wei_Field([Id],[w_Id],[xh],[fcode],[mc],[pym],[bz],[cdate],[lx],[cd],[xs],[Iskey],[NoAir],[NoRepeat],[flx])values(");
        maps.put(Weitableqxsql, "delete from Weitableqxsql where ID=@@@@\r\n insert into Weitableqxsql([Id],[sql],[bz],[wid])values(");
        maps.put(Wei_table_wTj, "delete from Wei_table_wTj where ID=@@@@ insert into Wei_table_wTj([Id],[wid],[mc],[bz],[cdate],[Ms_sql],[Oracle_sql],[mySql],[DbSql])values(");
        maps.put(wei_table_fl, "delete from wei_table_fl where ID=@@@@\r\n insert into [wei_table_fl] ([Id],[mc],[xh],[pid])values(");
    }

    //解析,替换,处理xml数据
    public static String jiexi(String s, String key) {
        s = s.replaceAll("↓", ",");
        if (s.trim().endsWith(",")) {
            s = s.substring(0, s.length() - 1);
        }
        return maps.get(key).replace("@@@@", s.substring(0, 38)) + s + ")\r\n";
    }

    //获取单条数据,节点名字是value
    public static Element getChild(Element e) {
        return XmlUtil.getElement(e, "value");
    }

    //获取列表数据,节点名字是ffvalue
    public static StringBuilder getFFvalues(Element e, String childTagName, StringBuilder sb) {
        List<Element> ffs = XmlUtil.getElements(XmlUtil.getElement(e, childTagName), null);
        if (null != ffs && !ffs.isEmpty()) {
            for (Element ee : ffs) {
                if (StrUtil.isNotEmpty(ee.getTextContent())) {
                    sb.append(jiexi(ee.getTextContent(), childTagName));
                }
            }
        }
        return sb;
    }

    public static void coverToSQL(String xmlpath) {
        Document d = XmlUtil.readXML(xmlpath);
        Element es = XmlUtil.getRootElement(d);
        List<Element> elements = XmlUtil.getElements(es, null);
        StringBuilder sb = new StringBuilder();
        String filename = "空白";
        for (Element e : elements) {
            switch (e.getTagName()) {
                case DsnAnalysisFrom://表单
                    sb.append(jiexi(getChild(e).getTextContent(), DsnAnalysisFrom));
                    sb = getFFvalues(e, DsnAnalysisFromopt, sb);
                    sb = getFFvalues(e, DsnAnalysisFromField, sb);
                    sb = getFFvalues(e, DsnAnalysisFromGridOpt, sb);
                    sb = getFFvalues(e, DsnAnalysisFromHtml, sb);
                    filename = "表单";
                    break;
                case biProject:
                    sb.append(jiexi(getChild(e).getTextContent(), biProject));
                    break;
                case Market_Table:
                    sb.append(jiexi(getChild(e).getTextContent(), Market_Table));
                    sb = getFFvalues(e, Market_Field, sb);
                    sb = getFFvalues(e, Market_tablexy_cxcs, sb);
                    sb = getFFvalues(e, MarketTargetCxCsOpt, sb);
                    filename = "事实表";
                    break;
                case Market_Targets:
                    sb.append(jiexi(getChild(e).getTextContent(), Market_Targets));
                    break;
                case Market_Fl:
                    sb.append(jiexi(getChild(e).getTextContent(), Market_Fl));
                    break;
                case Wei_Table:
                    sb.append(jiexi(getChild(e).getTextContent(), Wei_Table));
                    sb = getFFvalues(e, Wei_Field, sb);
                    sb = getFFvalues(e, Weitableqxsql, sb);
                    sb = getFFvalues(e, Wei_table_wTj, sb);
                    filename = "维表";
                    break;
                case wei_table_fl:
                    sb.append(jiexi(getChild(e).getTextContent(), wei_table_fl));
                    break;
            }
        }
        FileUtil.writeUtf8String(sb.toString(), "D:\\workspaces\\IDEA\\sxdl\\adr\\files\\" + filename + ".sql");
        System.out.println(sb);
    }
}
