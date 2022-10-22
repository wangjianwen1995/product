package com.sxdl.hp.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpRzOldMz;
import com.sxdl.hp.service.HpRzOldMzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rzmzold")
public class HpRzOldMzController {

    @Autowired
    HpRzOldMzService hpRzMzOldService;

    @GetMapping("list")
    public ResultUtil getlist(String date) throws Exception {
        return hpRzMzOldService.getlist(date);
    }

    @PostMapping("save")
    public ResultUtil insertOrUpdateList(@RequestBody List<HpRzOldMz> list,String time) throws Exception {
        return hpRzMzOldService.saveAll(list,time);
    }

}
