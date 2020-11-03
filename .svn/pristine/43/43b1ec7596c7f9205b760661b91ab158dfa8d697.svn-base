package com.fa.inventory.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sms_template")
public class SMSTemplate {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sms_type", length = 50, nullable = false)
	private String smsType;

	@Column(name = "sms_content", length = 300, nullable = false)
	private String sms_Content;

	@Column(name = "status", length = 8, nullable = false)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effective_start_date", length = 19, nullable = false)
	private Date effectiveStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effective_end_date", length = 19, nullable = false)
	private Date effectiveEndDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getSms_Content() {
		return sms_Content;
	}

	public void setSms_Content(String sms_Content) {
		this.sms_Content = sms_Content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Timestamp effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Timestamp effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

}
