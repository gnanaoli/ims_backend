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
@Table(name = "inventory_assign")
public class InventoryAssign {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "model_code", length = 10, nullable = false)
	private String modelCode;

	@Column(name = "available_qty", length = 4, nullable = false)
	private Integer availableQty;

	@Column(name = "allocated_qty", length = 4, nullable = false)
	private Integer allocatedQty;

	@Column(name = "leftover_qty", length = 4, nullable = false)
	private Integer leftoverQty;

	@Column(name = "assigned_location", length = 20, nullable = false)
	private String assignedLocation;

	@Column(name = "warehouse_or_sitename", length = 50, nullable = false)
	private String wareHouseSiteName;

	@Column(name = "warehouse_blocks", length = 50)
	private String warehouseBlocks;

	@Column(name = "inperson", length = 50, nullable = false)
	private String inperson;

	@Column(name = "created_by", length = 30, nullable = false)
	private String createdBy;

	@Column(name = "sub_category_name", length = 100, nullable = false)
	private String subCategoryName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 19, nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19, nullable = false)
	private Date lastModifiedDate;

	@Column(name = "last_modified_by", length = 30, nullable = false)
	private String lastModifiedBy;

	@Column(name = "inventory_number")
	private String inventoryNumber;

	@Column(name = "inventory_location")
	private String inventoryLocation;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "inventory_stock_id")
	private InventoryEntrance inventoryEntrance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getWareHouseSiteName() {
		return wareHouseSiteName;
	}

	public void setWareHouseSiteName(String wareHouseSiteName) {
		this.wareHouseSiteName = wareHouseSiteName;
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

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
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

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getInventoryLocation() {
		return inventoryLocation;
	}

	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
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

	public InventoryEntrance getInventoryEntrance() {
		return inventoryEntrance;
	}

	public void setInventoryEntrance(InventoryEntrance inventoryEntrance) {
		this.inventoryEntrance = inventoryEntrance;
	}

}
