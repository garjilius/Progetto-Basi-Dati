
package GestioneEntita;

import Entity.Fattura;
import Entity.Permanenza;
import UI.UIFattura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;

public class GestionePermanenza {
    
    private Vector permanenze;
 
    public Vector permanenzeInCorso() throws SQLException {
        
        String query = "SELECT * FROM Permanenza WHERE DataFine IS NULL";
        ResultSet result = new GestioneDB().readDB(query);
        
        Vector dati = new Vector();
        while(result.next()) {
            Vector riga = new Vector();
            riga.add(result.getString("CodiceFiscale"));
            riga.add(result.getInt("NumeroStanza"));
            riga.add(result.getDate("DataInizio"));
            dati.add(riga);
        }
        
        permanenze = dati;
        return dati;
    }
    
    public void aggiungiPermanenza(Permanenza input) {
        
        String query = "INSERT INTO Permanenza VALUES ('%s','%d','%s',NULL)";
        query = String.format(query, input.getCodiceFiscale(), input.getNumeroStanza(),
                input.getDataInizio());
        
        new GestioneDB().updateDB(query);
    }
    
    public void terminaPermanenza(int index) {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataFine = format.format(new GregorianCalendar().getTime());
        
    }
    
    
}
