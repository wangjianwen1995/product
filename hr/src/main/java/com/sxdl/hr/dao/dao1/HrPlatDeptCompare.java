package com.sxdl.hr.dao.dao1;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * @author shqrpknife
 * @create 2022-08-05-16:16
 */
public interface HrPlatDeptCompare {
    @Insert("insert into dzks (yyksname,dzid) values('${hsptName}','${platCode}')")
    int Insert(String hsptName,String platCode);

    @Delete("delete from dzks where yyksname = '${hsptName}'")
    int Del(String hsptName);
}
