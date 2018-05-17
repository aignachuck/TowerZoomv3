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
@Table(name="project_cables")
public class Cables {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cable_id")
	private int cableId;
	
	@Column(name="cable_type")
	private String cableType;
	
	@Column(name="cable_quantity")
	private int cableQuantity;
	
	@Column(name="cable_diameter")
	private double cableDiameter;
	
	@Column(name="cable_per_sector")
	private String cablePerSector;
	
	@Column(name="cable_configuration")
	private String cableConfiguration;
	
	//project reference
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})	
	@JoinColumn(name="project_cable_reference_id")
	private Project cablesProject;

	public Cables() {
		
	}

	public Cables(String cableType, int cableQuantity, double cableDiameter, String cablePerSector,
			String cableConfiguration) {
		super();
		this.cableType = cableType;
		this.cableQuantity = cableQuantity;
		this.cableDiameter = cableDiameter;
		this.cablePerSector = cablePerSector;
		this.cableConfiguration = cableConfiguration;
	}

	public int getCableId() {
		return cableId;
	}

	public void setCableId(int cableId) {
		this.cableId = cableId;
	}

	public String getCableType() {
		return cableType;
	}

	public void setCableType(String cableType) {
		this.cableType = cableType;
	}

	public int getCableQuantity() {
		return cableQuantity;
	}

	public void setCableQuantity(int cableQuantity) {
		this.cableQuantity = cableQuantity;
	}

	public double getCableDiameter() {
		return cableDiameter;
	}

	public void setCableDiameter(double cableDiameter) {
		this.cableDiameter = cableDiameter;
	}

	public String getCablePerSector() {
		return cablePerSector;
	}

	public void setCablePerSector(String cablePerSector) {
		this.cablePerSector = cablePerSector;
	}

	public String getCableConfiguration() {
		return cableConfiguration;
	}

	public void setCableConfiguration(String cableConfiguration) {
		this.cableConfiguration = cableConfiguration;
	}



	public Project getCablesProject() {
		return cablesProject;
	}

	public void setCablesProject(Project cablesProject) {
		this.cablesProject = cablesProject;
	}

	@Override
	public String toString() {
		return "Cables [cableId=" + cableId + ", cableType=" + cableType + ", cableQuantity=" + cableQuantity
				+ ", cableDiameter=" + cableDiameter + ", cablePerSector=" + cablePerSector + ", cableConfiguration="
				+ cableConfiguration + ", cablesProject=" + cablesProject + "]";
	}





	
	
	
	
}
