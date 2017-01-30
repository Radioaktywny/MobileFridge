INSERT IGNORE INTO Account(username,password,role)
VALUES('marcin','$2a$04$mvZTYDr/1E2AxFCqADPkeukCpSAVJvn9L9jxmCgrB/rtJjmcPz/ny','ADMIN');
INSERT IGNORE INTO fridge(id,name)
VALUES('1','first');
INSERT IGNORE INTO account_settings(account_id,first_name,last_name,age)
VALUES('1',null,null,NULL);
INSERT INTO `product` (`id`, `icon_big`, `icon_small`, `adding_time`, `gtin`, `name`, `weight`, `weight_unit`, `fridge_id`) VALUES
  (1, 'http://www.produktywsieci.pl/brandbank/big/05900497292009.jpg', 'http://www.produktywsieci.pl/brandbank/small/05900497292009.jpg', '2017/01/30 17:08:36', '5900497292009', 'Pepsi Twist Napój gazowany 2 l', '2', 'L', 1);