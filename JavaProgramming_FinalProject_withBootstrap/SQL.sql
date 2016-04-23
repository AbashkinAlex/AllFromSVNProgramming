-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Home8
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Home8
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Home8` DEFAULT CHARACTER SET utf8 ;
USE `Home8` ;

-- -----------------------------------------------------
-- Table `Home8`.`MyGroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Home8`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NULL,
  `department` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Home8`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Home8`.`Student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `enrolment_date` DATE NULL,
  `Group_id` INT NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_Student_Group_idx` (`Group_id` ASC),
  CONSTRAINT `fk_Student_Group`
    FOREIGN KEY (`Group_id`)
    REFERENCES `Home8`.`Group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
