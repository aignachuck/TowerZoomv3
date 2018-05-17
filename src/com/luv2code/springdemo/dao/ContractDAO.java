package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Contract;

public interface ContractDAO {

	public List<Contract> getContracts();

	public void saveContract(Contract theContract);

	public Contract getContract(int theId);

	public void deleteContract(int theId);

}
