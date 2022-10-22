package com.sxdl.hp.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpRzOldGcs;
import com.sxdl.hp.service.HpRzOldGcsServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rzgcsold")
public class HpRzOldGcsController {

    @Autowired
    HpRzOldGcsServcie hpRzOldGcsServcie;

    @GetMapping("gcsks")
    public ResultUtil getGcsks() throws Exception {
        return hpRzOldGcsServcie.getGcsks();
    }

    @GetMapping("list")
    public ResultUtil getlist(String date) throws Exception {
        return hpRzOldGcsServcie.getlist(date);
    }

    @PostMapping("save")
    public ResultUtil insertOrUpdateList(@RequestBody List<HpRzOldGcs> list,String time) throws Exception {
        return hpRzOldGcsServcie.saveAll(list,time);
    }

}
