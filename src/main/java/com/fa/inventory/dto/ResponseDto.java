package com.fa.inventory.dto;

import java.util.List;

public class ResponseDto {

	private String status;

	private String exceptionMessage;

	private String number;

	private String exceptionCode;

	private List<UserDto> userDtoList;

	private List<?> responseDtoList;

	public List<UserDto> getUserDtoList() {
		return userDtoList;
	}

	public void setUserDtoList(List<UserDto> userDtoList) {
		this.userDtoList = userDtoList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<?> getResponseDtoList() {
		return responseDtoList;
	}

	public void setResponseDtoList(List<?> responseDtoList) {
		this.responseDtoList = responseDtoList;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
