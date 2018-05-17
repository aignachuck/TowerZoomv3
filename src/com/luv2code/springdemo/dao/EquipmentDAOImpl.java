package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Equipment;

@Repository
public class EquipmentDAOImpl implements EquipmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Equipment> getEquipments() {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Equipment> theQuery = 
				currentSession.createQuery("from Equipment order by equipmentId", Equipment.class);
		
		//execute query and get results
		List<Equipment> equipments = theQuery.getResultList();
		
		return equipments;
	}

	@Override
	public void saveEquipment(Equipment theEquipment) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the equipment
		currentSession.saveOrUpdate(theEquipment);
		
	}

	@Override
	public Equipment getEquipment(int theId) {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve data using primary key
		Equipment theEquipment = currentSession.get(Equipment.class, theId);
		
		return theEquipment;
	}

	@Override
	public void deleteEquipment(int theId) {

		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//run query to find the equipment
		Query theQuery = currentSession.createQuery("delete from Equipment where equipmentId=:inputId");
		theQuery.setParameter("inputId", theId);
		
		//execute query to delete
		theQuery.executeUpdate();
		
	}

}
