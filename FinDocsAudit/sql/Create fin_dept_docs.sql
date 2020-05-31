﻿CREATE DATABASE IF NOT EXISTS `fin_dept_docs`;
USE `fin_dept_docs`;

CREATE USER 'dbadmin'@'localhost' IDENTIFIED BY 'dbadmin';
GRANT ALL PRIVILEGES ON * . * TO 'dbadmin'@'localhost';

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `input_number` varchar(10) NOT NULL,
  `reg_date` date NOT NULL,
  `name` varchar(200) NOT NULL,
  `type_id` int(10) unsigned NOT NULL,
  `performer_id` int(10) unsigned NOT NULL,
  `initiator_id` int(10) unsigned NOT NULL,
  `deadline` date NOT NULL,
  `status_id` int(10) unsigned NOT NULL,
  `file` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `doc_id_UNIQUE` (`id`),
  UNIQUE KEY `file_UNIQUE` (`file`),
  KEY `FK_initiator` (`initiator_id`),
  KEY `FK_status` (`status_id`),
  KEY `FK_type` (`type_id`),
  KEY `FK_performer` (`performer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;



--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
INSERT INTO `document` VALUES (1,'01/16','2015-11-15','План реализации продукции на 1 кв. 2016 г.',5,2,3,'2015-12-15',5,'План реализации продукции на 1 кв. 2016 г..pdf',''),(2,'02/16','2016-02-16','План реализации \n\nпродукции на 2 кв. 2016 г.',5,3,3,'2016-03-16',5,NULL,NULL),(3,'03/16','2016-05-17','План реализации продукции на 3 кв. 2016 г.',5,4,3,'2016-06-17',3,NULL,NULL),(5,'01/17','2016-11-26','План реализации продукции на 1 кв. 2017 г.',5,9,3,'2016-12-26',1,NULL,NULL),(6,'02/17','2017-01-28','План реализации продукции на 2 кв. 2017 \n\nг.',5,7,3,'2017-02-28',2,NULL,NULL),(22,'5/17','2017-01-01','План амортизационных отчислений на 2017 год',6,17,2,'2017-12-31',2,'План амортизационных отчислений на 2017 год.pdf',''),(23,'5/16','2016-01-01','План амортизационных отчислений на 2016 год',6,17,2,'2016-12-31',1,NULL,''),(24,'5/15','2015-01-01','План амортизационных отчислений на 2015 год',6,17,2,'2015-12-31',3,NULL,''),(25,'6/16','2016-01-01','Кассовый план на 2 полугодие 2016',4,2,3,'2016-12-31',1,NULL,''),(26,'6/17','2017-01-01','Кассовый план на 1 полугодие 2017',4,10,3,'2017-03-31',2,'Кассовый план на 1 полугодие 2017.pdf',''),(27,'7/17','2017-04-01','Кассовый план на 2 полугодие 2017',4,2,3,'2017-06-30',2,NULL,''),(28,'8/17','2017-02-23','Кредитная заявка Беларусбанк',11,12,1,'2017-03-02',2,NULL,NULL),(29,'9/17','2017-02-25','Кредитная заявка МТБанк',11,11,1,'2017-02-26',2,'Кредитная заявка МТБанк.pdf',''),(30,'10/17','2017-02-16','Кредитная заявка БПС-Сбербанк',11,13,1,'2017-02-23',2,NULL,''),(31,'11/16','2016-12-14','План капитального ремонта здания ул.Филимонова, 53',8,5,3,'2017-02-05',2,NULL,''),(32,'6/16','2016-11-01','План модернизации VoIP-телефонии офиса',8,10,3,'2017-03-16',2,'План модернизации VoIP-телефонии офиса.pdf',''),(33,'7/16','2016-09-13','Строительство торгового павильона',7,11,3,'2017-06-24',2,NULL,''),(34,'12/17','2017-02-22','Выплаты из прибыли 2016 года',9,7,2,'2017-04-07',2,NULL,''),(36,'7/16','2016-11-01','Разработка Положения о закупках',2,6,1,'2017-04-01',2,NULL,''),(37,'13/16','2016-09-06','Разработка Положения о премировании',2,3,5,'2017-04-13',2,NULL,''),(38,'14/16','2016-09-20','Разработка Учетной политики по налоговому учету на 2017 год',1,14,6,'2016-12-31',2,NULL,''),(39,'7/15','2015-08-11','Разработка Учетной политики по налоговому учету на 2016 год',1,6,6,'2016-01-01',1,NULL,''),(40,'15/17','2017-02-01','Кредитная заявка Беларусбанк',11,4,1,'2017-02-11',2,NULL,''),(41,'15/46','2017-02-20','План распределения балансовой прибыли на 2 кв. 2017 года',9,1,2,'2017-03-15',2,NULL,''),(42,'15/47','2017-02-01','Кредитная заявка Беларусбанк (в евро)',11,4,1,'2017-03-11',2,NULL,NULL),(43,'15/48','2017-02-26','Кредитная заявка Беларусбанк (в долларах США)',11,9,1,'2017-03-17',2,NULL,NULL),(44,'15/79','2017-02-24','Кредитная заявка МТБанк (в евро)',11,4,1,'2017-03-22',2,NULL,NULL),(45,'15/88','2017-02-25','Кредитная заявка БПС-Сбербанк (в евро)',11,9,1,'2017-03-22',2,NULL,NULL),(46,'16/106','2017-02-01','План капитального ремонта складского помещения (филиал 1)',8,1,3,'2017-03-15',2,'План капитального ремонта складского помещения (филиал 1).pdf',NULL),(47,'16/106','2017-02-11','План капитального ремонта складского помещения (филиал 2)',8,17,3,'2017-02-27',2,NULL,NULL),(48,'16/106','2017-02-17','План капитального ремонта складского помещения (филиал 3)',8,14,3,'2017-03-02',2,NULL,NULL),(49,'16/106','2017-02-05','План капитального ремонта складского помещения (филиал 4)',8,16,3,'2017-03-10',2,NULL,NULL),(50,'50/81','2017-02-11','План реализации продукции (позиция 006-01) на 2 кв. 2017 г.',5,2,4,'2017-03-03',2,'План реализации продукции (позиция 006-01) на 2 кв. 2017 г..pdf',NULL),(51,'50/82','2017-02-12','План реализации продукции (позиция 006-02) на 2 кв. 2017 г.',5,3,4,'2017-03-06',2,NULL,NULL),(52,'50/83','2017-02-13','План реализации продукции (позиция 006-03) на 2 кв. 2017 г.',5,5,4,'2017-03-14',2,NULL,NULL),(53,'50/84','2017-02-14','План реализации продукции (позиция 006-04) на 2 кв. 2017 г.',5,6,4,'2017-03-06',2,NULL,NULL),(54,'50/85','2017-02-15','План реализации продукции (позиция 006-05) на 2 кв. 2017 г.',5,18,4,'2017-03-03',2,NULL,NULL),(55,'50/93','2017-02-16','План реализации продукции (позиция 006-06) на 2 кв. 2017 г.',5,16,4,'2017-03-08',2,NULL,NULL),(56,'50/94','2017-02-17','План реализации продукции (позиция 006-07) на 2 кв. 2017 г.',5,12,4,'2017-03-04',2,NULL,NULL),(57,'50/96','2017-02-18','План реализации продукции (позиция 006-08) на 2 кв. 2017 г.',5,2,4,'2017-03-11',2,NULL,NULL),(58,'50/99','2017-02-19','План реализации продукции (позиция 006-09) на 2 кв. 2017 г.',5,3,4,'2017-03-22',2,NULL,NULL),(59,'17/105','2017-02-03','План капитального ремонта заготовительного цеха (филиал 7)',8,1,3,'2017-04-17',2,NULL,''),(60,'17/106','2017-02-05','План капитального ремонта производственного цеха (филиал 2)',8,2,3,'2017-04-15',2,NULL,NULL),(61,'17/13','2017-02-18','План капитального ремонта производственного цеха (филиал 3)',8,13,3,'2017-04-18',2,NULL,NULL),(62,'12/98','2017-02-10','План капитального ремонта производственного цеха (филиал 4)',8,1,3,'2017-04-11',2,NULL,NULL),(63,'15/87','2017-02-10','План капитального ремонта производственного цеха (филиал 5)',8,18,3,'2017-04-10',2,NULL,NULL);
UNLOCK TABLES;


--
-- Table structure for table `initiator`
--

DROP TABLE IF EXISTS `initiator`;
CREATE TABLE `initiator` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `initiator`
--

LOCK TABLES `initiator` WRITE;
INSERT INTO `initiator` VALUES (1,'Финансовый отдел'),(2,'Бухгалтерия'),(3,'Планово-экономический отдел'),(4,'Отдел сбыта'),(5,'Отдел труда и зарплаты'),(6,'Отдел \n

\nналогообложения');
UNLOCK TABLES;

--
-- Table structure for table `performer`
--

DROP TABLE IF EXISTS `performer`;
CREATE TABLE `performer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `post` varchar(100) DEFAULT NULL,
  `phone_in` varchar(10) DEFAULT NULL,
  `phone_out` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `performer`
--

LOCK TABLES `performer` WRITE;
INSERT INTO `performer` VALUES (1,'Иванова А.А.','Заместитель начальника отдела','102','(017) 215-17-89',NULL),(2,'Синицын А.Ю.','Экономист 2 категории','103','(017) 215-17-

89',NULL),(3,'Павлова А.Н.','Экономист 1 категории','104','(017) 215-17-96',NULL),(4,'Варламов Н.Е.','Специалист','105','(017) 215-17-98',NULL),(5,'Постоловский 

А.Б.','Экономист 2 категории','106','(017) 215-18-15',NULL),(6,'Карасев Е.Ю.','Начальник отдела','101','(017) 215-18-20',NULL),(7,'Филлимонов К.Е.','Финансовый 

аналитик','107','(017) 215-18-25',NULL),(8,'Беляева О.И.','Ведущий специалист','108','(017) 215-18-27',NULL),(9,'Никифоров А.Ю.','Экономист 2 категории','109','(017) 215-18-

26',NULL),(10,'Горький С.А.','Экономист 1 категории','110','(017) 215-18-27',NULL),(11,'Пилюлин П.Р.','Финансовый аналитик','111','(017) 215-18-88',NULL),(12,'Шохин 

Е.К.','Специалист','112','(017) 215-18-36',NULL),(13,'Туров М.С.','Экономист 1 категории','113','(017) 215-18-64',NULL),(14,'Александрова И.И.','Финансовый 

аналитик','114','(017) 215-18-17',NULL),(15,'Болтрукевич В.В.','Ведущий специалист','115','(017) 215-18-74',NULL),(16,'Сошников А.А.','Экономист 2 категории','116','(017) 

215-18-66',NULL),(17,'Панкратов П.П.','Ведущий специалист','117','(017) 215-18-78',NULL),(18,'Прохоров Д.Л.','Экономист 1 категории','118','(017) 215-18-33',NULL);
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `status_id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
INSERT INTO `status` VALUES (1,'Обработан/выполнен'),(2,'Принят к обработке'),(3,'Обработка отменена'),(4,'Не требует обработки'),(5,'Выведен из документооборота');
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_id_UNIQUE` (`id`),
  UNIQUE KEY `type_name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
INSERT INTO `type` VALUES (3,'График'),(4,'Кассовый план'),(11,'Кредитная заявка'),(6,'План амортизационных отчислений'),(10,'План по налогу \n\nс оборота'),(9,'План 

распределения балансовой прибыли'),(5,'План реализации продукции'),(8,'План финансирования капитального ремонта основных фондов'),(7,'План финансирования капитальных 

вложений'),(2,'Положение'),(1,'Проект документа');
UNLOCK TABLES;

-- FK

ALTER TABLE `fin_dept_docs`.`document` 
ADD CONSTRAINT `FK_initiator`
  FOREIGN KEY (`initiator_id`)
  REFERENCES `fin_dept_docs`.`initiator` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_perfomer`
  FOREIGN KEY (`performer_id`)
  REFERENCES `fin_dept_docs`.`performer` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_status`
  FOREIGN KEY (`status_id`)
  REFERENCES `fin_dept_docs`.`status` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_type`
  FOREIGN KEY (`type_id`)
  REFERENCES `fin_dept_docs`.`type` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
