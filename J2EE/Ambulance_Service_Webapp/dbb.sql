/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - db_accident_system
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_accident_system`;

USE `db_accident_system`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `h_hospital` */

DROP TABLE IF EXISTS `h_hospital`;

CREATE TABLE `h_hospital` (
  `H_code` int(10) NOT NULL auto_increment,
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
  `dist` double default NULL,
  PRIMARY KEY  (`H_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `h_hospital` */

insert into `h_hospital` (`H_code`,`Hospital_name`,`Address1`,`Address2`,`Area`,`city`,`state`,`pin`,`land_line`,`cell_no1`,`remarks`,`latitude`,`logitude`,`dist`) values (1,'sagar','sagar hospital,bangaloree','sagar hospital,bangaloree','Bangaloree','bangalore','karnatakaeeee','560001','234567','9578778770','9578778770','12.921997','77.594105',NULL);

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `s_no` int(6) NOT NULL auto_increment,
  `admin_id` varchar(40) NOT NULL,
  `admin_password` varchar(40) NOT NULL,
  `admin_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`s_no`,`admin_id`,`admin_password`,`admin_name`) values (1,'admin','admin','palani Kannan');

/*Table structure for table `m_police_station` */

DROP TABLE IF EXISTS `m_police_station`;

CREATE TABLE `m_police_station` (
  `id` int(10) NOT NULL auto_increment,
  `locname` varchar(100) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `langitude` varchar(20) NOT NULL,
  `cell` varchar(20) NOT NULL,
  `dist` double NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_police_station` */

insert into `m_police_station` (`id`,`locname`,`latitude`,`langitude`,`cell`,`dist`) values (1,'marathalli road','12.917195','77.589174','8951848917',1739.93807225744);
insert into `m_police_station` (`id`,`locname`,`latitude`,`langitude`,`cell`,`dist`) values (2,'1 st block','12.939293','77.586198','8951848917',871.763272132582);
insert into `m_police_station` (`id`,`locname`,`latitude`,`langitude`,`cell`,`dist`) values (3,'Yediyur','12.931877','77.576929','8951848917',723.585455087557);
insert into `m_police_station` (`id`,`locname`,`latitude`,`langitude`,`cell`,`dist`) values (4,'Jayanagar 3rd Block','12.931149','77.583305','8951848917',86.6756785604779);
insert into `m_police_station` (`id`,`locname`,`latitude`,`langitude`,`cell`,`dist`) values (5,'Pepe Jeans, 3rd block','12.931969','77.583761','8951848917',20.0322111701089);

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `id` int(10) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(100) default NULL,
  `otp` varchar(100) default NULL,
  `status` varchar(120) default 'false',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`id`,`username`,`password`,`address`,`phone`,`email`,`otp`,`status`) values (1,'shalini','shalini','bangalore','7760255563','shanunamgowda@gmail.com','787212','true');
insert into `m_user` (`id`,`username`,`password`,`address`,`phone`,`email`,`otp`,`status`) values (2,'vnu','vnu123','bangalore','7788990088','shalini@celestialv.com','736985','true');

/*Table structure for table `p_police_station` */

DROP TABLE IF EXISTS `p_police_station`;

CREATE TABLE `p_police_station` (
  `code` int(10) NOT NULL auto_increment,
  `police_station_name` varchar(50) NOT NULL,
  `Address1` varchar(50) NOT NULL,
  `Address2` varchar(50) NOT NULL,
  `Area` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `land_line` varchar(15) NOT NULL,
  `cell_no1` varchar(20) NOT NULL,
  `cell_no2` varchar(20) NOT NULL,
  `remarks` varchar(150) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `logitude` varchar(20) NOT NULL,
  `dist` double default NULL,
  PRIMARY KEY  (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `p_police_station` */

insert into `p_police_station` (`code`,`police_station_name`,`Address1`,`Address2`,`Area`,`City`,`state`,`pin`,`land_line`,`cell_no1`,`cell_no2`,`remarks`,`latitude`,`logitude`,`dist`) values (2,'Madiwala Police Station','Madiwala police station,bangalore','Madiwala police station,bangalore','Madiwala','Bangalore','karnataka','560001','234598','9578778770','9578778770','goodvv','12.93114999','77.583305999',986.341519848076);
insert into `p_police_station` (`code`,`police_station_name`,`Address1`,`Address2`,`Area`,`City`,`state`,`pin`,`land_line`,`cell_no1`,`cell_no2`,`remarks`,`latitude`,`logitude`,`dist`) values (3,'jayanagar police station','7th f main','jayanagar 3 block','jayanagar east','banglore','karnataka','645454','234598','9578778770','9578778770','goodd','12.9317824','12.9317824',0);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
