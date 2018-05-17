package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Equipment;



public interface EquipmentService {
	
	public List<Equipment> getEquipments();
	
	public void saveEquipment(Equipment theEquipment);

	public Equipment getEquipment(int theId);

	public void deleteEquipment(int theId);

}
