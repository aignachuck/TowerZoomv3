package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Equipment;

public interface EquipmentDAO {
	
	public List<Equipment> getEquipments();
	
	public void saveEquipment(Equipment theEquipment);

	public Equipment getEquipment(int theId);

	public void deleteEquipment(int theId);

}
