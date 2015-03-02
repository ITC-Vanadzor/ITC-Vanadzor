-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: computer_shop
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
-- Table structure for table `Chipset`
--

DROP TABLE IF EXISTS `Chipset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Chipset` (
  `id_chipset` int(3) NOT NULL AUTO_INCREMENT,
  `type` varchar(15) NOT NULL,
  PRIMARY KEY (`id_chipset`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Chipset`
--

LOCK TABLES `Chipset` WRITE;
/*!40000 ALTER TABLE `Chipset` DISABLE KEYS */;
INSERT INTO `Chipset` VALUES (1,'Intel Z97'),(2,'Intel X99');
/*!40000 ALTER TABLE `Chipset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Company`
--

DROP TABLE IF EXISTS `Company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Company` (
  `id_company` int(3) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(25) NOT NULL,
  PRIMARY KEY (`id_company`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Company`
--

LOCK TABLES `Company` WRITE;
/*!40000 ALTER TABLE `Company` DISABLE KEYS */;
INSERT INTO `Company` VALUES (1,'ASUS'),(2,'INTEL'),(3,'LG');
/*!40000 ALTER TABLE `Company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Data`
--

DROP TABLE IF EXISTS `Data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Data` (
  `id_data` int(3) NOT NULL AUTO_INCREMENT,
  `product_id` int(3) NOT NULL,
  `company_id` int(3) NOT NULL,
  `price` int(10) NOT NULL,
  `count` int(3) NOT NULL,
  `model` varchar(20) NOT NULL,
  PRIMARY KEY (`id_data`),
  KEY `product_id` (`product_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `Data_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `Products` (`id_product`),
  CONSTRAINT `Data_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `Company` (`id_company`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Data`
--

LOCK TABLES `Data` WRITE;
/*!40000 ALTER TABLE `Data` DISABLE KEYS */;
/*!40000 ALTER TABLE `Data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Form_factor`
--

DROP TABLE IF EXISTS `Form_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Form_factor` (
  `id_form_factor` int(3) NOT NULL AUTO_INCREMENT,
  `form_factor` varchar(10) NOT NULL,
  PRIMARY KEY (`id_form_factor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Form_factor`
--

LOCK TABLES `Form_factor` WRITE;
/*!40000 ALTER TABLE `Form_factor` DISABLE KEYS */;
INSERT INTO `Form_factor` VALUES (1,'ATX'),(2,'micro-ATX');
/*!40000 ALTER TABLE `Form_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Memory_size`
--

DROP TABLE IF EXISTS `Memory_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Memory_size` (
  `id_memory_size` int(3) NOT NULL AUTO_INCREMENT,
  `size` varchar(10) NOT NULL,
  PRIMARY KEY (`id_memory_size`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Memory_size`
--

LOCK TABLES `Memory_size` WRITE;
/*!40000 ALTER TABLE `Memory_size` DISABLE KEYS */;
INSERT INTO `Memory_size` VALUES (1,'2GB'),(2,'4GB'),(3,'1TB'),(4,'2TB');
/*!40000 ALTER TABLE `Memory_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Memory_type`
--

DROP TABLE IF EXISTS `Memory_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Memory_type` (
  `id_memory_type` int(3) NOT NULL AUTO_INCREMENT,
  `type` varchar(15) NOT NULL,
  PRIMARY KEY (`id_memory_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Memory_type`
--

LOCK TABLES `Memory_type` WRITE;
/*!40000 ALTER TABLE `Memory_type` DISABLE KEYS */;
INSERT INTO `Memory_type` VALUES (1,'DDR3'),(2,'DDR4');
/*!40000 ALTER TABLE `Memory_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Parameters`
--

DROP TABLE IF EXISTS `Parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Parameters` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `socket_id` int(3) DEFAULT NULL,
  `memory_size_id` int(3) DEFAULT NULL,
  `memory_type_id` int(3) DEFAULT NULL,
  `chipset_id` int(3) DEFAULT NULL,
  `power_id` int(3) DEFAULT NULL,
  `storage_type_id` int(3) DEFAULT NULL,
  `form_factor_id` int(3) DEFAULT NULL,
  `size_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `socket_id` (`socket_id`),
  KEY `memory_size_id` (`memory_size_id`),
  KEY `memory_type_id` (`memory_type_id`),
  KEY `power_id` (`power_id`),
  KEY `storage_type_id` (`storage_type_id`),
  KEY `form_factor_id` (`form_factor_id`),
  KEY `size_id` (`size_id`),
  CONSTRAINT `Parameters_ibfk_1` FOREIGN KEY (`socket_id`) REFERENCES `Socket` (`id_socket`),
  CONSTRAINT `Parameters_ibfk_2` FOREIGN KEY (`memory_size_id`) REFERENCES `Memory_size` (`id_memory_size`),
  CONSTRAINT `Parameters_ibfk_3` FOREIGN KEY (`memory_type_id`) REFERENCES `Memory_type` (`id_memory_type`),
  CONSTRAINT `Parameters_ibfk_4` FOREIGN KEY (`power_id`) REFERENCES `Power` (`id_power`),
  CONSTRAINT `Parameters_ibfk_5` FOREIGN KEY (`storage_type_id`) REFERENCES `Storage_type` (`id_storage_type`),
  CONSTRAINT `Parameters_ibfk_6` FOREIGN KEY (`form_factor_id`) REFERENCES `Form_factor` (`id_form_factor`),
  CONSTRAINT `Parameters_ibfk_7` FOREIGN KEY (`size_id`) REFERENCES `Size` (`id_size`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parameters`
--

LOCK TABLES `Parameters` WRITE;
/*!40000 ALTER TABLE `Parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `Parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Power`
--

DROP TABLE IF EXISTS `Power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Power` (
  `id_power` int(3) NOT NULL AUTO_INCREMENT,
  `power` varchar(10) NOT NULL,
  PRIMARY KEY (`id_power`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Power`
--

LOCK TABLES `Power` WRITE;
/*!40000 ALTER TABLE `Power` DISABLE KEYS */;
INSERT INTO `Power` VALUES (1,'400W'),(2,'500W');
/*!40000 ALTER TABLE `Power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product_model_parameters`
--

DROP TABLE IF EXISTS `Product_model_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product_model_parameters` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `data_id` int(3) NOT NULL,
  `parameter_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `data_id` (`data_id`),
  KEY `parameter_id` (`parameter_id`),
  CONSTRAINT `Product_model_parameters_ibfk_1` FOREIGN KEY (`data_id`) REFERENCES `Data` (`id_data`),
  CONSTRAINT `Product_model_parameters_ibfk_2` FOREIGN KEY (`parameter_id`) REFERENCES `Parameters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product_model_parameters`
--

LOCK TABLES `Product_model_parameters` WRITE;
/*!40000 ALTER TABLE `Product_model_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `Product_model_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Products`
--

DROP TABLE IF EXISTS `Products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Products` (
  `id_product` int(3) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Products`
--

LOCK TABLES `Products` WRITE;
/*!40000 ALTER TABLE `Products` DISABLE KEYS */;
INSERT INTO `Products` VALUES (1,'CPU'),(2,'GPU'),(3,'RAM'),(4,'Case'),(5,'Display'),(6,'Keyboard'),(7,'Mouse'),(8,'Motherboard'),(9,'Power_supplies'),(10,'Storage'),(11,'Videocard');
/*!40000 ALTER TABLE `Products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Realization`
--

DROP TABLE IF EXISTS `Realization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Realization` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `product_parameters_id` int(3) NOT NULL,
  `date` date NOT NULL,
  `sale_number` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_parameters_id` (`product_parameters_id`),
  CONSTRAINT `Realization_ibfk_1` FOREIGN KEY (`product_parameters_id`) REFERENCES `Product_model_parameters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Realization`
--

LOCK TABLES `Realization` WRITE;
/*!40000 ALTER TABLE `Realization` DISABLE KEYS */;
/*!40000 ALTER TABLE `Realization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Size`
--

DROP TABLE IF EXISTS `Size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Size` (
  `id_size` int(3) NOT NULL AUTO_INCREMENT,
  `size` float(5,1) NOT NULL,
  PRIMARY KEY (`id_size`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Size`
--

LOCK TABLES `Size` WRITE;
/*!40000 ALTER TABLE `Size` DISABLE KEYS */;
/*!40000 ALTER TABLE `Size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Socket`
--

DROP TABLE IF EXISTS `Socket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Socket` (
  `id_socket` int(3) NOT NULL AUTO_INCREMENT,
  `socket` varchar(10) NOT NULL,
  PRIMARY KEY (`id_socket`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Socket`
--

LOCK TABLES `Socket` WRITE;
/*!40000 ALTER TABLE `Socket` DISABLE KEYS */;
INSERT INTO `Socket` VALUES (1,'G2'),(2,'C32'),(3,'H');
/*!40000 ALTER TABLE `Socket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Storage_type`
--

DROP TABLE IF EXISTS `Storage_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Storage_type` (
  `id_storage_type` int(3) NOT NULL AUTO_INCREMENT,
  `type` enum('HDD','SSD') NOT NULL,
  PRIMARY KEY (`id_storage_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Storage_type`
--

LOCK TABLES `Storage_type` WRITE;
/*!40000 ALTER TABLE `Storage_type` DISABLE KEYS */;
INSERT INTO `Storage_type` VALUES (1,'HDD'),(3,'SSD');
/*!40000 ALTER TABLE `Storage_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-02 12:23:07
