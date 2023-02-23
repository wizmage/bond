package net.kepco.srm.framework;

public enum DmainErrorCode implements BondErrorCode {
	
	SUCESS(2000 , "response.success"),
	
	BUSINESS_ERROR(5100 , "response.success"),
	VALIDATION_ERROR(5200 , "response.success"),
	
	FAIL(5000 , "response.success"),
	

	FAIL_SAVE_FILE(1000, ""),
	FAIL_DELETE_FILE(1000, ""),
	
	INFO_NODATA(1001, "info.nodata.msg"),
	;
	
	private int code;
	private String message;
	
	DmainErrorCode(int code, String message) {
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
