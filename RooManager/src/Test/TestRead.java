
package Test;

import GestioneEntita.GestioneDB;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestRead {
    
    public void start() throws SQLException {
        
        GestioneDB gestore = new GestioneDB();
        
        System.out.println("TEST: Lettura delle righe di ogni tabella.\n");
        
        String query = "SELECT * FROM Anagrafica";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 6));
        
        query = "SELECT * FROM Anagrafica JOIN Dipendente ON Anagrafica.CodiceFiscale = Dipendente.CodiceFiscale";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 9));
        
        query = "SELECT * FROM Stanza";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 3));
        
        query = "SELECT * FROM Permanenza WHERE DataFine IS NOT NULL";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 4));
        
        query = "SELECT Nome, Cognome, Permanenza.CodiceFiscale, "
                + "Permanenza.NumeroStanza, Permanenza.DataInizio, "
                  + "Permanenza.DataFine FROM Anagrafica JOIN Permanenza "
                + "ON Anagrafica.CodiceFiscale = Permanenza.CodiceFiscale"
                + " WHERE DataFine IS NOT NULL";
         System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 6));
        
        query = "SELECT * FROM DittaEsterna";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 4));       
                
        query = "SELECT * FROM DittaEsterna where DittaEsterna.PIVA IN (Select PIVA from Task)";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 4));
        
        query = "SELECT * FROM Task ORDER BY ID";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 9));
        
        query = "SELECT * FROM Task WHERE DataFine is NULL ORDER BY ID ";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 9));
        
        query = "SELECT * FROM Fattura";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 7));
        
        query = "SELECT COUNT(*) from Task where DataFine BETWEEN (CURRENT_DATE - INTERVAL 1 WEEK) and CURRENT_DATE() and CodiceFiscale = 'CodiceFiscale2'";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 1));
        
        query = "SELECT AVG(Stipendio) FROM Dipendente";
        System.out.println("QUERY: " + query + "\n");
        System.out.println(readResultSet(gestore.readDB(query), 1));  
    }
    
    private static String readResultSet(ResultSet input, int nCol) throws SQLException {
        
        String toReturn = "";
        
        while(input.next()) {
            
            for(int i=1; i<=nCol; i++) {
                toReturn = toReturn + input.getObject(i) + " ";
            }
            toReturn = toReturn + "\n";
        }
        
        return toReturn;
    }
}
