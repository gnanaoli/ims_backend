package com.fa.inventory.dto;

public class SafetyStatusDto {
	
	
	
	private Long id;

	
	private String statusName;

	
	private String status;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
