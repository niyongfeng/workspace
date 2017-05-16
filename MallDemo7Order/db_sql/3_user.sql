-- user table
CREATE TABLE `mall_demo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NULL,
  `email` VARCHAR(45) not NULL,
  `status` int not null,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_name_UNIQUE` (`login_name` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));

  
CREATE TABLE `mall_demo`.`notification` (
  `notification_id` INT NOT NULL AUTO_INCREMENT,
  `ntype` VARCHAR(45) NOT NULL,
  `token` VARCHAR(200) NOT NULL,
  `info` VARCHAR(100) NULL,
  `expire_time` DATETIME NOT NULL,
  PRIMARY KEY (`notification_id`),
  UNIQUE INDEX `notification_id_UNIQUE` (`notification_id` ASC),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC));
