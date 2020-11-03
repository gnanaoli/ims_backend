package com.fa.inventory.dto;

import java.util.List;

public class CountryDto {

	private Integer id;

	private String countryName;

	private String status;

	private Integer code;

	private List<StateDto> stateItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<StateDto> getStateItem() {
		return stateItem;
	}

	public void setStateItem(List<StateDto> stateItem) {
		this.stateItem = stateItem;
	}

}
