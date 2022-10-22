package com.sxdl.hn;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class HnMainTest {

    @Autowired
    WebApplicationContext wac; // 公共容器，存放公共信息

    public MockMvc mockMvc; // 对html请求的模拟，能够直接使用网络的形式，转换到Controller的调用。可以使测试快、不依赖网络环境。

    public static final ResultMatcher OK = status().isOk();
    /**
     * is3xxRedirection();
     */
    public static final ResultMatcher XXX = status().is3xxRedirection();
    /**
     * is4xxClientError();
     */
    public static final ResultMatcher XXXX = status().is4xxClientError();
    /**
     * is5xxServerError();
     */
    public static final ResultMatcher XXXXX = status().is5xxServerError();

    public static final MediaType JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8;

    @BeforeEach  // 初始化方法，对于每个测试方法都执行一遍
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

}
