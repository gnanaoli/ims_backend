package com.fa.inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindToolsDto {

	@JsonProperty("categoryDto")
	private CategoryDto category;

	@JsonProperty("subCategoryDto")
	private SubCategoryDto subCategory;
	
	@JsonProperty("searchKeyword")
	private String searchKeyword;

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public SubCategoryDto getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategoryDto subCategory) {
		this.subCategory = subCategory;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	

}
