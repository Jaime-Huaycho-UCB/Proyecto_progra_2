-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: 192.168.1.190    Database: ProyectoProgra2
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CIUDADES`
--

DROP TABLE IF EXISTS `CIUDADES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CIUDADES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CIUDADES`
--

LOCK TABLES `CIUDADES` WRITE;
/*!40000 ALTER TABLE `CIUDADES` DISABLE KEYS */;
INSERT INTO `CIUDADES` VALUES (1,'Beni'),(2,'Cochabamba'),(3,'Chuquisaca'),(4,'La Paz'),(5,'Oruro'),(6,'Pando'),(7,'Potosi'),(8,'Tarija'),(9,'Santa Cruz'),(10,'Buenos Aires'),(11,'Cordoba'),(12,'Rosario'),(13,'Mendoza'),(14,'La Plata'),(15,'Tucuman'),(16,'Mar de Plata'),(17,'Salta'),(18,'Santa Fe'),(19,'San Juan'),(20,'Resistencia'),(21,'Neuquen'),(22,'Santiago del Estero'),(23,'Corrientes'),(24,'Bahia Blanca'),(25,'San Salvador'),(26,'Posadas'),(27,'Parana'),(28,'Formosa'),(29,'San Miguel');
/*!40000 ALTER TABLE `CIUDADES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CIUDADES_PAIS`
--

DROP TABLE IF EXISTS `CIUDADES_PAIS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CIUDADES_PAIS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPais` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idPais` (`idPais`),
  KEY `idCiudad` (`idCiudad`),
  CONSTRAINT `ciudades_pais_ibfk_1` FOREIGN KEY (`idPais`) REFERENCES `PAISES` (`id`),
  CONSTRAINT `ciudades_pais_ibfk_2` FOREIGN KEY (`idCiudad`) REFERENCES `CIUDADES` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CIUDADES_PAIS`
--

LOCK TABLES `CIUDADES_PAIS` WRITE;
/*!40000 ALTER TABLE `CIUDADES_PAIS` DISABLE KEYS */;
INSERT INTO `CIUDADES_PAIS` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,2,10),(11,2,11),(12,2,12),(13,2,13),(14,2,14),(15,2,15),(16,2,16),(17,2,17),(18,2,18),(19,2,19),(20,2,20),(21,2,21),(22,2,22),(23,2,23),(24,2,24),(25,2,25),(26,2,26),(27,2,27),(28,2,28),(29,2,29);
/*!40000 ALTER TABLE `CIUDADES_PAIS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUENTAS_AHORRO`
--

DROP TABLE IF EXISTS `CUENTAS_AHORRO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CUENTAS_AHORRO` (
  `numeroCuenta` decimal(14,0) NOT NULL,
  `ciPersona` decimal(7,0) NOT NULL,
  `tipo` int(11) NOT NULL,
  `fechaApertura` date NOT NULL,
  `saldo` double(10,2) NOT NULL,
  PRIMARY KEY (`numeroCuenta`),
  KEY `ciPersona` (`ciPersona`),
  KEY `tipo` (`tipo`),
  CONSTRAINT `cuentas_ahorro_ibfk_1` FOREIGN KEY (`ciPersona`) REFERENCES `PERSONAS` (`ci`),
  CONSTRAINT `cuentas_ahorro_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `TIPOS_CUENTA` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUENTAS_AHORRO`
--

LOCK TABLES `CUENTAS_AHORRO` WRITE;
/*!40000 ALTER TABLE `CUENTAS_AHORRO` DISABLE KEYS */;
INSERT INTO `CUENTAS_AHORRO` VALUES (12382962,8461662,13,'2024-06-20',1500.00),(12785336,8343043,10,'2024-06-09',500.00);
/*!40000 ALTER TABLE `CUENTAS_AHORRO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GENEROS`
--

DROP TABLE IF EXISTS `GENEROS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GENEROS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GENEROS`
--

LOCK TABLES `GENEROS` WRITE;
/*!40000 ALTER TABLE `GENEROS` DISABLE KEYS */;
INSERT INTO `GENEROS` VALUES (1,'Femenino'),(2,'Masculino');
/*!40000 ALTER TABLE `GENEROS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAISES`
--

DROP TABLE IF EXISTS `PAISES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PAISES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAISES`
--

LOCK TABLES `PAISES` WRITE;
/*!40000 ALTER TABLE `PAISES` DISABLE KEYS */;
INSERT INTO `PAISES` VALUES (1,'Bolivia'),(2,'Argentia');
/*!40000 ALTER TABLE `PAISES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSONAS`
--

DROP TABLE IF EXISTS `PERSONAS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PERSONAS` (
  `ci` decimal(7,0) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidoPaterno` varchar(20) NOT NULL,
  `apellidoMaterno` varchar(20) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `idGenero` int(11) NOT NULL,
  `idPais` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  PRIMARY KEY (`ci`),
  KEY `idGenero` (`idGenero`),
  KEY `idPais` (`idPais`),
  KEY `idCiudad` (`idCiudad`),
  CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`idGenero`) REFERENCES `GENEROS` (`id`),
  CONSTRAINT `personas_ibfk_2` FOREIGN KEY (`idPais`) REFERENCES `PAISES` (`id`),
  CONSTRAINT `personas_ibfk_3` FOREIGN KEY (`idCiudad`) REFERENCES `CIUDADES` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSONAS`
--

LOCK TABLES `PERSONAS` WRITE;
/*!40000 ALTER TABLE `PERSONAS` DISABLE KEYS */;
INSERT INTO `PERSONAS` VALUES (12345,'Octa','Luna','Vargas','2002-06-06',1,1,6,'gfdghjkl'),(1234567,'Pepe','Mendoza','Mamani','2004-01-24',2,1,1,'Calle alcoreza 3'),(8343043,'Jaime Ignacio','Huaycho','Clavel','2005-04-16',2,1,4,'Av. Libertador Curva de olguin #21'),(8461662,'Dilan','Mamani','Pamuri','2005-03-24',2,1,4,'calle pastor tejada');
/*!40000 ALTER TABLE `PERSONAS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPOS_CUENTA`
--

DROP TABLE IF EXISTS `TIPOS_CUENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIPOS_CUENTA` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `interes` double(3,2) NOT NULL,
  `tipoInteres` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPOS_CUENTA`
--

LOCK TABLES `TIPOS_CUENTA` WRITE;
/*!40000 ALTER TABLE `TIPOS_CUENTA` DISABLE KEYS */;
INSERT INTO `TIPOS_CUENTA` VALUES (10,'porcentual',2.90,'Mensual'),(13,'Ahorro',8.00,'Anual');
/*!40000 ALTER TABLE `TIPOS_CUENTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRANSACCIONES_CUENTA`
--

DROP TABLE IF EXISTS `TRANSACCIONES_CUENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TRANSACCIONES_CUENTA` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numeroCuenta` decimal(14,0) NOT NULL,
  `tipo` decimal(1,0) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(225) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `numeroCuenta` (`numeroCuenta`),
  CONSTRAINT `transacciones_cuenta_ibfk_1` FOREIGN KEY (`numeroCuenta`) REFERENCES `CUENTAS_AHORRO` (`numeroCuenta`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRANSACCIONES_CUENTA`
--

LOCK TABLES `TRANSACCIONES_CUENTA` WRITE;
/*!40000 ALTER TABLE `TRANSACCIONES_CUENTA` DISABLE KEYS */;
INSERT INTO `TRANSACCIONES_CUENTA` VALUES (7,12785336,1,'2024-06-09','afsefsefvsev',34.00),(8,12785336,2,'2024-06-09','fgdrg',12.00),(9,12785336,1,'2024-06-10','sefiusefksnefneflknf',56.00),(10,12785336,2,'2024-06-10','aeiubsfe',78.00),(11,12785336,1,'2024-06-11','',1000.00),(12,12785336,1,'2024-06-12','',500.00),(26,12785336,1,'2024-06-13','',68476.00),(27,12785336,1,'2024-06-19','',10.00),(28,12785336,2,'2024-06-20','',68000.00),(29,12382962,1,'2024-06-20','hola',10000.00),(30,12382962,1,'2024-06-20','ajsdijds',100000.00),(32,12785336,1,'2024-06-24','Presentacion programacion 2',1000.00);
/*!40000 ALTER TABLE `TRANSACCIONES_CUENTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRANSFERENCIAS`
--

DROP TABLE IF EXISTS `TRANSFERENCIAS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TRANSFERENCIAS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuentaEmisora` decimal(14,0) NOT NULL,
  `cuentaReceptora` decimal(14,0) NOT NULL,
  `fecha` date NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `motivo` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cuentaEmisora` (`cuentaEmisora`),
  CONSTRAINT `transferencias_ibfk_1` FOREIGN KEY (`cuentaEmisora`) REFERENCES `CUENTAS_AHORRO` (`numeroCuenta`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRANSFERENCIAS`
--

LOCK TABLES `TRANSFERENCIAS` WRITE;
/*!40000 ALTER TABLE `TRANSFERENCIAS` DISABLE KEYS */;
INSERT INTO `TRANSFERENCIAS` VALUES (6,12785336,66695545,'2024-06-12',250.00,'sefs'),(7,12785336,12785336,'2024-06-20',100.00,''),(8,12785336,12785336,'2024-06-20',100.00,''),(9,12785336,12382962,'2024-06-20',101.00,'cientounpesitos'),(10,12785336,12382962,'2024-06-20',0.01,'centavito'),(12,12382962,12785336,'2024-06-20',534.00,''),(13,12382962,12785336,'2024-06-20',500.00,'hola'),(18,12382962,78918125,'2024-06-21',51.00,'Juego de Tres en Raya'),(19,12382962,78918125,'2024-06-21',51.00,'Juego de Tres en Raya'),(20,12382962,78918125,'2024-06-21',20.00,'Juego de Tres en Raya'),(22,12785336,78918125,'2024-06-22',20.00,'Juego de Tres en Raya'),(23,12785336,78918125,'2024-06-22',10.00,'Juego de Tres en Raya'),(24,12785336,78918125,'2024-06-22',10.00,'Juego de Tres en Raya'),(25,12785336,12382962,'2024-06-24',100.00,'para pepsi'),(26,12785336,12382962,'2024-06-24',500.00,'Juego de Tres en Raya');
/*!40000 ALTER TABLE `TRANSFERENCIAS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIOS_SISTEMA`
--

DROP TABLE IF EXISTS `USUARIOS_SISTEMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USUARIOS_SISTEMA` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIOS_SISTEMA`
--

LOCK TABLES `USUARIOS_SISTEMA` WRITE;
/*!40000 ALTER TABLE `USUARIOS_SISTEMA` DISABLE KEYS */;
INSERT INTO `USUARIOS_SISTEMA` VALUES (1,'Jaime','override'),(4,'Dilan','parker'),(5,'sergio','pepe');
/*!40000 ALTER TABLE `USUARIOS_SISTEMA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-24 14:38:06
