DROP DATABASE IF EXISTS `musicastore`;

DROP TABLE IF EXISTS `musicastore`.`customer` CASCADE;
DROP TABLE IF EXISTS `musicastore`.`category` CASCADE;
DROP TABLE IF EXISTS `musicastore`.`discount` CASCADE;
DROP TABLE IF EXISTS `musicastore`.`product` CASCADE;
DROP TABLE IF EXISTS `musicastore`.`order` CASCADE;
DROP TABLE IF EXISTS `musicastore`.`order_line` CASCADE;
DROP TABLE IF EXISTS `musicastore`.`language` CASCADE;
DROP TABLE IF EXISTS `musicastore`.`translation` CASCADE;

CREATE SCHEMA `musicastore`;

CREATE TABLE `musicastore`.`customer`(
                                         `customer_id` int NOT NULL AUTO_INCREMENT,
                                         `username` varchar(50) NOT NULL,
                                         `email` varchar(50) NOT NULL,
                                         `password` varchar(100) NOT NULL,
                                         `lastname` varchar(50) NOT NULL,
                                         `firstname` varchar(50) NOT NULL,
                                         `phone_number` varchar(10) NOT NULL,
                                         `address` varchar(50) NOT NULL,
                                         `gender` varchar(10) DEFAULT NULL,
                                         `authorities` varchar(10) default 'ROLE_USER',
                                         `credentials_non_expired` tinyint default 1,
                                         `enabled` tinyint default 1,
                                         `non_locked` tinyint default 1,
                                         `account_non_expired` tinyint default 1,
                                         PRIMARY KEY(`customer_id`),
                                         UNIQUE KEY(`username`),
                                         UNIQUE KEY(`email`),
                                         CONSTRAINT phone_number_check CHECK(phone_number !='')
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `musicastore`.`category`(
                                         `category_id` int NOT NULL AUTO_INCREMENT,
                                         PRIMARY KEY(`category_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `musicastore`.`discount`(
                                         `discount_id` int NOT NULL AUTO_INCREMENT,
                                         `percentage_off` float NOT NULL,
                                         `start_date` DATETIME NOT NULL,
                                         `end_date` DATETIME NOT NULL,
                                         PRIMARY KEY(`discount_id`),
                                         CONSTRAINT discount_date_check CHECK(`start_date` < `end_date`),
                                         CONSTRAINT discount_percentage_check CHECK(`percentage_off` > 0 AND `percentage_off` <= 100)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `musicastore`.`product`(
                                        `product_id` int NOT NULL AUTO_INCREMENT,
                                        `product_name` varchar(50) NOT NULL,
                                        `description` varchar(200) NOT NULL,
                                        `brand` varchar(60) NOT NULL,
                                        `discount_fk` int DEFAULT NULL,
                                        `category_fk` int NOT NULL,
                                        `price` float NOT NULL,
                                        `image` varchar(50) NOT NULL,
                                        PRIMARY KEY(`product_id`),
                                        FOREIGN KEY(`discount_fk`) REFERENCES `discount` (`discount_id`),
                                        FOREIGN KEY(`category_fk`) REFERENCES `category` (`category_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `musicastore`.`order`(
                                      `order_id` int NOT NULL AUTO_INCREMENT,
                                      `order_date` date NOT NULL,
                                      `delivery_date` date NOT NULL,
                                      `is_order_paid` tinyint NOT NULL,
                                      `customer_fk` int DEFAULT NULL,
                                      PRIMARY KEY(`order_id`),
                                      FOREIGN KEY(`customer_fk`) REFERENCES `customer`(`customer_id`) ON DELETE SET NULL,
                                      CONSTRAINT order_date_check CHECK(`order_date` < `delivery_date`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `musicastore`.`order_line`(
                                           `order_line_id` int NOT NULL AUTO_INCREMENT,
                                           `real_price` float NOT NULL,
                                           `quantity` int NOT NULL,
                                           `order_fk` int DEFAULT NULL,
                                           `product_fk` int DEFAULT NULL,
                                           PRIMARY KEY(`order_line_id`),
                                           FOREIGN KEY(`order_fk`) REFERENCES `order`(`order_id`) ON DELETE SET NULL,
                                           FOREIGN KEY(`product_fk`) REFERENCES `product`(`product_id`) ON DELETE SET NULL,
                                           CONSTRAINT quantity_check CHECK(`quantity` > 0)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `musicastore`.`language`(
                                         `language_id` int NOT NULL AUTO_INCREMENT,
                                         `locale` varchar(10) NOT NULL,
                                         PRIMARY KEY(`language_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `musicastore`.`translation`(
                                            `translation_id` int NOT NULL AUTO_INCREMENT,
                                            `label` varchar(50) NOT NULL,
                                            `language_fk` int NOT NULL,
                                            `category_fk` int NOT NULL,
                                            PRIMARY KEY(`translation_id`),
                                            FOREIGN KEY(`category_fk`) REFERENCES `category`(`category_id`),
                                            FOREIGN KEY(`language_fk`) REFERENCES `language`(`language_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `musicastore`.`category` VALUES (1),(2),(3),(4),(5);
INSERT INTO `musicastore`.`discount` VALUES (1,20,STR_TO_DATE('31,12,2021,00,00,01','%d,%m,%Y,%H,%i,%s'),STR_TO_DATE('02,01,2022,23,59,59','%d,%m,%Y,%H,%i,%s')),
                                            (2,50,STR_TO_DATE('02,01,2021,00,00,01','%d,%m,%Y,%H,%i,%s'),STR_TO_DATE('12,01,2022,23,59,59','%d,%m,%Y,%H,%i,%s'));
INSERT INTO `musicastore`.`language` VALUES (1, 'fr'), (2,'en');

INSERT INTO `musicastore`.`product` VALUES (1,'Ibanez PF1512 NT 12 Natural', 'Guitare acoustique, dreadnought, cutaway à 12 cordes, corps laminé et finition brillante', 'Ibanez',null,1,239.88,'products/guitares/guitare-7.jpg'),
                                           (2,'Sigma Guitars DM12E', 'Avec le DM12E+, Sigma est une guitare acoustique à 12 cordes peu couteuse qui offre un son etonnamment puissant', 'Ibanez',2,1,304.00,'products/guitares/guitare-6.jpg'),
                                           (3,'Red Hill AF-8', 'Magnifique guitare à 12 cordes, finition brillante, corps en sapin laminé et touches en laurier', 'Ibanez',1,1,131.20,'products/guitares/guitare-5.jpg'),
                                           (4,'Fender CD-140SCE-12', 'Cuirassé electro-acoustique à 12 cordes, étui inclu, idéal pour les auteurs-compositeurs & interpretes', 'Ibanez',2,1,385.99,'products/guitares/guitare-4.jpg'),
                                           (5,'YAMAHA U3 – NOIR POLI', 'Le summum de la série U, haut de ses 131cm, le U3 permet une palette de sons plus large qui donnera plus de profondeur et de puissance.', 'Yamaha',1,2,12800,'products/pianos/piano-1.jpg'),
                                           (6,'Violon', 'Violon en bois', 'Stentor',1,3,250,'products/violons/violon-1.jpg'),
                                           (7,'YAMAHA CLP 725 BLANC SATINÉ','Ce modèle CLP-725 possède déjà toutes les qualités minimales requises pour un premier piano.','Yamaha',1,2,1500.99,'products/pianos/piano-scene-2.jpg'),
                                           (8,'YAMAHA B1 – BLANC POLI','ce modèle au rapport qualité/prix exceptionnel convient parfaitement pour l apprentissage du piano','Yamaha',null,2,580.99,'products/pianos/piano-scene-3.jpg'),
                                           (9,'YAMAHA YDP 164 NOIR SATINÉ PACK','Toute l authenticité d un piano acoustique avec ce clavier GH3, agrémentée des avantages du numérique.','Yamaha',1,2,1210.00,'products/pianos/piano-numerique-2.jpg'),
                                           (10,'ROLAND FP-30X FULL PACK','Compact et abordable, le FP-30X délivre les sonorités d\’un superbe piano à queue et propose en plus d\’incomparables fonctions','Yamaha',1,2,100.99,'products/pianos/piano-numerique-3.jpg'),
                                           (11,'YAMAHA GB1 SILENT SC2 – NOIR POLI','Ce modèle est très populaire grâce à sa taille compacte associée à une excellente qualité et un prix très attractif. Egalement disponible en location-achat. Ici avec système Silent','Yamaha',1,2,1500.99,'products/pianos/piano-acoustique-2.jpg'),
                                           (12,'YAMAHA GC1','Ce modèle est très populaire grâce à sa taille compacte associée à une excellente qualité et un prix très attractif. Egalement disponible en location-achat','Yamaha',1,2,1500.99,'products/pianos/piano-acoustique-3.jpg'),
                                           (13,'ROLAND FP-30X FULL PACK','Compact et abordable, le FP-30X délivre les sonorités d’un superbe piano à queue et propose en plus d’incomparables fonctions','Yamaha',2,2,1500.99,'products/pianos/piano-acoustique-1.jpg'),
                                           (14,'Violon Gliga Gems 2 Gloria ', 'Ce violon Gliga Gems 2 Gloria de très bonne qualité conviendra parfaitement aux musiciens de plus de 12 ans, en cours d apprentissage ou débutant en école de musique ou conservatoire.', 'Stentor',2,3,650,'products/violons/violon-2.jpg'),
                                           (15,'Violoncelle Gliga Genial 1 ', 'Fait à la main, le violoncelle Genial 1 est idéal pour débuter l apprentissage de cet instrument. Fabriqué à partir de bois sélectionnés, sa table est en épicéa massif des Carpates.', 'Stentor',null,3,1650,'products/violons/violoncelle.jpg');


INSERT INTO `musicastore`.`translation` VALUES (1,'Guitare',1,1), (2,'Guitar',2,1), (3,'Piano',1,2), (4,'Piano',2,2),(5,'Violon',1,3),(6,'Violin',2,3),
                                               (7,'Batteries',1,4),(8,'Drums',2,4),(9,'Flute',1,5), (10,'Flute', 2,5);

/*-- INSERTION CUSTOMER--*/
INSERT INTO `musicastore`.`customer`
VALUES (1,'arnaud', 'arnaud@gmail.com','$2a$10$c/MdR9VXxqo2dAM/1j/A6eMsIkIJe49Q5Wz90cuB130.KFo1QQc/y','arnaud','berg','049999999','Namur henallux','homme','ROLE_ADMIN',1,1,1,1),
       (2,'donnydsm','donnydsm@gmail.com','$2a$10$GPwfRGxMnm1oKOd7fm/vdOlT41htlEfatFUdanTxDGUFNH0s3MG8m','mboma','donny','047878798','Flandre occidentale','homme','ROLE_ADMIN',1,1,1,1),
       (3,'richarg','richarg@gmail.com',' $2a$10$SmqG1AsNgF2Z8QGyWjdSOe.rLxzBwt8FIq4wwZKGk7Y7u017dnUW6','fontaine','richard','048969665','Namur namen','homme','ROLE_USER',1,1,1,1),
       (4,'louis_hermant','louis_hermant@gmail.com','$2a$10$RA1J6qNuAZiyLqE/yE4hD.x9Bj.zPA0pqFg1Rf.Ei/HCWvOjvRLWm','hermant','louis','0465656565','Bruxelles Schumann','homme','ROLE_USER',1,1,1,1),
       (5,'armel_vially','armel_vially@gmail.com','$2a$10$D2YnEChTmJIC/Ta4mXFDHeDwWAmyB4ldV7kNG2GCtIikx7ekG02ia','vially','armel','0444444444','Namur','homme','ROLE_USER',1,1,1,1),
       (6,'cycyzush','cycyzush@gmail.com','$2a$10$5KO/Esqjrfn5ZrFy.3hhVOM9obVROgYtqn0W61LuZJ4SedBb8Ocoi','zush','cynthia','0444444444','Wemmel','femme','ROLE_USER',1,1,1,1),
       (7,'dubisy','dubisy@gmail.com','$2a$10$u0RE67ioREeOvWsLwAfmiOGzpbek0sDzZPYtoEpecr0AWnBkRsYV6','dubisy','francoise','047878798','Namur-Liège','femme','ROLE_ADMIN',1,1,1,1);


set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';