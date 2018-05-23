package com.luv2code.springdemo.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProjectDAO;
import com.luv2code.springdemo.entity.Contract;
import com.luv2code.springdemo.entity.Equipment;
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

		return projectDAO.getProject(theId);
	}
	
	@Override
	@Transactional
	public void deleteProject(int theId) {
		projectDAO.deleteProject(theId);
	}
	
	@Override
	@Transactional
	public void returnPricing(int theId) {
		//declare variables/retrieve data
		try {
			Project project = projectDAO.getProject(theId);		
			String type = project.getProjectType();
			String carrier = project.getCarrierName();
			List<Equipment> equipment = project.getEquipment();
			
			//loop through each element of equipment and perform calcs
			//choose pricing by carrier
			
			if (carrier.equalsIgnoreCase("Verizon")) {
				
			//loop through equipment on the project and get equipment pricing
				
				if(type.equalsIgnoreCase("MLA")) {
					System.out.println("\n\nReached the MLA!!!1!!\n\n");
					project.setPricing(2250.00);
				} else if(type.equalsIgnoreCase("Amendment")) {
					
					System.out.println("\n\nReached the Amendment!!!1!!\n\n");
					
//					int contractRAD = project.getContract().getPrimaryRadCenter();
					int contractRADTip = project.getContract().getPrimaryRadTip();
					int contractRADBase = project.getContract().getPrimaryRadBase();
					
					for (int i=0; i<equipment.size(); i++) {
						
						System.out.println("\n\nReached the Equipment Loop!!!1!!\n\n");
						
						Equipment readEquip = equipment.get(i);
						String equipType = readEquip.getEquipmentType();
						int equipCount = readEquip.getEquipmentQuantity();
						double proposedRAD = readEquip.getEquipmentRad();
						double equipHeight = readEquip.getEquipmentHeight();
						double feetHeight = (int) (equipHeight / 12);
						double equipRadius = feetHeight / 2;
						
						double equipTip = (double) (equipRadius + proposedRAD);
						double equipBase = (double) (proposedRAD - equipRadius);
						
						double equipPricing = 0.00;
						double linesPricing = 0.00;
						double groundPricing = 0.00;
						double newRADPricing = 0.00;
						double tipHeightPricing = 0.00;
						double baseHeightPricing = 0.00;
						
						//return pricing for an additional RAD if equipment is proposed outside of contract RAD
						
						if(proposedRAD > contractRADTip || proposedRAD < contractRADBase) {
							System.out.println("\n\nReached the New RAD Price!!!1!!\n\n");
							newRADPricing = 1950.00;							
							
						//return pricing for equipment that protrudes above contract RAD
							
						} else if(equipTip > contractRADTip) {
							
							double difference = equipTip - contractRADTip;
							double percentage = (double) (difference / feetHeight);							
							switch(equipType.toUpperCase()) {
								
							case "PANEL": equipPricing = 95.00;
										  break;
							case "RRH": equipPricing = 75.00;
										break;
							case "BOB": equipPricing = 50.00;
							  			break;							
							}
							
							System.out.println("\n\nReached the Tip Height Price!!!1!!\n\n");
							tipHeightPricing = ((equipPricing * percentage) * equipCount);	
							System.out.println("\n\nEquip Tip is:" + equipTip +
											   "\nDifference is: " + difference +
											   "\nFeet Height is: " + feetHeight +
											   "\nPercentage is: " + percentage + 
											   "\nEquip Count is: " + equipCount +
											   "\nContract RAD Tip is:" + contractRADTip + 
											   "\nTip Height Price is: " + tipHeightPricing + "\n\n");
							
						//return pricing if equipment protrudes below contract RAD
							
						} else if(equipBase < contractRADBase) {
							
							double difference = contractRADBase - equipBase;
							double percentage = (double) (difference / feetHeight);							
							switch(equipType.toUpperCase()) {
								
							case "PANEL": equipPricing = 95.00;
										  break;
							case "RRH": equipPricing = 75.00;
										break;
							case "BOB": equipPricing = 50.00;
							  			break;							
							}
							
							System.out.println("\n\nReached the Base Height Price!!!1!!\n\n");
							baseHeightPricing = ((equipPricing * percentage) * equipCount);							
						
						}
						
						equipPricing = newRADPricing + tipHeightPricing + baseHeightPricing;
						double pricingTotal = equipPricing + linesPricing + groundPricing;
						System.out.println("\n\nReached end of Verizon Pricing!\n\n");
						project.setPricing(pricingTotal);
					}
					
				}
				
				
				
				//return message for Sprint customer
			} else if (carrier.equalsIgnoreCase("Sprint")) {
				project.setPricing(0.00);
				System.out.println("\n\nSprint pricing not initialized!\n\n");
				//return message for TMO customer
			} else if(carrier.equalsIgnoreCase("T-Mobile")) {
				project.setPricing(0.00);
				System.out.println("\n\nTMO pricing not initialized!\n\n");
				//return message for ATT customer
			} else if(carrier.equalsIgnoreCase("AT&T")) {
				project.setPricing(0.00);
				System.out.println("\n\nAT&T pricing not initialized!\n\n");
			}			
			
			//basic pricing statement
//			if (type.equalsIgnoreCase("MLA")) {
//				
//				project.setPricing(2250.00);
//				projectDAO.saveProject(project);				
//
//							
//			} else if (type.equalsIgnoreCase("Amendment")) {					
//				project.setPricing(1000.00);
//				projectDAO.saveProject(project);
//
//			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Pricing failed!");
		}
	}
		
	
}

//Copyright 2018, Alex Ignachuck, All rights reserved

