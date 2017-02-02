
package Test;

import GestioneEntita.GestioneDB;


public class TestUpdate {
    
    public void start() {
        
        GestioneDB gestore = new GestioneDB();
        
        System.out.println("TEST: Aggiornamento di alcune tabelle.\n");
        
        System.out.println("Modifica dello stipendio di un dipendente.\n");
        String query = "UPDATE Dipendente SET Stipendio = '1500' "
                + "WHERE CodiceFiscale = 'CodiceFiscale2'";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        System.out.println("Fine di una permanenza.\n");
        query = "UPDATE Permanenza SET DataFine = '2017-02-02' "
                + "WHERE CodiceFiscale = 'CodiceFiscale1' AND "
                + "NumeroStanza = 1 AND DataFine IS NULL"
                + "AND DataInizio = '2016-12-30'";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        System.out.println("Fine di un task ordinario.\n");
        query = "UPDATE Task SET DataFine = CURRENT_DATE() "
                + "WHERE CodiceFiscale = 'CodiceFiscale2' AND "
                + "NumeroStanza = 1 AND DataFine IS NULL AND DataInizio = CURRENT_DATE()";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        System.out.println("Fine di un task straordinario.\n");
        query = "UPDATE Task SET DataFine = CURRENT_DATE(), Costo = '1500' "
                + "WHERE PIVA = 'PartitaIVA1' AND "
                + "NumeroStanza = 1 AND DataFine IS NULL";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
    }
}
