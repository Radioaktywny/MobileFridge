
--
-- Struktura tabeli dla tabeli `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `account`
--

INSERT INTO `account` (`id`, `password`, `role`, `settings_id`, `username`) VALUES
  (1, '$2a$04$mvZTYDr/1E2AxFCqADPkeukCpSAVJvn9L9jxmCgrB/rtJjmcPz/ny', 'USER', NULL, 'marcin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `account_settings`
--

DROP TABLE IF EXISTS `account_settings`;
CREATE TABLE IF NOT EXISTS `account_settings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `account_settings`
--

INSERT INTO `account_settings` (`id`, `account_id`, `age`, `first_name`, `last_name`) VALUES
  (1, 1, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `fridge`
--

DROP TABLE IF EXISTS `fridge`;
CREATE TABLE IF NOT EXISTS `fridge` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `fridge_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeqwyl26xhcbu1l16u5gkg5hx0` (`fridge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `fridge`
--
ALTER TABLE `fridge`
  ADD CONSTRAINT `FKrno2nfqjjhj48dym20jo65e9c` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Ograniczenia dla tabeli `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKeqwyl26xhcbu1l16u5gkg5hx0` FOREIGN KEY (`fridge_id`) REFERENCES `fridge` (`id`);
