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
	
	
	
	//need to set up a model for the existing tower.
		//get the towerId from that existing tower and set the towerId as the towerReferenceId in the project form
			//then, process the project form as though it is a new tower.
	
	@Override
	public int confirmTower(int theNumber) {
		
		Tower towerOne = new Tower();		
		int theId = 0;
		
		try {
			//get the current session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//retrieve tower from db where towerNumber equals input
			Query<Tower> theQuery = currentSession.createQuery("select towerId from Tower where towerNumber=:inputNumber", Tower.class);
			theQuery.setParameter("inputNumber", theNumber);
			
			//much like the problem on stack overflow, if this !=null then return the towerNumber to a label on the add project page
			//add a try/catch to return that
						
			towerOne = theQuery.uniqueResult();
			
			theId = towerOne.getTowerId();
			
			if (towerOne != null){
				System.out.println("/n-----tower number accepted------");
				return theId;				
			} 
				
			
		}
		catch (Exception e) {
			System.out.println("There was a problem with confirmTower!");
		}
		return theId;
		
		
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
