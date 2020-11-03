package com.fa.inventory.service;

import java.security.Principal;

import org.springframework.security.core.Authentication;

public interface SmsService {

	String sendSms(Principal principal,Authentication authentication);
	
	String sendSmsWithRestTemplate(Principal principal,Authentication authentication,String smsTemplate);
	
	String smsResponse(String mob,String name);
	
	String sendSmsToWareHouseOrProjectUsers(String To);
	
	
}
