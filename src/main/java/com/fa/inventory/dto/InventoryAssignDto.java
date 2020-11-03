package com.fa.inventory.dto;

public class InventoryAssignDto {
	private Long id;

	private String category;

	private String subCategory;

	private String modelCode;

	private Integer availableQty;

	private Integer allocatedQty;

	private Integer leftoverQty;

	private String assignedLocation;

	private String warehouseOrSitename;

	private String warehouseBlocks;

	private String inperson;

	private String createdBy;

	private String creationDate;

	private String inventoryLocation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public Integer getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
	}

	public Integer getAllocatedQty() {
		return allocatedQty;
	}

	public void setAllocatedQty(Integer allocatedQty) {
		this.allocatedQty = allocatedQty;
	}

	public Integer getLeftoverQty() {
		return leftoverQty;
	}

	public void setLeftoverQty(Integer leftoverQty) {
		this.leftoverQty = leftoverQty;
	}

	public String getAssignedLocation() {
		return assignedLocation;
	}

	public void setAssignedLocation(String assignedLocation) {
		this.assignedLocation = assignedLocation;
	}

	public String getWarehouseOrSitename() {
		return warehouseOrSitename;
	}

	public void setWarehouseOrSitename(String warehouseOrSitename) {
		this.warehouseOrSitename = warehouseOrSitename;
	}

	public String getWarehouseBlocks() {
		return warehouseBlocks;
	}

	public void setWarehouseBlocks(String warehouseBlocks) {
		this.warehouseBlocks = warehouseBlocks;
	}

	public String getInperson() {
		return inperson;
	}

	public void setInperson(String inperson) {
		this.inperson = inperson;
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

	public String getInventoryLocation() {
		return inventoryLocation;
	}

	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}

}
