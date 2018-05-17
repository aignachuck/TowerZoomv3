package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CablesDAO;
import com.luv2code.springdemo.entity.Cables;

@Service
public class CablesServiceImpl implements CablesService {
	
	@Autowired
	private CablesDAO cablesDAO;

	@Override
	@Transactional
	public List<Cables> getCables() {
		return cablesDAO.getCables();
	}

	@Override
	@Transactional
	public void saveCables(Cables theCables) {
		cablesDAO.saveCables(theCables);
	}

	@Override
	@Transactional
	public Cables getCable(int theId) {
		return cablesDAO.getCable(theId);
	}

	@Override
	@Transactional
	public void deleteCable(int theId) {
		cablesDAO.deleteCable(theId);
	}

}
