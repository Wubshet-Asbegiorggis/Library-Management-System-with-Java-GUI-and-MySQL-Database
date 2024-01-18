-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Book_ID` varchar(45) NOT NULL,
  `Book_Name` varchar(45) DEFAULT NULL,
  `Book_Author` varchar(45) DEFAULT NULL,
  `Publication_Date` varchar(45) DEFAULT NULL,
  `Book_Type` varchar(45) DEFAULT NULL,
  `Book_Price` varchar(45) DEFAULT NULL,
  `Book_Description` varchar(45) DEFAULT NULL,
  `Total_No` int DEFAULT NULL,
  PRIMARY KEY (`ID`,`Book_ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `Book_ID_UNIQUE` (`Book_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (2,'lfkvj','m mm','m nmvnm','mn mkvk','mn hhh','3453','mnmnknk nm nfm nm',15),(3,',mvkfmvkl','jn vjdfnjk','jdncjdn','kdnknmd','jdn kn','344','mn jn jn jn',0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librarian` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `librarian_ID` varchar(45) NOT NULL,
  `librarian_name` varchar(45) DEFAULT NULL,
  `Phone_Nol` varchar(45) DEFAULT NULL,
  `librarian_email` varchar(45) DEFAULT NULL,
  `librarian_Address` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `UserName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`,`librarian_ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `librarian_email_UNIQUE` (`librarian_email`),
  UNIQUE KEY `Password_UNIQUE` (`Password`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian`
--

LOCK TABLES `librarian` WRITE;
/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` VALUES (1,'9876','Hayle Mengstu','0965432343','hayle2@gmail.com','Addis Ababa,4kilo','hayle123','hayle12'),(2,'2884','Alemu Sisay','0987456321','alemu@gmail.com','Addis Ababa','alemu123','alemu12'),(4,'2343','werku','0987364521','werku@gmail.com','Addis Ababa','werku123','werku12'),(5,'12345','kebede goshu','0978564323','kebe@gmail.com','Addis Ababa','kebe123','kebe12'),(8,'443','mkmkm','mkmkm','km m m,m ','knmkmnknmk','knjknjkn','bbbbbbbbbbbbb');
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `student_ID` varchar(45) NOT NULL,
  `student_name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `Student_email` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `UserName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`,`student_ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `student_id_UNIQUE` (`student_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'ugr/9738/13','kidus birhane','0974156202','kidusbirhane9@gmail.com','Amhara,North shewa','Kid123','kid'),(3,'UGR/4470/13','Mesay Berhane','0908279119','mesay@gmail.com','Ethiopia , Hawasa','mesay123','mesay12'),(15,'ugr/9898/13','kebede nugus','0987654398','kebe@gmail.com','Addis Ababa','kebe123','kebe12');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-01  7:47:27
