package com.fa.inventory.dto;

import java.util.List;

public class ProjectDto {

	private Long id;

	private String customerType;

	private String projectInCharge;

	private String name;

	private String projectType;

	private String startDate;

	private String endDate;

	private String status;

	private String projectstatus;

	private String address1;

	private String address2;

	private String address3;

	private String areaLandmark;

	private String state;

	private String city;

	private String countryName;

	private String pinCode;

	private String createdBy;

	private String creationDate;

	// private Date lastModifiedDate;

	// private String lastModifiedBy;

	private Boolean selected;

	private String location;

	private String wareHouseSiteName;

	private String resourceCount;

	private String comments;

	private List<ProjectsTasksDto> ProjectTasksDtoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getProjectInCharge() {
		return projectInCharge;
	}

	public void setProjectInCharge(String projectInCharge) {
		this.projectInCharge = projectInCharge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProjectstatus() {
		return projectstatus;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAreaLandmark() {
		return areaLandmark;
	}

	public void setAreaLandmark(String areaLandmark) {
		this.areaLandmark = areaLandmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWareHouseSiteName() {
		return wareHouseSiteName;
	}

	public void setWareHouseSiteName(String wareHouseSiteName) {
		this.wareHouseSiteName = wareHouseSiteName;
	}

	public String getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(String resourceCount) {
		this.resourceCount = resourceCount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public List<ProjectsTasksDto> getProjectTasksDtoList() {
		return ProjectTasksDtoList;
	}

	public void setProjectTasksDtoList(List<ProjectsTasksDto> projectTasksDtoList) {
		ProjectTasksDtoList = projectTasksDtoList;
	}

}
