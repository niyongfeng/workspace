CREATE SCHEMA `mall_demo` DEFAULT CHARACTER SET utf8 ;

-- product
  CREATE TABLE `mall_demo`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` LONGTEXT NULL,
  `price` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC));

INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P001', '热水器1', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P002', '热水器2', '非常好的热水器', '200');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P003', '热水器3', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P004', '热水器4', '非常好的热水器', '300');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P005', '热水器5', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P006', '热水器6', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P007', '热水器7', '非常好的热水器', '400');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P008', '热水器8', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P009', '热水器9', '非常好的热水器', '560');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P010', '热水器10', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P011', '热水器11', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P012', '热水器12', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P013', '热水器13', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P014', '热水器14', '非常好的热水器', '600');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P015', '热水器15', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P016', '热水器16', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P017', '热水器17', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P018', '热水器18', '非常好的热水器', '400');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P019', '热水器19', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P020', '热水器20', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P021', '热水器21', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P022', '热水器22', '非常好的热水器', '320');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P023', '热水器23', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P024', '热水器24', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P025', '热水器25', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P026', '热水器26', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P027', '热水器27', '非常好的热水器', '300');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P028', '热水器28', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P029', '热水器29', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P030', '热水器30', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P031', '热水器31', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P032', '热水器32', '非常好的热水器', '400');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P033', '热水器33', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P034', '热水器34', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P035', '热水器35', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P036', '热水器36', '非常好的热水器', '500');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P037', '热水器37', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P038', '热水器38', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P039', '热水器39', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P040', '热水器40', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P041', '热水器41', '非常好的热水器', '600');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P042', '热水器42', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P043', '热水器43', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P044', '热水器44', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P045', '热水器45', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P046', '热水器46', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P047', '热水器47', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P048', '热水器48', '非常好的热水器', '400');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P049', '热水器49', '非常好的热水器', '100');
INSERT INTO `mall_demo`.`product` (`code`, `name`, `description`, `price`) VALUES ('P050', '热水器50', '非常好的热水器', '100');

  
