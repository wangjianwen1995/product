/*
 * Copyright 2005-2012 Schlichtherle IT Services
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.sxdl.base.util.license.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Looks up the resources for this package in a Resource Bundle. Provided for
 * comfort.
 */
public class Resources {

	private static final String CLASS_NAME = new ObfuscatedString(new long[] { 0x8246C1C2E784F8A9L, 0x2A963FCC670BE6ECL,
			0x29F7E952EDBA28E7L, 0xED1E515A84EC76CAL, 0xA653C1190F34AA13L, 0x629E86F190F9A137L, 0x3C7253003F4DFCCL })
					.toString();

	private static final ResourceBundle resources = ResourceBundle.getBundle(CLASS_NAME);

	/**
	 * Looks up a string resource identified by {@code key} in {@code resources}.
	 */
	public static String getString(String key) {
		return resources.getString(key);
	}

	/**
	 * Looks up a string resource identified by {@code key} in {@code resources} and
	 * formats it as a message using {@code MessageFormat.format} with the given
	 * {@code arguments}.
	 */
	public static String getString(String key, Object[] arguments) {
		return MessageFormat.format(getString(key), arguments);
	}

	/**
	 * Looks up a string resource identified by {@code key} in {@code resources} and
	 * formats it as a message using {@code MessageFormat.format} with the given
	 * singular {@code argument}.
	 */
	public static String getString(String key, Object argument) {
		return MessageFormat.format(getString(key), new Object[] { argument });
	}

	/** You cannot instantiate this class. */
	protected Resources() {
	}

}
