-- order
CREATE TABLE `mall_demo`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  `total_price` DECIMAL NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `last_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC),
  INDEX `fk_ord_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_ord_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mall_demo`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

    
-- order detail
CREATE TABLE `mall_demo`.`order_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `order_price` DECIMAL NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_ord_order_id_idx` (`order_id` ASC),
  INDEX `fk_ord_prod_id_idx` (`product_id` ASC),
  CONSTRAINT `fk_ord_order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `mall_demo`.`order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ord_prod_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `mall_demo`.`product` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);