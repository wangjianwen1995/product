package com.sxdl.base.util.license.util;

import java.rmi.Remote;

public abstract interface LicenseVerifier
  extends Remote
{
  public abstract LicenseContent verify(byte[] paramArrayOfByte)
    throws Exception;
}
