package com.sxdl.base.util.license.exception;

import com.sxdl.base.util.license.util.Resources;

public class LicenseContentException extends Exception {
	public LicenseContentException(String paramString) {
		super(paramString);
	}

	public String getLocalizedMessage() {
		return Resources.getString(super.getMessage());
	}
}
