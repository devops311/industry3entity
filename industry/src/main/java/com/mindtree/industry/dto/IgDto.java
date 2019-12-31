package com.mindtree.industry.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class IgDto {
	private int igId;
	private String igName;
	

	@JsonIgnoreProperties(value="ig")
	private List<AccountDto>accountList;


	public IgDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IgDto(int igId, String igName, List<AccountDto> accountList) {
		super();
		this.igId = igId;
		this.igName = igName;
		this.accountList = accountList;
	}


	public int getIgId() {
		return igId;
	}


	public void setIgId(int igId) {
		this.igId = igId;
	}


	public String getIgName() {
		return igName;
	}


	public void setIgName(String igName) {
		this.igName = igName;
	}


	public List<AccountDto> getAccountList() {
		return accountList;
	}


	public void setAccountList(List<AccountDto> accountList) {
		this.accountList = accountList;
	}
	
}
