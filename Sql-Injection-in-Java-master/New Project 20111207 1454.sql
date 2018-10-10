-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.55


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema test
--

CREATE DATABASE IF NOT EXISTS test;
USE test;

--
-- Definition of table `User`
--

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `userId` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` (`userId`,`password`,`city`,`country`,`email`,`phone`,`firstName`,`lastName`) VALUES 
 ('sandeep','sandeep123','pune','IndiaASAS','panksfdajv@cdac.in','999999999','SANDEEP','MALVIYA'),
 ('ramki','ramki123','PUne','INdia','rkrishanan@cdac.in','9999999999','Ramakrishnan','E.P.'),
 ('test','test123','city','country','test@cdac.in','0000000000','test','test'),
 ('tess','sss','ss','ss','test@cdac.in','3333333333','sss','sss'),
 ('tesss','1111','1111','1111','test@cdac.in','1111111111','1111','1111'),
 ('TESSDF','111','111','11','test@cdac.in','1111111111','111','111'),
 ('dsdsad','1111','fds','fds','test@cdac.in','3432222222','fdsf','fdsfs'),
 ('harshal1','1','1','1','fsd@fg.hj','1111111111','1','1'),
 ('g21','g12','sdf','Albania','rahs@gmail.com','1111111111','g12','sdf'),
 ('wqwq','qq','qq','qq','qq@er.hj','1212121212','qq','qq'),
 ('rerere','qq','qq','Albania','rahs@gmail.com','1212121212','qq','qq'),
 ('sasasa','sa','sad','Bhutan','rahs@gmail.com','2133333333','sa','sa'),
 ('tqwt','wq','sad','Angola','rahs@gmail.com','1222222222','wq','wq'),
 ('tetststst','kl','df','Bahrain','rahs@gmail.com','1211111111','kl','lk'),
 ('ghfh','34','fsd','Costa Rica','rahs@gmail.com','3244444444','34','34'),
 ('renug','123','sda','Switzerland','rahs@gmail.com','2333333333','123','123'),
 ('testt','123','sda','Algeria','rahs@gmail.com','2222222222','123','12'),
 ('ghtyghty','67','jgh','Australia','rahs@gmail.com','7777777777','67','67'),
 ('test90','90','bvc','Antigua And Barbuda','rahs@gmail.com','1111111111','90','bcv'),
 ('popopo','po','po','Christmas Island','rahs@gmail.com','1111111111','po','po'),
 ('pipipi','pi','pi','Antigua And Barbuda','rahs@gmail.com','1111111111','pi','pi'),
 ('pipipipi','pi','df','Antarctica','rahs@gmail.com','1222222222','pi','pi');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
