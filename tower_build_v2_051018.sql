DROP SCHEMA IF EXISTS `tower-build-v2`;

CREATE SCHEMA `tower-build-v2`;

use `tower-build-v2`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `project_setup`;

CREATE TABLE `project_setup` (
  `project_number` int(11) NOT NULL AUTO_INCREMENT,
  `project_type` varchar(45) DEFAULT NULL,
  `carrier_name` varchar(45) DEFAULT NULL,
  `contact_company` varchar(45) DEFAULT NULL,
  `contact_first_name` varchar(45) DEFAULT NULL,
  `contact_last_name` varchar(45) DEFAULT NULL,
  `contact_email` varchar(45) DEFAULT NULL,
  `project_primary_rad_center` int(11) DEFAULT NULL,
  `project_primary_rad_tip` int(11) DEFAULT NULL,
  `project_primary_rad_base` int(11) DEFAULT NULL,
  `project_alternate_rad_center_1` int(11) DEFAULT NULL,
  `project_alternate_rad_tip_1` int(11) DEFAULT NULL,
  `project_alternate_rad_base_1` int(11) DEFAULT NULL,
  `project_alternate_rad_center_2` int(11) DEFAULT NULL,
  `project_alternate_rad_tip_2` int(11) DEFAULT NULL,
  `project_alternate_rad_base_2` int(11) DEFAULT NULL,
  `tower_reference_id` int(11) DEFAULT NULL,
  `contract_reference_id` int(11) DEFAULT NULL,
  `pricing` decimal(11, 2) DEFAULT NULL,

  PRIMARY KEY (`project_number`),
  KEY `FK_TowerNumber` (`tower_reference_id`),
  CONSTRAINT `FK_TowerNumber` FOREIGN KEY (`tower_reference_id`) 
  REFERENCES `tower_detail` (`tower_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_ContractNumber` (`contract_reference_id`),
  CONSTRAINT `FK_ContractNumber` FOREIGN KEY (`contract_reference_id`) 
  REFERENCES `contract` (`contract_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `project_setup` VALUES 
	(1,'MLA','Verizon','NB&C','Jim','Oontz','joontz@nbcllc.com', 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, null, 0.00),
	(2,'Amendment','Verizon','Black & Veatch','Tom','Beach','tbeach@bv.com', 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0.00),
	(3,'MLA','T-Mobile','Goodman','David','Harris','david@goodman.com', 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, null, 0.00),
	(4,'Amendment','Sprint','NB&C','Nancy','Grace','grace@nbcllc.com', 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0.00),
	(5,'Amendment','Verizon','TRM','Joe','Paterno','joepa@trm.com', 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, 0.00);

DROP TABLE IF EXISTS `tower_detail`;

CREATE TABLE `tower_detail` (
  `tower_id` int(11) NOT NULL AUTO_INCREMENT,
  `tower_number` int(11) NOT NULL,
  `tower_name` varchar(45) DEFAULT NULL,
  `tower_portfolio` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tower_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `tower_detail` VALUES 
	(1, 6679,'Pattern','Nextel','Boston','MA'),
	(2, 11876,'Roller','SBC','Lexington','KY'),
	(3, 93287,'Loot Crate','TowerCo','Salem','NH'),
	(4, 418627,'Batman','Sequoia','New Haven','CT'),
	(5, 419213,'Zavala','Sequoia','Pelham','NH');
    
DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract` (
  `contract_id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_number` varchar(45) DEFAULT NULL,
  `parent_company` varchar(45) DEFAULT NULL,
  `primary_rad_center` int(11) DEFAULT NULL,
  `primary_rad_tip` int(11) DEFAULT NULL,
  `primary_rad_base` int(11) DEFAULT NULL,
  `alternate_rad_center_1` int(11) DEFAULT NULL,
  `alternate_rad_tip_1` int(11) DEFAULT NULL,
  `alternate_rad_base_1` int(11) DEFAULT NULL,
  `alternate_rad_center_2` int(11) DEFAULT NULL,
  `alternate_rad_tip_2` int(11) DEFAULT NULL,
  `alternate_rad_base_2` int(11) DEFAULT NULL,
  `contract_tower_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `FK_ContractTowerNumber` (`contract_tower_id`),
  CONSTRAINT `FK_ContractTowerNumber` FOREIGN KEY (`contract_tower_id`) 
  REFERENCES `tower_detail` (`tower_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `contract` VALUES
	(1, 'VZW0001', 'Verizon', 150, 154, 146, 0, 0, 0, 0, 0, 0, 2),
    (2, 'SPRNT0022', 'Sprint', 100, 104, 96, 0, 0, 0, 0, 0, 0, 4),
    (3, 'TMO23040', 'T-Mobile', 110, 114, 106, 0, 0, 0, 0, 0, 0, 3);
    
    
DROP TABLE IF EXISTS `project_equipment`;

CREATE TABLE `project_equipment` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_type` varchar(45) DEFAULT NULL,
  `equipment_quantity` int(11) DEFAULT NULL,
  `equipment_manufacturer` varchar(45) DEFAULT NULL,
  `equipment_model` varchar(45) DEFAULT NULL,
  `equipment_height` decimal(9, 3) DEFAULT NULL,
  `equipment_width` decimal(9, 3) DEFAULT NULL,
  `equipment_depth` decimal(9, 3) DEFAULT NULL,
  `equipment_weight` decimal(9, 3) DEFAULT NULL,
  `equipment_rad` decimal(9, 3) DEFAULT NULL,
  `mount_type` varchar(45) DEFAULT NULL,
  `azimuths` varchar(45) DEFAULT NULL,
  `count_per_azimuth` varchar(45) DEFAULT NULL,
  `tx_frequency` varchar(45) DEFAULT NULL,
  `rx_frequency` varchar(45) DEFAULT NULL,  
  `project_equipment_reference_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`equipment_id`),
  KEY `FK_ProjectEquipNum` (`project_equipment_reference_id`),
  CONSTRAINT `FK_ProjectEquipNum` FOREIGN KEY (`project_equipment_reference_id`) 
  REFERENCES `project_setup` (`project_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `project_equipment` VALUES 
	(1,'Panel', 6, 'Commscope', 'SBNHH-7554', 96, 16, 10, 66, 150, 'Low Profile Platform', '0/120/240', '2/2/2', '850', '850', 1),
    (2,'RRH', 3, 'ALU', 'RRH-32', 36, 12, 8, 55, 150, 'Low Profile Platform', '0/120/240', '1/1/1', 'N/A', 'N/A', 1),
    (3,'BOB', 2, 'Raycap', 'RNNH-1234', 20, 8, 8, 12, 150, 'Low Profile Platform', '0/120/240', '1/1/0', 'N/A', 'N/A', 1);
	
    
DROP TABLE IF EXISTS `project_cables`;

CREATE TABLE `project_cables` (
  `cable_id` int(11) NOT NULL AUTO_INCREMENT,
  `cable_type` varchar(45) DEFAULT NULL,
  `cable_quantity` int(11) DEFAULT NULL,
  `cable_diameter` decimal(9, 3) DEFAULT NULL,
  `cable_per_sector` varchar(45) DEFAULT NULL,
  `cable_configuration` varchar(45) DEFAULT NULL,
  `project_cable_reference_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`cable_id`),
  KEY `FK_ProjectCableNum` (`project_cable_reference_id`),
  CONSTRAINT `FK_ProjectCableNum` FOREIGN KEY (`project_cable_reference_id`) 
  REFERENCES `project_setup` (`project_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `project_cables` VALUES 
	(1, 'Fiber', 3, 1.625, '1/1/1', 'N/A', 1),
    (2, 'Coax', 12, 1.625, '4/4/4', 'N/A', 1);
    
    DROP TABLE IF EXISTS `project_ground`;

CREATE TABLE `project_ground` (
  `ground_id` int(11) NOT NULL AUTO_INCREMENT,
  `ground_primary` varchar(45) DEFAULT NULL,
  `ground_space_type` varchar(45) DEFAULT NULL,
  `ground_space_length` decimal(9, 3) DEFAULT NULL,
  `ground_space_width` decimal(9, 3) DEFAULT NULL,
  `ground_area` decimal(9, 3) DEFAULT NULL,
  `project_ground_reference_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`ground_id`),
  KEY `FK_ProjectGroundNum` (`project_ground_reference_id`),
  CONSTRAINT `FK_ProjectGroundNum` FOREIGN KEY (`project_ground_reference_id`) 
  REFERENCES `project_setup` (`project_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `project_ground` VALUES 
	(1, 'Yes', 'Concrete Pad', 20, 10, 200, 1),
    (2, 'No', 'Generator', 4, 10, 40, 1);
    
    
SET FOREIGN_KEY_CHECKS = 1;
