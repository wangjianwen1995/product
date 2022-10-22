package com.sxdl.base.util.license;

import com.sxdl.base.util.license.util.LicenseManager;
import com.sxdl.base.util.license.util.LicenseParam;

/**
 * LicenseManager
 */
public class LicenseManagerHolder {
	
	private static LicenseManager licenseManager;
 
	public static synchronized LicenseManager getLicenseManager(LicenseParam licenseParams) {
    	if (licenseManager == null) {
    		licenseManager = new LicenseManager(licenseParams);
    	}
    	return licenseManager;
    }
}