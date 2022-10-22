package com.sxdl.base.controller;


import com.sxdl.base.service.ServiceDiskService;
import com.sxdl.base.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/db")
public class BackupsController {

    @Autowired
    ServiceDiskService serviceDiskService;

    @RequestMapping(value = "/backUp")
    @ResponseBody
    public ResultUtil backUp() {
        try {
            serviceDiskService.backUp();
            return ResultUtil.success("备份成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }
}

