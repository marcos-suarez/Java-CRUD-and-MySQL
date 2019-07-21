-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: mercado
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idC` int(11) NOT NULL AUTO_INCREMENT,
  `nomeC` varchar(40) NOT NULL,
  UNIQUE KEY `idC` (`idC`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Marcos Augusto Suarez'),(3,'Leticia Alvarez'),(4,'Adriano Oliveira Santos');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estoque` (
  `idE` int(11) NOT NULL AUTO_INCREMENT,
  `nomeE` varchar(30) NOT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `qtdP` int(11) NOT NULL,
  UNIQUE KEY `idE` (`idE`),
  KEY `idProduto` (`idProduto`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,'Quitandinha 2',2,65),(2,'Feirinha',1,3);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPed` int(11) NOT NULL AUTO_INCREMENT,
  `idCli` int(11) NOT NULL,
  `idProd` int(11) NOT NULL,
  `idEst` int(11) NOT NULL,
  `valorPed` decimal(6,2) NOT NULL,
  UNIQUE KEY `idPed` (`idPed`),
  KEY `idCli` (`idCli`),
  KEY `idProd` (`idProd`),
  KEY `idEst` (`idEst`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,3,1,2,3000.00);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idP` int(11) NOT NULL AUTO_INCREMENT,
  `nomeP` varchar(30) NOT NULL,
  `valorP` decimal(6,2) NOT NULL,
  UNIQUE KEY `idP` (`idP`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Arroz Integral',6.50),(2,'Feijão',7.00);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_estoqueproduto`
--

DROP TABLE IF EXISTS `view_estoqueproduto`;
/*!50001 DROP VIEW IF EXISTS `view_estoqueproduto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_estoqueproduto` AS SELECT 
 1 AS `idE`,
 1 AS `nomeE`,
 1 AS `idProduto`,
 1 AS `nomeP`,
 1 AS `qtdP`,
 1 AS `valorP`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `view_pedidoall`
--

DROP TABLE IF EXISTS `view_pedidoall`;
/*!50001 DROP VIEW IF EXISTS `view_pedidoall`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_pedidoall` AS SELECT 
 1 AS `idPed`,
 1 AS `idC`,
 1 AS `nomeC`,
 1 AS `idP`,
 1 AS `nomeP`,
 1 AS `valorP`,
 1 AS `idE`,
 1 AS `nomeE`,
 1 AS `valorPed`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_estoqueproduto`
--

/*!50001 DROP VIEW IF EXISTS `view_estoqueproduto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_estoqueproduto` AS select `e`.`idE` AS `idE`,`e`.`nomeE` AS `nomeE`,`e`.`idProduto` AS `idProduto`,`p`.`nomeP` AS `nomeP`,`e`.`qtdP` AS `qtdP`,`p`.`valorP` AS `valorP` from (`estoque` `e` join `produto` `p` on((`e`.`idProduto` = `p`.`idP`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_pedidoall`
--

/*!50001 DROP VIEW IF EXISTS `view_pedidoall`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_pedidoall` AS select `ped`.`idPed` AS `idPed`,`c`.`idC` AS `idC`,`c`.`nomeC` AS `nomeC`,`pro`.`idP` AS `idP`,`pro`.`nomeP` AS `nomeP`,`pro`.`valorP` AS `valorP`,`e`.`idE` AS `idE`,`e`.`nomeE` AS `nomeE`,`ped`.`valorPed` AS `valorPed` from (((`pedido` `ped` join `cliente` `c` on((`ped`.`idCli` = `c`.`idC`))) join `produto` `pro` on((`ped`.`idProd` = `pro`.`idP`))) join `estoque` `e` on((`ped`.`idEst` = `e`.`idE`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-20  1:00:30
