package com.sxdl.base.util.license;

import com.sxdl.base.util.license.util.*;

import java.util.prefs.Preferences;

/**
 * VerifyLicense
 */
public class VerifyLicense {
    //common param
    private static final String PUBLICALIAS = "publicCert";
    private static final String STOREPWD = "li815205";
    private static final String SUBJECT = "sxdl";
    private static final String licPath = "D:/cert/license.lic";
    private static final String pubPath = "D:/cert/publicCerts.store";


//	public void setParam(String propertiesPath) throws IOException {
//		// 
//		Properties prop = new Properties();
//		System.out.println("propertiesPath="+propertiesPath);
//		//InputStream in = getClass().getResourceAsStream(propertiesPath);		
//		InputStream in = new FileInputStream(propertiesPath);		
//		prop.load(in);		
//		PUBLICALIAS = prop.getProperty("PUBLICALIAS");
//		STOREPWD = prop.getProperty("STOREPWD");
//		SUBJECT = prop.getProperty("SUBJECT");
//		licPath = prop.getProperty("licPath");
//		pubPath = prop.getProperty("pubPath");
//	}

    //
    private static LicenseParam initLicenseParams() {
        Preferences preference = Preferences
                .userNodeForPackage(VerifyLicense.class);
        CipherParam cipherParam = new DefaultCipherParam(STOREPWD);

        KeyStoreParam privateStoreParam = new DefaultKeyStoreParam(
                VerifyLicense.class, pubPath, PUBLICALIAS, STOREPWD, null);
        LicenseParam licenseParams = new DefaultLicenseParam(SUBJECT,
                preference, privateStoreParam, cipherParam);
        return licenseParams;
    }

    public boolean verify() throws Exception {

        LicenseManager licenseManager = LicenseManagerHolder
                .getLicenseManager(initLicenseParams());
        // install license file
//		try {
//			licenseManager.install(new File(licPath));
//			System.out.println("License file instal successfully!");
//		} catch (Exception e) {
//			//e.printStackTrace();
//			String moreInfo ="License file instal failure";
//			System.out.println(moreInfo);
//			throw e;
//		}
        // verify license file
        try {
            licenseManager.verify();
            System.out.println("License file verify successfully!");
        } catch (Exception e) {
            //e.printStackTrace();
            String moreInfo = "License file verify failure";
            System.out.println(moreInfo);
            throw e;
        }
        return true;
    }
}