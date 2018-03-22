package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Tower;

public interface TowerService {

	public List<Tower> getTowers();
	
	public void saveTower(Tower theTower);

	public Tower getTower(int theId);

	public void deleteTower(int theId);
}
