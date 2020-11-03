package com.fa.inventory.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 100, unique = true, nullable = false)
	private String roleName;

	@Column(name = "status", length = 8, nullable = false)
	private String status;

	@Column(name = "action")
	private String action;

	/*
	 * @Column(name = "pages") private String pages;
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 19, nullable = false)
	private Date creationDate;

	@Column(name = "created_by", length = 30, nullable = false)
	private String createdBy;

	@Column(name = "last_modified_by", length = 30, nullable = false)
	private String lastModifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modification_date", length = 19, nullable = false)
	private Date modificationDate;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "role_fk_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_fk_id") })
	private Set<User> user = new HashSet<User>();

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "role_id")
	private List<Menu> menuItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public List<Menu> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(List<Menu> menuItem) {
		this.menuItem = menuItem;
	}

}
