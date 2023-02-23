package net.kepco.srm.framework.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import net.kepco.srm.framework.ApiResponse;

@ControllerAdvice
public class BondExceptionHandler  {

	private static final Logger LOGGER = LoggerFactory.getLogger(BondExceptionHandler.class);
	
	@ExceptionHandler(BondErrorCodeException.class)
	public ApiResponse bondErrorCodeExceptionHandler(BondErrorCodeException e) {
		LOGGER.error("exceptionHandler run...", e);
		return ApiResponse.ok();
	}
	
	@ExceptionHandler(Exception.class)
	public ApiResponse exceptionHandler(Exception e) {
		LOGGER.error("exceptionHandler run...", e);
		return ApiResponse.ok();
	}	
}
