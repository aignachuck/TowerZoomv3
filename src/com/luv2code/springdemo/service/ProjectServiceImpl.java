package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProjectDAO;
import com.luv2code.springdemo.entity.Project;
import com.luv2code.springdemo.entity.Tower;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	@Transactional
	public List<Project> getProjects() {
		return projectDAO.getProjects();
	}

	@Override
	@Transactional
	public void saveProject(Project theProject) {

		projectDAO.saveProject(theProject);
	}



	@Override
	@Transactional
	public Project getProject(int theId) {
		Project theProject = new Project();
		Tower theTower = new Tower();
		int towerId = 0;
		
		theProject = projectDAO.getProject(theId);
		
		if(theProject.getTowerId() != 0) {
			towerId = theTower.getTowerId();
			theProject.setTowerId(towerId);
		}
	
		return theProject;
	}
	
	@Override
	@Transactional
	public void deleteProject(int theId) {
		projectDAO.deleteProject(theId);
	}
	

}
