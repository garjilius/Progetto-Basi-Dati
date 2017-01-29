
package GestioneEntita;

import Entity.AnagDipe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class GestioneAnagDip {
           public static ArrayList CFs = new ArrayList();

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
            toReturn.setDataDiNascita(result.getString("DataNascita"));
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
        
        String query = "INSERT INTO Dipendente VALUES ('%s','%s','%s','%d')";
        query = String.format(query, input.getCodiceFiscale(),
                input.getStipendio(), input.getDataAssunzione(),
                input.getMansione());
        
        new GestioneDB().updateDB(query);
        System.out.println(query);
    }
    
    public boolean aggiornaStipendio(int index, int stipendio) {
        
        String cf = (String) CFs.get(index);
        String query = "UPDATE Dipendente SET Stipendio=%d WHERE CodiceFiscale='%s'";
        query = String.format(query, stipendio, cf);
        new GestioneDB().updateDB(query);
        System.out.println(query);
        return true;
    }
    
    public static Vector leggiOspiti() throws SQLException {
        
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
            ospiti.add(riga);
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
    
    public static int getAvgStipendio() throws SQLException {
        String query = "SELECT AVG(Stipendio) FROM Dipendente";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            return result.getInt(1);
        }
        return 0;
    }
    
    public static Vector letturaCompletaDipendenti() throws SQLException {
         Vector dipendenti = new Vector();
        String query = "SELECT * FROM Anagrafica JOIN Dipendente ON Anagrafica.CodiceFiscale = Dipendente.CodiceFiscale";
        ResultSet result = new GestioneDB().readDB(query);
        CFs = new ArrayList();
        while(result.next()) {
            String nome = result.getString("Nome");
            String cognome = result.getString("Cognome");
            String CF = result.getString("CodiceFiscale");
            float stipendio = result.getFloat("Stipendio");
            String dataAssunsione = result.getString("DataAssunzione");
            String mansione = result.getString("Mansione");
            Vector riga = new Vector();
            riga.add(nome);
            riga.add(cognome);
            riga.add(CF);
            riga.add(stipendio);
            riga.add(dataAssunsione);
            riga.add(mansione);
            dipendenti.add(riga);
            CFs.add(result.getString("CodiceFiscale"));
        }
        return dipendenti;
    } 
}
