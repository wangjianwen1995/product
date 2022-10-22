package com.sxdl.hp.util;

import com.sxdl.hp.entity.HpCondition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SqlUtil {

    public static String retrunsql(List<HpCondition> hpConditions)  {

        List<String> list = new ArrayList<>();
        List<HpCondition> hpCondition = hpConditions.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(user ->
                                user.getTable_name()))), ArrayList::new));
        for (HpCondition condition : hpCondition) {
            list.add(condition.getTable_name());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("  from homepage  ");
        if (list.contains("dl_fllow")) { //包含山西附页附页
            sb.append(" left join dl_fllow   on homepage.A_ID = dl_fllow.A_ID \r\n");
        }

        if (list.contains("VsCH0P")) {
            sb.append(" left join VsCH0P   on homepage.A_ID = VsCH0P.A_ID \r\n");
        }
        return sb.toString();
    }
}
