package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Cables;

@Repository
public class CablesDAOImpl implements CablesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Cables> getCables() {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Cables> theQuery = 
				currentSession.createQuery("from Cables order by cableId", Cables.class);
		
		//execute query and get results
		List<Cables> cables = theQuery.getResultList();
		
		return cables;
	}

	@Override
	public void saveCables(Cables theCables) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the equipment
		currentSession.saveOrUpdate(theCables);
	}

	@Override
	public Cables getCable(int theId) {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve data using primary key
		Cables theCables = currentSession.get(Cables.class, theId);
		
		return theCables;
		
	}

	@Override
	public void deleteCable(int theId) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//run query to find the equipment
		Query theQuery = currentSession.createQuery("delete from Cables where cableId=:inputId");
		theQuery.setParameter("inputId", theId);
		
		//execute query to delete
		theQuery.executeUpdate();
	}

}
