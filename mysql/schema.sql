CREATE SCHEMA `mybatis_extend` ;

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET latin1 NOT NULL,
  `male` bit(1) DEFAULT NULL COMMENT '1: male'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


