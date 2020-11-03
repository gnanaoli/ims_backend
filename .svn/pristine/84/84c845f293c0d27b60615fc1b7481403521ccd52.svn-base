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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inventory_stock")
public class InventoryEntrance {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity", length = 4, nullable = true)
	private Integer quantity;

	@Column(name = "available_quantity", length = 4, nullable = true)
	private Integer availableQuantity;

	@Column(name = "serial_number", length = 17)
	private String serialNumber;

	@Column(name = "manufacturer_name", length = 100, nullable = true)
	private String manufacturerName;

	@Column(name = "supplier_name", length = 100, nullable = true)
	private String supplierName;

	@Column(name = "purchase_total_cost", length = 15, nullable = true)
	private Double purchaseTotalCost;

	@Column(name = "service_due_month", length = 4, nullable = true)
	private String serviceDueMonth;

	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_date", length = 10, nullable = true)
	private Date purchaseDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "service_due_date", length = 10, nullable = true)
	private Date serviceDueDate;

	@Column(name = "is_warranty_applicable", length = 3, nullable = true)
	private String isWarrantyApplicable;
	
	@Column(name = "is_service_applicable", length = 3, nullable = true)
	private String isServiceApplicable;

	@Column(name = "sub_category_name", length = 100, nullable = true)
	private String subCategoryName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "warranty_expiry_date", length = 10)
	private Date warrantyExpiryDate;

	@Column(name = "comments", length = 300)
	private String comments;

	@Column(name = "inventory_number", unique = true, length = 10, nullable = true)
	private String inventoryNumber;

	@Column(name = "asset_tracking", length = 30, nullable = true)
	private String assetTracking;

	@Column(name = "created_by", length = 30, nullable = true)
	private String created_By;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 10, nullable = true)
	private Date creationDate;

	@Column(name = "year", length = 4, nullable = true)
	private Integer year;

	@Column(name = "month", length = 4, nullable = true)
	private Integer month;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 10, nullable = true)
	private Date lastModifiedDate;

	@Column(name = "last_modified_by", length = 30, nullable = true)
	private String lastModifiedBy;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, })
	@JoinColumn(name = "inventory_stock_id")
	private List<InventoryAssign> inventoryAssignItem = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "inventory_stock_id")
	private List<InventoryRequest> inventoryRequestItem = new ArrayList<>();

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	@Column(name = "asset_no", length = 45)
	private String assetNo;

	@Column(name = "location", length = 45)
	private String location;

	@Column(name = "make_name", length = 45, nullable = true)
	private String makeName;

	@Column(name = "model_name", length = 45, nullable = true)
	private String modelName;

	@Column(name = "vehicleNumber", length = 45, nullable = true)
	private String vehicleNumber;

	@Column(name = "warehouse_sitename", length = 45, nullable = true)
	private String wareHouseSiteName;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, })
	@JoinColumn(name = "inventory_stock_id")
	private List<Scrap> scrap;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, })
	@JoinColumn(name = "inventory_stock_id")
	private List<ServiceTracker> serviceTracker;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;

	@Column(name = "model_code", length = 30, nullable = true)
	private String modelcode;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "warehouseblock_id")
	private WareHouseBlocks wareHouseBlock;

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

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Double getPurchaseTotalCost() {
		return purchaseTotalCost;
	}

	public void setPurchaseTotalCost(Double purchaseTotalCost) {
		this.purchaseTotalCost = purchaseTotalCost;
	}
	

	
	public String getServiceDueMonth() {
		return serviceDueMonth;
	}

	public void setServiceDueMonth(String serviceDueMonth) {
		this.serviceDueMonth = serviceDueMonth;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getIsWarrantyApplicable() {
		return isWarrantyApplicable;
	}

	public void setIsWarrantyApplicable(String isWarrantyApplicable) {
		this.isWarrantyApplicable = isWarrantyApplicable;
	}
	

	public String getIsServiceApplicable() {
		return isServiceApplicable;
	}

	public void setIsServiceApplicable(String isServiceApplicable) {
		this.isServiceApplicable = isServiceApplicable;
	}

	public Date getWarrantyExpiryDate() {
		return warrantyExpiryDate;
	}

	public void setWarrantyExpiryDate(Date warrantyExpiryDate) {
		this.warrantyExpiryDate = warrantyExpiryDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getCreated_By() {
		return created_By;
	}

	public void setCreated_By(String created_By) {
		this.created_By = created_By;
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

	public List<InventoryAssign> getInventoryAssignItem() {
		return inventoryAssignItem;
	}

	public void setInventoryAssignItem(List<InventoryAssign> inventoryAssignItem) {
		this.inventoryAssignItem = inventoryAssignItem;
	}

	public List<InventoryRequest> getInventoryRequestItem() {
		return inventoryRequestItem;
	}

	public void setInventoryRequestItem(List<InventoryRequest> inventoryRequestItem) {
		this.inventoryRequestItem = inventoryRequestItem;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Scrap> getScrap() {
		return scrap;
	}

	public void setScrap(List<Scrap> scrap) {
		this.scrap = scrap;
	}

	public List<ServiceTracker> getServiceTracker() {
		return serviceTracker;
	}

	public void setServiceTracker(List<ServiceTracker> serviceTracker) {
		this.serviceTracker = serviceTracker;
	}

	public String getWareHouseSiteName() {
		return wareHouseSiteName;
	}

	public void setWareHouseSiteName(String wareHouseSiteName) {
		this.wareHouseSiteName = wareHouseSiteName;
	}

	public String getAssetNo() {
		return assetNo;
	}

	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getModelcode() {
		return modelcode;
	}

	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}

	public String getAssetTracking() {
		return assetTracking;
	}

	public void setAssetTracking(String assetTracking) {
		this.assetTracking = assetTracking;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public WareHouseBlocks getWareHouseBlock() {
		return wareHouseBlock;
	}

	public void setWareHouseBlock(WareHouseBlocks wareHouseBlock) {
		this.wareHouseBlock = wareHouseBlock;
	}

	public String getMakeName() {
		return makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Date getServiceDueDate() {
		return serviceDueDate;
	}

	public void setServiceDueDate(Date serviceDueDate) {
		this.serviceDueDate = serviceDueDate;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
