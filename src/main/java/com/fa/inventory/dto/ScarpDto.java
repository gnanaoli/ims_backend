package com.fa.inventory.dto;

import java.io.Serializable;
import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScarpDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("from_location")
	private String fromLocation;

	@JsonProperty("warehouse_site_name")
	private String warehouseSiteName;

	@JsonProperty("status")
	private String status;

	@JsonProperty("sub_status")
	private String subStatus;

	@JsonProperty("level_1_approver")
	private String level1Approver;

	@JsonProperty("comments")
	private String comments;

	@JsonProperty("raised_by")
	private String raisedBy;

	@JsonProperty("raised_date")
	private Timestamp raisedDate;

	@JsonProperty("last_modified_by")
	private String lastModifiedBy;

	@JsonProperty("last_modified_date")
	private Timestamp lastModifiedDate;

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

	public String getLevel1Approver() {
		return level1Approver;
	}

	public void setLevel1Approver(String level1Approver) {
		this.level1Approver = level1Approver;
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

	public Timestamp getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Timestamp raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	
	
}
