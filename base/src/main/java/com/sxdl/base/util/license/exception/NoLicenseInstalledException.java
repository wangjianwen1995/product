package com.sxdl.base.util.license.exception;

import com.sxdl.base.util.license.util.ObfuscatedString;
import com.sxdl.base.util.license.util.Resources;

public class NoLicenseInstalledException extends Exception {
	private static final String EXC_NO_LICENSE_INSTALLED = new ObfuscatedString(
			new long[] { 5636850220590995934L, -798521115123526970L, 3054112192777193179L, 881750348384376277L })
					.toString();

	public NoLicenseInstalledException(String paramString) {
		super(paramString);
	}

	public String getLocalizedMessage() {
		return Resources.getString(EXC_NO_LICENSE_INSTALLED, super.getMessage());
	}
}
