package com.sxdl.sd.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.sd.SdMainTest;
import com.sxdl.sd.entity.SdPatientVal;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class SdPatientValControllerTest extends SdMainTest {

  @Test
    public void insert() throws Exception {
        List<SdPatientVal> list = new ArrayList<> ();
        SdPatientVal sdPatientVal1 = new SdPatientVal ();
        SdPatientVal sdPatientVal2 = new SdPatientVal ();
        SdPatientVal sdPatientVal3 = new SdPatientVal ();
        sdPatientVal1.setSd_info_id ( 1 );
        sdPatientVal2.setSd_info_id ( 1 );
        sdPatientVal3.setSd_info_id ( 1 );
        sdPatientVal1.setSd_info_column_name ( "STEMI_1_3_2_2" );
        sdPatientVal2.setSd_info_column_name ( "STEMI_1_3_2_3" );
        sdPatientVal3.setSd_info_column_name ( "STEMI_1_3_2_4" );
        sdPatientVal1.setSd_patient_id ( 1 );
        sdPatientVal2.setSd_patient_id ( 1 );
        sdPatientVal3.setSd_patient_id ( 1 );
        sdPatientVal1.setVal ( "0.61" );
        sdPatientVal2.setVal ( "1.41" );
        sdPatientVal3.setVal ( "2.51" );
        list.add ( sdPatientVal1 );
        list.add ( sdPatientVal2 );
        list.add ( sdPatientVal3);

        mockMvc.perform ( MockMvcRequestBuilders.post ( "/psv/save" )
                .content ( JSONUtil.toJsonStr ( list ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }
}