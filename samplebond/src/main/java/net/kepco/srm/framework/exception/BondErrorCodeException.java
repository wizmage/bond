package net.kepco.srm.framework.exception;

import net.kepco.srm.framework.BondErrorCode;

public class BondErrorCodeException extends RuntimeException {

	private static final long serialVersionUID = 8710163909163965172L;

	private BondErrorCode errorCode;
	
	public BondErrorCodeException(BondErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
 
	public BondErrorCodeException(BondErrorCode errorCode, Throwable cause) {
		super(errorCode.getMessage(), cause);
		this.errorCode = errorCode;
	}
	
	public BondErrorCodeException(int code, String message) {
		super(message);
		this.errorCode = new BondDefaultErrorCode(code, message);
	}
	
	public BondErrorCodeException(int code, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = new BondDefaultErrorCode(code, message);
	}
	
	public BondErrorCode getErrorCode() {
		return errorCode;
	}	
}
