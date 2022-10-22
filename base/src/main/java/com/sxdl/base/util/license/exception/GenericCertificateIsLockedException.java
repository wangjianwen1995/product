package com.sxdl.base.util.license.exception;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class GenericCertificateIsLockedException
  extends PropertyVetoException
{
  public GenericCertificateIsLockedException(PropertyChangeEvent paramPropertyChangeEvent)
  {
    super(paramPropertyChangeEvent.getPropertyName(), paramPropertyChangeEvent);
  }
}
