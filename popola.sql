INSERT INTO Anagrafica VALUES("CodiceFiscale1","Nome1","Cognome1","1993-02-27","Ndoc1",1);

INSERT INTO Anagrafica VALUES("CodiceFiscale2","Nome2","Cognome2","1993-02-25","Ndoc2",2);

INSERT INTO Anagrafica VALUES("CodiceFiscale3","Nome3","Cognome3","1993-02-20","Ndoc3",2);

INSERT INTO Dipendente VALUES ("CodiceFiscale2",1300,"2000-01-10","Pulizie");

INSERT INTO Dipendente VALUES("CodiceFiscale3",1300,"2000-01-10","Cameriere");

INSERT INTO Stanza VALUES(1,1,20);

INSERT INTO Stanza VALUES(2,2,40);

INSERT INTO Stanza VALUES(3,3,60);

INSERT INTO Stanza VALUES(4,4,80);

INSERT INTO Permanenza VALUES("CodiceFiscale1",1,"2016-12-01",NULL);

INSERT INTO Permanenza VALUES("CodiceFiscale1",1,"2016-12-01","2016-12-05");

INSERT INTO DittaEsterna VALUES("PartitaIVA1","NomeDitta1","SedeDitta1","RecapitoDitta1");

INSERT INTO DittaEsterna VALUES("PartitaIVA2","NomeDitta2","SedeDitta2","RecapitoDitta2");

INSERT INTO DittaEsterna VALUES("PartitaIVA3","NomeDitta3","SedeDitta3","RecapitoDitta3");

INSERT INTO Task VALUES(NULL,"Quotidiano",1,NULL,"CodiceFiscale2",NULL,"2016-12-05",NULL);

INSERT INTO Task VALUES(NULL,"Quotidiano",1,NULL,"CodiceFiscale2",NULL,"2016-12-05","2016-12-06");

INSERT INTO Task VALUES(NULL,"Straordinario",1,"PartitaIVA1",NULL,NULL,"2016-12-05",NULL);

INSERT INTO Task VALUES(NULL,"Straordinario",1,"PartitaIVA1",NULL,500,"2016-12-05","2016-12-08");

INSERT INTO Fattura VALUES(NULL,"Permanenza",100,"2016-12-05",NULL,"CodiceFiscale1",1);

INSERT INTO Fattura VALUES(NULL,"Straordinaria",500,"2016-12-05","PartitaIVA1",NULL,NULL);
