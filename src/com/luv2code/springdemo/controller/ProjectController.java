package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Cables;
import com.luv2code.springdemo.entity.Contract;
import com.luv2code.springdemo.entity.Equipment;
import com.luv2code.springdemo.entity.Ground;
import com.luv2code.springdemo.entity.Project;
import com.luv2code.springdemo.entity.Tower;
import com.luv2code.springdemo.service.CablesService;
import com.luv2code.springdemo.service.ContractService;
import com.luv2code.springdemo.service.EquipmentService;
import com.luv2code.springdemo.service.GroundService;
import com.luv2code.springdemo.service.ProjectService;
import com.luv2code.springdemo.service.TowerService;



@Controller
@RequestMapping("/main")
public class ProjectController {
	
	//need to inject service
	
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TowerService towerService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private CablesService cablesService;
	
	@Autowired
	private GroundService groundService;
	
	//need a main splash page
	
	@GetMapping("/startPage")
	public String startUp() {
		return "homepage";
	}
	
	
	
	@GetMapping("/towersList")
	public String listTowers(Model theModel) {
		
		//get towers from the service
		List<Tower> theTowers = towerService.getTowers();
		
		//add towers to the model
		theModel.addAttribute("towers", theTowers);
		
		return "tower-list";
	}
	
	
	//auto update project pricing
	@GetMapping("/priceProject")
	public String priceProject(@RequestParam("projectNumber") int theId) {
		
		//reprice the project
		projectService.returnPricing(theId);
		
		//return to the project list
		return "redirect:/main/projectsList";
	}
	
//	//attempt to update pricing
//	@GetMapping("/projectsList")
//	public String listProjects(ModelMap theModel) {
//		
//		//get projects from the service
//		List<Project> theProjects = projectService.getProjects();
//		
//		//newPricing = projectService.returnPricing();
//		int theId = projectService.getProject(projectNumber);
//		double newPricing =
//			projectService.returnPricing(theId);
//		
//		
//		//add projects to the model
//		theModel.addAttribute("projects", theProjects);
//		theModel.addAttribute("pricing", newPricing);
//		
//		return "project-list";
//	}
	
	@GetMapping("/projectsList")
	public String listProjects(Model theModel) {
		
		//get projects from the service
		List<Project> theProjects = projectService.getProjects();
		
		//add projects to the model
		theModel.addAttribute("projects", theProjects);
		
		return "project-list";
	}
	
	@GetMapping("/contractsList")
	public String listContracts(Model theModel) {
		
		//get contracts from the service
		List<Contract> theContracts = contractService.getContracts();
		
		//add contracts to the model
		theModel.addAttribute("contracts", theContracts);
		
		return "contract-list";
	}
	
	@GetMapping("/equipmentList")
	public String listEquipment(Model theModel) {
		
		//get towers from the service
		List<Equipment> theEquipment = equipmentService.getEquipments();
		
		//add towers to the model
		theModel.addAttribute("equipment", theEquipment);
		
		return "equipment-list";
	}
	
	@GetMapping("/cablesList")
	public String listCables(Model theModel) {
		
		//get cables from the service
		List<Cables> theCables = cablesService.getCables();
		
		//add cables to the model
		theModel.addAttribute("cables", theCables);
		
		return "cables-list";
	}
	
	@GetMapping("/groundList")
	public String listGround(Model theModel) {
		
		//get ground space list from the service
		List<Ground> theGround = groundService.getGrounds();
		
		//add ground space to the model
		theModel.addAttribute("ground", theGround);
		
		return "ground-list";
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
	
	@GetMapping("/addContractForm")
	public String addContractForm(Model theModel) {
		
		//create model attribute to bind form data
		Contract theContract = new Contract();
								
		theModel.addAttribute("contract", theContract);
		
		return "contract-form";
	}
	
	@GetMapping("/addEquipmentForm")
	public String addEquipmentForm(Model theModel) {
		
		//create model attribute to bind form data
		Equipment theEquipment = new Equipment();
								
		theModel.addAttribute("equipment", theEquipment);
		
		return "equipment-form";
	}
	
	@GetMapping("/addCablesForm")
	public String addCablesForm(Model theModel) {
		
		//create model attribute to bind form data
		Cables theCables = new Cables();
				
		theModel.addAttribute("cables", theCables);
		
		return "cables-form";
	}
	
	@GetMapping("/addGroundForm")
	public String addGroundForm(Model theModel) {
		
		//create model attribute to bind form data
		Ground theGround = new Ground();
				
		theModel.addAttribute("ground", theGround);
		
		return "ground-form";
	}
	
	//saving a new project
	
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project theProject) {
		
		//save the project using the service
		projectService.saveProject(theProject);
		
		return "redirect:/main/projectsList";
	}
	
	//saving a new tower
	@PostMapping("/saveTower")
	public String saveTower(@ModelAttribute("tower") Tower theTower) {
		
		//save the tower using the service
		towerService.saveTower(theTower);
		
		return "redirect:/main/towersList";
	}
	
	//saving a new contract
	@PostMapping("/saveContract")
	public String saveContract(@ModelAttribute("contract") Contract theContract) {
		
		//save the project using the service
		contractService.saveContract(theContract);
		
		return "redirect:/main/contractsList";
	}
	
	//saving new equipment
	@PostMapping("/saveEquipment")
	public String saveEquipment(@ModelAttribute("equipment") Equipment theEquipment) {
		
		//save the project using the service
		equipmentService.saveEquipment(theEquipment);
		
		return "redirect:/main/equipmentList";
	}
	
	@PostMapping("/saveCables")
	public String saveCables(@ModelAttribute("cables") Cables theCables) {
		
		//save the cables using the service
		cablesService.saveCables(theCables);
		
		return "redirect:/main/cablesList";
	}
	
	//saving a new ground space
	
	@PostMapping("/saveGround")
	public String saveGround(@ModelAttribute("ground") Ground theGround) {
		
		//save the project using the service
		groundService.saveGround(theGround);
		
		return "redirect:/main/groundList";
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
	
	//update an existing project
	@GetMapping("/updateProjectForm")
	public String updateProjectForm(@RequestParam("projectNumber") int theId,
									Model theModel) {
		//get project from the service
		Project theProject = projectService.getProject(theId);
		
		//set project as model attribute for pre-population
		theModel.addAttribute("project", theProject);
		
		//send project over to the form
		
		return "project-form";
	}
	
	//update an existing contract
	@GetMapping("/updateContractForm")
	public String updateContractForm(@RequestParam("contractId") int theId,
									Model theModel) {
		//get project from the service
		Contract theContract = contractService.getContract(theId);
		
		//set project as model attribute for pre-population
		theModel.addAttribute("contract", theContract);
		
		//send project over to the form
		
		return "contract-form";
	}
	
	//update existing equipment
	@GetMapping("/updateEquipmentForm")
	public String updateEquipmentForm(@RequestParam("equipmentId") int theId,
									Model theModel) {
		//get project from the service
		Equipment theEquipment = equipmentService.getEquipment(theId);
		
		//set project as model attribute for pre-population
		theModel.addAttribute("equipment", theEquipment);
		
		//send project over to the form
		
		return "equipment-form";
	}
	
	//update existing cables
	@GetMapping("/updateCablesForm")
	public String updateCablesForm(@RequestParam("cableId") int theId,
									Model theModel) {
		
		//get cables from the service
		Cables theCables = cablesService.getCable(theId);
		
		//set cables as a model attribute for the pre-populate
		theModel.addAttribute("cables", theCables);
		
		//send over to the form
		
		return "cables-form";
	}
	
	//update an existing ground space
	@GetMapping("/updateGroundForm")
	public String updateGroundForm(@RequestParam("groundId") int theId,
									Model theModel) {
		
		//get ground space from the service
		Ground theGround = groundService.getGround(theId);
		
		//set ground space as a model attribute for the pre-populate
		theModel.addAttribute("ground", theGround);
		
		//send over to the form
		
		return "ground-form";
	}
	
	//delete an existing tower
	@GetMapping("/deleteTower")
	public String deleteTower(@RequestParam("towerId") int theId) {
		
		//delete the tower
		towerService.deleteTower(theId);
		
		//return to the tower list
		return "redirect:/main/towersList";
		
	}
	
	//delete an existing project
	@GetMapping("/deleteProject")
	public String deleteProject(@RequestParam("projectNumber") int theId) {
		
		//delete the project
		projectService.deleteProject(theId);
		
		//return to the project list
		return "redirect:/main/projectsList";
	}
	
	//delete an existing contract
	@GetMapping("/deleteContract")
	public String deleteContract(@RequestParam("contractId") int theId) {
		
		//delete the project
		contractService.deleteContract(theId);
		
		//return to the project list
		return "redirect:/main/contractsList";
	}
	
	//delete existing equipment
	@GetMapping("/deleteEquipment")
	public String deleteEquipment(@RequestParam("equipmentId") int theId) {
		
		//delete the equipment
		equipmentService.deleteEquipment(theId);
		
		//return to the equipment list
		return "redirect:/main/equipmentList";
	}
	
	//delete existing cables
	@GetMapping("/deleteCables")
	public String deleteCables(@RequestParam("cableId") int theId) {
		
		//delete the cable
		cablesService.deleteCable(theId);
		
		//return to the tower list
		return "redirect:/main/cablesList";
		
	}
	
	//delete existing ground space
	@GetMapping("/deleteGround")
	public String deleteGround(@RequestParam("groundId") int theId) {
		
		//delete the ground space
		groundService.deleteGround(theId);
		
		//return to the tower list
		return "redirect:/main/groundList";
		
	}
	
}
//Copyright 2018, Alex Ignachuck, All rights reserved
