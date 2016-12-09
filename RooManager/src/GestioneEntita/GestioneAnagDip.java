
package GestioneEntita;

import Entity.AnagDipe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


public class GestioneAnagDip {
           public ArrayList CFs = new ArrayList();

    
<<<<<<< Updated upstream
=======
    public ArrayList getCFs() {
        return this.CFs;
    }      
           
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
    

>>>>>>> Stashed changes
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
    
    public Vector leggiOspiti() throws SQLException {
        
        Vector ospiti = new Vector();
        String query = "SELECT * FROM Anagrafica WHERE Tipo = 1";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            Vector riga = new Vector();
            riga.add(result.getString("Nome"));
            riga.add(result.getString("Cognome"));
            riga.add(result.getString("CodiceFiscale"));
            riga.add(result.getString("DataDiNascita"));
            riga.add(result.getString("NumeroDocumento"));
        }
        return ospiti;
    }
    
    public Vector leggiDipendenti() throws SQLException {
        
        Vector dipendenti = new Vector();
        String query = "SELECT NOME, COGNOME, Anagrafica.CodiceFiscale FROM Anagrafica JOIN Dipendente ON Anagrafica.CodiceFiscale = Dipendente.CodiceFiscale";
        ResultSet result = new GestioneDB().readDB(query);
        CFs = new ArrayList();
        while(result.next()) {
            String nome = result.getString("Nome");
            String cognome = result.getString("Cognome");
            String nomecognome = nome + " " + cognome;
            dipendenti.add(nomecognome);
            CFs.add(result.getString("CodiceFiscale"));
        }
        return dipendenti;
    }
<<<<<<< Updated upstream
    
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
=======
               
>>>>>>> Stashed changes
    
}
