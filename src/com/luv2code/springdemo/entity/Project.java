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

import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.springdemo.service.ProjectService;

@Entity
@Table(name="project_setup")
public class Project {	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_number")
	private int projectNumber;
	
	@Column(name="project_type")
	private String projectType;
	
	@Column(name="carrier_name")
	private String carrierName;
	
	@Column(name="contact_company")
	private String contactCompany;
	
	@Column(name="contact_first_name")
	private String contactFirstName;
	
	@Column(name="contact_last_name")
	private String contactLastName;
	
	@Column(name="contact_email")
	private String contactEmail;
	
	@Column(name="pricing")
	private double pricing;
	
	

	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})	
	@JoinColumn(name="tower_reference_id")
	private Tower tower;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="contract_reference_id")
	private Contract contract;
	
	@OneToMany(mappedBy = "equipmentProject",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	private List<Equipment> equipment;
	
	@OneToMany(mappedBy = "cablesProject",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	private List<Cables> cables;
	
	@OneToMany(mappedBy = "groundProject",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	private List<Ground> ground;
	
	
	
	public Project() {
			
	}

	

	public Project(int projectNumber, String projectType, String carrierName, String contactCompany,
			String contactFirstName, String contactLastName, String contactEmail, double pricing) {
		super();
		this.projectNumber = projectNumber;
		this.projectType = projectType;
		this.carrierName = carrierName;
		this.contactCompany = contactCompany;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactEmail = contactEmail;
		this.pricing = pricing;
	}





	public int getProjectNumber() {
		return projectNumber;
	}


	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}


	public String getProjectType() {
		return projectType;
	}


	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}


	public String getCarrierName() {
		return carrierName;
	}


	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	public String getContactCompany() {
		return contactCompany;
	}


	public void setContactCompany(String contactCompany) {
		this.contactCompany = contactCompany;
	}


	public String getContactFirstName() {
		return contactFirstName;
	}


	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}


	public String getContactLastName() {
		return contactLastName;
	}


	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	

	public Tower getTower() {
		return tower;
	}


	public void setTower(Tower tower) {
		this.tower = tower;
	}


	public Contract getContract() {
		return contract;
	}


	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	
	public List<Equipment> getEquipment() {
		return equipment;
	}


	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}


	public List<Cables> getCables() {
		return cables;
	}


	public void setCables(List<Cables> cables) {
		this.cables = cables;
	}


	public List<Ground> getGround() {
		return ground;
	}


	public void setGround(List<Ground> ground) {
		this.ground = ground;
	}
	
	
	public double getPricing() {
		
		return pricing;
	}


	public void setPricing(double pricing) {
		
		this.pricing = pricing;
	}
		

	@Override
	public String toString() {
		return "Project [projectNumber=" + projectNumber + ", projectType=" + projectType + ", carrierName="
				+ carrierName + ", contactCompany=" + contactCompany + ", contactFirstName=" + contactFirstName
				+ ", contactLastName=" + contactLastName + ", contactEmail=" + contactEmail + ", pricing=" + pricing
				+ "]";
	}



		//helper class for new equipment
		public void addEquipment(Equipment tempEquipment) {
			if(equipment == null) {
				equipment = new ArrayList<>();
				
			}
			
			equipment.add(tempEquipment);
			
			tempEquipment.setEquipmentProject(this);
		}
		
		//helper class for new cables
		public void addCables(Cables tempCables) {
			if(cables == null) {
				cables = new ArrayList<>();
				
			}
			
			cables.add(tempCables);
			
			tempCables.setCablesProject(this);
		}
		
		//helper class for new ground
		public void addGround(Ground tempGround) {
			if(ground == null) {
				ground = new ArrayList<>();
				
			}
			
			ground.add(tempGround);
			
			tempGround.setGroundProject(this);
		}
		
	
}

//Copyright 2018, Alex Ignachuck, All rights reserved

