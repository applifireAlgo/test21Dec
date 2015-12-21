DROP TABLE IF EXISTS `ast_Product_M`;

CREATE TABLE `ast_Product_M` ( `productId` VARCHAR(256) NOT NULL, `productName` VARCHAR(256) NOT NULL, `productDesc` VARCHAR(256) NOT NULL, `productUnitPrice` DOUBLE(10,2) NOT NULL, `productStock` INT(10) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`productId`));

