package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.product.dc.entity.HpTumourGxb;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpTumourGxbDao extends BaseDao<HpTumourGxb> {
    @Select("select ${left_dm} as left_bm,${left_mc} as left_mc,${right_dm} as right_dm,${right_mc} as right_mc from ${table_name}")
    List<HpTumourGxb> selectByVersion(@Param("left_dm") String left_dm,
                                    @Param("left_mc") String left_mc,
                                    @Param("right_dm") String right_dm,
                                    @Param("right_mc") String right_mc, @Param("table_name")String table_name);

    /*@Select("select ${left_dm} as left_bm,${left_mc} as left_mc,${right_dm} as right_dm,${right_mc} as right_mc from hp_ICDAutoDz")
    List<HpICDAutoDz> selectByBzVersion(@Param("left_dm") String left_dm,
                                        @Param("left_mc") String left_mc,
                                        @Param("rightVersion") String rightVersion,
                                        @Param("type") String type);
    */



    @Select("select code as right_dm,name as right_mc from hp_bzdmk where type=${type} and version=${rightVersion} ")
    List<HpTumourGxb> selectByTypeAndVersion(@Param("type") String type, @Param("rightVersion") String rightVersion);
 /*   @Select("select code as as right_dm,name as right_mc from hp_bzdmk a left join hp_iccm_gxb b on  \n" +
        " ((a.code=b.right_dm and a.name=b.right_mc) or  a.code=b.right_dm or  a.name=b.right_mc) and b.type=${gxtype} \n" +
        "where  a.type=${type} and version=${version} ${left_mc}  ")
    List<HpICDAutoDz> selectWdz(@Param("gxtype") String gxtype,
                                @Param("type") String type,
                                @Param("version") String version,@Param("left_mc") String left_mc);*/

    @Select("select code as as right_dm,name as right_mc from hp_bzdmk a where  a.type=${type} and version=${version} ${left_mc}  ")
    List<HpTumourGxb> selectWdz(@Param("type") String type,
                              @Param("version") String version,
                              @Param("left_mc") String left_mc);

    @Select("select distinct ${left_dm} as left_bm,${left_mc} as left_mc from hp_TumourAutoDz where ${left_dm} is not null")
    List<HpTumourGxb> selectLeftByVersion(String left_bm, String left_mc);
}
