package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusCenterTableDao;
import com.sxdl.drplus.dao1.DrPlusPlatformDetailedDao;
import com.sxdl.drplus.dto.AUTODBO;
import com.sxdl.drplus.dto.AUTOReportDBO;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class DrPlusPlatformDetailedService extends BaseServiceImpl<DrPlusPlatformDetailed> {


    private static final  String TABLE="drplus_center_table_data";
    private static final  String TABLE_IOC="drplus_center_table_data_ioc";

    @Autowired
    private DrPlusCenterTableDao centerTableDao;


    @Autowired
    private DrPlusPlatformDetailedDao detailedDao;

    public DrPlusPlatformDetailed getPlatformDetailedById(Integer id) {
        return detailedDao.selectByPrimaryKey(id);
    }

    public int getCountById(Integer id) {
        return detailedDao.getCountById(id);
    }




    public int updateType(Integer id, Integer type) {
        return detailedDao.updateType(id,type);
    }

    public List<DrPlusPlatformDetailed> getSheduledData() {
        return detailedDao.getSheduledData();
    }

    public Integer getcountByCron(String corn){
            return detailedDao.getcountByCron(corn);
    }



    public void setSheduled(AUTODBO sheduledDBO) {
        Integer i  = detailedDao.setSheduledData(
                sheduledDBO.getId(),
                sheduledDBO.getIs_autoextract(),
                sheduledDBO.getIs_autocode(),
                sheduledDBO.getIs_autoreview(),
                sheduledDBO.getIs_autoreport(),
                sheduledDBO.getCron(),
                sheduledDBO.getIsopen(),
                sheduledDBO.getOffset(),
                sheduledDBO.getE_days()
        );
    }

    public void setSheduled2(AUTOReportDBO dbo) {
        Integer i  = detailedDao.setSheduledData2(
                dbo.getId(),
                dbo.getCron2(),
                dbo.getIsopen2(),
                dbo.getOffset2(),
                dbo.getE_days2()
        );
    }

    public List<DrPlusPlatformDetailed> getScheduledByCron(String corn) {
        return detailedDao.getScheduledByCron(corn);
    }

    public void saveDetailedData(DrPlusPlatformDetailed detailed) throws IOException {
        if(detailedDao.getCountById(detailed.getId())< 1){
            int i = detailedDao.saveDetailedId(detailed.getId());

        }
        int i2 = detailedDao.updateByPrimaryKey(detailed);
        //key 1  每个平台在储存数据都有自己的一个表 根据平台id 判断是哪个表   超过1024字段的上报平台 存储实施人员将表拆分,本地根据JSON文件进行创建表,和字段构建
        if(6==detailed.getId()||7==detailed.getId() ){

            if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"a")==0){
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesql(detailed.getId(),1,"a").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"a").toString());
                //将字段数据 添加到center表中
                Integer tt = centerTableDao.insetColDateAdd(detailed.getId(),"a");
            }

            if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"b")==0){
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesql(detailed.getId(),1,"b").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"b").toString());
                //将字段数据 添加到center表中
                Integer tt = centerTableDao.insetColDateAddB(detailed.getId(),"b");
            }
            if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"a")==0) {
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesql(detailed.getId(), 2,"a").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 2,"a").toString());
            }
            if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"b")==0) {
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesql(detailed.getId(), 2,"b").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 2,"b").toString());
            }

        }else if(10==detailed.getId() || 15==detailed.getId()){ //四个表 一个主表, 其他都是一对多的子表
            if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"a")==0){
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesql(detailed.getId(),1,"a").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"a").toString());
                //将字段数据 添加到center表中
                Integer tt = centerTableDao.insetColDateAdd(detailed.getId(),"a");
            }

            if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"b")==0){
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesqlNoKey(detailed.getId(),1,"b").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"b").toString());
                //将字段数据 添加到center表中
                Integer tt = centerTableDao.insetColDateAddOneToMany(detailed.getId(),"b");
            }

            if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"c")==0){
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesqlNoKey(detailed.getId(),1,"c").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"c").toString());
                //将字段数据 添加到center表中
                Integer tt = centerTableDao.insetColDateAddOneToMany(detailed.getId(),"c");
            }

            if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"d")==0){
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesqlNoKey(detailed.getId(),1,"d").toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"d").toString());
                //将字段数据 添加到center表中
                Integer tt = centerTableDao.insetColDateAddOneToMany(detailed.getId(),"d");
            }



            // 容器表
            if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"a")==0) {
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesql(detailed.getId(), 2,"a").toString());

            }
            if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"b")==0) {
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesqlNoKey(detailed.getId(), 2,"b").toString());
            }
            if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"c")==0) {
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesqlNoKey(detailed.getId(), 2,"c").toString());
            }
            if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"d")==0) {
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesqlNoKey(detailed.getId(), 2,"d").toString());
            }

            if(15==detailed.getId()){
                if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"e")==0){
                    //  创建表
                    Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesqlNoKey(detailed.getId(),1,"e").toString());
                    //  添加注释
                    Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"e").toString());
                    //将字段数据 添加到center表中
                    Integer tt = centerTableDao.insetColDateAddOneToMany(detailed.getId(),"e");
                }

                if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"f")==0){
                    //  创建表
                    Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesqlNoKey(detailed.getId(),1,"f").toString());
                    //  添加注释
                    Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"f").toString());
                    //将字段数据 添加到center表中
                    Integer tt = centerTableDao.insetColDateAddOneToMany(detailed.getId(),"f");
                }

                if(centerTableDao.isExistsTable(TABLE+detailed.getId()+"g")==0){
                    //  创建表
                    Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesqlNoKey(detailed.getId(),1,"g").toString());
                    //  添加注释
                    Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1,"g").toString());
                    //将字段数据 添加到center表中
                    Integer tt = centerTableDao.insetColDateAddOneToMany(detailed.getId(),"g");
                }

                if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"e")==0) {
                    //  创建表
                    Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesqlNoKey(detailed.getId(), 2,"e").toString());
                }

                if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"f")==0) {
                    //  创建表
                    Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesqlNoKey(detailed.getId(), 2,"f").toString());
                }

                if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId()+"g")==0) {
                    //  创建表
                    Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesqlNoKey(detailed.getId(), 2,"g").toString());
                }
            }

        }else {
            if(centerTableDao.isExistsTable(TABLE+detailed.getId())==0){
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL( DataUtil.createTablesql(detailed.getId(),1).toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 1).toString());
                //将字段数据 添加到center表中
                Integer tt = centerTableDao.insetColDate(detailed.getId());
            }

            if(centerTableDao.isExistsTable(TABLE_IOC+detailed.getId())==0) {
                //  创建表
                Integer integer = centerTableDao.updateSqlWithSQL(DataUtil.createTablesql(detailed.getId(), 2).toString());
                //  添加注释
                Integer tableBysql = centerTableDao.updateSqlWithSQL(DataUtil.createExtendedsql(detailed.getId(), 2).toString());
            }
        }
    }
}
