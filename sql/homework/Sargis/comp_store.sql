-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: comp_store
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CPU`
--

DROP TABLE IF EXISTS `CPU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CPU` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CPU`
--

LOCK TABLES `CPU` WRITE;
/*!40000 ALTER TABLE `CPU` DISABLE KEYS */;
INSERT INTO `CPU` VALUES (1,7,340,5,270,'#333/44/55','Core i7-4790K Processor','8M Cache, up to 4.40 GHz'),(2,7,300,6,240,'#333/44/77','Core i5 Processor','6M Cache, up to 4.20 GHz');
/*!40000 ALTER TABLE `CPU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Displays`
--

DROP TABLE IF EXISTS `Displays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Displays` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Displays`
--

LOCK TABLES `Displays` WRITE;
/*!40000 ALTER TABLE `Displays` DISABLE KEYS */;
INSERT INTO `Displays` VALUES (1,8,169,8,120,'VS248H-P','Asus VS248H-P Full-HD','24 Inch'),(2,8,145,11,110,'VS228H-P','Asus VS228H-P Full-HD','21.5 Inch 5ms LED-Lit'),(3,8,145,11,110,'VS247H-P','Asus VS247H-P Full-HD','23.6 Inch  LED-Lit'),(4,5,140,14,105,'VX2252MH-P','ViewSonic Full-HD','22 Inch  LED-Lit Game mode');
/*!40000 ALTER TABLE `Displays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HDD`
--

DROP TABLE IF EXISTS `HDD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HDD` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HDD`
--

LOCK TABLES `HDD` WRITE;
/*!40000 ALTER TABLE `HDD` DISABLE KEYS */;
INSERT INTO `HDD` VALUES (1,1,125,6,100,'#400/84/73','Seagate Expansion USB 3.0','5TB'),(2,1,115,7,80,'ST2000LM003','Seagate HN-M201RAD','2TB');
/*!40000 ALTER TABLE `HDD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Keyboard`
--

DROP TABLE IF EXISTS `Keyboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Keyboard` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Keyboard`
--

LOCK TABLES `Keyboard` WRITE;
/*!40000 ALTER TABLE `Keyboard` DISABLE KEYS */;
INSERT INTO `Keyboard` VALUES (1,4,60,3,50,'MC184LL/B','Apple Wireless keyboard','2 AA battery, Bluetooth connection'),(2,1,40,12,35,'VG-KBD2000','Samsung Wireless keyboard','LED H6400, FH6030');
/*!40000 ALTER TABLE `Keyboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `M_Board`
--

DROP TABLE IF EXISTS `M_Board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `M_Board` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `M_Board`
--

LOCK TABLES `M_Board` WRITE;
/*!40000 ALTER TABLE `M_Board` DISABLE KEYS */;
INSERT INTO `M_Board` VALUES (1,7,240,3,290,'#333/894/45','Z97 Extreme6 Desktop Motherboard','Socket H3 LGA-1150'),(2,8,350,2,280,'#399/84/45','Z97-PRO','WI-FI AC S1150 Z97 ATX');
/*!40000 ALTER TABLE `M_Board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manufact`
--

DROP TABLE IF EXISTS `Manufact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Manufact` (
  `man_id` int(11) NOT NULL AUTO_INCREMENT,
  `man_name` text,
  PRIMARY KEY (`man_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manufact`
--

LOCK TABLES `Manufact` WRITE;
/*!40000 ALTER TABLE `Manufact` DISABLE KEYS */;
INSERT INTO `Manufact` VALUES (1,'Samsung'),(2,'LG'),(3,'LENOVO'),(4,'APPLE'),(5,'Sony'),(6,'DELL'),(7,'INTEL'),(8,'ASUS'),(9,'ASROCK'),(10,'G-Force');
/*!40000 ALTER TABLE `Manufact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mouse`
--

DROP TABLE IF EXISTS `Mouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mouse` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mouse`
--

LOCK TABLES `Mouse` WRITE;
/*!40000 ALTER TABLE `Mouse` DISABLE KEYS */;
INSERT INTO `Mouse` VALUES (1,4,65,5,45,'#aaa/342/666','Apple Magic Mouse','Blutooth, touch technology'),(2,3,65,15,45,'N700','Lenovo Dual MOde Wl','Black, touch technology');
/*!40000 ALTER TABLE `Mouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAM`
--

DROP TABLE IF EXISTS `RAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAM` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAM`
--

LOCK TABLES `RAM` WRITE;
/*!40000 ALTER TABLE `RAM` DISABLE KEYS */;
INSERT INTO `RAM` VALUES (1,4,80,10,50,'#400/84/45','Crucial 8 GB Kit (4 GB x 2) DDR3','8GB KIT(4GB*2)'),(2,7,110,8,75,'#400/84/68','Corsair Vengeance  DDR3 1600 MHz','16 GB KIT(8GB*2)');
/*!40000 ALTER TABLE `RAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `V_Card`
--

DROP TABLE IF EXISTS `V_Card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `V_Card` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `man_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `model` text,
  `name` text,
  `parameters` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `V_Card`
--

LOCK TABLES `V_Card` WRITE;
/*!40000 ALTER TABLE `V_Card` DISABLE KEYS */;
INSERT INTO `V_Card` VALUES (1,10,200,4,165,'#400/84/69','EVGA GeForce GTX 960 SuperSC','ACX 2.0+ 2GB GDDR5 128bit, PCI-E 3.0 Dual-Link DVI-I'),(2,10,360,6,290,'#400/84/71','Gigabyte GeForce GTX 970 G1','G1 Gaming GDDR5 Pcie Video Graphics Card, 4GB');
/*!40000 ALTER TABLE `V_Card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realization`
--

DROP TABLE IF EXISTS `realization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `realization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cpu_id` int(11) NOT NULL,
  `MB_id` int(11) NOT NULL,
  `ram_id` int(11) NOT NULL,
  `VC_id` int(11) NOT NULL,
  `hdd_id` int(11) NOT NULL,
  `kb_id` int(11) NOT NULL,
  `ms_id` int(11) NOT NULL,
  `disp_id` int(11) NOT NULL,
  `sell_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realization`
--

LOCK TABLES `realization` WRITE;
/*!40000 ALTER TABLE `realization` DISABLE KEYS */;
INSERT INTO `realization` VALUES (1,1,1,2,1,1,2,1,1,'0000-00-00'),(2,2,1,2,1,1,2,1,1,'2014-10-02'),(3,2,1,2,1,1,2,2,2,'2015-02-20'),(4,1,1,2,1,1,2,2,4,'2015-02-20'),(5,1,1,2,1,1,2,2,4,'2015-02-21'),(6,2,1,2,2,1,2,2,3,'2015-02-23');
/*!40000 ALTER TABLE `realization` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-27 14:03:59
