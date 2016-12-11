USE roomanager;

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


INSERT INTO Task VALUES(NULL,"Cambiare Bucato",1,NULL,"CodiceFiscale2",NULL,"2016-12-05",NULL);

INSERT INTO Task VALUES(NULL,"Cambiare Tende",3,NULL,"CodiceFiscale2",NULL,"2016-12-11",NULL);

INSERT INTO Task VALUES(NULL,"Pulizia Camera",1,NULL,"CodiceFiscale2",NULL,"2016-12-06","2016-12-06");

INSERT INTO Task VALUES(NULL,"Pulizia Bagno",2,NULL,"CodiceFiscale2",NULL,"2016-12-07","2016-12-07");

INSERT INTO Task VALUES(NULL,"Cambiare Tubi",1,"PartitaIVA1",NULL,NULL,"2016-12-05",NULL);

INSERT INTO Task VALUES(NULL,"Cambiare Acquario",2,"PartitaIVA1",NULL,NULL,"2016-12-07",NULL);

INSERT INTO Task VALUES(NULL,"Cambiare Pavimento",1,"PartitaIVA1",NULL,500,"2016-12-05","2016-12-08");

INSERT INTO Task VALUES(NULL,"Cambiare Moquette",2,"PartitaIVA1",NULL,600,"2016-11-03","2016-12-09");

INSERT INTO Task VALUES(NULL,"Cambiare Imposte",3,"PartitaIVA1",NULL,700,"2016-10-01","2016-10-15");


INSERT INTO Fattura VALUES(NULL,"Permanenza",100,"2016-12-05",NULL,"CodiceFiscale1",1);

INSERT INTO Fattura VALUES(NULL,"Permanenza",160,"2016-12-25",NULL,"CodiceFiscale1",2);

INSERT INTO Fattura VALUES(NULL,"Permanenza",240,"2016-12-15",NULL,"CodiceFiscale4",3);

INSERT INTO Fattura VALUES(NULL,"Permanenza",20,"2016-12-19",NULL,"CodiceFiscale5",1);

INSERT INTO Fattura VALUES(NULL,"Cambiare Pavimento",500,"2016-12-08","PartitaIVA1",NULL,1);

INSERT INTO Fattura VALUES(NULL,"Cambiare Moquette",600,"2016-12-09","PartitaIVA1",NULL,2);

INSERT INTO Fattura VALUES(NULL,"Cambiare Imposte",700,"2016-12-15","PartitaIVA1",NULL,3);



