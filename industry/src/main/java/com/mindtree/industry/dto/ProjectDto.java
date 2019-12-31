package com.mindtree.industry.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
@JsonIgnoreType
public class ProjectDto {
	private int projectId;
	private String projectName;
	private int cost;

	@JsonIgnoreProperties(value="projectList")
	private AccountDto account;

	public ProjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectDto(int projectId, String projectName, int cost, AccountDto account) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.cost = cost;
		this.account = account;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}
	
	
}
