package com.sxdl.product.dc.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcVirtualTable;
import com.sxdl.product.dc.service.DcVirtualTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "存储过程")
@RestController
@RequestMapping("/dcVirtualTable")
public class DcVirtualTableController {
    @Autowired
    private DcVirtualTableService dcVirtualTableService;

    @Autowired
    private HandleDao handleDao;

    private PageInfo<DcVirtualTable> dcVirtualTablePageInfo;
    @ApiOperation(value="直连存储",notes="获取所有直连库存储过程")
    @GetMapping("/findAll")
    @ResponseBody
    public ResultUtil findAll(PageInfo<DcVirtualTable> pageInfo) {
        try{
            dcVirtualTablePageInfo= dcVirtualTableService.queryPageList(pageInfo, new DcVirtualTable());
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }
        ResultUtil<PageInfo<DcVirtualTable>> success = ResultUtil.success(dcVirtualTablePageInfo);
        return success ;
    }



    @ApiOperation(value="修改",notes="修改数据")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtil update(@RequestBody DcVirtualTable dcVirtualTable ){
        try{
            dcVirtualTableService.update(dcVirtualTable);
        }catch (Exception e){
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("修改成功");
    }

}
