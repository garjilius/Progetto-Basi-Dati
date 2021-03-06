package GestioneEntita;

import Entity.Fattura;
import Entity.Permanenza;
import UI.Home;
import UI.JDialogFattura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestioneFattura {

    public void aggiungiFatturaPermanenza(Permanenza input) throws ParseException, SQLException {

        Fattura fattura = new Fattura();
        fattura.setData(input.getDataFine());
        fattura.setCf(input.getCodiceFiscale());
        fattura.setStanza(input.getNumeroStanza());
        fattura.setImporto(calcolaImporto(input));
        fattura.setDataInizio(input.getDataInizio());

        String causale = "Permanenza di " + fattura.getCf() + "\n"
                + "dal giorno " + input.getDataInizio() + "\n"
                + "al giorno " + input.getDataFine() + "\n"
                + "nella stanza " + input.getNumeroStanza();
        fattura.setCausale(causale);

        aggiungiFattura(fattura);
        new JDialogFattura(null, true, fattura).setVisible(true);
    }

    private void aggiungiFattura(Fattura input) {

        String query = null;
            query = "INSERT INTO Fattura VALUES(null,'%s','%d','%s','%s','%s','%d')";
            query = String.format(query, input.getCausale(), 
                    input.getImporto(), input.getData(), input.getDataInizio(),
                    input.getCf(),input.getStanza());
                    
        new GestioneDB().updateDB(query);
        
        try {
            Home.fatture.caricaFatture();
        } catch (SQLException ex) {
            Logger.getLogger(GestioneFattura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Vector leggiFatture() throws SQLException {

        String query = "SELECT ID,Data,Importo,Causale FROM Fattura";
        ResultSet result = new GestioneDB().readDB(query);
        Vector toReturn = new Vector();
        Vector causali = new Vector();
        Vector visualizza = new Vector();

        while (result.next()) {

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

    private int calcolaImporto(Permanenza input) throws ParseException, SQLException {

        // CALCOLO GIORNI DI PERMANENZA
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataInizio = input.getDataInizio();
        String dataFine = format.format(new GregorianCalendar().getTime());
        long millisDiff = format.parse(dataFine).getTime() - format.parse(dataInizio).getTime();
        int giorni = (int) (millisDiff / 86400000);

        // CALCOLO IMPORTO
        String query = "SELECT CostoGiornaliero FROM Stanza WHERE Numero=%d";
        query = String.format(query, input.getNumeroStanza());
        ResultSet result = new GestioneDB().readDB(query);
        int costo = 0;
        while (result.next()) {
            costo = result.getInt("CostoGiornaliero");
        }
        
        if (giorni == 0) {
            return costo;
        } else {
            return (giorni + 1) * costo;
        }
    }
}
