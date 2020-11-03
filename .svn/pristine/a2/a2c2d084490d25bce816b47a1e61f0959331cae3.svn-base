package com.fa.inventory.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "category_code", length = 6, nullable = false)
	private String categoryCode;

	@Column(name = "category_type", length = 100, nullable = false)
	private String categoryType;

	@Column(name = "asset_tracking", length = 50, nullable = false)
	private String assetTracking;

	@Column(name = "status", length = 8, nullable = false)
	private String status;

	@Column(name = "created_by", length = 30, nullable = false)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 19, nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19, nullable = false)
	private Date lastModifiedDate;

	@Column(name = "last_modified_by", length = 30, nullable = false)
	private String lastModifiedBy;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "category_id")
	private List<SubCategory> subCategory = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "category_id")
	private List<InventoryEntrance> inventoryStock = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "category_id")
	private List<InventoryAssign> inventoryAssign = new ArrayList<>();

	public List<InventoryAssign> getInventoryAssign() {
		return inventoryAssign;
	}

	public void setInventoryAssign(List<InventoryAssign> inventoryAssign) {
		this.inventoryAssign = inventoryAssign;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssetTracking() {
		return assetTracking;
	}

	public void setAssetTracking(String assetTracking) {
		this.assetTracking = assetTracking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public List<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public List<InventoryEntrance> getInventoryStock() {
		return inventoryStock;
	}

	public void setInventoryStock(List<InventoryEntrance> inventoryStock) {
		this.inventoryStock = inventoryStock;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

}
