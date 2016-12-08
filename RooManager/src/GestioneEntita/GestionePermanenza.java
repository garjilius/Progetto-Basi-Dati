
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
    
    private Vector<Permanenza> permanenze;
 
    public Vector permanenzeInCorso() throws SQLException {
        
        permanenze = new Vector<Permanenza>();
        
        String query = "SELECT * FROM Permanenza WHERE DataFine IS NULL";
        ResultSet result = new GestioneDB().readDB(query);
        
        Vector dati = new Vector();
        while(result.next()) {
            Permanenza temp = new Permanenza();
            temp.setCodiceFiscale(result.getString("CodiceFiscale"));
            temp.setNumeroStanza(result.getInt("NumeroStanza"));
            temp.setDataInizio(result.getString("DataInizio"));
            permanenze.add(temp);
            
            Vector riga = new Vector();
            riga.add(result.getString("CodiceFiscale"));
            riga.add(result.getInt("NumeroStanza"));
            riga.add(result.getString("DataInizio"));
            dati.add(riga);
        }
        
        return dati;
    }
    
    public void aggiungiPermanenza(Permanenza input) {
        
        String query = "INSERT INTO Permanenza VALUES ('%s','%d','%s',NULL)";
        query = String.format(query, input.getCodiceFiscale(), input.getNumeroStanza(),
                input.getDataInizio());
        
        new GestioneDB().updateDB(query);
    }
    
    public void terminaPermanenza(int index) throws ParseException, SQLException {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataFine = format.format(new GregorianCalendar().getTime());
        permanenze.get(index).setDataFine(dataFine);
        
        String query = "UPDATE Permanenza SET DataFine='%s' WHERE CodiceFiscale='%s' "
                + "AND DataFine IS NULL";
        query = String.format(query, dataFine, permanenze.get(index).getCodiceFiscale());
        
        //new GestioneDB().updateDB(query)
        new GestioneFattura().aggiungiFatturaPermanenza(permanenze.get(index));
    }
    
    
}