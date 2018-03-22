package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Project;
import com.luv2code.springdemo.entity.Tower;
import com.luv2code.springdemo.service.ProjectService;
import com.luv2code.springdemo.service.TowerService;



@Controller
@RequestMapping("/main")
public class ProjectController {
	
	//need to inject service
	
	@Autowired
	private TowerService towerService;
	
	@Autowired
	private ProjectService projectService;
	
	//need a main splash page
	
	@GetMapping("/startPage")
	public String startUp() {
		return "homepage";
	}
	
	
	
	@GetMapping("/towersList")
	public String listTowers(Model theModel) {
		
		//get projects from the service
		List<Tower> theTowers = towerService.getTowers();
		
		//add projects to the model
		theModel.addAttribute("towers", theTowers);
		
		return "tower-list";
	}
	
	@GetMapping("/projectsList")
	public String listProjects(Model theModel) {
		
		//get towers from the service
		List<Project> theProjects = projectService.getProjects();
		
		//add towers to the model
		theModel.addAttribute("projects", theProjects);
		
		return "project-list";
	}
	
	
	@GetMapping("/addTowerForm")
	public String addTowerForm(Model theModel) {
		
		//create model attribute to bind form data
		
		Tower theTower = new Tower();
				
		theModel.addAttribute("tower", theTower);
		
		return "tower-form";
	}
	
	@GetMapping("/addProjectForm")
	public String addProjectForm(Model theModel) {
		
		//create model attribute to bind form data
		
		Project theProject = new Project();
				
		theModel.addAttribute("project", theProject);
		
		return "project-form";
	}
	
	//saving a new project
	
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project theProject) {
		
		//save the project using the service
		projectService.saveProject(theProject);
		
		return "redirect:/main/projectsList";
	}
	
	@PostMapping("/saveTower")
	public String saveTower(@ModelAttribute("tower") Tower theTower) {
		
		//save the tower using the service
		towerService.saveTower(theTower);
		
		return "redirect:/main/towersList";
	}

	//update an existing tower
	@GetMapping("/updateTowerForm")
	public String updateTowerForm(@RequestParam("towerId") int theId,
									Model theModel) {
		
		//get tower from the service
		Tower theTower = towerService.getTower(theId);
		
		//set tower as a model attribute for the pre-populate
		theModel.addAttribute("tower", theTower);
		
		//send over to the form
		
		return "tower-form";
	}
	
	//delete an existing tower
	@GetMapping("/deleteTower")
	public String deleteTower(@RequestParam("towerId") int theId) {
		
		//delete the tower
		towerService.deleteTower(theId);
		
		//return to the tower list
		return "redirect:/main/towersList";
		
	}
	
}

