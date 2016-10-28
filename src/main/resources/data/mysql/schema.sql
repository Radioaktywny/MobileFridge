DROP TABLE IF EXISTS `AccountSettings`;
DROP TABLE IF EXISTS `Product`;
DROP TABLE IF EXISTS `Account`;
DROP TABLE IF EXISTS `Fridge`;

CREATE TABLE `Account` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `settingsId` bigint(20) unsigned ,
  PRIMARY KEY (`id`),
  CONSTRAINT `UQ_Account_Username` UNIQUE (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `AccountSettings` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `accountId` bigint(20) unsigned NOT NULL,
  `firstName` varchar(50) ,
  `lastName` varchar(100) ,
  `age` int(3) unsigned ,
  PRIMARY KEY (`id`),
  FOREIGN KEY  (`accountId`) REFERENCES Account(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Fridge` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Product` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `weight` int(4) NOT NULL,
  `fridgeId` bigint(20) unsigned NOT NULL ,
  PRIMARY KEY (`id`),
  FOREIGN KEY  (`fridgeId`) REFERENCES Fridge(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;