SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


DROP TABLE IF EXISTS `pc`;
CREATE TABLE IF NOT EXISTS `pc` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `M_Board` int(10) NOT NULL,
  `CPU` int(10) NOT NULL,
  `RAM` int(10) NOT NULL,
  `GPU` int(10) NOT NULL,
  `HDD` int(10) NOT NULL,
  `Cooler` int(10) NOT NULL,
  `Case` int(10) NOT NULL,
  `Monitor` int(10) NOT NULL,
  `Keyboard` int(10) NOT NULL,
  `Mouse` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  UNIQUE KEY `ID_2` (`ID`),
  UNIQUE KEY `ID_3` (`ID`),
  UNIQUE KEY `ID_4` (`ID`),
  KEY `ID_5` (`ID`),
  KEY `ID_6` (`ID`),
  KEY `M_Board` (`M_Board`),
  KEY `M_Board_2` (`M_Board`),
  KEY `CPU` (`CPU`),
  KEY `CPU_2` (`CPU`),
  KEY `RAM` (`RAM`),
  KEY `Mouse` (`Mouse`),
  KEY `Mouse_2` (`Mouse`),
  KEY `Keyboard` (`Keyboard`),
  KEY `Monitor` (`Monitor`),
  KEY `Case` (`Case`),
  KEY `HDD` (`HDD`),
  KEY `GPU` (`GPU`),
  KEY `Cooler` (`Cooler`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


ALTER TABLE `pc`
  ADD CONSTRAINT `pc_ibfk_11` FOREIGN KEY (`Cooler`) REFERENCES `cooler` (`ID`),
  ADD CONSTRAINT `pc_ibfk_10` FOREIGN KEY (`Mouse`) REFERENCES `mouse` (`ID`),
  ADD CONSTRAINT `pc_ibfk_2` FOREIGN KEY (`M_Board`) REFERENCES `mb` (`ID`),
  ADD CONSTRAINT `pc_ibfk_3` FOREIGN KEY (`CPU`) REFERENCES `cpu` (`ID`),
  ADD CONSTRAINT `pc_ibfk_4` FOREIGN KEY (`RAM`) REFERENCES `ram` (`ID`),
  ADD CONSTRAINT `pc_ibfk_5` FOREIGN KEY (`GPU`) REFERENCES `gpu` (`ID`),
  ADD CONSTRAINT `pc_ibfk_6` FOREIGN KEY (`HDD`) REFERENCES `hdd` (`ID`),
  ADD CONSTRAINT `pc_ibfk_7` FOREIGN KEY (`Case`) REFERENCES `case` (`ID`),
  ADD CONSTRAINT `pc_ibfk_8` FOREIGN KEY (`Monitor`) REFERENCES `monitor` (`ID`),
  ADD CONSTRAINT `pc_ibfk_9` FOREIGN KEY (`Keyboard`) REFERENCES `keybord` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
