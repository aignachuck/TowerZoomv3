package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.EquipmentDAO;
import com.luv2code.springdemo.entity.Equipment;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentDAO equipmentDAO;

	@Override
	@Transactional
	public List<Equipment> getEquipments() {
		return equipmentDAO.getEquipments();
	}

	@Override
	@Transactional
	public void saveEquipment(Equipment theEquipment) {
		equipmentDAO.saveEquipment(theEquipment);
	}

	@Override
	@Transactional
	public Equipment getEquipment(int theId) {
		return equipmentDAO.getEquipment(theId);
	}

	@Override
	@Transactional
	public void deleteEquipment(int theId) {
		equipmentDAO.deleteEquipment(theId);
	}

}
