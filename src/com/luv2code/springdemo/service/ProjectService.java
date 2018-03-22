package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Project;

public interface ProjectService {
	
	public List<Project> getProjects();
	
	public void saveProject(Project theProject);

}
