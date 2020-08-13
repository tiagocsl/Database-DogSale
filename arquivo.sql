-- MySQL dump 10.13  Distrib 5.5.55, for Win64 (AMD64)
--
-- Host: localhost    Database: dogsale
-- ------------------------------------------------------
-- Server version	5.5.55-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complement` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpo044ng5x4gynb291cv24vtea` (`city_id`),
  KEY `FK7156ty2o5atyuy9f6kuup9dna` (`client_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'','Jardim Monumento','941','Rua Luiz Abrahao','13405186',1,1),(2,'Apto 59','Icarai','76','Rua Presidente Backer','24220041',2,2),(3,'','Vila Centenario','39','Rua Leopoldina Tome','25030050',3,3),(4,'','Vila Santa Cruz','70','Rua Maria da Silva','25260290',3,4),(5,'casa 2','São Judas Tadeu','12','Rua Edson Ramalhete Coutinho','29200570',4,5),(6,'','Ipiranga','310','Rua Ouro Preto','29201105',4,5);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_slip_payment`
--

DROP TABLE IF EXISTS `bank_slip_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_slip_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bkstatus` int(11) DEFAULT NULL,
  `duedate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_slip_payment`
--

LOCK TABLES `bank_slip_payment` WRITE;
/*!40000 ALTER TABLE `bank_slip_payment` DISABLE KEYS */;
INSERT INTO `bank_slip_payment` VALUES (1,3,'2019-10-19 00:00:00'),(2,3,'2019-12-02 00:00:00'),(3,2,'2019-12-09 00:00:00');
/*!40000 ALTER TABLE `bank_slip_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `breed`
--

DROP TABLE IF EXISTS `breed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `breed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `breed`
--

LOCK TABLES `breed` WRITE;
/*!40000 ALTER TABLE `breed` DISABLE KEYS */;
INSERT INTO `breed` VALUES (1,'Golden Retriever',1200),(2,'Duck Tolling Retriever',17800),(3,'Flat Coated Retriever',5300),(4,'Labrador Retriever',1900),(5,'Chesapeake Bay Retriever',26280),(6,'Curly Coated Retriever',6680),(7,'Husky Siberiano',2300),(8,'Malamute Do Alasca',2400),(9,'Chow Chow',1200),(10,'Samoieda',3600),(11,'Shiba Inu',5800),(12,'Eurasier',3900);
/*!40000 ALTER TABLE `breed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `breed_clazz`
--

DROP TABLE IF EXISTS `breed_clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `breed_clazz` (
  `breed_id` int(11) NOT NULL,
  `clazz_id` int(11) NOT NULL,
  KEY `FK4ajur8qs8vi2kaiap18mx97ug` (`clazz_id`),
  KEY `FK24g8m1f8wviwius8ayn7dmn3l` (`breed_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `breed_clazz`
--

LOCK TABLES `breed_clazz` WRITE;
/*!40000 ALTER TABLE `breed_clazz` DISABLE KEYS */;
INSERT INTO `breed_clazz` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2);
/*!40000 ALTER TABLE `breed_clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_payment`
--

DROP TABLE IF EXISTS `card_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cstatus` int(11) DEFAULT NULL,
  `number_of_installments` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_payment`
--

LOCK TABLES `card_payment` WRITE;
/*!40000 ALTER TABLE `card_payment` DISABLE KEYS */;
INSERT INTO `card_payment` VALUES (1,1,2),(2,2,1),(3,1,3);
/*!40000 ALTER TABLE `card_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6p2u50v8fg2y0js6djc6xanit` (`state_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Piracicaba',1),(2,'Niterói',2),(3,'Duque de Caxias',2),(4,'Guarapari',3);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'Retriever, Levantador e Cao Dagua'),(2,'Spitz'),(3,'Terrier'),(4,'Cao de Guarda, Trabalho e Utilidade'),(5,'Pastor e Boiadeiro'),(6,'Sabujo e Farejador'),(7,'Apontadores'),(8,'Companhia'),(9,'Lebreis ou Galgos');
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf_or_cnpj` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bfgjs3fem0hmjhvih80158x29` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'16897548535','Jmendes@hotmail.com','Jailson Mendes',1),(2,'48625734957','TiringaYTB@outlook.com','Tiringa',1),(3,'34897628469','PartiuMagrelin@live.com','Magrelinho',1),(4,'56092292000194','VairusTuKu@gmail.com','Corona Vairus',2),(5,'79541055000169','CorongaV@outlook.com','Coronga Vairus',2);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_item`
--

DROP TABLE IF EXISTS `ordered_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordered_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `breed_id` int(11) DEFAULT NULL,
  `purchase_order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa3v7l0emjlw4hwdbujr36ova1` (`breed_id`),
  KEY `FKs32h1go9l017liljliodj01cj` (`purchase_order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_item`
--

LOCK TABLES `ordered_item` WRITE;
/*!40000 ALTER TABLE `ordered_item` DISABLE KEYS */;
INSERT INTO `ordered_item` VALUES (1,1,0,1,5300,3,1),(2,1,0,1,1200,1,2),(3,1,0,0,1200,1,2),(4,1,0,1,1900,4,3),(5,1,4450,1,17800,2,4),(6,1,4450,0,17800,2,4),(7,1,360,1,2400,8,5),(8,1,360,0,2400,8,5),(9,1,0,0,5300,9,6);
/*!40000 ALTER TABLE `ordered_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payday` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `bank_slip_id` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg1f41iov6ubgl4n90y9rt91yp` (`bank_slip_id`),
  KEY `FKdonrwnyieqp8oo7p5c6ym7jig` (`card_id`),
  KEY `FK1gynfawdj4ts2b4wmh35nhmec` (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'2019-09-30 12:49:00',2,NULL,1,1),(2,'2019-10-17 14:27:00',2,1,NULL,2),(3,NULL,3,NULL,2,3),(4,'2019-12-01 18:53:00',2,2,NULL,4),(5,'2019-12-06 20:05:00',2,NULL,3,5),(6,NULL,3,3,NULL,6);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `momment` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `delivery_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30v1b5ywmk0n0rasy577mcijx` (`client_id`),
  KEY `FKt0q6r5vise2om6wjs43o3fn97` (`delivery_address_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
INSERT INTO `purchase_order` VALUES (1,'2019-09-30 12:48:00',1,1,1),(2,'2019-10-16 10:27:00',2,2,2),(3,'2019-11-21 07:31:00',1,3,3),(4,'2019-11-29 17:18:00',2,4,4),(5,'2019-12-06 20:04:00',1,5,5),(6,'2019-12-06 20:04:00',2,5,6);
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'São Paulo'),(2,'Rio de Janeiro'),(3,'Espirito Santo');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tellphone`
--

DROP TABLE IF EXISTS `tellphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tellphone` (
  `client_id` int(11) NOT NULL,
  `tellphones` varchar(255) DEFAULT NULL,
  KEY `FKieiye4gk92voj7jneo38ow7dv` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tellphone`
--

LOCK TABLES `tellphone` WRITE;
/*!40000 ALTER TABLE `tellphone` DISABLE KEYS */;
INSERT INTO `tellphone` VALUES (1,'36789458'),(1,'984753218'),(2,'978945843'),(2,'27859845'),(3,'954780469'),(3,'24984812'),(4,'997584216'),(4,'27758498'),(5,'997851607'),(5,'58607945');
/*!40000 ALTER TABLE `tellphone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-05 12:03:36
