CREATE DATABASE  IF NOT EXISTS `animopts` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `animopts`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: animopts
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `idnumber` int(11) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `degree` varchar(45) NOT NULL,
  `fburl` varchar(45) NOT NULL,
  `mobilenum` varchar(9) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(40) NOT NULL,
  `accountlevel` int(11) NOT NULL,
  PRIMARY KEY (`idnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (11291247,'Ngo','Courtney','CS-ST','asd','90123123','courtney@gmail.com','7ce0359f12857f2a90c7de465f40a95f01cb5da9',1),(11311234,'Ambion','Gaius','BSCS','http://google.com','1234','gaius_ambion@dlsu.edu.ph','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11398765,'Penaranda','Brandon','BSCS-CSE','http://google.com','1234456','brandon_penaranda@dlsu.edu.ph','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11400001,'Poe','Totoro','BSCS','http://google.com','061234567','totoropoe@gmail.com','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11400002,'Tu','Ho','CS-ST','http://google.com','061234567','ho.tu@gmail.com','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11400003,'Mi','Dana','CS-NE','http://google.com','061234567','dana.mi@gmail.com','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11400004,'Wei','Grad','CS-IST','http://google.com','061234567','gradwei@gmail.com','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11400005,'Ko','Sumu','BSCS-CSE','http://google.com','061234567','sumu.ko@gmail.com','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11400006,'Ace','Pretty','BS-INSYS','http://google.com','061234567','pretty.ace@pts.com','250e77f12a5ab6972a0895d290c4792f0a326ea8',2),(11400007,'Lit','Maku','BSIT','http://google.com','061234567','maku.lit@ako.com','250e77f12a5ab6972a0895d290c4792f0a326ea8',1),(11427817,'Reamon','Gelo','CS-IST','http://google.com','0987000','david_reamon@dlsu.edu.ph','250e77f12a5ab6972a0895d290c4792f0a326ea8',3);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activatedtutor`
--

DROP TABLE IF EXISTS `activatedtutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activatedtutor` (
  `idnumber` int(11) NOT NULL,
  `maxtutorcount` int(11) NOT NULL,
  PRIMARY KEY (`idnumber`),
  CONSTRAINT `fk_activatedtutor_idnumber` FOREIGN KEY (`idnumber`) REFERENCES `account` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activatedtutor`
--

LOCK TABLES `activatedtutor` WRITE;
/*!40000 ALTER TABLE `activatedtutor` DISABLE KEYS */;
INSERT INTO `activatedtutor` VALUES (11311234,1),(11398765,5),(11400001,0),(11400002,0),(11427817,5);
/*!40000 ALTER TABLE `activatedtutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deactivatedtutor`
--

DROP TABLE IF EXISTS `deactivatedtutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deactivatedtutor` (
  `idnumber` int(11) NOT NULL,
  PRIMARY KEY (`idnumber`),
  CONSTRAINT `fk_deactivatedtutor_idnumber` FOREIGN KEY (`idnumber`) REFERENCES `account` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deactivatedtutor`
--

LOCK TABLES `deactivatedtutor` WRITE;
/*!40000 ALTER TABLE `deactivatedtutor` DISABLE KEYS */;
INSERT INTO `deactivatedtutor` VALUES (11400004);
/*!40000 ALTER TABLE `deactivatedtutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluation` (
  `evaluationid` int(11) NOT NULL AUTO_INCREMENT,
  `requesttutorid` int(11) NOT NULL,
  `freq` tinyint(4) NOT NULL DEFAULT '0',
  `prep` tinyint(4) NOT NULL DEFAULT '0',
  `exp` tinyint(4) NOT NULL DEFAULT '0',
  `exc` tinyint(4) NOT NULL DEFAULT '0',
  `rel` tinyint(4) NOT NULL DEFAULT '0',
  `ent` tinyint(4) NOT NULL DEFAULT '0',
  `con` tinyint(4) NOT NULL DEFAULT '0',
  `kno` tinyint(4) NOT NULL DEFAULT '0',
  `voc` tinyint(4) NOT NULL DEFAULT '0',
  `que` tinyint(4) NOT NULL DEFAULT '0',
  `eff` tinyint(4) NOT NULL DEFAULT '0',
  `enc` tinyint(4) NOT NULL DEFAULT '0',
  `pas` tinyint(4) NOT NULL DEFAULT '0',
  `message` varchar(200) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `tutee_lrn` tinyint(4) NOT NULL DEFAULT '0',
  `tutee_und` tinyint(4) NOT NULL DEFAULT '0',
  `tutee_eff` tinyint(4) NOT NULL DEFAULT '0',
  `sent` tinyint(4) NOT NULL DEFAULT '0',
  `read` tinyint(4) NOT NULL DEFAULT '0',
  `answered` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`evaluationid`),
  KEY `fk_evaluation_requesttutorid_idx` (`requesttutorid`),
  CONSTRAINT `fk_evaluation_requesttutorid` FOREIGN KEY (`requesttutorid`) REFERENCES `requesttutor` (`requesttutorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation`
--

LOCK TABLES `evaluation` WRITE;
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
INSERT INTO `evaluation` VALUES (1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,NULL,NULL,0,0,0,0,0,0),(2,8,0,0,0,0,0,0,0,0,0,0,0,0,0,NULL,NULL,0,0,0,0,0,0),(3,9,0,0,0,0,0,0,0,0,0,0,0,0,0,NULL,NULL,0,0,0,0,0,0),(4,10,0,0,0,0,0,0,0,0,0,0,0,0,0,NULL,NULL,0,0,0,0,0,0);
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `global`
--

DROP TABLE IF EXISTS `global`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `global` (
  `globalid` int(11) NOT NULL AUTO_INCREMENT,
  `term` tinyint(4) NOT NULL,
  `year` year(4) NOT NULL,
  `enable_tutorapp` tinyint(4) NOT NULL,
  `enable_tutorreq` tinyint(4) NOT NULL,
  PRIMARY KEY (`globalid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `global`
--

LOCK TABLES `global` WRITE;
/*!40000 ALTER TABLE `global` DISABLE KEYS */;
INSERT INTO `global` VALUES (1,3,2015,1,1);
/*!40000 ALTER TABLE `global` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officer`
--

DROP TABLE IF EXISTS `officer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `officer` (
  `activatedtutorid` int(11) NOT NULL,
  `officerpositionid` int(11) NOT NULL,
  PRIMARY KEY (`activatedtutorid`),
  KEY `fk_officer_officerpositionid_idx` (`officerpositionid`),
  CONSTRAINT `fk_officer_activatedtutorid` FOREIGN KEY (`activatedtutorid`) REFERENCES `activatedtutor` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_officer_officerpositionid` FOREIGN KEY (`officerpositionid`) REFERENCES `officerposition` (`idofficerposition`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officer`
--

LOCK TABLES `officer` WRITE;
/*!40000 ALTER TABLE `officer` DISABLE KEYS */;
/*!40000 ALTER TABLE `officer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officerposition`
--

DROP TABLE IF EXISTS `officerposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `officerposition` (
  `idofficerposition` int(11) NOT NULL AUTO_INCREMENT,
  `officertitle` varchar(45) NOT NULL,
  PRIMARY KEY (`idofficerposition`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officerposition`
--

LOCK TABLES `officerposition` WRITE;
/*!40000 ALTER TABLE `officerposition` DISABLE KEYS */;
/*!40000 ALTER TABLE `officerposition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pendingtutor`
--

DROP TABLE IF EXISTS `pendingtutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pendingtutor` (
  `idnumber` int(11) NOT NULL,
  `currinvolvement` varchar(200) NOT NULL,
  `reasonforjoining` varchar(200) NOT NULL,
  PRIMARY KEY (`idnumber`),
  CONSTRAINT `fk_pendingtutor_idnumber` FOREIGN KEY (`idnumber`) REFERENCES `account` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pendingtutor`
--

LOCK TABLES `pendingtutor` WRITE;
/*!40000 ALTER TABLE `pendingtutor` DISABLE KEYS */;
INSERT INTO `pendingtutor` VALUES (11291247,'sd','sx'),(11400003,'Finland Exchange Student Program','because dana mi'),(11400005,'siya','kasi kahit ako ay sumu ko, andiyan parin ako para sayo');
/*!40000 ALTER TABLE `pendingtutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prefsubject`
--

DROP TABLE IF EXISTS `prefsubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prefsubject` (
  `prefsubjectid` int(11) NOT NULL AUTO_INCREMENT,
  `activatedtutorid` int(11) NOT NULL,
  `subjectid` int(11) NOT NULL,
  PRIMARY KEY (`prefsubjectid`),
  KEY `fk_prefsubject_tutorid_idx` (`activatedtutorid`),
  KEY `fk_prefsubject_subjectid_idx` (`subjectid`),
  CONSTRAINT `fk_prefsubject_activatedtutorid` FOREIGN KEY (`activatedtutorid`) REFERENCES `activatedtutor` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_prefsubject_subjectid` FOREIGN KEY (`subjectid`) REFERENCES `subjecttopic` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prefsubject`
--

LOCK TABLES `prefsubject` WRITE;
/*!40000 ALTER TABLE `prefsubject` DISABLE KEYS */;
/*!40000 ALTER TABLE `prefsubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preftutorial`
--

DROP TABLE IF EXISTS `preftutorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preftutorial` (
  `preftutorialid` int(11) NOT NULL AUTO_INCREMENT,
  `activatedtutorid` int(11) NOT NULL,
  `solo` tinyint(4) NOT NULL,
  `pair` tinyint(4) NOT NULL,
  `group` tinyint(4) NOT NULL,
  `classroom` tinyint(4) NOT NULL,
  PRIMARY KEY (`preftutorialid`),
  KEY `fk_preftutorial_activatedtutorid_idx` (`activatedtutorid`),
  CONSTRAINT `fk_preftutorial_activatedtutorid` FOREIGN KEY (`activatedtutorid`) REFERENCES `activatedtutor` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preftutorial`
--

LOCK TABLES `preftutorial` WRITE;
/*!40000 ALTER TABLE `preftutorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `preftutorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejectedtutor`
--

DROP TABLE IF EXISTS `rejectedtutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejectedtutor` (
  `idnumber` int(11) NOT NULL,
  `rejectionreason` varchar(200) NOT NULL,
  PRIMARY KEY (`idnumber`),
  CONSTRAINT `fk_rejectedtutor_idnumber` FOREIGN KEY (`idnumber`) REFERENCES `account` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejectedtutor`
--

LOCK TABLES `rejectedtutor` WRITE;
/*!40000 ALTER TABLE `rejectedtutor` DISABLE KEYS */;
INSERT INTO `rejectedtutor` VALUES (11400006,'secret'),(11400007,'secret');
/*!40000 ALTER TABLE `rejectedtutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestschedule`
--

DROP TABLE IF EXISTS `requestschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestschedule` (
  `requestscheduleid` int(11) NOT NULL AUTO_INCREMENT,
  `requesttutorid` int(11) NOT NULL,
  `day` tinyint(4) NOT NULL,
  `time` varchar(5) NOT NULL,
  PRIMARY KEY (`requestscheduleid`),
  KEY `fk_requestschedule_requesttutorid_idx` (`requesttutorid`),
  CONSTRAINT `fk_requestschedule_requesttutorid` FOREIGN KEY (`requesttutorid`) REFERENCES `requesttutor` (`requesttutorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestschedule`
--

LOCK TABLES `requestschedule` WRITE;
/*!40000 ALTER TABLE `requestschedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `requestschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requesttutor`
--

DROP TABLE IF EXISTS `requesttutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requesttutor` (
  `requesttutorid` int(11) NOT NULL AUTO_INCREMENT,
  `tuteeid` int(11) NOT NULL,
  `preftutorid` int(11) DEFAULT NULL,
  `assignedtutorid` int(11) DEFAULT NULL,
  `subjectid` int(11) NOT NULL,
  `term` tinyint(4) NOT NULL,
  `year` year(4) NOT NULL,
  `tutorialtype` tinyint(4) NOT NULL,
  PRIMARY KEY (`requesttutorid`),
  KEY `fk_requesttutor_tuteeid_idx` (`tuteeid`),
  KEY `fk_requesttutor_preftutorid_idx` (`preftutorid`),
  KEY `fk_requesttutor_assignedtutorid_idx` (`assignedtutorid`),
  KEY `fk_requesttutor_subjectid_idx` (`subjectid`),
  CONSTRAINT `fk_requesttutor_assignedtutorid` FOREIGN KEY (`assignedtutorid`) REFERENCES `account` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_requesttutor_preftutorid` FOREIGN KEY (`preftutorid`) REFERENCES `account` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_requesttutor_subjectid` FOREIGN KEY (`subjectid`) REFERENCES `subjecttopic` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_requesttutor_tuteeid` FOREIGN KEY (`tuteeid`) REFERENCES `account` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requesttutor`
--

LOCK TABLES `requesttutor` WRITE;
/*!40000 ALTER TABLE `requesttutor` DISABLE KEYS */;
INSERT INTO `requesttutor` VALUES (2,11427817,11311234,11311234,2,3,2015,2),(8,11427817,NULL,11400001,3,3,2015,3),(9,11427817,11311234,NULL,5,3,2015,1),(10,11398765,11311234,11311234,4,3,2015,3),(11,11291247,11311234,NULL,7,3,2015,1);
/*!40000 ALTER TABLE `requesttutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjecttopic`
--

DROP TABLE IF EXISTS `subjecttopic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjecttopic` (
  `subjectid` int(11) NOT NULL AUTO_INCREMENT,
  `subjectname` varchar(45) NOT NULL,
  `isoffered` tinyint(4) NOT NULL,
  PRIMARY KEY (`subjectid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjecttopic`
--

LOCK TABLES `subjecttopic` WRITE;
/*!40000 ALTER TABLE `subjecttopic` DISABLE KEYS */;
INSERT INTO `subjecttopic` VALUES (1,'COMPRO1',1),(2,'COMPRO2',1),(3,'C Programming',1),(4,'OBJECTP',1),(5,'Java Programming',1),(6,'CCSCAL1',0),(7,'CCSCAL2',1);
/*!40000 ALTER TABLE `subjecttopic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `tagid` int(11) NOT NULL AUTO_INCREMENT,
  `subjectid` int(11) NOT NULL,
  `tagname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tagid`),
  KEY `fk_tag_subjectid_idx` (`subjectid`),
  CONSTRAINT `fk_tag_subjectid` FOREIGN KEY (`subjectid`) REFERENCES `subjecttopic` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,1,'C'),(2,1,'Programming'),(3,2,'C'),(4,2,'Programming'),(5,6,'Calculus'),(6,7,'Calculus'),(7,4,'OOP');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutorschedule`
--

DROP TABLE IF EXISTS `tutorschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tutorschedule` (
  `tutorscheduleid` int(11) NOT NULL AUTO_INCREMENT,
  `day` tinyint(4) NOT NULL,
  `time` varchar(5) NOT NULL,
  `activatedtutorid` int(11) NOT NULL,
  PRIMARY KEY (`tutorscheduleid`),
  KEY `fk_tutorschedule_activatedtutorid_idx` (`activatedtutorid`),
  CONSTRAINT `fk_tutorschedule_activatedtutorid` FOREIGN KEY (`activatedtutorid`) REFERENCES `activatedtutor` (`idnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutorschedule`
--

LOCK TABLES `tutorschedule` WRITE;
/*!40000 ALTER TABLE `tutorschedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutorschedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-15 18:59:09
