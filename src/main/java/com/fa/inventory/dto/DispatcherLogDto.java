package com.fa.inventory.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dispatcher_log")
public class DispatcherLogDto {

	private Long id;

	private String categoryType;

	private String subCategory;

	private String referenceNo;

	private String modelCode;

	private Integer quantity;
	
	private Integer quantityInTransferProcess;

	private String requestedFrom;

	private String requestedTo;

	private Integer requiredDays;

	private Date expectedDateToReach;

	private String status;

	private String subStatus;

	private Date dispatchDate;

	private Integer acceptedQuantity;

	private String availableQuantity;

	private String comments;

	private String raisedBy;

	private Date raisedDate;

	private String actionBy;

	private Date actionDate;

	private CategoryDto categoryDto;

	private String vehicleNumber;
	
	private String vehicleNumber1;
	
	private String vehicleNumber2;
	
	private String vehicleNumber3;

	private SubCategoryDto subCategoryDto;

	private String location;

	private String assetTracking;

	private String purpose;

	private String reason;

	private String Price;
	
	private InventoryAssignDto inventoryAssignDto;

	private InventoryEntranceDto inventoryEntranceDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

	public Integer getQuantityInTransferProcess() {
		return quantityInTransferProcess;
	}

	public void setQuantityInTransferProcess(Integer quantityInTransferProcess) {
		this.quantityInTransferProcess = quantityInTransferProcess;
	}

	public String getRequestedFrom() {
		return requestedFrom;
	}

	public void setRequestedFrom(String requestedFrom) {
		this.requestedFrom = requestedFrom;
	}

	public String getRequestedTo() {
		return requestedTo;
	}

	public void setRequestedTo(String requestedTo) {
		this.requestedTo = requestedTo;
	}

	public Integer getRequiredDays() {
		return requiredDays;
	}

	public void setRequiredDays(Integer requiredDays) {
		this.requiredDays = requiredDays;
	}

	public Date getExpectedDateToReach() {
		return expectedDateToReach;
	}

	public void setExpectedDateToReach(Date expectedDateToReach) {
		this.expectedDateToReach = expectedDateToReach;
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

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Integer getAcceptedQuantity() {
		return acceptedQuantity;
	}

	public void setAcceptedQuantity(Integer acceptedQuantity) {
		this.acceptedQuantity = acceptedQuantity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleNumber1() {
		return vehicleNumber1;
	}

	public void setVehicleNumber1(String vehicleNumber1) {
		this.vehicleNumber1 = vehicleNumber1;
	}

	public String getVehicleNumber2() {
		return vehicleNumber2;
	}

	public void setVehicleNumber2(String vehicleNumber2) {
		this.vehicleNumber2 = vehicleNumber2;
	}

	public String getVehicleNumber3() {
		return vehicleNumber3;
	}

	public void setVehicleNumber3(String vehicleNumber3) {
		this.vehicleNumber3 = vehicleNumber3;
	}

	public SubCategoryDto getSubCategoryDto() {
		return subCategoryDto;
	}

	public void setSubCategoryDto(SubCategoryDto subCategoryDto) {
		this.subCategoryDto = subCategoryDto;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public InventoryAssignDto getInventoryAssignDto() {
		return inventoryAssignDto;
	}

	public void setInventoryAssignDto(InventoryAssignDto inventoryAssignDto) {
		this.inventoryAssignDto = inventoryAssignDto;
	}

	public InventoryEntranceDto getInventoryEntranceDto() {
		return inventoryEntranceDto;
	}

	public void setInventoryEntranceDto(InventoryEntranceDto inventoryEntranceDto) {
		this.inventoryEntranceDto = inventoryEntranceDto;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getAssetTracking() {
		return assetTracking;
	}

	public void setAssetTracking(String assetTracking) {
		this.assetTracking = assetTracking;
	}

	public String getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
