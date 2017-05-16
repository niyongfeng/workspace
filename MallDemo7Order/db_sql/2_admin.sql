-- admin
CREATE TABLE `mall_demo`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_name_UNIQUE` (`login_name` ASC));

-- seeding a admin
INSERT INTO `mall_demo`.`admin` (`login_name`, `password`) VALUES ('admin', 'admin');
