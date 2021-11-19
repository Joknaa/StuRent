-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 19, 2021 at 06:49 PM
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
(19);

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
CREATE TABLE IF NOT EXISTS `images` (
  `Image_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Property_ID` int(11) NOT NULL,
  `Path` varchar(255) NOT NULL,
  PRIMARY KEY (`Image_ID`),
  KEY `images_property_Property_ID_fk` (`Property_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `Post_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `Property_ID` int(11) NOT NULL,
  `Title` varchar(20) NOT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Availability` enum('Available','Unavailable') DEFAULT 'Available',
  PRIMARY KEY (`Post_ID`),
  KEY `post_users_User_ID_fk` (`User_ID`),
  KEY `post_property_Property_ID_fk` (`Property_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`Post_ID`, `User_ID`, `Property_ID`, `Title`, `Description`, `Availability`) VALUES
(1, 1, 1, 'post1', 'test', 'Available'),
(2, 1, 1, 'post2', NULL, 'Available'),
(3, 1, 1, 'post3', NULL, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
CREATE TABLE IF NOT EXISTS `property` (
  `Property_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Address` varchar(100) NOT NULL,
  `City` varchar(20) NOT NULL,
  `Max_Capacity` int(11) NOT NULL DEFAULT '0',
  `Available_Capacity` int(11) NOT NULL DEFAULT '0',
  `Price` int(11) NOT NULL,
  `Floor` int(11) DEFAULT NULL,
  PRIMARY KEY (`Property_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property`
--

INSERT INTO `property` (`Property_ID`, `Address`, `City`, `Max_Capacity`, `Available_Capacity`, `Price`, `Floor`) VALUES
(2, 'address2', 'city2', 2, 2, 2, 1),
(3, 'address2', 'city2', 2, 2, 2, 1),
(4, 'Address4', 'City4', 4, 3, 1000, 1),
(5, 'Address5', 'City5', 4, 3, 1000, 1),
(1, 'Address1', 'City1', 4, 3, 1000, 1),
(0, 'address2', 'city2', 2, 2, 2, NULL),
(15, 'address2', 'city2', 2, 2, 2, NULL),
(16, 'address22', 'city2', 2, 2, 2, NULL),
(18, 'adress4', 'city4', 44, 44, 4444, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
CREATE TABLE IF NOT EXISTS `request` (
  `Request_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Post_ID` int(11) NOT NULL,
  `Requester_ID` int(11) NOT NULL,
  `Status` enum('Waiting','Accepted','Rejected') DEFAULT 'Waiting',
  PRIMARY KEY (`Request_ID`),
  KEY `request_post_Post_ID_fk` (`Post_ID`),
  KEY `request_users_User_Name_fk` (`Requester_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`Request_ID`, `Post_ID`, `Requester_ID`, `Status`) VALUES
(1, 1, 1, 'Waiting'),
(2, 1, 1, 'Waiting'),
(3, 1, 1, 'Waiting'),
(17, 1, 1, 'Waiting');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `User_Name` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Gender` enum('Male','Female') DEFAULT NULL,
  `Phone` int(11) DEFAULT NULL,
  `Is_Admin` tinyint(4) DEFAULT '0',
  `Is_Available` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`User_Name`),
  UNIQUE KEY `users_Email_uindex` (`Email`),
  UNIQUE KEY `users_User_Name_uindex` (`User_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
