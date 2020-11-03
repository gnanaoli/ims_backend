/**
 * 
 */
package com.fa.inventory.dto;

import java.io.Serializable;

/**
 * @author Divya
 *
 */
public class CommonResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
