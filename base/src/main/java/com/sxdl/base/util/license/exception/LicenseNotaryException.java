package com.sxdl.base.util.license.exception;

import com.sxdl.base.util.license.util.Resources;

import java.security.GeneralSecurityException;

public class LicenseNotaryException extends GeneralSecurityException {
	private String alias;

	public LicenseNotaryException(String paramString1, String paramString2) {
		super(paramString1);
		this.alias = paramString2;
	}

	public String getLocalizedMessage() {
		return Resources.getString(super.getMessage(), this.alias);
	}
}
