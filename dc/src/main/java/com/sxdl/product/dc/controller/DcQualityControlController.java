package com.sxdl.product.dc.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcDataQualityControl;
import com.sxdl.product.dc.entity.DcOverallQualityControl;
import com.sxdl.product.dc.entity.DcTable;
import com.sxdl.product.dc.entity.DcWarning;
import com.sxdl.product.dc.service.DcDataQualityControlService;
import com.sxdl.product.dc.service.DcOverallQualityControlService;
import com.sxdl.product.dc.service.DcWarningService;
import com.sxdl.product.dc.service.impl.DcTableServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "质控动作")
@RestController
@RequestMapping("/qualityControl")
public class DcQualityControlController {

    @Autowired
    private DcDataQualityControlService dcDataQualityControlService;

    @Autowired
    private DcOverallQualityControlService dcOverallQualityControlService;

    @Autowired
    private DcTableServiceImpl tableService;

    @Autowired
    private HandleDao handleDao;

    @Autowired
    private DcWarningService dcWarningService;


    @ApiOperation(value = "质控", notes = "质控")
    @GetMapping("/qc")
    public ResultUtil  qualityControl() {
        try {
            //------质控开始--------
            String qcsql;
            //首先查询数据表中需要质控的所有表
            DcTable table = new DcTable();
            table.setIs_qc(1);
            List<DcTable> list = tableService.select(table);

            DcWarning dw = new DcWarning();

            //循环需要质控的表，查询各个表的整体质控条件和数据质控条件
            for (DcTable dcTable : list) {
                List<DcOverallQualityControl> doqc = dcOverallQualityControlService.findByTableId(dcTable.getId());
                String collect = doqc.stream().map(e ->{
                    if(1==e.getQc_type()){//上限
                        return "case  when "+e.getTarget()+" > " +e.getMax_value()+
                                "  then "+e.getTarget()+" else -99999999 end as "+e.getMc();
                    }else if(2==e.getQc_type()){//下限
                        return "case  when "+e.getTarget()+" < " +e.getMin_value()+
                                " then "+e.getTarget()+" else -99999999 end as "+e.getMc();
                    }else{//范围
                        return "case  when "+e.getTarget()+" between " +e.getMin_value()+
                                " and "+e.getMax_value()+" then "+e.getTarget()+" else -99999999 end as "+e.getMc();
                    }

                }).collect(Collectors.joining(","));

                //如果当前表没有维护质控条件，则进行下一个表的质控
                if(StringUtil.isEmpty(collect)) continue;


                //根据质控单位进行拼接时间范围参数 //TODO 质控单位，
                qcsql="select "+collect+" from "+dcTable.getName();

                System.out.println(qcsql);
                List<Map<String, Object>> maps = handleDao.selectSqlWithSQL(qcsql);
                if(CollUtil.isNotEmpty(maps.get(0))){
                    for (String s : maps.get(0).keySet()) {
                        if (Integer.parseInt(maps.get(0).get(s).toString())!=-99999999) {
                            //保存预警信息
                            dw.setProduct_id(dcTable.getProduct_id());
                            dw.setExec_name(dcTable.getName_zh());
                            dw.setType(4);
                            dw.setWarnreason("指标预警");
                            dw.setEtltime(DateUtil.format(new Date(), "yyyy-MM-dd"));
                            dw.setWarnmessage(dcTable.getName_zh()+"表中指标【"+s+"】值【"+maps.get(0).get(s).toString()+"】超过预警值");
                            dcWarningService.insert(dw);
                        };
                    }
                };

                List<DcDataQualityControl> ddqc = dcDataQualityControlService.findByTableId(dcTable.getId());
            }


            return ResultUtil.success("质控完成");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    public static void main(String[] args) {
        System.out.println();

    }






}
