package com.fa.inventory.dto;

import java.util.Date;

public class NotificationDto {
	
	private Long id;
	
	private Integer quantity;
	
	private String requestedFrom;
	
	private String requestedTo;
	
	private String status;
	
	private String subStatus;
	
	private String notificationStatus;
	
	private String notificationLink;
	
	private String notificationMessage;
	
	private String creationDate;
	
	private String notificationViewStatus;
	
	private String categoryType;
	
	private String userName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getNotificationViewStatus() {
		return notificationViewStatus;
	}

	public void setNotificationViewStatus(String notificationViewStatus) {
		this.notificationViewStatus = notificationViewStatus;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	 
	
	
}
