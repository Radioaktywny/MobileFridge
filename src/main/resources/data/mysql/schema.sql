CREATE TABLE IF NOT EXISTS `Account` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(10) NOT NULL,
  `settings_id` bigint(20) unsigned ,
  PRIMARY KEY (`id`),
  CONSTRAINT `UQ_Account_Username` UNIQUE (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `AccountSettings` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `account_id` bigint(20) unsigned NOT NULL,
  `first_name` varchar(50) ,
  `last_name` varchar(100) ,
  `age` int(3) unsigned ,

  PRIMARY KEY (`id`),
  FOREIGN KEY  (`account_id`) REFERENCES Account(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Fridge` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Product` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `weight` int(4) NOT NULL,
  `fridge_id` bigint(20) unsigned NOT NULL ,
  PRIMARY KEY (`id`),
  FOREIGN KEY  (`fridge_id`) REFERENCES Fridge(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

