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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "elcb")
public class ELCB {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date",length=10,nullable=false)
	private Date date;

	@Column(name = "project_name",length=50,nullable=false)
	private String projectName;

	@Column(name = "safety_status",length=20,nullable=true)
	private String safetyStatus;
	
	@Column(name = "working_status",length=20,nullable=true)
	private String workingStatus;

	@Column(name = "comments",length=100)
	private String comments;

	@Column(name = "updated_by",length=30,nullable=false)
	private String updatedBy;

	//@Temporal(TemporalType.DATE)
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
	@JoinColumn(name = "project_id")
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
	@JoinColumn(name = "user_id")
	private User user;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSafetyStatus() {
		return safetyStatus;
	}

	public void setSafetyStatus(String safetyStatus) {
		this.safetyStatus = safetyStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}

	

	

}
