package com.mindtree.industry.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
@JsonIgnoreType
@Entity
public class Project {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int projectId;
private String projectName;
private int cost;

@ManyToOne(cascade=CascadeType.ALL)
//@JsonIgnoreProperties(value="projectList")
private Account account;

public Project() {
	super();
	// TODO Auto-generated constructor stub
}

public Project(int projectId, String projectName, int cost, Account account) {
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

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}


}
