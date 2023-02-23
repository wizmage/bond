package net.kepco.srm.framework.exception;

import net.kepco.srm.framework.BondErrorCode;

public class BondDefaultErrorCode implements BondErrorCode {

	private int code;
	private String message;
	
	public BondDefaultErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
