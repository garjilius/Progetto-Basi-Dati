
package GestioneEntita;

import Entity.Fattura;
import MainTest.UIFattura;
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
    
    public void terminaPermanenza(int index) throws SQLException, ParseException{
        
        Vector selezionata = (Vector) permanenze.get(index);

        // CALCOLO GIORNI DI PERMANENZA
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataInizio = (String) selezionata.get(2).toString();
        String dataFine = format.format(new GregorianCalendar().getTime());
        long millisDiff = format.parse(dataFine).getTime() - format.parse(dataInizio).getTime();
        int giorni = (int) (millisDiff / 86400000);

        // CALCOLO IMPORTO
        String query = "SELECT CostoGiornaliero FROM Stanza JOIN Permanenza "
                + "ON CodiceFiscale = '%s' "
                + "AND DataFine IS NULL WHERE Numero=Permanenza.NumeroStanza";
        query = String.format(query, selezionata.get(0));
        ResultSet result = new GestioneDB().readDB(query);
        int costo = 0;
        while(result.next()) {
            costo = result.getInt("CostoGiornaliero");
        }
        System.out.println("Giorni trascorsi: "+ giorni 
                + ". Costo giornaliero: " + costo);
        
        
        // CREAZIONE FATTURA
        Fattura fattura = new Fattura();
        fattura.setID(101);
        fattura.setData(dataFine);
        fattura.setImporto(558.78);
        fattura.setCf((String) selezionata.get(0));
        fattura.setStanza((Integer) selezionata.get(1));
        
        String causale = "Permanenza di " + fattura.getCf() + "\n"
                + "dal giorno " + selezionata.get(2) + " al giorno " + dataFine + "\n"
                + "nella stanza " + fattura.getStanza();
        fattura.setCausale(causale);
        
        new UIFattura(null, true, true, fattura).setVisible(true);
    }
    
}
