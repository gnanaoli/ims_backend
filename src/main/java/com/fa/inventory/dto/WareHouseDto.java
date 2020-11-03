package com.fa.inventory.dto;

import java.util.List;

public class WareHouseDto {

	private Long id;

	private String wareHouseName;

	private String code;

	private String parentCode;

	private String address1;

	private String address2;

	private String address3;

	private String areaLandmark;

	private String country;

	private String state;

	private String city;

	private String pinCode;

	private String effectiveStartDate;

	private String effectiveEndDate;

	// private List<WareHouse> wareHouseItem = new ArrayList<>();

	private String status;

	private String createdBy;

	private String creationDate;

	private Boolean selected;
	
	private List<WareHouseBlocksDto> wareHouseBlocksDto;

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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(String effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public List<WareHouseBlocksDto> getWareHouseBlocksDto() {
		return wareHouseBlocksDto;
	}

	public void setWareHouseBlocksDto(List<WareHouseBlocksDto> wareHouseBlocksDto) {
		this.wareHouseBlocksDto = wareHouseBlocksDto;
	}



	
	

}
