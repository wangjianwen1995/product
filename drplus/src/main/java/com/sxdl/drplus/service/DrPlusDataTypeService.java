package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.dao1.DrPlusDataTypeDao;
import com.sxdl.drplus.dao1.DrPlusPlatformDetailedDao;
import com.sxdl.drplus.dto.ProcessDataDBO;
import com.sxdl.drplus.dto.RevokeDBO;
import com.sxdl.drplus.entity.DrPlusDataType;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@Transactional
public class DrPlusDataTypeService extends BaseUUIDServiceImpl<DrPlusDataType> {


    @Autowired
    private DrPlusDataTypeDao dataTypeDao;
    @Autowired
    private DrPlusPlatformDetailedDao plusPlatformDao;



    /**
     * 数据初审
     *   1 应该查看  drplus_data_type 状态表中 是否存在 pid 和PRIMAEYKEY 一样的数据
     *      如果存在就开始修改  不存在就新增一条数据
     *
     *     2  数据审核应该先通过质控 ,质控没有问题才能审核
     *
     * @param pid
     * @param PRIMAEYKEY
     */
    public void startFirstReview(Integer pid, String PRIMAEYKEY,String msg,Integer type) {

        DrPlusDataType drPlusDataType = new DrPlusDataType();
        if(dataTypeDao.getCountData(pid,PRIMAEYKEY)==1){
            drPlusDataType.setDrplus_platform_detailed_id(pid);
            drPlusDataType.setPrimarykey_val(PRIMAEYKEY);
            DrPlusDataType drPlusDataType1 = dataTypeDao.selectOne(drPlusDataType);
            if(StringUtils.isEmpty(drPlusDataType1.getReview_type())||drPlusDataType1.getReview_type()==0||drPlusDataType1.getReview_type()==-1 ||drPlusDataType1.getReview_type()==1  ){
                drPlusDataType1.setReview_type(type);
                drPlusDataType1.setFirst_review_time(DataUtil.getDateTime());
                drPlusDataType1.setFirst_review_msg(msg);
                dataTypeDao.updateByPrimaryKey(drPlusDataType1);
            }
        }else if (dataTypeDao.getCountData(pid,PRIMAEYKEY)==0){
            drPlusDataType.setDrplus_platform_detailed_id(pid);
            drPlusDataType.setPrimarykey_val(PRIMAEYKEY);
            drPlusDataType.setReview_type(type);
            drPlusDataType.setFirst_review_time(DataUtil.getDateTime());
            drPlusDataType.setFirst_review_msg(msg);
            dataTypeDao.insert(drPlusDataType);
        }

    }


    public List<RevokeDBO>  getRevokeCodes(Integer pid, Integer eid){
        return dataTypeDao.getRevokeCodes(pid,eid);
    }

    public Integer getCountData(Integer pid, String bah) {
        return dataTypeDao.getCountData(pid,bah);
    }


    public DrPlusDataType getDatabyBah(Integer pid, String bah) {
        return dataTypeDao.getDatabyBah(pid,bah);
    }
    public static final  String LineBreak = "\r\n";


    public List<LinkedHashMap<String, Object>> getReportResult(String stime, String etime) {
        //获取开启的 平台
        List<DrPlusPlatformDetailed> plusPlatform = plusPlatformDao.getSheduledData();
        StringBuilder sb = new StringBuilder(" select '代码' dm ,'平台' name ,'上报数' num ");
        plusPlatform.forEach(e->{
            sb.append(LineBreak+"   union all "+LineBreak);
            sb.append(" select '"+e.getId()+"', "+"'"+e.getName()+"', "+"'"+getReportResultNum(e.getId(),stime,etime)+"'");
        });
        String sqlText = sb.toString();
        List<LinkedHashMap<String, Object>> dataBySql = dataTypeDao.getDataBySql(sqlText);
        return dataBySql;
    }

    private Integer getReportResultNum(Integer pid , String stime, String etime) {
        //获取开启的 平台
        String tab = "";
        if(pid==6|| pid==7 || pid==10||pid==15)
            tab = "a";
        String sqlText = "select COUNT(1)  total " +
                " from  dbo.drplus_center_table_data"+pid+tab+" a   " +
                " left  join  drplus_data_type b on  b.drplus_platform_detailed_id= "+pid+" and a.PRIMAEYKEY = b.primarykey_val and report_type = 1" +
                " where  b.reprot_time between '"+stime+"' and '" +etime+"' " ;
        Integer Num = dataTypeDao.getReportResultNum(sqlText);
        return Num;
    }

    public  List<ProcessDataDBO>   drillDownDiff(Integer p1, Integer p2, String stime, String etime) {
        String taba = "";
        String tabb = "";
        if(p1==6|| p1==7 ||p1==10)
            taba = "a";
        if(p2==6|| p2==7 ||p2==10)
            tabb = "a";
        List<ProcessDataDBO> list =  dataTypeDao.drillDownDiff(p1,p2,stime,etime,taba,tabb);
        return list;
    }


}
