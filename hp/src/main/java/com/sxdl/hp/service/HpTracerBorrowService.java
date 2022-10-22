package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpTracerBorrow;
import com.sxdl.hp.entity.HpTracerBorrowLog;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import com.sxdl.hp.util.PoiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
@Transactional
public class HpTracerBorrowService extends BaseUUIDServiceImpl<HpTracerBorrow> {

    @Autowired
    HpTracerBorrowLogService hpTracerBorrowLogService;

    String getMinLogTime = "select min(optime) mytime from hp_tracer_borrow_log a where pre_status='1' and current_status='2' and bah='@@@@'";
    String getMaxLogTime = "select max(optime) mytime from hp_tracer_borrow_log a where pre_status='2' and current_status='0' and bah='@@@@'";
    @Autowired
    HpKsService hpKsService;

    /**
     * 查询在档的病案数据
     *
     * @param p     分页
     * @param start 开始时间
     * @param end   结束时间
     * @param ks    科室代码
     * @param ys    住院医师代码
     * @param bah   病案号
     * @param btxm  条形码
     * @param bxm   病人姓名
     */
    public PageInfo<HpTracerBorrow> findOn(PageInfo p, String start, String end, String ks, String ys, String bah, String btxm, String bxm)  {
        String sqlleft = "select \n" +
                "'' as id,'' as borrower_id,'' as borrower_name,'' as borrower_ks_id,'' as borrower_ks_name,'' as borrower_title_level,'' as borrower_used,'' as start,'' as [end],'' as scope,'' as status,\n" +
                "a.CH0A01 as bah,CH0A02 as bxm,CH0A03 as bxb,a.CHYear as byear,m.cyks as bcykb,convert(varchar(10),CH0A27,120) AS bcysj,CH0ABarcode as btxm,m.zyys as bzyys " +
                "from VsCH0A a left join dl_fllow f on a.id=f.A_ID and isnull(f.CH0A01,'')='' LEFT JOIN hp_mid_table m ON a.ch0a01= m.bah\n" +
                "where \na.status>=2 and a.CH0A01 not in (select bah from hp_tracer_borrow where status in('0','1','2') ) ";
        String sql = "select \n" +
                "b.id,borrower_id,   borrower_name ,  borrower_ks_id ,  borrower_ks_name ,  borrower_title_level ,  borrower_used ,  start ,  endtime as [end],   scope ,\tstatus,  \n" +
                "bah,   bxm ,  bxb ,  byear ,  bcykb ,  bcysj ,  btxm ,bzyys\n" +
                "from hp_tracer_borrow b left join sys_ks ks on b.bcykb=ks.name\n" +
                "where \nb.status =0  ";
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            sqlleft += " and convert(varchar(10),CH0A27,120) between '" + start + "' and '" + end + "' ";
            sql += " and bcysj between '" + start + "' and '" + end + "' ";
        }
        if (StrUtil.isNotEmpty(ks)) {
            sqlleft += " and ch0a23='" + ks + "' ";
            sql += " and ks.code ='" + ks + "' ";
        }
        if (StrUtil.isNotEmpty(ys)) {
            sqlleft += " and a.CH0A34='" + ys + "' ";
            sql += " and bzyys ='" + ys + "' ";
        }
        if (StrUtil.isNotEmpty(bah)) {
            sqlleft += " and a.ch0a01 LIKE '%" + bah + "%' ";
            sql += " and bah LIKE '%" + bah + "%' ";
        }
        if (StrUtil.isNotEmpty(btxm)) {
            sqlleft += " and CH0ABarcode='" + btxm + "' ";
            sql += " and btxm ='" + btxm + "' ";
        }
        if (StrUtil.isNotEmpty(bxm)) {
            sqlleft += " and CH0A02='" + bxm + "' ";
            sql += " and bxm ='" + bxm + "' ";
        }
        StringBuilder sb = new StringBuilder("from (" + sqlleft);
        sb.append("\nUNION\n").append(sql).append(") t");
        return selectPageinfoWithSQL(HpTracerBorrow.class, " * ", sb.toString().replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()), " bah ", p, true);
    }

    /**
     * 查询待归还的列表
     *
     * @param p                  分页
     * @param start              借阅开始时间
     * @param end                借阅结束时间
     * @param borrowerKs         借阅人ks
     * @param borrowerId         借阅人id
     * @param borrowerTitleLevel 借阅人职级
     * @param bah                病案号
     * @param btxm               病案条形码
     * @param bxm                病人姓名
     */
    public PageInfo<HpTracerBorrow> findBack(PageInfo p, String start, String end, String borrowerKs, String borrowerId, String borrowerTitleLevel, String bah, String btxm, String bxm)  {
        return findByConditions(p, start, end, borrowerKs, borrowerId, borrowerTitleLevel, bah, btxm, bxm, "'1'");
    }

    /**
     * 查询已经挂失的列表
     *
     * @param p                  分页
     * @param start              借阅开始时间
     * @param end                借阅结束时间
     * @param borrowerKs         借阅人ks
     * @param borrowerId         借阅人id
     * @param borrowerTitleLevel 借阅人职级
     * @param bah                病案号
     * @param btxm               病案条形码
     * @param bxm                病人姓名
     */
    public PageInfo<HpTracerBorrow> findLost(PageInfo p, String start, String end, String borrowerKs, String borrowerId, String borrowerTitleLevel, String bah, String btxm, String bxm)  {
        return findByConditions(p, start, end, borrowerKs, borrowerId, borrowerTitleLevel, bah, btxm, bxm, "'2'");
    }

    /**
     * 通用查询借阅信息功能
     *
     * @param p                  分页
     * @param start              借阅开始时间
     * @param end                借阅结束时间
     * @param borrowerKs         借阅人ks
     * @param borrowerId         借阅人id
     * @param borrowerTitleLevel 借阅人职级
     * @param bah                病案号
     * @param btxm               病案条形码
     * @param bxm                病人姓名
     * @param status             状态
     */
    public PageInfo<HpTracerBorrow> findByConditions(PageInfo p, String start, String end, String borrowerKs, String borrowerId, String borrowerTitleLevel, String bah, String btxm, String bxm, String status)  {
        String sql = " from hp_tracer_borrow where 1=1 ";
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            sql += " and start between '" + start + "' and '" + end + "' ";
        }
        if (StrUtil.isNotEmpty(borrowerKs)) {
            sql += " and borrower_ks_id ='" + borrowerKs + "' ";
        }
        if (StrUtil.isNotEmpty(borrowerTitleLevel)) {
            sql += " and borrower_title_level ='" + borrowerTitleLevel + "' ";
        }
        if (StrUtil.isNotEmpty(borrowerId)) {
            sql += " and borrower_name ='" + borrowerId + "' ";
        }
        if (StrUtil.isNotEmpty(bah)) {
            sql += " and bah LIKE '%" + bah + "%' ";
        }
        if (StrUtil.isNotEmpty(btxm)) {
            sql += " and btxm ='" + btxm + "' ";
        }
        if (StrUtil.isNotEmpty(bxm)) {
            sql += " and bxm ='" + bxm + "' ";
        }
        if (StrUtil.isNotEmpty(status)) {
            sql += " and status in (" + status + ") ";
        }
        return selectPageinfoWithSQL(HpTracerBorrow.class, " * ", sql, " bah ", p, true);
    }

    /**
     * 保存借阅信息
     */
    public void saveAll(ArrayList<HpTracerBorrow> tracerBorrows)  {
        saveAllByStatus(tracerBorrows, "0", "1");
    }

    /**
     * 保存归还信息
     */
    public void saveAllBack(ArrayList<HpTracerBorrow> tracerBorrows)  {
        saveAllByStatus(tracerBorrows, "1", "0");
    }

    /**
     * 保存挂失信息
     */
    public void saveAllLost(ArrayList<HpTracerBorrow> tracerBorrows)  {
        saveAllByStatus(tracerBorrows, "1", "2");
    }

    /**
     * 保存寻回信息
     */
    public void saveAllLookingForBack(ArrayList<HpTracerBorrow> tracerBorrows)  {
        saveAllByStatus(tracerBorrows, "2", "0");
    }

    /**
     * 通用保存功能
     *
     * @param tracerBorrows 待保存列表
     * @param pre           变更前状态
     * @param now           变更后状态
     */
    public ResultUtil saveAllByStatus(ArrayList<HpTracerBorrow> tracerBorrows, String pre, String now)  {
        Map<String, String> kss = hpKsService.findMapKs(0, null);
        HpTracerBorrowLog tbLog;
        Map<String, Object> maps;
        String end, bah, nowtime = DateUtil.now();
        Date min = null, max = null, nowtimeDate = DateUtil.parse(nowtime), endDate;
        for (HpTracerBorrow tb : tracerBorrows) {
            bah = tb.getBah();
            //后台计算截止归还日期
            end = DateUtil.offsetDay(DateUtil.parse(tb.getStart()), NumberUtil.parseInt(tb.getScope())).toDateStr();
            if (!"2".equals(now) && !"0".equals(pre)) {//只有寻回操作可以正常执行,必定是丢失的
                endDate = DateUtil.parse(end);
                maps = selectSqlWithSQL(getMaxLogTime.replace("@@@@", bah)).get(0);//先查是否寻回
                if (CollUtil.isNotEmpty(maps)) {
                    max = DateUtil.parse(maps.get("mytime").toString());
                }
                maps = selectSqlWithSQL(getMinLogTime.replace("@@@@", bah)).get(0);//再查是否丢失
                if (CollUtil.isNotEmpty(maps)) {
                    min = DateUtil.parse(maps.get("mytime").toString());
                }
                if (null != max && null != min) {//已经发生过一次丢失且寻回操作
                    if (DateUtil.isIn(nowtimeDate, min, max) || DateUtil.isIn(endDate, min, max) || DateUtil.isIn(min, nowtimeDate, endDate) || DateUtil.isIn(max, nowtimeDate, endDate)) {
                        ResultUtil.error("病案号为:" + bah + " 的数据已经在 (" + min + " 至 " + max + ")内丢失,期间不可操作!");
                    }
                } else if (null != min) {
                    ResultUtil.error("病案号为:" + bah + " 的数据已经在 (" + min + ")丢失,任何期间不可操作,或联系管理员查看! ");
                }
            }
            tb.setEnd(end);
            tb.setStatus(now);
            if (kss.containsKey(tb.getBcykb())) {
                tb.setBcykb(kss.get(tb.getBcykb()) + "");
            }
            if (StrUtil.isEmpty(tb.getId())) {//判断借阅表中是否有数据
                tb.setId(null);
                insert(tb);
            } else {
                update(tb);
            }
            tbLog = HpTracerBorrowLog.builder()//装载数据
                    .borrowerId(tb.getBorrowerId()).borrowerName(tb.getBorrowerName()).borrowerKsName(tb.getBorrowerKsName()).borrowerKsId(tb.getBorrowerKsId())
                    .borrowerUsed(tb.getBorrowerUsed()).borrowerTitleLevel(tb.getBorrowerTitleLevel())
                    .start(tb.getStart()).scope(tb.getScope()).end(end)
                    .bah(bah).bxm(tb.getBxm()).byear(tb.getByear()).bxb(tb.getBxb())
                    .bcykb(tb.getBcykb()).bcysj(tb.getBcysj()).btxm(tb.getBtxm()).bzyys(tb.getBzyys())
                    .preStatus(pre).currentStatus(now).remark(tb.getRemark()).optime(nowtime)
                    .build();
            hpTracerBorrowLogService.insert(tbLog);
        }
        return ResultUtil.success("保存成功!");
    }

    public List<Map<String, Object>> findAllKs()  {
        return hpKsService.findKsByType(0, "code,code+dbo.getpym(name)+name cxtj");
    }

    /**
     * 查询所有历史记录
     *
     * @param p        分页
     * @param startBor 借阅开始时间的开始时间段
     * @param endBor   借阅开始时间的结束时间段
     * @param startCy  病人出院时间的开始时间段
     * @param endCy    病人出院时间的结束时间段
     * @param ksBor    借阅人科室
     * @param bks      病人科室
     * @param bah      病案号
     * @param txm      病人条形码
     * @param bxm      病人姓名
     * @param xm       借阅人姓名
     * @param status   状态,99全部,1已借阅;2已归还;3已挂失;4已寻回
     */
    public ResultUtil findHistory(PageInfo p, String startBor, String endBor, String startCy, String endCy, String ksBor, String bks, String bah, String txm, String bxm, String status, String xm)  {
        String colsql = " start ,borrower_name ,borrower_ks_name ,\n" +
                "case borrower_used when 0 then '临床' when 1 then '教学' when 2 then '科研' when 3 then '司法' when 4 then '医患纠纷' when 5 then '医护检查' when  6 then '院外展评' when  9 then '其他' else '未知' end borrower_used\n" +
                ",bah,bxm,case bxb when 1 then '男' when 2 then '女' else '未知' end bxb,bcykb,bcysj,bzyys,optime,remark," +
                "case pre_status when 0 then '在档' when 1 then '借出' when 2 then '挂失' when 3 then '寻回' else '未知' end pre_status," +
                "case current_status when 0 then '在档' when 1 then '借出' when 2 then '挂失' when 3 then '寻回' else '未知' end current_status";
        String sql = " from hp_tracer_borrow_log where 1=1 ";
        if (StrUtil.isNotEmpty(startBor) && StrUtil.isNotEmpty(endBor)) {
            sql += " and start between '" + startBor + "' and '" + endBor + "' ";
        }
        if (StrUtil.isNotEmpty(startCy) && StrUtil.isNotEmpty(endCy)) {
            sql += " and  bcysj between '" + startCy + "' and '" + endCy + "' ";
        }
        if (StrUtil.isNotEmpty(ksBor)) {
            sql += " and  borrower_ks_name ='" + ksBor + "' ";
        }
        if (StrUtil.isNotEmpty(bks)) {
            sql += " and  bcykb='" + bks + "' ";
        }
        if (StrUtil.isNotEmpty(bah)) {
            sql += " and bah like '%" + bah + "%' ";
        }
        if (StrUtil.isNotEmpty(txm)) {
            sql += " and txm='" + txm + "'";
        }
        if (StrUtil.isNotEmpty(bxm)) {
            sql += " and bxm like '%" + bxm + "%'";
        }
        if (StrUtil.isNotEmpty(xm)) {
            sql += " and borrower_name like '%" + xm + "%'";
        }
        if (StrUtil.isNotEmpty(status) && !"99".equals(status)) {
            //状态,1已借阅;2已归还;3已挂失;4已寻回
            if ("1".equals(status)) {
                sql += " and pre_status='0' and current_status='1' ";
            } else if ("2".equals(status)) {
                sql += " and pre_status='1' and current_status='0' ";
            } else if ("3".equals(status)) {
                sql += " and pre_status='1' and current_status='2' ";
            } else if ("4".equals(status)) {
                sql += " and pre_status='2' and current_status='0' ";
            }
        }
        return ResultUtil.success(hpTracerBorrowLogService.selectPageinfoWithSQL(colsql, sql, "endtime", p, true));
    }

    /**
     * 查询需要催还的报表
     *
     * @param startBor 借阅开始时间的开始时间段
     * @param endBor   借阅开始时间的结束时间段
     * @param startCy  病人出院时间的开始时间段
     * @param endCy    病人出院时间的结束时间段
     * @param ksBor    借阅人科室
     * @param bks      病人科室
     */
    public ResultUtil findUrgeToReturn(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks)  {
        return ResultUtil.success(getUrgeToreturnData(startBor, endBor, startCy, endCy, ksBor, bks));
    }

    /**
     * 导出需要催还的报表
     */
    public void downUrgeToReturn(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks, HttpServletResponse response) throws Exception {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("借阅人", "借阅人");
        map.put("借阅日期", "借阅日期");
        map.put("应还日期", "应还日期");
        map.put("超期天数", "超期天数");
        map.put("病案年度", "病案年度");
        map.put("病案号", "病案号");
        map.put("病人姓名", "病人姓名");
        map.put("出院科别", "出院科别");
        map.put("出院时间", "出院时间");
        PoiUtil.createExcel("病案借阅催还单", response, getUrgeToreturnData(startBor, endBor, startCy, endCy, ksBor, bks), map);
    }

    //查询催还列表数据,要查询当前状态的数据,只能查借阅表,不能查日志表
    List<Map<String, Object>> getUrgeToreturnData(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks) {
        String sql = "select borrower_name 借阅人,start 借阅日期,endtime 应还日期,DATEDIFF(day,CONVERT(datetime,start,120),GETDATE())-scope 超期天数,byear 病案年度,bah 病案号,bxm 病人姓名,bcykb 出院科别,bcysj 出院时间 " +
                "from hp_tracer_borrow log where CONVERT(char(10),GETDATE(),120)>=endtime and status='1' ";
        if (StrUtil.isNotEmpty(startBor) && StrUtil.isNotEmpty(endBor)) {
            sql += " and start between '" + startBor + "' and '" + endBor + "' ";
        }
        if (StrUtil.isNotEmpty(startCy) && StrUtil.isNotEmpty(endCy)) {
            sql += " and  bcysj between '" + startCy + "' and '" + endCy + "' ";
        }
        if (StrUtil.isNotEmpty(ksBor)) {
            sql += " and  borrower_ks_name ='" + ksBor + "' ";
        }
        if (StrUtil.isNotEmpty(bks)) {
            sql += " and  bcykb='" + bks + "' ";
        }
        return selectSqlWithSQL(sql);
    }

    /**
     * 查询报表数据
     */
    public ResultUtil findReport(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks)  {
        return ResultUtil.success(getReportData(startBor, endBor, startCy, endCy, ksBor, bks));
    }

    /**
     * 导出报表数据
     */
    public void downReport(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks, HttpServletResponse response) throws Exception {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("科室", "科室");
        map.put("姓名", "姓名");
        map.put("已借阅(份)", "已借阅(份)");
        map.put("已归还(份)", "已归还(份)");
        map.put("已挂失(份)", "已挂失(份)");
        map.put("已寻回(份)", "已寻回(份)");
        PoiUtil.createExcel("病案借阅统计汇总表", response, getReportData(startBor, endBor, startCy, endCy, ksBor, bks), map);
    }

    //查询借阅历史数据报表数据
    List<Map<String, Object>> getReportData(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks) {
        String sql = "select borrower_ks_name 科室,borrower_name 姓名,\n" +
                "sum(case when pre_status='0' and current_status='1' then 1 else 0 end) [已借阅(份)],\n" +
                "sum(case when pre_status='1' and current_status='0' then 1 else 0 end) [已归还(份)],\n" +
                "sum(case when pre_status='1' and current_status='2' then 1 else 0 end) [已挂失(份)],\n" +
                "sum(case when pre_status='2' and current_status='0' then 1 else 0 end) [已寻回(份)] " +
                " from hp_tracer_borrow_log where 1=1 ";
        String groupsql = " GROUP BY borrower_ks_name,borrower_name with rollup order by borrower_ks_name desc,borrower_name desc";
        if (StrUtil.isNotEmpty(startBor) && StrUtil.isNotEmpty(endBor)) {
            sql += " and start between '" + startBor + "' and '" + endBor + "' ";
        }
        if (StrUtil.isNotEmpty(startCy) && StrUtil.isNotEmpty(endCy)) {
            sql += " and  bcysj between '" + startCy + "' and '" + endCy + "' ";
        }
        if (StrUtil.isNotEmpty(ksBor)) {
            sql += " and  borrower_ks_name ='" + ksBor + "' ";
        }
        if (StrUtil.isNotEmpty(bks)) {
            sql += " and  bcykb='" + bks + "' ";
        }
        List<Map<String, Object>> maps = selectSqlWithSQL(sql + groupsql);
        for (Map m : maps) {
            if (null == m.get("科室")) {
                m.put("科室", "总计");
            }
            if (null == m.get("姓名")) {
                m.put("姓名", "小计");
            }
        }
        return maps;
    }
}

