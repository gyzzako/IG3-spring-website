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
                                         `email` varchar(50) NOT NULL,
                                         `password` varchar(50) NOT NULL,
                                         `lastname` varchar(50) NOT NULL,
                                         `firstname` varchar(50) NOT NULL,
                                         `phone_number` varchar(10) DEFAULT NULL,
                                         `address` varchar(50) NOT NULL,
                                         `gender` varchar(10) NOT NULL,
                                         PRIMARY KEY(`customer_id`),
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
                                         `start_date` date NOT NULL,
                                         `end_date` date NOT NULL,
                                         PRIMARY KEY(`discount_id`)
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
                                      CONSTRAINT date_check CHECK(`order_date` < `delivery_date`)
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
INSERT INTO `musicastore`.`discount` VALUES (1,20,STR_TO_DATE('27,11,2021','%d,%m,%Y'),STR_TO_DATE('30,11,2021','%d,%m,%Y'));
INSERT INTO `musicastore`.`language` VALUES (1, 'fr'), (2,'en');
INSERT INTO `musicastore`.`product` VALUES (1,'Guitare1', 'Belle guitare', 'Ibanez',1,1,20.6,'products/guitares/guitare-7.jpg'),(2,'Guitare2', 'Superbe guitare', 'Ibanez',1,1,40.6,'products/guitares/guitare-6.jpg'),
                                           (3,'Guitare3', 'Magnifique guitare', 'Ibanez',1,1,206,'products/guitares/guitare-5.jpg'),(4,'Guitare4', 'Guitare de rock', 'Ibanez',1,1,27,'products/guitares/guitare-4.jpg'),
                                           (5,'Piano1', 'Magnifique piano', 'Yamaha',1,2,800,'products/pianos/piano-1.jpg'),(6,'Violon', 'Violon en bois', 'Stentor',1,3,250,'products/violons/violon-1.jpg');
INSERT INTO `musicastore`.`translation` VALUES (1,'Guitare',1,1), (2,'Guitar',2,1), (3,'Piano',1,2), (4,'Piano',2,2),(5,'Violon',1,3),(6,'Violin',2,3);


set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';