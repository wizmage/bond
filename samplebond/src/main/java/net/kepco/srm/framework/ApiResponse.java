package net.kepco.srm.framework;

import org.apache.commons.lang3.StringUtils;

public class ApiResponse {

	private int code;
	private String message;
	private Object data;
	
	public ApiResponse(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public static ApiResponse ok() {
		return ok(StringUtils.EMPTY);
	}
	
	public static ApiResponse ok(Object data) {
		return new ApiResponse(DmainErrorCode.SUCESS.getCode(), DmainErrorCode.SUCESS.getMessage(), data);
	}
	
	public static ApiResponse fail() {
		return new ApiResponse(DmainErrorCode.FAIL.getCode(), DmainErrorCode.FAIL.getMessage(), "");
	}
	
	public static ApiResponse error(BondErrorCode bondErrorCode) {
		return new ApiResponse(bondErrorCode.getCode(), bondErrorCode.getMessage(), "");
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Object getData() {
		return data;
	}
}
