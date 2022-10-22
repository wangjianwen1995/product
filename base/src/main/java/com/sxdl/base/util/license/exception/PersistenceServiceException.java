package com.sxdl.base.util.license.exception;

public class PersistenceServiceException extends Exception {
	public PersistenceServiceException(Throwable paramThrowable) {
		super(paramThrowable.getLocalizedMessage(), paramThrowable);
	}
}
