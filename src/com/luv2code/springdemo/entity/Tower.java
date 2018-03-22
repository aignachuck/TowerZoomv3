package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tower_detail")
public class Tower {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tower_id")
	private int towerId;
	
	@Column(name="tower_number")
	private int towerNumber;
	
	@Column(name="tower_name")
	private String towerName;
	
	@Column(name="tower_portfolio")
	private String towerPortfolio;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	public Tower() {
		
	}

	public Tower(int towerNumber, String towerName, String towerPortfolio, String city, String state) {
		super();
		this.towerNumber = towerNumber;
		this.towerName = towerName;
		this.towerPortfolio = towerPortfolio;
		this.city = city;
		this.state = state;
	}

	public int getTowerId() {
		return towerId;
	}

	public void setTowerId(int towerId) {
		this.towerId = towerId;
	}

	public int getTowerNumber() {
		return towerNumber;
	}

	public void setTowerNumber(int towerNumber) {
		this.towerNumber = towerNumber;
	}

	public String getTowerName() {
		return towerName;
	}

	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}

	public String getTowerPortfolio() {
		return towerPortfolio;
	}

	public void setTowerPortfolio(String towerPortfolio) {
		this.towerPortfolio = towerPortfolio;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Tower [towerId=" + towerId + ", towerNumber=" + towerNumber + ", towerName=" + towerName
				+ ", towerPortfolio=" + towerPortfolio + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
