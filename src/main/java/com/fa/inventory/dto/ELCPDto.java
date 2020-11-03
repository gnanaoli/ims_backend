package com.fa.inventory.dto;

public class ELCPDto {
	
	private Long id;
	
	private String date;
	
	private String projectName;
	
	private String safetyStatus;
	
	private String workingStatus;
	
	private String comments;
	
	private String userId;
	private String upDatedBy;
	private String upDatedTime;
	
	private ProjectDto projectDto;
	
	private UserDto userDto;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getSafetyStatus() {
		return safetyStatus;
	}


	public void setSafetyStatus(String safetyStatus) {
		this.safetyStatus = safetyStatus;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	


	public String getUpDatedBy() {
		return upDatedBy;
	}


	public void setUpDatedBy(String upDatedBy) {
		this.upDatedBy = upDatedBy;
	}


	public String getUpDatedTime() {
		return upDatedTime;
	}


	public void setUpDatedTime(String upDatedTime) {
		this.upDatedTime = upDatedTime;
	}


	public ProjectDto getProjectDto() {
		return projectDto;
	}


	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
	}


	public UserDto getUserDto() {
		return userDto;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}


	public String getWorkingStatus() {
		return workingStatus;
	}


	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}



}
