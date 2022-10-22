package com.sxdl.fm.util.scheduled;

import com.sxdl.fm.controller.AppFrontController;
import com.sxdl.fm.service.FmSecondHandlerService;
import org.springframework.beans.factory.annotation.Autowired;

//@Component(value = "dataTask")
public class MyDLongTask {

    @Autowired
    FmSecondHandlerService fmSecondHandlerService;
    @Autowired
    AppFrontController appFrontController;

//    public void everyDay() {
//        fmHandlerService.findDay();
//    }
//
//    public void everyWeek() {
//        fmHandlerService.findWeek();
//    }

    public void doTask() {
        appFrontController.save ();
    }

}
