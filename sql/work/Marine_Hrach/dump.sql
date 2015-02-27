-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: shop
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
-- Table structure for table `CPUs`
--

DROP TABLE IF EXISTS `CPUs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CPUs` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(10) NOT NULL,
  `socket_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `socket_id` (`socket_id`),
  CONSTRAINT `CPUs_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `CPUs_ibfk_2` FOREIGN KEY (`socket_id`) REFERENCES `sockets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CPUs`
--

LOCK TABLES `CPUs` WRITE;
/*!40000 ALTER TABLE `CPUs` DISABLE KEYS */;
/*!40000 ALTER TABLE `CPUs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CPUs_history`
--

DROP TABLE IF EXISTS `CPUs_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CPUs_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `CPU_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CPU_id` (`CPU_id`),
  CONSTRAINT `CPUs_history_ibfk_1` FOREIGN KEY (`CPU_id`) REFERENCES `CPUs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CPUs_history`
--

LOCK TABLES `CPUs_history` WRITE;
/*!40000 ALTER TABLE `CPUs_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `CPUs_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GPUs`
--

DROP TABLE IF EXISTS `GPUs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GPUs` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  `memory_size_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `memory_size_id` (`memory_size_id`),
  CONSTRAINT `GPUs_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `GPUs_ibfk_2` FOREIGN KEY (`memory_size_id`) REFERENCES `memory_sizes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GPUs`
--

LOCK TABLES `GPUs` WRITE;
/*!40000 ALTER TABLE `GPUs` DISABLE KEYS */;
/*!40000 ALTER TABLE `GPUs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GPUs_history`
--

DROP TABLE IF EXISTS `GPUs_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GPUs_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `GPU_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `GPU_id` (`GPU_id`),
  CONSTRAINT `GPUs_history_ibfk_1` FOREIGN KEY (`GPU_id`) REFERENCES `GPUs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GPUs_history`
--

LOCK TABLES `GPUs_history` WRITE;
/*!40000 ALTER TABLE `GPUs_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `GPUs_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAM_memory_types`
--

DROP TABLE IF EXISTS `RAM_memory_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAM_memory_types` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `type` char(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAM_memory_types`
--

LOCK TABLES `RAM_memory_types` WRITE;
/*!40000 ALTER TABLE `RAM_memory_types` DISABLE KEYS */;
INSERT INTO `RAM_memory_types` VALUES (1,'DDR3'),(2,'DDR4');
/*!40000 ALTER TABLE `RAM_memory_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAMs`
--

DROP TABLE IF EXISTS `RAMs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAMs` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  `memory_size_id` tinyint(3) unsigned NOT NULL,
  `type_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `memory_size_id` (`memory_size_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `RAMs_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `RAMs_ibfk_2` FOREIGN KEY (`memory_size_id`) REFERENCES `memory_sizes` (`id`),
  CONSTRAINT `RAMs_ibfk_3` FOREIGN KEY (`type_id`) REFERENCES `RAM_memory_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAMs`
--

LOCK TABLES `RAMs` WRITE;
/*!40000 ALTER TABLE `RAMs` DISABLE KEYS */;
/*!40000 ALTER TABLE `RAMs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAMs_history`
--

DROP TABLE IF EXISTS `RAMs_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAMs_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `RAM_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `RAM_id` (`RAM_id`),
  CONSTRAINT `RAMs_history_ibfk_1` FOREIGN KEY (`RAM_id`) REFERENCES `RAMs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAMs_history`
--

LOCK TABLES `RAMs_history` WRITE;
/*!40000 ALTER TABLE `RAMs_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `RAMs_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cases`
--

DROP TABLE IF EXISTS `cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cases` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `cases_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cases`
--

LOCK TABLES `cases` WRITE;
/*!40000 ALTER TABLE `cases` DISABLE KEYS */;
/*!40000 ALTER TABLE `cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cases_history`
--

DROP TABLE IF EXISTS `cases_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cases_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `case_id` (`case_id`),
  CONSTRAINT `cases_history_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `cases` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cases_history`
--

LOCK TABLES `cases_history` WRITE;
/*!40000 ALTER TABLE `cases_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `cases_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chipsets`
--

DROP TABLE IF EXISTS `chipsets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chipsets` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `type` char(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chipsets`
--

LOCK TABLES `chipsets` WRITE;
/*!40000 ALTER TABLE `chipsets` DISABLE KEYS */;
INSERT INTO `chipsets` VALUES (1,'Intel Z97'),(2,'Intel X99');
/*!40000 ALTER TABLE `chipsets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companys`
--

DROP TABLE IF EXISTS `companys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companys` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company` char(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companys`
--

LOCK TABLES `companys` WRITE;
/*!40000 ALTER TABLE `companys` DISABLE KEYS */;
INSERT INTO `companys` VALUES (1,'ASUS'),(2,'INTEL');
/*!40000 ALTER TABLE `companys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates`
--

DROP TABLE IF EXISTS `dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dates` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates`
--

LOCK TABLES `dates` WRITE;
/*!40000 ALTER TABLE `dates` DISABLE KEYS */;
INSERT INTO `dates` VALUES (1,'2021-01-20'),(2,'2021-02-20');
/*!40000 ALTER TABLE `dates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `display`
--

DROP TABLE IF EXISTS `display`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `display` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  `size_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `size_id` (`size_id`),
  CONSTRAINT `display_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `display_ibfk_2` FOREIGN KEY (`size_id`) REFERENCES `sizes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `display`
--

LOCK TABLES `display` WRITE;
/*!40000 ALTER TABLE `display` DISABLE KEYS */;
INSERT INTO `display` VALUES (1,1,70000,20,'AAA',3),(2,2,90000,40,'BBB',4);
/*!40000 ALTER TABLE `display` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `display_history`
--

DROP TABLE IF EXISTS `display_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `display_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `display_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `display_id` (`display_id`),
  CONSTRAINT `display_history_ibfk_1` FOREIGN KEY (`display_id`) REFERENCES `display` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `display_history`
--

LOCK TABLES `display_history` WRITE;
/*!40000 ALTER TABLE `display_history` DISABLE KEYS */;
INSERT INTO `display_history` VALUES (1,2,'2007-01-20',5),(2,2,'2021-02-20',5),(3,1,'2017-02-20',6),(4,2,'2022-02-20',3);
/*!40000 ALTER TABLE `display_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_factors`
--

DROP TABLE IF EXISTS `form_factors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_factors` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `form_factor` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_factors`
--

LOCK TABLES `form_factors` WRITE;
/*!40000 ALTER TABLE `form_factors` DISABLE KEYS */;
INSERT INTO `form_factors` VALUES (1,'ATX'),(2,'micro-ATX');
/*!40000 ALTER TABLE `form_factors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyboard_history`
--

DROP TABLE IF EXISTS `keyboard_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyboard_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `keyboard_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `keyboard_id` (`keyboard_id`),
  CONSTRAINT `keyboard_history_ibfk_1` FOREIGN KEY (`keyboard_id`) REFERENCES `keyboards` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyboard_history`
--

LOCK TABLES `keyboard_history` WRITE;
/*!40000 ALTER TABLE `keyboard_history` DISABLE KEYS */;
INSERT INTO `keyboard_history` VALUES (9,2,'2007-01-20',5),(10,2,'2021-02-20',5),(11,1,'2017-02-20',6),(12,2,'2022-02-20',3);
/*!40000 ALTER TABLE `keyboard_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyboards`
--

DROP TABLE IF EXISTS `keyboards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyboards` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `keyboards_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyboards`
--

LOCK TABLES `keyboards` WRITE;
/*!40000 ALTER TABLE `keyboards` DISABLE KEYS */;
INSERT INTO `keyboards` VALUES (1,1,8000,30,'BA'),(2,2,15000,25,'AB');
/*!40000 ALTER TABLE `keyboards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memory_sizes`
--

DROP TABLE IF EXISTS `memory_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memory_sizes` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `size` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memory_sizes`
--

LOCK TABLES `memory_sizes` WRITE;
/*!40000 ALTER TABLE `memory_sizes` DISABLE KEYS */;
INSERT INTO `memory_sizes` VALUES (1,'2GB'),(2,'4GB'),(3,'1TB'),(4,'2TB');
/*!40000 ALTER TABLE `memory_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motherboards`
--

DROP TABLE IF EXISTS `motherboards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motherboards` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  `chipset_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `chipset_id` (`chipset_id`),
  CONSTRAINT `motherboards_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `motherboards_ibfk_2` FOREIGN KEY (`chipset_id`) REFERENCES `chipsets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motherboards`
--

LOCK TABLES `motherboards` WRITE;
/*!40000 ALTER TABLE `motherboards` DISABLE KEYS */;
/*!40000 ALTER TABLE `motherboards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motherboards_history`
--

DROP TABLE IF EXISTS `motherboards_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motherboards_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `motherboard_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `motherboard_id` (`motherboard_id`),
  CONSTRAINT `motherboards_history_ibfk_1` FOREIGN KEY (`motherboard_id`) REFERENCES `motherboards` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motherboards_history`
--

LOCK TABLES `motherboards_history` WRITE;
/*!40000 ALTER TABLE `motherboards_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `motherboards_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mouses`
--

DROP TABLE IF EXISTS `mouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mouses` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `mouses_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mouses`
--

LOCK TABLES `mouses` WRITE;
/*!40000 ALTER TABLE `mouses` DISABLE KEYS */;
INSERT INTO `mouses` VALUES (1,1,7000,30,'ABA'),(2,2,12000,25,'BAB');
/*!40000 ALTER TABLE `mouses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mouses_history`
--

DROP TABLE IF EXISTS `mouses_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mouses_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `mouse_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mouse_id` (`mouse_id`),
  CONSTRAINT `mouses_history_ibfk_1` FOREIGN KEY (`mouse_id`) REFERENCES `mouses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mouses_history`
--

LOCK TABLES `mouses_history` WRITE;
/*!40000 ALTER TABLE `mouses_history` DISABLE KEYS */;
INSERT INTO `mouses_history` VALUES (1,2,'2007-01-20',5),(2,2,'2021-02-20',5),(3,1,'2017-02-20',6),(4,2,'2022-02-20',3);
/*!40000 ALTER TABLE `mouses_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power_supplies`
--

DROP TABLE IF EXISTS `power_supplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power_supplies` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  `power_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `power_id` (`power_id`),
  CONSTRAINT `power_supplies_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `power_supplies_ibfk_2` FOREIGN KEY (`power_id`) REFERENCES `powers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_supplies`
--

LOCK TABLES `power_supplies` WRITE;
/*!40000 ALTER TABLE `power_supplies` DISABLE KEYS */;
/*!40000 ALTER TABLE `power_supplies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power_supplies_history`
--

DROP TABLE IF EXISTS `power_supplies_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power_supplies_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `power_supplie_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `power_supplie_id` (`power_supplie_id`),
  CONSTRAINT `power_supplies_history_ibfk_1` FOREIGN KEY (`power_supplie_id`) REFERENCES `power_supplies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_supplies_history`
--

LOCK TABLES `power_supplies_history` WRITE;
/*!40000 ALTER TABLE `power_supplies_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `power_supplies_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `powers`
--

DROP TABLE IF EXISTS `powers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `powers` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `type` char(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `powers`
--

LOCK TABLES `powers` WRITE;
/*!40000 ALTER TABLE `powers` DISABLE KEYS */;
INSERT INTO `powers` VALUES (1,'400W'),(2,'500W');
/*!40000 ALTER TABLE `powers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sizes` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `size` float(5,1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sockets`
--

DROP TABLE IF EXISTS `sockets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sockets` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `socket` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sockets`
--

LOCK TABLES `sockets` WRITE;
/*!40000 ALTER TABLE `sockets` DISABLE KEYS */;
/*!40000 ALTER TABLE `sockets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_history`
--

DROP TABLE IF EXISTS `storage_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_history` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `storage_id` tinyint(3) unsigned NOT NULL,
  `date` date NOT NULL,
  `sale_number` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `storage_id` (`storage_id`),
  CONSTRAINT `storage_history_ibfk_1` FOREIGN KEY (`storage_id`) REFERENCES `storages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_history`
--

LOCK TABLES `storage_history` WRITE;
/*!40000 ALTER TABLE `storage_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_types`
--

DROP TABLE IF EXISTS `storage_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_types` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `type` enum('HDD','SSD') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_types`
--

LOCK TABLES `storage_types` WRITE;
/*!40000 ALTER TABLE `storage_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storages`
--

DROP TABLE IF EXISTS `storages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storages` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` tinyint(3) unsigned NOT NULL,
  `price` mediumint(8) unsigned NOT NULL,
  `number` smallint(5) unsigned NOT NULL,
  `model` char(20) NOT NULL,
  `memory_size_id` tinyint(3) unsigned NOT NULL,
  `type_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `memory_size_id` (`memory_size_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `storages_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `storages_ibfk_2` FOREIGN KEY (`memory_size_id`) REFERENCES `memory_sizes` (`id`),
  CONSTRAINT `storages_ibfk_3` FOREIGN KEY (`type_id`) REFERENCES `storage_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storages`
--

LOCK TABLES `storages` WRITE;
/*!40000 ALTER TABLE `storages` DISABLE KEYS */;
/*!40000 ALTER TABLE `storages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-27 17:52:22
