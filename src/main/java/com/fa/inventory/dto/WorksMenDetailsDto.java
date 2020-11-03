package com.fa.inventory.dto;

import java.util.List;

public class WorksMenDetailsDto {

	private Long id;

	private String date;

	private String resourceCount;

	private String comments;

	private String createdBy;

	private String creationDate;

	private List<ProjectDto> projectDto;
	
	private ProjectDto projectDto1;

	private String projectName;

	private String worksMenCategory;

	private List<WorksMenCategoryDto> worksMenCategoryDto;
	
	private WorksMenCategoryDto worksMenCategoryDto1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(String resourceCount) {
		this.resourceCount = resourceCount;
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}



	public List<ProjectDto> getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(List<ProjectDto> projectDto) {
		this.projectDto = projectDto;
	}

	public List<WorksMenCategoryDto> getWorksMenCategoryDto() {
		return worksMenCategoryDto;
	}

	public void setWorksMenCategoryDto(List<WorksMenCategoryDto> worksMenCategoryDto) {
		this.worksMenCategoryDto = worksMenCategoryDto;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getWorksMenCategory() {
		return worksMenCategory;
	}

	public void setWorksMenCategory(String worksMenCategory) {
		this.worksMenCategory = worksMenCategory;
	}

	public ProjectDto getProjectDto1() {
		return projectDto1;
	}

	public void setProjectDto1(ProjectDto projectDto1) {
		this.projectDto1 = projectDto1;
	}

	public WorksMenCategoryDto getWorksMenCategoryDto1() {
		return worksMenCategoryDto1;
	}

	public void setWorksMenCategoryDto1(WorksMenCategoryDto worksMenCategoryDto1) {
		this.worksMenCategoryDto1 = worksMenCategoryDto1;
	}


	

}
