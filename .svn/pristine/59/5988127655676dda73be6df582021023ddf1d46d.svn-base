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
@Table(name = "service_tracker")
public class ServiceTracker {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity", length = 4, nullable = false)
	private Integer quantity;

	@Column(name = "serial_number", length = 20)
	private String serialNumber;

	@Column(name = "working_condition", length = 20, nullable = true)
	private String workingCondtion;

	@Column(name = "type", length = 20, nullable = false)
	private String type;

	@Temporal(TemporalType.DATE)
	@Column(name = "from_date", length = 19, nullable = false)
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "to_date", length = 19, nullable = false)
	private Date toDate;

	@Column(name = "status", length = 20, nullable = false)
	private String status;

	@Column(name = "comments", length = 300, nullable = false)
	private String comments;

	@Column(name = "created_by", length = 30, nullable = false)
	private String createdBy;
	
	@Column(name = "inventory_number")
	private String inventoryNumber;
	
	@Column(name = "from_location", length = 20, nullable = false)
	private String fromLocation;
	
	@Column(name = "warehouse_site_name", length = 50, nullable = false)
	private String warehouseSiteName;

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 19, nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19, nullable = false)
	private Date lastModifiedDate;

	@Column(name = "last_modified_by", length = 30, nullable = false)
	private String lastModifiedBy;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "sub_category_id")
	private SubCategory subCategory;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "category_id")
	private Category category;
	
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
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

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
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

	public String getWorkingCondtion() {
		return workingCondtion;
	}

	public void setWorkingCondtion(String workingCondtion) {
		this.workingCondtion = workingCondtion;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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

}
