CREATE DATABASE `perfumaria`;

USE `perfumaria`;

CREATE TABLE `TB_CLIENT_INFO` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NM_CLIE` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `TP_CLIE` varchar(45) NOT NULL,
  `GENDER` varchar(45) NOT NULL,
  `NR_PHONE` varchar(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TB_ADDRESS` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NM_ADDRESS` varchar(100) NOT NULL,
  `NR_ADDRESS` int NOT NULL,
  `CEP` varchar(10) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `COMPLEMENT` varchar(45) DEFAULT NULL,
  `DISTRICT` varchar(45) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `CLIENT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`CLIENT_ID`) REFERENCES `TB_CLIENT_INFO`(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TB_PRODUCTS` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NM_PROD` varchar(45) NOT NULL,
  `PRICE` decimal(6,2) NOT NULL,
  `QT_PROD` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TB_SALES` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CLIENT_ID` int NOT NULL,
  `STATUS` varchar(45) NOT NULL,
  `TOTAL_VALUE` decimal(7,2) NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`CLIENT_ID`) REFERENCES `TB_CLIENT_INFO`(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TB_SALE_PRODUCTS` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SALE_ID` int NOT NULL,
  `PRODUCT_ID` int NOT NULL,
  `QT_PROD` int NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`SALE_ID`) REFERENCES `TB_SALES`(`ID`),
  FOREIGN KEY (`PRODUCT_ID`) REFERENCES `TB_PRODUCTS`(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




