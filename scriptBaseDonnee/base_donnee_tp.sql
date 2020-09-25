-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_projet_final
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie` (
  `id` int NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `url_image` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Anneaux','sources/71RGnniKhWL._AC_UY395_.jpg'),(2,'Colliers','sources/collier-lush-rutenium-multi.jpg'),(3,'Bijoux de pied','sources/61btdc33jNL._AC_UY395_.jpg'),(4,'Couronnes','sources/61u6gmVZmRL._AC_UY3sd95_.jpg'),(5,'Boucles d\'oreilles','sources/download _boucle_or.jpg'),(6,'Collections Or - Diamand','sources/bague-elsa-or-jaune-diamants-ancelys.jpg');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1,22),(2,22),(3,22),(4,22),(5,22),(6,22),(7,22),(8,22),(9,22),(10,22),(11,22),(12,22),(13,22),(14,22),(15,22),(16,22),(17,22),(18,22),(19,22),(20,22),(21,22),(22,22),(23,22),(24,22),(25,22),(26,22),(27,22),(28,22),(29,22),(30,22),(31,22),(32,22),(33,22),(34,22),(35,22),(36,22),(37,22),(38,22),(39,22),(40,22),(41,22),(42,22),(43,22),(44,22),(45,29),(46,29),(47,30),(48,30),(49,30),(50,30),(51,30);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit` (
  `id` int NOT NULL,
  `nom` varchar(254) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `url_image` varchar(254) DEFAULT NULL,
  `quantite` int DEFAULT NULL,
  `description` longtext,
  `categorie_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categorie_categorie_id_idx` (`categorie_id`),
  CONSTRAINT `fk_categorie_categorie_id` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1,'Jewellery',24.72,'sources/61K9h87BZqL._AC_UX.jpg',45,'simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing',1),(2,'Anneau diamnan',53.99,'sources/rBVaR1vlWHmAWxlaAAO2uOvQSds248.jpg',25,'I found some amazing stuff, open it to learn more! Don’t wait:https://m.dhgate.com/product/hot-sale-delicate-blue-zircon-rings-italian/432655046.html',1),(3,'Bauge #33',15.22,'sources/anneau-de-promesse-luxe-deux-tons-femme.jpg',18,'Anneau de promesse luxe deux tons femme - Origine Gravure\nCheck website for latest pricing and availability. Images may be subject to copyright. Learn more',1),(4,'Gemperles',36.99,'sources/b943cb00306f161d20156265f6f22f50.jpg',64,'Épinglé sur Alliance de Mariage I Gemperles.com',1),(5,'Anneau de promesse classique',33.48,'sources/anneau-de-promesse-classique-noir-femme.jpg',79,'Anneau de promesse classique noir femme - Origine Gravure\n Check website for latest pricing and availability. Images may be subject to copyright.',1),(6,'Trésors De Lily',22.57,'sources/Les Trésors De Lily Bague Plaqué Or Infini blanc Doré Achat Vente bague anneau Femme Adulte Plaqué or Doré.jpg',96,'Les Trésors De Lily Bague Plaqué Or Infini blanc Doré Achat ...\nImages may be subject to copyright',1),(7,'Swarovski',99,'sources/anneau-femme-swarovski-ref-1121068.jpg',55,'Anneau femme SWAROVSKI ref: 1121068\n Une pièce indispensable pour toute boîte à bijoux ! Avec sa silhouette fine, cette délicate bague plaquée rhodium est raffinée et facile',1),(8,'B49-Swagg',82.15,'sources/51Gy6t9lZiL._AC_SX425_.jpg',12,'WZYMNJZ 1 Pcs BFF Amis Coeur Forme Anneaux Femmes ...\nImages may be subject to copyright. Learn more',1),(9,'Coeur d\'ange',19.75,'sources/469e26dd00208699004ebf586a7be197.jpg',92,'NEEMODA \"Coeur d\'ange\" Ailes d\'anges Collier pour femme Pendentif coeur en cristal Bijoux Cadeaux',2),(10,'Love Guardian',58,'sources/0e217e216d391a2f12175a57cd85c2d9.jpg',42,'BRAND NEW - LOW QUANTITY IN STOCK - ORDER SOON Editor Notes:Every queen needs a loyal guardian, when things go beyond as they seem, the loyal love from Guardian never changes from life till death',2),(11,'Blue Swarovski',99.99,'sources/efe0d295ae0fb7312b4307fd32ead35d.jpg',250,'According to legend of western cultures, each of the four leaf clovers represent one theme. First leaf is for hope Second leaf is for faith Third leaf is for love Fourth leaf is for luck',2),(12,'Sterll',18.26,'sources/9f848cd659bfa817a42e634b78d00e5f.jpg',16,'Ce produit a été produit avec beaucoup d\'amour pour le détail. Pendentif: 50cm sans pendentif. Chaîne: une massive chaîne figaro en argent 925, sans nickel. La chaîne a subi un traitement',2),(13,'Gioielli',7,'sources/41NZodYQAKL._AC_UY395_.jpg',72,'Emma Gioielli - Collier pour Femme Chaîne en Acier de HAUTE QUALITÉ avec Pendentif Charm Cercle Anneau Bead Rool Chiffres Romains - Boîte Cadeau',2),(15,'Col456',33,'sources/collier-pour-femme-hypoallergenique-en-or-blanc-18.jpg',130,'collier pour femme hypoallergénique en or blanc 18 carats plaqué 5 barres pendentif en zircone cubique pour 1 W9M5F',2),(16,'Wolfleague',19.98,'sources/51XGTckgTUL._AC_UY395_.jpg',28,'Wolfleague ChaîNe à La Cheville, Boho Pied Bijoux RéGlable Bijoux Cheville Pied De Plage Set ChaîNes De Cheville Pour Femmes Filles Pieds Nus',3),(17,'Lady Charme',21,'sources/rBVaVFyB3j2AIeEDAAR8uu0UVLQ900.jpg',98,'Bijoux de mode Lady Charme Femmes Chaînes de Cheville Pieds Nus Chaîne Cheville Chaîne Chaîne de Cheville Bracelet Pied Bijoux Sandale Plage Cheville Cadeau Livraison Gratuite',3),(18,'PIERRE TURQUOISE',6.99,'sources/bijou-de-pied-boheme-argente.jpg',84,'BIJOU CUISSE ARGENTÉ PIERRE TURQUOISE',3);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mot_de_passe` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (22,'f','f'),(23,'adjchel@gmail.com','l'),(24,'adjchel@gmail.com','l'),(25,'adjchel@gmail.com','l'),(26,'Michel','Michel'),(27,'adjchel@gmail.com','lok'),(28,'vanina@gmail.com','vv'),(29,'adjchel@gmail.com','MichelISI'),(30,'vanina','abc123...'),(31,'gyfggfy','abc123...');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-30 11:53:34
