/*
SQLyog - Free MySQL GUI v5.19
Host - 5.5.17 : Database - db_ambulance
*********************************************************************
Server version : 5.5.17
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_ambulance`;

USE `db_ambulance`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `h_hospital` */

DROP TABLE IF EXISTS `h_hospital`;

CREATE TABLE `h_hospital` (
  `H_code` int(10) NOT NULL AUTO_INCREMENT,
  `Hospital_name` varchar(150) NOT NULL,
  `Address1` varchar(100) NOT NULL,
  `Address2` varchar(100) NOT NULL,
  `Area` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `pin` varchar(6) NOT NULL,
  `land_line` varchar(20) NOT NULL,
  `cell_no1` varchar(10) NOT NULL,
  `remarks` varchar(500) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `logitude` varchar(50) NOT NULL,
  `dist` double DEFAULT NULL,
  PRIMARY KEY (`H_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `h_hospital` */

insert into `h_hospital` (`H_code`,`Hospital_name`,`Address1`,`Address2`,`Area`,`city`,`state`,`pin`,`land_line`,`cell_no1`,`remarks`,`latitude`,`logitude`,`dist`) values (4,'BTM','BTM 1st','Bangalore','BTM','Bangalore','Karnataka','78954','123456','7278416895','good','12.911943','77.613302',NULL);
insert into `h_hospital` (`H_code`,`Hospital_name`,`Address1`,`Address2`,`Area`,`city`,`state`,`pin`,`land_line`,`cell_no1`,`remarks`,`latitude`,`logitude`,`dist`) values (5,'Jayanagar','Jayanagar 3rd Block','Bangalore','Jayanagar','Bangalore','Karnataka','889966','123456','7338679514','good','12.930840','77.580185',NULL);

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(200) DEFAULT NULL,
  `admin_password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`id`,`admin_id`,`admin_password`) values (1,'admin','admin');

/*Table structure for table `m_passenger` */

DROP TABLE IF EXISTS `m_passenger`;

CREATE TABLE `m_passenger` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `m_passengerid` varchar(100) DEFAULT NULL,
  `m_password` varchar(100) DEFAULT NULL,
  `m_name` varchar(100) DEFAULT NULL,
  `m_email` varchar(100) DEFAULT NULL,
  `m_phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `m_passenger` */

insert into `m_passenger` (`id`,`m_passengerid`,`m_password`,`m_name`,`m_email`,`m_phone`) values (1,'abhi','abhi','ggu','tz','666888');
insert into `m_passenger` (`id`,`m_passengerid`,`m_password`,`m_name`,`m_email`,`m_phone`) values (2,'abc','abc','abc','abc@gmail.com','7278416895');

/*Table structure for table `p_ambulance` */

DROP TABLE IF EXISTS `p_ambulance`;

CREATE TABLE `p_ambulance` (
  `code` int(10) NOT NULL AUTO_INCREMENT,
  `ambulance_loc_name` varchar(50) NOT NULL,
  `Address1` varchar(50) NOT NULL,
  `Address2` varchar(50) NOT NULL,
  `Area` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `land_line` varchar(15) NOT NULL,
  `cell_no1` varchar(20) NOT NULL,
  `remarks` varchar(150) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `logitude` varchar(20) NOT NULL,
  `status` varchar(200) NOT NULL DEFAULT 'Available',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `p_ambulance` */

insert into `p_ambulance` (`code`,`ambulance_loc_name`,`Address1`,`Address2`,`Area`,`City`,`state`,`pin`,`land_line`,`cell_no1`,`remarks`,`latitude`,`logitude`,`status`) values (5,'Madiwala','Mdiwala','Bangalore','Madiwala BTM','Bangalore','Karnataka','560089','123456','7338679514','good','12.921001','77.620362','Available');
insert into `p_ambulance` (`code`,`ambulance_loc_name`,`Address1`,`Address2`,`Area`,`City`,`state`,`pin`,`land_line`,`cell_no1`,`remarks`,`latitude`,`logitude`,`status`) values (6,'Koramangla','Koramangla','Bangalore','Koramangla 1st Block','Bangalore','Karnataka','896547','1234567','7338679514','good','12.928782','77.627998','Available');
insert into `p_ambulance` (`code`,`ambulance_loc_name`,`Address1`,`Address2`,`Area`,`City`,`state`,`pin`,`land_line`,`cell_no1`,`remarks`,`latitude`,`logitude`,`status`) values (8,'Jayanagar 3rd','Jayanagar 3rd Block','Bangalore','jayanagar 8th F Main Road','Bangalore','Karnataka','889966','123456','7278416895','good','12.931805','77.583568','Occupied');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
