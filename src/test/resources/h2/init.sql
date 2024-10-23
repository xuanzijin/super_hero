DROP TABLE IF EXISTS `super_hero`;
DROP TABLE IF EXISTS `super_hero_powers`;
DROP TABLE IF EXISTS `super_hero_weapons`;
DROP TABLE IF EXISTS `super_hero_associations`;

CREATE TABLE `super_hero` (
                              `super_hero_id` int NOT NULL AUTO_INCREMENT COMMENT 'primary key',
                              `alias` varchar(100)  NOT NULL,
                              `name` varchar(100)  NOT NULL,
                              `origin` varchar(100)  NOT NULL,
                              PRIMARY KEY (`super_hero_id`)
) ;

CREATE TABLE `super_hero_powers` (
                                     `id` int NOT NULL AUTO_INCREMENT,
                                     `super_hero_id` int NOT NULL,
                                     `power` varchar(100)  NOT NULL,
                                     PRIMARY KEY (`id`)
) ;

CREATE TABLE `super_hero_weapons` (
                                      `id` int NOT NULL AUTO_INCREMENT,
                                      `super_hero_id` int NOT NULL,
                                      `weapon` varchar(100)  NOT NULL,
                                      PRIMARY KEY (`id`)
) ;

CREATE TABLE `super_hero_associations` (
                                           `id` int NOT NULL AUTO_INCREMENT,
                                           `super_hero_id` int NOT NULL,
                                           `association` varchar(100)  NOT NULL,
                                           PRIMARY KEY (`id`)
) ;