package com.fa.inventory.dto;

public class ServiceTrackerDto {

	private Long id;

	private String quantity;

	private String serialNumber;

	private String workingNonWorking;

	private String type;

	private String fromDate;

	private String toDate;

	private String status;

	private String comments;

	private String createdBy;

	private String creationDate;

	private String lastModifiedDate;

	private String inventoryNumber;

	private String subCategory;

	private String category;

	private String moveBackTo;

	private String needChallan;

	private String lastModified;

	private String fromLocation;

	private String warehouseSiteName;

	private String referenceNo;

	private String availableQty;

	private String movedQty;

	private CategoryDto category1;

	private SubCategoryDto subCategory1;

	private InventoryEntranceDto inventoryEntrance;

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getMoveBackTo() {
		return moveBackTo;
	}

	public void setMoveBackTo(String moveBackTo) {
		this.moveBackTo = moveBackTo;
	}

	public String getNeedChallan() {
		return needChallan;
	}

	public void setNeedChallan(String needChallan) {
		this.needChallan = needChallan;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	private String modelCode;

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getWorkingNonWorking() {
		return workingNonWorking;
	}

	public void setWorkingNonWorking(String workingNonWorking) {
		this.workingNonWorking = workingNonWorking;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getWarehouseSiteName() {
		return warehouseSiteName;
	}

	public void setWarehouseSiteName(String warehouseSiteName) {
		this.warehouseSiteName = warehouseSiteName;
	}

	public CategoryDto getCategory1() {
		return category1;
	}

	public void setCategory1(CategoryDto category1) {
		this.category1 = category1;
	}

	public SubCategoryDto getSubCategory1() {
		return subCategory1;
	}

	public void setSubCategory1(SubCategoryDto subCategory1) {
		this.subCategory1 = subCategory1;
	}

	public InventoryEntranceDto getInventoryEntrance() {
		return inventoryEntrance;
	}

	public void setInventoryEntrance(InventoryEntranceDto inventoryEntrance) {
		this.inventoryEntrance = inventoryEntrance;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
	}

	public String getMovedQty() {
		return movedQty;
	}

	public void setMovedQty(String movedQty) {
		this.movedQty = movedQty;
	}

}
