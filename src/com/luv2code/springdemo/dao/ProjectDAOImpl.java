package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Project;
import com.luv2code.springdemo.entity.Tower;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	
	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Project> getProjects() {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Project> theQuery = 
				currentSession.createQuery("from Project order by projectNumber", Project.class);
		
		//execute query and get results list
		List<Project> projects = theQuery.getResultList();
		
		//return the results	
		
		return projects;
	}

	@Override
	public void saveProject(Project theProject) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the project to the database
		currentSession.saveOrUpdate(theProject);
	}
	


	@Override
	public Project getProject(int theId) {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve from database using the primary key
		Project theProject = currentSession.get(Project.class, theId);
		
		return theProject;
	}

	@Override
	public void deleteProject(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//run query to find the project
		Query theQuery = currentSession.createQuery("delete from Project where projectNumber=:inputId");
		theQuery.setParameter("inputId", theId);
		
		//execute query to delete the project
		theQuery.executeUpdate();
	}


}
