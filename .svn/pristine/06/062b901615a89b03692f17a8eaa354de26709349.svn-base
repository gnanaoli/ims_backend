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
	@Table(name = "project_tasks")
	public class ProjectTasks {

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "task_name", length = 100, nullable = true)
		private String TaskName;
		
		
		@Temporal(TemporalType.DATE)
		@Column(name = "start_date", length = 10, nullable = false)
		private Date startDate;

		@Temporal(TemporalType.DATE)
		@Column(name = "end_date", length = 10, nullable = false)
		private Date endDate;
		
		@Column(name = "duration", length = 5, nullable = false)
		private Integer duration;
		
		@Column(name = "assigned_to", length = 20, nullable = true)
		private String assignedTo;
		
		@Column(name = "resource_count", length = 5, nullable = false)
		private Integer resourceCount;

		@Column(name = "comments", length = 100, nullable = false)
		private String comments;
		


		@Column(name = "status", length = 16, nullable = false)
		private String status;
		
		@Column(name = "is_active", length = 10, nullable = false)
		private String isActive;
		

		@Column(name = "is_new", length = 10, nullable = false)
		private String isNew;
		
		@Column(name = "task_id", length = 100, nullable = false)
		private String taskId;

		@Column(name = "created_by", length = 30, nullable = false)
		private String createdBy;

		// @Temporal(TemporalType.DATE)
		@Column(name = "creation_date", length = 19, nullable = false)
		private Timestamp creationDate;

		// @Temporal(TemporalType.DATE)
		@Column(name = "last_modified_date", length = 19, nullable = false)
		private Timestamp lastModifiedDate;

		@Column(name = "last_modified_by", length = 30, nullable = false)
		private String lastModifiedBy;
		
		@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
		@JoinColumn(name = "project_id")
		private Project project;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTaskName() {
			return TaskName;
		}

		public void setTaskName(String taskName) {
			TaskName = taskName;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Integer getDuration() {
			return duration;
		}

		public void setDuration(Integer duration) {
			this.duration = duration;
		}

		public String getAssignedTo() {
			return assignedTo;
		}

		public void setAssignedTo(String assignedTo) {
			this.assignedTo = assignedTo;
		}

		public Integer getResourceCount() {
			return resourceCount;
		}

		public void setResourceCount(Integer resourceCount) {
			this.resourceCount = resourceCount;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		

		public String getIsActive() {
			return isActive;
		}

		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}
		

		public String getIsNew() {
			return isNew;
		}

		public void setIsNew(String isNew) {
			this.isNew = isNew;
		}

		public String getTaskId() {
			return taskId;
		}

		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public Timestamp getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Timestamp creationDate) {
			this.creationDate = creationDate;
		}

		public Timestamp getLastModifiedDate() {
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

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

		
		
		



}
