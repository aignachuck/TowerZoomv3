package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.GroundDAO;
import com.luv2code.springdemo.entity.Ground;

@Service
public class GroundServiceImpl implements GroundService {
	
	@Autowired
	private GroundDAO groundDAO;

	@Override
	@Transactional
	public List<Ground> getGrounds() {
		return groundDAO.getGrounds();
	}

	@Override
	@Transactional
	public void saveGround(Ground theGround) {
		groundDAO.saveGround(theGround);
	}

	@Override
	@Transactional
	public Ground getGround(int theId) {
		return groundDAO.getGround(theId);
	}

	@Override
	@Transactional
	public void deleteGround(int theId) {
		groundDAO.deleteGround(theId);
	}

}
