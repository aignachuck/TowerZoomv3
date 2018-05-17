package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Ground;

public interface GroundDAO {
	
	public List<Ground> getGrounds();
	
	public void saveGround(Ground theGround);

	public Ground getGround(int theId);

	public void deleteGround(int theId);

}
