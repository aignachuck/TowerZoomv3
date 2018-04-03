package com.luv2code.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@Column(name="tower_reference_id")
	private int towerId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})	
	@JoinColumn(name="tower_reference_id", insertable=false, updatable=false)
	private Tower tower;
	
	//need insertable/updatable = False?
	
	
	public Project() {
			
	}


	public Project(String projectType, String carrierName, String contactCompany, String contactFirstName,
			String contactLastName, String contactEmail, int towerId) {
		super();
		this.projectType = projectType;
		this.carrierName = carrierName;
		this.contactCompany = contactCompany;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactEmail = contactEmail;
		this.towerId = towerId;
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


	public int getTowerId() {
		return towerId;
	}


	public void setTowerId(int towerId) {
		this.towerId = towerId;
	}
	

	public Tower getTower() {
		return tower;
	}


	public void setTower(Tower tower) {
		this.tower = tower;
	}


	@Override
	public String toString() {
		return "Project [projectNumber=" + projectNumber + ", projectType=" + projectType + ", carrierName="
				+ carrierName + ", contactCompany=" + contactCompany + ", contactFirstName=" + contactFirstName
				+ ", contactLastName=" + contactLastName + ", contactEmail=" + contactEmail + ", towerId=" + towerId
				+ "]";
	}
	

		
	
}
