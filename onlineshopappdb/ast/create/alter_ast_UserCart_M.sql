

ALTER TABLE `ast_UserCart_M` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_UserCart_M` ADD CONSTRAINT FOREIGN KEY (`productId`) REFERENCES `ast_Product_M`(`productId`);

