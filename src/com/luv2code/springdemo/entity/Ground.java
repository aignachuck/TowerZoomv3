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
@Table(name="project_ground")
public class Ground {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ground_id")
	private int groundId;
	
	@Column(name="ground_primary")
	private String groundPrimary;
	
	@Column(name="ground_space_type")
	private String groundSpaceType;
	
	@Column(name="ground_space_length")
	private double groundSpaceLength;
	
	@Column(name="ground_space_width")
	private double groundSpaceWidth;
	
	@Column(name="ground_area")
	private double groundArea;
	
	//project reference
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})	
	@JoinColumn(name="project_ground_reference_id")
	private Project groundProject;
	
	
	public Ground() {
		
	}

	public Ground(String groundPrimary, String groundSpaceType, double groundSpaceLength, double groundSpaceWidth,
			double groundArea) {
		super();
		this.groundPrimary = groundPrimary;
		this.groundSpaceType = groundSpaceType;
		this.groundSpaceLength = groundSpaceLength;
		this.groundSpaceWidth = groundSpaceWidth;
		this.groundArea = groundArea;
	}

	public int getGroundId() {
		return groundId;
	}

	public void setGroundId(int groundId) {
		this.groundId = groundId;
	}

	public String getGroundPrimary() {
		return groundPrimary;
	}

	public void setGroundPrimary(String groundPrimary) {
		this.groundPrimary = groundPrimary;
	}

	public String getGroundSpaceType() {
		return groundSpaceType;
	}

	public void setGroundSpaceType(String groundSpaceType) {
		this.groundSpaceType = groundSpaceType;
	}

	public double getGroundSpaceLength() {
		return groundSpaceLength;
	}

	public void setGroundSpaceLength(double groundSpaceLength) {
		this.groundSpaceLength = groundSpaceLength;
	}

	public double getGroundSpaceWidth() {
		return groundSpaceWidth;
	}

	public void setGroundSpaceWidth(double groundSpaceWidth) {
		this.groundSpaceWidth = groundSpaceWidth;
	}

	public double getGroundArea() {
		return groundArea;
	}

	public void setGroundArea(double groundArea) {
		this.groundArea = groundArea;
	}

	public Project getGroundProject() {
		return groundProject;
	}

	public void setGroundProject(Project groundProject) {
		this.groundProject = groundProject;
	}

	@Override
	public String toString() {
		return "Ground [groundId=" + groundId + ", groundPrimary=" + groundPrimary + ", groundSpaceType="
				+ groundSpaceType + ", groundSpaceLength=" + groundSpaceLength + ", groundSpaceWidth="
				+ groundSpaceWidth + ", groundArea=" + groundArea + ", groundProject=" + groundProject + "]";
	}



	
		
	
	

}
