
package GestioneEntita;

import Entity.Fattura;
import Entity.Permanenza;
import UI.JDialogFattura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;


public class GestioneFattura {
    
    public void aggiungiFatturaPermanenza(Permanenza input) throws ParseException, SQLException {
        
        Fattura fattura = new Fattura();
        fattura.setID(ultimoID());
        fattura.setData(input.getDataFine());
        fattura.setImporto(558.78);
        fattura.setCf(input.getCodiceFiscale());
        fattura.setStanza(input.getNumeroStanza());
        fattura.setImporto(calcolaImporto(input));
        
        System.out.println(calcolaImporto(input));
        
        String causale = "Permanenza di " + fattura.getCf() + "\n"
                + "dal giorno " + input.getDataInizio() + " al giorno " + 
                input.getDataFine() + "\n"
                + "nella stanza " + input.getNumeroStanza();
        fattura.setCausale(causale);
        
        new JDialogFattura(null, true, true, fattura).setVisible(true);
    }
    
    public Vector leggiFatture() throws SQLException {
        
        String query = "SELECT ID,Data,Importo,Causale FROM Fattura";
        ResultSet result = new GestioneDB().readDB(query);
        Vector toReturn = new Vector();
        Vector causali = new Vector();
        Vector visualizza = new Vector();
        
        while(result.next()) {
            
            Vector riga = new Vector();
            riga.add(result.getInt("ID"));
            riga.add(result.getString("Data"));
            riga.add(result.getString("Importo"));
            riga.add("Clicca per visualizzare");
            causali.add(result.getString("Causale"));
            visualizza.add(riga);
        }
        
        toReturn.add(visualizza);
        toReturn.add(causali);
        
        return toReturn; 
        
    }
    
    
    private int ultimoID() throws SQLException {
        
        String query = "SELECT max(ID) FROM Fattura";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next())
            return result.getInt(1) + 1;
        return 0;
    }
    
    private double calcolaImporto(Permanenza input) throws ParseException, SQLException {

        // CALCOLO GIORNI DI PERMANENZA
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataInizio = input.getDataInizio();
        String dataFine = format.format(new GregorianCalendar().getTime());
        long millisDiff = format.parse(dataFine).getTime() - format.parse(dataInizio).getTime();
        int giorni = (int) (millisDiff / 86400000);

        // CALCOLO IMPORTO
        String query = "SELECT CostoGiornaliero FROM Stanza JOIN Permanenza "
                + "ON CodiceFiscale = '%s' "
                + "AND DataFine IS NULL WHERE Numero=Permanenza.NumeroStanza";
        query = String.format(query, input.getCodiceFiscale());
        ResultSet result = new GestioneDB().readDB(query);
        int costo = 0;
        while(result.next()) {
            costo = result.getInt("CostoGiornaliero");
        }

        if(giorni == 0)
            return costo;
        else
            return (giorni+1) * costo; 
    }

}
