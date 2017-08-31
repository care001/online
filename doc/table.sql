CREATE TABLE IF NOT EXISTS `line_user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `login_name` VARCHAR(100) NOT NULL,
   `show_name` VARCHAR(100),
   `pwd` VARCHAR(40) NOT NULL,
   `create_time` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;