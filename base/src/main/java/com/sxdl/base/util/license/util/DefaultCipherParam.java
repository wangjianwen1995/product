package com.sxdl.base.util.license.util;

public class DefaultCipherParam implements CipherParam {
	private final String keyPwd;

	public DefaultCipherParam(String paramString) {
		this.keyPwd = paramString;
	}

	public String getKeyPwd() {
		return this.keyPwd;
	}
}
