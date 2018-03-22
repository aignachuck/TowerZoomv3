package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Tower;

@Repository
public class TowerDAOImpl implements TowerDAO {
	
	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tower> getTowers() {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Tower> theQuery = 
				currentSession.createQuery("from Tower order by towerNumber", Tower.class);
		
		//execute query and get the results list
		List<Tower> towers = theQuery.getResultList();
		
		//return the results
		return towers;
	}

	@Override
	public void saveTower(Tower theTower) {

		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the tower to the database
		currentSession.saveOrUpdate(theTower);
		
		
	}

	@Override
	public Tower getTower(int theId) {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve the tower from the db
		Tower theTower = currentSession.get(Tower.class, theId);
		
		return theTower;
	}

	@Override
	public void deleteTower(int theId) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query to retrieve tower
		Query theQuery = currentSession.createQuery("delete from Tower where towerId=:thisTowerId");
		theQuery.setParameter("thisTowerId", theId);
		
		//execute query to delete tower
		theQuery.executeUpdate();
		
	}

}
