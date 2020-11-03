package com.fa.inventory.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inventory_request")
public class InventoryRequest {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "reference_no", length = 40, nullable = true)
	private String referenceNo;

	@Column(name = "model_code", length = 10, nullable = true)
	private String modelCode;

	@Column(name = "quantity", length = 4, nullable = true)
	private Integer quantity;

	@Column(name = "requested_from", length = 20, nullable = true)
	private String requestedFrom;

	@Column(name = "requested_to", length = 50, nullable = true)
	private String requestedTo;

	@Column(name = "required_days", length = 20, nullable = true)
	private Integer requiredDays;

	@Temporal(TemporalType.DATE)
	@Column(name = "expected_date_toreach", length = 10, nullable = true)
	private Date expectedDateToReach;

	@Column(name = "status", length = 50, nullable = true)
	private String status;

	@Column(name = "sub_status", length = 50, nullable = true)
	private String subStatus;

	@Column(name = "challan_status", length = 50, nullable = true)
	private String challanStatus;

	@Column(name = "notification_status", length = 100, nullable = true)
	private String notificationStatus;

	@Column(name = "notification_link", length = 100, nullable = true)
	private String notificationLink;

	@Temporal(TemporalType.DATE)
	@Column(name = "dispatchdate", length = 10)
	private Date dispatchDate;

	@Column(name = "accepted_quantity", length = 4, nullable = true)
	private Integer acceptedQuantity;

	@Column(name = "comments", length = 300, nullable = true)
	private String comments;

	@Column(name = "raised_by", length = 30, nullable = true)
	private String raisedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "raised_date", length = 19, nullable = true)
	private Date raisedDate;

	@Column(name = "action_by", length = 19, nullable = true)
	private String actionBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "action_date", length = 19, nullable = true)
	private Date actionDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	@Column(name = "location", length = 19, nullable = true)
	private String location;

	@Column(name = "inventory_number", length = 50, nullable = true)
	private String inventoryNumber;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "inventory_assign_id")
	private InventoryAssign inventoryAssign;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "inventory_stock_id")
	private InventoryEntrance inventoryEntrance;

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

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Timestamp actionDate) {
		this.actionDate = actionDate;
	}

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public InventoryAssign getInventoryAssign() {
		return inventoryAssign;
	}

	public void setInventoryAssign(InventoryAssign inventoryAssign) {
		this.inventoryAssign = inventoryAssign;
	}

	public InventoryEntrance getInventoryEntrance() {
		return inventoryEntrance;
	}

	public void setInventoryEntrance(InventoryEntrance inventoryEntrance) {
		this.inventoryEntrance = inventoryEntrance;
	}

	public String getChallanStatus() {
		return challanStatus;
	}

	public void setChallanStatus(String challanStatus) {
		this.challanStatus = challanStatus;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public String getNotificationLink() {
		return notificationLink;
	}

	public void setNotificationLink(String notificationLink) {
		this.notificationLink = notificationLink;
	}

}
