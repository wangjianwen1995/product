package com.sxdl.performance.util;

import com.sxdl.base.util.ApplicationRunnerImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class PpApplicationRunnerImpl  extends ApplicationRunnerImpl {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        super.init();

    }
}
