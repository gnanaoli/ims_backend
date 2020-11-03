package com.fa.inventory.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("userType")
	private String userType;

	@JsonProperty("empid")
	private String empid;

	@JsonProperty("userName")
	private String userName;

	@JsonProperty("role")
	private String role;

	@JsonProperty("designation")
	private String designation;

	@JsonProperty("mobileNumber")
	private String mobileNumber;

	@JsonProperty("emailId")
	private String emailId;

	@JsonProperty("password")
	private String password;

	@JsonProperty("confirmPassword")
	private String confirmPassword;

	@JsonProperty("newPassword")
	private String newPassword;

	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("creationDate")
	private Date creationDate;

	@JsonProperty("lastModifiedDate")
	private Date lastModifiedDate;

	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;
	
	@JsonProperty("lastLoginDateTime")
	private String lastLoginDateTime;

	@JsonProperty("pages")
	private String pages;

	@JsonProperty("countryName")
	private String countryName;

	@JsonProperty("stateName")
	private String stateName;

	@JsonProperty("cityName")
	private String cityName;

	@JsonProperty("projectName")
	private String projectName;

	@JsonProperty("roleType")
	private String roleType;

    @JsonProperty("Roles")
	private List<RoleDto> roleSet;

	private List<RoleDto> userNotSelectedRoles;

	private List<ProjectDto> userNotSelectedProjects;

	@JsonProperty("Projects")
	private List<ProjectDto> projectItemDtoList;

	@JsonProperty("wareHouses")
	private List<WareHouseDto> wareHouseDtoList;

	private List<WareHouseDto> userNotSelectedWareHouseDtoList;

	@JsonProperty("oldPassword")
	private String oldPassword;

	@JsonProperty("resetPassword")
	private String resetPassword;

	@JsonProperty("firstLogin")
	private String firstLogin;

	@JsonProperty("name")
	private String name;

	@JsonProperty("secretQuestion")
	private String secretQuestion;

	@JsonProperty("secretAnswer")
	private String secretAnswer;

	@JsonProperty("theme")
	private String theme;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	
	public String getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(String lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public List<RoleDto> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(List<RoleDto> roleSet) {
		this.roleSet = roleSet;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<ProjectDto> getProjectItemDtoList() {
		return projectItemDtoList;
	}

	public void setProjectItemDtoList(List<ProjectDto> projectItemDtoList) {
		this.projectItemDtoList = projectItemDtoList;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(String firstLogin) {
		this.firstLogin = firstLogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WareHouseDto> getWareHouseDtoList() {
		return wareHouseDtoList;
	}

	public void setWareHouseDtoList(List<WareHouseDto> wareHouseDtoList) {
		this.wareHouseDtoList = wareHouseDtoList;
	}

	public List<RoleDto> getUserNotSelectedRoles() {
		return userNotSelectedRoles;
	}

	public void setUserNotSelectedRoles(List<RoleDto> userNotSelectedRoles) {
		this.userNotSelectedRoles = userNotSelectedRoles;
	}

	public List<ProjectDto> getUserNotSelectedProjects() {
		return userNotSelectedProjects;
	}

	public void setUserNotSelectedProjects(List<ProjectDto> userNotSelectedProjects) {
		this.userNotSelectedProjects = userNotSelectedProjects;
	}

	public List<WareHouseDto> getUserNotSelectedWareHouseDtoList() {
		return userNotSelectedWareHouseDtoList;
	}

	public void setUserNotSelectedWareHouseDtoList(List<WareHouseDto> userNotSelectedWareHouseDtoList) {
		this.userNotSelectedWareHouseDtoList = userNotSelectedWareHouseDtoList;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

}
