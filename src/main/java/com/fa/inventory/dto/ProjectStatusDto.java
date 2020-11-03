package com.fa.inventory.dto;

public class ProjectStatusDto{

	
	private Long id;
	
	private String statusType;

	
	private String status;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStatusType() {
		return statusType;
	}


	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
