-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Feb 02, 2017 alle 17:30
-- Versione del server: 10.1.19-MariaDB
-- Versione PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `roomanager`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Anagrafica`
--

CREATE TABLE `Anagrafica` (
  `CodiceFiscale` varchar(16) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Cognome` varchar(30) NOT NULL,
  `DataNascita` date NOT NULL,
  `NumeroDocumento` varchar(20) NOT NULL,
  `Tipo` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Anagrafica`
--

INSERT INTO `Anagrafica` (`CodiceFiscale`, `Nome`, `Cognome`, `DataNascita`, `NumeroDocumento`, `Tipo`) VALUES
('CodiceFiscale1', 'Nome1', 'Cognome1', '1993-02-27', 'Ndoc1', 1),
('CodiceFiscale2', 'Nome2', 'Cognome2', '1994-02-25', 'Ndoc2', 2),
('CodiceFiscale3', 'Nome3', 'Cognome3', '1992-02-20', 'Ndoc3', 2),
('CodiceFiscale4', 'Nome4', 'Cognome4', '1990-03-22', 'Ndoc4', 1),
('CodiceFiscale5', 'Nome5', 'Cognome5', '1991-06-29', 'Ndoc5', 1),
('GIZZO92BLABLA', 'Giandomenico', 'Izzo', '1992-03-10', 'GIIZZO92CID', 1),
('GRGMNL94CF839T', 'Emanuele', 'Gargiulo', '1994-03-22', 'CIDEG1', 1),
('PCRMBR93L993D', 'Umberto', 'Picariello', '1993-10-10', 'CIDUMBY93', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `Dipendente`
--

CREATE TABLE `Dipendente` (
  `CodiceFiscale` varchar(16) NOT NULL,
  `Stipendio` int(11) NOT NULL,
  `DataAssunzione` date NOT NULL,
  `Mansione` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Dipendente`
--

INSERT INTO `Dipendente` (`CodiceFiscale`, `Stipendio`, `DataAssunzione`, `Mansione`) VALUES
('CodiceFiscale2', 1300, '2000-01-10', 'Pulizie'),
('CodiceFiscale3', 1600, '2000-03-15', 'Cameriere'),
('PCRMBR93L993D', 1700, '2017-02-02', 'Servizio in camera');

-- --------------------------------------------------------

--
-- Struttura della tabella `DittaEsterna`
--

CREATE TABLE `DittaEsterna` (
  `PIVA` varchar(255) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Sede` varchar(255) NOT NULL,
  `Recapito` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `DittaEsterna`
--

INSERT INTO `DittaEsterna` (`PIVA`, `Nome`, `Sede`, `Recapito`) VALUES
('PartitaIVA1', 'NomeDitta1', 'SedeDitta1', 'RecapitoDitta1'),
('PartitaIVA2', 'NomeDitta2', 'SedeDitta2', 'RecapitoDitta2'),
('PartitaIVA3', 'NomeDitta3', 'SedeDitta3', 'RecapitoDitta3'),
('PartitaIva4', 'Bloise Idraulica', 'CS', '03333344929');

-- --------------------------------------------------------

--
-- Struttura della tabella `Fattura`
--

CREATE TABLE `Fattura` (
  `ID` int(11) NOT NULL,
  `Causale` varchar(255) NOT NULL,
  `Importo` int(11) NOT NULL,
  `Data` date NOT NULL,
  `DataInizio` date NOT NULL,
  `CodiceFiscale` varchar(16) NOT NULL,
  `NumeroStanza` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Fattura`
--

INSERT INTO `Fattura` (`ID`, `Causale`, `Importo`, `Data`, `DataInizio`, `CodiceFiscale`, `NumeroStanza`) VALUES
(1, 'Permanenza', 100, '2016-12-05', '2016-12-01', 'CodiceFiscale1', 1),
(2, 'Permanenza', 160, '2016-12-25', '2016-12-21', 'CodiceFiscale1', 2),
(3, 'Permanenza', 240, '2016-12-15', '2016-12-11', 'CodiceFiscale4', 3),
(4, 'Permanenza', 20, '2016-12-19', '2016-12-18', 'CodiceFiscale5', 1),
(5, 'Permanenza di GRGMNL94CF839T\ndal giorno 2017-02-02\nal giorno 2017-02-02\nnella stanza 2', 40, '2017-02-02', '2017-02-02', 'GRGMNL94CF839T', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `Permanenza`
--

CREATE TABLE `Permanenza` (
  `CodiceFiscale` varchar(16) NOT NULL,
  `NumeroStanza` int(11) NOT NULL,
  `DataInizio` date NOT NULL,
  `DataFine` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Permanenza`
--

INSERT INTO `Permanenza` (`CodiceFiscale`, `NumeroStanza`, `DataInizio`, `DataFine`) VALUES
('CodiceFiscale1', 1, '2016-12-01', '2016-12-05'),
('CodiceFiscale4', 2, '2016-12-01', NULL),
('CodiceFiscale4', 3, '2016-12-11', '2016-12-15'),
('CodiceFiscale3', 3, '2016-12-14', NULL),
('CodiceFiscale5', 1, '2016-12-18', '2016-12-19'),
('CodiceFiscale1', 2, '2016-12-21', '2016-12-25'),
('CodiceFiscale1', 1, '2016-12-30', NULL),
('GIZZO92BLABLA', 4, '2017-02-02', NULL),
('GRGMNL94CF839T', 2, '2017-02-02', '2017-02-02');

-- --------------------------------------------------------

--
-- Struttura della tabella `Stanza`
--

CREATE TABLE `Stanza` (
  `Numero` int(11) NOT NULL,
  `Tipologia` smallint(6) NOT NULL,
  `CostoGiornaliero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Stanza`
--

INSERT INTO `Stanza` (`Numero`, `Tipologia`, `CostoGiornaliero`) VALUES
(1, 1, 20),
(2, 2, 40),
(3, 3, 60),
(4, 4, 80);

-- --------------------------------------------------------

--
-- Struttura della tabella `Task`
--

CREATE TABLE `Task` (
  `ID` int(11) NOT NULL,
  `Tipo` int(11) NOT NULL,
  `Operazione` varchar(255) NOT NULL,
  `NumeroStanza` int(11) NOT NULL,
  `PIVA` varchar(255) DEFAULT NULL,
  `CodiceFiscale` varchar(16) DEFAULT NULL,
  `Costo` int(11) DEFAULT NULL,
  `DataInizio` date NOT NULL,
  `DataFine` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Task`
--

INSERT INTO `Task` (`ID`, `Tipo`, `Operazione`, `NumeroStanza`, `PIVA`, `CodiceFiscale`, `Costo`, `DataInizio`, `DataFine`) VALUES
(1, 1, 'Cambiare Bucato', 1, NULL, 'CodiceFiscale2', NULL, '2016-12-05', NULL),
(2, 1, 'Cambiare Tende', 3, NULL, 'CodiceFiscale2', NULL, '2016-12-11', NULL),
(3, 1, 'Pulizia Camera', 1, NULL, 'CodiceFiscale2', NULL, '2016-12-06', '2016-12-06'),
(4, 1, 'Pulizia Bagno', 2, NULL, 'CodiceFiscale2', NULL, '2016-12-07', '2016-12-07'),
(5, 1, 'Pranzo in camera', 2, NULL, 'CodiceFiscale3', NULL, '2017-02-02', '2017-02-02'),
(6, 2, 'Cambiare Tubi', 1, 'PartitaIVA1', NULL, 8420, '2016-12-05', '2017-02-02'),
(7, 2, 'Cambiare Acquario', 2, 'PartitaIVA1', NULL, NULL, '2016-12-07', NULL),
(8, 2, 'Cambiare Pavimento', 1, 'PartitaIVA1', NULL, 500, '2016-12-05', '2016-12-08'),
(9, 2, 'Cambiare Moquette', 2, 'PartitaIVA1', NULL, 600, '2016-11-03', '2016-12-09'),
(10, 2, 'Cambiare Imposte', 3, 'PartitaIVA1', NULL, 700, '2016-10-01', '2016-10-15'),
(11, 1, 'Pulizia Tende', 3, NULL, 'CodiceFiscale3', NULL, '2017-02-02', '2017-02-02'),
(12, 2, 'Sostituzione Moquette', 4, 'PartitaIVA2', NULL, NULL, '2017-02-02', NULL);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Anagrafica`
--
ALTER TABLE `Anagrafica`
  ADD PRIMARY KEY (`CodiceFiscale`);

--
-- Indici per le tabelle `Dipendente`
--
ALTER TABLE `Dipendente`
  ADD UNIQUE KEY `CodiceFiscale` (`CodiceFiscale`);

--
-- Indici per le tabelle `DittaEsterna`
--
ALTER TABLE `DittaEsterna`
  ADD PRIMARY KEY (`PIVA`);

--
-- Indici per le tabelle `Fattura`
--
ALTER TABLE `Fattura`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CodiceFiscale` (`CodiceFiscale`),
  ADD KEY `NumeroStanza` (`NumeroStanza`),
  ADD KEY `DataInizio` (`DataInizio`);

--
-- Indici per le tabelle `Permanenza`
--
ALTER TABLE `Permanenza`
  ADD UNIQUE KEY `DataInizio` (`DataInizio`,`CodiceFiscale`,`NumeroStanza`),
  ADD KEY `CodiceFiscale` (`CodiceFiscale`),
  ADD KEY `NumeroStanza` (`NumeroStanza`);

--
-- Indici per le tabelle `Stanza`
--
ALTER TABLE `Stanza`
  ADD PRIMARY KEY (`Numero`);

--
-- Indici per le tabelle `Task`
--
ALTER TABLE `Task`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `NumeroStanza` (`NumeroStanza`),
  ADD KEY `PIVA` (`PIVA`),
  ADD KEY `CodiceFiscale` (`CodiceFiscale`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Fattura`
--
ALTER TABLE `Fattura`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `Task`
--
ALTER TABLE `Task`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Dipendente`
--
ALTER TABLE `Dipendente`
  ADD CONSTRAINT `dipendente_ibfk_1` FOREIGN KEY (`CodiceFiscale`) REFERENCES `Anagrafica` (`CodiceFiscale`) ON UPDATE CASCADE;

--
-- Limiti per la tabella `Fattura`
--
ALTER TABLE `Fattura`
  ADD CONSTRAINT `fattura_ibfk_1` FOREIGN KEY (`CodiceFiscale`) REFERENCES `Permanenza` (`CodiceFiscale`),
  ADD CONSTRAINT `fattura_ibfk_2` FOREIGN KEY (`NumeroStanza`) REFERENCES `Permanenza` (`NumeroStanza`),
  ADD CONSTRAINT `fattura_ibfk_3` FOREIGN KEY (`DataInizio`) REFERENCES `Permanenza` (`DataInizio`);

--
-- Limiti per la tabella `Permanenza`
--
ALTER TABLE `Permanenza`
  ADD CONSTRAINT `permanenza_ibfk_1` FOREIGN KEY (`CodiceFiscale`) REFERENCES `Anagrafica` (`CodiceFiscale`),
  ADD CONSTRAINT `permanenza_ibfk_2` FOREIGN KEY (`NumeroStanza`) REFERENCES `Stanza` (`Numero`);

--
-- Limiti per la tabella `Task`
--
ALTER TABLE `Task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`NumeroStanza`) REFERENCES `Stanza` (`Numero`),
  ADD CONSTRAINT `task_ibfk_2` FOREIGN KEY (`PIVA`) REFERENCES `DittaEsterna` (`PIVA`),
  ADD CONSTRAINT `task_ibfk_3` FOREIGN KEY (`CodiceFiscale`) REFERENCES `Dipendente` (`CodiceFiscale`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
