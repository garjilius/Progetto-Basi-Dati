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
        fattura.setID(ultimoID());
        fattura.setData(input.getDataFine());
        fattura.setCf(input.getCodiceFiscale());
        fattura.setPiva(null);
        fattura.setStanza(input.getNumeroStanza());
        fattura.setImporto(calcolaImporto(input));

        System.out.println(calcolaImporto(input));

        String causale = "Permanenza di " + fattura.getCf() + "\n"
                + "dal giorno " + input.getDataInizio() + "\n"
                + "al giorno " + input.getDataFine() + "\n"
                + "nella stanza " + input.getNumeroStanza();
        fattura.setCausale(causale);

        aggiungiFattura(fattura);
        new JDialogFattura(null, true, fattura).setVisible(true);
    }

    public void aggiungiFatturaDitta(String dataInizio, String dataFine, String piva, int stanza, int importo) throws ParseException, SQLException {

        Fattura fattura = new Fattura();
        fattura.setID(ultimoID());
        fattura.setData(dataFine);
        fattura.setCf(null);
        fattura.setPiva(piva);
        fattura.setStanza(stanza);
        fattura.setImporto(importo);

        String causale = "Intervento di " + fattura.getPiva() + "\n"
                + "dal giorno " + dataInizio + "\n "
                + "al giorno " + fattura.getData() + "\n"
                + "nella stanza " + fattura.getStanza();
        fattura.setCausale(causale);

        aggiungiFattura(fattura);
        new JDialogFattura(null, true, fattura).setVisible(true);
    }

    private void aggiungiFattura(Fattura input) {

        String query = null;
        if (input.getCf() == null) {
            query = "INSERT INTO Fattura VALUES(null,'%s','%d','%s','%s',NULL,'%d')";
            query = String.format(query, input.getCausale(), 
                    input.getImporto(), input.getData(), 
                    input.getPiva(),input.getStanza());
        } else if (input.getPiva() == null) {
            query = "INSERT INTO Fattura VALUES(null,'%s','%d','%s',NULL,'%s','%d')";
            query = String.format(query, input.getCausale(), 
                    input.getImporto(), input.getData(), 
                    input.getCf(),input.getStanza());
        }        
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
    
        private int ultimoID() throws SQLException {

        String query = "SELECT max(ID) FROM Fattura";
        ResultSet result = new GestioneDB().readDB(query);
        while (result.next()) {
            return result.getInt(1) + 1;
        }
        return 0;
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
