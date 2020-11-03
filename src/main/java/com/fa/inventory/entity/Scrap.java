package com.fa.inventory.entity;

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
@Table(name = "scrap")
public class Scrap {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity", length = 4, nullable = false)
	private Integer quantity;

	@Column(name = "from_location", length = 20, nullable = false)
	private String fromLocation;

	@Column(name = "warehouse_site_name", length = 50, nullable = false)
	private String warehouseSiteName;

	@Column(name = "status", length = 50, nullable = false)
	private String status;

	@Column(name = "sub_status", length = 50, nullable = true)
	private String subStatus;

	@Column(name = "level_1_approver", length = 50, nullable = false)
	private String level1Approver;

	@Column(name = "comments", length = 300, nullable = true)
	private String comments;

	@Column(name = "raised_by", length = 30, nullable = false)
	private String raisedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "raised_date")
	private Date raisedDate;

	@Column(name = "last_modified_by", length = 19)
	private String lastModifiedBy;

	@Column(name = "level_2_approver")
	private String level2Approver;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name = "inventory_number", length = 50, nullable = true)
	private String inventoryNumber;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "sub_category_id")
	private SubCategory subCategory;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "inventory_stock_id")
	private InventoryEntrance inventoryEntrance;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "inventory_assign_id")
	private InventoryAssign inventoryAssign;

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

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getLevel2Approver() {
		return level2Approver;
	}

	public void setLevel2Approver(String level2Approver) {
		this.level2Approver = level2Approver;
	}

	public InventoryEntrance getInventoryEntrance() {
		return inventoryEntrance;
	}

	public void setInventoryEntrance(InventoryEntrance inventoryEntrance) {
		this.inventoryEntrance = inventoryEntrance;
	}

	public InventoryAssign getInventoryAssign() {
		return inventoryAssign;
	}

	public void setInventoryAssign(InventoryAssign inventoryAssign) {
		this.inventoryAssign = inventoryAssign;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}
	
	

}
