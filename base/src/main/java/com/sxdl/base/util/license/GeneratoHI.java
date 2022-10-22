package com.sxdl.base.util.license;

import com.sxdl.base.util.HardwareInfo;
import com.sxdl.base.util.license.util.ObfuscatedString;

public class GeneratoHI {

    public static void main(String[] args) throws Exception {
        String s = HardwareInfo.getCPUId() + "@" + HardwareInfo.getMAC() + "@"
                + HardwareInfo.getMainBordId();
        String encrypt = ObfuscatedString.encrypt_Base64(s);
        encrypt = ObfuscatedString.encrypt_Base64(encrypt);

        System.out.println(encrypt);
        s = ObfuscatedString.decrypt_Base64(encrypt);
        s = ObfuscatedString.decrypt_Base64(s);
        System.out.println(s);
    }
}
