package com.fa.inventory.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_type", length = 20, nullable = false)
	private String userType;

	@Column(name = "user_id", unique = true, length = 15, nullable = false)
	private String userId;

	@Column(name = "emp_id", length = 10, nullable = false)
	private String empid;

	@Column(name = "user_name", length = 100, nullable = false)
	private String userName;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "confirmPassword", length = 50, nullable = false)
	private String confirmPassword;

	@Column(name = "created_by", length = 30, nullable = false)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", length = 19, nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19, nullable = true)
	private Date lastModifiedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_date_time", length = 19, nullable = true)
	private Date lastLoginDateTime;

	@Column(name = "last_modified_by", length = 30, nullable = false)
	private String lastModifiedBy;

	@Column(name = "first_login")
	private String firstLogin;

	@Column(name = "secret_question", length = 100)
	private String secretQuestion;

	@Column(name = "secret_answer", length = 100)
	private String secretAnswer;

	@Column(name = "role_type")
	private String roleType;

	@Column(name = "theme")
	private String theme;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinTable(name = "user_project", joinColumns = { @JoinColumn(name = "user_fk_id") }, inverseJoinColumns = {
			@JoinColumn(name = "project_fk_id") })
	private List<Project> projectItem = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, })
	@JoinTable(name = "user_warehouse", joinColumns = { @JoinColumn(name = "user_fk_id") }, inverseJoinColumns = {
			@JoinColumn(name = "warehouse_fk_id") })
	private List<WareHouse> wareHouseItem = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, })
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_fk_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_fk_id") })
	private Set<Role> roles = new HashSet<Role>();

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	


	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public List<Project> getProjectItem() {
		return projectItem;
	}

	public void setProjectItem(List<Project> projectItem) {
		this.projectItem = projectItem;
	}

	public List<WareHouse> getWareHouseItem() {
		return wareHouseItem;
	}

	public void setWareHouseItem(List<WareHouse> wareHouseItem) {
		this.wareHouseItem = wareHouseItem;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(String firstLogin) {
		this.firstLogin = firstLogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
