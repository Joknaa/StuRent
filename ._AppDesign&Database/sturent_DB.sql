-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 24, 2021 at 05:44 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sturent`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `Post_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(50) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Address` varchar(100) NOT NULL,
  `Gender` enum('Man','Woman') NOT NULL,
  `Price` int(11) NOT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Has_Wifi` varchar(10) DEFAULT '0',
  `Has_Water_Heater` varchar(10) DEFAULT '0',
  `Allow_Pets` varchar(10) DEFAULT '0',
  `Allow_Smoking` varchar(10) DEFAULT '0',
  `Is_Available` tinyint(4) DEFAULT '1',
  `Images` varchar(1000) DEFAULT 'Images/image (6).jpg',
  `user_id` bigint(20) DEFAULT NULL,
  `Phone` varchar(20) NOT NULL,
  PRIMARY KEY (`Post_ID`),
  KEY `post_users_User_ID_fk` (`User_Name`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`Post_ID`, `User_Name`, `Title`, `City`, `Address`, `Gender`, `Price`, `Description`, `Has_Wifi`, `Has_Water_Heater`, `Allow_Pets`, `Allow_Smoking`, `Is_Available`, `Images`, `user_id`, `Phone`) VALUES
(29, 'Oknaa', 'Chambre 2 place', 'agadir', 'N247, B1, Hay AlAmal, AitMelloul', 'Man', 1500, 'tkhrbii9', 'yes', '0', 'YES', 'no', 1, 'Images/image (1).jpeg', NULL, '0'),
(30, 'Niaa', 'Appartement aven balcon', 'Tetouan', 'N20, B2, Etage 4, Imeuble essafa, Mhannach', 'Man', 2800, 'room with 2 beds', 'yes', 'no', 'no', 'no', 1, 'Images/image (2).jpg', NULL, '0'),
(33, 'Yassin', 'Ahsan dar fl3alam', 'hna', 'flhoma', 'Man', 10000, 'Naaaadi', 'yes', '0', 'no', 'yes', 1, 'Images/image (3).jpg', NULL, '0'),
(34, 'Oknaa@kun.me', 'Medine House', 'Essaouira', 'N34, Hai Alja3far, Elmedina', 'Woman', 2300, 'Old renovated house in elmedina of Essaouira', 'yes', '0', 'yes', 'no', 1, 'Images/image (4).jpg', NULL, '0608384477'),
(35, 'yass@in', 'dar', 'tangier', 'tmma', 'Woman', 100000, 'waaa3ra', 'yes', '0', 'yes', 'no', 1, 'Images/image (5).jpeg', NULL, '06'),
(50, 'yass@in', 'Farm House', 'Agadir', 'N34, Hai Alja3far, Elmedina', 'Man', 1900, 'A very cool old farm house next to the Ezzar9a river ...', 'yes', '0', 'yes', 'yes', 1, NULL, NULL, '0988227733');

-- --------------------------------------------------------

--
-- Table structure for table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `spring_session`
--

INSERT INTO `spring_session` (`PRIMARY_ID`, `SESSION_ID`, `CREATION_TIME`, `LAST_ACCESS_TIME`, `MAX_INACTIVE_INTERVAL`, `EXPIRY_TIME`, `PRINCIPAL_NAME`) VALUES
('bd8e1339-4232-44b9-8385-ffc874091647', 'ccb4df03-b39c-4fd4-aad8-61e303f242d5', 1637702321929, 1637706635355, 1800, 1637708435355, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `spring_session_attributes`
--

INSERT INTO `spring_session_attributes` (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_BYTES`) VALUES
('bd8e1339-4232-44b9-8385-ffc874091647', 'MY_SESSION_USERS', 0xaced00057400077961737340696e);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `User_Name` varchar(50) NOT NULL DEFAULT '',
  `Email` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Gender` enum('Male','Female') DEFAULT NULL,
  `Phone` int(11) DEFAULT NULL,
  `Is_Admin` tinyint(4) DEFAULT '0',
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`Email`),
  UNIQUE KEY `users_Email_uindex` (`Email`),
  UNIQUE KEY `users_User_Name_uindex` (`User_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_Name`, `Email`, `Password`, `Gender`, `Phone`, `Is_Admin`, `username`) VALUES
('Oknaa', 'Oknaa@kun.me', 'oknaa', 'Male', 708008065, 0, ''),
('Niaa', 'Niaa@ma.me', 'nia', 'Female', 689228833, 1, ''),
('med', 'med@a.a', 'med', 'Male', 11, 0, 'med'),
('', 'yass@in', 'yass', NULL, 92883377, 0, 'yass');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
