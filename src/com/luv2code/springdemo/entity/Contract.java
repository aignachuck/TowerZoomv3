package com.luv2code.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contract")
public class Contract {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contract_id")
	private int contractId;
	
	@Column(name="contract_number")
	private String contractNumber;
	
	@Column(name="parent_company")
	private String parentCompany;
	
	@Column(name="primary_rad_center")
	private int primaryRadCenter;
	
	@Column(name="primary_rad_tip")
	private int primaryRadTip;
	
	@Column(name="primary_rad_base")
	private int primaryRadBase;
	
	@Column(name="alternate_rad_center_1")
	private int alternateRadCenter1;
	
	@Column(name="alternate_rad_tip_1")
	private int alternateRadTip1;
	
	@Column(name="alternate_rad_base_1")
	private int alternateRadBase1;
	
	@Column(name="alternate_rad_center_2")
	private int alternateRadCenter2;
	
	@Column(name="alternate_rad_tip_2")
	private int alternateRadTip2;
	
	@Column(name="alternate_rad_base_2")
	private int alternateRadBase2;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})	
	@JoinColumn(name="contract_tower_id")
	private Tower towerContract;
	
	@OneToMany(mappedBy = "contract",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH}, 
			   fetch = FetchType.LAZY)
	private List<Project> contractProjects;

	public Contract() {
		
	}

	public Contract(String contractNumber, String parentCompany, int primaryRadCenter, int primaryRadTip,
			int primaryRadBase, int alternateRadCenter1, int alternateRadTip1, int alternateRadBase1,
			int alternateRadCenter2, int alternateRadTip2, int alternateRadBase2) {
		super();
		this.contractNumber = contractNumber;
		this.parentCompany = parentCompany;
		this.primaryRadCenter = primaryRadCenter;
		this.primaryRadTip = primaryRadTip;
		this.primaryRadBase = primaryRadBase;
		this.alternateRadCenter1 = alternateRadCenter1;
		this.alternateRadTip1 = alternateRadTip1;
		this.alternateRadBase1 = alternateRadBase1;
		this.alternateRadCenter2 = alternateRadCenter2;
		this.alternateRadTip2 = alternateRadTip2;
		this.alternateRadBase2 = alternateRadBase2;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getParentCompany() {
		return parentCompany;
	}

	public void setParentCompany(String parentCompany) {
		this.parentCompany = parentCompany;
	}

	public int getPrimaryRadCenter() {
		return primaryRadCenter;
	}

	public void setPrimaryRadCenter(int primaryRadCenter) {
		this.primaryRadCenter = primaryRadCenter;
	}

	public int getPrimaryRadTip() {
		return primaryRadTip;
	}

	public void setPrimaryRadTip(int primaryRadTip) {
		this.primaryRadTip = primaryRadTip;
	}

	public int getPrimaryRadBase() {
		return primaryRadBase;
	}

	public void setPrimaryRadBase(int primaryRadBase) {
		this.primaryRadBase = primaryRadBase;
	}

	public int getAlternateRadCenter1() {
		return alternateRadCenter1;
	}

	public void setAlternateRadCenter1(int alternateRadCenter1) {
		this.alternateRadCenter1 = alternateRadCenter1;
	}

	public int getAlternateRadTip1() {
		return alternateRadTip1;
	}

	public void setAlternateRadTip1(int alternateRadTip1) {
		this.alternateRadTip1 = alternateRadTip1;
	}

	public int getAlternateRadBase1() {
		return alternateRadBase1;
	}

	public void setAlternateRadBase1(int alternateRadBase1) {
		this.alternateRadBase1 = alternateRadBase1;
	}

	public int getAlternateRadCenter2() {
		return alternateRadCenter2;
	}

	public void setAlternateRadCenter2(int alternateRadCenter2) {
		this.alternateRadCenter2 = alternateRadCenter2;
	}

	public int getAlternateRadTip2() {
		return alternateRadTip2;
	}

	public void setAlternateRadTip2(int alternateRadTip2) {
		this.alternateRadTip2 = alternateRadTip2;
	}

	public int getAlternateRadBase2() {
		return alternateRadBase2;
	}

	public void setAlternateRadBase2(int alternateRadBase2) {
		this.alternateRadBase2 = alternateRadBase2;
	}

	public Tower getTowerContract() {
		return towerContract;
	}

	public void setTowerContract(Tower tower) {
		this.towerContract = tower;
	}

		
	public List<Project> getContractProjects() {
		return contractProjects;
	}

	public void setContractProjects(List<Project> contractProjects) {
		this.contractProjects = contractProjects;
	}
	
	

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractNumber=" + contractNumber + ", parentCompany="
				+ parentCompany + ", primaryRadCenter=" + primaryRadCenter + ", primaryRadTip=" + primaryRadTip
				+ ", primaryRadBase=" + primaryRadBase + ", alternateRadCenter1=" + alternateRadCenter1
				+ ", alternateRadTip1=" + alternateRadTip1 + ", alternateRadBase1=" + alternateRadBase1
				+ ", alternateRadCenter2=" + alternateRadCenter2 + ", alternateRadTip2=" + alternateRadTip2
				+ ", alternateRadBase2=" + alternateRadBase2 + ", towerContract=" + towerContract
				+ ", contractProjects=" + contractProjects + "]";
	}
	
	//helper class for new contracts
	public void addContractProject(Project tempContractProject) {
		if(contractProjects == null) {
			contractProjects = new ArrayList<>();
			
		}
		
		contractProjects.add(tempContractProject);
		
		tempContractProject.setContract(this);
	}
	
	
	
	
	
	

}
