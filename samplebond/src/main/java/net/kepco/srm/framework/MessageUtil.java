package net.kepco.srm.framework;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;

public class MessageUtil {

	private static MessageSourceAccessor messageSourceAccessor = null;
	
	public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
		MessageUtil.messageSourceAccessor = messageSourceAccessor;
	}
	
	public static String getMessage(String code) {
		return code;
	}
	
	public static String getMessage(String code, String args[]) {
		return messageSourceAccessor.getMessage(code, args, Locale.getDefault());
	}
}