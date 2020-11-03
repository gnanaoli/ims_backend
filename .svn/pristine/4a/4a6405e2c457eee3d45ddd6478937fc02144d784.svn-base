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
@Table(name = "warehouse")
public class WareHouse {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "warehouse_name", length = 50, nullable = false)
	private String wareHouseName;

	@Column(name = "code", unique = true, length = 3, nullable = false)
	private String code;

	@Column(name = "parent_code", length = 3, nullable = false)
	private String parentCode;

	@Column(name = "address_1", length = 50, nullable = false)
	private String address1;

	@Column(name = "address_2", length = 50)
	private String address2;

	@Column(name = "address_3", length = 50)
	private String address3;

	@Column(name = "area_landmark", length = 50)
	private String areaLandmark;

	@Column(name = "country", length = 50, nullable = false)
	private String country;

	@Column(name = "state", length = 50, nullable = false)
	private String state;

	@Column(name = "city", length = 50, nullable = false)
	private String city;

	@Column(name = "pincode", length = 6, nullable = false)
	private Integer pincode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effective_start_date", length = 19, nullable = false)
	private Date effectiveStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effective_end_date", length = 19, nullable = false)
	private Date effectiveEndDate;

	@Column(name = "status", length = 8, nullable = false)
	private String status;

	@Column(name = "created_by", length = 30, nullable = false)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 19, nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19, nullable = false)
	private Date lastModifiedDate;

	@Column(name = "last_modified_by", length = 30, nullable = false)
	private String lastModifiedBy;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "user_warehouse", joinColumns = { @JoinColumn(name = "warehouse_fk_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_fk_id") })
	private List<User> user = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "warehouse_id")
	private List<WareHouseBlocks> wareHouseBlocksList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWareHouseName() {
		return wareHouseName;
	}

	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
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

	public void setEffectiveStartDate(Timestamp effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public void setEffectiveEndDate(Timestamp effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<WareHouseBlocks> getWareHouseBlocksList() {
		return wareHouseBlocksList;
	}

	public void setWareHouseBlocksList(List<WareHouseBlocks> wareHouseBlocksList) {
		this.wareHouseBlocksList = wareHouseBlocksList;
	}

}
