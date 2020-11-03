package com.fa.inventory.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScrapDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("comments")
	private String comments;
	
	@JsonProperty("fromLocation")
	private String fromLocation;
	
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;
	
	@JsonProperty("lastModifiedDate")
	private String lastModifiedDate;
	
	@JsonProperty("level1Approver")
	private String level1Approver;
	
	@JsonProperty("level2Approver")
	private String level2Approver;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	@JsonProperty("raised_by")
	private String raised_by;
	
	@JsonProperty("raisedDate")
	private Date raisedDate;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("subStatus")
	private String subStatus;
	
	@JsonProperty("warehouseSiteName")
	private String warehouseSiteName;
	
	@JsonProperty("inventoryNumber")
	private String inventoryNumber;
	
	@JsonProperty("category")
	private CategoryDto category;
	
	@JsonProperty("subCategory")
	private SubCategoryDto subCategory;
	
	@JsonProperty("inventoryEntrance")
	private InventoryEntranceDto inventoryEntrance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLevel1Approver() {
		return level1Approver;
	}

	public void setLevel1Approver(String level1Approver) {
		this.level1Approver = level1Approver;
	}

	public String getLevel2Approver() {
		return level2Approver;
	}

	public void setLevel2Approver(String level2Approver) {
		this.level2Approver = level2Approver;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public String getRaised_by() {
		return raised_by;
	}

	public void setRaised_by(String raised_by) {
		this.raised_by = raised_by;
	}



	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public String getWarehouseSiteName() {
		return warehouseSiteName;
	}

	public void setWarehouseSiteName(String warehouseSiteName) {
		this.warehouseSiteName = warehouseSiteName;
	}

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

	public InventoryEntranceDto getInventoryEntrance() {
		return inventoryEntrance;
	}

	public void setInventoryEntrance(InventoryEntranceDto inventoryEntrance) {
		this.inventoryEntrance = inventoryEntrance;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}




	
}
