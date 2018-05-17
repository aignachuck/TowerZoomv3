package com.luv2code.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Cables;
import com.luv2code.springdemo.entity.Ground;

@Repository
public class GroundDAOImpl implements GroundDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Ground> getGrounds() {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Ground> theQuery = 
				currentSession.createQuery("from Ground order by groundId", Ground.class);
		
		//execute query and get results
		List<Ground> grounds = theQuery.getResultList();
		
		return grounds;
	}

	@Override
	public void saveGround(Ground theGround) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the equipment
		currentSession.saveOrUpdate(theGround);
	}

	@Override
	public Ground getGround(int theId) {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve data using primary key
		Ground theGround = currentSession.get(Ground.class, theId);
		
		return theGround;
		
	}

	@Override
	public void deleteGround(int theId) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//run query to find the equipment
		Query theQuery = currentSession.createQuery("delete from Ground where groundId=:inputId");
		theQuery.setParameter("inputId", theId);
		
		//execute query to delete
		theQuery.executeUpdate();
	}

}
