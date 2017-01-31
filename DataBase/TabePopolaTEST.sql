USE roomanager;

CREATE TABLE Anagrafica(
	CodiceFiscale VARCHAR(16) PRIMARY KEY,
	Nome VARCHAR(30) NOT NULL,
	Cognome VARCHAR(30) NOT NULL,
	DataNascita DATE NOT NULL,
	NumeroDocumento VARCHAR(20) NOT NULL,
	Tipo SMALLINT NOT NULL
);

CREATE TABLE Dipendente(
	CodiceFiscale VARCHAR(16) NOT NULL,
	Stipendio INT NOT NULL DEFAULT 1000,
	DataAssunzione DATE NOT NULL,
	Mansione VARCHAR(30) NOT NULL,
	FOREIGN KEY (CodiceFiscale) REFERENCES Anagrafica(CodiceFiscale)
	on update cascade on delete restrict
);

CREATE TABLE Stanza(
	Numero INT PRIMARY KEY,
	Tipologia SMALLINT NOT NULL,
	CostoGiornaliero INT NOT NULL);

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
	Tipo INT NOT NULL
	Operazione VARCHAR(255) NOT NULL,
	NumeroStanza INT NOT NULL,
	PIVA VARCHAR(255),
	CodiceFiscale VARCHAR(16),
	Costo INT,
	DataInizio DATE NOT NULL,
	DataFine DATE,
	FOREIGN KEY (NumeroStanza) REFERENCES Stanza(Numero),
	FOREIGN KEY (PIVA) REFERENCES DittaEsterna(PIVA),
	FOREIGN KEY (CodiceFiscale) REFERENCES Dipendente(CodiceFiscale)
);

CREATE TABLE Fattura(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Causale VARCHAR(255) NOT NULL,
	Importo INT NOT NULL,
	Data DATE NOT NULL,
	CodiceFiscale VARCHAR(16),
	NumeroStanza INT,
	FOREIGN KEY (CodiceFiscale) REFERENCES Permanenza(CodiceFiscale),
	FOREIGN KEY (NumeroStanza) REFERENCES Permanenza(NumeroStanza)
);
	

INSERT INTO Anagrafica VALUES("CodiceFiscale1","Nome1","Cognome1","1993-02-27","Ndoc1",1);

INSERT INTO Anagrafica VALUES("CodiceFiscale2","Nome2","Cognome2","1994-02-25","Ndoc2",2);

INSERT INTO Anagrafica VALUES("CodiceFiscale3","Nome3","Cognome3","1992-02-20","Ndoc3",2);

INSERT INTO Anagrafica VALUES("CodiceFiscale4","Nome4","Cognome4","1990-03-22","Ndoc4",1);

INSERT INTO Anagrafica VALUES("CodiceFiscale5","Nome5","Cognome5","1991-06-29","Ndoc5",1);


INSERT INTO Dipendente VALUES ("CodiceFiscale2",1300,"2000-01-10","Pulizie");

INSERT INTO Dipendente VALUES("CodiceFiscale3",1600,"2000-03-15","Cameriere");


INSERT INTO Stanza VALUES(1,1,20);

INSERT INTO Stanza VALUES(2,2,40);

INSERT INTO Stanza VALUES(3,3,60);

INSERT INTO Stanza VALUES(4,4,80);


INSERT INTO Permanenza VALUES("CodiceFiscale1",1,"2016-12-01",NULL);

INSERT INTO Permanenza VALUES("CodiceFiscale4",2,"2016-12-06",NULL);

INSERT INTO Permanenza VALUES("CodiceFiscale3",3,"2016-12-14",NULL);

INSERT INTO Permanenza VALUES("CodiceFiscale1",1,"2016-12-01","2016-12-05");

INSERT INTO Permanenza VALUES("CodiceFiscale1",2,"2016-12-21","2016-12-25");

INSERT INTO Permanenza VALUES("CodiceFiscale4",3,"2016-12-11","2016-12-15");

INSERT INTO Permanenza VALUES("CodiceFiscale5",1,"2016-12-18","2016-12-19");


INSERT INTO DittaEsterna VALUES("PartitaIVA1","NomeDitta1","SedeDitta1","RecapitoDitta1");

INSERT INTO DittaEsterna VALUES("PartitaIVA2","NomeDitta2","SedeDitta2","RecapitoDitta2");

INSERT INTO DittaEsterna VALUES("PartitaIVA3","NomeDitta3","SedeDitta3","RecapitoDitta3");


INSERT INTO Task VALUES(NULL,1,"Cambiare Bucato",1,NULL,"CodiceFiscale2",NULL,"2016-12-05",NULL);

INSERT INTO Task VALUES(NULL,1,"Cambiare Tende",3,NULL,"CodiceFiscale2",NULL,"2016-12-11",NULL);

INSERT INTO Task VALUES(NULL,1,"Pulizia Camera",1,NULL,"CodiceFiscale2",NULL,"2016-12-06","2016-12-06");

INSERT INTO Task VALUES(NULL,1,"Pulizia Bagno",2,NULL,"CodiceFiscale2",NULL,"2016-12-07","2016-12-07");

INSERT INTO Task VALUES(NULL,1,"Pranzo in camera",2,NULL,"CodiceFiscale3",NULL,CURRENT_DATE(),CURRENT_DATE());

INSERT INTO Task VALUES(NULL,2,"Cambiare Tubi",1,"PartitaIVA1",NULL,NULL,"2016-12-05",NULL);

INSERT INTO Task VALUES(NULL,2,"Cambiare Acquario",2,"PartitaIVA1",NULL,NULL,"2016-12-07",NULL);

INSERT INTO Task VALUES(NULL,2,"Cambiare Pavimento",1,"PartitaIVA1",NULL,500,"2016-12-05","2016-12-08");

INSERT INTO Task VALUES(NULL,2,"Cambiare Moquette",2,"PartitaIVA1",NULL,600,"2016-11-03","2016-12-09");

INSERT INTO Task VALUES(NULL,2,"Cambiare Imposte",3,"PartitaIVA1",NULL,700,"2016-10-01","2016-10-15");


INSERT INTO Fattura VALUES(NULL,"Permanenza",100,"2016-12-05","CodiceFiscale1",1);

INSERT INTO Fattura VALUES(NULL,"Permanenza",160,"2016-12-25","CodiceFiscale1",2);

INSERT INTO Fattura VALUES(NULL,"Permanenza",240,"2016-12-15","CodiceFiscale4",3);

INSERT INTO Fattura VALUES(NULL,"Permanenza",20,"2016-12-19","CodiceFiscale5",1);



