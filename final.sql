-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.9.3-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para sgiu
CREATE DATABASE IF NOT EXISTS `sgiu` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sgiu`;

-- Volcando estructura para tabla sgiu.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `idCurso` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigoCurso` varchar(50) NOT NULL,
  `idIdioma` bigint(20) NOT NULL,
  `idTipoCurso` bigint(20) NOT NULL,
  `idModalidad` bigint(20) NOT NULL,
  `idNivel` bigint(20) NOT NULL,
  PRIMARY KEY (`idCurso`),
  UNIQUE KEY `codigoCurso` (`codigoCurso`),
  KEY `FK_Idioma` (`idIdioma`),
  KEY `FK_TipoCurso` (`idTipoCurso`),
  KEY `FK_Modalidad` (`idModalidad`),
  KEY `FK_Nivel` (`idNivel`),
  CONSTRAINT `FK_Idioma` FOREIGN KEY (`idIdioma`) REFERENCES `idioma` (`idIdioma`),
  CONSTRAINT `FK_Modalidad` FOREIGN KEY (`idModalidad`) REFERENCES `modalidad` (`idModalidad`),
  CONSTRAINT `FK_Nivel` FOREIGN KEY (`idNivel`) REFERENCES `nivel` (`idNivel`),
  CONSTRAINT `FK_TipoCurso` FOREIGN KEY (`idTipoCurso`) REFERENCES `tipocurso` (`idTipoCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.curso: ~1 rows (aproximadamente)
DELETE FROM `curso`;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idCurso`, `codigoCurso`, `idIdioma`, `idTipoCurso`, `idModalidad`, `idNivel`) VALUES
	(2, 'ENG02', 1, 2, 2, 2),
	(3, 'FR0333', 3, 1, 1, 2);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `idFactura` bigint(20) NOT NULL AUTO_INCREMENT,
  `folioFactura` varchar(50) NOT NULL,
  `fechaFactura` int(11) NOT NULL,
  `razonSocial` varchar(30) NOT NULL,
  PRIMARY KEY (`idFactura`),
  UNIQUE KEY `folioFactura` (`folioFactura`),
  UNIQUE KEY `razonSocial` (`razonSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.factura: ~2 rows (aproximadamente)
DELETE FROM `factura`;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` (`idFactura`, `folioFactura`, `fechaFactura`, `razonSocial`) VALUES
	(1, 'test77', 12122022, '4242424yy'),
	(2, 'tretret54q', 12122022, '4242424'),
	(3, 'tretret543', 12122022, '323244');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.genero
CREATE TABLE IF NOT EXISTS `genero` (
  `idGenero` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT 'INDEFINIDO',
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.genero: ~3 rows (aproximadamente)
DELETE FROM `genero`;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` (`idGenero`, `nombre`) VALUES
	(1, 'Femenino'),
	(2, 'Masculino'),
	(3, 'Indefinido');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.idioma
CREATE TABLE IF NOT EXISTS `idioma` (
  `idIdioma` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT 'INGLÉS',
  PRIMARY KEY (`idIdioma`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.idioma: ~5 rows (aproximadamente)
DELETE FROM `idioma`;
/*!40000 ALTER TABLE `idioma` DISABLE KEYS */;
INSERT INTO `idioma` (`idIdioma`, `nombre`) VALUES
	(1, 'Ingles'),
	(2, 'Espanol'),
	(3, 'Frances'),
	(4, 'Portugues'),
	(5, 'Aleman');
/*!40000 ALTER TABLE `idioma` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.modalidad
CREATE TABLE IF NOT EXISTS `modalidad` (
  `idModalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT 'BÁSICO',
  PRIMARY KEY (`idModalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.modalidad: ~5 rows (aproximadamente)
DELETE FROM `modalidad`;
/*!40000 ALTER TABLE `modalidad` DISABLE KEYS */;
INSERT INTO `modalidad` (`idModalidad`, `nombre`) VALUES
	(1, 'Basico'),
	(2, 'Regular Uno'),
	(3, 'Regular Dos'),
	(4, 'Regular Tres'),
	(5, 'Regular Cuatro');
/*!40000 ALTER TABLE `modalidad` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.nacionalidad
CREATE TABLE IF NOT EXISTS `nacionalidad` (
  `idNacionalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT 'MEXICANA',
  PRIMARY KEY (`idNacionalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.nacionalidad: ~3 rows (aproximadamente)
DELETE FROM `nacionalidad`;
/*!40000 ALTER TABLE `nacionalidad` DISABLE KEYS */;
INSERT INTO `nacionalidad` (`idNacionalidad`, `nombre`) VALUES
	(1, 'Mexicana'),
	(2, 'Estadounidense'),
	(3, 'Brasilena');
/*!40000 ALTER TABLE `nacionalidad` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.nivel
CREATE TABLE IF NOT EXISTS `nivel` (
  `idNivel` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT 'A1',
  PRIMARY KEY (`idNivel`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.nivel: ~6 rows (aproximadamente)
DELETE FROM `nivel`;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
INSERT INTO `nivel` (`idNivel`, `nombre`) VALUES
	(1, 'A1'),
	(2, 'A2'),
	(3, 'B1'),
	(4, 'B2'),
	(5, 'C1'),
	(6, 'C2');
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.ordenpagocursos
CREATE TABLE IF NOT EXISTS `ordenpagocursos` (
  `idOrdenPagoCursos` bigint(20) NOT NULL AUTO_INCREMENT,
  `folioPago` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `fechaPago` varchar(8) NOT NULL,
  `idTipoPago` bigint(20) NOT NULL,
  PRIMARY KEY (`idOrdenPagoCursos`),
  UNIQUE KEY `folioPago` (`folioPago`),
  KEY `FK_TipoPago` (`idTipoPago`),
  CONSTRAINT `FK_TipoPago` FOREIGN KEY (`idTipoPago`) REFERENCES `tipopago` (`idTipoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.ordenpagocursos: ~0 rows (aproximadamente)
DELETE FROM `ordenpagocursos`;
/*!40000 ALTER TABLE `ordenpagocursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordenpagocursos` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `idPersona` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL CHECK (`edad` > 15),
  `correoElectronico` varchar(50) NOT NULL,
  `rfc` varchar(50) NOT NULL,
  `idGenero` bigint(20) NOT NULL,
  `idNacionalidad` bigint(20) NOT NULL,
  `pais` varchar(50) NOT NULL DEFAULT 'MÉXICO',
  `estado` varchar(50) NOT NULL DEFAULT 'MÉXICO',
  `localidad` varchar(50) NOT NULL DEFAULT 'INDEFINIDO',
  `calle` varchar(50) NOT NULL,
  `codigoPostal` bigint(20) NOT NULL,
  `numExt` int(11) DEFAULT NULL,
  `numInt` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `rfc` (`rfc`),
  KEY `FK_Genero` (`idGenero`),
  KEY `FK_Nacionalidad` (`idNacionalidad`),
  CONSTRAINT `FK_Genero` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`),
  CONSTRAINT `FK_Nacionalidad` FOREIGN KEY (`idNacionalidad`) REFERENCES `nacionalidad` (`idNacionalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.persona: ~4 rows (aproximadamente)
DELETE FROM `persona`;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`idPersona`, `nombre`, `edad`, `correoElectronico`, `rfc`, `idGenero`, `idNacionalidad`, `pais`, `estado`, `localidad`, `calle`, `codigoPostal`, `numExt`, `numInt`) VALUES
	(1, 'Persona 1', 16, 'correo1@gmail.com', '0000000001', 1, 1, 'México', 'México', 'Izcalli del Valle', 'Valle del agua', 54946, 232, NULL),
	(2, 'Persona 2', 22, 'correo2@gmail.com', '0000000002', 2, 3, 'México', 'Querétaro', 'Los azules', 'Azul 1', 54346, 2323, 3234),
	(3, 'Persona 3', 33, 'correo3@gmail.com', '0000000003', 2, 2, 'México', 'León', 'Agua Azul', 'Raul Anguiano', 54933, 232, 224),
	(4, 'Persona 4', 44, 'correo4@gmail.com', '0000000004', 2, 1, 'México', 'México', 'Ecatepec', 'Hidalgo', 30, 232, 3);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.tipocurso
CREATE TABLE IF NOT EXISTS `tipocurso` (
  `idTipoCurso` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT 'GRUPAL',
  PRIMARY KEY (`idTipoCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.tipocurso: ~2 rows (aproximadamente)
DELETE FROM `tipocurso`;
/*!40000 ALTER TABLE `tipocurso` DISABLE KEYS */;
INSERT INTO `tipocurso` (`idTipoCurso`, `nombre`) VALUES
	(1, 'Individual'),
	(2, 'Grupal');
/*!40000 ALTER TABLE `tipocurso` ENABLE KEYS */;

-- Volcando estructura para tabla sgiu.tipopago
CREATE TABLE IF NOT EXISTS `tipopago` (
  `idTipoPago` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipoPago`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgiu.tipopago: ~4 rows (aproximadamente)
DELETE FROM `tipopago`;
/*!40000 ALTER TABLE `tipopago` DISABLE KEYS */;
INSERT INTO `tipopago` (`idTipoPago`, `nombre`) VALUES
	(1, 'PayPal'),
	(2, 'Tarjeta de Credito'),
	(3, 'Tarjeta de debito'),
	(4, 'Efectivo');
/*!40000 ALTER TABLE `tipopago` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;


CREATE TABLE Alumno
(
	idAlumno            BIGINT PRIMARY KEY AUTO_INCREMENT, 
	matricula           VARCHAR(50) UNIQUE NOT NULL,
	calificacion        DECIMAL  NOT NULL CHECK( calificacion > 7.0),
	activo              INTEGER   NOT NULL,
   idPersona           BIGINT NOT NULL,
         
	
	 	CONSTRAINT FK_Persona FOREIGN KEY (idPersona)
   REFERENCES Persona(idPersona)
   
);








