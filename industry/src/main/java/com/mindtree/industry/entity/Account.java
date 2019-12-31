package com.mindtree.industry.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.omg.CORBA.OMGVMCID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
@Entity
public class Account implements Comparable<Account> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accID;
	private String aacName;
	private int revenue;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	// @JsonIgnoreProperties(value="ig")
	private List<Project> projectlist;

	@ManyToOne
	@JsonIgnoreProperties(value = "accountList")
	private Ig ig;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accID, String aacName, int revenue, List<Project> projectlist, Ig ig) {
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

	public List<Project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(List<Project> projectlist) {
		this.projectlist = projectlist;
	}

	public Ig getIg() {
		return ig;
	}

	public void setIg(Ig ig) {
		this.ig = ig;
	}

	@Override
	public int compareTo(Account o) {
		int res = 0;
		res = this.getRevenue() - o.getRevenue();
		if (res == 0) {
			res = this.getRevenue() - o.getRevenue();

		}
		return res;
	}

}
