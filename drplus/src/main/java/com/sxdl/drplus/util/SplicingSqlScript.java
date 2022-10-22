package com.sxdl.drplus.util;


import cn.hutool.core.util.StrUtil;
import com.sxdl.drplus.entity.DrPlusTargetWarning;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类专用 拼接sql 语句
 *  key 方法 命名规则splicing+[目标]+Sql
 */
public class SplicingSqlScript {

    public static final  String LineBreak = "\r\n";


    public static void main(String[] args) {
        List<DrPlusTargetWarning> list = new ArrayList<>();
        // Integer drplus_platform_detailed_id,  String name,  Integer type,  String sql, String val, String val2, Integer isuse, Integer isqy
        DrPlusTargetWarning warning = new DrPlusTargetWarning(2,"出院人数",1,"count(distinct case when isnull(p22,'')!='' then PRIMAEYKEY else null end)","3000",null,null,1);
        DrPlusTargetWarning warning2 = new DrPlusTargetWarning(2,"入院人数",1,"count(1)","3000",null,null,1);
        DrPlusTargetWarning warning3 = new DrPlusTargetWarning(2,"合计指标",1," SUM(ISNUMERIC(p414)) ","20",null,null,1);
        DrPlusTargetWarning warning4 = new DrPlusTargetWarning(2,"平均指标",1," cast (avg (distinct  ISNUMERIC(p799)) as decimal(15,2)) ","0.2",null,null,1);
        list.add(warning);
        list.add(warning2);
        list.add(warning3);
        list.add(warning4);
        String s = splicingTargetResultSql(list, 2, 2);
        System.out.println(s);


    }

    public static String splicingTargetResultSql(List<DrPlusTargetWarning> list,Integer pid,Integer eid){
        StringBuilder sb = new StringBuilder(" select '指标' c1, '标准值' c2 , '实际值' c3 , '类型(隐藏)' c4, '值1(隐藏)' c5, '值2(隐藏)' c6 ");
        list.forEach(e->{
            // select 字段部分
            sb.append(LineBreak+"   union all "+LineBreak);  //指标名称
            sb.append(" select '"+e.getName()+"' , " );  //标准值
            sb.append("'"+(e.getType()==3?e.getVal()+"~"+e.getVal2():e.getVal())+"' , " ); //实际值
            sb.append("cast( "+e.getSql()+" as varchar) , " );
            sb.append(" '"+e.getType()+"' , ");
            sb.append(" '"+ (StrUtil.isEmpty(e.getVal())?"":e.getVal() )+"' , ");
            sb.append(" '"+ (StrUtil.isEmpty(e.getVal2())?"":e.getVal2() )+"'  ");
            // from 表部分
            if (pid==6 || pid==7) {
                sb.append(" from drplus_center_table_data"+pid+"a ");
                if(!StringUtils.isEmpty(e.getIsuse())&& 1==e.getIsuse()){
                    sb.append(" a left join drplus_center_table_data"+pid+"b b on b.PRIMAEYKEY= a.PRIMAEYKEY ");
                }
            }else if (pid==10 ||pid==15  ){
                sb.append(" from drplus_center_table_data"+pid+"a ");
                if(!StringUtils.isEmpty(e.getIsuse())&& 1==e.getIsuse()){
                    sb.append(" a ").append(LineBreak);
                    for (String tab : e.getUsetable().split(",")) {
                        sb.append(" left join drplus_center_table_data"+pid+tab+" "+tab+" on "+tab+".PRIMAEYKEY= a.PRIMAEYKEY ").append(LineBreak);
                    }
                }
            }else{
                sb.append(" from drplus_center_table_data"+pid+" ");
            }

            // where 部分
            if ( !StringUtils.isEmpty(e.getIsuse()) && 1==e.getIsuse() &&( pid==6 || pid==7 || pid==10 || pid==15)) {
                sb.append(" where a.drplus_extract_detailed_id = "+eid);

            }else{
                sb.append(" where drplus_extract_detailed_id = "+eid);
            }
        });
        return sb.toString();
    }


}
