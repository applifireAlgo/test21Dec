DROP TABLE IF EXISTS `ast_UserCart_M`;

CREATE TABLE `ast_UserCart_M` ( `userCartId` VARCHAR(256) NOT NULL, `productId` VARCHAR(256) NOT NULL, `productQty` INT(10) NOT NULL, `cartTotal` DOUBLE(10,2) NOT NULL, `userId` VARCHAR(64) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`userCartId`));

