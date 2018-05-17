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
@Table(name="project_equipment")
public class Equipment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="equipment_id")
	private int equipmentId;
	
	@Column(name="equipment_type")
	private String equipmentType;
	
	@Column(name="equipment_quantity")
	private int equipmentQuantity;
	
	@Column(name="equipment_manufacturer")
	private String equipmentManufacturer;
	
	@Column(name="equipment_model")
	private String equipmentModel;
	
	@Column(name="equipment_height")
	private double equipmentHeight;
	
	@Column(name="equipment_width")
	private double equipmentWidth;
	
	@Column(name="equipment_depth")
	private double equipmentDepth;
	
	@Column(name="equipment_weight")
	private double equipmentWeight;
	
	@Column(name="equipment_rad")
	private double equipmentRad;
	
	@Column(name="mount_type")
	private String mountType;
	
	@Column(name="azimuths")
	private String azimuths;
	
	@Column(name="count_per_azimuth")
	private String countPerAzimuth;
	
	@Column(name="tx_frequency")
	private String txFrequency;
	
	@Column(name="rx_frequency")
	private String rxFrequency;
	
	//project reference
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})	
	@JoinColumn(name="project_equipment_reference_id")
	private Project equipmentProject;
	
	
	public Equipment() {
		
	}

	public Equipment(String equipmentType, int equipmentQuantity, String equipmentManufacturer, String equipmentModel,
			double equipmentHeight, double equipmentWidth, double equipmentDepth, double equipmentWeight,
			double equipmentRad, String mountType, String azimuths, String countPerAzimuth, String txFrequency,
			String rxFrequency) {
		super();
		this.equipmentType = equipmentType;
		this.equipmentQuantity = equipmentQuantity;
		this.equipmentManufacturer = equipmentManufacturer;
		this.equipmentModel = equipmentModel;
		this.equipmentHeight = equipmentHeight;
		this.equipmentWidth = equipmentWidth;
		this.equipmentDepth = equipmentDepth;
		this.equipmentWeight = equipmentWeight;
		this.equipmentRad = equipmentRad;
		this.mountType = mountType;
		this.azimuths = azimuths;
		this.countPerAzimuth = countPerAzimuth;
		this.txFrequency = txFrequency;
		this.rxFrequency = rxFrequency;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public int getEquipmentQuantity() {
		return equipmentQuantity;
	}

	public void setEquipmentQuantity(int equipmentQuantity) {
		this.equipmentQuantity = equipmentQuantity;
	}

	public String getEquipmentManufacturer() {
		return equipmentManufacturer;
	}

	public void setEquipmentManufacturer(String equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public double getEquipmentHeight() {
		return equipmentHeight;
	}

	public void setEquipmentHeight(double equipmentHeight) {
		this.equipmentHeight = equipmentHeight;
	}

	public double getEquipmentWidth() {
		return equipmentWidth;
	}

	public void setEquipmentWidth(double equipmentWidth) {
		this.equipmentWidth = equipmentWidth;
	}

	public double getEquipmentDepth() {
		return equipmentDepth;
	}

	public void setEquipmentDepth(double equipmentDepth) {
		this.equipmentDepth = equipmentDepth;
	}

	public double getEquipmentWeight() {
		return equipmentWeight;
	}

	public void setEquipmentWeight(double equipmentWeight) {
		this.equipmentWeight = equipmentWeight;
	}

	public double getEquipmentRad() {
		return equipmentRad;
	}

	public void setEquipmentRad(double equipmentRad) {
		this.equipmentRad = equipmentRad;
	}

	public String getMountType() {
		return mountType;
	}

	public void setMountType(String mountType) {
		this.mountType = mountType;
	}

	public String getAzimuths() {
		return azimuths;
	}

	public void setAzimuths(String azimuths) {
		this.azimuths = azimuths;
	}

	public String getCountPerAzimuth() {
		return countPerAzimuth;
	}

	public void setCountPerAzimuth(String countPerAzimuth) {
		this.countPerAzimuth = countPerAzimuth;
	}

	public String getTxFrequency() {
		return txFrequency;
	}

	public void setTxFrequency(String txFrequency) {
		this.txFrequency = txFrequency;
	}

	public String getRxFrequency() {
		return rxFrequency;
	}

	public void setRxFrequency(String rxFrequency) {
		this.rxFrequency = rxFrequency;
	}

	public Project getEquipmentProject() {
		return equipmentProject;
	}

	public void setEquipmentProject(Project equipmentProject) {
		this.equipmentProject = equipmentProject;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentType=" + equipmentType + ", equipmentQuantity="
				+ equipmentQuantity + ", equipmentManufacturer=" + equipmentManufacturer + ", equipmentModel="
				+ equipmentModel + ", equipmentHeight=" + equipmentHeight + ", equipmentWidth=" + equipmentWidth
				+ ", equipmentDepth=" + equipmentDepth + ", equipmentWeight=" + equipmentWeight + ", equipmentRad="
				+ equipmentRad + ", mountType=" + mountType + ", azimuths=" + azimuths + ", countPerAzimuth="
				+ countPerAzimuth + ", txFrequency=" + txFrequency + ", rxFrequency=" + rxFrequency
				+ ", equipmentProject=" + equipmentProject + "]";
	}




	
	
	
	
	
	
	
}
