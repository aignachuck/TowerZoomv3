package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Contract;

@Repository
public class ContractDAOImpl implements ContractDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Contract> getContracts() {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query
		Query<Contract> theQuery = 
					currentSession.createQuery("from Contract order by contractId", Contract.class);
				
		//execute query and get results list
		List<Contract> contracts = theQuery.getResultList();
				
		//return the results				
		return contracts;
	}

	@Override
	public void saveContract(Contract theContract) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theContract);
	}

	@Override
	public Contract getContract(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Contract theContract = currentSession.get(Contract.class, theId);
		
		return theContract;
	}

	@Override
	public void deleteContract(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//run query to find the project
		Query theQuery = currentSession.createQuery("delete from Contract where contractId=:inputId");
						 theQuery.setParameter("inputId", theId);
				
		//execute query to delete the project
		theQuery.executeUpdate();
	}

}
