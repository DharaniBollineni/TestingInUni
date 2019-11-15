-- MySQL dump 10.16  Distrib 10.1.41-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	10.1.41-MariaDB-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `EmployeeID` int(11) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `AddressLine` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PlayerXml`
--

DROP TABLE IF EXISTS `PlayerXml`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PlayerXml` (
  `PlayerID` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Club` varchar(255) DEFAULT NULL,
  `Position` varchar(255) DEFAULT NULL,
  `MarketValue` double DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PlayerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PlayerXml`
--

LOCK TABLES `PlayerXml` WRITE;
/*!40000 ALTER TABLE `PlayerXml` DISABLE KEYS */;
INSERT INTO `PlayerXml` VALUES (1,'Alexis Sanchez',28,'Arsenal','LW',65,'Chile'),(2,'Mesut Ozil',28,'Arsenal','AM',50,'Germany'),(3,'Petr Cech',35,'Arsenal','GK',7,'Czech Republic'),(4,'Theo Walcott',28,'Arsenal','RW',20,'England'),(5,'Laurent Koscielny',31,'Arsenal','CB',22,'France'),(6,'Hector Bellerin',22,'Arsenal','RB',30,'Spain'),(7,'Olivier Giroud',30,'Arsenal','CF',22,'France'),(8,'Nacho Monreal',31,'Arsenal','LB',13,'Spain'),(9,'Shkodran Mustafi',25,'Arsenal','CB',30,'Germany'),(10,'Alex Iwobi',21,'Arsenal','LW',10,'Nigeria'),(11,'Granit Xhaka',24,'Arsenal','DM',35,'Switzerland'),(12,'Alex Oxlade-Chamberlain',23,'Arsenal','RM',22,'England'),(13,'Jack Wilshere',25,'Arsenal','CM',18,'England'),(14,'Aaron Ramsey',26,'Arsenal','CM',35,'Wales'),(15,'Francis Coquelin',26,'Arsenal','DM',15,'France'),(16,'Gabriel Paulista',26,'Arsenal','CB',13,'Brazil'),(17,'Kieran Gibbs',27,'Arsenal','LB',10,'England'),(18,'Santi Cazorla',32,'Arsenal','CM',12,'Spain'),(19,'Danny Welbeck',26,'Arsenal','CF',15,'England'),(20,'Rob Holding',21,'Arsenal','CB',7,'England'),(21,'Mohamed Elneny',25,'Arsenal','DM',10,'Egypt'),(22,'Lucas Perez',28,'Arsenal','CF',15,'Spain'),(23,'Emiliano Martinez',24,'Arsenal','GK',1,'Argentina'),(24,'David Ospina',28,'Arsenal','GK',7,'Colombia'),(25,'Carl Jenkinson',25,'Arsenal','RB',5,'England'),(26,'Per Mertesacker',32,'Arsenal','CB',6,'Germany'),(27,'Sead Kolasinac',24,'Arsenal','LB',15,'Bosnia'),(28,'Alexandre Lacazette',26,'Arsenal','CF',40,'France'),(29,'Joshua King',25,'Bournemouth','SS',8,'Norway'),(30,'Jermain Defoe',34,'Bournemouth','CF',5,'England'),(31,'Charlie Daniels',30,'Bournemouth','LB',3,'England'),(32,'Artur Boruc',37,'Bournemouth','GK',1,'Poland'),(33,'Steve Cook',26,'Bournemouth','CB',5,'England'),(34,'Junior Stanislas',27,'Bournemouth','LW',4.5,'England'),(35,'Adam Smith',26,'Bournemouth','RB',5,'England'),(36,'Ryan Fraser',23,'Bournemouth','LW',5,'Scotland'),(37,'Simon Francis',32,'Bournemouth','RB',2.5,'England'),(38,'Benik Afobe',24,'Bournemouth','CF',10,'Congo DR'),(39,'Harry Arter',27,'Bournemouth','CM',2.5,'Ireland'),(40,'Marc Pugh',30,'Bournemouth','LW',2,'England'),(41,'Callum Wilson',25,'Bournemouth','CF',10,'England'),(42,'Nathan Ake',22,'Bournemouth','CB',8,'Netherlands'),(43,'Dan Gosling',27,'Bournemouth','CM',3,'England'),(44,'Andrew Surman',30,'Bournemouth','CM',2,'England'),(45,'Jordon Ibe',21,'Bournemouth','RW',8,'England'),(46,'Lewis Cook',20,'Bournemouth','CM',6,'England'),(47,'Lys Mousset',21,'Bournemouth','CF',4,'France'),(48,'Adam Federici',32,'Bournemouth','GK',1,'Australia'),(49,'Max Gradel',29,'Bournemouth','LW',7,'Cote d\'Ivoire'),(50,'Tyrone Mings',24,'Bournemouth','CB',5,'England'),(51,'Brad Smith',23,'Bournemouth','LB',2,'Australia'),(52,'Asmir Begovic',30,'Bournemouth','GK',8,'Bosnia'),(53,'Niki Maenpaa',32,'Brighton+and+Hove','GK',0.25,'Finland'),(54,'Mathew Ryan',25,'Brighton+and+Hove','GK',3.5,'Australia'),(55,'Lewis Dunk',25,'Brighton+and+Hove','CB',5,'England'),(56,'Shane Duffy',25,'Brighton+and+Hove','CB',5,'Ireland'),(57,'Uwe Hunemeier',31,'Brighton+and+Hove','CB',1.5,'Germany'),(58,'Bruno',36,'Brighton+and+Hove','RB',0.5,'Argentina'),(59,'Gaetan Bong',29,'Brighton+and+Hove','LB',1.5,'Cameroon'),(60,'Liam Rosenior',33,'Brighton+and+Hove','RB',1,'England'),(61,'Connor Goldson',24,'Brighton+and+Hove','CB',0.75,'England'),(62,'Markus Suttner',30,'Brighton+and+Hove','LB',2,'Austria'),(63,'Anthony Knockaert',25,'Brighton+and+Hove','RW',8,'France'),(64,'Dale Stephens',27,'Brighton+and+Hove','CM',5,'England'),(65,'Beram Kayal',29,'Brighton+and+Hove','CM',1.25,'Israel'),(66,'Steve Sidwell',34,'Brighton+and+Hove','CM',1,'England'),(67,'Solly March',23,'Brighton+and+Hove','RM',0.5,'England'),(68,'Jiri Skalak',25,'Brighton+and+Hove','LW',1.5,'Czech Republic'),(69,'Oliver Norwood',26,'Brighton+and+Hove','CM',2.5,'Northern Ireland'),(70,'Jamie Murphy',27,'Brighton+and+Hove','LW',1.75,'Scotland'),(71,'Pascal Gross',26,'Brighton+and+Hove','CM',4,'Germany'),(72,'Glenn Murray',33,'Brighton+and+Hove','CF',3.5,'England'),(73,'Tomer Hemed',30,'Brighton+and+Hove','CF',2.5,'Israel'),(74,'Sam Baldock',28,'Brighton+and+Hove','CF',3,'England'),(75,'Tom Heaton',31,'Burnley','GK',4,'England'),(76,'Sam Vokes',27,'Burnley','CF',4.5,'Wales'),(77,'Andre Gray',26,'Burnley','CF',10,'England'),(78,'Ben Mee',27,'Burnley','CB',6,'England'),(79,'Stephen Ward',31,'Burnley','LB',1.5,'Ireland'),(80,'Matthew Lowton',28,'Burnley','RB',2.5,'England'),(81,'Ashley Barnes',27,'Burnley','CF',2.5,'England'),(82,'Jeff Hendrick',25,'Burnley','CM',6,'Ireland'),(83,'Scott Arfield',28,'Burnley','LM',3,'Canada'),(84,'Steven Defour',29,'Burnley','CM',6,'Belgium'),(85,'Dean Marney',33,'Burnley','CM',1,'England'),(86,'Jack Cork',28,'Burnley','DM',5,'England'),(87,'Johann Berg Gudmundsson',26,'Burnley','RW',2.5,'Iceland'),(88,'Robbie Brady',25,'Burnley','LM',10,'Ireland'),(89,'James Tarkowski',24,'Burnley','CB',2,'England'),(90,'Ashley Westwood',27,'Burnley','DM',4,'England'),(91,'Kevin Long',26,'Burnley','CB',0.5,'Ireland'),(92,'Matthew Taylor',35,'Burnley','LM',0.25,'England'),(93,'Eden Hazard',26,'Chelsea','LW',75,'Belgium'),(94,'Diego Costa',28,'Chelsea','CF',50,'Spain'),(95,'Gary Cahill',31,'Chelsea','CB',16,'England'),(96,'Marcos Alonso Mendoza',26,'Chelsea','LB',25,'Spain'),(97,'Cesar Azpilicueta',27,'Chelsea','RB',30,'Spain'),(98,'Pedro',29,'Chelsea','RW',28,'Spain'),(99,'Thibaut Courtois',25,'Chelsea','GK',40,'Belgium'),(100,'David Luiz',30,'Chelsea','CB',30,'Brazil'),(101,'Cesc Fabregas',30,'Chelsea','CM',35,'Spain'),(102,'Willian',28,'Chelsea','RW',32,'Brazil'),(103,'Victor Moses',26,'Chelsea','RM',18,'Nigeria'),(104,'Nemanja Matic',28,'Chelsea','DM',35,'Serbia'),(105,'N%27Golo Kante',26,'Chelsea','DM',50,'France'),(106,'Willy Caballero',35,'Chelsea','GK',1.5,'Argentina'),(107,'Michy Batshuayi',23,'Chelsea','CF',25,'Belgium'),(108,'Kurt Zouma',22,'Chelsea','CB',15,'France'),(109,'Kenedy',21,'Chelsea','LB',7,'Brazil'),(110,'Eduardo Carvalho',34,'Chelsea','LW',0.05,'Portugal'),(111,'Antonio Rudiger',24,'Chelsea','CB',25,'Germany'),(112,'Tiemoue Bakayoko',22,'Chelsea','DM',16,'France'),(113,'Wilfried Zaha',24,'Crystal+Palace','RW',18,'Cote d\'Ivoire'),(114,'Christian Benteke',26,'Crystal+Palace','CF',28,'Belgium'),(115,'Andros Townsend',26,'Crystal+Palace','RW',12,'England'),(116,'Patrick van Aanholt',26,'Crystal+Palace','LB',9,'Netherlands'),(117,'James McArthur',29,'Crystal+Palace','CM',7,'Scotland'),(118,'Wayne Hennessey',30,'Crystal+Palace','GK',4,'Wales'),(119,'Jason Puncheon',31,'Crystal+Palace','AM',5.5,'England'),(120,'Yohan Cabaye',31,'Crystal+Palace','CM',15,'France'),(121,'Joel Ward',27,'Crystal+Palace','RB',5,'England'),(122,'James Tomkins',28,'Crystal+Palace','CB',7,'England'),(123,'Scott Dann',30,'Crystal+Palace','CB',5,'England'),(124,'Damien Delaney',36,'Crystal+Palace','CB',1,'Ireland'),(125,'Jeffrey Schlupp',24,'Crystal+Palace','LB',8,'Ghana'),(126,'Martin Kelly',27,'Crystal+Palace','RB',3,'England'),(127,'Luka Milivojevic',26,'Crystal+Palace','DM',10,'Serbia'),(128,'Lee Chung-yong',29,'Crystal+Palace','RW',1.5,'South Korea'),(129,'Connor Wickham',24,'Crystal+Palace','CF',6,'England'),(130,'Bakary Sako',29,'Crystal+Palace','LW',6,'Mali'),(131,'Pape Souare',27,'Crystal+Palace','LB',6,'Senegal'),(132,'Ruben Loftus-Cheek',21,'Crystal+Palace','CM',5,'England'),(133,'Julian Speroni',38,'Crystal+Palace','GK',0.25,'Argentina'),(134,'Ross Barkley',23,'Everton','AM',25,'England'),(135,'Leighton Baines',32,'Everton','LB',12,'England'),(136,'Seamus Coleman',28,'Everton','RB',17,'Ireland'),(137,'Ashley Williams',32,'Everton','CB',8,'Wales'),(138,'Kevin Mirallas',29,'Everton','RW',13,'Belgium'),(139,'Michael Keane',24,'Everton','CB',18,'England'),(140,'Phil Jagielka',34,'Everton','CB',2,'England'),(141,'Jordan Pickford',23,'Everton','GK',15,'England'),(142,'Joel Robles',27,'Everton','GK',5,'Spain'),(143,'Idrissa Gueye',27,'Everton','CM',18,'Senegal'),(144,'Wayne Rooney',31,'Everton','SS',15,'England'),(145,'Ramiro Funes Mori',26,'Everton','CB',12,'Argentina'),(146,'Maarten Stekelenburg',34,'Everton','GK',2,'Netherlands'),(147,'Gareth Barry',36,'Everton','DM',1.5,'England'),(148,'Tom Davies',19,'Everton','CM',8,'England'),(149,'Mason Holgate',20,'Everton','CB',5,'England'),(150,'Yannick Bolasie',28,'Everton','LW',20,'Congo DR'),(151,'Morgan Schneiderlin',27,'Everton','DM',22,'France'),(152,'Cuco Martina',27,'Everton','RB',2,'Curacao'),(153,'James McCarthy',26,'Everton','CM',15,'Ireland'),(154,'Aaron Lennon',30,'Everton','RW',5,'England'),(155,'Dominic Calvert-Lewin',20,'Everton','SS',3.5,'England'),(156,'Ademola Lookman',19,'Everton','LW',5,'England'),(157,'Matthew Pennington',22,'Everton','CB',0.5,'England'),(158,'Jonjoe Kenny',20,'Everton','RB',0.25,'England'),(159,'Muhamed Besic',24,'Everton','DM',5,'Germany'),(160,'Davy Klaassen',24,'Everton','AM',18,'Netherlands'),(161,'Sandro Ramirez',22,'Everton','CF',10,'Spain'),(162,'Joel Coleman',21,'Huddersfield','GK',0.25,'England'),(163,'Jonas Lossl',28,'Huddersfield','GK',1.5,'Denmark'),(164,'Christopher Schindler',27,'Huddersfield','CB',2,'Germany'),(165,'Chris Lowe',28,'Huddersfield','LB',1.5,'Germany'),(166,'Tommy Smith',25,'Huddersfield','RB',2,'England'),(167,'Michael Hefele',26,'Huddersfield','CB',1.5,'Germany'),(168,'Martin Cranie',30,'Huddersfield','CB',0.5,'England'),(169,'Jon Gorenc Stankovic',21,'Huddersfield','CB',0.5,'Slovenia'),(170,'Mark Hudson',35,'Huddersfield','CB',0.5,'England'),(171,'Mathias Jorgensen',27,'Huddersfield','CB',2.5,'Denmark'),(172,'Scott Malone',26,'Huddersfield','LB',0.75,'England'),(173,'Aaron Mooy',26,'Huddersfield','CM',5,'Australia'),(174,'Rajiv van La Parra',26,'Huddersfield','LW',2,'Netherlands'),(175,'Jonathan Hogg',28,'Huddersfield','CM',1,'England'),(176,'Philip Billing',21,'Huddersfield','CM',0.5,'Denmark'),(177,'Joe Lolley',24,'Huddersfield','RW',0.25,'England'),(178,'Jack Payne',25,'Huddersfield','CM',0.25,'England'),(179,'Dean Whitehead',35,'Huddersfield','CM',0.25,'England'),(180,'Harry Bunn',24,'Huddersfield','LW',0.5,'England'),(181,'Sean Scannell',26,'Huddersfield','RW',0.5,'Ireland'),(182,'Elias Kachunga',25,'Huddersfield','RW',3.5,'Congo DR'),(183,'Tom Ince',25,'Huddersfield','RW',7,'England'),(184,'Kasey Palmer',20,'Huddersfield','AM',0.75,'England'),(185,'Andy Williams',26,'Huddersfield','CB',0.65,'Trinidad and Tobago'),(186,'Nahki Wells',27,'Huddersfield','CF',5,'Bermuda'),(187,'Collin Quaner',26,'Huddersfield','CF',1,'Germany'),(188,'Laurent Depoitre',28,'Huddersfield','CF',3,'Belgium'),(189,'Steve Mounie',22,'Huddersfield','CF',5.5,'Benin'),(190,'Jamie Vardy',30,'Leicester+City','CF',15,'England'),(191,'Riyad Mahrez',26,'Leicester+City','RW',30,'Algeria'),(192,'Kasper Schmeichel',30,'Leicester+City','GK',10,'Denmark'),(193,'Christian Fuchs',31,'Leicester+City','LB',6,'Austria'),(194,'Marc Albrighton',27,'Leicester+City','LM',6,'England'),(195,'Robert Huth',32,'Leicester+City','CB',5,'Germany'),(196,'Danny Simpson',30,'Leicester+City','RB',5,'England'),(197,'Islam Slimani',29,'Leicester+City','CF',25,'Algeria'),(198,'Harry Maguire',24,'Leicester+City','CB',8,'England'),(199,'Danny Drinkwater',27,'Leicester+City','CM',9,'England'),(200,'Wes Morgan',33,'Leicester+City','CB',3,'Jamaica'),(201,'Shinji Okazaki',31,'Leicester+City','CF',7,'Japan'),(202,'Wilfred Ndidi',20,'Leicester+City','DM',14,'Nigeria'),(203,'Demarai Gray',21,'Leicester+City','LW',9,'England'),(204,'Daniel Amartey',22,'Leicester+City','DM',5,'Ghana'),(205,'Andy King',28,'Leicester+City','CM',3,'Wales'),(206,'Ahmed Musa',24,'Leicester+City','CF',17,'Nigeria'),(207,'Yohan Benalouane',30,'Leicester+City','CB',1,'Tunisia'),(208,'Leonardo Ulloa',30,'Leicester+City','CF',6,'Argentina'),(209,'Ben Chilwell',20,'Leicester+City','LB',2.5,'England'),(210,'Nampalys Mendy',25,'Leicester+City','DM',10,'France'),(211,'Ben Hamer',29,'Leicester+City','GK',0.5,'England'),(212,'Molla Wague',26,'Leicester+City','CB',1.5,'Mali'),(213,'Vicente Iborra',29,'Leicester+City','DM',9,'Spain'),(214,'Roberto Firmino',25,'Liverpool','SS',38,'Brazil'),(215,'Philippe Coutinho',25,'Liverpool','AM',45,'Brazil'),(216,'Sadio Mane',25,'Liverpool','LW',40,'Senegal'),(217,'Georginio Wijnaldum',26,'Liverpool','CM',28,'Netherlands'),(218,'James Milner',31,'Liverpool','CM',12,'England'),(219,'Adam Lallana',29,'Liverpool','AM',25,'England'),(220,'Nathaniel Clyne',26,'Liverpool','RB',21,'England'),(221,'Simon Mignolet',29,'Liverpool','GK',12,'Belgium'),(222,'Dejan Lovren',28,'Liverpool','CB',17,'Croatia'),(223,'Emre Can',23,'Liverpool','DM',15,'Germany'),(224,'Joel Matip',25,'Liverpool','CB',25,'Cameroon'),(225,'Divock Origi',22,'Liverpool','CF',12,'Belgium'),(226,'Jordan Henderson',27,'Liverpool','CM',28,'England'),(227,'Daniel Sturridge',27,'Liverpool','CF',20,'England'),(228,'Lucas Leiva',30,'Liverpool','DM',7,'Brazil'),(229,'Ragnar Klavan',31,'Liverpool','CB',3.5,'Estonia'),(230,'Mamadou Sakho',27,'Liverpool','CB',15,'France'),(231,'Loris Karius',24,'Liverpool','GK',8,'Germany'),(232,'Trent Alexander-Arnold',18,'Liverpool','RB',1.5,'England'),(233,'Alberto Moreno',25,'Liverpool','LB',10,'Spain'),(234,'Ben Woodburn',17,'Liverpool','LW',1.5,'Wales'),(235,'Marko Grujic',21,'Liverpool','CM',5,'Serbia'),(236,'Joe Gomez',20,'Liverpool','CB',4,'England'),(237,'Sheyi Ojo',20,'Liverpool','LW',2,'England'),(238,'Mohamed Salah',25,'Liverpool','RW',35,'Egypt'),(239,'Danny Ings',24,'Liverpool','CF',8,'England'),(240,'Dominic Solanke',19,'Liverpool','CF',2,'England'),(241,'Kevin De Bruyne',26,'Manchester+City','AM',65,'Belgium'),(242,'Sergio Aguero',29,'Manchester+City','CF',65,'Argentina'),(243,'Raheem Sterling',22,'Manchester+City','LW',45,'England'),(244,'Kyle Walker',27,'Manchester+City','RB',30,'England'),(245,'David Silva',31,'Manchester+City','AM',30,'Spain'),(246,'Leroy Sane',21,'Manchester+City','LW',35,'Germany'),(247,'Nicolas Otamendi',29,'Manchester+City','CB',30,'Argentina'),(248,'Aleksandar Kolarov',31,'Manchester+City','LB',10,'Serbia'),(249,'Yaya Toure',34,'Manchester+City','CM',8,'Cote d\'Ivoire'),(250,'Fernandinho',32,'Manchester+City','DM',18,'Brazil'),(251,'Claudio Bravo',34,'Manchester+City','GK',8,'Chile'),(252,'Gabriel Jesus',20,'Manchester+City','CF',30,'Brazil'),(253,'John Stones',23,'Manchester+City','CB',35,'England'),(254,'Vincent Kompany',31,'Manchester+City','CB',22,'Belgium'),(255,'Kelechi Iheanacho',20,'Manchester+City','CF',15,'Nigeria'),(256,'Ilkay Gundogan',26,'Manchester+City','CM',30,'Germany'),(257,'Fernando',32,'Manchester+City','DM',18,'Brazil'),(258,'Fabian Delph',27,'Manchester+City','CM',8,'England'),(259,'Ederson Moraes',23,'Manchester+City','GK',22,'Brazil'),(260,'Bernardo Silva',22,'Manchester+City','RW',40,'Portugal'),(261,'Romelu Lukaku',24,'Manchester+United','CF',50,'Belgium'),(262,'David de Gea',26,'Manchester+United','GK',40,'Spain'),(263,'Antonio Valencia',31,'Manchester+United','RB',10,'Ecuador'),(264,'Paul Pogba',24,'Manchester+United','CM',75,'France'),(265,'Eric Bailly',23,'Manchester+United','CB',30,'Cote d\'Ivoire'),(266,'Juan Mata',29,'Manchester+United','AM',30,'Spain'),(267,'Daley Blind',27,'Manchester+United','LB',22,'Netherlands'),(268,'Ander Herrera',27,'Manchester+United','CM',30,'Spain'),(269,'Anthony Martial',21,'Manchester+United','CF',30,'France'),(270,'Marcos Rojo',27,'Manchester+United','CB',18,'Argentina'),(271,'Marcus Rashford',19,'Manchester+United','CF',18,'England'),(272,'Henrikh Mkhitaryan',28,'Manchester+United','AM',35,'Armenia'),(273,'Matteo Darmian',27,'Manchester+United','RB',12,'Italy'),(274,'Jesse Lingard',24,'Manchester+United','LW',12,'England'),(275,'Phil Jones',25,'Manchester+United','CB',14,'England'),(276,'Chris Smalling',27,'Manchester+United','CB',18,'England'),(277,'Marouane Fellaini',29,'Manchester+United','CM',12,'Belgium'),(278,'Luke Shaw',22,'Manchester+United','LB',20,'England'),(279,'Michael Carrick',35,'Manchester+United','DM',1.5,'England'),(280,'Ashley Young',32,'Manchester+United','LM',5,'England'),(281,'Sergio Romero',30,'Manchester+United','GK',6,'Argentina'),(282,'Axel Tuanzebe',19,'Manchester+United','CB',1,'England'),(283,'Timothy Fosu-Mensah',19,'Manchester+United','DM',2.5,'Netherlands'),(284,'Joel Castro Pereira',21,'Manchester+United','GK',0.1,'Portugal'),(285,'Victor Lindelof',23,'Manchester+United','CB',22,'Sweden'),(286,'Rob Elliot',31,'Newcastle+United','GK',1,'Ireland'),(287,'Karl Darlow',26,'Newcastle+United','GK',4.5,'England'),(288,'DeAndre Yedlin',24,'Newcastle+United','RB',5,'United States'),(289,'Ciaran Clark',27,'Newcastle+United','CB',5,'Ireland'),(290,'Lascelles',27,'Newcastle+United','CB',5,'England'),(291,'Paul Dummett',25,'Newcastle+United','LB',3.5,'Wales'),(292,'Grant Hanley',25,'Newcastle+United','CB',4.5,'Scotland'),(293,'Jesus Gamez',32,'Newcastle+United','RB',2.5,'Spain'),(294,'Florian Lejeune',26,'Newcastle+United','CB',5,'France'),(295,'Massadio Haidara',24,'Newcastle+United','LB',1.5,'France'),(296,'Matt Ritchie',27,'Newcastle+United','RM',9,'Scotland'),(297,'Jonjo Shelvey',25,'Newcastle+United','CM',11,'England'),(298,'Mohamed Diame',30,'Newcastle+United','CM',6,'Senegal'),(299,'Jack Colback',27,'Newcastle+United','DM',5,'England'),(300,'Christian Atsu',25,'Newcastle+United','RW',5,'Ghana'),(301,'Siem de Jong',28,'Newcastle+United','AM',5.5,'Netherlands'),(302,'Rolando Aarons',21,'Newcastle+United','LW',0.75,'England'),(303,'Dwight Gayle',26,'Newcastle+United','CF',10,'England'),(304,'Ayoze Perez',23,'Newcastle+United','SS',8,'Spain'),(305,'Aleksandar Mitrovic',22,'Newcastle+United','CF',10,'Serbia'),(306,'Daryl Murphy',34,'Newcastle+United','CF',1.5,'Ireland'),(307,'Fraser Forster',29,'Southampton','GK',15,'England'),(308,'Nathan Redmond',23,'Southampton','RW',15,'England'),(309,'Ryan Bertrand',27,'Southampton','LB',20,'England'),(310,'DuÅ¡an TadiÄ‡',28,'Southampton','LW',17,'Portugal'),(311,'Cedric Soares',25,'Southampton','RB',15,'Portugal'),(312,'James Ward-Prowse',22,'Southampton','CM',15,'England'),(313,'Oriol Romeu',25,'Southampton','DM',10,'Spain'),(314,'Maya Yoshida',28,'Southampton','CB',5,'Japan'),(315,'Steven Davis',32,'Southampton','CM',6,'Northern Ireland'),(316,'Virgil van Dijk',26,'Southampton','CB',30,'Netherlands'),(317,'Charlie Austin',28,'Southampton','CF',13,'England'),(318,'Jack Stephens',23,'Southampton','CB',3.5,'England'),(319,'Shane Long',30,'Southampton','CF',9,'Ireland'),(320,'Sofiane Boufal',23,'Southampton','AM',15,'Morocco'),(321,'Jordy Clasie',26,'Southampton','DM',10,'Netherlands'),(322,'Pierre-Emile Hojbjerg',21,'Southampton','CM',8,'Denmark'),(323,'Manolo Gabbiadini',25,'Southampton','CF',15,'Italy'),(324,'Sam McQueen',22,'Southampton','LM',0.75,'England'),(325,'Matt Targett',21,'Southampton','LB',3,'England'),(326,'Josh Sims',20,'Southampton','RW',0.5,'England'),(327,'Jeremy Pied',28,'Southampton','RM',3.5,'France'),(328,'Jason McCarthy',21,'Southampton','CB',0.25,'England'),(329,'Jan Bednarek',21,'Southampton','CB',0.5,'Poland'),(330,'Joe Allen',27,'Stoke+City','CM',15,'Wales'),(331,'Marko ArnautoviÄ‡',28,'Stoke+City','LW',15,'England'),(332,'Lee Grant',34,'Stoke+City','GK',1,'England'),(333,'Erik Pieters',28,'Stoke+City','LB',7,'Netherlands'),(334,'Steven Fletcher',30,'Stoke+City','CF',3,'Scotland'),(335,'Ryan Shawcross',29,'Stoke+City','CB',11,'England'),(336,'Xherdan Shaqiri',25,'Stoke+City','RW',15,'Switzerland'),(337,'Peter Crouch',36,'Stoke+City','CF',1.5,'England'),(338,'Glenn Whelan',33,'Stoke+City','DM',2.5,'Ireland'),(339,'Charlie Adam',31,'Stoke+City','CM',3.5,'Scotland'),(340,'Geoff Cameron',32,'Stoke+City','CB',3,'United States'),(341,'Glen Johnson',32,'Stoke+City','RB',5,'England'),(342,'Mame Biram Diouf',29,'Stoke+City','CF',7,'Senegal'),(343,'Ramadan Sobhi',20,'Stoke+City','LW',5,'Egypt'),(344,'Marc Muniesa',25,'Stoke+City','CB',3,'Spain'),(345,'Bojan KrkiÄ‡',26,'Stoke+City','SS',5,'Spain'),(346,'Phil Bardsley',32,'Stoke+City','RB',1.5,'Scotland'),(347,'Saido Berahino',23,'Stoke+City','CF',15,'England'),(348,'Giannelli Imbula',24,'Stoke+City','DM',12,'France'),(349,'Jack Butland',24,'Stoke+City','GK',15,'England'),(350,'Ibrahim Afellay',31,'Stoke+City','LM',3,'Netherlands'),(351,'Josh Tymon',18,'Stoke+City','LB',1,'England'),(352,'Gylfi Sigurdsson',27,'Swansea','AM',25,'Iceland'),(353,'Fernando Llorente',32,'Swansea','CF',6,'Spain'),(354,'Åukasz FabiaÅ„ski',32,'Swansea','GK',9,'Poland'),(355,'Leroy Fer',27,'Swansea','CM',8,'Netherlands'),(356,'Alfie Mawson',23,'Swansea','CB',6,'England'),(357,'Kyle Naughton',28,'Swansea','RB',5,'England'),(358,'Wayne Routledge',32,'Swansea','LW',2.5,'England'),(359,'Federico Fernandez',28,'Swansea','CB',9,'Argentina'),(360,'Martin Olsson',29,'Swansea','LB',5,'Sweden'),(361,'Tom Carroll',25,'Swansea','CM',6,'England'),(362,'Ki Sung-yueng',28,'Swansea','DM',7,'South Korea'),(363,'Jordan Ayew',25,'Swansea','CF',7.5,'Ghana'),(364,'Modou Barrow',24,'Swansea','RW',3,'The Gambia'),(365,'Leon Britton',34,'Swansea','CM',1,'England'),(366,'Stephen Kingsley',22,'Swansea','LB',0.75,'Scotland'),(367,'Ã€ngel Rangel',34,'Swansea','RB',1,'Spain'),(368,'Luciano Narsingh',26,'Swansea','RW',5,'Netherlands'),(369,'Jay Fulton',23,'Swansea','CM',0.5,'Scotland'),(370,'Jefferson Montero',27,'Swansea','LW',4.5,'Ecuador'),(371,'Mike van der Hoorn',24,'Swansea','CB',2,'Netherlands'),(372,'Nathan Dyer',29,'Swansea','RW',3.5,'England'),(373,'Oliver McBurnie',21,'Swansea','CF',0.25,'Scotland'),(374,'Kristoffer Nordfeldt',28,'Swansea','GK',1.5,'Sweden'),(375,'Roque Mesa',28,'Swansea','CM',12,'Spain'),(376,'Tammy Abraham',19,'Swansea','CF',8,'England'),(377,'Dele Alli',21,'Tottenham','CM',45,'England'),(378,'Harry Kane',23,'Tottenham','CF',60,'England'),(379,'Christian Eriksen',25,'Tottenham','AM',40,'Denmark'),(380,'Son Heung-min',25,'Tottenham','LW',30,'South Korea'),(381,'Hugo Lloris',30,'Tottenham','GK',24,'France'),(382,'Jan Vertonghen',30,'Tottenham','CB',28,'Belgium'),(383,'Toby Alderweireld',28,'Tottenham','CB',35,'Belgium'),(384,'Victor Wanyama',26,'Tottenham','DM',25,'Kenya'),(385,'Eric Dier',23,'Tottenham','DM',25,'England'),(386,'Ben Davies',24,'Tottenham','LB',12,'Wales'),(387,'Danny Rose',27,'Tottenham','LB',28,'England'),(388,'Mousa Dembele',30,'Tottenham','CM',18,'Belgium'),(389,'Vincent Janssen',23,'Tottenham','CF',13,'Netherlands'),(390,'Kieran Trippier',26,'Tottenham','RB',10,'England'),(391,'Moussa Sissokho',27,'Tottenham','CM',20,'France'),(392,'Harry Winks',21,'Tottenham','CM',4,'England'),(393,'Erik Lamela',25,'Tottenham','RW',25,'Argentina'),(394,'Michel Vorm',33,'Tottenham','GK',4,'Netherlands'),(395,'Georges-Kevin N%27Koudou',22,'Tottenham','LW',7,'France'),(396,'Kevin Wimmer',24,'Tottenham','CB',7,'Austria'),(397,'Ã‰tienne Capoue',29,'Watford','DM',9,'France'),(398,'Troy Deeney',29,'Watford','CF',11,'England'),(399,'Heurelho Gomes',36,'Watford','GK',1,'Brazil'),(400,'Jose Holebas',33,'Watford','LB',2,'Greece'),(401,'Miguel Britos',32,'Watford','CB',3.5,'Uruguay'),(402,'Sebastian Prodl',30,'Watford','CB',4,'Austria'),(403,'Nordin Amrabat',30,'Watford','LW',4.5,'Morocco'),(404,'YounÃ¨s Kaboul',31,'Watford','CB',2.5,'France'),(405,'Tom Cleverley',27,'Watford','CM',8,'England'),(406,'Daryl Janmaat',27,'Watford','RB',7,'Netherlands'),(407,'Valon Behrami',32,'Watford','DM',2.5,'Switzerland'),(408,'Roberto Pereyra',26,'Watford','AM',15,'Argentina'),(409,'Stefano Okaka',27,'Watford','CF',6,'Italy'),(410,'Abdoulaye Doucoure',24,'Watford','CM',6,'France'),(411,'Kabasele',26,'Watford','CB',5.5,'Belgium'),(412,'Craig Cathcart',28,'Watford','CB',4,'Northern Ireland'),(413,'Isaac Success',21,'Watford','LW',4,'Nigeria'),(414,'Adrian Mariappa',30,'Watford','CB',1,'Jamaica'),(415,'Nathaniel Chalobah',22,'Watford','DM',5,'England'),(416,'Mauro Zarate',30,'Watford','SS',2,'Argentina'),(417,'Costel Pantilimon',30,'Watford','GK',3,'Romania'),(418,'Kiko Femenia',26,'Watford','RB',4,'Spain'),(419,'Steven Berghuis',25,'Watford','RW',5.5,'Netherlands'),(420,'Will Hughes',22,'Watford','CM',8,'England'),(421,'Gareth McAuley',37,'West+Brom','CB',1,'Northern Ireland'),(422,'Salomon Rondon',27,'West+Brom','CF',15,'Venezuela'),(423,'Matt Phillips',26,'West+Brom','RW',9,'Scotland'),(424,'Ben Foster',34,'West+Brom','GK',4,'England'),(425,'Nacer Chadli',27,'West+Brom','LW',15,'Belgium'),(426,'Craig Dawson',27,'West+Brom','RB',6,'England'),(427,'Chris Brunt',32,'West+Brom','LM',4,'Northern Ireland'),(428,'James Morrison',31,'West+Brom','CM',5,'Scotland'),(429,'Jonny Evans',29,'West+Brom','CB',7,'Northern Ireland'),(430,'Jake Livermore',27,'West+Brom','DM',7,'England'),(431,'Allan Nyom',29,'West+Brom','RB',4.5,'Cameroon'),(432,'Jay Rodriguez',27,'West+Brom','CF',10,'England'),(433,'Claudio Yacob',30,'West+Brom','DM',4,'Argentina'),(434,'James McClean',28,'West+Brom','LW',3,'Ireland'),(435,'Hal Robson-Kanu',28,'West+Brom','LW',2.5,'Wales'),(436,'Jonathan Leko',18,'West+Brom','RW',1.5,'England'),(437,'Sam Field',19,'West+Brom','CM',0.25,'England'),(438,'Boaz Myhill',34,'West+Brom','GK',1.5,'Wales'),(439,'Ahmed Hegazy',26,'West+Brom','CB',1,'Egypt'),(440,'Robert Snodgrass',29,'West+Ham','RW',8,'Scotland'),(441,'Manuel Lanzini',24,'West+Ham','AM',15,'Argentina'),(442,'Michail Antonio',27,'West+Ham','RW',18,'England'),(443,'Winston Reid',29,'West+Ham','CB',10,'New Zealand'),(444,'Jose Fonte',33,'West+Ham','CB',7,'Portugal'),(445,'Andre Ayew',27,'West+Ham','LW',18,'Ghana'),(446,'Cheikhou Kouyate',27,'West+Ham','DM',12,'Senegal'),(447,'Mark Noble',30,'West+Ham','CM',7,'England'),(448,'Darren Randolph',30,'West+Ham','GK',2.5,'Ireland'),(449,'James Collins',33,'West+Ham','CB',2,'Wales'),(450,'Andy Carroll',28,'West+Ham','CF',10,'England'),(451,'Adrian',30,'West+Ham','GK',8,'Spain'),(452,'Aaron Cresswell',27,'West+Ham','LB',12,'England'),(453,'Pedro Obiang',25,'West+Ham','CM',9,'Spain'),(454,'Sofiane Feghouli',27,'West+Ham','RW',12,'Algeria'),(455,'Angelo Ogbonna',29,'West+Ham','CB',9,'Italy'),(456,'Pablo Zabaleta',32,'West+Ham','RB',7,'Argentina'),(457,'Edimilson Fernandes',21,'West+Ham','CM',5,'Switzerland'),(458,'Arthur Masuaku',23,'West+Ham','LB',7,'Congo DR'),(459,'Sam Byram',23,'West+Ham','RB',4.5,'England'),(460,'Ashley Fletcher',21,'West+Ham','CF',1,'England'),(461,'Diafra Sakho',27,'West+Ham','CF',10,'Senegal');
/*!40000 ALTER TABLE `PlayerXml` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `UserID` int(11) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Dharani','password');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coaches`
--

DROP TABLE IF EXISTS `coaches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coaches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coaches`
--

LOCK TABLES `coaches` WRITE;
/*!40000 ALTER TABLE `coaches` DISABLE KEYS */;
INSERT INTO `coaches` VALUES (1,'Kristy Keppich-Birrell'),(2,'Tanya Dearns'),(3,'Sue Hawkins'),(4,'Simone McKinnis'),(5,'Rob Wright'),(6,'Debbie Fuller'),(7,'Roselee Jencke'),(8,'Noeline Taurua'),(9,'Julie Fitzgerald'),(10,'Stacey Rosman');
/*!40000 ALTER TABLE `coaches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_tb`
--

DROP TABLE IF EXISTS `event_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_tb` (
  `event_number` int(11) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(100) NOT NULL,
  `email` varchar(70) NOT NULL,
  `phoneNumber` varchar(70) NOT NULL,
  `Event_type` varchar(70) DEFAULT NULL,
  `needDate` varchar(70) DEFAULT NULL,
  `yourMsg` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`event_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tb`
--

LOCK TABLES `event_tb` WRITE;
/*!40000 ALTER TABLE `event_tb` DISABLE KEYS */;
INSERT INTO `event_tb` VALUES (1,'dharani','Dharani@gmail.com','02200202','weekend party','20/10/2019','please contact'),(2,'Chinmayi','chin@gmail.com','0220020211','weekend party','3/02/2020','need to talk'),(3,'ravanth','ravanth@gmail.com','0233223','Birthday party','4/10/2019','it\'s two hrs party in the afternoon from 12pm to 2pm'),(4,'ravanth','Vani@gmail.com','0233223','Birthday party','24/10/2019','hi please call');
/*!40000 ALTER TABLE `event_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games` (
  `home_id` int(11) DEFAULT NULL,
  `away_id` int(11) DEFAULT NULL,
  `home_score` int(11) DEFAULT NULL,
  `away_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (6,8,57,58),(7,3,70,55),(10,1,63,44),(5,4,57,42),(2,9,57,56),(5,9,78,50),(1,4,44,59),(8,3,58,58),(6,10,44,54),(7,2,61,45),(4,7,47,58),(5,1,68,44),(10,3,64,50),(9,8,53,63),(2,6,52,52),(1,7,46,58),(10,5,52,63),(8,2,67,54),(3,6,56,55),(8,10,69,62),(7,5,61,51),(4,9,57,34),(2,3,57,58),(6,1,52,49),(7,6,70,42),(5,2,79,41),(1,8,54,69),(3,4,48,69),(9,10,44,58),(10,7,52,61),(4,5,51,59),(3,9,57,58),(6,2,55,53),(9,6,49,45),(10,4,53,54),(7,1,62,51),(3,5,52,73),(2,8,63,67),(4,1,57,51),(5,7,58,54),(8,6,66,60),(9,2,54,44),(7,4,56,44),(1,10,51,63),(3,8,51,81),(6,9,51,54),(8,7,66,51),(5,10,57,58),(4,6,69,46),(2,1,46,60),(9,3,56,55),(1,5,53,67),(4,10,60,55),(8,9,64,54),(3,2,59,64),(8,4,65,56),(10,2,70,47),(1,3,58,55),(6,5,53,59),(9,7,47,71),(6,3,62,54),(5,8,59,59),(7,10,63,52),(9,1,56,55),(2,4,53,66);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match_teams`
--

DROP TABLE IF EXISTS `match_teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match_teams` (
  `match_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match_teams`
--

LOCK TABLES `match_teams` WRITE;
/*!40000 ALTER TABLE `match_teams` DISABLE KEYS */;
INSERT INTO `match_teams` VALUES (1,6,57),(1,8,58),(2,7,70),(2,3,55),(3,10,63),(3,1,44),(4,5,57),(4,4,42),(5,2,57),(5,9,56),(6,5,78),(6,9,50),(7,1,44),(7,4,59),(8,8,58),(8,3,58),(9,6,44),(9,10,54),(10,7,61),(10,2,45),(11,4,47),(11,7,58),(12,5,68),(12,1,44),(13,10,64),(13,3,50),(14,9,53),(14,8,63),(15,2,52),(15,6,52),(16,1,46),(16,7,58),(17,10,52),(17,5,63),(18,8,67),(18,2,54),(19,3,56),(19,6,55),(20,8,69),(20,10,62),(21,7,61),(21,5,51),(22,4,57),(22,9,34),(23,2,57),(23,3,58),(24,6,52),(24,1,49),(25,7,70),(25,6,42),(26,5,79),(26,2,41),(27,1,54),(27,8,69),(28,3,48),(28,4,69),(29,9,44),(29,10,58),(30,10,52),(30,7,61),(31,4,51),(31,5,59),(32,3,57),(32,9,58),(33,6,55),(33,2,53),(34,9,49),(34,6,45),(35,10,53),(35,4,54),(36,7,62),(36,1,51),(37,3,52),(37,5,73),(38,2,63),(38,8,67),(39,4,57),(39,1,51),(40,5,58),(40,7,54),(41,8,66),(41,6,60),(42,9,54),(42,2,44),(43,7,56),(43,4,44),(44,1,51),(44,10,63),(45,3,51),(45,8,81),(46,6,51),(46,9,54),(47,8,66),(47,7,51),(48,5,57),(48,10,58),(49,4,69),(49,6,46),(50,2,46),(50,1,60),(51,9,56),(51,3,55),(52,1,53),(52,5,67),(53,4,60),(53,10,55),(54,8,64),(54,9,54),(55,3,59),(55,2,64),(56,8,65),(56,4,56),(57,10,70),(57,2,47),(58,1,58),(58,3,55),(59,6,53),(59,5,59),(60,9,47),(60,7,71),(61,6,62),(61,3,54),(62,5,59),(62,8,59),(63,7,63),(63,10,52),(64,9,56),(64,1,55),(65,2,53),(65,4,66);
/*!40000 ALTER TABLE `match_teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `at_team` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (1,6),(2,7),(3,10),(4,5),(5,2),(6,5),(7,1),(8,8),(9,6),(10,7),(11,4),(12,5),(13,10),(14,9),(15,2),(16,1),(17,10),(18,8),(19,3),(20,8),(21,7),(22,4),(23,2),(24,6),(25,7),(26,5),(27,1),(28,3),(29,9),(30,10),(31,4),(32,3),(33,6),(34,9),(35,10),(36,7),(37,3),(38,2),(39,4),(40,5),(41,8),(42,9),(43,7),(44,1),(45,3),(46,6),(47,8),(48,5),(49,4),(50,2),(51,9),(52,1),(53,4),(54,8),(55,3),(56,8),(57,10),(58,1),(59,6),(60,9),(61,6),(62,5),(63,7),(64,9),(65,2);
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer_tb`
--

DROP TABLE IF EXISTS `offer_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer_tb` (
  `code_number` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(100) NOT NULL,
  `price` varchar(70) NOT NULL,
  PRIMARY KEY (`code_number`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer_tb`
--

LOCK TABLES `offer_tb` WRITE;
/*!40000 ALTER TABLE `offer_tb` DISABLE KEYS */;
INSERT INTO `offer_tb` VALUES (1,'Espresso','$2'),(2,'Americano','$3'),(3,'Cappuccino','$3'),(4,'Affogato','$2'),(5,'Corto','$3'),(6,'Latte','$2'),(7,'Macchiato','$3'),(8,'French','$3'),(9,'Iced Coffee','$4'),(10,'Decaf Coffee','$4');
/*!40000 ALTER TABLE `offer_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_tb`
--

DROP TABLE IF EXISTS `order_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_tb` (
  `order_number` int(11) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(100) NOT NULL,
  `email` varchar(70) NOT NULL,
  `contact_number` varchar(70) NOT NULL,
  `item_name` varchar(70) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `pickup_time` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`order_number`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tb`
--

LOCK TABLES `order_tb` WRITE;
/*!40000 ALTER TABLE `order_tb` DISABLE KEYS */;
INSERT INTO `order_tb` VALUES (15,'kiran','abcd100@mail.com','02255330','IcedCoffee',3,'1:20pm'),(25,'Gai','abcd100@mail.com','0202002','Espresso',1,'2pm'),(26,'Chinmayi','abcd100@mail.com','32323232','Macchiato',1,'10pm');
/*!40000 ALTER TABLE `order_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_positions`
--

DROP TABLE IF EXISTS `player_positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_positions` (
  `player_id` int(11) DEFAULT NULL,
  `position` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_positions`
--

LOCK TABLES `player_positions` WRITE;
/*!40000 ALTER TABLE `player_positions` DISABLE KEYS */;
INSERT INTO `player_positions` VALUES (1,'WA'),(1,'C'),(2,'GA'),(2,'WA'),(2,'GS'),(3,'GA'),(3,'GS'),(4,'GK'),(4,'GD'),(5,'C'),(5,'WA'),(6,'GK'),(6,'GD'),(7,'WA'),(7,'C'),(7,'WD'),(8,'GD'),(8,'GK'),(8,'WD'),(9,'GA'),(9,'GS'),(10,'C'),(10,'WA'),(11,'GK'),(11,'GD'),(12,'WD'),(12,'C'),(12,'WA'),(13,'GD'),(13,'GK'),(14,'GA'),(14,'GS'),(15,'GS'),(15,'GA'),(16,'GK'),(16,'GD'),(16,'GS'),(17,'WD'),(17,'C'),(18,'WA'),(18,'C'),(18,'GA'),(19,'GA'),(19,'GS'),(20,'GK'),(20,'GD'),(21,'C'),(21,'WD'),(22,'WA'),(22,'C'),(22,'GA'),(23,'WD'),(24,'GS'),(25,'GA'),(25,'WA'),(25,'GS'),(26,'WA'),(26,'GS'),(26,'GA'),(27,'GA'),(27,'WA'),(27,'C'),(28,'GS'),(28,'GA'),(29,'WA'),(29,'C'),(30,'GK'),(30,'GD'),(31,'WD'),(31,'C'),(31,'WA'),(32,'WD'),(32,'C'),(33,'GK'),(33,'GD'),(33,'WD'),(34,'GK'),(34,'GD'),(34,'WD'),(35,'WD'),(35,'C'),(36,'GK'),(37,'GA'),(37,'GS'),(38,'GS'),(38,'GA'),(39,'GK'),(39,'GD'),(40,'GK'),(40,'GD'),(40,'WD'),(41,'WD'),(41,'C'),(42,'WA'),(42,'C'),(43,'GD'),(43,'WD'),(44,'C'),(44,'WA'),(45,'GD'),(45,'GK'),(45,'WD'),(46,'WA'),(47,'GS'),(47,'GA'),(48,'C'),(48,'WA'),(49,'C'),(49,'WA'),(49,'WD'),(50,'GK'),(50,'GD'),(50,'WD'),(51,'WD'),(51,'C'),(52,'GA'),(52,'GS'),(53,'GS'),(54,'GA'),(54,'GS'),(54,'WA'),(55,'C'),(55,'WD'),(55,'WA'),(56,'WA'),(56,'C'),(57,'GD'),(58,'GS'),(59,'GD'),(60,'GD'),(60,'WD'),(60,'C'),(60,'WA'),(61,'GD'),(61,'GK'),(62,'C'),(62,'WD'),(63,'GS'),(63,'GA'),(64,'WD'),(64,'C'),(65,'GK'),(65,'GD'),(66,'GA'),(66,'GS'),(67,'GS'),(68,'GD'),(68,'GK'),(69,'GK'),(69,'GD'),(69,'WD'),(70,'GD'),(70,'WD'),(71,'C'),(71,'WD'),(72,'GS'),(73,'GK'),(73,'GD'),(74,'GS'),(74,'GA'),(75,'GK'),(75,'GD'),(76,'GD'),(76,'WD'),(77,'WA'),(77,'C'),(77,'WD'),(78,'C'),(78,'WD'),(78,'WA'),(79,'WD'),(79,'C'),(79,'GD'),(80,'GA'),(80,'GS'),(81,'C'),(81,'WA'),(82,'GD'),(82,'WD'),(83,'GA'),(83,'GS'),(83,'WA'),(84,'GK'),(84,'GD'),(85,'WA'),(85,'C'),(86,'GS'),(87,'C'),(87,'WA'),(88,'WD'),(88,'C'),(88,'WA'),(89,'GA'),(89,'GS'),(90,'WD'),(90,'C'),(91,'GD'),(91,'GK'),(92,'GS'),(92,'GA'),(93,'GK'),(93,'GD'),(93,'WD'),(94,'GK'),(94,'GD'),(95,'GA'),(95,'GS'),(96,'GD'),(96,'GK'),(97,'GS'),(97,'GA'),(98,'GS'),(98,'GA'),(99,'GD'),(99,'GK'),(100,'GD'),(100,'GK'),(101,'GS'),(101,'GA'),(102,'GD'),(102,'WD'),(103,'GA'),(103,'WA'),(104,'C'),(104,'WA'),(104,'WD'),(105,'C'),(105,'WA'),(106,'WD'),(106,'GD'),(107,'GA'),(107,'GS'),(108,'WA'),(108,'C'),(109,'GS'),(110,'GS'),(110,'GA'),(111,'C'),(111,'WD'),(112,'C'),(112,'WA'),(112,'WD'),(113,'GD'),(113,'GK'),(114,'C'),(114,'WA'),(115,'GD'),(115,'GK'),(116,'GK'),(116,'GD'),(117,'GA'),(117,'GS'),(118,'GK'),(118,'GD'),(119,'GS'),(119,'GA');
/*!40000 ALTER TABLE `player_positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `hometown` varchar(90) DEFAULT NULL,
  `team` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'Emily Beaton',180,'Loxton, SA',1),(2,'Erin Bell',178,'Sydney, NSW',1),(3,'Stephanie Puopolo',181,'Melbourne, Victoria',1),(4,'Samantha Poolman',189,'Newcastle, NSW',1),(5,'Madeleine Proud',174,'Adelaide, SA',1),(6,'Kate Shimmin',186,'Adelaide, SA',1),(7,'Khao Watts',170,'Millicent, South Australia',1),(8,'Amy Steel',190,'Melbourne, VIC',1),(9,'Carla Borrego',193,'Jamaica',1),(10,'Hannah Petty',177,'Adelaide, South Australia',1),(11,'Sarah Klau',190,'null',1),(12,'Jade Clarke',174,'Manchester, England',1),(13,'Katrina Grant',186,'Papakura, NZ',2),(14,'Jodi Brown',185,'Whanganui, NZ',2),(15,'Ameliaranne Wells',186,'Bundaberg, QLD',2),(16,'Phoenix Karaka',186,'Auckland, New Zealand',2),(17,'Elias Scheres',178,'Tokoroa, NZ',2),(18,'Whitney Souness',182,'Porirua, NZ',2),(19,'Blaze Leslie',182,'Karratha, Western Australia',2),(20,'Jacinta Messer',184,'Brisbane, Queensland',2),(21,'Samon Nathan',178,'Waitakere, New Zealand',2),(22,'Chelsea Locke',181,'Paddington, New South Wales',2),(23,'Kate Wells',176,'Stratford, New Zealand',2),(24,'Maia Wilson',189,'Auckland, New Zealand',2),(25,'Anna Thompson',175,'Christchurch, NZ',3),(26,'Bailey Mes',187,'Auckland, NZ',3),(27,'Gemma Hazeldine',170,'Christchurch, NZ',3),(28,'Mwai Kumwenda',183,'Mzimba, MAW',3),(29,'Nicola Mackle',169,'Timaru, New Zealand',3),(30,'Jess Moulds',188,'Helensville, NZ',3),(31,'Erikana Pedersen',173,'Auckland, NZ',3),(32,' Hayley Saunders',179,'Gore, NZ',3),(33,'Louise Thayer',185,'Invercargill, NZ',3),(34,'Zoe Walker',183,'Nelson, NZ',3),(35,'Charlotte Elley',174,'Westport, New Zealand',3),(36,'Olivia Coughlan',188,'Palmerston North',3),(37,'Alice Teague-Neeld',183,'Bundoora, VIC',4),(38,'Karyn Bailey',193,'Williamstown, VIC',4),(39,'Emily Mannix',187,'Geelong, VIC',4),(40,'Geva Mentor',188,'Bournemouth, ENG',4),(41,'Kate Moloney',177,'Greensborough, VIC',4),(42,'Madison Robinson',168,'Geelong, Victoria',4),(43,'Chloe Watson',183,'Fitzroy, VIC',4),(44,'Elizabeth Watson',178,'Carlton, VIC',4),(45,'Joanna Weston',188,'Corowa, VIC',4),(46,'Kelsey Browne',164,'Geelong, VIC',4),(47,'Emma Ryde',197,'Dandenong, Victoria',4),(48,'Kimberlee Green',176,'Sydney, New South Wales',5),(49,'Paige Hadley',173,'Sydney, New South Wales',5),(50,'Sharni Layton',187,'Melbourne, Victoria',5),(51,'Abbey McCulloch',178,'Sydney, NSW',5),(52,'Susan Pettitt',180,'Canberra, ACT',5),(53,'Caitlin Thwaites',188,'Bendigo, VIC',5),(54,'Stephanie Wood',175,'Hyde Park, Queensland',5),(55,'Laura Langman',173,'Waikato, New Zealand',5),(56,'Kaitlyn Bryce',170,'Nowra, New South Wales',5),(57,'Lauren Moore',184,'Sydney, New South Wales',5),(58,'Amy Sommerville',180,'Sydney, New South Wales',5),(59,'Maddy Turner',183,'Adelaide, South Australia',5),(60,'Kayla Cullen',185,'Auckland, New Zealand',6),(61,'Temalisi Fakahokotau',182,'Auckland, New Zealand',6),(62,'Serena Guthrie',180,'Jersey, United Kingdom',6),(63,'Cathrine Tuivaiti',189,'Auckland, New Zealand',6),(64,'Nadia Loveday',171,'Auckland, New Zealand',6),(65,'Sulu Fitzpatrick',188,'Auckland, New Zealand',6),(66,'Maria Tutaia',188,'Tokoroa, New Zealand',6),(67,'Megan Craig',203,'Lower Hutt, New Zealand',6),(68,'Holly Fowler',182,'Auckland, New Zealand',6),(69,'Anna Harrison',190,'Westport, New Zealand',6),(70,'Michaela Sokolich-Beatson',183,'Auckland, New Zealand',6),(71,'Fa\'amu Ioane',172,'Apia, Samoa',6),(72,'Romelda Aiken',196,'Jamaica',7),(73,'Laura Clemesha',190,'Toowoomba, Queensland',7),(74,'Beryl Friday',184,'Ingham, Queensland',7),(75,'Laura Geitz',185,'Ipswich, Queensland',7),(76,'Clare McMeniman',185,'Brisbane, Queensland',7),(77,'Caitlyn Nevins',173,'Echuca, Victoria',7),(78,'Kimberley Ravaillion',176,'Strathfield, New South Wales',7),(79,'Gabrielle Simpson',176,'Sydney, New South Wales',7),(80,'Gretel Tippett',192,'Gold Coast, Queensland',7),(81,'Mahalia Cassidy',173,'Redcliffe, Queensland',7),(82,'Hulita Haukinima',178,'Logan, Queensland',7),(83,'Chelsea Lemke',182,'Gawler, South Australia',7),(84,'Te Huinga Reo Selby-Rickit',184,'Hamilton, NZ',8),(85,'Gina Crampton',174,'Hamilton, New Zealand',8),(86,'Jhaniele Fowler-Reid',198,'Montego Bay, Jamaica',8),(87,'Shannon Francois',178,'Motueka, New Zealand',8),(88,'Wendy Frew',174,'Invercargill, New Zealand',8),(89,'Brooke Leaver',183,'Auckland, New Zealand',8),(90,'Stacey Peeters',173,'Matamata, New Zealand',8),(91,'Storm Purvis',186,'Christchurch, New Zealand',8),(92,'Te Paea Selby-Rickit',188,'Otaki, New Zealand',8),(93,'Jane Watson',181,'Christchurch, New Zealand',8),(94,'Abby Erwood',181,'Dunedin, New Zealand',8),(95,'Jamie Hume',182,'Clyde, New Zealand',8),(96,'Leana de Bruin',190,'Bethlehem, South Africa',9),(97,'Ellen Halpenny',185,'Napier, New Zealand',9),(98,'Joanne Harten',188,'Essex, ENG',9),(99,'Kelly Jury',192,'Stratford, New Zealand',9),(100,'Kristiana Manu\'a',182,'Wellington, New Zealand',9),(101,'Malia Paseka',183,'Auckland, New Zealand',9),(102,'Jamie-Lee Price',179,'Sydney, New South Wales',9),(103,'Grace Rasmussen',177,'Auckland, New Zealand',9),(104,'Samantha Sinclair',171,'Rotorua, New Zealand',9),(105,' Courtney Tairi',180,'Sydney, New South Wales',9),(106,'Katherine Coffin',182,'Hamilton, New Zealand',9),(107,'Paula Griffin',1,'Auckland, New Zealand',9),(108,'Verity Simmons',170,'Liverpool, New South Wales',10),(109,'Cailtin Bassett',193,'Perth, Western Australia',10),(110,'Kate Beveridge',193,'Perth, Western Australia',10),(111,'Ashleigh Brazill',175,'Campbelltown, NSW',10),(112,'Shae Brown',181,'Melbourne, Victoria',10),(113,'Courtney Bruce',189,'Gosnells, Western Australia',10),(114,'Ingrid Colyer',165,'Karridale, Western Australia',10),(115,'Josie Janz-Dawson',185,'Thursday Island, Queensland',10),(116,'April Brandley',185,'Nowra, New South Wales',10),(117,'Natalie Medhurst',175,'Warracknabeal, Victoria',10),(118,'Erena Mikaere',193,'Rotorua, New Zealand',10),(119,'Kaylia Stanton',189,'Perth, Western Australia',10),(125,NULL,NULL,NULL,NULL),(126,NULL,NULL,NULL,NULL),(127,'Schoolchild',166,'Wellington',5),(128,'dharani',182,'Wellington',3);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `coach` int(11) DEFAULT NULL,
  `captain` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Thunderbirds',1,2),(2,'Pulse',2,13),(3,'Tactix',3,25),(4,'Vixens',4,42),(5,'Swifts',5,55),(6,'Mystics',6,66),(7,'Firebirds',7,75),(8,'Steel',8,88),(9,'Magic',9,96),(10,'Fever',10,111);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tb`
--

DROP TABLE IF EXISTS `user_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_tb` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `email` varchar(70) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tb`
--

LOCK TABLES `user_tb` WRITE;
/*!40000 ALTER TABLE `user_tb` DISABLE KEYS */;
INSERT INTO `user_tb` VALUES (1,'Chin','chin@gmail.com','0'),(2,'Chin','abc@email.com','0'),(5,'Abcd','abcd1@mail.com','0'),(6,'Abcde','abcde@gmail.com','0'),(8,'Chin','chin2@gmail.com','0'),(9,'Dharani','Dharani1@gmail.com','Abcdef1!'),(10,'userA','usera1@gmail.com','Abcdef1!'),(11,'Dharani','Dharani3@gmail.com','Abcdef1!'),(12,'Dharani','Dharani@gmail.com','Abcdef1!'),(14,'Dharani','abcd12@mail.com','Abcdefg1!'),(16,'userABC','Dharani21@gmail.com','Abcdef1!'),(17,'userAb','userBc@gamil.com','GaiGai1!'),(18,'userAcd','userabc@gmail.com','Abcdef1!'),(20,'dharanig','dharanig@gmail.com','Abcdef1!'),(21,'Dharani','abcd23@mail.com','Abcdef1!'),(26,'userA','user12A@gmail.com','Apple11!'),(27,'Dharani','dharani44@gmail.com','Abcdef1!'),(28,'Dharani','Dharu@gmail.com','Abcdef1!'),(29,'Dharani','chin34@gmail.com','Abcdef1!'),(30,'Dharani','Dharanigai@gmail.com','Abcdef1!'),(31,'Dharani','dharani121@gmail.com','Abcdef1!'),(32,'Chin','abcd100@mail.com','Abcdef1!'),(33,'Dharani','dharani1212@mail.com','Abcdef1'),(34,'Chin','Dharanich1985@gmail.com','Abcdef1'),(36,'Chin','bollineni.dharani@gmail.com','Abcdef1'),(37,'Vani','Vani@gmail.com','Vani1!'),(38,'Dharani','harani@gmail.com','Abcdef1!'),(40,'userA','abcd122@mail.com','Abcdef1!'),(41,'Chin','Vani1@gmail.com','Abcdef1!'),(42,'kalyani','kalyani@gmail.com','Abcdef1!');
/*!40000 ALTER TABLE `user_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-27 12:35:06
