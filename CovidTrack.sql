CREATE TABLE IF NOT EXISTS `covidtrack`.`users` (
  `email` VARCHAR(320) NOT NULL,
  `fName` VARCHAR(45) NULL,
  `lName` VARCHAR(45) NULL,
  `manager` VARCHAR(320) NULL,
  `passed` TINYINT ZEROFILL NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB