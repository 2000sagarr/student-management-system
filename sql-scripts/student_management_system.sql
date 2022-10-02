DROP DATABASE  IF EXISTS `student_management_system`;

CREATE DATABASE  IF NOT EXISTS `student_management_system`;

USE `student_management_system`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `student_detail`;

CREATE TABLE `student_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
   `date_of_birth` date,
   `email` varchar(128),
   `phone_number` varchar(15),
   `address` varchar(200),
	`city` varchar(20),
    
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_detail_id` int(11),
  `student_department_id` int(11),

  PRIMARY KEY (`id`),
  foreign key (`student_detail_id`) references `student_detail` (`id`),
  foreign key (`student_department_id`) references `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50),
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` CHAR(80) NOT NULL,
    `first_name` VARCHAR(128) DEFAULT NULL,
    `last_name` VARCHAR(128) DEFAULT NULL,
    `email` VARCHAR(128) DEFAULT NULL,
    `phone_number` VARCHAR(15) DEFAULT NULL,
    `user_department_id` INT(11) default null,
    FOREIGN KEY (`user_department_id`)
        REFERENCES `department` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

create table authorities (
	`username` varchar(50) not null,
	`authority` varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `users_roles` (
  `user_id` int(11),
  `role_id` int(11),
  PRIMARY KEY (`user_id`,`role_id`),
  foreign key (`user_id`) references `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  foreign key (`role_id`) references `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50),
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;