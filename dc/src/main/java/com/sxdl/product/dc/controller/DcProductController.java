package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.service.DcProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "产品信息")
@RestController
@RequestMapping("/product")
public class DcProductController {

    @Autowired
    private DcProductService dcProductService;

    List<DcProduct> products;

    //查询所有医院
    @ApiOperation(value = "查询", notes = "查询产品所有信息")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DcProduct>> findAll(PageInfo pageInfo) {
        try {
            DcProduct product = new DcProduct();
            product.setStatus(1);//状态0为未启用，1为启用
            PageInfo<DcProduct> list = dcProductService.queryPageList(pageInfo, product);
            return ResultUtil.success(list);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    @ApiOperation(value = "查询", notes = "查询正在实施的自己的产品")
    @GetMapping("/findOwn")
    public ResultUtil<List<DcProduct>> findOwn() {
        try {
            DcProduct product = new DcProduct();
            product.setStatus(1);//状态0为未启用，1为启用
            product.setIsown(1);
            product.setIsdeploy(1);
            List<DcProduct> list = dcProductService.select(product);
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //根据name模糊查询信息
    @ApiOperation(value = "根据name查询", notes = "根据产品名称查询")
    @GetMapping("/findByName")
    public ResultUtil findByName(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            DcProduct product = new DcProduct();
            product.setShort_name(name);
            return ResultUtil.success(dcProductService.queryPageList(pageInfo, product));
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //根据name模糊查询信息
    @ApiOperation(value = "根据name模糊查询", notes = "根据产品名称模糊查询")
    @GetMapping("/findByLikeName")
    public ResultUtil findByLikeName(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            DcProduct product = new DcProduct();
            product.setName(name);
            List<DcProduct> list = dcProductService.selectByExample(product);
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(list);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    //根据类型（ETLP）查询产品
    @ApiOperation(value = "根据类型（ETLP）查询产品", notes = "根据类型（ETLP）查询产品")
    @GetMapping("/findByType")
    public ResultUtil findByType(@RequestParam(value = "type", defaultValue = "") String type) {
        try {
            DcProduct product = new DcProduct();
            product.setStatus(1);//状态0为未启用，1为启用

            if("2".equals(type)){//类型是TL 查询DC
                product.setShort_name("dc");
            }else if("3".equals(type)){//类型是L 查询我们自己的产品
                //product.setIsown(1);
                product.setShort_name("dc");
            }
            List<DcProduct> select = dcProductService.select(product);
            if("1".equals(type)){//类型是E 排除DC
                select=select.stream().filter(e -> null!=e && !e.getShort_name().contains("dc")).collect(Collectors.toList());
            }
            return ResultUtil.success(select);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //根据name模糊查询信息
    @ApiOperation(value = "根据产品id查询", notes = "根据产品id查询")
    @GetMapping("/findByProductId")
    public ResultUtil findByProductId(@RequestParam(value = "id", defaultValue = "") String id,String type) {
        try {
            List<DcProduct> productList = new ArrayList<>();
            DcProduct dcProduct = new DcProduct();
            dcProduct.setStatus(1);//状态0为未启用，1为启用
            DcProduct byId = dcProductService.findById(id);
            if ("dc".equals(byId.getShort_name())) {
                //from 是dc to 要排除his项目
                if("2".equals(type)){
                    //如果from是dc 而且类型是清晰转化，只能是dc到dc
                    dcProduct.setShort_name("dc");
                }
                productList = dcProductService.select(dcProduct);
                productList = productList.stream().filter(e -> null != e && !e.getShort_name().contains("his")).collect(Collectors.toList());
            } else if("5".equals(type)){
                productList = dcProductService.select(dcProduct);
            } else {
                //from 不是dc to 只能是dc
                dcProduct.setShort_name("dc");
                productList = dcProductService.select(dcProduct);
            }
            return ResultUtil.success(productList);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    //根据name模糊查询信息 yid 源产品  mid 目标产品
    @ApiOperation(value = "根据产品id查询", notes = "根据产品id查询需要的id")
    @GetMapping("/findIdByProductId")
    public ResultUtil findIdByProductId(@RequestParam(value = "yid", defaultValue = "") String yid,@RequestParam(value = "mid", defaultValue = "") String mid) {
        try {
            DcProduct dcProduct = new DcProduct();
            dcProduct.setStatus(1);//状态0为未启用，1为启用
            DcProduct yId = dcProductService.findById(yid);
            DcProduct mId = dcProductService.findById(mid);
            String returnId="";
            if ("dc".equals(yId.getShort_name())) {
                //from 是dc to 要排除his项目
              returnId=mid;
            } else if("dc".equals(mId.getShort_name())){
               returnId=yid;
            } else {
                returnId=yid;
            }
            return  ResultUtil.success(returnId) ;
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    //删除医院信息
    @ApiOperation(value = "删除", notes = "删除产品信息")
    @DeleteMapping("/delete")
    public ResultUtil<DcProduct> delete(@RequestBody DcProduct dcProduct) {
        try {
            dcProductService.delete(dcProduct);
            return ResultUtil.success("删除产品成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增", notes = "添加产品信息")
    @PostMapping("/insert")
    public ResultUtil<DcProduct> insertProduct(@RequestBody DcProduct dcProduct) {
        try {
            String prefix="dc_create_"+dcProduct.getShort_name();
            dcProduct.setPrefix(prefix);
            dcProductService.insert(dcProduct);
            return ResultUtil.success("添加产品成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "修改", notes = "修改产品信息")
    @PutMapping("/update")
    public ResultUtil<DcProduct> updateProduct(@RequestBody DcProduct dcProduct) {
        try {
            String prefix="dc_create_"+dcProduct.getShort_name();
            dcProduct.setPrefix(prefix);
            dcProductService.update(dcProduct);
            return ResultUtil.success("修改产品成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }
}
