package com.fa.inventory.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "warehouse_blocks")
public class WareHouseBlocks {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*
	 * @Column(name = "warehouse_name") private String wareHouseName;
	 */
	@Column(name = "blocks_names", length = 30, nullable = false)
	private String blocksNames;

	@Column(name = "code", unique = true, length = 3, nullable = false)
	private String code;

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

	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private WareHouse wareHouse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlocksNames() {
		return blocksNames;
	}

	public void setBlocksNames(String blocksNames) {
		this.blocksNames = blocksNames;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public WareHouse getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
}
