
package GestioneEntita;

import Entity.Fattura;
import UI.UIFattura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;


public class GestioneFattura {
 
    public int ultimoID() throws SQLException {
        
        String query = "SELECT max(ID) FROM Fattura";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next())
            return result.getInt(0);
        return 0;
    }
    
    public void aggiungiFattura(Fattura input) {
        
    }
    
    private void calcolaImporto(int index) throws ParseException, SQLException {
        
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
    }
    
    private void creaFattura() {
        
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
