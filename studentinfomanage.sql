CREATE TABLE `class` (
  `id` tinyint(10) NOT NULL AUTO_INCREMENT,
  `classname` varchar(128) DEFAULT NULL,
  `subject` varchar(128) DEFAULT NULL,
  `dept` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4


CREATE TABLE `student` (
  `sid` bigint(128) NOT NULL AUTO_INCREMENT,
  `sname` varchar(128) NOT NULL,
  `sex` tinyint(10) DEFAULT NULL,
  `class` tinyint(10) DEFAULT NULL,
  `date` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=201702379 DEFAULT CHARSET=utf8mb4


CREATE TABLE `user` (
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4
