package com.sxdl.base.util.license.util;

import java.util.prefs.Preferences;

public abstract interface LicenseParam {
	public abstract String getSubject();

	public abstract Preferences getPreferences();

	public abstract KeyStoreParam getKeyStoreParam();

	public abstract CipherParam getCipherParam();
}
