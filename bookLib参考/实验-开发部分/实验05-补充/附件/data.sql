-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `ProductID` int(11) NOT NULL,
  `ProductName` varchar(40) DEFAULT NULL,
  `UnitPrice` float DEFAULT NULL,
  `UnitsInStock` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `CustomerID` varchar(5) DEFAULT NULL,
  `EmployeeID` int(11) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for orderdetails
-- ----------------------------
DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails` (
  `OrderID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `UnitPrice` float DEFAULT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`OrderID`,`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `CustomerID` varchar(5) NOT NULL,
  `CompanyName` varchar(40) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `products` VALUES ('1', 'Ï´·¢Ë®', '25.00', '300');
INSERT INTO `products` VALUES ('2', 'Î÷¹Ï', '6.00', '30');
INSERT INTO `products` VALUES ('3', 'Ö½½í', '2.60', '100');
INSERT INTO `products` VALUES ('4', '÷è÷ëÎ÷¹Ï', '9.60', '50');

INSERT INTO `customers` VALUES('001','Alfreds Futterkiste');
INSERT INTO `customers` VALUES('002','Around the Horn');
INSERT INTO `customers` VALUES('003','Berglunds snabbkp');


INSERT INTO `orders` VALUES ('1', '001', '3', '2018-03-05 14:35:32');
INSERT INTO `orders` VALUES ('2', '002', '4', '2018-03-18 14:35:27');
INSERT INTO `orders` VALUES ('3', '001', '4', '2018-03-19 14:35:27');

INSERT INTO `orderdetails` VALUES ('1', '1', '25.00', '4');
INSERT INTO `orderdetails` VALUES ('1', '2', '5.00', '1');
INSERT INTO `orderdetails` VALUES ('2', '1', '15.00', '10');
INSERT INTO `orderdetails` VALUES ('3', '3', '3.00', '15');
INSERT INTO `orderdetails` VALUES ('3', '4', '9.00', '30');
