package com.site.siteweb.helpers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestHeader;

@Configuration
public class MessageHelper {

	@Autowired
	private static MessageSource messageSource;

	public MessageHelper(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	
	public static  String success(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("lang.success", null, locale);
	} 

	public static String createdSuccessfully(Locale locale) {
		return messageSource.getMessage("lang.createdSuccessfully", null, locale);
	}

	public static String internalServer(Locale locale) {
		return messageSource.getMessage("lang.internalServer", null, locale);
	}

	public static String canNotBeNull(String name, Locale locale) {
		return name + " " + messageSource.getMessage("lang.dataNotBenull", null, locale);
	}

	public static String dataExist(String name, Locale locale) {
		return name + " " + messageSource.getMessage("lang.code_er", null, locale);
	}

	public static String updatedSuccessFully(Locale locale) {
		return messageSource.getMessage("lang.updatedSuccessFully", null, locale);
	}

	public static String notFound(String name, Locale locale) {
		return name + " " + messageSource.getMessage("lang.dataNotFound", null, locale);
	}

	public static String deletedElementUsed(Locale locale) {
		return messageSource.getMessage("lang.deletedElementUsed", null, locale);
	}

    public static String deletedSuccessFully(Locale locale) {
        return messageSource.getMessage("lang.deletedSuccessFully", null, locale);
    }
	public static String loginFail(Locale locale) {
		return messageSource.getMessage("lang.loginFail", null, locale);
	}

	public static String loginSuccess(Locale locale) {
		return messageSource.getMessage("lang.loginSuccess", null, locale);
	}

     
}
