package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Cables;

public interface CablesService {
	
	public List<Cables> getCables();
	
	public void saveCables(Cables theCables);

	public Cables getCable(int theId);

	public void deleteCable(int theId);

}
