CREATE TABLE IF NOT EXISTS `line_user`(
   `id` BIGINT UNSIGNED AUTO_INCREMENT,
   `login_name` VARCHAR(100) NOT NULL,
   `show_name` VARCHAR(100),
   `img_url` VARCHAR(100),
   `pwd` VARCHAR(40) NOT NULL,
   `create_time` TIMESTAMP,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `user_plan`(
   `id` BIGINT UNSIGNED AUTO_INCREMENT,
   `user_id` BIGINT NOT NULL,
   `site_id` BIGINT NOT NULL,
   `say_info` VARCHAR(4096),
   `foot_result` VARCHAR(40) NOT NULL,
   `hot` BIGINT NOT NULL,
   `click` BIGINT NOT NULL,
   `create_time` TIMESTAMP,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `foot_site`(
   `id` BIGINT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `start_time` VARCHAR(100),
   `match_name` VARCHAR(40) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user_support`(
   `id` BIGINT UNSIGNED AUTO_INCREMENT,
   `user_id` BIGINT NOT NULL,
   `plan_id` BIGINT NOT NULL,
   `support_type` VARCHAR(10),
   `create_time` TIMESTAMP,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
