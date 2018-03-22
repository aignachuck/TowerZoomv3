package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Project;

public interface ProjectDAO {
	
	public List<Project> getProjects();

	public void saveProject(Project theProject);

}
