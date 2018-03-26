package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.TowerDAO;
import com.luv2code.springdemo.entity.Tower;

@Service
public class TowerServiceImpl implements TowerService {

	@Autowired
	private TowerDAO towerDAO;
	
	@Override
	@Transactional
	public List<Tower> getTowers() {
		return towerDAO.getTowers();
	}

	@Override
	@Transactional
	public void saveTower(Tower theTower) {

		towerDAO.saveTower(theTower);
	}

	@Override
	@Transactional
	public Tower getTower(int theId) {
		
		
		return towerDAO.getTower(theId);
	}

	@Override
	@Transactional
	public void deleteTower(int theId) {
		towerDAO.deleteTower(theId);
		
	}

	@Override
	@Transactional
	public int confirmTower(int theNumber) {

		return towerDAO.confirmTower(theNumber);
	}

}
