package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Project;
import com.luv2code.springdemo.entity.Tower;

public interface ProjectDAO {
	
	public List<Project> getProjects();

	public void saveProject(Project theProject);

	public Project getProject(int theId);

	public void deleteProject(int theId);
	

}
