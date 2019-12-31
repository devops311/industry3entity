package com.mindtree.industry.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
@JsonIgnoreType
public class AccountDto {

	private int accID;
	private String aacName;
	private int revenue;
	
	//@JsonIgnoreProperties(value="ig")
	private List<ProjectDto>projectlist;
	

	@JsonIgnoreProperties(value="accountList")
	private IgDto ig;


	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountDto(int accID, String aacName, int revenue, List<ProjectDto> projectlist, IgDto ig) {
		super();
		this.accID = accID;
		this.aacName = aacName;
		this.revenue = revenue;
		this.projectlist = projectlist;
		this.ig = ig;
	}


	public int getAccID() {
		return accID;
	}


	public void setAccID(int accID) {
		this.accID = accID;
	}


	public String getAacName() {
		return aacName;
	}


	public void setAacName(String aacName) {
		this.aacName = aacName;
	}


	public int getRevenue() {
		return revenue;
	}


	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}


	public List<ProjectDto> getProjectlist() {
		return projectlist;
	}


	public void setProjectlist(List<ProjectDto> projectlist) {
		this.projectlist = projectlist;
	}


	public IgDto getIg() {
		return ig;
	}


	public void setIg(IgDto ig) {
		this.ig = ig;
	}
	
	
}
