package com.mindtree.industry.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Ig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int igId;
	private String igName;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy= "ig")
	@JsonIgnoreProperties(value="ig")
	private List<Account>accountList;


	public Ig() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ig(int igId, String igName, List<Account> accountList) {
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


	public List<Account> getAccountList() {
		return accountList;
	}


	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	
	

}
