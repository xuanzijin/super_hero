CREATE DATABASE super_hero CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

use super_hero;

CREATE TABLE `super_hero` (
                              `super_hero_id` int NOT NULL AUTO_INCREMENT COMMENT 'primary key',
                              `alias` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                              `name` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                              `origin` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                              PRIMARY KEY (`super_hero_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `super_hero_powers` (
                                     `id` int NOT NULL AUTO_INCREMENT,
                                     `super_hero_id` int NOT NULL,
                                     `power` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `super_hero_weapons` (
                                      `id` int NOT NULL AUTO_INCREMENT,
                                      `super_hero_id` int NOT NULL,
                                      `weapon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `super_hero_associations` (
                                           `id` int NOT NULL AUTO_INCREMENT,
                                           `super_hero_id` int NOT NULL,
                                           `association` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO super_hero
(super_hero_id, alias, name, origin)
VALUES(1, 'Captain Marvel', 'Carol Danvers', 'Exposed to Space Stone reactor overload');
INSERT INTO super_hero
(super_hero_id, alias, name, origin)
VALUES(2, 'Iron Man', 'Tony Stark', 'Kidnapped in Afghanistan, created the first iron-man suit to escape.');

INSERT INTO super_hero_powers
(id, super_hero_id, power)
VALUES(1, 1, 'photon-blast');
INSERT INTO super_hero_powers
(id, super_hero_id, power)
VALUES(2, 1, 'flight');
INSERT INTO super_hero_powers
(id, super_hero_id, power)
VALUES(3, 1, 'super-strength');
INSERT INTO super_hero_powers
(id, super_hero_id, power)
VALUES(4, 1, 'healing');
INSERT INTO super_hero_powers
(id, super_hero_id, power)
VALUES(5, 2, 'genius-intelligence');
INSERT INTO super_hero_powers
(id, super_hero_id, power)
VALUES(6, 2, 'wealth');

INSERT INTO super_hero_weapons
(id, super_hero_id, weapon)
VALUES(1, 2, 'arc-reactor');
INSERT INTO super_hero_weapons
(id, super_hero_id, weapon)
VALUES(2, 2, 'iron-man-suit');
INSERT INTO super_hero_weapons
(id, super_hero_id, weapon)
VALUES(3, 2, 'iron-legion');

INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(1, 1, 'space-stone');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(2, 1, 'skrulls');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(3, 1, 'photon');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(4, 1, 'kree');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(5, 1, 'avengers');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(6, 2, 'war-machine');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(7, 2, 'avengers');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(8, 2, 'jarvis');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(9, 2, 'thanos');
INSERT INTO super_hero_associations
(id, super_hero_id, association)
VALUES(10, 2, 'pepper-potts');
