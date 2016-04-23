-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb2` DEFAULT CHARACTER SET utf8 ;
USE `mydb2` ;

-- -----------------------------------------------------
-- Table `mydb2`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `mydb2`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `mypassword` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `firstname` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `lastname` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `age` INT(11) NOT NULL,
  `role_id` INT(11) NULL,
  PRIMARY KEY (`id`, `role_id`),
  INDEX `fk_user_role1_idx` (`role_id` ASC),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC),
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `mydb2`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `mydb2`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`address` (
  `country` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `street` VARCHAR(256) CHARACTER SET 'utf8' NULL,
  `zip` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_address_user1_idx` (`user_id` ASC),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  CONSTRAINT `fk_address_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `mydb2`.`music_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`music_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `mydb2`.`user_musictype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`user_musictype` (
  `user_id` INT(11) NULL DEFAULT NULL,
  `music_type_id` INT(11) NULL DEFAULT NULL,
  INDEX `user_id` (`user_id` ASC),
  INDEX `music_type_id` (`music_type_id` ASC),
  CONSTRAINT `user_musictype_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb2`.`user` (`id`),
  CONSTRAINT `user_musictype_ibfk_2`
    FOREIGN KEY (`music_type_id`)
    REFERENCES `mydb2`.`music_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
