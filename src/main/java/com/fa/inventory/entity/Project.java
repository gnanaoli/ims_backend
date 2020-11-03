package com.fa.inventory.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_type", length = 100, nullable = true)
	private String customerType;

	@Column(name = "project_in_charge", length = 20, nullable = true)
	private String projectInCharge;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "project_type", length = 50, nullable = false)
	private String projectType;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", length = 10, nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", length = 10, nullable = false)
	private Date endDate;

	@Column(name = "status", length = 16, nullable = false)
	private String status;

	@Column(name = "address_1", length = 50, nullable = false)
	private String address1;

	@Column(name = "address_2", length = 50)
	private String address2;

	@Column(name = "address_3", length = 50)
	private String address3;

	@Column(name = "area_landmark", length = 50)
	private String areaLandmark;

	@Column(name = "state", length = 50, nullable = false)
	private String state;

	@Column(name = "city", length = 50, nullable = false)
	private String city;

	@Column(name = "pincode", length = 6, nullable = false)
	private Integer pinCode;

	@Column(name = "created_by", length = 30, nullable = false)
	private String createdBy;

	// @Temporal(TemporalType.DATE)
	@Column(name = "creation_date", length = 19, nullable = false)
	private Timestamp creationDate;

	// @Temporal(TemporalType.DATE)
	@Column(name = "last_modified_date", length = 19, nullable = false)
	private Timestamp lastModifiedDate;

	@Column(name = "last_modified_by", length = 30, nullable = false)
	private String lastModifiedBy;

	@Column(name = "country_name", length = 50)
	private String countryName;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, })
	@JoinColumn(name = "project_id")
	private List<ProjectTasks> projectTaskList;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "user_project", joinColumns = { @JoinColumn(name = "project_fk_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_fk_id") })
	private List<User> user = new ArrayList<>();

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<ProjectTasks> getProjectTaskList() {
		return projectTaskList;
	}

	public void setProjectTaskList(List<ProjectTasks> projectTaskList) {
		this.projectTaskList = projectTaskList;
	}

}
