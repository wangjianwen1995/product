package com.sxdl.hp.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.service.HpFileService;
import com.sxdl.hp.service.HpVsch0AService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "节假日")
@RestController
@RequestMapping("/hp_holidays")
public class HpHolidaysController {

    @Autowired
    HpVsch0AService hpVsch0AService;
    @Autowired
    HpFileService hpFileService;

    @ApiOperation(value = "查询")
    @GetMapping("/findHpHolidays")
    public ResultUtil findOneType(String year, String month) throws Exception {
        String sql = "Declare @Y varchar(4), @M varchar(2), @OY varchar(4), @OM varchar(2), @D datetime \n" +
                "Select @Y='" + year + "', @M='" + month + "' \n" +
                "if @M='01'  \n" +
                "Select @OY=convert(int, @Y-1), @OM='12' \n" +
                "else   \n" +
                "Select @OY=@Y, @OM=convert(int, @M-1) \n" +
                "\n" +
                "if Len(@OM)=1   \n" +
                "Set @OM='0'+@OM \n" +
                "Select @D=max(Date) From VsHolidays \n" +
                "Where DATEPART(yyyy,Date) = @OY AND DATEPART(mm,Date) = @OM and week='星期日' \n" +
                "\n" +
                "SELECT \n" +
                "DATEPART(yyyy,Date) AS OrderYear,\n" +
                "DATEPART(mm,Date) AS OrderMonth,\n" +
                "DATEPART(dd,Date) AS OrderDay ,\n" +
                "CONVERT(varchar(100), DATE, 120) DATE,\n" +
                "sfsjjr,\n" +
                "week \n" +
                "\n" +
                "FROM VsHolidays  \n" +
                "\n" +
                "WHERE (DATEPART(yyyy,Date) = @Y \n" +
                "AND DATEPART(mm,Date) = @M) or \n" +
                "(DATEPART(yyyy,Date) = @OY AND DATEPART(mm,Date) = @OM and DATE>=@D) \n" +
                "\n" +
                "Order by DATE";
        List<Map<String, Object>> maps = hpVsch0AService.selectSqlWithSQL(sql);
        return ResultUtil.success(maps);
    }

    @ApiOperation(value = "单独切换某天是否为节假日")
    @GetMapping("/updaHpHolidays")
    public ResultUtil updaHpHolidays(String date) throws Exception {
        String updateSql = "update VsHolidays set sfsjjr =case when sfsjjr=1 then 0 else 1 end where DATE='" + date + "'";
        hpVsch0AService.updateSqlWithSQL(updateSql);
        hpFileService.updateMidFIledayAfterChangeWeekend(date);
        return ResultUtil.success("成功");
    }

    @ApiOperation(value = "切换节假日单休双休")
    @GetMapping("/changeWeekend")
    public ResultUtil changeWeekend(String status) throws Exception {
        String updateSql = "";
        if ("1".equals(status)) {//单休
            updateSql = "update VsHolidays set sfsjjr =0 where week like '%六%';update VsHolidays set sfsjjr =1 where week like '%日%'";
        } else if("0".equals(status)) {//无休
            updateSql = "update VsHolidays set sfsjjr =0 where week like '%日%' or week like '%六%'";
        } else {//双休
            updateSql = "update VsHolidays set sfsjjr =1 where week like '%日%' or week like '%六%' ";
        }
        hpVsch0AService.updateSqlWithSQL(updateSql);
        hpFileService.updateMidFIledayAfterChangeWeekend("");
        return ResultUtil.success("成功");
    }


}
