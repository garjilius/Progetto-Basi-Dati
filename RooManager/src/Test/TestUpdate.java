
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
        query = "UPDATE Permanenza SET DataFine = '2017-01-12' "
                + "WHERE CodiceFiscale = 'CodiceFiscale1' AND "
                + "NumeroStanza = 1 AND DataFine IS NULL";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        System.out.println("Fine di un task ordinario.\n");
        query = "UPDATE Task SET DataFine = '2017-01-12' "
                + "WHERE CodiceFiscale = 'CodiceFiscale2' AND "
                + "NumeroStanza = 1 AND DataFine IS NULL";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
        
        System.out.println("Fine di un task straordinario.\n");
        query = "UPDATE Task SET DataFine = '2017-01-12', Costo = '500' "
                + "WHERE PIVA = 'PartitaIVA1' AND "
                + "NumeroStanza = 1 AND DataFine IS NULL";
        System.out.println("QUERY: " + query + "\n");
        gestore.updateDB(query);
    }
}
