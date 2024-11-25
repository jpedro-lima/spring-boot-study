CREATE TABLE `books` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`author` LONGTEXT,
	`launch_date` datetime(6) NOT NULL,
	`price` DECIMAL(65,2) NOT NULL,
	`title` LONGTEXT,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
