package com.sxdl.hpqc.util.verify;

import cn.hutool.json.JSONObject;
import com.sxdl.base.util.verify.VerifyUtil;

public class HpVerify extends VerifyUtil {

    private static HpVerify hpVerify = new HpVerify();

    public static HpVerify builder() {
        return hpVerify;
    }

    public JSONObject isVerify(JSONObject j) {
        if(null==j) return null;
        if (null == j.get("level")) return null;
        if (!"1,2,3,4".contains(j.getStr("level"))) return null;
        if (null == j.get("hasLinking")) {
            j.putOpt("hasLinking", 1);
            return j;
        }
        if (!"1,2".contains(j.getStr("hasLinking"))) return null;
        else return j;
    }
}
