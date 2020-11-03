package com.fa.inventory.dto;

public class FindToolResponseDto {
	private Long id;
 private String categoryType;
 private String subcategoryName;
 private String model;
 private Integer quantity;
 private String location;
 
  public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
private String site;
public String getCategoryType() {
	return categoryType;
}
public void setCategoryType(String categoryType) {
	this.categoryType = categoryType;
}
public String getSubcategoryName() {
	return subcategoryName;
}
public void setSubcategoryName(String subcategoryName) {
	this.subcategoryName = subcategoryName;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public String getSite() {
	return site;
}
public void setSite(String site) {
	this.site = site;
}
  
}
