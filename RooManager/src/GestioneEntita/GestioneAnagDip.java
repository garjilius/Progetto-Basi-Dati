
package GestioneEntita;

import Entity.AnagDipe;
import Entity.Permanenza;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GestioneAnagDip {
    
    public AnagDipe verificaCf(String cf) throws SQLException {
        
        String query = "SELECT * FROM Anagrafica WHERE CodiceFiscale = '" + cf + "'";
        ResultSet result = new GestioneDB().readDB(query);
        
        AnagDipe toReturn = new AnagDipe();
        while(result.next()) {
            toReturn.setCodiceFiscale(result.getString("CodiceFiscale"));
            toReturn.setNome(result.getString("Nome"));
            toReturn.setCognome(result.getString("Cognome"));
            toReturn.setDataDiNascita(result.getString("DataDiNascita"));
            toReturn.setNumeroDocumento(result.getString("NumeroDocumento"));
            return toReturn;
        }
        return null;
    }
    
    public void aggiungiAnagrafica(AnagDipe input) {
        
        String query = "INSERT INTO Anagrafica VALUES ('%s','%s','%s','%s','%s','%d')";
        query = String.format(query, input.getCodiceFiscale(), input.getNome(),
                input.getCognome(), input.getDataDiNascita(),
                input.getNumeroDocumento(), input.getTipo());
        
        new GestioneDB().updateDB(query);
    }
    
    public void aggiungiDipendente(AnagDipe input) {
        
        String query = "INSERT INTO Anagrafica VALUES ('%s','%s','%s','%d')";
        query = String.format(query, input.getCodiceFiscale(),
                input.getStipendio(), input.getDataAssunzione(),
                input.getMansione());
        
        new GestioneDB().updateDB(query);
    }
}
