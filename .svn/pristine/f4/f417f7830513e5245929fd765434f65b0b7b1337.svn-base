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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "delivery_challan")
public class DeliveryChallanEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "consignee_name")
	private String consigneeName;

	@Column(name = "consignee_address")
	private String consigneeAddress;

	@Column(name = "trans_mode")
	private String transMode;

	@Column(name = "trans_company")
	private String transCompany;

	@Column(name = "gstin")
	private String gstIn;

	@Column(name = "dely_challan")
	private String delyChallan;

	@Column(name = "dc_date")
	private String dcDate;

	@Column(name = "place_of_supply")
	private String placeOfSupply;

	@Column(name = "vehicle_no")
	private String vehicleNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "dispatch_date", nullable = true)
	private Date dispatchDate;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "code")
	private String Code;

	@Column(name = "qty")
	private String Qty;

	@Column(name = "unit")
	private String Unit;

	@Column(name = "rate")
	private String Rate;

	@Column(name = "total")
	private String Total;

	@Column(name = "quantity", length = 4, nullable = true)
	private Integer quantity;

	@Column(name = "status", length = 50, nullable = true)
	private String status;

	@Column(name = "sub_status", length = 50, nullable = true)
	private String subStatus;

	@Column(name = "challan_no", length = 17, nullable = true)
	private String challanNo;

	@Column(name = "purpose", length = 50, nullable = true)
	private String purpose;

	@Column(name = "reason", length = 60, nullable = true)
	private String reason;

	@Column(name = "is_ownvehicle", length = 60, nullable = true)
	private String isOwnVehicle;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, })
	@JoinColumn(name = "dispatchlog_id")
	private DispatcherLog dispatcherLog;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getTransMode() {
		return transMode;
	}

	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}

	public String getTransCompany() {
		return transCompany;
	}

	public void setTransCompany(String transCompany) {
		this.transCompany = transCompany;
	}

	public String getGstIn() {
		return gstIn;
	}

	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}

	public String getDelyChallan() {
		return delyChallan;
	}

	public void setDelyChallan(String delyChallan) {
		this.delyChallan = delyChallan;
	}

	public String getDcDate() {
		return dcDate;
	}

	public void setDcDate(String dcDate) {
		this.dcDate = dcDate;
	}

	public String getPlaceOfSupply() {
		return placeOfSupply;
	}

	public void setPlaceOfSupply(String placeOfSupply) {
		this.placeOfSupply = placeOfSupply;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getQty() {
		return Qty;
	}

	public void setQty(String qty) {
		Qty = qty;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}

	public String getTotal() {
		return Total;
	}

	public void setTotal(String total) {
		Total = total;
	}

	public DispatcherLog getDispatcherLog() {
		return dispatcherLog;
	}

	public void setDispatcherLog(DispatcherLog dispatcherLog) {
		this.dispatcherLog = dispatcherLog;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public String getIsOwnVehicle() {
		return isOwnVehicle;
	}

	public void setIsOwnVehicle(String isOwnVehicle) {
		this.isOwnVehicle = isOwnVehicle;
	}

}
