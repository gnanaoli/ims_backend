package com.fa.inventory.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "notification_status")
public class Notifications {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity", length = 100, nullable = false)
	private Integer quantity;

	@Column(name = "requested_from", length = 20, nullable = true)
	private String requestedFrom;

	@Column(name = "requested_to", length = 50, nullable = true)
	private String requestedTo;
	
	@Column(name = "status", length = 50, nullable = true)
	private String status;

	@Column(name = "sub_status", length = 50, nullable = true)
	private String subStatus;

	@Column(name = "notification_status", length = 100, nullable = true)
	private String notificationStatus;

	@Column(name = "notification_link", length = 100, nullable = true)
	private String notificationLink;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 10, nullable = true)
	private Date creationDate;

	@Column(name = "notification_view_status", length = 100, nullable = true)
	private String notificationViewStatus;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;
	
	
	@Column(name = "user_name", length = 100, nullable = true)
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getNotificationViewStatus() {
		return notificationViewStatus;
	}

	public void setNotificationViewStatus(String notificationViewStatus) {
		this.notificationViewStatus = notificationViewStatus;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	 
	
	
	
}
