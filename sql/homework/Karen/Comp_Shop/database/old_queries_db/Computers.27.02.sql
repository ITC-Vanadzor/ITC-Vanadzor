-- MySQL dump 10.13  Distrib 5.5.22, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Computers
-- ------------------------------------------------------
-- Server version	5.5.22-0ubuntu1

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
-- Table structure for table `Cases`
--

DROP TABLE IF EXISTS `Cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cases` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firm_id` int(6) NOT NULL,
  `cost` int(6) NOT NULL,
  `count` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `Cases_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `Firms` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cases`
--

LOCK TABLES `Cases` WRITE;
/*!40000 ALTER TABLE `Cases` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Devices`
--

DROP TABLE IF EXISTS `Devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Devices` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `products_id` int(6) NOT NULL,
  `device_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `products_id` (`products_id`),
  CONSTRAINT `Devices_ibfk_1` FOREIGN KEY (`products_id`) REFERENCES `Products` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Devices`
--

LOCK TABLES `Devices` WRITE;
/*!40000 ALTER TABLE `Devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `Devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Firms`
--

DROP TABLE IF EXISTS `Firms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Firms` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Firms`
--

LOCK TABLES `Firms` WRITE;
/*!40000 ALTER TABLE `Firms` DISABLE KEYS */;
INSERT INTO `Firms` VALUES (1,'Samsung'),(2,'LG'),(3,'Sony'),(4,'Intel'),(5,'AMD'),(6,'Genius');
/*!40000 ALTER TABLE `Firms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hard_Discs`
--

DROP TABLE IF EXISTS `Hard_Discs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Hard_Discs` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firm_id` int(6) NOT NULL,
  `size` varchar(30) NOT NULL,
  `cost` int(6) NOT NULL,
  `count` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `Hard_Discs_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `Firms` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hard_Discs`
--

LOCK TABLES `Hard_Discs` WRITE;
/*!40000 ALTER TABLE `Hard_Discs` DISABLE KEYS */;
INSERT INTO `Hard_Discs` VALUES (1,'LG 1TB',2,'1TB',100,30),(2,'Sony 500GB',3,'500GB',70,35),(3,'Sony 2TB',3,'2TB',150,25);
/*!40000 ALTER TABLE `Hard_Discs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `History`
--

DROP TABLE IF EXISTS `History`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `History` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `device_id` int(6) NOT NULL,
  `count` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `device_id` (`device_id`),
  CONSTRAINT `History_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `Devices` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `History`
--

LOCK TABLES `History` WRITE;
/*!40000 ALTER TABLE `History` DISABLE KEYS */;
/*!40000 ALTER TABLE `History` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Keyboards`
--

DROP TABLE IF EXISTS `Keyboards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Keyboards` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firm_id` int(6) NOT NULL,
  `type` varchar(30) NOT NULL,
  `cost` int(6) NOT NULL,
  `count` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `Keyboards_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `Firms` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Keyboards`
--

LOCK TABLES `Keyboards` WRITE;
/*!40000 ALTER TABLE `Keyboards` DISABLE KEYS */;
/*!40000 ALTER TABLE `Keyboards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Monitors`
--

DROP TABLE IF EXISTS `Monitors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Monitors` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firm_id` int(6) NOT NULL,
  `diagonal` varchar(50) NOT NULL,
  `cost` int(6) NOT NULL,
  `count` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `Monitors_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `Firms` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Monitors`
--

LOCK TABLES `Monitors` WRITE;
/*!40000 ALTER TABLE `Monitors` DISABLE KEYS */;
INSERT INTO `Monitors` VALUES (1,'Samsung 19d led',1,'19d',200,20),(2,'Samsung 21d led',1,'21d',230,15),(3,'LG 21d led',2,'21d',180,25),(4,'LG 19d led',2,'19d',150,23);
/*!40000 ALTER TABLE `Monitors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mouses`
--

DROP TABLE IF EXISTS `Mouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mouses` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firm_id` int(6) NOT NULL,
  `type` varchar(30) NOT NULL,
  `cost` int(6) NOT NULL,
  `count` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `Mouses_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `Firms` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mouses`
--

LOCK TABLES `Mouses` WRITE;
/*!40000 ALTER TABLE `Mouses` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mouses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Processor_powers`
--

DROP TABLE IF EXISTS `Processor_powers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Processor_powers` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Processor_powers`
--

LOCK TABLES `Processor_powers` WRITE;
/*!40000 ALTER TABLE `Processor_powers` DISABLE KEYS */;
/*!40000 ALTER TABLE `Processor_powers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Processor_types`
--

DROP TABLE IF EXISTS `Processor_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Processor_types` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Processor_types`
--

LOCK TABLES `Processor_types` WRITE;
/*!40000 ALTER TABLE `Processor_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `Processor_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Processors`
--

DROP TABLE IF EXISTS `Processors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Processors` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firm_id` int(6) NOT NULL,
  `type_id` int(6) NOT NULL,
  `power_id` int(6) NOT NULL,
  `count` int(6) DEFAULT NULL,
  `cost` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `firm_id` (`firm_id`),
  KEY `type_id` (`type_id`),
  KEY `power_id` (`power_id`),
  CONSTRAINT `Processors_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `Firms` (`id`) ON DELETE CASCADE,
  CONSTRAINT `Processors_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `Processor_types` (`id`) ON DELETE CASCADE,
  CONSTRAINT `Processors_ibfk_3` FOREIGN KEY (`power_id`) REFERENCES `Processor_powers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Processors`
--

LOCK TABLES `Processors` WRITE;
/*!40000 ALTER TABLE `Processors` DISABLE KEYS */;
/*!40000 ALTER TABLE `Processors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Products`
--

DROP TABLE IF EXISTS `Products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Products` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Products`
--

LOCK TABLES `Products` WRITE;
/*!40000 ALTER TABLE `Products` DISABLE KEYS */;
INSERT INTO `Products` VALUES (1,'Monitors'),(2,'Processors'),(3,'Keyboards'),(4,'Mouses'),(5,'RAM'),(6,'Cases');
/*!40000 ALTER TABLE `Products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAM`
--

DROP TABLE IF EXISTS `RAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAM` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firm_id` int(6) NOT NULL,
  `size` varchar(30) NOT NULL,
  `cost` varchar(30) NOT NULL,
  `count` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `RAM_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `Firms` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAM`
--

LOCK TABLES `RAM` WRITE;
/*!40000 ALTER TABLE `RAM` DISABLE KEYS */;
/*!40000 ALTER TABLE `RAM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-27 17:49:32
