CREATE TABLE IF NOT EXISTS `person` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(80) NOT NULL,
	`last_name` VARCHAR(80) NOT NULL,
	`address` VARCHAR(80) NOT NULL,
	`gender` ENUM('Male', 'Female', 'Non-binary', 'Other') NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
