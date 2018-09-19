SET NAMES utf8;

-- ---------------------------
--  Struktura tabeli `rowery`
-- ---------------------------
DROP TABLE IF EXISTS `rowery`;
CREATE TABLE `rowery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(100) NOT NULL,
  `cena` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ---------------------------
--  Wiersze w 'rowery'
-- ---------------------------
BEGIN;
INSERT INTO produkty.rowery(nazwa, cena) VALUES('Merida', 1500);
INSERT INTO produkty.rowery(nazwa, cena) VALUES('Orbea ', 1400);
COMMIT;

-- ---------------------------
--  Struktura tabeli `narty`
-- ---------------------------
DROP TABLE IF EXISTS `narty`;
CREATE TABLE `narty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(100) NOT NULL,
  `cena` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ---------------------------
--  Wiersze w 'narty'
-- ---------------------------
BEGIN;
INSERT INTO produkty.narty(nazwa, cena) VALUES('Atomic ', 1100);
INSERT INTO produkty.narty(nazwa, cena) VALUES('Lusti', 1600);
COMMIT;