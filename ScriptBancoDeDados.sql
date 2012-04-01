-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.61-0ubuntu0.10.10.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema atendimento
--

CREATE DATABASE IF NOT EXISTS atendimento;
USE atendimento;

--
-- Definition of table `atendimento`.`agendamento`
--

DROP TABLE IF EXISTS `atendimento`.`agendamento`;
CREATE TABLE  `atendimento`.`agendamento` (
  `idAgendamento` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataAgendamento` date DEFAULT NULL,
  `horaAtendimento` varchar(255) DEFAULT NULL,
  `idEspecialidade` bigint(20) DEFAULT NULL,
  `idMedico` bigint(20) DEFAULT NULL,
  `idPaciente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idAgendamento`),
  KEY `FK2B9A2245E03F4475` (`idEspecialidade`),
  KEY `FK2B9A2245E60BC3E3` (`idMedico`),
  KEY `FK2B9A224556D7BFF3` (`idPaciente`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`agendamento`
--

/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
LOCK TABLES `agendamento` WRITE;
INSERT INTO `atendimento`.`agendamento` VALUES  (4,'2012-03-26','09:01',1,2,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`atendimento`
--

DROP TABLE IF EXISTS `atendimento`.`atendimento`;
CREATE TABLE  `atendimento`.`atendimento` (
  `idAtendimento` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataAtendimento` date DEFAULT NULL,
  `horaAtendimento` varchar(255) DEFAULT NULL,
  `idConvenio` bigint(20) DEFAULT NULL,
  `idEspecialidade` bigint(20) DEFAULT NULL,
  `idMedico` bigint(20) DEFAULT NULL,
  `idPaciente` bigint(20) DEFAULT NULL,
  `idTratamento` bigint(20) DEFAULT NULL,
  `valorTratamento` double NOT NULL,
  `prontuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAtendimento`),
  KEY `FKA0FBA5D0B162CCEF` (`idAtendimento`),
  KEY `FKA0FBA5D0E03F4475` (`idEspecialidade`),
  KEY `FKA0FBA5D0BA20AA97` (`idConvenio`),
  KEY `FKA0FBA5D0E60BC3E3` (`idMedico`),
  KEY `FKA0FBA5D056D7BFF3` (`idPaciente`),
  KEY `FKA0FBA5D031BE03D3` (`idTratamento`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`atendimento`
--

/*!40000 ALTER TABLE `atendimento` DISABLE KEYS */;
LOCK TABLES `atendimento` WRITE;
INSERT INTO `atendimento`.`atendimento` VALUES  (36,'2012-03-27','08:00',1,1,2,1,1,100,'Paciente está sentindo dores'),
 (37,'2012-03-27','09:00',1,1,2,1,4,170,'Paciente parou de sentir dores');
UNLOCK TABLES;
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`convenio`
--

DROP TABLE IF EXISTS `atendimento`.`convenio`;
CREATE TABLE  `atendimento`.`convenio` (
  `idConvenio` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricaoConvenio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idConvenio`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`convenio`
--

/*!40000 ALTER TABLE `convenio` DISABLE KEYS */;
LOCK TABLES `convenio` WRITE;
INSERT INTO `atendimento`.`convenio` VALUES  (1,'Unimed'),
 (2,'Sul America'),
 (4,'Particular');
UNLOCK TABLES;
/*!40000 ALTER TABLE `convenio` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`especialidade`
--

DROP TABLE IF EXISTS `atendimento`.`especialidade`;
CREATE TABLE  `atendimento`.`especialidade` (
  `idEspecialidade` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricaoEspecialidade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEspecialidade`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`especialidade`
--

/*!40000 ALTER TABLE `especialidade` DISABLE KEYS */;
LOCK TABLES `especialidade` WRITE;
INSERT INTO `atendimento`.`especialidade` VALUES  (1,'Acupuntura'),
 (2,'Cardiologista');
UNLOCK TABLES;
/*!40000 ALTER TABLE `especialidade` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`faturamento`
--

DROP TABLE IF EXISTS `atendimento`.`faturamento`;
CREATE TABLE  `atendimento`.`faturamento` (
  `id` bigint(20) NOT NULL,
  `descricaoConvenio` varchar(255) DEFAULT NULL,
  `nomeMedico` varchar(255) DEFAULT NULL,
  `valor` double NOT NULL,
  `idConvenio` bigint(20) NOT NULL,
  `valorTratamento` double NOT NULL,
  `precoTotalMateriais` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`faturamento`
--

/*!40000 ALTER TABLE `faturamento` DISABLE KEYS */;
LOCK TABLES `faturamento` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `faturamento` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`medico`
--

DROP TABLE IF EXISTS `atendimento`.`medico`;
CREATE TABLE  `atendimento`.`medico` (
  `idMedico` bigint(20) NOT NULL AUTO_INCREMENT,
  `crmMedico` varchar(255) DEFAULT NULL,
  `nomeMedico` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idMedico`),
  KEY `FKBFBE8D4957A54E1` (`login`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`medico`
--

/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
LOCK TABLES `medico` WRITE;
INSERT INTO `atendimento`.`medico` VALUES  (1,'789','Gustavo Marquesani','gumarquesani'),
 (2,'123','Fernando Santiago','fspo'),
 (3,'456','Cláudia Marquesani','cmarquesani');
UNLOCK TABLES;
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`medicoEspecialidade`
--

DROP TABLE IF EXISTS `atendimento`.`medicoEspecialidade`;
CREATE TABLE  `atendimento`.`medicoEspecialidade` (
  `idMedico` bigint(20) NOT NULL,
  `idEspecialidade` bigint(20) NOT NULL,
  PRIMARY KEY (`idMedico`,`idEspecialidade`),
  KEY `FKD3C3AEAAE03F4475` (`idEspecialidade`),
  KEY `FKD3C3AEAAE60BC3E3` (`idMedico`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`medicoEspecialidade`
--

/*!40000 ALTER TABLE `medicoEspecialidade` DISABLE KEYS */;
LOCK TABLES `medicoEspecialidade` WRITE;
INSERT INTO `atendimento`.`medicoEspecialidade` VALUES  (1,1),
 (2,1),
 (3,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `medicoEspecialidade` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`paciente`
--

DROP TABLE IF EXISTS `atendimento`.`paciente`;
CREATE TABLE  `atendimento`.`paciente` (
  `idPaciente` bigint(20) NOT NULL AUTO_INCREMENT,
  `cidade` varchar(255) DEFAULT NULL,
  `cor` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `rg` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `idConvenio` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`),
  KEY `FK2CA71371BA20AA97` (`idConvenio`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`paciente`
--

/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
LOCK TABLES `paciente` WRITE;
INSERT INTO `atendimento`.`paciente` VALUES  (1,'São Paulo','Branco','27722700845','2012-03-25','SP','José da Silva','326943146','Masculino',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`produto`
--

DROP TABLE IF EXISTS `atendimento`.`produto`;
CREATE TABLE  `atendimento`.`produto` (
  `idProduto` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricaoProduto` varchar(255) DEFAULT NULL,
  `idTipoProduto` bigint(20) DEFAULT NULL,
  `precoUnitario` double NOT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `FKED8DCEF9D2668BB9` (`idTipoProduto`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`produto`
--

/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
LOCK TABLES `produto` WRITE;
INSERT INTO `atendimento`.`produto` VALUES  (1,'Água Sanitária',1,1.5),
 (2,'Dorflex',2,20);
UNLOCK TABLES;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`registro`
--

DROP TABLE IF EXISTS `atendimento`.`registro`;
CREATE TABLE  `atendimento`.`registro` (
  `idRegistro` bigint(20) NOT NULL AUTO_INCREMENT,
  `idProduto` bigint(20) DEFAULT NULL,
  `idAtendimento` bigint(20) DEFAULT NULL,
  `precoTotal` double NOT NULL,
  `precoUnitario` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`idRegistro`),
  KEY `FKD6DC303346621EC1` (`idProduto`),
  KEY `FKD6DC3033B162CCEF` (`idAtendimento`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`registro`
--

/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
LOCK TABLES `registro` WRITE;
INSERT INTO `atendimento`.`registro` VALUES  (27,1,37,7.5,1.5,5),
 (26,2,36,80,20,4);
UNLOCK TABLES;
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`tipoProduto`
--

DROP TABLE IF EXISTS `atendimento`.`tipoProduto`;
CREATE TABLE  `atendimento`.`tipoProduto` (
  `idTipoProduto` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricaoTipoProduto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTipoProduto`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`tipoProduto`
--

/*!40000 ALTER TABLE `tipoProduto` DISABLE KEYS */;
LOCK TABLES `tipoProduto` WRITE;
INSERT INTO `atendimento`.`tipoProduto` VALUES  (1,'Material'),
 (2,'Medicamento');
UNLOCK TABLES;
/*!40000 ALTER TABLE `tipoProduto` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`tratamento`
--

DROP TABLE IF EXISTS `atendimento`.`tratamento`;
CREATE TABLE  `atendimento`.`tratamento` (
  `idTratamento` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricaoTratamento` varchar(255) DEFAULT NULL,
  `valorTratamento` double NOT NULL,
  `idConvenio` bigint(20) DEFAULT NULL,
  `idEspecialidade` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idTratamento`),
  KEY `FKB81B3581E03F4475` (`idEspecialidade`),
  KEY `FKB81B3581BA20AA97` (`idConvenio`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`tratamento`
--

/*!40000 ALTER TABLE `tratamento` DISABLE KEYS */;
LOCK TABLES `tratamento` WRITE;
INSERT INTO `atendimento`.`tratamento` VALUES  (1,'Consulta',100,1,1),
 (2,'Consulta',150,4,1),
 (3,'Sessão',200,4,1),
 (4,'Sessão',170,1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `tratamento` ENABLE KEYS */;


--
-- Definition of table `atendimento`.`usuario`
--

DROP TABLE IF EXISTS `atendimento`.`usuario`;
CREATE TABLE  `atendimento`.`usuario` (
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendimento`.`usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
LOCK TABLES `usuario` WRITE;
INSERT INTO `atendimento`.`usuario` VALUES  ('fspo','60d541f7076960f4318be19d0c65fca2'),
 ('cmarquesani','c764f5b611e78f16ce995d6ef47a3c07'),
 ('gumarquesani','83e7e26c7fd705076a84f091b29c1507'),
 ('fiap','407db65923f0469248bb47dcc18c3931');
UNLOCK TABLES;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
