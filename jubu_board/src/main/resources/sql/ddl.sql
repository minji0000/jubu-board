CREATE TABLE `board` (
  `board_id` int NOT NULL AUTO_INCREMENT,
  `writer_id` int DEFAULT NULL,
  `title` varchar(100) COLLATE utf8mb3_bin DEFAULT NULL,
  `content` varchar(2000) COLLATE utf8mb3_bin DEFAULT NULL,
  `view` int DEFAULT '0',
  `good` int DEFAULT '0',
  `mod_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`board_id`),
  UNIQUE KEY `board_id_UNIQUE` (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin

CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `board_id` int NOT NULL,
  `writer_id` varchar(50) COLLATE utf8mb3_bin NOT NULL,
  `content` text COLLATE utf8mb3_bin NOT NULL,
  `parent_id` int DEFAULT NULL,
  `reg_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`),
  KEY `board_id` (`board_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`board_id`) REFERENCES `board` (`board_id`) ON DELETE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`comment_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(256) COLLATE utf8mb3_bin DEFAULT NULL,
  `nickname` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin