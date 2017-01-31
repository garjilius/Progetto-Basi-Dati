
package Test;

import GestioneEntita.GestioneDB;

public class TestInsert {

    public void start() {

        GestioneDB gestore = new GestioneDB();

        System.out.println("TEST: Inserimento di una riga per ogni tabella.\n");

        // ANAGRAFICA
        String query = "INSERT INTO Anagrafica VALUES('CodiceFiscale1','Nome1','Cognome1','1993-02-27','Ndoc1',1)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);

        query = "INSERT INTO Anagrafica VALUES('CodiceFiscale2','Nome2','Cognome2','1993-02-27','Ndoc2',2)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);

        // DIPENDENTE
        query = "INSERT INTO Dipendente VALUES ('CodiceFiscale2',1300,'2000-01-10','Pulizie')";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);

        // STANZA
        query = "INSERT INTO Stanza VALUES(1,1,20)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);

        // PERMANENZA
        query = "INSERT INTO Permanenza VALUES('CodiceFiscale1',1,'2016-12-01',NULL)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        query = "INSERT INTO Permanenza VALUES('CodiceFiscale1',1,'2016-12-01','2016-12-05')";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);

        // DITTA ESTERNA
        query = "INSERT INTO DittaEsterna VALUES('PartitaIVA1','NomeDitta1','SedeDitta1','RecapitoDitta1')";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);

        // TASK
        query = "INSERT INTO Task VALUES(NULL,1,'Cambiare Bucato',1,NULL,'CodiceFiscale2',NULL,'2016-12-05',NULL)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        query = "INSERT INTO Task VALUES(NULL,1,'Cambiare Cuscini',1,NULL,'CodiceFiscale2',NULL,CURRENT_DATE(),NULL)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        query = "INSERT INTO Task VALUES(NULL,2,'Cambiare Tubi',1,'PartitaIVA1',NULL,NULL,'2016-12-05',NULL)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        // FATTURA
        query = "INSERT INTO Fattura VALUES(NULL,'Permanenza',100,'2016-12-05','CodiceFiscale1',1)";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
    }
}
