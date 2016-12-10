CREATE TABLE Anagrafica(
	CodiceFiscale VARCHAR(16) PRIMARY KEY,
	Nome VARCHAR(30) NOT NULL,
	Cognome VARCHAR(30) NOT NULL,
	DataDiNascita DATE NOT NULL,
	NumeroDocumento VARCHAR(20) NOT NULL,
	Tipo SMALLINT NOT NULL
);

CREATE TABLE Dipendente(
	CodiceFiscale VARCHAR(16) NOT NULL,
	Stipendio INT NOT NULL,
	DataAssunzione DATE NOT NULL,
	Mansione VARCHAR(30) NOT NULL,
	FOREIGN KEY (CodiceFiscale)
		REFERENCES Anagrafica(CodiceFiscale)
);

CREATE TABLE Stanza(
	Numero INT PRIMARY KEY,
	Tipologia SMALLINT NOT NULL,
	CostoGiornaliero INT NOT NULL
);

CREATE TABLE Permanenza(
	CodiceFiscale VARCHAR(16) NOT NULL,
	NumeroStanza INT NOT NULL,
	DataInizio DATE NOT NULL,
	DataFine DATE,
	FOREIGN KEY (CodiceFiscale) REFERENCES Anagrafica(CodiceFiscale),
	FOREIGN KEY (NumeroStanza) REFERENCES Stanza(Numero)
);

CREATE TABLE DittaEsterna(
	PIVA VARCHAR(255) PRIMARY KEY,
	Nome VARCHAR(50) NOT NULL,
	Sede VARCHAR(255) NOT NULL,
	Recapito VARCHAR(255) NOT NULL
);

CREATE TABLE Task(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Operazione VARCHAR(255) NOT NULL,
	NumeroStanza INT NOT NULL,
	PIVA VARCHAR(255),
	CodiceFiscale VARCHAR(16),
	Costo INT,
	DataInizio DATE NOT NULL,
	DataFine DATE,
	FOREIGN KEY (NumeroStanza) REFERENCES Stanza(Numero),
	FOREIGN KEY (PIVA) REFERENCES DittaEsterna(PIVA),
	FOREIGN KEY (CodiceFiscale) REFERENCES Anagrafica(CodiceFiscale)
);

CREATE TABLE Fattura(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Causale VARCHAR(255) NOT NULL,
	Importo INT NOT NULL,
	Data DATE NOT NULL,
	PIVA VARCHAR(255),
	CodiceFiscale VARCHAR(16),
	NumeroStanza INT,
	FOREIGN KEY (PIVA) REFERENCES DittaEsterna(PIVA),
	FOREIGN KEY (CodiceFiscale) REFERENCES Anagrafica(CodiceFiscale),
	FOREIGN KEY (NumeroStanza) REFERENCES Stanza(Numero)
);
	
